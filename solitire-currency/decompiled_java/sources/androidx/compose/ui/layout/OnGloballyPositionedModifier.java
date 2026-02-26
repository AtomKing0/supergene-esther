package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OnGloballyPositionedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface OnGloballyPositionedModifier extends Modifier.Element {

    /* JADX INFO: compiled from: OnGloballyPositionedModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(onGloballyPositionedModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(onGloballyPositionedModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(onGloballyPositionedModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(onGloballyPositionedModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(onGloballyPositionedModifier, other);
        }
    }

    void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates);
}
