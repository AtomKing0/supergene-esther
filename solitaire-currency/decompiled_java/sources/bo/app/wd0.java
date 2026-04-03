package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wd0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4198a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd0(String str) {
        super(0);
        this.f4198a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Not removing local path for remote path "), this.f4198a, " from cache because it is being preserved until the end of the app run.");
    }
}
