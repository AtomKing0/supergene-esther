package g8;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AttributesJvm.kt */
/* JADX INFO: loaded from: classes.dex */
final class p extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<a<?>, Object> f25905a = new HashMap();

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
        Object objPut = h().put(key, tInvoke);
        if (objPut != null) {
            tInvoke = (T) objPut;
        }
        kotlin.jvm.internal.t.g(tInvoke, "null cannot be cast to non-null type T of io.ktor.util.HashMapAttributes.computeIfAbsent");
        return tInvoke;
    }

    @Override // g8.c
    @NotNull
    protected Map<a<?>, Object> h() {
        return this.f25905a;
    }
}
