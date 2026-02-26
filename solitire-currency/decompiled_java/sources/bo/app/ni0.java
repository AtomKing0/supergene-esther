package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ni0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3492a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ni0(int i10) {
        super(0);
        this.f3492a = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "The requested purchase quantity of " + this.f3492a + " is greater than the maximum of 100";
    }
}
