package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class si0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3864a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public si0(String str) {
        super(0);
        this.f3864a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Could not download zip file to local storage. " + this.f3864a;
    }
}
