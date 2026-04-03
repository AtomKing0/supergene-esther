package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class b4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2414b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(String str, String str2) {
        super(0);
        this.f2413a = str;
        this.f2414b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to log push story page clicked for pageId: " + this.f2413a + " campaignId: " + this.f2414b;
    }
}
