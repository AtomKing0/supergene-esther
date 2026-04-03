package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class m90 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x90 f3400a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m90(x90 x90Var) {
        super(0);
        this.f3400a = x90Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Received SdkDebuggerConfigUpdateEvent. Updating SDK Debugger config with " + this.f3400a.f4255a;
    }
}
