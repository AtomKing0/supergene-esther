package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes5.dex */
final class g<T> extends a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Thread f29899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final k1 f29900e;

    public g(@NotNull z8.g gVar, @NotNull Thread thread, @Nullable k1 k1Var) {
        super(gVar, true, true);
        this.f29899d = thread;
        this.f29900e = k1Var;
    }

    @Override // kotlinx.coroutines.j2
    protected void C(@Nullable Object obj) {
        if (kotlin.jvm.internal.t.d(Thread.currentThread(), this.f29899d)) {
            return;
        }
        Thread thread = this.f29899d;
        c.a();
        LockSupport.unpark(thread);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T U0() throws Throwable {
        c.a();
        try {
            k1 k1Var = this.f29900e;
            if (k1Var != null) {
                k1.O0(k1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    k1 k1Var2 = this.f29900e;
                    long jR0 = k1Var2 != null ? k1Var2.R0() : Long.MAX_VALUE;
                    if (i()) {
                        c.a();
                        T t10 = (T) k2.h(f0());
                        c0Var = t10 instanceof c0 ? (c0) t10 : null;
                        if (c0Var == null) {
                            return t10;
                        }
                        throw c0Var.f29865a;
                    }
                    c.a();
                    LockSupport.parkNanos(this, jR0);
                } finally {
                    k1 k1Var3 = this.f29900e;
                    if (k1Var3 != null) {
                        k1.J0(k1Var3, false, 1, null);
                    }
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            F(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            c.a();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.j2
    protected boolean l0() {
        return true;
    }
}
