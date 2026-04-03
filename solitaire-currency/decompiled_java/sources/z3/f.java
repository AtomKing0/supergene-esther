package z3;

import a4.o0;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: BaseDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f37386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<m0> f37387b = new ArrayList<>(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f37388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private o f37389d;

    protected f(boolean z10) {
        this.f37386a = z10;
    }

    @Override // z3.k
    public final void b(m0 m0Var) {
        a4.a.e(m0Var);
        if (this.f37387b.contains(m0Var)) {
            return;
        }
        this.f37387b.add(m0Var);
        this.f37388c++;
    }

    protected final void c(int i10) {
        o oVar = (o) o0.j(this.f37389d);
        for (int i11 = 0; i11 < this.f37388c; i11++) {
            this.f37387b.get(i11).b(this, oVar, this.f37386a, i10);
        }
    }

    protected final void d() {
        o oVar = (o) o0.j(this.f37389d);
        for (int i10 = 0; i10 < this.f37388c; i10++) {
            this.f37387b.get(i10).f(this, oVar, this.f37386a);
        }
        this.f37389d = null;
    }

    protected final void e(o oVar) {
        for (int i10 = 0; i10 < this.f37388c; i10++) {
            this.f37387b.get(i10).e(this, oVar, this.f37386a);
        }
    }

    protected final void f(o oVar) {
        this.f37389d = oVar;
        for (int i10 = 0; i10 < this.f37388c; i10++) {
            this.f37387b.get(i10).d(this, oVar, this.f37386a);
        }
    }

    @Override // z3.k
    public /* synthetic */ Map getResponseHeaders() {
        return j.a(this);
    }
}
