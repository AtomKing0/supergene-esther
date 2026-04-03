package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class xh extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w40 f4272a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xh(w40 w40Var) {
        super(0);
        this.f4272a = w40Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Session [" + this.f4272a.f4421a + "] being sealed because its end time is over the grace period. Session: " + this.f4272a;
    }
}
