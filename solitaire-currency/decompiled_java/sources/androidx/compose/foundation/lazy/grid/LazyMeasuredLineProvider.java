package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.ui.unit.Constraints;
import h9.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyMeasuredLineProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyMeasuredLineProvider {

    @NotNull
    private final p<Integer, Integer, Constraints> childConstraints;
    private final int gridItemsCount;
    private final boolean isVertical;

    @NotNull
    private final LazyMeasuredItemProvider measuredItemProvider;

    @NotNull
    private final MeasuredLineFactory measuredLineFactory;
    private final int spaceBetweenLines;

    @NotNull
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyMeasuredLineProvider(boolean z10, @NotNull List<Integer> slotSizesSums, int i10, int i11, int i12, @NotNull LazyMeasuredItemProvider measuredItemProvider, @NotNull LazyGridSpanLayoutProvider spanLayoutProvider, @NotNull MeasuredLineFactory measuredLineFactory) {
        t.i(slotSizesSums, "slotSizesSums");
        t.i(measuredItemProvider, "measuredItemProvider");
        t.i(spanLayoutProvider, "spanLayoutProvider");
        t.i(measuredLineFactory, "measuredLineFactory");
        this.isVertical = z10;
        this.gridItemsCount = i11;
        this.spaceBetweenLines = i12;
        this.measuredItemProvider = measuredItemProvider;
        this.spanLayoutProvider = spanLayoutProvider;
        this.measuredLineFactory = measuredLineFactory;
        this.childConstraints = new LazyMeasuredLineProvider$childConstraints$1(slotSizesSums, i10, this);
    }

    @NotNull
    /* JADX INFO: renamed from: getAndMeasure-bKFJvoY, reason: not valid java name */
    public final LazyMeasuredLine m589getAndMeasurebKFJvoY(int i10) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(i10);
        int size = lineConfiguration.getSpans().size();
        int i11 = (size == 0 || lineConfiguration.getFirstItemIndex() + size == this.gridItemsCount) ? 0 : this.spaceBetweenLines;
        LazyMeasuredItem[] lazyMeasuredItemArr = new LazyMeasuredItem[size];
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            int iM535getCurrentLineSpanimpl = GridItemSpan.m535getCurrentLineSpanimpl(lineConfiguration.getSpans().get(i13).m538unboximpl());
            LazyMeasuredItem lazyMeasuredItemM587getAndMeasureednRnyU = this.measuredItemProvider.m587getAndMeasureednRnyU(ItemIndex.m541constructorimpl(lineConfiguration.getFirstItemIndex() + i13), i11, this.childConstraints.mo4invoke(Integer.valueOf(i12), Integer.valueOf(iM535getCurrentLineSpanimpl)).m3647unboximpl());
            i12 += iM535getCurrentLineSpanimpl;
            k0 k0Var = k0.f35197a;
            lazyMeasuredItemArr[i13] = lazyMeasuredItemM587getAndMeasureednRnyU;
        }
        return this.measuredLineFactory.mo570createLineH9FfpSk(i10, lazyMeasuredItemArr, lineConfiguration.getSpans(), i11);
    }

    @NotNull
    public final p<Integer, Integer, Constraints> getChildConstraints$foundation_release() {
        return this.childConstraints;
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.measuredItemProvider.getKeyToIndexMap();
    }
}
