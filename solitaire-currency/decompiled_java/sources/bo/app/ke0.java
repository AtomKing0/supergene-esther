package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ke0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3246a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ke0(String str) {
        super(0);
        this.f3246a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Failed to store asset for remote path "), this.f3246a, ". Not storing local asset");
    }
}
