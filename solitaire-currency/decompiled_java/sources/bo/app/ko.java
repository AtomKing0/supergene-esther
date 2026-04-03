package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ko extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zo f3276b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ko(long j10, zo zoVar) {
        super(0);
        this.f3275a = j10;
        this.f3276b = zoVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Kicking off the Sync Job. initialDelaysMs: " + this.f3275a + ": currentIntervalMs " + this.f3276b.f4462g + " ms";
    }
}
