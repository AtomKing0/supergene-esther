package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class vs extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4135c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vs(boolean z10, String str, String str2) {
        super(0);
        this.f4133a = z10;
        this.f4134b = str;
        this.f4135c = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Starting (resume = " + this.f4133a + ") DUST subscription for mite: " + this.f4134b + " to url: " + this.f4135c;
    }
}
