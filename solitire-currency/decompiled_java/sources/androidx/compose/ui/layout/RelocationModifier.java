package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RelocationModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
public interface RelocationModifier extends Modifier.Element {

    /* JADX INFO: compiled from: RelocationModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull RelocationModifier relocationModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(relocationModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull RelocationModifier relocationModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(relocationModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull RelocationModifier relocationModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(relocationModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull RelocationModifier relocationModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(relocationModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull RelocationModifier relocationModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(relocationModifier, other);
        }
    }

    @NotNull
    Rect computeDestination(@NotNull Rect rect, @NotNull LayoutCoordinates layoutCoordinates);

    @Nullable
    Object performRelocation(@NotNull Rect rect, @NotNull Rect rect2, @NotNull z8.d<? super k0> dVar);
}
