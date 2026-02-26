package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface DrawModifier extends Modifier.Element {

    /* JADX INFO: compiled from: DrawModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull DrawModifier drawModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(drawModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull DrawModifier drawModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(drawModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull DrawModifier drawModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(drawModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull DrawModifier drawModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(drawModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull DrawModifier drawModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(drawModifier, other);
        }
    }

    void draw(@NotNull ContentDrawScope contentDrawScope);
}
