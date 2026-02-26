package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class tt extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fu f3970a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt(fu fuVar) {
        super(0);
        this.f3970a = fuVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not restarting stream since " + this.f3970a.f2843a + " is still active.";
    }
}
