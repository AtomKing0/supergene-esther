package da;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: Caching.kt */
/* JADX INFO: loaded from: classes5.dex */
final class u<T> implements f1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.p<KClass<Object>, List<? extends KType>, KSerializer<T>> f24627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<Class<?>, e1<T>> f24628b;

    /* JADX WARN: Multi-variable type inference failed */
    public u(@NotNull h9.p<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        kotlin.jvm.internal.t.i(compute, "compute");
        this.f24627a = compute;
        this.f24628b = new ConcurrentHashMap<>();
    }

    @Override // da.f1
    @NotNull
    public Object a(@NotNull KClass<Object> key, @NotNull List<? extends KType> types) {
        Object objB;
        e1<T> e1VarPutIfAbsent;
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(types, "types");
        ConcurrentHashMap<Class<?>, e1<T>> concurrentHashMap = this.f24628b;
        Class<?> clsA = g9.a.a(key);
        e1<T> e1Var = concurrentHashMap.get(clsA);
        if (e1Var == null && (e1VarPutIfAbsent = concurrentHashMap.putIfAbsent(clsA, (e1Var = new e1<>()))) != null) {
            e1Var = e1VarPutIfAbsent;
        }
        ConcurrentHashMap concurrentHashMap2 = ((e1) e1Var).f24563a;
        Object obj = concurrentHashMap2.get(types);
        if (obj == null) {
            try {
                t.a aVar = v8.t.f35208b;
                objB = v8.t.b(this.f24627a.mo4invoke(key, types));
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            v8.t tVarA = v8.t.a(objB);
            Object objPutIfAbsent = concurrentHashMap2.putIfAbsent(types, tVarA);
            obj = objPutIfAbsent == null ? tVarA : objPutIfAbsent;
        }
        kotlin.jvm.internal.t.h(obj, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((v8.t) obj).j();
    }
}
