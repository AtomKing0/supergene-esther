package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ch extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih f2530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ fb0 f2531b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch(ih ihVar, fb0 fb0Var) {
        super(0);
        this.f2530a = ihVar;
        this.f2531b = fb0Var;
    }

    @Override // h9.a
    public final Object invoke() {
        this.f2530a.f3058d.a(this.f2531b);
        ((vw) this.f2530a.f3055a).b(gb0.class, new gb0(this.f2531b));
        fb0 serverConfig = this.f2531b;
        kotlin.jvm.internal.t.i(serverConfig, "serverConfig");
        r90 r90Var = new r90(serverConfig.b(), serverConfig.c(), serverConfig.a(), serverConfig.d(), serverConfig.e(), serverConfig.f());
        ((vw) this.f2530a.f3055a).b(x90.class, new x90(r90Var));
        return v8.k0.f35197a;
    }
}
