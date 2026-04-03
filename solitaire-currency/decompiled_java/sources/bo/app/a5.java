package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class a5 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f2350a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a5(Class cls) {
        super(0);
        this.f2350a = cls;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to remove " + this.f2350a.getName() + " subscriber.";
    }
}
