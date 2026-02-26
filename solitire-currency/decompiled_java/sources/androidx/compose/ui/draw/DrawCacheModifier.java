package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DrawModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public interface DrawCacheModifier extends DrawModifier {

    /* JADX INFO: compiled from: DrawModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull DrawCacheModifier drawCacheModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.a(drawCacheModifier, predicate);
        }

        @Deprecated
        public static boolean any(@NotNull DrawCacheModifier drawCacheModifier, @NotNull l<? super Modifier.Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return androidx.compose.ui.b.b(drawCacheModifier, predicate);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull DrawCacheModifier drawCacheModifier, R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.c(drawCacheModifier, r10, operation);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull DrawCacheModifier drawCacheModifier, R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return (R) androidx.compose.ui.b.d(drawCacheModifier, r10, operation);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull DrawCacheModifier drawCacheModifier, @NotNull Modifier other) {
            t.i(other, "other");
            return androidx.compose.ui.a.a(drawCacheModifier, other);
        }
    }

    void onBuildCache(@NotNull BuildDrawCacheParams buildDrawCacheParams);
}
