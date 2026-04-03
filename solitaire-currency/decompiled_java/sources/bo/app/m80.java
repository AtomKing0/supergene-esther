package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class m80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z80 f3399b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m80(long j10, z80 z80Var) {
        super(0);
        this.f3398a = j10;
        this.f3399b = z80Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Running at " + this.f3398a + " for request " + this.f3399b.a(this.f3398a);
    }
}
