package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class og0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f3564a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public og0(k10 k10Var) {
        super(0);
        this.f3564a = k10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Triggered action id "), ((bh0) this.f3564a).f2452a, " always eligible via configuration. Returning true for eligibility status");
    }
}
