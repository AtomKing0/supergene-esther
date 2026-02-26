package u9;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.r2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e0;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e0<S extends e0<S>> extends e<S> implements r2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f34653d = AtomicIntegerFieldUpdater.newUpdater(e0.class, "cleanedAndPointers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34654c;
    private volatile int cleanedAndPointers;

    public e0(long j10, @Nullable S s10, int i10) {
        super(s10);
        this.f34654c = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    @Override // u9.e
    public boolean h() {
        return f34653d.get(this) == n() && !i();
    }

    public final boolean m() {
        return f34653d.addAndGet(this, SupportMenu.CATEGORY_MASK) == n() && !i();
    }

    public abstract int n();

    public abstract void o(int i10, @Nullable Throwable th, @NotNull z8.g gVar);

    public final void p() {
        if (f34653d.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34653d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (!(i10 != n() || i())) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
