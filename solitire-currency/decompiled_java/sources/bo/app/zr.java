package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class zr extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e00 f4474a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zr(e00 e00Var) {
        super(0);
        this.f4474a = e00Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Event dispatched: " + ((ba) this.f4474a).forJsonPut() + " with uid: " + ((ba) this.f4474a).f2434d;
    }
}
