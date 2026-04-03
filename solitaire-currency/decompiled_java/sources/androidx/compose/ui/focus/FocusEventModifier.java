package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusEventModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface FocusEventModifier extends Modifier.Element {

    /* JADX INFO: compiled from: FocusEventModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull FocusEventModifier focusEventModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(focusEventModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull FocusEventModifier focusEventModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(focusEventModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull FocusEventModifier focusEventModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(focusEventModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull FocusEventModifier focusEventModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(focusEventModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull FocusEventModifier focusEventModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(focusEventModifier, other);
        }
    }

    void onFocusEvent(@NotNull FocusState focusState);
}
