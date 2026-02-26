package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ku extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uu f3283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3284b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ku(long j10, uu uuVar) {
        super(0);
        this.f3283a = uuVar;
        this.f3284b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Added request now to queue " + this.f3283a.c(this.f3284b);
    }
}
