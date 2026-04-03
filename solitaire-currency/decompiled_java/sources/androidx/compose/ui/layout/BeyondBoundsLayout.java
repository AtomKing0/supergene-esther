package androidx.compose.ui.layout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BeyondBoundsLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public interface BeyondBoundsLayout {

    /* JADX INFO: compiled from: BeyondBoundsLayout.kt */
    public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    @Nullable
    /* JADX INFO: renamed from: layout-o7g1Pn8 */
    <T> T mo507layouto7g1Pn8(int i10, @NotNull h9.l<? super BeyondBoundsScope, ? extends T> lVar);

    /* JADX INFO: compiled from: BeyondBoundsLayout.kt */
    public static final class LayoutDirection {
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Before = m2965constructorimpl(1);
        private static final int After = m2965constructorimpl(2);
        private static final int Left = m2965constructorimpl(3);
        private static final int Right = m2965constructorimpl(4);
        private static final int Above = m2965constructorimpl(5);
        private static final int Below = m2965constructorimpl(6);

        /* JADX INFO: compiled from: BeyondBoundsLayout.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }

            /* JADX INFO: renamed from: getAbove-hoxUOeE, reason: not valid java name */
            public final int m2971getAbovehoxUOeE() {
                return LayoutDirection.Above;
            }

            /* JADX INFO: renamed from: getAfter-hoxUOeE, reason: not valid java name */
            public final int m2972getAfterhoxUOeE() {
                return LayoutDirection.After;
            }

            /* JADX INFO: renamed from: getBefore-hoxUOeE, reason: not valid java name */
            public final int m2973getBeforehoxUOeE() {
                return LayoutDirection.Before;
            }

            /* JADX INFO: renamed from: getBelow-hoxUOeE, reason: not valid java name */
            public final int m2974getBelowhoxUOeE() {
                return LayoutDirection.Below;
            }

            /* JADX INFO: renamed from: getLeft-hoxUOeE, reason: not valid java name */
            public final int m2975getLefthoxUOeE() {
                return LayoutDirection.Left;
            }

            /* JADX INFO: renamed from: getRight-hoxUOeE, reason: not valid java name */
            public final int m2976getRighthoxUOeE() {
                return LayoutDirection.Right;
            }
        }

        private /* synthetic */ LayoutDirection(int i10) {
            this.value = i10;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ LayoutDirection m2964boximpl(int i10) {
            return new LayoutDirection(i10);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m2966equalsimpl(int i10, Object obj) {
            return (obj instanceof LayoutDirection) && i10 == ((LayoutDirection) obj).m2970unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2967equalsimpl0(int i10, int i11) {
            return i10 == i11;
        }

        @NotNull
        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2969toStringimpl(int i10) {
            return m2967equalsimpl0(i10, Before) ? "Before" : m2967equalsimpl0(i10, After) ? "After" : m2967equalsimpl0(i10, Left) ? "Left" : m2967equalsimpl0(i10, Right) ? "Right" : m2967equalsimpl0(i10, Above) ? "Above" : m2967equalsimpl0(i10, Below) ? "Below" : "invalid LayoutDirection";
        }

        public boolean equals(Object obj) {
            return m2966equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m2968hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m2969toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m2970unboximpl() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m2965constructorimpl(int i10) {
            return i10;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2968hashCodeimpl(int i10) {
            return i10;
        }
    }
}
