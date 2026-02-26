package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3673b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(String str, String str2) {
        super(0);
        this.f3672a = str;
        this.f3673b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Cannot add null or blank card json to storage. Returning. User id: " + this.f3672a + " Serialized json: " + this.f3673b;
    }
}
