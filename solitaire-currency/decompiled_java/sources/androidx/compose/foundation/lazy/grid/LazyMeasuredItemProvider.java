package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyMeasuredItemProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyMeasuredItemProvider {
    private final int defaultMainAxisSpacing;

    @NotNull
    private final LazyGridItemProvider itemProvider;

    @NotNull
    private final LazyLayoutMeasureScope measureScope;

    @NotNull
    private final MeasuredItemFactory measuredItemFactory;

    @ExperimentalFoundationApi
    public LazyMeasuredItemProvider(@NotNull LazyGridItemProvider itemProvider, @NotNull LazyLayoutMeasureScope measureScope, int i10, @NotNull MeasuredItemFactory measuredItemFactory) {
        t.i(itemProvider, "itemProvider");
        t.i(measureScope, "measureScope");
        t.i(measuredItemFactory, "measuredItemFactory");
        this.itemProvider = itemProvider;
        this.measureScope = measureScope;
        this.defaultMainAxisSpacing = i10;
        this.measuredItemFactory = measuredItemFactory;
    }

    /* JADX INFO: renamed from: getAndMeasure-ednRnyU$default, reason: not valid java name */
    public static /* synthetic */ LazyMeasuredItem m586getAndMeasureednRnyU$default(LazyMeasuredItemProvider lazyMeasuredItemProvider, int i10, int i11, long j10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = lazyMeasuredItemProvider.defaultMainAxisSpacing;
        }
        return lazyMeasuredItemProvider.m587getAndMeasureednRnyU(i10, i11, j10);
    }

    @NotNull
    /* JADX INFO: renamed from: getAndMeasure-ednRnyU, reason: not valid java name */
    public final LazyMeasuredItem m587getAndMeasureednRnyU(int i10, int i11, long j10) {
        int iM3642getMinHeightimpl;
        Object key = this.itemProvider.getKey(i10);
        Placeable[] placeableArrMo608measure0kLqBqw = this.measureScope.mo608measure0kLqBqw(i10, j10);
        if (Constraints.m3639getHasFixedWidthimpl(j10)) {
            iM3642getMinHeightimpl = Constraints.m3643getMinWidthimpl(j10);
        } else {
            if (!Constraints.m3638getHasFixedHeightimpl(j10)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            iM3642getMinHeightimpl = Constraints.m3642getMinHeightimpl(j10);
        }
        return this.measuredItemFactory.mo569createItemPU_OBEw(i10, key, iM3642getMinHeightimpl, i11, placeableArrMo608measure0kLqBqw);
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.itemProvider.getKeyToIndexMap();
    }
}
