package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class et extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f2750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f2751b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et(kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2) {
        super(0);
        this.f2750a = n0Var;
        this.f2751b = n0Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Handling full event on blank line. lastEventType: '");
        sb.append((String) this.f2750a.f29834a);
        sb.append("' \ndata: '");
        return h1.a(sb, (String) this.f2751b.f29834a, '\'');
    }
}
