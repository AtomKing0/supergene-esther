package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ParentDataModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ParentDataModifier extends Modifier.Element {

    /* JADX INFO: compiled from: ParentDataModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull ParentDataModifier parentDataModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(parentDataModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull ParentDataModifier parentDataModifier, @NotNull h9.l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(parentDataModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull ParentDataModifier parentDataModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(parentDataModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull ParentDataModifier parentDataModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(parentDataModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull ParentDataModifier parentDataModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(parentDataModifier, other);
        }
    }

    @Nullable
    Object modifyParentData(@NotNull Density density, @Nullable Object obj);
}
