package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class mu extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f3449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3450b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mu(long j10, z80 z80Var) {
        super(0);
        this.f3449a = z80Var;
        this.f3450b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Marking request as framework complete \n" + this.f3449a.a(this.f3450b);
    }
}
