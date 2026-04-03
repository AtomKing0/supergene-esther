package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ik extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f3069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f3070c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ik(String str, double d10, double d11) {
        super(0);
        this.f3068a = str;
        this.f3069b = d10;
        this.f3070c = d11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to set custom location attribute with key '" + this.f3068a + "' and latitude '" + this.f3069b + "' and longitude '" + this.f3070c + '\'';
    }
}
