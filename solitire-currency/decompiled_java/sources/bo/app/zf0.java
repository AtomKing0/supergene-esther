package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class zf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f4437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4438b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zf0(k10 k10Var, long j10) {
        super(0);
        this.f4437a = k10Var;
        this.f4438b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Performing fallback triggered action with id: <" + ((bh0) this.f4437a).f2452a + "> with a delay: " + this.f4438b + " ms";
    }
}
