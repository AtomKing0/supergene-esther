package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Latch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Latch {

    @NotNull
    private final Object lock = new Object();

    @NotNull
    private List<z8.d<k0>> awaiters = new ArrayList();

    @NotNull
    private List<z8.d<k0>> spareList = new ArrayList();
    private boolean _isOpen = true;

    @Nullable
    public final Object await(@NotNull z8.d<? super k0> dVar) throws Throwable {
        if (isOpen()) {
            return k0.f35197a;
        }
        p pVar = new p(a9.c.c(dVar), 1);
        pVar.C();
        synchronized (this.lock) {
            this.awaiters.add(pVar);
        }
        pVar.m(new Latch$await$2$2(this, pVar));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : k0.f35197a;
    }

    public final void closeLatch() {
        synchronized (this.lock) {
            this._isOpen = false;
            k0 k0Var = k0.f35197a;
        }
    }

    public final boolean isOpen() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this._isOpen;
        }
        return z10;
    }

    public final void openLatch() {
        synchronized (this.lock) {
            if (isOpen()) {
                return;
            }
            List<z8.d<k0>> list = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = list;
            this._isOpen = true;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                z8.d<k0> dVar = list.get(i10);
                t.a aVar = t.f35208b;
                dVar.resumeWith(t.b(k0.f35197a));
            }
            list.clear();
            k0 k0Var = k0.f35197a;
        }
    }

    public final <R> R withClosed(@NotNull h9.a<? extends R> block) {
        kotlin.jvm.internal.t.i(block, "block");
        closeLatch();
        try {
            return block.invoke();
        } finally {
            r.b(1);
            openLatch();
            r.a(1);
        }
    }
}
