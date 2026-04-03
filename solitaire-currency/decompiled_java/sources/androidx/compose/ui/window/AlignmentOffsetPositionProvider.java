package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Popup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {

    @NotNull
    private final Alignment alignment;
    private final long offset;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment, long j10, k kVar) {
        this(alignment, j10);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo758calculatePositionllwVHH4(@NotNull IntRect anchorBounds, long j10, @NotNull LayoutDirection layoutDirection, long j11) {
        t.i(anchorBounds, "anchorBounds");
        t.i(layoutDirection, "layoutDirection");
        long jIntOffset = IntOffsetKt.IntOffset(0, 0);
        Alignment alignment = this.alignment;
        IntSize.Companion companion = IntSize.Companion;
        long jMo1275alignKFBX0sM = alignment.mo1275alignKFBX0sM(companion.m3838getZeroYbymL2g(), IntSizeKt.IntSize(anchorBounds.getWidth(), anchorBounds.getHeight()), layoutDirection);
        long jMo1275alignKFBX0sM2 = this.alignment.mo1275alignKFBX0sM(companion.m3838getZeroYbymL2g(), IntSizeKt.IntSize(IntSize.m3833getWidthimpl(j11), IntSize.m3832getHeightimpl(j11)), layoutDirection);
        long jIntOffset2 = IntOffsetKt.IntOffset(anchorBounds.getLeft(), anchorBounds.getTop());
        long jIntOffset3 = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset) + IntOffset.m3791getXimpl(jIntOffset2), IntOffset.m3792getYimpl(jIntOffset) + IntOffset.m3792getYimpl(jIntOffset2));
        long jIntOffset4 = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset3) + IntOffset.m3791getXimpl(jMo1275alignKFBX0sM), IntOffset.m3792getYimpl(jIntOffset3) + IntOffset.m3792getYimpl(jMo1275alignKFBX0sM));
        long jIntOffset5 = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jMo1275alignKFBX0sM2), IntOffset.m3792getYimpl(jMo1275alignKFBX0sM2));
        long jIntOffset6 = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset4) - IntOffset.m3791getXimpl(jIntOffset5), IntOffset.m3792getYimpl(jIntOffset4) - IntOffset.m3792getYimpl(jIntOffset5));
        long jIntOffset7 = IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.m3792getYimpl(this.offset));
        return IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jIntOffset6) + IntOffset.m3791getXimpl(jIntOffset7), IntOffset.m3792getYimpl(jIntOffset6) + IntOffset.m3792getYimpl(jIntOffset7));
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public final long m3912getOffsetnOccac() {
        return this.offset;
    }

    private AlignmentOffsetPositionProvider(Alignment alignment, long j10) {
        this.alignment = alignment;
        this.offset = j10;
    }
}
