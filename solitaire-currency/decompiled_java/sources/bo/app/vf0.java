package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class vf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k10 f4115a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vf0(k10 k10Var) {
        super(0);
        this.f4115a = k10Var;
    }

    @Override // h9.a
    public final Object invoke() {
        return d1.a(new StringBuilder("Trigger manager received failed triggered action with id: <"), ((bh0) this.f4115a).f2452a, ">. Will attempt to perform fallback triggered actions, if present.");
    }
}
