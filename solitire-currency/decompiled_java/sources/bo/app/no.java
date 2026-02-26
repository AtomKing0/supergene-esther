package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class no extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zo f3500a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public no(zo zoVar) {
        super(0);
        this.f3500a = zoVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Data flush interval is " + this.f3500a.f4462g + " ms. Not scheduling a proceeding data flush.";
    }
}
