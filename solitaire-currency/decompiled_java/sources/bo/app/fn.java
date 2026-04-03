package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class fn extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f2836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kn f2837b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fn(kotlin.jvm.internal.n0 n0Var, kn knVar) {
        super(0);
        this.f2836a = n0Var;
        this.f2837b = knVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("The received cards are for user ");
        sb.append((String) this.f2836a.f29834a);
        sb.append(" and the current user is ");
        return d1.a(sb, this.f2837b.f3264a, " , the cards will be discarded and no changes will be made.");
    }
}
