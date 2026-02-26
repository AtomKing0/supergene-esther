package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NestedScrollModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollSource {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Drag = m2780constructorimpl(1);
    private static final int Fling = m2780constructorimpl(2);
    private static final int Relocate = m2780constructorimpl(3);
    private final int value;

    private /* synthetic */ NestedScrollSource(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ NestedScrollSource m2779boximpl(int i10) {
        return new NestedScrollSource(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2781equalsimpl(int i10, Object obj) {
        return (obj instanceof NestedScrollSource) && i10 == ((NestedScrollSource) obj).m2785unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2782equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2784toStringimpl(int i10) {
        return m2782equalsimpl0(i10, Drag) ? "Drag" : m2782equalsimpl0(i10, Fling) ? "Fling" : m2782equalsimpl0(i10, Relocate) ? "Relocate" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2781equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2783hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2784toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2785unboximpl() {
        return this.value;
    }

    /* JADX INFO: compiled from: NestedScrollModifier.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getDrag-WNlRxjI, reason: not valid java name */
        public final int m2787getDragWNlRxjI() {
            return NestedScrollSource.Drag;
        }

        /* JADX INFO: renamed from: getFling-WNlRxjI, reason: not valid java name */
        public final int m2788getFlingWNlRxjI() {
            return NestedScrollSource.Fling;
        }

        /* JADX INFO: renamed from: getRelocate-WNlRxjI, reason: not valid java name */
        public final int m2789getRelocateWNlRxjI() {
            return NestedScrollSource.Relocate;
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getRelocate-WNlRxjI$annotations, reason: not valid java name */
        public static /* synthetic */ void m2786getRelocateWNlRxjI$annotations() {
        }
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2780constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2783hashCodeimpl(int i10) {
        return i10;
    }
}
