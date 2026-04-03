package u9;

import java.util.List;
import kotlinx.coroutines.n2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f34716a = true;

    private static final y a(Throwable th, String str) throws Throwable {
        if (f34716a) {
            return new y(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new v8.h();
    }

    static /* synthetic */ y b(Throwable th, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(@NotNull n2 n2Var) {
        return n2Var.getImmediate() instanceof y;
    }

    @NotNull
    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @NotNull
    public static final n2 e(@NotNull v vVar, @NotNull List<? extends v> list) {
        try {
            return vVar.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, vVar.hintOnError());
        }
    }
}
