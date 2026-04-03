package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class hf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f2979a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hf0(bh0 bh0Var) {
        super(0);
        this.f2979a = bh0Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return h1.a(new StringBuilder("Found potential triggered action for incoming trigger event. Action id "), ((bh0) this.f2979a).f2452a, '.');
    }
}
