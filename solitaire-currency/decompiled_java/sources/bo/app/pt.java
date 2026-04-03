package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class pt extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Exception f3660a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pt(Exception exc) {
        super(0);
        this.f3660a = exc;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Stream producer job cancelled " + this.f3660a;
    }
}
