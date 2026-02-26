package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.b;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SemanticsModifier extends Modifier.Element {

    /* JADX INFO: compiled from: SemanticsModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull SemanticsModifier semanticsModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return b.a(semanticsModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull SemanticsModifier semanticsModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return b.b(semanticsModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull SemanticsModifier semanticsModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) b.c(semanticsModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull SemanticsModifier semanticsModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) b.d(semanticsModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull SemanticsModifier semanticsModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(semanticsModifier, other);
        }
    }

    int getId();

    @NotNull
    SemanticsConfiguration getSemanticsConfiguration();
}
