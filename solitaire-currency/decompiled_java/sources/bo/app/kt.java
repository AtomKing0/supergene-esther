package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class kt extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3282b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kt(String str, String str2) {
        super(0);
        this.f3281a = str;
        this.f3282b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Got event '");
        sb.append(this.f3281a);
        sb.append("' and data: '");
        return h1.a(sb, this.f3282b, '\'');
    }
}
