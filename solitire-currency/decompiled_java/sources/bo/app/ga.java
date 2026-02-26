package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ga extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2890a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga(String str) {
        super(0);
        this.f2890a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "SDK is offline. File not downloaded for url: " + this.f2890a;
    }
}
