package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class nx extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ox f3525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3527c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nx(ox oxVar, int i10, int i11) {
        super(0);
        this.f3525a = oxVar;
        this.f3526b = i10;
        this.f3527c = i11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "New sleep duration: " + this.f3525a.f3591f + " ms. Default sleep duration: " + this.f3526b + " ms. Max sleep: " + this.f3525a.f3586a + " ms. Min sleep: " + this.f3525a.f3588c + " ms. Scale factor: " + this.f3525a.f3589d + " randomValueBetweenSleepIntervals: " + this.f3527c;
    }
}
