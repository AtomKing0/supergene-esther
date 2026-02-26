package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class z90 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d10 f4418a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z90(d10 d10Var) {
        super(0);
        this.f4418a = d10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "SDK Debugger Initialization Request failed " + this.f4418a.a() + ". Disabling SDK Debugger.";
    }
}
