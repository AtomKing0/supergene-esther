package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes5.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p0 f29835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final KClass[] f29836b;

    static {
        p0 p0Var = null;
        try {
            p0Var = (p0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (p0Var == null) {
            p0Var = new p0();
        }
        f29835a = p0Var;
        f29836b = new KClass[0];
    }

    public static KFunction a(p pVar) {
        return f29835a.a(pVar);
    }

    public static KClass b(Class cls) {
        return f29835a.b(cls);
    }

    public static KDeclarationContainer c(Class cls) {
        return f29835a.c(cls, "");
    }

    public static KMutableProperty0 d(x xVar) {
        return f29835a.d(xVar);
    }

    public static KMutableProperty1 e(z zVar) {
        return f29835a.e(zVar);
    }

    public static KProperty0 f(d0 d0Var) {
        return f29835a.f(d0Var);
    }

    public static KProperty1 g(f0 f0Var) {
        return f29835a.g(f0Var);
    }

    public static String h(o oVar) {
        return f29835a.h(oVar);
    }

    public static String i(v vVar) {
        return f29835a.i(vVar);
    }

    public static KType j(Class cls) {
        return f29835a.j(b(cls), Collections.emptyList(), false);
    }

    public static KType k(Class cls, KTypeProjection kTypeProjection) {
        return f29835a.j(b(cls), Collections.singletonList(kTypeProjection), false);
    }

    public static KType l(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f29835a.j(b(cls), Arrays.asList(kTypeProjection, kTypeProjection2), false);
    }
}
