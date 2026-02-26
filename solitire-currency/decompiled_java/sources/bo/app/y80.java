package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class y80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f4343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4344b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y80(long j10, z80 z80Var) {
        super(0);
        this.f4343a = z80Var;
        this.f4344b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Moving to pending retry.Updated retry count: " + this.f4343a.f4417h + " for: \n" + this.f4343a.a(this.f4344b);
    }
}
