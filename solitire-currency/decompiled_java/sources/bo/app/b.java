package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2407a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        super(0);
        this.f2407a = fVar;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Notifying confirmAndUnlock listeners for cache: " + this.f2407a;
    }
}
