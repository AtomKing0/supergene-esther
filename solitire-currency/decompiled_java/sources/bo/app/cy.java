package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class cy extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gy f2608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f2609b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cy(gy gyVar, long j10) {
        super(0);
        this.f2608a = gyVar;
        this.f2609b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not enough time has passed since last Feature Flags refresh. Not refreshing Feature Flags. " + ((this.f2608a.f2935g.getLong("last_refresh", 0L) - this.f2609b) + ((long) this.f2608a.f2931c.h())) + " seconds remaining until next available flush.";
    }
}
