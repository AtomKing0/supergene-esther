package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class c80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f2491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z80 f2492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f2493c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c80(boolean z10, z80 z80Var, long j10) {
        super(0);
        this.f2491a = z10;
        this.f2492b = z80Var;
        this.f2493c = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Running on ");
        sb.append(this.f2491a ? "no-op" : "network");
        sb.append(" executor for ");
        sb.append(this.f2492b.a(this.f2493c));
        return sb.toString();
    }
}
