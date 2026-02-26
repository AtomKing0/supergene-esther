package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class f80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f2783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f2784b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f80(long j10, z80 z80Var) {
        super(0);
        this.f2783a = z80Var;
        this.f2784b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Request success received for " + this.f2783a.a(this.f2784b);
    }
}
