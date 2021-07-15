package com.kingsley.leetcode.util;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 运行工具类
 * Created by zhangtao552 on 2021/7/15.
 */
public class RunProxy {

    public static Object run(Solution solution, Object... args) {
        Solution proxyInstance = (Solution) Proxy.newProxyInstance(solution.getClass().getClassLoader(), solution.getClass().getInterfaces(), (proxy, method, params) -> {
            Object result;
            String methodName = method.getName();
            if ("solute".equals(methodName)) {
                List<Method> methods = Arrays.stream(solution.getClass().getMethods()).filter(method1 -> method1.isAnnotationPresent(SolutionEntry.class)).collect(Collectors.toList());
                if (methods.isEmpty()) {
                    throw new RuntimeException("没有找到解决方案的入口方法，请在入口方法添加@SolutionEntry注解");
                }
                Method entry = methods.get(0);
                int parameterCount = entry.getParameterCount();
                if (parameterCount != args.length) {
                    throw new IllegalArgumentException("输入参数与解决方案入口方法所需参数数量不一致！");
                }
                boolean existArray = Arrays.stream(args).anyMatch(arg -> arg.getClass().isArray());
                System.out.println("执行 " + entry.getName() + " 方法" + (existArray ? "" : args));
                result = entry.invoke(solution, args);
                System.out.println("执行结果：" + result);
            } else {
                result = method.invoke(solution, args);
            }
            return result;
        });

        return proxyInstance.solute(args);
    }

}
