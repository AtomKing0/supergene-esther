package androidx.compose.foundation.lazy.grid;

/* JADX INFO: compiled from: ItemIndex.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LineIndex {
    private final int value;

    private /* synthetic */ LineIndex(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineIndex m591boximpl(int i10) {
        return new LineIndex(i10);
    }

    /* JADX INFO: renamed from: compareTo-bKFJvoY, reason: not valid java name */
    public static final int m592compareTobKFJvoY(int i10, int i11) {
        return i10 - i11;
    }

    /* JADX INFO: renamed from: dec-hA7yfN8, reason: not valid java name */
    public static final int m594dechA7yfN8(int i10) {
        return m593constructorimpl(i10 - 1);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m595equalsimpl(int i10, Object obj) {
        return (obj instanceof LineIndex) && i10 == ((LineIndex) obj).m603unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m596equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    /* JADX INFO: renamed from: inc-hA7yfN8, reason: not valid java name */
    public static final int m598inchA7yfN8(int i10) {
        return m593constructorimpl(i10 + 1);
    }

    /* JADX INFO: renamed from: minus--_Ze7BM, reason: not valid java name */
    public static final int m599minus_Ze7BM(int i10, int i11) {
        return m593constructorimpl(i10 - i11);
    }

    /* JADX INFO: renamed from: minus-fVkYB0M, reason: not valid java name */
    public static final int m600minusfVkYB0M(int i10, int i11) {
        return m593constructorimpl(i10 - i11);
    }

    /* JADX INFO: renamed from: plus--_Ze7BM, reason: not valid java name */
    public static final int m601plus_Ze7BM(int i10, int i11) {
        return m593constructorimpl(i10 + i11);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m602toStringimpl(int i10) {
        return "LineIndex(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return m595equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m597hashCodeimpl(this.value);
    }

    public String toString() {
        return m602toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m603unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m593constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m597hashCodeimpl(int i10) {
        return i10;
    }
}
