package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class wg extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b90 f4206a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wg(b90 b90Var) {
        super(0);
        this.f4206a = b90Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Could not parse request parameters for POST request to " + this.f4206a + ", cancelling request.";
    }
}
