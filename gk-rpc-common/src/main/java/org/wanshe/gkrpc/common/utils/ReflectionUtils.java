package org.wanshe.gkrpc.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 *
 * @author wanshe
 */
public class ReflectionUtils {
    /**
     * 根据Class创建对象
     *
     * @param clazz 待创建对象类
     * @param <T> 对象类型
     * @return 创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取某个class的公共方法
     *
     * @param clazz 对象类
     * @return class的公共方法
     */
    public static Method[] getPublicMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pMethods = new ArrayList<>();
        for (Method m :methods) {
            if (Modifier.isPublic(m.getModifiers())) {
                pMethods.add(m);
            }
        }
        return pMethods.toArray(new Method[0]);
    }

    /**
     * 调用指定对象的指定方法
     * @param obj 调用对象
     * @param method 调用方法
     * @param args 方法参数
     * @return 返回结果
     */
    public static Object invoke(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}
