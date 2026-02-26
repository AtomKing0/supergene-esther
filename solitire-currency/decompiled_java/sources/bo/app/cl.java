package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class cl extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xk f2576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2578c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl(xk xkVar, String str, Object obj) {
        super(0);
        this.f2576a = xkVar;
        this.f2577b = str;
        this.f2578c = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Unable to find the xml " + this.f2576a + " configuration value with primary key '" + this.f2577b + "'. Using default value '" + this.f2578c + "'.";
    }
}
