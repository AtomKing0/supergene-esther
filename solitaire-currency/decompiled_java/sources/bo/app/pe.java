package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class pe extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f3623a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pe(Throwable th) {
        super(0);
        this.f3623a = th;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not logging duplicate error: " + this.f3623a;
    }
}
