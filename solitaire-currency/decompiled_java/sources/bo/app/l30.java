package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class l30 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g10 f3297a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l30(g10 g10Var) {
        super(0);
        this.f3297a = g10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Cannot perform triggered action for " + this.f3297a + " due to in-app message json being null";
    }
}
