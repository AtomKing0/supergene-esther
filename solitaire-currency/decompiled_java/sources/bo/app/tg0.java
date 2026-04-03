package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class tg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f3949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3950b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tg0(k10 k10Var, long j10) {
        super(0);
        this.f3949a = k10Var;
        this.f3950b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Updating re-eligibility for action Id " + ((bh0) this.f3949a).f2452a + " to time " + this.f3950b + '.';
    }
}
