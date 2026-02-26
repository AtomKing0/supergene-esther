package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class h9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2963b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h9(String str, String str2) {
        super(0);
        this.f2962a = str;
        this.f2963b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return new ba(lx.INAPP_MESSAGE_CONTROL_IMPRESSION, ba.f2429g.a(this.f2962a, null, this.f2963b), 0.0d, 12);
    }
}
