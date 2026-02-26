package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class n5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f3468a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n5(boolean z10) {
        super(0);
        this.f3468a = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to request geofence refresh with rate limit ignore: " + this.f3468a;
    }
}
