package ab;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: ServiceMethod.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class a0<T> {
    a0() {
    }

    static <T> a0<T> b(z zVar, Method method) {
        x xVarB = x.b(zVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (d0.j(genericReturnType)) {
            throw d0.m(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return m.f(zVar, method, xVarB);
        }
        throw d0.m(method, "Service methods cannot return void.", new Object[0]);
    }

    abstract T a(Object[] objArr);
}
