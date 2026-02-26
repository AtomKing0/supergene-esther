package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SnapshotMutationPolicy.kt */
/* JADX INFO: loaded from: classes.dex */
final class NeverEqualPolicy implements SnapshotMutationPolicy<Object> {

    @NotNull
    public static final NeverEqualPolicy INSTANCE = new NeverEqualPolicy();

    private NeverEqualPolicy() {
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(@Nullable Object obj, @Nullable Object obj2) {
        return false;
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public /* synthetic */ Object merge(Object obj, Object obj2, Object obj3) {
        return d.a(this, obj, obj2, obj3);
    }

    @NotNull
    public String toString() {
        return "NeverEqualPolicy";
    }
}
