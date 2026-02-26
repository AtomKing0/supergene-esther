package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class qg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f3710a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qg0(k10 k10Var) {
        super(0);
        this.f3710a = k10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Triggered action id "), ((bh0) this.f3710a).f2452a, " no longer eligible due to having been triggered in the past and is only eligible once.");
    }
}
