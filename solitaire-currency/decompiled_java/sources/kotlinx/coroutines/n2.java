package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainCoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class n2 extends k0 {
    @NotNull
    public abstract n2 getImmediate();

    @Override // kotlinx.coroutines.k0
    @NotNull
    public k0 limitedParallelism(int i10) {
        u9.p.a(i10);
        return this;
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        return s0.a(this) + '@' + s0.b(this);
    }

    @Nullable
    protected final String toStringInternalImpl() {
        n2 immediate;
        n2 n2VarC = e1.c();
        if (this == n2VarC) {
            return "Dispatchers.Main";
        }
        try {
            immediate = n2VarC.getImmediate();
        } catch (UnsupportedOperationException unused) {
            immediate = null;
        }
        if (this == immediate) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
