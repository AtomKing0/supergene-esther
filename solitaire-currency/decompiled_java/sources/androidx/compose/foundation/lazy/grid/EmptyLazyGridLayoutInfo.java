package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.collections.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridState.kt */
/* JADX INFO: loaded from: classes.dex */
final class EmptyLazyGridLayoutInfo implements LazyGridLayoutInfo {
    private static final int afterContentPadding = 0;
    private static final int beforeContentPadding = 0;
    private static final boolean reverseLayout = false;
    private static final int totalItemsCount = 0;
    private static final int viewportEndOffset = 0;
    private static final int viewportStartOffset = 0;

    @NotNull
    public static final EmptyLazyGridLayoutInfo INSTANCE = new EmptyLazyGridLayoutInfo();

    @NotNull
    private static final List<LazyGridItemInfo> visibleItemsInfo = v.l();
    private static final long viewportSize = IntSize.Companion.m3838getZeroYbymL2g();

    @NotNull
    private static final Orientation orientation = Orientation.Vertical;

    private EmptyLazyGridLayoutInfo() {
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getAfterContentPadding() {
        return afterContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getBeforeContentPadding() {
        return beforeContentPadding;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    @NotNull
    public Orientation getOrientation() {
        return orientation;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public boolean getReverseLayout() {
        return reverseLayout;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportEndOffset() {
        return viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    public long mo530getViewportSizeYbymL2g() {
        return viewportSize;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    public int getViewportStartOffset() {
        return viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
    @NotNull
    public List<LazyGridItemInfo> getVisibleItemsInfo() {
        return visibleItemsInfo;
    }
}
