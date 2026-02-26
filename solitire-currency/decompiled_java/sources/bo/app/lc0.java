package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class lc0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f3325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3326b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lc0(String str, kotlin.jvm.internal.n0 n0Var) {
        super(0);
        this.f3325a = n0Var;
        this.f3326b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Could not create BrazeEvent from [serialized event string=");
        sb.append((String) this.f3325a.f29834a);
        sb.append(", unique identifier=");
        return d1.a(sb, this.f3326b, "] ... Deleting!");
    }
}
