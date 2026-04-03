package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ri0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3793b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ri0(String str, String str2) {
        super(0);
        this.f3792a = str;
        this.f3793b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Starting download of url: " + this.f3792a + " to " + this.f3793b;
    }
}
