package com.baseapp.common.utils;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/1/24 0024.
 * 反射器
 * 用于解决InputMethodManager内存泄漏，具体使用查看基类
 */

public class Reflector {

    public static final class TypedObject
    {
        private final Object object;
        private final Class type;

        public TypedObject(final Object object, final Class type)
        {
            this.object = object;
            this.type = type;
        }

        Object getObject()
        {
            return object;
        }

        Class getType()
        {
            return type;
        }
    }

    public static void invokeMethodExceptionSafe(final Object methodOwner, final String method, final TypedObject... arguments)
    {
        if (null == methodOwner)
        {
            return;
        }

        try
        {
            final Class<?>[] types = null == arguments ? new Class[0] : new Class[arguments.length];
            final Object[] objects = null == arguments ? new Object[0] : new Object[arguments.length];

            if (null != arguments)
            {
                for (int i = 0, limit = types.length; i < limit; i++)
                {
                    types[i] = arguments[i].getType();
                    objects[i] = arguments[i].getObject();
                }
            }

            final Method declaredMethod = methodOwner.getClass().getDeclaredMethod(method, types);

            declaredMethod.setAccessible(true);
            declaredMethod.invoke(methodOwner, objects);
        }
        catch (final Throwable ignored)
        {
            ignored.printStackTrace();
        }
    }
}
