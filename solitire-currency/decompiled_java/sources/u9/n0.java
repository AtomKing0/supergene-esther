package u9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n0 implements g.c<m0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ThreadLocal<?> f34682a;

    public n0(@NotNull ThreadLocal<?> threadLocal) {
        this.f34682a = threadLocal;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n0) && kotlin.jvm.internal.t.d(this.f34682a, ((n0) obj).f34682a);
    }

    public int hashCode() {
        return this.f34682a.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f34682a + ')';
    }
}
