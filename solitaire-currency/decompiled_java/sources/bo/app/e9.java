package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class e9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2716b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e9(String str, String str2) {
        super(0);
        this.f2715a = str;
        this.f2716b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return new ba(lx.INAPP_MESSAGE_BUTTON_CLICK, z9.a(ba.f2429g, this.f2715a, this.f2716b, 4), 0.0d, 12);
    }
}
