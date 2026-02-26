package kotlin.jvm.internal;

import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: ReflectionFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public class p0 {
    public KClass b(Class cls) {
        return new i(cls);
    }

    public KDeclarationContainer c(Class cls, String str) {
        return new c0(cls, str);
    }

    public String h(o oVar) {
        String string = oVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String i(v vVar) {
        return h(vVar);
    }

    public KType j(KClassifier kClassifier, List<KTypeProjection> list, boolean z10) {
        return new u0(kClassifier, list, z10);
    }

    public KFunction a(p pVar) {
        return pVar;
    }

    public KMutableProperty0 d(x xVar) {
        return xVar;
    }

    public KMutableProperty1 e(z zVar) {
        return zVar;
    }

    public KProperty0 f(d0 d0Var) {
        return d0Var;
    }

    public KProperty1 g(f0 f0Var) {
        return f0Var;
    }
}
