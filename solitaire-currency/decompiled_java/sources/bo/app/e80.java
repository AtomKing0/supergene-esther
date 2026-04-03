package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class e80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v80 f2714a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e80(v80 v80Var) {
        super(0);
        this.f2714a = v80Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Incremented invalidApiKeyErrorCounter to " + this.f2714a.f4092k.get();
    }
}
