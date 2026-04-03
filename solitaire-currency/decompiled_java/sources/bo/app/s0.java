package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3814a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(Class cls) {
        super(0);
        this.f3814a = cls;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to add synchronous subscriber for class: " + this.f3814a;
    }
}
