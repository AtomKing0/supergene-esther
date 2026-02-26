package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class nf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f3485a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nf0(k10 k10Var) {
        super(0);
        this.f3485a = k10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Trigger manager received reenqueue with action with id: <"), ((bh0) this.f3485a).f2452a, ">.");
    }
}
