package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class zd0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f4432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4433b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zd0(String str, kotlin.jvm.internal.n0 n0Var) {
        super(0);
        this.f4432a = n0Var;
        this.f4433b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.a
    public final Object invoke() {
        return "Using file extension " + ((String) this.f4432a.f29834a) + " for remote asset url: " + this.f4433b;
    }
}
