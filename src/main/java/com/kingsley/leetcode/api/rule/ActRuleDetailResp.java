package com.kingsley.leetcode.api.rule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActRuleDetailResp implements Serializable {
    /**
     * 规则id
     */
    private Long ruleId;
    /**
     * 父节点id
     */
    private Long parentId;
    /**
     * 节点类型 1-逻辑 2-比较
     */
    private Integer type;
    /**
     * 操作符号 > = < !=
     */
    private String operator;
    /**
     * 左侧
     */
    private String field;
    /**
     * 右侧
     */
    private String quota;
    /**
     * 不满足规则的描述文案
     */
    private String text;
    /**
     * 创建人
     */
    private String creator;

    /**
     * 子节点 多节点 避免同一节点下出现多于2个以上的子节点
     */
    private List<ActRuleDetailResp> childItem = new ArrayList<>();

    /**
     * 添加
     *
     * @param node
     */
    public void add(ActRuleDetailResp node) {
        childItem.add(node);
    }
}
