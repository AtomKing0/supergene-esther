package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2697a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(String str) {
        super(0);
        this.f2697a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Received request to change current user "), this.f2697a, " to the same user id. Not changing user.");
    }
}
