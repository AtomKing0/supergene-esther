package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class b60 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2418a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b60(int i10) {
        super(0);
        this.f2418a = i10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "App Target API version of " + this.f2418a + " is too low to display push permission prompt.";
    }
}
