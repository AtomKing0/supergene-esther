package androidx.compose.material.ripple;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RippleTheme.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class RippleAlpha {
    private final float draggedAlpha;
    private final float focusedAlpha;
    private final float hoveredAlpha;
    private final float pressedAlpha;

    public RippleAlpha(float f10, float f11, float f12, float f13) {
        this.draggedAlpha = f10;
        this.focusedAlpha = f11;
        this.hoveredAlpha = f12;
        this.pressedAlpha = f13;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleAlpha)) {
            return false;
        }
        RippleAlpha rippleAlpha = (RippleAlpha) obj;
        if (!(this.draggedAlpha == rippleAlpha.draggedAlpha)) {
            return false;
        }
        if (!(this.focusedAlpha == rippleAlpha.focusedAlpha)) {
            return false;
        }
        if (this.hoveredAlpha == rippleAlpha.hoveredAlpha) {
            return (this.pressedAlpha > rippleAlpha.pressedAlpha ? 1 : (this.pressedAlpha == rippleAlpha.pressedAlpha ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float getDraggedAlpha() {
        return this.draggedAlpha;
    }

    public final float getFocusedAlpha() {
        return this.focusedAlpha;
    }

    public final float getHoveredAlpha() {
        return this.hoveredAlpha;
    }

    public final float getPressedAlpha() {
        return this.pressedAlpha;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.draggedAlpha) * 31) + Float.floatToIntBits(this.focusedAlpha)) * 31) + Float.floatToIntBits(this.hoveredAlpha)) * 31) + Float.floatToIntBits(this.pressedAlpha);
    }

    @NotNull
    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.draggedAlpha + ", focusedAlpha=" + this.focusedAlpha + ", hoveredAlpha=" + this.hoveredAlpha + ", pressedAlpha=" + this.pressedAlpha + ')';
    }
}
