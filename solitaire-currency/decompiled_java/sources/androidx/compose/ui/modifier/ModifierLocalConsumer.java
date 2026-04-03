package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ModifierLocalConsumer.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface ModifierLocalConsumer extends Modifier.Element {

    /* JADX INFO: compiled from: ModifierLocalConsumer.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull ModifierLocalConsumer modifierLocalConsumer, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(modifierLocalConsumer, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull ModifierLocalConsumer modifierLocalConsumer, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(modifierLocalConsumer, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull ModifierLocalConsumer modifierLocalConsumer, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(modifierLocalConsumer, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull ModifierLocalConsumer modifierLocalConsumer, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(modifierLocalConsumer, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull ModifierLocalConsumer modifierLocalConsumer, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(modifierLocalConsumer, other);
        }
    }

    void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope);
}
