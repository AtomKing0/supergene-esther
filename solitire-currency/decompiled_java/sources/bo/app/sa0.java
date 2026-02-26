package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class sa0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fb0 f3844a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sa0(fb0 fb0Var) {
        super(0);
        this.f3844a = fb0Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Banners enabled but maxBannerPlacement is " + this.f3844a.G + ". Not enabling banners.";
    }
}
