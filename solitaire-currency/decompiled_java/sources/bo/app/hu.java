package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class hu extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l00 f3004a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hu(l00 l00Var) {
        super(0);
        this.f3004a = l00Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Short circuiting execution of network request (" + this.f3004a.hashCode() + ") and immediately marking it as succeeded.";
    }
}
