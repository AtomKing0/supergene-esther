package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class if0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g10 f3052a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public if0(g10 g10Var) {
        super(0);
        this.f3052a = g10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to match triggered action for incoming <" + this.f3052a.a() + ">.";
    }
}
