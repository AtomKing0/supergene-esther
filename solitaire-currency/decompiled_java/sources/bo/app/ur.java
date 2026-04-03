package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ur extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k90 f4037a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ur(k90 k90Var) {
        super(0);
        this.f4037a = k90Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Adding SDK Auth token to request '" + this.f4037a.f3233d.getString("auth_signature", null) + '\'';
    }
}
