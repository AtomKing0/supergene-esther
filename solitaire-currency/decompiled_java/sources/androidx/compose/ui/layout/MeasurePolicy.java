package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MeasurePolicy.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MeasurePolicy {

    /* JADX INFO: compiled from: MeasurePolicy.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static int maxIntrinsicHeight(@NotNull MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope receiver, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
            t.i(receiver, "receiver");
            t.i(measurables, "measurables");
            return d.a(measurePolicy, receiver, measurables, i10);
        }

        @Deprecated
        public static int maxIntrinsicWidth(@NotNull MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope receiver, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
            t.i(receiver, "receiver");
            t.i(measurables, "measurables");
            return d.b(measurePolicy, receiver, measurables, i10);
        }

        @Deprecated
        public static int minIntrinsicHeight(@NotNull MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope receiver, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
            t.i(receiver, "receiver");
            t.i(measurables, "measurables");
            return d.c(measurePolicy, receiver, measurables, i10);
        }

        @Deprecated
        public static int minIntrinsicWidth(@NotNull MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope receiver, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
            t.i(receiver, "receiver");
            t.i(measurables, "measurables");
            return d.d(measurePolicy, receiver, measurables, i10);
        }
    }

    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i10);

    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i10);

    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j10);

    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i10);

    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i10);
}
