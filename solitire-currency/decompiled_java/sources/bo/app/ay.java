package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ay extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gy f2405a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(gy gyVar) {
        super(0);
        this.f2405a = gyVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not refreshing Feature Flags since another " + this.f2405a.f2938j.get() + " request is currently in-flight.";
    }
}
