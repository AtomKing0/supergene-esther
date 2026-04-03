package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class uc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.l0 f4006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4008c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uc(kotlin.jvm.internal.l0 l0Var, long j10, long j11) {
        super(0);
        this.f4006a = l0Var;
        this.f4007b = j10;
        this.f4008c = j11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Using image sample size of " + this.f4006a.f29831a + ". Image will be scaled to width: " + (this.f4007b / ((long) this.f4006a.f29831a)) + " and height: " + (this.f4008c / ((long) this.f4006a.f29831a));
    }
}
