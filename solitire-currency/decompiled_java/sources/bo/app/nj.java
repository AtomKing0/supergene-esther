package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class nj extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3493a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nj(String str) {
        super(0);
        this.f3493a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Email address is not valid: " + this.f3493a;
    }
}
