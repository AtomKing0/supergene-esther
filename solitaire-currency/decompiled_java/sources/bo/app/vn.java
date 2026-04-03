package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class vn extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4128a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vn(String str) {
        super(0);
        this.f4128a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return h1.a(new StringBuilder("Custom attribute key cannot be blocklisted attribute: "), this.f4128a, '.');
    }
}
