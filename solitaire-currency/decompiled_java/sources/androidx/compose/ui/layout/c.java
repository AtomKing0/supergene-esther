package androidx.compose.ui.layout;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c {
    public static int a(LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.maxHeight$ui_release(layoutModifier, intrinsicMeasureScope, measurable, i10);
    }

    public static int b(LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.maxWidth$ui_release(layoutModifier, intrinsicMeasureScope, measurable, i10);
    }

    public static int c(LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.minHeight$ui_release(layoutModifier, intrinsicMeasureScope, measurable, i10);
    }

    public static int d(LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable measurable, int i10) {
        t.i(intrinsicMeasureScope, "<this>");
        t.i(measurable, "measurable");
        return MeasuringIntrinsics.INSTANCE.minWidth$ui_release(layoutModifier, intrinsicMeasureScope, measurable, i10);
    }
}
