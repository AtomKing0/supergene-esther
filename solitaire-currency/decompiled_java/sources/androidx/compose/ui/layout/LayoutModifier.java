package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LayoutModifier extends Modifier.Element {

    /* JADX INFO: compiled from: LayoutModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull LayoutModifier layoutModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(layoutModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull LayoutModifier layoutModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(layoutModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull LayoutModifier layoutModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(layoutModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull LayoutModifier layoutModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(layoutModifier, r10, operation);
        }

        @Deprecated
        public static int maxIntrinsicHeight(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope receiver, @NotNull IntrinsicMeasurable measurable, int i10) {
            t.i(receiver, "receiver");
            t.i(measurable, "measurable");
            return c.a(layoutModifier, receiver, measurable, i10);
        }

        @Deprecated
        public static int maxIntrinsicWidth(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope receiver, @NotNull IntrinsicMeasurable measurable, int i10) {
            t.i(receiver, "receiver");
            t.i(measurable, "measurable");
            return c.b(layoutModifier, receiver, measurable, i10);
        }

        @Deprecated
        public static int minIntrinsicHeight(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope receiver, @NotNull IntrinsicMeasurable measurable, int i10) {
            t.i(receiver, "receiver");
            t.i(measurable, "measurable");
            return c.c(layoutModifier, receiver, measurable, i10);
        }

        @Deprecated
        public static int minIntrinsicWidth(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope receiver, @NotNull IntrinsicMeasurable measurable, int i10) {
            t.i(receiver, "receiver");
            t.i(measurable, "measurable");
            return c.d(layoutModifier, receiver, measurable, i10);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull LayoutModifier layoutModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(layoutModifier, other);
        }
    }

    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10);

    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10);

    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j10);

    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10);

    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i10);
}
