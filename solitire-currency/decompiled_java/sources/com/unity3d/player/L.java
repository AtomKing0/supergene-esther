package com.unity3d.player;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
final class L implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f23953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private UnityPlayer f23954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f23955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f23956d;

    L(UnityPlayer unityPlayer, long j10) {
        this.f23956d = j10;
        long j11 = ReflectionHelper.f23998b;
        this.f23953a = new O(j11, j10);
        this.f23954b = unityPlayer;
        this.f23955c = j11;
    }

    private static Object a(Object obj, Method method, Object[] objArr, N n10) {
        if (objArr == null) {
            try {
                try {
                    objArr = new Object[0];
                } catch (NoClassDefFoundError unused) {
                    AbstractC3275z.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
                    ReflectionHelper.nativeProxyLogJNIInvokeException(n10.f23967a);
                    n10.f23967a = 0L;
                    return null;
                }
            } finally {
                long j10 = n10.f23967a;
                if (j10 != 0) {
                    ReflectionHelper.nativeProxyJNIFreeGCHandle(j10);
                }
            }
        }
        Class<?> declaringClass = method.getDeclaringClass();
        Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
        declaredConstructor.setAccessible(true);
        return ((MethodHandles.Lookup) declaredConstructor.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
    }

    protected void finalize() throws Throwable {
        this.f23954b.queueGLThreadEvent(this.f23953a);
        super.finalize();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (!ReflectionHelper.beginProxyCall(this.f23955c)) {
            AbstractC3275z.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
            return null;
        }
        try {
            Object objNativeProxyInvoke = ReflectionHelper.nativeProxyInvoke(this.f23956d, method.getName(), objArr);
            if (!(objNativeProxyInvoke instanceof N)) {
                return objNativeProxyInvoke;
            }
            N n10 = (N) objNativeProxyInvoke;
            if (n10.f23968b && (method.getModifiers() & 1024) == 0) {
                return a(obj, method, objArr, n10);
            }
            ReflectionHelper.nativeProxyLogJNIInvokeException(n10.f23967a);
            return null;
        } finally {
            ReflectionHelper.endProxyCall();
        }
    }
}
