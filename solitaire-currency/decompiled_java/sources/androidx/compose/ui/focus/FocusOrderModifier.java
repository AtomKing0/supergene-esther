package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusOrderModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface FocusOrderModifier extends Modifier.Element {

    /* JADX INFO: compiled from: FocusOrderModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull FocusOrderModifier focusOrderModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(focusOrderModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull FocusOrderModifier focusOrderModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(focusOrderModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull FocusOrderModifier focusOrderModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(focusOrderModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull FocusOrderModifier focusOrderModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(focusOrderModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull FocusOrderModifier focusOrderModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(focusOrderModifier, other);
        }
    }

    void populateFocusOrder(@NotNull FocusOrder focusOrder);
}
