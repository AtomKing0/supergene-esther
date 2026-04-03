package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class po extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zo f3639a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public po(zo zoVar) {
        super(0);
        this.f3639a = zoVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "recalculateDispatchState called with session state: " + fc0.a(this.f3639a.f4461f) + " lastNetworkLevel: " + this.f3639a.f4465j;
    }
}
