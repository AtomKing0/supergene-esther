package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ow extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3584b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow(Class cls, Object obj) {
        super(0);
        this.f3583a = cls;
        this.f3584b = obj;
    }

    @Override // h9.a
    public final Object invoke() {
        return "SDK is disabled. Not publishing event class: " + this.f3583a.getName() + " and message: " + this.f3584b;
    }
}
