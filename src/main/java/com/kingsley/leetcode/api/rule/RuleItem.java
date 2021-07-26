package com.kingsley.leetcode.api.rule;

import lombok.Data;

import java.util.List;

@Data
public class RuleItem {
    /**
     * 节点类型	1逻辑 2比较
     */
    private Integer type;

    /**
     * 比较符	逻辑符 or 操作符
     */
    private String operator;

    /**
     * 属性名(左)	比较运算必填
     */
    private String field;

    /**
     * 指标值(右)	比较运算 必填
     */
    private String quota;

    /**
     * 子规则
     */
    private List<RuleItem> childItem;
}
