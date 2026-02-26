package bo.app;

import com.braze.support.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class k80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f3225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v80 f3228d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k80(z80 z80Var, long j10, long j11, v80 v80Var) {
        super(0);
        this.f3225a = z80Var;
        this.f3226b = j10;
        this.f3227c = j11;
        this.f3228d = v80Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Delaying next request after " + this.f3225a.a(this.f3226b) + " until next token is available in " + this.f3227c + "ms - '" + DateTimeUtils.formatDateFromMillis$default(this.f3226b + this.f3227c, null, null, 3, null) + "'\n" + this.f3228d.f4093l;
    }
}
