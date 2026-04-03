package r9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface u<E> {

    /* JADX INFO: compiled from: Channel.kt */
    public static final class a {
        public static /* synthetic */ boolean a(u uVar, Throwable th, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i10 & 1) != 0) {
                th = null;
            }
            return uVar.d(th);
        }
    }

    boolean d(@Nullable Throwable th);

    @NotNull
    Object f(E e10);

    void g(@NotNull h9.l<? super Throwable, k0> lVar);

    @Nullable
    Object p(E e10, @NotNull z8.d<? super k0> dVar);

    boolean t();
}
