package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2340b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Object obj, boolean z10) {
        super(0);
        this.f2339a = obj;
        this.f2340b = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Tried to confirm outboundObject [" + this.f2339a + "] with success [" + this.f2340b + "], but the cache wasn't locked, so not doing anything.";
    }
}
