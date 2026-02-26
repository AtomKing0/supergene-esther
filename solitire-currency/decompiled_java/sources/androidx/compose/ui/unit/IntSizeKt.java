package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.SizeKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IntSize.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IntSizeKt {
    @Stable
    public static final long IntSize(int i10, int i11) {
        return IntSize.m3828constructorimpl((((long) i11) & 4294967295L) | (((long) i10) << 32));
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m3839getCenterozmzZPI(long j10) {
        return IntOffsetKt.IntOffset(IntSize.m3833getWidthimpl(j10) / 2, IntSize.m3832getHeightimpl(j10) / 2);
    }

    @Stable
    /* JADX INFO: renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m3841timesO0kMr_c(int i10, long j10) {
        return IntSize.m3835timesYEO4UFw(j10, i10);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m3842toIntRectozmzZPI(long j10) {
        return IntRectKt.m3823IntRectVbeCjmY(IntOffset.Companion.m3801getZeronOccac(), j10);
    }

    @Stable
    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m3843toSizeozmzZPI(long j10) {
        return SizeKt.Size(IntSize.m3833getWidthimpl(j10), IntSize.m3832getHeightimpl(j10));
    }

    @Stable
    /* JADX INFO: renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m3840getCenterozmzZPI$annotations(long j10) {
    }
}
