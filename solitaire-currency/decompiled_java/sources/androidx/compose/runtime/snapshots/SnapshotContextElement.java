package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: SnapshotContextElement.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeApi
public interface SnapshotContextElement extends g.b {

    @NotNull
    public static final Key Key = Key.$$INSTANCE;

    /* JADX INFO: compiled from: SnapshotContextElement.kt */
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull SnapshotContextElement snapshotContextElement, R r10, @NotNull p<? super R, ? super g.b, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) g.b.a.a(snapshotContextElement, r10, operation);
        }

        @Nullable
        public static <E extends g.b> E get(@NotNull SnapshotContextElement snapshotContextElement, @NotNull g.c<E> key) {
            t.i(key, "key");
            return (E) g.b.a.b(snapshotContextElement, key);
        }

        @NotNull
        public static g minusKey(@NotNull SnapshotContextElement snapshotContextElement, @NotNull g.c<?> key) {
            t.i(key, "key");
            return g.b.a.c(snapshotContextElement, key);
        }

        @NotNull
        public static g plus(@NotNull SnapshotContextElement snapshotContextElement, @NotNull g context) {
            t.i(context, "context");
            return g.b.a.d(snapshotContextElement, context);
        }
    }

    /* JADX INFO: compiled from: SnapshotContextElement.kt */
    public static final class Key implements g.c<SnapshotContextElement> {
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
    /* synthetic */ g.c<?> getKey();

    @Override // z8.g.b, z8.g
    @NotNull
    /* synthetic */ g minusKey(@NotNull g.c<?> cVar);

    @Override // z8.g
    @NotNull
    /* synthetic */ g plus(@NotNull g gVar);
}
