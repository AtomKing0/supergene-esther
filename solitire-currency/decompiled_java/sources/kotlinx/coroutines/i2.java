package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i2 extends e0 implements g1, v1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j2 f29906d;

    @Override // kotlinx.coroutines.v1
    @Nullable
    public o2 b() {
        return null;
    }

    @Override // kotlinx.coroutines.g1
    public void dispose() {
        r().D0(this);
    }

    @Override // kotlinx.coroutines.v1
    public boolean isActive() {
        return true;
    }

    @NotNull
    public final j2 r() {
        j2 j2Var = this.f29906d;
        if (j2Var != null) {
            return j2Var;
        }
        kotlin.jvm.internal.t.A("job");
        return null;
    }

    public final void s(@NotNull j2 j2Var) {
        this.f29906d = j2Var;
    }

    @Override // u9.s
    @NotNull
    public String toString() {
        return s0.a(this) + '@' + s0.b(this) + "[job@" + s0.b(r()) + ']';
    }
}
