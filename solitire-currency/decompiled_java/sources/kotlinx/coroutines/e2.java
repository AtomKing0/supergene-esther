package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
public class e2 extends j2 implements a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f29888c;

    public e2(@Nullable b2 b2Var) {
        super(true);
        k0(b2Var);
        this.f29888c = Q0();
    }

    private final boolean Q0() {
        j2 j2VarR;
        u uVarE0 = e0();
        v vVar = uVarE0 instanceof v ? (v) uVarE0 : null;
        if (vVar != null && (j2VarR = vVar.r()) != null) {
            while (!j2VarR.a0()) {
                u uVarE02 = j2VarR.e0();
                v vVar2 = uVarE02 instanceof v ? (v) uVarE02 : null;
                if (vVar2 == null || (j2VarR = vVar2.r()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.j2
    public boolean a0() {
        return this.f29888c;
    }

    @Override // kotlinx.coroutines.j2
    public boolean b0() {
        return true;
    }

    @Override // kotlinx.coroutines.a0
    public boolean c(@NotNull Throwable th) {
        return q0(new c0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.a0
    public boolean complete() {
        return q0(v8.k0.f35197a);
    }
}
