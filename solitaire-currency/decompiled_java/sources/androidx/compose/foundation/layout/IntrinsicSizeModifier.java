package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Intrinsic.kt */
/* JADX INFO: loaded from: classes.dex */
interface IntrinsicSizeModifier extends LayoutModifier {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.IntrinsicSizeModifier$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: Intrinsic.kt */
    public final /* synthetic */ class CC {
        public static boolean a(IntrinsicSizeModifier intrinsicSizeModifier) {
            return true;
        }

        public static int b(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
            t.i(intrinsicMeasureScope, "<this>");
            t.i(measurable, "measurable");
            return measurable.maxIntrinsicHeight(i10);
        }

        public static int c(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
            t.i(intrinsicMeasureScope, "<this>");
            t.i(measurable, "measurable");
            return measurable.maxIntrinsicWidth(i10);
        }

        @NotNull
        public static MeasureResult d(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
            t.i(measure, "$this$measure");
            t.i(measurable, "measurable");
            long jMo383calculateContentConstraintsl58MMJ0 = intrinsicSizeModifier.mo383calculateContentConstraintsl58MMJ0(measure, measurable, j10);
            if (intrinsicSizeModifier.getEnforceIncoming()) {
                jMo383calculateContentConstraintsl58MMJ0 = ConstraintsKt.m3653constrainN9IONVI(j10, jMo383calculateContentConstraintsl58MMJ0);
            }
            Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(jMo383calculateContentConstraintsl58MMJ0);
            return MeasureScope.CC.p(measure, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new IntrinsicSizeModifier$measure$1(placeableMo2987measureBRTryo0), 4, null);
        }

        public static int e(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
            t.i(intrinsicMeasureScope, "<this>");
            t.i(measurable, "measurable");
            return measurable.minIntrinsicHeight(i10);
        }

        public static int f(IntrinsicSizeModifier intrinsicSizeModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
            t.i(intrinsicMeasureScope, "<this>");
            t.i(measurable, "measurable");
            return measurable.minIntrinsicWidth(i10);
        }
    }

    /* JADX INFO: renamed from: calculateContentConstraints-l58MMJ0, reason: not valid java name */
    long mo383calculateContentConstraintsl58MMJ0(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j10);

    boolean getEnforceIncoming();

    @Override // androidx.compose.ui.layout.LayoutModifier
    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10);

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j10);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10);
}
