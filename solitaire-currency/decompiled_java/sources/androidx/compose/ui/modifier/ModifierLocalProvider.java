package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ModifierLocalProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface ModifierLocalProvider<T> extends Modifier.Element {

    /* JADX INFO: compiled from: ModifierLocalProvider.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> boolean all(@NotNull ModifierLocalProvider<T> modifierLocalProvider, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(modifierLocalProvider, predicate);
        }

        @Deprecated
        public static <T> boolean any(@NotNull ModifierLocalProvider<T> modifierLocalProvider, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(modifierLocalProvider, predicate);
        }

        @Deprecated
        public static <T, R> R foldIn(@NotNull ModifierLocalProvider<T> modifierLocalProvider, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(modifierLocalProvider, r10, operation);
        }

        @Deprecated
        public static <T, R> R foldOut(@NotNull ModifierLocalProvider<T> modifierLocalProvider, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(modifierLocalProvider, r10, operation);
        }

        @Deprecated
        @NotNull
        public static <T> Modifier then(@NotNull ModifierLocalProvider<T> modifierLocalProvider, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(modifierLocalProvider, other);
        }
    }

    @NotNull
    ProvidableModifierLocal<T> getKey();

    T getValue();
}
