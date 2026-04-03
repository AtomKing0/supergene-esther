package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Immutable;

/* JADX INFO: compiled from: LazyGridSpan.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class GridItemSpan {
    private final long packedValue;

    private /* synthetic */ GridItemSpan(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ GridItemSpan m531boximpl(long j10) {
        return new GridItemSpan(j10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m533equalsimpl(long j10, Object obj) {
        return (obj instanceof GridItemSpan) && j10 == ((GridItemSpan) obj).m538unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m534equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getCurrentLineSpan-impl, reason: not valid java name */
    public static final int m535getCurrentLineSpanimpl(long j10) {
        return (int) j10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m536hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m537toStringimpl(long j10) {
        return "GridItemSpan(packedValue=" + j10 + ')';
    }

    public boolean equals(Object obj) {
        return m533equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m536hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m537toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m538unboximpl() {
        return this.packedValue;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getCurrentLineSpan$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m532constructorimpl(long j10) {
        return j10;
    }
}
