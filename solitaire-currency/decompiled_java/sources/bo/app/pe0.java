package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class pe0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3625b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pe0(String str, String str2) {
        super(0);
        this.f3624a = str;
        this.f3625b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Adding new local path '");
        sb.append(this.f3624a);
        sb.append("' for remote path '");
        return d1.a(sb, this.f3625b, "' to cache.");
    }
}
