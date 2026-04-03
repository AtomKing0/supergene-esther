package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import h9.p;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridDsl.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridDslKt$rememberRowHeightSums$1$1 extends v implements p<Density, Constraints, List<Integer>> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ GridCells $rows;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Vertical vertical) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$rows = gridCells;
        this.$verticalArrangement = vertical;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ List<Integer> mo4invoke(Density density, Constraints constraints) {
        return m559invoke0kLqBqw(density, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final List<Integer> m559invoke0kLqBqw(@NotNull Density density, long j10) {
        t.i(density, "$this$null");
        if (!(Constraints.m3640getMaxHeightimpl(j10) != Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
        }
        List<Integer> listR0 = d0.R0(this.$rows.calculateCrossAxisCellSizes(density, Constraints.m3640getMaxHeightimpl(j10) - density.mo290roundToPx0680j_4(Dp.m3673constructorimpl(this.$contentPadding.mo382calculateTopPaddingD9Ej5fM() + this.$contentPadding.mo379calculateBottomPaddingD9Ej5fM())), density.mo290roundToPx0680j_4(this.$verticalArrangement.mo353getSpacingD9Ej5fM())));
        int size = listR0.size();
        for (int i10 = 1; i10 < size; i10++) {
            listR0.set(i10, Integer.valueOf(listR0.get(i10).intValue() + listR0.get(i10 - 1).intValue()));
        }
        return listR0;
    }
}
