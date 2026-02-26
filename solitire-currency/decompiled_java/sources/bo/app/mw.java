package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class mw extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3452a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mw(Class cls) {
        super(0);
        this.f3452a = cls;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not publishing cached event for class: " + this.f3452a + " because events are not allowed to send yet.";
    }
}
