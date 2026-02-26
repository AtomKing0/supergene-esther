package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerEventKt {
    public static final boolean anyChangeConsumed(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return pointerInputChange.isConsumed();
    }

    public static final boolean changedToDown(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return !pointerInputChange.getPreviousPressed() && pointerInputChange.getPressed();
    }

    public static final boolean changedToUp(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return pointerInputChange.getPreviousPressed() && !pointerInputChange.getPressed();
    }

    public static final void consumeAllChanges(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        pointerInputChange.consume();
    }

    public static final void consumeDownChange(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        if (pointerInputChange.getPressed() != pointerInputChange.getPreviousPressed()) {
            pointerInputChange.consume();
        }
    }

    public static final void consumePositionChange(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        if (Offset.m1364equalsimpl0(positionChange(pointerInputChange), Offset.Companion.m1383getZeroF1C5BW0())) {
            return;
        }
        pointerInputChange.consume();
    }

    /* JADX INFO: renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m2822isOutOfBoundsO0kMr_c(@NotNull PointerInputChange isOutOfBounds, long j10) {
        t.i(isOutOfBounds, "$this$isOutOfBounds");
        long jM2873getPositionF1C5BW0 = isOutOfBounds.m2873getPositionF1C5BW0();
        float fM1367getXimpl = Offset.m1367getXimpl(jM2873getPositionF1C5BW0);
        float fM1368getYimpl = Offset.m1368getYimpl(jM2873getPositionF1C5BW0);
        return fM1367getXimpl < 0.0f || fM1367getXimpl > ((float) IntSize.m3833getWidthimpl(j10)) || fM1368getYimpl < 0.0f || fM1368getYimpl > ((float) IntSize.m3832getHeightimpl(j10));
    }

    /* JADX INFO: renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m2823isOutOfBoundsjwHxaWs(@NotNull PointerInputChange isOutOfBounds, long j10, long j11) {
        t.i(isOutOfBounds, "$this$isOutOfBounds");
        if (!PointerType.m2931equalsimpl0(isOutOfBounds.m2876getTypeT8wyACA(), PointerType.Companion.m2938getTouchT8wyACA())) {
            return m2822isOutOfBoundsO0kMr_c(isOutOfBounds, j10);
        }
        long jM2873getPositionF1C5BW0 = isOutOfBounds.m2873getPositionF1C5BW0();
        float fM1367getXimpl = Offset.m1367getXimpl(jM2873getPositionF1C5BW0);
        float fM1368getYimpl = Offset.m1368getYimpl(jM2873getPositionF1C5BW0);
        return fM1367getXimpl < (-Size.m1436getWidthimpl(j11)) || fM1367getXimpl > ((float) IntSize.m3833getWidthimpl(j10)) + Size.m1436getWidthimpl(j11) || fM1368getYimpl < (-Size.m1433getHeightimpl(j11)) || fM1368getYimpl > ((float) IntSize.m3832getHeightimpl(j10)) + Size.m1433getHeightimpl(j11);
    }

    public static final long positionChange(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, false);
    }

    public static final boolean positionChangeConsumed(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return pointerInputChange.isConsumed();
    }

    public static final long positionChangeIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, true);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z10) {
        long jM1371minusMKHz9U = Offset.m1371minusMKHz9U(pointerInputChange.m2873getPositionF1C5BW0(), pointerInputChange.m2874getPreviousPositionF1C5BW0());
        return (z10 || !pointerInputChange.isConsumed()) ? jM1371minusMKHz9U : Offset.Companion.m1383getZeroF1C5BW0();
    }

    static /* synthetic */ long positionChangeInternal$default(PointerInputChange pointerInputChange, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return positionChangeInternal(pointerInputChange, z10);
    }

    public static final boolean positionChanged(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return !Offset.m1364equalsimpl0(positionChangeInternal(pointerInputChange, false), Offset.Companion.m1383getZeroF1C5BW0());
    }

    public static final boolean positionChangedIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        t.i(pointerInputChange, "<this>");
        return !Offset.m1364equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.Companion.m1383getZeroF1C5BW0());
    }
}
