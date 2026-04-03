package androidx.compose.ui.text.style;

import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextOverflow.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextOverflow {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Clip = m3617constructorimpl(1);
    private static final int Ellipsis = m3617constructorimpl(2);
    private static final int Visible = m3617constructorimpl(3);

    private /* synthetic */ TextOverflow(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextOverflow m3616boximpl(int i10) {
        return new TextOverflow(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3618equalsimpl(int i10, Object obj) {
        return (obj instanceof TextOverflow) && i10 == ((TextOverflow) obj).m3622unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3619equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3621toStringimpl(int i10) {
        return m3619equalsimpl0(i10, Clip) ? "Clip" : m3619equalsimpl0(i10, Ellipsis) ? "Ellipsis" : m3619equalsimpl0(i10, Visible) ? "Visible" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3618equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3620hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3621toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3622unboximpl() {
        return this.value;
    }

    /* JADX INFO: compiled from: TextOverflow.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getClip-gIe3tQ8, reason: not valid java name */
        public final int m3626getClipgIe3tQ8() {
            return TextOverflow.Clip;
        }

        /* JADX INFO: renamed from: getEllipsis-gIe3tQ8, reason: not valid java name */
        public final int m3627getEllipsisgIe3tQ8() {
            return TextOverflow.Ellipsis;
        }

        /* JADX INFO: renamed from: getVisible-gIe3tQ8, reason: not valid java name */
        public final int m3628getVisiblegIe3tQ8() {
            return TextOverflow.Visible;
        }

        @Stable
        /* JADX INFO: renamed from: getClip-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m3623getClipgIe3tQ8$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getEllipsis-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m3624getEllipsisgIe3tQ8$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getVisible-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m3625getVisiblegIe3tQ8$annotations() {
        }
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3617constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3620hashCodeimpl(int i10) {
        return i10;
    }
}
