package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class kp extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3277a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kp(String str) {
        super(0);
        this.f3277a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Got bitmap from disk cache for key " + this.f3277a;
    }
}
