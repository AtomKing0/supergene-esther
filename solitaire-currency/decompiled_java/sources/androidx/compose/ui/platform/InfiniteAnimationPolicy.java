package androidx.compose.ui.platform;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: InfiniteAnimationPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
public interface InfiniteAnimationPolicy extends g.b {

    @NotNull
    public static final Key Key = Key.$$INSTANCE;

    /* JADX INFO: compiled from: InfiniteAnimationPolicy.kt */
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy, R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> operation) {
            kotlin.jvm.internal.t.i(operation, "operation");
            return (R) g.b.a.a(infiniteAnimationPolicy, r10, operation);
        }

        @Nullable
        public static <E extends g.b> E get(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy, @NotNull g.c<E> key) {
            kotlin.jvm.internal.t.i(key, "key");
            return (E) g.b.a.b(infiniteAnimationPolicy, key);
        }

        @Deprecated
        @NotNull
        public static g.c<?> getKey(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy) {
            return u.a(infiniteAnimationPolicy);
        }

        @NotNull
        public static z8.g minusKey(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy, @NotNull g.c<?> key) {
            kotlin.jvm.internal.t.i(key, "key");
            return g.b.a.c(infiniteAnimationPolicy, key);
        }

        @NotNull
        public static z8.g plus(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy, @NotNull z8.g context) {
            kotlin.jvm.internal.t.i(context, "context");
            return g.b.a.d(infiniteAnimationPolicy, context);
        }
    }

    /* JADX INFO: compiled from: InfiniteAnimationPolicy.kt */
    public static final class Key implements g.c<InfiniteAnimationPolicy> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // z8.g.b, z8.g
    /* synthetic */ <R> R fold(R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar);

    @Override // z8.g.b, z8.g
    @Nullable
    /* synthetic */ <E extends g.b> E get(@NotNull g.c<E> cVar);

    @Override // z8.g.b
    @NotNull
    g.c<?> getKey();

    @Override // z8.g.b, z8.g
    @NotNull
    /* synthetic */ z8.g minusKey(@NotNull g.c<?> cVar);

    @Nullable
    <R> Object onInfiniteOperation(@NotNull h9.l<? super z8.d<? super R>, ? extends Object> lVar, @NotNull z8.d<? super R> dVar);

    @Override // z8.g
    @NotNull
    /* synthetic */ z8.g plus(@NotNull z8.g gVar);
}
