package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyLayoutPrefetchState.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public final class LazyLayoutPrefetchState {

    @NotNull
    private final MutableState prefetcher$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: compiled from: LazyLayoutPrefetchState.kt */
    public interface PrefetchHandle {
        void cancel();
    }

    /* JADX INFO: compiled from: LazyLayoutPrefetchState.kt */
    public interface Prefetcher {
        @NotNull
        /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
        PrefetchHandle mo610schedulePrefetch0kLqBqw(int i10, long j10);
    }

    @Nullable
    public final Prefetcher getPrefetcher$foundation_release() {
        return (Prefetcher) this.prefetcher$delegate.getValue();
    }

    @NotNull
    /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
    public final PrefetchHandle m609schedulePrefetch0kLqBqw(int i10, long j10) {
        PrefetchHandle prefetchHandleMo610schedulePrefetch0kLqBqw;
        Prefetcher prefetcher$foundation_release = getPrefetcher$foundation_release();
        return (prefetcher$foundation_release == null || (prefetchHandleMo610schedulePrefetch0kLqBqw = prefetcher$foundation_release.mo610schedulePrefetch0kLqBqw(i10, j10)) == null) ? DummyHandle.INSTANCE : prefetchHandleMo610schedulePrefetch0kLqBqw;
    }

    public final void setPrefetcher$foundation_release(@Nullable Prefetcher prefetcher) {
        this.prefetcher$delegate.setValue(prefetcher);
    }
}
