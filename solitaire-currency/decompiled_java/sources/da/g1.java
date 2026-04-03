package da;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g1 {
    private static final Object a(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static final <T> KSerializer<T> b(@NotNull KClass<T> kClass) {
        kotlin.jvm.internal.t.i(kClass, "<this>");
        return d(kClass, new KSerializer[0]);
    }

    @Nullable
    public static final <T> KSerializer<T> c(@NotNull Class<T> cls, @NotNull KSerializer<Object>... args) throws IllegalAccessException, InvocationTargetException {
        Object obj;
        Field field;
        KSerializer<T> kSerializerG;
        kotlin.jvm.internal.t.i(cls, "<this>");
        kotlin.jvm.internal.t.i(args, "args");
        if (cls.isEnum() && j(cls)) {
            return e(cls);
        }
        if (cls.isInterface() && (kSerializerG = g(cls)) != null) {
            return kSerializerG;
        }
        KSerializer<T> kSerializerH = h(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (kSerializerH != null) {
            return kSerializerH;
        }
        KSerializer<T> kSerializerF = f(cls);
        if (kSerializerF != null) {
            return kSerializerF;
        }
        try {
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            kotlin.jvm.internal.t.h(declaredClasses, "declaredClasses");
            int length = declaredClasses.length;
            int i10 = 0;
            Class<?> cls2 = null;
            boolean z10 = false;
            while (true) {
                if (i10 >= length) {
                    if (!z10) {
                        break;
                    }
                } else {
                    Class<?> cls3 = declaredClasses[i10];
                    if (kotlin.jvm.internal.t.d(cls3.getSimpleName(), "$serializer")) {
                        if (z10) {
                            break;
                        }
                        z10 = true;
                        cls2 = cls3;
                    }
                    i10++;
                }
            }
            cls2 = null;
            Class<?> cls4 = cls2;
            obj = (cls4 == null || (field = cls4.getField("INSTANCE")) == null) ? null : field.get(null);
        } catch (NoSuchFieldException unused) {
        }
        KSerializer<T> kSerializer = obj instanceof KSerializer ? (KSerializer) obj : null;
        if (kSerializer != null) {
            return kSerializer;
        }
        if (k(cls)) {
            return new z9.e(g9.a.c(cls));
        }
        return null;
    }

    @Nullable
    public static final <T> KSerializer<T> d(@NotNull KClass<T> kClass, @NotNull KSerializer<Object>... args) {
        kotlin.jvm.internal.t.i(kClass, "<this>");
        kotlin.jvm.internal.t.i(args, "args");
        return c(g9.a.a(kClass), (KSerializer[]) Arrays.copyOf(args, args.length));
    }

    private static final <T> KSerializer<T> e(Class<T> cls) {
        T[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        kotlin.jvm.internal.t.h(canonicalName, "canonicalName");
        kotlin.jvm.internal.t.g(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new a0(canonicalName, (Enum[]) enumConstants);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final <T> kotlinx.serialization.KSerializer<T> f(java.lang.Class<T> r11) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r1 = "declaredFields"
            kotlin.jvm.internal.t.h(r0, r1)
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r6 = r2
            r4 = r3
            r5 = r4
        Lf:
            r7 = 1
            if (r4 >= r1) goto L41
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.t.d(r9, r10)
            if (r9 == 0) goto L36
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.t.d(r9, r11)
            if (r9 == 0) goto L36
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L36
            r9 = r7
            goto L37
        L36:
            r9 = r3
        L37:
            if (r9 == 0) goto L3e
            if (r5 == 0) goto L3c
            goto L43
        L3c:
            r5 = r7
            r6 = r8
        L3e:
            int r4 = r4 + 1
            goto Lf
        L41:
            if (r5 != 0) goto L44
        L43:
            r6 = r2
        L44:
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            if (r6 != 0) goto L49
            return r2
        L49:
            java.lang.Object r0 = r6.get(r2)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r1 = "methods"
            kotlin.jvm.internal.t.h(r11, r1)
            int r1 = r11.length
            r6 = r2
            r4 = r3
            r5 = r4
        L5a:
            if (r4 >= r1) goto L94
            r8 = r11[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "serializer"
            boolean r9 = kotlin.jvm.internal.t.d(r9, r10)
            if (r9 == 0) goto L89
            java.lang.Class[] r9 = r8.getParameterTypes()
            java.lang.String r10 = "it.parameterTypes"
            kotlin.jvm.internal.t.h(r9, r10)
            int r9 = r9.length
            if (r9 != 0) goto L78
            r9 = r7
            goto L79
        L78:
            r9 = r3
        L79:
            if (r9 == 0) goto L89
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r10 = kotlinx.serialization.KSerializer.class
            boolean r9 = kotlin.jvm.internal.t.d(r9, r10)
            if (r9 == 0) goto L89
            r9 = r7
            goto L8a
        L89:
            r9 = r3
        L8a:
            if (r9 == 0) goto L91
            if (r5 == 0) goto L8f
            goto L96
        L8f:
            r5 = r7
            r6 = r8
        L91:
            int r4 = r4 + 1
            goto L5a
        L94:
            if (r5 != 0) goto L97
        L96:
            r6 = r2
        L97:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L9c
            return r2
        L9c:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.Object r11 = r6.invoke(r0, r11)
            boolean r0 = r11 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto La9
            r2 = r11
            kotlinx.serialization.KSerializer r2 = (kotlinx.serialization.KSerializer) r2
        La9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: da.g1.f(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    private static final <T> KSerializer<T> g(Class<T> cls) {
        z9.h hVar = (z9.h) cls.getAnnotation(z9.h.class);
        if (hVar == null || kotlin.jvm.internal.t.d(kotlin.jvm.internal.o0.b(hVar.with()), kotlin.jvm.internal.o0.b(z9.e.class))) {
            return new z9.e(g9.a.c(cls));
        }
        return null;
    }

    private static final <T> KSerializer<T> h(Class<?> cls, KSerializer<Object>... kSerializerArr) throws IllegalAccessException, InvocationTargetException {
        Class[] clsArr;
        Object objA = a(cls);
        if (objA == null) {
            return null;
        }
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i10 = 0; i10 < length; i10++) {
                    clsArr2[i10] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object objInvoke = objA.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(objA, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (objInvoke instanceof KSerializer) {
                return (KSerializer) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause == null) {
                throw e10;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e10.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    public static final boolean i(@NotNull Object obj, @NotNull KClass<?> kclass) {
        kotlin.jvm.internal.t.i(obj, "<this>");
        kotlin.jvm.internal.t.i(kclass, "kclass");
        return g9.a.b(kclass).isInstance(obj);
    }

    private static final <T> boolean j(Class<T> cls) {
        return cls.getAnnotation(z9.h.class) == null && cls.getAnnotation(z9.d.class) == null;
    }

    private static final <T> boolean k(Class<T> cls) {
        if (cls.getAnnotation(z9.d.class) != null) {
            return true;
        }
        z9.h hVar = (z9.h) cls.getAnnotation(z9.h.class);
        return hVar != null && kotlin.jvm.internal.t.d(kotlin.jvm.internal.o0.b(hVar.with()), kotlin.jvm.internal.o0.b(z9.e.class));
    }

    public static final boolean l(@NotNull KClass<Object> rootClass) {
        kotlin.jvm.internal.t.i(rootClass, "rootClass");
        return g9.a.a(rootClass).isArray();
    }

    @NotNull
    public static final Void m(@NotNull KClass<?> kClass) {
        kotlin.jvm.internal.t.i(kClass, "<this>");
        h1.d(kClass);
        throw new v8.h();
    }

    @NotNull
    public static final <T, E extends T> E[] n(@NotNull ArrayList<E> arrayList, @NotNull KClass<T> eClass) {
        kotlin.jvm.internal.t.i(arrayList, "<this>");
        kotlin.jvm.internal.t.i(eClass, "eClass");
        Object objNewInstance = Array.newInstance((Class<?>) g9.a.a(eClass), arrayList.size());
        kotlin.jvm.internal.t.g(objNewInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) objNewInstance);
        kotlin.jvm.internal.t.h(eArr, "toArray(java.lang.reflec….java, size) as Array<E>)");
        return eArr;
    }
}
