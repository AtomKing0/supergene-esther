package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class gh extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d10 f2912a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh(d10 d10Var) {
        super(0);
        this.f2912a = d10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Received server error from request: " + this.f2912a.a();
    }
}
