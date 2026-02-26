package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class co extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f2580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f2581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z80 f2582c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(z80 z80Var, long j10, z80 z80Var2) {
        super(0);
        this.f2580a = z80Var;
        this.f2581b = j10;
        this.f2582c = z80Var2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Batched request " + this.f2580a.a(this.f2581b) + " and combined into " + this.f2582c.a(this.f2581b);
    }
}
