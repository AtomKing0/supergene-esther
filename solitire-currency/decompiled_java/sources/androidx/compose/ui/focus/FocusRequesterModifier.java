package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusRequesterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface FocusRequesterModifier extends Modifier.Element {

    /* JADX INFO: compiled from: FocusRequesterModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull FocusRequesterModifier focusRequesterModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(focusRequesterModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull FocusRequesterModifier focusRequesterModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(focusRequesterModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull FocusRequesterModifier focusRequesterModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(focusRequesterModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull FocusRequesterModifier focusRequesterModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(focusRequesterModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull FocusRequesterModifier focusRequesterModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(focusRequesterModifier, other);
        }
    }

    @NotNull
    FocusRequester getFocusRequester();
}
