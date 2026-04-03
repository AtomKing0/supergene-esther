package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class zs extends kotlin.coroutines.jvm.internal.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fu f4475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kotlinx.coroutines.o0 f4476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r9.t f4477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h9.l f4478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kotlin.jvm.internal.n0 f4479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public kotlin.jvm.internal.n0 f4480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f4481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ fu f4482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4483i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zs(fu fuVar, z8.d dVar) {
        super(dVar);
        this.f4482h = fuVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.f4481g = obj;
        this.f4483i |= Integer.MIN_VALUE;
        return fu.a(this.f4482h, null, null, null, this);
    }
}
