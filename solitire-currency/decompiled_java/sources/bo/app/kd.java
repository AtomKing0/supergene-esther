package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class kd extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Exception f3243b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kd(String str, Exception exc) {
        super(0);
        this.f3242a = str;
        this.f3243b = exc;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Exception in image bitmap download for Uri: " + this.f3242a + ' ' + this.f3243b.getMessage();
    }
}
