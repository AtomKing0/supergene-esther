package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class dd0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f2645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f2646b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd0(long j10, z80 z80Var) {
        super(0);
        this.f2645a = z80Var;
        this.f2646b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Template request will expire before send time and is not eligible for a request retry. Not retrying or performing any fallback triggers. " + this.f2645a.a(this.f2646b);
    }
}
