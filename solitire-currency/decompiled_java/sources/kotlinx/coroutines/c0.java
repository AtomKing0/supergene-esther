package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes5.dex */
public class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f29864b = AtomicIntegerFieldUpdater.newUpdater(c0.class, "_handled");
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Throwable f29865a;

    public c0(@NotNull Throwable th, boolean z10) {
        this.f29865a = th;
        this._handled = z10 ? 1 : 0;
    }

    public final boolean a() {
        return f29864b.get(this) != 0;
    }

    public final boolean b() {
        return f29864b.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return s0.a(this) + '[' + this.f29865a + ']';
    }

    public /* synthetic */ c0(Throwable th, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this(th, (i10 & 2) != 0 ? false : z10);
    }
}
