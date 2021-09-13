package com.kingsley.leetcode.api;

import java.util.Random;

/**
 * @Time 2021/9/5 11:31
 * @Author Kingsley
 * @Project LeetCode
 * @Description
 */
public abstract class SolBase {

    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

}
