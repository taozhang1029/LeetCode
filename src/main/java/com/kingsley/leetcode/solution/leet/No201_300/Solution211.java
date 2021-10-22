package com.kingsley.leetcode.solution.leet.No201_300;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Time 2021/10/19 22:48
 * @Author Kingsley
 * @Project LeetCode
 * @Description
 */
public class Solution211 extends Solution {

    @Test
    @Override
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        checkResult(false, wordDictionary, "a");
        checkResult(false, wordDictionary, ".at");
        wordDictionary.addWord("bat");
        checkResult(true, wordDictionary, ".at");
        checkResult(true, wordDictionary, "an.");
        checkResult(false, wordDictionary, "a.d.");
        checkResult(false, wordDictionary, "b.");
        checkResult(true, wordDictionary, "a.d");
        checkResult(false, wordDictionary, ".");
    }

    @SolutionEntry
    private boolean search(WordDictionary dictionary, String target) {
        return dictionary.search(target);
    }
}

class WordDictionary {

    DictTree[] dictTrees;

    public WordDictionary() {
        this.dictTrees = new DictTree[26];
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        int idx = chars[0] - 'a';
        if (dictTrees[idx] == null) {
            dictTrees[idx] = new DictTree(chars[0]);
            if (chars.length == 1) {
                dictTrees[idx].setIsEnd(true);
            }
        }
        DictTree curr = dictTrees[idx];
        for (int i = 1; i < chars.length; i++) {
            int currIdx = chars[i] - 'a';
            if (curr.getChild(currIdx) == null) {
                curr.setChildren(currIdx, chars[i]);
            }
            curr = curr.getChild(currIdx);
            if (i == chars.length -1) {
                curr.setIsEnd(true);
            }
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        if (chars[0] == '.') {
            for (DictTree dictTree : dictTrees) {
                if (isExist(word, dictTree)) {
                    return true;
                }
            }
            return false;
        }
        return isExist(word, dictTrees[chars[0] - 'a']);
    }

    private boolean isExist(String s, DictTree tree) {
        if ("".equals(s)) {
            return true;
        }
        if (tree == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        String next = s.substring(1);
        if (chars[0] != '.') {
            if (tree.getC() != chars[0]) {
                return false;
            }
            if (chars.length == 1) {
                return tree.isEnd();
            }
            if (chars[1] != '.') {
                return isExist(next, tree.getChild(chars[1] - 'a'));
            }
            for (DictTree child : tree.getChildren()) {
                if (isExist(next, child)) {
                    return true;
                }
            }
        } else {
            if ("".equals(next)) {
                return tree.isEnd();
            }
            for (DictTree child : tree.getChildren()) {
                if (child == null) {
                    continue;
                }
                if (isExist(next, child)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class DictTree {

    private char c;
    private DictTree[] children;
    private boolean isEnd;

    public DictTree(char c) {
        this.c = c;
        this.children = new DictTree[26];
    }

    public DictTree getChild(int idx) {
        return children[idx];
    }

    public void setChildren(int idx, char c) {
        children[idx] = new DictTree(c);
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public char getC() {
        return c;
    }

    public DictTree[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

}