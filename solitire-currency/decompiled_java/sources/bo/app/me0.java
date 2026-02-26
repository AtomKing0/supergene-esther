package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class me0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3415b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public me0(String str, String str2) {
        super(0);
        this.f3414a = str;
        this.f3415b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Found local asset at path " + this.f3414a + " for remote asset at path: " + this.f3415b;
    }
}
