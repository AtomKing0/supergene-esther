package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class kc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rc f3240b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kc(long j10, rc rcVar) {
        super(0);
        this.f3239a = j10;
        this.f3240b = rcVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return this.f3239a + " seconds have passed since the last time geofences were requested (minimum interval: " + this.f3240b.f3769g + ").";
    }
}
