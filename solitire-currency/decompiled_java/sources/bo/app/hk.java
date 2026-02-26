package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class hk extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ double f2986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f2987b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk(double d10, double d11) {
        super(0);
        this.f2986a = d10;
        this.f2987b = d11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Cannot set custom location attribute due with invalid latitude '" + this.f2986a + " and longitude '" + this.f2987b + '\'';
    }
}
