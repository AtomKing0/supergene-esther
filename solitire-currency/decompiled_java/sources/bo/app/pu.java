package bo.app;

import com.braze.support.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class pu extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f3661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ rd0 f3664d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pu(z80 z80Var, long j10, long j11, rd0 rd0Var) {
        super(0);
        this.f3661a = z80Var;
        this.f3662b = j10;
        this.f3663c = j11;
        this.f3664d = rd0Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Delaying next request after '" + this.f3661a.a(this.f3662b) + "' until next token is available in " + this.f3663c + "ms - '" + DateTimeUtils.formatDateFromMillis$default(this.f3662b + this.f3663c, null, null, 3, null) + "'\n" + this.f3664d;
    }
}
