package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OnPlacedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface OnPlacedModifier extends Modifier.Element {

    /* JADX INFO: compiled from: OnPlacedModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull OnPlacedModifier onPlacedModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(onPlacedModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull OnPlacedModifier onPlacedModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(onPlacedModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull OnPlacedModifier onPlacedModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(onPlacedModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull OnPlacedModifier onPlacedModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(onPlacedModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull OnPlacedModifier onPlacedModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(onPlacedModifier, other);
        }
    }

    void onPlaced(@NotNull LayoutCoordinates layoutCoordinates);
}
