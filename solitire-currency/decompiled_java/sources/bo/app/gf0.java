package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class gf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g10 f2909a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gf0(g10 g10Var) {
        super(0);
        this.f2909a = g10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "No action found for " + this.f2909a.a() + " event, publishing NoMatchingTriggerEvent";
    }
}
