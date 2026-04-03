package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class em extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2743b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public em(String str, String str2) {
        super(0);
        this.f2742a = str;
        this.f2743b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Detected SDK update from '");
        sb.append(this.f2742a);
        sb.append("' -> '");
        return d1.a(sb, this.f2743b, "'. Clearing config update time.");
    }
}
