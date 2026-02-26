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
final class q<T> implements f1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.p<KClass<Object>, List<? extends KType>, KSerializer<T>> f24612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a f24613b;

    /* JADX INFO: compiled from: Caching.kt */
    public static final class a extends ClassValue<e1<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ClassValue
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e1<T> computeValue(@NotNull Class<?> type) {
            kotlin.jvm.internal.t.i(type, "type");
            return new e1<>();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(@NotNull h9.p<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> compute) {
        kotlin.jvm.internal.t.i(compute, "compute");
        this.f24612a = compute;
        this.f24613b = b();
    }

    private final a b() {
        return new a();
    }

    @Override // da.f1
    @NotNull
    public Object a(@NotNull KClass<Object> key, @NotNull List<? extends KType> types) {
        Object objB;
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(types, "types");
        ConcurrentHashMap concurrentHashMap = ((e1) this.f24613b.get(g9.a.a(key))).f24563a;
        Object obj = concurrentHashMap.get(types);
        if (obj == null) {
            try {
                t.a aVar = v8.t.f35208b;
                objB = v8.t.b(this.f24612a.mo4invoke(key, types));
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            v8.t tVarA = v8.t.a(objB);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(types, tVarA);
            obj = objPutIfAbsent == null ? tVarA : objPutIfAbsent;
        }
        kotlin.jvm.internal.t.h(obj, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((v8.t) obj).j();
    }
}
