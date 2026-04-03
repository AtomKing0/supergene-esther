package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Exception f2940a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Exception exc) {
        super(0);
        this.f2940a = exc;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Manifest not authored properly to support ADM. ADM manifest exception: " + this.f2940a;
    }
}
