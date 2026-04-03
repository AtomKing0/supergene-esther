package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SnapshotMutationPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SnapshotMutationPolicy<T> {

    /* JADX INFO: compiled from: SnapshotMutationPolicy.kt */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static <T> T merge(@NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy, T t10, T t11, T t12) {
            return (T) d.a(snapshotMutationPolicy, t10, t11, t12);
        }
    }

    boolean equivalent(T t10, T t11);

    @Nullable
    T merge(T t10, T t11, T t12);
}
