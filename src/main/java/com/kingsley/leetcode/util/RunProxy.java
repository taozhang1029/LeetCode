package com.kingsley.leetcode.util;

import com.kingsley.leetcode.api.Solution;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.AccessException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 运行工具类
 * Created by zhangtao1029 on 2021/7/15.
 */
@Slf4j
public class RunProxy {

    public static Object invoke(Solution solution, Object... args) {
        Solution proxyInstance = (Solution) Proxy.newProxyInstance(solution.getClass().getClassLoader(), solution.getClass().getInterfaces(), (proxy, method, params) -> {
            Object result = null;
            String methodName = method.getName();
            Method entry = method;
            if ("solute".equals(methodName)) {
                List<Method> methods = Arrays.stream(solution.getClass().getMethods()).filter(method1 -> method1.isAnnotationPresent(SolutionEntry.class)).collect(Collectors.toList());
                if (methods.isEmpty()) {
                    throw new AccessException("没有找到解决方案的入口方法，请在入口方法添加@SolutionEntry注解！");
                } else if (methods.size() > 1) {
                    throw new AccessException("解决方案存在多个入口方法，请检查！");
                }
                entry = methods.get(0);
                int parameterCount = entry.getParameterCount();
                if (parameterCount != args.length) {
                    throw new IllegalArgumentException("输入参数与解决方案入口方法所需参数数量不一致！");
                }
            }

            log.info("方法名：" + entry.getName());
            log.info("入参：" + Arrays.deepToString(args));

            try {
                result = entry.invoke(solution, args);
                StringBuilder sb = new StringBuilder();
                sb.append("程序运行结果：");
                if (result == null) {
                    sb.append("void");
                } else if (result.getClass().isArray()) {
                    String s = Arrays.deepToString(new Object[]{result});
                    sb.append(s, 1, s.length() - 1);
                } else {
                    sb.append(result);
                }
                log.info(sb.toString());
            } catch (Exception e) {
                log.error("方法调用异常！");
                log.error(e.getMessage());
            }

            return result;
        });

        return proxyInstance.solute(args);
    }

}
