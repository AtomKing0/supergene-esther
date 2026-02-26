package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class vi extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4120b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vi(String str, Object obj) {
        super(0);
        this.f4119a = str;
        this.f4120b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Could not add unsupported custom attribute value with key: " + this.f4119a + " and value: " + this.f4120b;
    }
}
