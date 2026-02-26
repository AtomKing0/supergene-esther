package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class pw extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3666a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pw(Class cls) {
        super(0);
        this.f3666a = cls;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not publishing null message to event class ".concat(this.f3666a.getName());
    }
}
