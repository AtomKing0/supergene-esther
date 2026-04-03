package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3013b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(String str, String str2) {
        super(0);
        this.f3012a = str;
        this.f3013b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Changing current user ");
        sb.append(this.f3012a);
        sb.append(" to new user ");
        return h1.a(sb, this.f3013b, '.');
    }
}
