package androidx.compose.runtime;

import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: MonotonicFrameClock.kt */
/* JADX INFO: loaded from: classes.dex */
public interface MonotonicFrameClock extends g.b {

    @NotNull
    public static final Key Key = Key.$$INSTANCE;

    /* JADX INFO: compiled from: MonotonicFrameClock.kt */
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull MonotonicFrameClock monotonicFrameClock, R r10, @NotNull p<? super R, ? super g.b, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) g.b.a.a(monotonicFrameClock, r10, operation);
        }

        @Nullable
        public static <E extends g.b> E get(@NotNull MonotonicFrameClock monotonicFrameClock, @NotNull g.c<E> key) {
            t.i(key, "key");
            return (E) g.b.a.b(monotonicFrameClock, key);
        }

        @Deprecated
        @NotNull
        public static g.c<?> getKey(@NotNull MonotonicFrameClock monotonicFrameClock) {
            return c.a(monotonicFrameClock);
        }

        @NotNull
        public static g minusKey(@NotNull MonotonicFrameClock monotonicFrameClock, @NotNull g.c<?> key) {
            t.i(key, "key");
            return g.b.a.c(monotonicFrameClock, key);
        }

        @NotNull
        public static g plus(@NotNull MonotonicFrameClock monotonicFrameClock, @NotNull g context) {
            t.i(context, "context");
            return g.b.a.d(monotonicFrameClock, context);
        }
    }

    /* JADX INFO: compiled from: MonotonicFrameClock.kt */
    public static final class Key implements g.c<MonotonicFrameClock> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // z8.g.b, z8.g
    /* synthetic */ <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> pVar);

    @Override // z8.g.b, z8.g
    @Nullable
    /* synthetic */ <E extends g.b> E get(@NotNull g.c<E> cVar);

    @Override // z8.g.b
    @NotNull
    g.c<?> getKey();

    @Override // z8.g.b, z8.g
    @NotNull
    /* synthetic */ g minusKey(@NotNull g.c<?> cVar);

    @Override // z8.g
    @NotNull
    /* synthetic */ g plus(@NotNull g gVar);

    @Nullable
    <R> Object withFrameNanos(@NotNull l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar);
}
