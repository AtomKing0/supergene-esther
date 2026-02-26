package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontStyle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontStyle {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Normal = m3411constructorimpl(0);
    private static final int Italic = m3411constructorimpl(1);

    /* JADX INFO: compiled from: FontStyle.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getItalic-_-LCdwA, reason: not valid java name */
        public final int m3417getItalic_LCdwA() {
            return FontStyle.Italic;
        }

        /* JADX INFO: renamed from: getNormal-_-LCdwA, reason: not valid java name */
        public final int m3418getNormal_LCdwA() {
            return FontStyle.Normal;
        }

        @NotNull
        public final List<FontStyle> values() {
            return v.n(FontStyle.m3410boximpl(m3418getNormal_LCdwA()), FontStyle.m3410boximpl(m3417getItalic_LCdwA()));
        }
    }

    private /* synthetic */ FontStyle(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontStyle m3410boximpl(int i10) {
        return new FontStyle(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3412equalsimpl(int i10, Object obj) {
        return (obj instanceof FontStyle) && i10 == ((FontStyle) obj).m3416unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3413equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3415toStringimpl(int i10) {
        return m3413equalsimpl0(i10, Normal) ? "Normal" : m3413equalsimpl0(i10, Italic) ? "Italic" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3412equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m3414hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3415toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3416unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3411constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3414hashCodeimpl(int i10) {
        return i10;
    }
}
