package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class xd0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4265b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xd0(String str, String str2) {
        super(0);
        this.f4264a = str;
        this.f4265b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Removing obsolete local path ");
        sb.append(this.f4264a);
        sb.append(" for obsolete remote path ");
        return d1.a(sb, this.f4265b, " from cache.");
    }
}
