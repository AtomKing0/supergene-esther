package com.unity3d.player;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class ReflectionHelper {
    protected static boolean LOG = false;
    protected static final boolean LOGV = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static M[] f23997a = new M[4096];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f23998b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f23999c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f24000d = false;

    protected static synchronized boolean beginProxyCall(long j10) {
        if (j10 != f23998b) {
            return false;
        }
        f23999c++;
        return true;
    }

    protected static Object createInvocationError(long j10, boolean z10) {
        return new N(j10, z10);
    }

    protected static synchronized void endProxyCall() {
        long j10 = f23999c - 1;
        f23999c = j10;
        if (0 == j10 && f24000d) {
            ReflectionHelper.class.notifyAll();
        }
    }

    protected static synchronized void endUnityLaunch() {
        try {
            f23998b++;
            f24000d = true;
            while (f23999c > 0) {
                ReflectionHelper.class.wait();
            }
        } catch (InterruptedException unused) {
            AbstractC3275z.Log(6, "Interrupted while waiting for all proxies to exit.");
        }
        f24000d = false;
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        Constructor<?> constructor;
        M m10 = new M(cls, "", str);
        if (a(m10)) {
            constructor = (Constructor) m10.f23965e;
        } else {
            Class[] clsArrA = a(str);
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            Constructor<?> constructor2 = null;
            float f10 = 0.0f;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                Constructor<?> constructor3 = constructors[i10];
                float fA = a(Void.TYPE, constructor3.getParameterTypes(), clsArrA);
                if (fA > f10) {
                    if (fA == 1.0f) {
                        constructor2 = constructor3;
                        break;
                    }
                    constructor2 = constructor3;
                    f10 = fA;
                }
                i10++;
            }
            synchronized (ReflectionHelper.class) {
                m10.f23965e = constructor2;
                f23997a[m10.f23964d & 4095] = m10;
            }
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z10) {
        Field field;
        Class superclass = cls;
        M m10 = new M(superclass, str, str2);
        if (a(m10)) {
            field = (Field) m10.f23965e;
        } else {
            Class[] clsArrA = a(str2);
            float f10 = 0.0f;
            Field field2 = null;
            while (superclass != null) {
                Field[] declaredFields = superclass.getDeclaredFields();
                int length = declaredFields.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    Field field3 = declaredFields[i10];
                    if (z10 == Modifier.isStatic(field3.getModifiers()) && field3.getName().compareTo(str) == 0) {
                        float fA = a(field3.getType(), null, clsArrA);
                        if (fA > f10) {
                            field2 = field3;
                            if (fA == 1.0f) {
                                f10 = fA;
                                break;
                            }
                            f10 = fA;
                        } else {
                            continue;
                        }
                    }
                    i10++;
                }
                if (f10 == 1.0f || superclass.isPrimitive() || superclass.isInterface() || superclass.equals(Object.class) || superclass.equals(Void.TYPE)) {
                    break;
                }
                superclass = superclass.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                m10.f23965e = field2;
                f23997a[m10.f23964d & 4095] = m10;
            }
            field = field2;
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z10 ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = superclass.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    protected static String getFieldSignature(Field field) {
        Class<?> type = field.getType();
        if (type.isPrimitive()) {
            String name = type.getName();
            return TypedValues.Custom.S_BOOLEAN.equals(name) ? "Z" : "byte".equals(name) ? "B" : "char".equals(name) ? "C" : "double".equals(name) ? "D" : TypedValues.Custom.S_FLOAT.equals(name) ? "F" : "int".equals(name) ? "I" : "long".equals(name) ? "J" : "short".equals(name) ? ExifInterface.LATITUDE_SOUTH : name;
        }
        if (type.isArray()) {
            return type.getName().replace('.', '/');
        }
        return "L" + type.getName().replace('.', '/') + ";";
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z10) {
        Method method;
        M m10 = new M(cls, str, str2);
        if (a(m10)) {
            method = (Method) m10.f23965e;
        } else {
            Class[] clsArrA = a(str2);
            Method method2 = null;
            float f10 = 0.0f;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    Method method3 = declaredMethods[i10];
                    if (z10 == Modifier.isStatic(method3.getModifiers()) && method3.getName().compareTo(str) == 0) {
                        float fA = a(method3.getReturnType(), method3.getParameterTypes(), clsArrA);
                        if (fA <= f10) {
                            continue;
                        } else {
                            if (fA == 1.0f) {
                                method2 = method3;
                                f10 = fA;
                                break;
                            }
                            method2 = method3;
                            f10 = fA;
                        }
                    }
                    i10++;
                }
                if (f10 == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                m10.f23965e = method2;
                f23997a[m10.f23964d & 4095] = m10;
            }
            method = method2;
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z10 ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Object nativeProxyInvoke(long j10, String str, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyJNIFreeGCHandle(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyLogJNIInvokeException(long j10);

    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j10, Class cls) {
        return newProxyInstance(unityPlayer, j10, new Class[]{cls});
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static float a(java.lang.Class r11, java.lang.Class[] r12, java.lang.Class[] r13) {
        /*
            int r0 = r13.length
            r1 = 1036831949(0x3dcccccd, float:0.1)
            if (r0 != 0) goto L7
            return r1
        L7:
            r0 = 0
            if (r12 != 0) goto Lc
            r2 = r0
            goto Ld
        Lc:
            int r2 = r12.length
        Ld:
            int r2 = r2 + 1
            int r3 = r13.length
            r4 = 0
            if (r2 == r3) goto L14
            return r4
        L14:
            r2 = 1056964608(0x3f000000, float:0.5)
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r12 == 0) goto L4f
            int r5 = r12.length
            r6 = r0
            r7 = r3
        L1d:
            if (r0 >= r5) goto L50
            r8 = r12[r0]
            int r9 = r6 + 1
            r6 = r13[r6]
            boolean r10 = r8.equals(r6)
            if (r10 == 0) goto L2d
            r6 = r3
            goto L4a
        L2d:
            boolean r10 = r8.isPrimitive()
            if (r10 != 0) goto L49
            boolean r10 = r6.isPrimitive()
            if (r10 != 0) goto L49
            java.lang.Class r10 = r8.asSubclass(r6)     // Catch: java.lang.ClassCastException -> L41
            if (r10 == 0) goto L41
            r6 = r2
            goto L4a
        L41:
            java.lang.Class r6 = r6.asSubclass(r8)     // Catch: java.lang.ClassCastException -> L49
            if (r6 == 0) goto L49
            r6 = r1
            goto L4a
        L49:
            r6 = r4
        L4a:
            float r7 = r7 * r6
            int r0 = r0 + 1
            r6 = r9
            goto L1d
        L4f:
            r7 = r3
        L50:
            int r12 = r13.length
            int r12 = r12 + (-1)
            r12 = r13[r12]
            boolean r13 = r11.equals(r12)
            if (r13 == 0) goto L5d
            r1 = r3
            goto L79
        L5d:
            boolean r13 = r11.isPrimitive()
            if (r13 != 0) goto L78
            boolean r13 = r12.isPrimitive()
            if (r13 != 0) goto L78
            java.lang.Class r13 = r11.asSubclass(r12)     // Catch: java.lang.ClassCastException -> L71
            if (r13 == 0) goto L71
            r1 = r2
            goto L79
        L71:
            java.lang.Class r11 = r12.asSubclass(r11)     // Catch: java.lang.ClassCastException -> L78
            if (r11 == 0) goto L78
            goto L79
        L78:
            r1 = r4
        L79:
            float r7 = r7 * r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.ReflectionHelper.a(java.lang.Class, java.lang.Class[], java.lang.Class[]):float");
    }

    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j10, Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new L(unityPlayer, j10));
    }

    private static Class a(String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i10 = iArr[0];
            iArr[0] = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt != '(' && cCharAt != ')') {
                if (cCharAt == 'L') {
                    int iIndexOf = str.indexOf(59, iArr[0]);
                    if (iIndexOf == -1) {
                        return null;
                    }
                    String strSubstring = str.substring(iArr[0], iIndexOf);
                    iArr[0] = iIndexOf + 1;
                    try {
                        return Class.forName(strSubstring.replace('/', '.'));
                    } catch (ClassNotFoundException unused) {
                        return null;
                    }
                }
                if (cCharAt == 'Z') {
                    return Boolean.TYPE;
                }
                if (cCharAt == 'I') {
                    return Integer.TYPE;
                }
                if (cCharAt == 'F') {
                    return Float.TYPE;
                }
                if (cCharAt == 'V') {
                    return Void.TYPE;
                }
                if (cCharAt == 'B') {
                    return Byte.TYPE;
                }
                if (cCharAt == 'C') {
                    return Character.TYPE;
                }
                if (cCharAt == 'S') {
                    return Short.TYPE;
                }
                if (cCharAt == 'J') {
                    return Long.TYPE;
                }
                if (cCharAt == 'D') {
                    return Double.TYPE;
                }
                if (cCharAt == '[') {
                    return Array.newInstance((Class<?>) a(str, iArr), 0).getClass();
                }
                AbstractC3275z.Log(5, "! parseType; " + cCharAt + " is not known!");
                return null;
            }
        }
        return null;
    }

    private static synchronized boolean a(M m10) {
        M m11 = f23997a[m10.f23964d & 4095];
        if (!m10.equals(m11)) {
            return false;
        }
        m10.f23965e = m11.f23965e;
        return true;
    }

    private static Class[] a(String str) {
        Class clsA;
        int i10 = 0;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (clsA = a(str, iArr)) != null) {
            arrayList.add(clsA);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            clsArr[i10] = (Class) it.next();
            i10++;
        }
        return clsArr;
    }
}
