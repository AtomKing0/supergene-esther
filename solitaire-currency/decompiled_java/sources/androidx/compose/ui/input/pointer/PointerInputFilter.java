package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class PointerInputFilter {
    public static final int $stable = 8;
    private boolean isAttached;

    @Nullable
    private LayoutCoordinates layoutCoordinates;

    public boolean getInterceptOutOfBoundsChildEvents() {
        return false;
    }

    @Nullable
    public final LayoutCoordinates getLayoutCoordinates$ui_release() {
        return this.layoutCoordinates;
    }

    @ExperimentalComposeUiApi
    public boolean getShareWithSiblings() {
        return false;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m2893getSizeYbymL2g() {
        LayoutCoordinates layoutCoordinates = this.layoutCoordinates;
        return layoutCoordinates != null ? layoutCoordinates.mo2989getSizeYbymL2g() : IntSize.Companion.m3838getZeroYbymL2g();
    }

    public final boolean isAttached$ui_release() {
        return this.isAttached;
    }

    public abstract void onCancel();

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public abstract void mo2894onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j10);

    public final void setAttached$ui_release(boolean z10) {
        this.isAttached = z10;
    }

    public final void setLayoutCoordinates$ui_release(@Nullable LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates = layoutCoordinates;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getShareWithSiblings$annotations() {
    }
}
