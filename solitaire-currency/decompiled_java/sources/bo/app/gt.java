package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class gt extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fu f2925a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt(fu fuVar) {
        super(0);
        this.f2925a = fuVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Got call to endStream(). Stream job: " + this.f2925a.f2843a;
    }
}
