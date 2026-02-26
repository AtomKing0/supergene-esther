package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class bf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f2448b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf0(long j10, long j11) {
        super(0);
        this.f2447a = j10;
        this.f2448b = j11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Minimum time interval requirement met for matched trigger. Action display time: " + this.f2447a + " . Next viable display time: " + this.f2448b;
    }
}
