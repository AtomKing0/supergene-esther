package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class k4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f3212a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k4(Throwable th) {
        super(0);
        this.f3212a = th;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to log throwable: " + this.f3212a;
    }
}
