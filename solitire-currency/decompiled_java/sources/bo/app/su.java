package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class su extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uu f3876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3877b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su(long j10, uu uuVar) {
        super(0);
        this.f3876a = uuVar;
        this.f3877b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "New state after request success\n" + this.f3876a.c(this.f3877b);
    }
}
