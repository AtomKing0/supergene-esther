package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ii0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3065a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii0(String str) {
        super(0);
        this.f3065a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "The productId is a blocklisted productId: " + this.f3065a;
    }
}
