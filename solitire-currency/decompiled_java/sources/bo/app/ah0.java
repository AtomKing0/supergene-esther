package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ah0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bh0 f2384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g10 f2385b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah0(bh0 bh0Var, g10 g10Var) {
        super(0);
        this.f2384a = bh0Var;
        this.f2385b = g10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Triggered action " + this.f2384a.f2452a + " not eligible to be triggered by " + this.f2385b.a() + " event. Current device time outside triggered action time window.";
    }
}
