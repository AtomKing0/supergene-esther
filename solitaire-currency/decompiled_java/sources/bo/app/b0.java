package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2408a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(String str) {
        super(0);
        this.f2408a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Device build model matches a known crawler. Enabling mock network request mode. Device it: " + this.f2408a;
    }
}
