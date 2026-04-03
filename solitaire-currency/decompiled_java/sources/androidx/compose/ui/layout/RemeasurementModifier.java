package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RemeasurementModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RemeasurementModifier extends Modifier.Element {

    /* JADX INFO: compiled from: RemeasurementModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull RemeasurementModifier remeasurementModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(remeasurementModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull RemeasurementModifier remeasurementModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(remeasurementModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull RemeasurementModifier remeasurementModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(remeasurementModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull RemeasurementModifier remeasurementModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(remeasurementModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull RemeasurementModifier remeasurementModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(remeasurementModifier, other);
        }
    }

    void onRemeasurementAvailable(@NotNull Remeasurement remeasurement);
}
