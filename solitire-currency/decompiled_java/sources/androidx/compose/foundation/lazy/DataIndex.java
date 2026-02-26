package androidx.compose.foundation.lazy;

/* JADX INFO: compiled from: DataIndex.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DataIndex {
    private final int value;

    private /* synthetic */ DataIndex(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DataIndex m484boximpl(int i10) {
        return new DataIndex(i10);
    }

    /* JADX INFO: renamed from: compareTo-ZjPyQlc, reason: not valid java name */
    public static final int m485compareToZjPyQlc(int i10, int i11) {
        return i10 - i11;
    }

    /* JADX INFO: renamed from: dec-jQJCoq8, reason: not valid java name */
    public static final int m487decjQJCoq8(int i10) {
        return m486constructorimpl(i10 - 1);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m488equalsimpl(int i10, Object obj) {
        return (obj instanceof DataIndex) && i10 == ((DataIndex) obj).m496unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m489equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    /* JADX INFO: renamed from: inc-jQJCoq8, reason: not valid java name */
    public static final int m491incjQJCoq8(int i10) {
        return m486constructorimpl(i10 + 1);
    }

    /* JADX INFO: renamed from: minus-PBKCTt8, reason: not valid java name */
    public static final int m492minusPBKCTt8(int i10, int i11) {
        return m486constructorimpl(i10 - i11);
    }

    /* JADX INFO: renamed from: minus-yUvdeeg, reason: not valid java name */
    public static final int m493minusyUvdeeg(int i10, int i11) {
        return m486constructorimpl(i10 - i11);
    }

    /* JADX INFO: renamed from: plus-PBKCTt8, reason: not valid java name */
    public static final int m494plusPBKCTt8(int i10, int i11) {
        return m486constructorimpl(i10 + i11);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m495toStringimpl(int i10) {
        return "DataIndex(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return m488equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m490hashCodeimpl(this.value);
    }

    public String toString() {
        return m495toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m496unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m486constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m490hashCodeimpl(int i10) {
        return i10;
    }
}
