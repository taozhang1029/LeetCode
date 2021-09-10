package com.kingsley.leetcode.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @Time 2021/9/7 12:19
 * @Author Kingsley
 * @Project LeetCode
 * @Description
 */
@Slf4j
public abstract class SolutionType {

    protected String type;

    protected void showSolutionType() {
        log.info("当前题型：" + type);
    }

}
