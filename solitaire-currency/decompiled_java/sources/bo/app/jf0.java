package bo.app;

import com.braze.support.JsonUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class jf0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g10 f3156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.n0 f3157b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jf0(g10 g10Var, kotlin.jvm.internal.n0 n0Var) {
        super(0);
        this.f3156a = g10Var;
        this.f3157b = n0Var;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("\n     Found best triggered action for incoming trigger event ");
        e00 e00Var = ((we0) this.f3156a).f4203c;
        sb.append(e00Var != null ? JsonUtils.getPrettyPrintedString(((ba) e00Var).forJsonPut()) : "");
        sb.append(".\n     Matched Action id: ");
        sb.append(((bh0) ((k10) this.f3157b.f29834a)).f2452a);
        sb.append(".\n                ");
        return p9.j.f(sb.toString());
    }
}
