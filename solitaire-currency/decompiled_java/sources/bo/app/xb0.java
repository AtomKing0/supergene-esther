package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class xb0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ double f4259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zb0 f4260b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xb0(double d10, zb0 zb0Var) {
        super(0);
        this.f4259a = d10;
        this.f4260b = zb0Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "End time '" + this.f4259a + "' for session is less than the start time '" + this.f4260b.f4422b + "' for this session.";
    }
}
