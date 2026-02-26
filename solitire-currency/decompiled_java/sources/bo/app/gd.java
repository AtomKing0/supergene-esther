package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class gd extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2897a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(String str) {
        super(0);
        this.f2897a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "SDK is in offline mode, not downloading remote bitmap with uri: " + this.f2897a;
    }
}
