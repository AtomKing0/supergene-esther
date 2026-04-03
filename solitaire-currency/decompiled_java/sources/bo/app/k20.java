package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class k20 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3204a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k20(String str) {
        super(0);
        this.f3204a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Trigger id not found (this is expected for test sends). Not logging html in-app message button click for id: " + this.f3204a;
    }
}
