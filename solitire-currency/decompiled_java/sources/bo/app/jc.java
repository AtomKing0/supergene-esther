package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class jc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3147a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jc(long j10) {
        super(0);
        this.f3147a = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Ignoring rate limit for this geofence request. Elapsed time since last request:" + this.f3147a;
    }
}
