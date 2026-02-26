package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ev extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e00 f2753a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ev(e00 e00Var) {
        super(0);
        this.f2753a = e00Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Event already seen in cache. Ignoring duplicate: " + this.f2753a;
    }
}
