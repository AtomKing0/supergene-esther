package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.l1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EventLoop.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class m1 extends k1 {
    @NotNull
    protected abstract Thread U0();

    protected void V0(long j10, @NotNull l1.c cVar) {
        t0.f29980g.f1(j10, cVar);
    }

    protected final void W0() {
        Thread threadU0 = U0();
        if (Thread.currentThread() != threadU0) {
            c.a();
            LockSupport.unpark(threadU0);
        }
    }
}
