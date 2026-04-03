package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AlignmentLine.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AlignmentLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m324alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, AlignmentLine alignmentLine, float f10, float f11, Measurable measurable, long j10) {
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m3632copyZbe2FdA$default(j10, 0, 0, 0, 0, 11, null) : Constraints.m3632copyZbe2FdA$default(j10, 0, 0, 0, 0, 14, null));
        int i10 = placeableMo2987measureBRTryo0.get(alignmentLine);
        if (i10 == Integer.MIN_VALUE) {
            i10 = 0;
        }
        int height = getHorizontal(alignmentLine) ? placeableMo2987measureBRTryo0.getHeight() : placeableMo2987measureBRTryo0.getWidth();
        int iM3640getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m3640getMaxHeightimpl(j10) : Constraints.m3641getMaxWidthimpl(j10);
        Dp.Companion companion = Dp.Companion;
        int i11 = iM3640getMaxHeightimpl - height;
        int iN = n9.o.n((!Dp.m3678equalsimpl0(f10, companion.m3693getUnspecifiedD9Ej5fM()) ? measureScope.mo290roundToPx0680j_4(f10) : 0) - i10, 0, i11);
        int iN2 = n9.o.n(((!Dp.m3678equalsimpl0(f11, companion.m3693getUnspecifiedD9Ej5fM()) ? measureScope.mo290roundToPx0680j_4(f11) : 0) - height) + i10, 0, i11 - iN);
        int width = getHorizontal(alignmentLine) ? placeableMo2987measureBRTryo0.getWidth() : Math.max(placeableMo2987measureBRTryo0.getWidth() + iN + iN2, Constraints.m3643getMinWidthimpl(j10));
        int iMax = getHorizontal(alignmentLine) ? Math.max(placeableMo2987measureBRTryo0.getHeight() + iN + iN2, Constraints.m3642getMinHeightimpl(j10)) : placeableMo2987measureBRTryo0.getHeight();
        return MeasureScope.CC.p(measureScope, width, iMax, null, new AlignmentLineKt$alignmentLineOffsetMeasure$1(alignmentLine, f10, iN, width, iN2, placeableMo2987measureBRTryo0, iMax), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m325paddingFrom4j6BHR0(@NotNull Modifier paddingFrom, @NotNull AlignmentLine alignmentLine, float f10, float f11) {
        t.i(paddingFrom, "$this$paddingFrom");
        t.i(alignmentLine, "alignmentLine");
        return paddingFrom.then(new AlignmentLineOffsetDp(alignmentLine, f10, f11, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1(alignmentLine, f10, f11) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m326paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 4) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m325paddingFrom4j6BHR0(modifier, alignmentLine, f10, f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m327paddingFromY_r0B1c(@NotNull Modifier paddingFrom, @NotNull AlignmentLine alignmentLine, long j10, long j11) {
        t.i(paddingFrom, "$this$paddingFrom");
        t.i(alignmentLine, "alignmentLine");
        return paddingFrom.then(new AlignmentLineOffsetTextUnit(alignmentLine, j10, j11, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFromY_r0B1c$$inlined$debugInspectorInfo$1(alignmentLine, j10, j11) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m328paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = TextUnit.Companion.m3865getUnspecifiedXSAIIZE();
        }
        long j12 = j10;
        if ((i10 & 4) != 0) {
            j11 = TextUnit.Companion.m3865getUnspecifiedXSAIIZE();
        }
        return m327paddingFromY_r0B1c(modifier, alignmentLine, j12, j11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m329paddingFromBaselineVpY3zN4(@NotNull Modifier paddingFromBaseline, float f10, float f11) {
        t.i(paddingFromBaseline, "$this$paddingFromBaseline");
        Dp.Companion companion = Dp.Companion;
        return paddingFromBaseline.then(!Dp.m3678equalsimpl0(f11, companion.m3693getUnspecifiedD9Ej5fM()) ? m326paddingFrom4j6BHR0$default(paddingFromBaseline, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f11, 2, null) : Modifier.Companion).then(!Dp.m3678equalsimpl0(f10, companion.m3693getUnspecifiedD9Ej5fM()) ? m326paddingFrom4j6BHR0$default(paddingFromBaseline, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f10, 0.0f, 4, null) : Modifier.Companion);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m330paddingFromBaselineVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        return m329paddingFromBaselineVpY3zN4(modifier, f10, f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m331paddingFromBaselinewCyjxdI(@NotNull Modifier paddingFromBaseline, long j10, long j11) {
        t.i(paddingFromBaseline, "$this$paddingFromBaseline");
        return paddingFromBaseline.then(!TextUnitKt.m3872isUnspecifiedR2X_6o(j11) ? m328paddingFromY_r0B1c$default(paddingFromBaseline, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j11, 2, null) : Modifier.Companion).then(!TextUnitKt.m3872isUnspecifiedR2X_6o(j10) ? m328paddingFromY_r0B1c$default(paddingFromBaseline, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j10, 0L, 4, null) : Modifier.Companion);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m332paddingFromBaselinewCyjxdI$default(Modifier modifier, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = TextUnit.Companion.m3865getUnspecifiedXSAIIZE();
        }
        if ((i10 & 2) != 0) {
            j11 = TextUnit.Companion.m3865getUnspecifiedXSAIIZE();
        }
        return m331paddingFromBaselinewCyjxdI(modifier, j10, j11);
    }
}
