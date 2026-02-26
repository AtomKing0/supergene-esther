package g8;

import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AttributesJvm.kt */
/* JADX INFO: loaded from: classes.dex */
final class l extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ConcurrentHashMap<a<?>, Object> f25896a = new ConcurrentHashMap<>();

    @Override // g8.b
    @NotNull
    public <T> T g(@NotNull a<T> key, @NotNull h9.a<? extends T> block) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(block, "block");
        T t10 = (T) h().get(key);
        if (t10 != null) {
            return t10;
        }
        T tInvoke = block.invoke();
        Object objPutIfAbsent = h().putIfAbsent(key, tInvoke);
        if (objPutIfAbsent != null) {
            tInvoke = (T) objPutIfAbsent;
        }
        kotlin.jvm.internal.t.g(tInvoke, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // g8.c
    @NotNull
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public ConcurrentHashMap<a<?>, Object> h() {
        return this.f25896a;
    }
}
