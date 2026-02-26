package androidx.compose.foundation.lazy.grid;

/* JADX INFO: compiled from: ItemIndex.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ItemIndex {
    private final int value;

    private /* synthetic */ ItemIndex(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ItemIndex m539boximpl(int i10) {
        return new ItemIndex(i10);
    }

    /* JADX INFO: renamed from: compareTo-YGsSkvE, reason: not valid java name */
    public static final int m540compareToYGsSkvE(int i10, int i11) {
        return i10 - i11;
    }

    /* JADX INFO: renamed from: dec-VZbfaAc, reason: not valid java name */
    public static final int m542decVZbfaAc(int i10) {
        return m541constructorimpl(i10 - 1);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m543equalsimpl(int i10, Object obj) {
        return (obj instanceof ItemIndex) && i10 == ((ItemIndex) obj).m551unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m544equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    /* JADX INFO: renamed from: inc-VZbfaAc, reason: not valid java name */
    public static final int m546incVZbfaAc(int i10) {
        return m541constructorimpl(i10 + 1);
    }

    /* JADX INFO: renamed from: minus-41DfMLM, reason: not valid java name */
    public static final int m547minus41DfMLM(int i10, int i11) {
        return m541constructorimpl(i10 - i11);
    }

    /* JADX INFO: renamed from: minus-AoD1bsw, reason: not valid java name */
    public static final int m548minusAoD1bsw(int i10, int i11) {
        return m541constructorimpl(i10 - i11);
    }

    /* JADX INFO: renamed from: plus-AoD1bsw, reason: not valid java name */
    public static final int m549plusAoD1bsw(int i10, int i11) {
        return m541constructorimpl(i10 + i11);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m550toStringimpl(int i10) {
        return "ItemIndex(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return m543equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m545hashCodeimpl(this.value);
    }

    public String toString() {
        return m550toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m551unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m541constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m545hashCodeimpl(int i10) {
        return i10;
    }
}
