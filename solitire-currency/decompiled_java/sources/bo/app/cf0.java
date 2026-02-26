package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class cf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f2510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f2511c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf0(long j10, long j11, long j12) {
        super(0);
        this.f2509a = j10;
        this.f2510b = j11;
        this.f2511c = j12;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Minimum time interval requirement and triggered action override time interval requirement of " + this.f2509a + " not met for matched trigger. Returning null. Next viable display time: " + this.f2510b + ". Action display time: " + this.f2511c;
    }
}
