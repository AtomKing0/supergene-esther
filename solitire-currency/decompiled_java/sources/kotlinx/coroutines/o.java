package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface o<T> extends z8.d<T> {

    /* JADX INFO: compiled from: CancellableContinuation.kt */
    public static final class a {
        public static /* synthetic */ boolean a(o oVar, Throwable th, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th = null;
            }
            return oVar.b(th);
        }
    }

    boolean b(@Nullable Throwable th);

    boolean i();

    boolean isActive();

    @Nullable
    Object j(@NotNull Throwable th);

    @Nullable
    Object k(T t10, @Nullable Object obj, @Nullable h9.l<? super Throwable, v8.k0> lVar);

    void l(T t10, @Nullable h9.l<? super Throwable, v8.k0> lVar);

    void m(@NotNull h9.l<? super Throwable, v8.k0> lVar);

    void o(@NotNull k0 k0Var, T t10);

    void u(@NotNull Object obj);
}
