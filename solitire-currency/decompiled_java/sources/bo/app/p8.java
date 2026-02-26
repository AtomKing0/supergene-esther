package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class p8 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f3608a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p8(Throwable th) {
        super(0);
        this.f3608a = th;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Child job of BrazeCoroutineScope got exception: " + this.f3608a;
    }
}
