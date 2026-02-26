package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ig extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3053a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig(String str) {
        super(0);
        this.f3053a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Error occurred while executing Braze request: " + this.f3053a;
    }
}
