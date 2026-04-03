package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class o10 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3533a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o10(int i10) {
        super(0);
        this.f3533a = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Requested in-app message duration " + this.f3533a + " is lower than the minimum of 999. Defaulting to 5000 milliseconds.";
    }
}
