package ga;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ConnectionPool.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final la.g f26152a;

    public k(@NotNull la.g delegate) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        this.f26152a = delegate;
    }

    @NotNull
    public final la.g a() {
        return this.f26152a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(int i10, long j10, @NotNull TimeUnit timeUnit) {
        this(new la.g(ka.e.f29730i, i10, j10, timeUnit));
        kotlin.jvm.internal.t.i(timeUnit, "timeUnit");
    }

    public k() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
