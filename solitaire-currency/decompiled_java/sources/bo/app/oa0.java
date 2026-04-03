package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class oa0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f3552a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oa0(Throwable th) {
        super(0);
        this.f3552a = th;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Child job of SerialCoroutineScope got exception: " + this.f3552a;
    }
}
