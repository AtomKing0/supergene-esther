package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class m70 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f3396b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m70(String str, kotlin.jvm.internal.n0 n0Var) {
        super(0);
        this.f3395a = str;
        this.f3396b = n0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Could not find ");
        sb.append(this.f3395a);
        sb.append(" on ");
        Class cls = (Class) this.f3396b.f29834a;
        sb.append(cls != null ? cls.getName() : null);
        return sb.toString();
    }
}
