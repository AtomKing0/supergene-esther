package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f4207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4208b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wg0(k10 k10Var, long j10) {
        super(0);
        this.f4207a = k10Var;
        this.f4208b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Resetting re-eligibility for action Id " + ((bh0) this.f4207a).f2452a + " to " + this.f4208b;
    }
}
