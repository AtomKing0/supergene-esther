package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class o20 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3536b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o20(String str, String str2) {
        super(0);
        this.f3535a = str;
        this.f3536b = str2;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Logged button click for button id: " + this.f3535a + " and trigger id: " + this.f3536b;
    }
}
