package com.kingsley.leetcode.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kingsley.leetcode.api.Solution;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.rmi.AccessException;
import java.util.Arrays;
import java.util.HashMap;
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
                List<Method> methods = Arrays.stream(solution.getClass().getDeclaredMethods()).filter(m -> {
                    m.setAccessible(true);
                    return m.isAnnotationPresent(SolutionEntry.class);
                }).collect(Collectors.toList());
                if (methods.isEmpty()) {
                    throw new AccessException("没有找到入口方法，请在入口方法添加 @SolutionEntry 注解！");
                } else if (methods.size() > 1) {
                    throw new AccessException("存在多个入口方法，请检查！");
                }
                entry = methods.get(0);
                int parameterCount = entry.getParameterCount();
                if (parameterCount != args.length) {
                    throw new IllegalArgumentException("入口方法实际参数列表和形式参数列表长度不同！");
                }
            }

            log.info("执行方法：{}", entry.getName());
            Parameter[] parameters = entry.getParameters();
            HashMap<String, Object> map = new HashMap<>();
            for (int i = 0; i < parameters.length; i++) {
                if (args[i].getClass().isArray()) {
                    map.put(parameters[i].getName(), Arrays.deepToString((Object[]) args[i]));
                } else {
                    boolean isNum = true;
                    try {
                        new BigDecimal(args[i].toString());
                    } catch (NumberFormatException e) {
                        // 不是数字
                        isNum = false;
                    }
                    map.put(parameters[i].getName(), isNum ? args[i] : args[i].toString());
                }
            }
            log.info("方法入参：{}", JSON.toJSONString(map, SerializerFeature.MapSortField).replace("\"[", "[").replaceAll("]\"", "]"));

            SolutionEntry annotation = entry.getAnnotation(SolutionEntry.class);
            long start = System.currentTimeMillis();
            try {
                result = entry.invoke(solution, args);
                long end = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("返回结果：");
                if (result == null) {
                    sb.append("null");
                } else {
                    sb.append(trans2String(result, annotation.useJsonResult()));
                }
                log.info(sb.toString());
                if (annotation.countTime()) {
                    log.info("运行耗时：{}ms", end - start);
                }
            } catch (Exception e) {
                log.error("方法调用异常: ");
                e.printStackTrace();
            }

            return result;
        });

        return proxyInstance.solute(args);
    }

    private static String trans2String(Object obj, boolean useJson) {
        if (useJson || obj.getClass().isArray()) {
            return JSON.toJSONString(obj);
        }
        return obj.toString();
    }

}
