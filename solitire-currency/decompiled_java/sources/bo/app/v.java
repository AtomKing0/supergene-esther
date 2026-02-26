package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4064b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(String str, String str2) {
        super(0);
        this.f4063a = str;
        this.f4064b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Error while retrieving disk for key " + this.f4063a + " diskKey " + this.f4064b;
    }
}
