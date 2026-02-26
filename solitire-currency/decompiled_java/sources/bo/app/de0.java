package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class de0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f2648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2649b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de0(k10 k10Var, String str) {
        super(0);
        this.f2648a = k10Var;
        this.f2649b = str;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Received new remote path for triggered action ");
        sb.append(((bh0) this.f2648a).f2452a);
        sb.append(" at ");
        return h1.a(sb, this.f2649b, '.');
    }
}
