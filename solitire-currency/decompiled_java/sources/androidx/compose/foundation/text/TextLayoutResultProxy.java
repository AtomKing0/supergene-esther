package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextLayoutResultProxy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutResultProxy {

    @Nullable
    private LayoutCoordinates decorationBoxCoordinates;

    @Nullable
    private LayoutCoordinates innerTextFieldCoordinates;

    @NotNull
    private final TextLayoutResult value;

    public TextLayoutResultProxy(@NotNull TextLayoutResult value) {
        t.i(value, "value");
        this.value = value;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long m742coercedInVisibleBoundsOfInputTextMKHz9U(long r6) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.innerTextFieldCoordinates
            if (r0 == 0) goto L1e
            boolean r1 = r0.isAttached()
            if (r1 == 0) goto L16
            androidx.compose.ui.layout.LayoutCoordinates r1 = r5.decorationBoxCoordinates
            r2 = 0
            if (r1 == 0) goto L1c
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.b.a(r1, r0, r3, r4, r2)
            goto L1c
        L16:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L1c:
            if (r2 != 0) goto L24
        L1e:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r2 = r0.getZero()
        L24:
            long r6 = androidx.compose.foundation.text.TextLayoutResultProxyKt.m747access$coerceIn3MmeM6k(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLayoutResultProxy.m742coercedInVisibleBoundsOfInputTextMKHz9U(long):long");
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResultProxy textLayoutResultProxy, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return textLayoutResultProxy.getLineEnd(i10, z10);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m743getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return textLayoutResultProxy.m745getOffsetForPosition3MmeM6k(j10, z10);
    }

    /* JADX INFO: renamed from: relativeToInputText-MK-Hz9U, reason: not valid java name */
    private final long m744relativeToInputTextMKHz9U(long j10) {
        Offset offsetM1356boximpl;
        LayoutCoordinates layoutCoordinates = this.innerTextFieldCoordinates;
        if (layoutCoordinates == null) {
            return j10;
        }
        LayoutCoordinates layoutCoordinates2 = this.decorationBoxCoordinates;
        if (layoutCoordinates2 != null) {
            offsetM1356boximpl = Offset.m1356boximpl((layoutCoordinates.isAttached() && layoutCoordinates2.isAttached()) ? layoutCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates2, j10) : j10);
        } else {
            offsetM1356boximpl = null;
        }
        return offsetM1356boximpl != null ? offsetM1356boximpl.m1377unboximpl() : j10;
    }

    @Nullable
    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    @Nullable
    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final int getLineEnd(int i10, boolean z10) {
        return this.value.getLineEnd(i10, z10);
    }

    public final int getLineForVerticalPosition(float f10) {
        return this.value.getLineForVerticalPosition(Offset.m1368getYimpl(m744relativeToInputTextMKHz9U(m742coercedInVisibleBoundsOfInputTextMKHz9U(OffsetKt.Offset(0.0f, f10)))));
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m745getOffsetForPosition3MmeM6k(long j10, boolean z10) {
        if (z10) {
            j10 = m742coercedInVisibleBoundsOfInputTextMKHz9U(j10);
        }
        return this.value.m3320getOffsetForPositionk4lQ0M(m744relativeToInputTextMKHz9U(j10));
    }

    @NotNull
    public final TextLayoutResult getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m746isPositionOnTextk4lQ0M(long j10) {
        long jM744relativeToInputTextMKHz9U = m744relativeToInputTextMKHz9U(m742coercedInVisibleBoundsOfInputTextMKHz9U(j10));
        int lineForVerticalPosition = this.value.getLineForVerticalPosition(Offset.m1368getYimpl(jM744relativeToInputTextMKHz9U));
        return Offset.m1367getXimpl(jM744relativeToInputTextMKHz9U) >= this.value.getLineLeft(lineForVerticalPosition) && Offset.m1367getXimpl(jM744relativeToInputTextMKHz9U) <= this.value.getLineRight(lineForVerticalPosition);
    }

    public final void setDecorationBoxCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    public final void setInnerTextFieldCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }
}
