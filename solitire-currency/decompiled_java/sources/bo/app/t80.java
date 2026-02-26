package bo.app;

import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class t80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v80 f3904a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t80(v80 v80Var) {
        super(0);
        this.f3904a = v80Var;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Kicking off request framework sweeper job ");
        b2 b2Var = this.f3904a.f4087f;
        sb.append(b2Var != null ? Boolean.valueOf(b2Var.isActive()) : null);
        return sb.toString();
    }
}
