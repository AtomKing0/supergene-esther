package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class nt extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3522b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nt(String str, String str2) {
        super(0);
        this.f3521a = str;
        this.f3522b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Not handling event: '");
        sb.append(this.f3521a);
        sb.append("' and data: '");
        return h1.a(sb, this.f3522b, '\'');
    }
}
