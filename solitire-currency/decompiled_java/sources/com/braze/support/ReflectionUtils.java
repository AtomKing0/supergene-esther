package com.braze.support;

import bo.app.l70;
import bo.app.m70;
import bo.app.n70;
import bo.app.o70;
import bo.app.p70;
import bo.app.q70;
import bo.app.r70;
import com.braze.support.BrazeLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import v8.s;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectionUtils {
    public static final ReflectionUtils INSTANCE = new ReflectionUtils();

    private ReflectionUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object constructObjectQuietly$default(ReflectionUtils reflectionUtils, String str, List list, List list2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = v.l();
        }
        if ((i10 & 4) != 0) {
            list2 = v.l();
        }
        return reflectionUtils.constructObjectQuietly(str, list, list2);
    }

    public static final boolean doesMethodExist(String className, String methodName, Class<?>... parameterTypes) {
        t.i(className, "className");
        t.i(methodName, "methodName");
        t.i(parameterTypes, "parameterTypes");
        return getMethodQuietly(className, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length)) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [T, java.lang.Class] */
    private final Method getDeclaredMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        n0 n0Var = new n0();
        n0Var.f29834a = cls;
        while (true) {
            T t10 = n0Var.f29834a;
            if (t10 == 0) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, false, (h9.a) new n70(str), 6, (Object) null);
                return null;
            }
            try {
                return ((Class) t10).getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, false, (h9.a) new m70(str, n0Var), 6, (Object) null);
                n0Var.f29834a = ((Class) n0Var.f29834a).getSuperclass();
            }
        }
    }

    public static final Method getMethodQuietly(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        t.i(clazz, "clazz");
        t.i(methodName, "methodName");
        t.i(parameterTypes, "parameterTypes");
        try {
            return clazz.getMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.D, (Throwable) e10, false, (h9.a) p70.f3607a, 4, (Object) null);
            return null;
        }
    }

    public static final s<Boolean, Object> invokeMethodQuietly(Object obj, Method method, Object... args) {
        t.i(method, "method");
        t.i(args, "args");
        try {
            return new s<>(Boolean.TRUE, method.invoke(obj, Arrays.copyOf(args, args.length)));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.D, (Throwable) e10, false, (h9.a) r70.f3748a, 4, (Object) null);
            return new s<>(Boolean.FALSE, null);
        }
    }

    public final Object constructObjectQuietly(String classpath, List<? extends Class<?>> parameterTypes, List<? extends Object> args) {
        t.i(classpath, "classpath");
        t.i(parameterTypes, "parameterTypes");
        t.i(args, "args");
        try {
            Class<?> cls = Class.forName(classpath);
            Class[] clsArr = (Class[]) parameterTypes.toArray(new Class[0]);
            Constructor<?> constructor = cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            Object[] array = args.toArray(new Object[0]);
            return constructor.newInstance(Arrays.copyOf(array, array.length));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) l70.f3311a, 4, (Object) null);
            return null;
        }
    }

    public static final Method getMethodQuietly(String className, String methodName, Class<?>... parameterTypes) {
        t.i(className, "className");
        t.i(methodName, "methodName");
        t.i(parameterTypes, "parameterTypes");
        try {
            Class<?> clazz = Class.forName(className);
            t.h(clazz, "clazz");
            return getMethodQuietly(clazz, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.D, (Throwable) e10, false, (h9.a) q70.f3687a, 4, (Object) null);
            return null;
        }
    }

    public final Method getDeclaredMethodQuietly(String className, String methodName, Class<?>... parameterTypes) {
        t.i(className, "className");
        t.i(methodName, "methodName");
        t.i(parameterTypes, "parameterTypes");
        try {
            Class<?> clazz = Class.forName(className);
            t.h(clazz, "clazz");
            return getDeclaredMethodQuietly(clazz, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) e10, false, (h9.a) o70.f3546a, 4, (Object) null);
            return null;
        }
    }
}
