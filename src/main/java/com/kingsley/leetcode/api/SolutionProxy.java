package com.kingsley.leetcode.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 代理类
 * Created by zhangtao1029 on 2021/7/15.
 */
@Slf4j
public class SolutionProxy {

    private static int cnt = 0;
    private static Solution sol;
    private static Object[] args;

    public static Object invoke(Solution solution, Object... params) {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("logContext.xml");
        sol = solution;
        args = params;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Solution.class);
        enhancer.setCallback(new SolutionInvocationHandler(solution));
        Solution proxy = (Solution) enhancer.create();

        return proxy.solute(args);
    }

    private static String trans2String(Object obj, boolean useJson) {
        if (useJson || obj.getClass().isArray()) {
            return JSON.toJSONString(obj);
        }
        return obj.toString();
    }

    private static class SolutionInvocationHandler implements InvocationHandler {

        private Solution solution;

        public SolutionInvocationHandler(Solution solution) {
            this.solution = solution;
        }

        @Override
        public Object invoke(Object obj, Method method, Object[] params) {
            Object result = null;
            List<Method> methods = Arrays.stream(sol.getClass().getDeclaredMethods()).filter(m -> {
                m.setAccessible(true);
                return m.isAnnotationPresent(SolutionEntry.class);
            }).collect(Collectors.toList());

            if (methods.isEmpty()) {
                log.error("没有找到入口方法，请在入口方法添加 @SolutionEntry 注解！");
                return null;
            }

            if (methods.size() > 1) {
                methods.sort(Comparator.comparingInt(m -> m.getAnnotation(SolutionEntry.class).priority()));
            }

            Method entry = methods.get(0);
            int parameterCount = entry.getParameterCount();
            if (parameterCount != args.length) {
                log.error("入口方法实际参数列表和形式参数列表长度不一致！");
                return null;
            }

            SolutionEntry entryAnnotation = AnnotationUtils.getAnnotation(entry, SolutionEntry.class);
            if (entryAnnotation == null) {
                return null;
            }

            boolean onlyResult = entryAnnotation.onlyResult();

            SolutionInfo solutionInfo = solution.getClass().getAnnotation(SolutionInfo.class);

            String solutionName = (String) AnnotationUtils.getValue(solutionInfo, "value");
            if (solutionName == null) {
                solutionName = (String) AnnotationUtils.getValue(solutionInfo, "solutionName");
            }
            String requirements = solutionInfo.requirements();
            if (cnt == 0) {
                log.info("题目名称：{}", "".equals(solutionName) ? "未知" : solutionName);
            }

            if (cnt == 0) {
                Set<Class<?>> classes = Arrays.stream(sol.getClass().getInterfaces()).collect(Collectors.toSet());
                String type = "未知";
                if (!classes.isEmpty()) {
                    StringBuilder types = new StringBuilder();
                    boolean isFirst = true;
                    for (Class<?> clazz : classes) {
                        try {
                            if (!isFirst) {
                                types.append("、");
                            }
                            isFirst = false;
                            types.append((String) clazz.getDeclaredField("type").get(sol));
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    type = types.toString();
                }
                log.info("题目类型：{}", type);

                if (!StringUtils.isEmpty(requirements)) {
                    log.info("附加要求：{}", requirements);
                }

                if (methods.size() > 1) {
                    log.info("存在多个入口方法，按优先级选取");
                }

                if (!onlyResult) {
                    log.info("执行方法：{}#{}", sol.getClass().getName(), entry.getName());
                }
            }

            if (!onlyResult) {
                log.info("********************* 测试" + (cnt + 1) + " ********************");
            }

            Parameter[] parameters = entry.getParameters();
            HashMap<String, Object> map = new HashMap<>();
            boolean existArray = false;
            for (int i = 0; i < parameters.length; i++) {
                if (args[i].getClass().isArray()) {
                    map.put(parameters[i].getName(), Arrays.deepToString(new Object[]{args[i]}));
                    existArray = true;
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

            String argsInfo = JSON.toJSONString(map, SerializerFeature.MapSortField);
            if (existArray) {
                argsInfo = argsInfo.replace("\"[", "").replaceAll("]\"", "");
            }
            if (!onlyResult) {
                log.info("方法入参：{}", argsInfo);
            }
            long start = System.currentTimeMillis();
            try {
                result = entry.invoke(sol, args);
                long end = System.currentTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("返回结果：");
                if (result == null) {
                    sb.append("null");
                } else {
                    sb.append(trans2String(result, entryAnnotation.useJsonResult()));
                }
                log.info(sb.toString());
                if (!onlyResult && entryAnnotation.countTime()) {
                    log.info("运行耗时：{}ms", end - start);
                }
            } catch (Exception e) {
                log.error("方法调用异常: ", e);
            }
            cnt++;
            return result;
        }
    }

}
