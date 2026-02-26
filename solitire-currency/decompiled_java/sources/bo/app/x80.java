package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class x80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z80 f4251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a90 f4252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4253c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x80(z80 z80Var, a90 a90Var, long j10) {
        super(0);
        this.f4251a = z80Var;
        this.f4252b = a90Var;
        this.f4253c = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Moving from " + this.f4251a.f4413d + " -> " + this.f4252b + " with time " + this.f4253c + " for \n" + this.f4251a.a(this.f4253c);
    }
}
