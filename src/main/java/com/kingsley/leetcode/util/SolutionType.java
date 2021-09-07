package com.kingsley.leetcode.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Time 2021/9/7 12:19
 * @Author Kingsley
 * @Project LeetCode
 * @Description
 */
@Data
@Slf4j
public abstract class SolutionType {

    protected String solutionType;

    public void showSolutionType() {
        log.info("当前题型：" + solutionType);
    }
}
