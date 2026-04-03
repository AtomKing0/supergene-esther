package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class k30 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q30 f3211a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k30(q30 q30Var) {
        super(0);
        this.f3211a = q30Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Attempting to publish in-app message after delay of " + this.f3211a.f2453b.f2886d + " seconds.";
    }
}
