package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ae0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2373b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae0(String str, String str2) {
        super(0);
        this.f2372a = str;
        this.f2373b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Retrieving trigger local asset path '");
        sb.append(this.f2372a);
        sb.append("' from local storage for remote path '");
        return h1.a(sb, this.f2373b, '\'');
    }
}
