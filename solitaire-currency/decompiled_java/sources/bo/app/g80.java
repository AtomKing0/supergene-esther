package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class g80 implements a80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v80 f2879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z80 f2880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ uu f2881c;

    public g80(v80 v80Var, z80 z80Var, uu uuVar) {
        this.f2879a = v80Var;
        this.f2880b = z80Var;
        this.f2881c = uuVar;
    }

    @Override // bo.app.a80
    public final void a(n apiResponse) {
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        v80 v80Var = this.f2879a;
        ReentrantLock reentrantLock = v80Var.f4088g;
        z80 z80Var = this.f2880b;
        uu uuVar = this.f2881c;
        reentrantLock.lock();
        try {
            long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
            s50 s50Var = apiResponse instanceof s50 ? (s50) apiResponse : null;
            d10 d10Var = s50Var != null ? s50Var.f3820d : null;
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, v80.f4079n, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new d80(z80Var, jNowInMilliseconds, d10Var), 14, (Object) null);
            z80Var.a(jNowInMilliseconds, a90.PENDING_RETRY);
            uuVar.a(jNowInMilliseconds, z80Var, apiResponse);
            if (d10Var instanceof i90) {
                v80Var.f4090i = jNowInMilliseconds;
                v80Var.f4089h = (i90) d10Var;
                v80Var.f4091j = jNowInMilliseconds + v80.f4080o;
            }
            if (d10Var instanceof x30) {
                v80Var.f4092k.incrementAndGet();
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new e80(v80Var), 7, (Object) null);
            }
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // bo.app.a80
    public final void a(s50 apiResponse) {
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        ReentrantLock reentrantLock = this.f2879a.f4088g;
        z80 z80Var = this.f2880b;
        uu uuVar = this.f2881c;
        reentrantLock.lock();
        try {
            long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, v80.f4079n, (BrazeLogger.Priority) null, (Throwable) null, true, (h9.a) new f80(jNowInMilliseconds, z80Var), 6, (Object) null);
            z80Var.a(jNowInMilliseconds, a90.COMPLETE);
            uuVar.a(jNowInMilliseconds, z80Var, apiResponse);
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
