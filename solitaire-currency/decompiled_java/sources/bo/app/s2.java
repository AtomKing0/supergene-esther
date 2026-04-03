package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class s2 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f3816a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s2(kotlin.jvm.internal.n0 n0Var) {
        super(0);
        this.f3816a = n0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Logged custom event with name "), (String) this.f3816a.f29834a, " was invalid. Not logging custom event to Braze.");
    }
}
