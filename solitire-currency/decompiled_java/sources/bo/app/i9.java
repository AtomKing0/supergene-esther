package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class i9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3034b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i9(String str, String str2) {
        super(0);
        this.f3033a = str;
        this.f3034b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return new ba(lx.INAPP_MESSAGE_IMPRESSION, ba.f2429g.a(this.f3033a, null, this.f3034b), 0.0d, 12);
    }
}
