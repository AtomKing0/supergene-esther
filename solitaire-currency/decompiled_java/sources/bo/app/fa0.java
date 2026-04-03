package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class fa0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d10 f2788a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa0(d10 d10Var) {
        super(0);
        this.f2788a = d10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "SDK Debugger Log Request failed " + this.f2788a.a() + ". Disabling SDK Debugger.";
    }
}
