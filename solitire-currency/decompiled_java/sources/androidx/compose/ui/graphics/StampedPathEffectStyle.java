package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PathEffect.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class StampedPathEffectStyle {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Translate = m1869constructorimpl(0);
    private static final int Rotate = m1869constructorimpl(1);
    private static final int Morph = m1869constructorimpl(2);

    /* JADX INFO: compiled from: PathEffect.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getMorph-Ypspkwk, reason: not valid java name */
        public final int m1875getMorphYpspkwk() {
            return StampedPathEffectStyle.Morph;
        }

        /* JADX INFO: renamed from: getRotate-Ypspkwk, reason: not valid java name */
        public final int m1876getRotateYpspkwk() {
            return StampedPathEffectStyle.Rotate;
        }

        /* JADX INFO: renamed from: getTranslate-Ypspkwk, reason: not valid java name */
        public final int m1877getTranslateYpspkwk() {
            return StampedPathEffectStyle.Translate;
        }
    }

    private /* synthetic */ StampedPathEffectStyle(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StampedPathEffectStyle m1868boximpl(int i10) {
        return new StampedPathEffectStyle(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1870equalsimpl(int i10, Object obj) {
        return (obj instanceof StampedPathEffectStyle) && i10 == ((StampedPathEffectStyle) obj).m1874unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1871equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1873toStringimpl(int i10) {
        return m1871equalsimpl0(i10, Translate) ? "Translate" : m1871equalsimpl0(i10, Rotate) ? "Rotate" : m1871equalsimpl0(i10, Morph) ? "Morph" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1870equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1872hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1873toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1874unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1869constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1872hashCodeimpl(int i10) {
        return i10;
    }
}
