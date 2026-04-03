package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyListMeasureResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListMeasureResult implements LazyListLayoutInfo, MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final boolean canScrollForward;
    private final float consumedScroll;

    @Nullable
    private final LazyMeasuredItem firstVisibleItem;
    private final int firstVisibleItemScrollOffset;

    @NotNull
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;

    @NotNull
    private final List<LazyListItemInfo> visibleItemsInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyListMeasureResult(@Nullable LazyMeasuredItem lazyMeasuredItem, int i10, boolean z10, float f10, @NotNull MeasureResult measureResult, @NotNull List<? extends LazyListItemInfo> visibleItemsInfo, int i11, int i12, int i13, boolean z11, @NotNull Orientation orientation, int i14) {
        t.i(measureResult, "measureResult");
        t.i(visibleItemsInfo, "visibleItemsInfo");
        t.i(orientation, "orientation");
        this.firstVisibleItem = lazyMeasuredItem;
        this.firstVisibleItemScrollOffset = i10;
        this.canScrollForward = z10;
        this.consumedScroll = f10;
        this.visibleItemsInfo = visibleItemsInfo;
        this.viewportStartOffset = i11;
        this.viewportEndOffset = i12;
        this.totalItemsCount = i13;
        this.reverseLayout = z11;
        this.orientation = orientation;
        this.afterContentPadding = i14;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    @NotNull
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    @Nullable
    public final LazyMeasuredItem getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.firstVisibleItemScrollOffset;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    @NotNull
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    public long mo497getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    @NotNull
    public List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }
}
