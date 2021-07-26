package com.kingsley.leetcode.api.rule;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RuleTest implements Solution {

    @Test
    @Override
    public void test() {
        ActRuleDetailResp rule = new ActRuleDetailResp();
        rule.setRuleId(1L);
        rule.setParentId(null);
        rule.setType(1);
        rule.setOperator("and");
        rule.setField("rule2");
        rule.setQuota("rule3");
        rule.setText("父规则");
        rule.setCreator("7f_admin");

        ActRuleDetailResp rule2 = new ActRuleDetailResp();
        rule2.setRuleId(2L);
        rule2.setParentId(1L);
        rule2.setType(2);
        rule2.setOperator(">");
        rule2.setField("amount");
        rule2.setQuota("100");
        rule2.setText("价格要求");
        rule2.setCreator("7f_admin");
        rule.add(rule2);

        ActRuleDetailResp rule3 = new ActRuleDetailResp();
        rule3.setRuleId(3L);
        rule3.setParentId(1L);
        rule3.setType(2);
        rule3.setOperator(">");
        rule3.setField("evaluation");
        rule3.setQuota("50");
        rule3.setText("评价要求");
        rule3.setCreator("7f_admin");
        rule.add(rule3);

        solute(rule);

    }

    @SolutionEntry(useJsonResult = true)
    public RuleItem copyRule(ActRuleDetailResp src) {
        return recursion(src);
    }

    public RuleItem recursion(ActRuleDetailResp src) {
        RuleItem target = new RuleItem();
        target.setType(src.getType());
        target.setField(src.getField());
        target.setOperator(src.getOperator());
        target.setQuota(src.getQuota());
        List<ActRuleDetailResp> childItems = src.getChildItem();
        if (!childItems.isEmpty()) {
            List<RuleItem> ruleItems = new ArrayList<>();
            for (ActRuleDetailResp item : childItems) {
                ruleItems.add(recursion(item));
            }
            target.setChildItem(ruleItems);
        }

        return target;
    }
}
