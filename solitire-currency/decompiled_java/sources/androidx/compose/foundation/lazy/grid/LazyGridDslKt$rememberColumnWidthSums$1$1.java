package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridDsl.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridDslKt$rememberColumnWidthSums$1$1 extends v implements p<Density, Constraints, List<Integer>> {
    final /* synthetic */ GridCells $columns;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridDslKt$rememberColumnWidthSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$columns = gridCells;
        this.$horizontalArrangement = horizontal;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ List<Integer> mo4invoke(Density density, Constraints constraints) {
        return m558invoke0kLqBqw(density, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final List<Integer> m558invoke0kLqBqw(@NotNull Density density, long j10) {
        t.i(density, "$this$null");
        if (!(Constraints.m3641getMaxWidthimpl(j10) != Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
        }
        PaddingValues paddingValues = this.$contentPadding;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        List<Integer> listR0 = d0.R0(this.$columns.calculateCrossAxisCellSizes(density, Constraints.m3641getMaxWidthimpl(j10) - density.mo290roundToPx0680j_4(Dp.m3673constructorimpl(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) + PaddingKt.calculateEndPadding(this.$contentPadding, layoutDirection))), density.mo290roundToPx0680j_4(this.$horizontalArrangement.mo353getSpacingD9Ej5fM())));
        int size = listR0.size();
        for (int i10 = 1; i10 < size; i10++) {
            listR0.set(i10, Integer.valueOf(listR0.get(i10).intValue() + listR0.get(i10 - 1).intValue()));
        }
        return listR0;
    }
}
