package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Modifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface Modifier {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Modifier.kt */
    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Override // androidx.compose.ui.Modifier
        public boolean all(@NotNull l<? super Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return true;
        }

        @Override // androidx.compose.ui.Modifier
        public boolean any(@NotNull l<? super Element, Boolean> predicate) {
            t.i(predicate, "predicate");
            return false;
        }

        @Override // androidx.compose.ui.Modifier
        public <R> R foldIn(R r10, @NotNull p<? super R, ? super Element, ? extends R> operation) {
            t.i(operation, "operation");
            return r10;
        }

        @Override // androidx.compose.ui.Modifier
        public <R> R foldOut(R r10, @NotNull p<? super Element, ? super R, ? extends R> operation) {
            t.i(operation, "operation");
            return r10;
        }

        @Override // androidx.compose.ui.Modifier
        @NotNull
        public Modifier then(@NotNull Modifier other) {
            t.i(other, "other");
            return other;
        }

        @NotNull
        public String toString() {
            return "Modifier";
        }
    }

    /* JADX INFO: compiled from: Modifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static Modifier then(@NotNull Modifier modifier, @NotNull Modifier other) {
            t.i(other, "other");
            return a.a(modifier, other);
        }
    }

    /* JADX INFO: compiled from: Modifier.kt */
    public interface Element extends Modifier {

        /* JADX INFO: compiled from: Modifier.kt */
        public static final class DefaultImpls {
            @Deprecated
            public static boolean all(@NotNull Element element, @NotNull l<? super Element, Boolean> predicate) {
                t.i(predicate, "predicate");
                return b.a(element, predicate);
            }

            @Deprecated
            public static boolean any(@NotNull Element element, @NotNull l<? super Element, Boolean> predicate) {
                t.i(predicate, "predicate");
                return b.b(element, predicate);
            }

            @Deprecated
            public static <R> R foldIn(@NotNull Element element, R r10, @NotNull p<? super R, ? super Element, ? extends R> operation) {
                t.i(operation, "operation");
                return (R) b.c(element, r10, operation);
            }

            @Deprecated
            public static <R> R foldOut(@NotNull Element element, R r10, @NotNull p<? super Element, ? super R, ? extends R> operation) {
                t.i(operation, "operation");
                return (R) b.d(element, r10, operation);
            }

            @Deprecated
            @NotNull
            public static Modifier then(@NotNull Element element, @NotNull Modifier other) {
                t.i(other, "other");
                return a.a(element, other);
            }
        }

        @Override // androidx.compose.ui.Modifier
        boolean all(@NotNull l<? super Element, Boolean> lVar);

        @Override // androidx.compose.ui.Modifier
        boolean any(@NotNull l<? super Element, Boolean> lVar);

        @Override // androidx.compose.ui.Modifier
        <R> R foldIn(R r10, @NotNull p<? super R, ? super Element, ? extends R> pVar);

        @Override // androidx.compose.ui.Modifier
        <R> R foldOut(R r10, @NotNull p<? super Element, ? super R, ? extends R> pVar);
    }

    boolean all(@NotNull l<? super Element, Boolean> lVar);

    boolean any(@NotNull l<? super Element, Boolean> lVar);

    <R> R foldIn(R r10, @NotNull p<? super R, ? super Element, ? extends R> pVar);

    <R> R foldOut(R r10, @NotNull p<? super Element, ? super R, ? extends R> pVar);

    @NotNull
    Modifier then(@NotNull Modifier modifier);
}
