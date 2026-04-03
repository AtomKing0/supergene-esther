package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PointerInputModifier extends Modifier.Element {

    /* JADX INFO: compiled from: PointerEvent.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull PointerInputModifier pointerInputModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(pointerInputModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull PointerInputModifier pointerInputModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(pointerInputModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull PointerInputModifier pointerInputModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(pointerInputModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull PointerInputModifier pointerInputModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(pointerInputModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull PointerInputModifier pointerInputModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(pointerInputModifier, other);
        }
    }

    @NotNull
    PointerInputFilter getPointerInputFilter();
}
