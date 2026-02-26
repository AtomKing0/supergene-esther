package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ei0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f2738a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei0(kotlin.jvm.internal.n0 n0Var) {
        super(0);
        this.f2738a = n0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h9.a
    public final Object invoke() {
        return "Provided string field is too long [" + ((String) this.f2738a.f29834a).length() + "]. The max length is 255, truncating provided field.";
    }
}
