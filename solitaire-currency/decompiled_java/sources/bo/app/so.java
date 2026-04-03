package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class so extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zo f3872b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public so(long j10, zo zoVar) {
        super(0);
        this.f3871a = j10;
        this.f3872b = zoVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Data flush interval has changed from " + this.f3871a + " ms to " + this.f3872b.f4462g + " ms after connectivity state change to: " + this.f3872b.f4465j + " and session state: " + fc0.a(this.f3872b.f4461f);
    }
}
