package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class mp extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3444a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mp(String str) {
        super(0);
        this.f3444a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Disk cache still starting. Cannot retrieve key from disk cache: " + this.f3444a;
    }
}
