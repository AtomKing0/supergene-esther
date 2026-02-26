package u9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
public class t<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34703a = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "_cur");

    @Nullable
    private volatile Object _cur;

    public t(boolean z10) {
        this._cur = new u(8, z10);
    }

    public final boolean a(@NotNull E e10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34703a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            int iA = uVar.a(e10);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                androidx.concurrent.futures.a.a(f34703a, this, uVar, uVar.i());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34703a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            if (uVar.d()) {
                return;
            } else {
                androidx.concurrent.futures.a.a(f34703a, this, uVar, uVar.i());
            }
        }
    }

    public final int c() {
        return ((u) f34703a.get(this)).f();
    }

    @Nullable
    public final E d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34703a;
        while (true) {
            u uVar = (u) atomicReferenceFieldUpdater.get(this);
            E e10 = (E) uVar.j();
            if (e10 != u.f34707h) {
                return e10;
            }
            androidx.concurrent.futures.a.a(f34703a, this, uVar, uVar.i());
        }
    }
}
