package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class qd0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3704b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qd0(int i10, int i11) {
        super(0);
        this.f3703a = i10;
        this.f3704b = i11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "TokenBucketRateLimiter updated with new capacity: " + this.f3703a + " and refill rate: " + this.f3704b;
    }
}
