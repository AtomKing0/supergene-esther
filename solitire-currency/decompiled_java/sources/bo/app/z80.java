package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class z80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l00 f4410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a90 f4413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f4415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4417h;

    public z80(l00 request, long j10, long j11, a90 state, int i10, Integer num) {
        kotlin.jvm.internal.t.i(request, "request");
        kotlin.jvm.internal.t.i(state, "state");
        this.f4410a = request;
        this.f4411b = j10;
        this.f4412c = j11;
        this.f4413d = state;
        this.f4414e = i10;
        this.f4415f = num;
        this.f4416g = j11;
    }

    public final l00 a() {
        return this.f4410a;
    }

    public final void a(long j10, a90 newState) {
        kotlin.jvm.internal.t.i(newState, "newState");
        if (this.f4413d != newState) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.Priority priority = BrazeLogger.Priority.V;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, true, (h9.a) new x80(this, newState, j10), 2, (Object) null);
            this.f4416g = j10;
            this.f4413d = newState;
            if (newState == a90.PENDING_RETRY) {
                this.f4417h++;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, true, (h9.a) new y80(j10, this), 2, (Object) null);
            }
        }
    }

    public final String a(long j10) {
        return p9.j.h("\n            |RequestInfo for " + this.f4410a.hashCode() + " \n            | at " + j10 + "\n            | request.target = " + ((tg) this.f4410a).e() + "\n            | nextAdvance = " + (this.f4411b - j10) + "\n            | createdAt = " + (this.f4412c - j10) + "\n            | state = " + this.f4413d + "\n            | lastStateMovedAt = " + (this.f4416g - j10) + "\n            | timesMovedToRetry = " + this.f4417h + "\n        ", null, 1, null);
    }
}
