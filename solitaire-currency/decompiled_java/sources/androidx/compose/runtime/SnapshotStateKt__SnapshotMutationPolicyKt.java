package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SnapshotMutationPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__SnapshotMutationPolicyKt {
    @NotNull
    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return NeverEqualPolicy.INSTANCE;
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return ReferentialEqualityPolicy.INSTANCE;
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return StructuralEqualityPolicy.INSTANCE;
    }
}
