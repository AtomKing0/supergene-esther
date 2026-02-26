package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ht extends kotlin.coroutines.jvm.internal.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fu f3000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fu f3002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3003d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ht(fu fuVar, z8.d dVar) {
        super(dVar);
        this.f3002c = fuVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        this.f3001b = obj;
        this.f3003d |= Integer.MIN_VALUE;
        return fu.a(this.f3002c, this);
    }
}
