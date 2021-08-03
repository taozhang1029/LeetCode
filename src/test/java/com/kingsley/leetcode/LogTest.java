package com.kingsley.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/3 9:36
 * @description
 */
@Slf4j
public class LogTest {

    @Test
    public void logTest() {
        log.info("log test");
        log.warn("log test");
        log.error("log test");
    }
}
