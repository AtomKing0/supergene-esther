package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class yc0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4352b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc0(String str, String str2) {
        super(0);
        this.f4351a = str;
        this.f4352b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Generating MD5 for user id: " + this.f4351a + " apiKey: " + this.f4352b;
    }
}
