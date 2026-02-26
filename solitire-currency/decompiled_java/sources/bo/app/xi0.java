package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class xi0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4278b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xi0(String str, String str2) {
        super(0);
        this.f4277a = str;
        this.f4278b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Replacing remote url \"");
        sb.append(this.f4277a);
        sb.append("\" with local uri \"");
        return h1.a(sb, this.f4278b, '\"');
    }
}
