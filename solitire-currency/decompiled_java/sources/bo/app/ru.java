package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ru extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uu f3805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3806b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ru(long j10, uu uuVar) {
        super(0);
        this.f3805a = uuVar;
        this.f3806b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "New state after request error " + this.f3805a.c(this.f3806b);
    }
}
