package da;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Caching.kt */
/* JADX INFO: loaded from: classes5.dex */
final class t<T> implements t1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.l<KClass<?>, KSerializer<T>> f24623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<Class<?>, k<T>> f24624b;

    /* JADX WARN: Multi-variable type inference failed */
    public t(@NotNull h9.l<? super KClass<?>, ? extends KSerializer<T>> compute) {
        kotlin.jvm.internal.t.i(compute, "compute");
        this.f24623a = compute;
        this.f24624b = new ConcurrentHashMap<>();
    }

    @Override // da.t1
    @Nullable
    public KSerializer<T> a(@NotNull KClass<Object> key) {
        k<T> kVarPutIfAbsent;
        kotlin.jvm.internal.t.i(key, "key");
        ConcurrentHashMap<Class<?>, k<T>> concurrentHashMap = this.f24624b;
        Class<?> clsA = g9.a.a(key);
        k<T> kVar = concurrentHashMap.get(clsA);
        if (kVar == null && (kVarPutIfAbsent = concurrentHashMap.putIfAbsent(clsA, (kVar = new k<>(this.f24623a.invoke(key))))) != null) {
            kVar = kVarPutIfAbsent;
        }
        return kVar.f24590a;
    }
}
