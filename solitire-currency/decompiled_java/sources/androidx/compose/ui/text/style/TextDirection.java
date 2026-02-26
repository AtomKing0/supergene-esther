package androidx.compose.ui.text.style;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextDirection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextDirection {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Ltr = m3600constructorimpl(1);
    private static final int Rtl = m3600constructorimpl(2);
    private static final int Content = m3600constructorimpl(3);
    private static final int ContentOrLtr = m3600constructorimpl(4);
    private static final int ContentOrRtl = m3600constructorimpl(5);

    /* JADX INFO: compiled from: TextDirection.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getContent-s_7X-co, reason: not valid java name */
        public final int m3606getContents_7Xco() {
            return TextDirection.Content;
        }

        /* JADX INFO: renamed from: getContentOrLtr-s_7X-co, reason: not valid java name */
        public final int m3607getContentOrLtrs_7Xco() {
            return TextDirection.ContentOrLtr;
        }

        /* JADX INFO: renamed from: getContentOrRtl-s_7X-co, reason: not valid java name */
        public final int m3608getContentOrRtls_7Xco() {
            return TextDirection.ContentOrRtl;
        }

        /* JADX INFO: renamed from: getLtr-s_7X-co, reason: not valid java name */
        public final int m3609getLtrs_7Xco() {
            return TextDirection.Ltr;
        }

        /* JADX INFO: renamed from: getRtl-s_7X-co, reason: not valid java name */
        public final int m3610getRtls_7Xco() {
            return TextDirection.Rtl;
        }
    }

    private /* synthetic */ TextDirection(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextDirection m3599boximpl(int i10) {
        return new TextDirection(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3601equalsimpl(int i10, Object obj) {
        return (obj instanceof TextDirection) && i10 == ((TextDirection) obj).m3605unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3602equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3604toStringimpl(int i10) {
        return m3602equalsimpl0(i10, Ltr) ? "Ltr" : m3602equalsimpl0(i10, Rtl) ? "Rtl" : m3602equalsimpl0(i10, Content) ? "Content" : m3602equalsimpl0(i10, ContentOrLtr) ? "ContentOrLtr" : m3602equalsimpl0(i10, ContentOrRtl) ? "ContentOrRtl" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3601equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3603hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3604toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3605unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3600constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3603hashCodeimpl(int i10) {
        return i10;
    }
}
