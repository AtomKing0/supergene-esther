package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class us extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xs f4039b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public us(String str, xs xsVar) {
        super(0);
        this.f4038a = str;
        this.f4039b = xsVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Cannot start a dust subscription with mite " + this.f4038a + " and enabled " + this.f4039b.f4297a.x();
    }
}
