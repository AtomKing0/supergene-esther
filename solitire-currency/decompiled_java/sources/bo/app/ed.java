package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ed extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Exception f2727a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ed(Exception exc) {
        super(0);
        this.f2727a = exc;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Exception occurred when attempting to retrieve local bitmap. " + this.f2727a.getMessage();
    }
}
