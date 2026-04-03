package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class lu extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f3348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3350c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lu(z80 z80Var, long j10, int i10) {
        super(0);
        this.f3348a = z80Var;
        this.f3349b = j10;
        this.f3350c = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Set retry count for " + this.f3348a.a(this.f3349b) + " to " + this.f3350c;
    }
}
