package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class d80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f2630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f2631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d10 f2632c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d80(z80 z80Var, long j10, d10 d10Var) {
        super(0);
        this.f2630a = z80Var;
        this.f2631b = j10;
        this.f2632c = d10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Request failure received " + this.f2630a.a(this.f2631b) + " \n" + this.f2632c;
    }
}
