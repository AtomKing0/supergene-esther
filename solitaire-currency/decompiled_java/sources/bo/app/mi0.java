package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class mi0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3429a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mi0(int i10) {
        super(0);
        this.f3429a = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "The requested purchase quantity of " + this.f3429a + " is less than one. Invalid purchase";
    }
}
