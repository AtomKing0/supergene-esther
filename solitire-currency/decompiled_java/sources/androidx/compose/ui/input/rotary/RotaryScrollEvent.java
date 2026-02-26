package androidx.compose.ui.input.rotary;

import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.input.focus.FocusAwareEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RotaryScrollEvent.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class RotaryScrollEvent implements FocusAwareEvent {
    public static final int $stable = 0;
    private final float horizontalScrollPixels;
    private final long uptimeMillis;
    private final float verticalScrollPixels;

    public RotaryScrollEvent(float f10, float f11, long j10) {
        this.verticalScrollPixels = f10;
        this.horizontalScrollPixels = f11;
        this.uptimeMillis = j10;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof RotaryScrollEvent)) {
            return false;
        }
        RotaryScrollEvent rotaryScrollEvent = (RotaryScrollEvent) obj;
        if (rotaryScrollEvent.verticalScrollPixels == this.verticalScrollPixels) {
            return ((rotaryScrollEvent.horizontalScrollPixels > this.horizontalScrollPixels ? 1 : (rotaryScrollEvent.horizontalScrollPixels == this.horizontalScrollPixels ? 0 : -1)) == 0) && rotaryScrollEvent.uptimeMillis == this.uptimeMillis;
        }
        return false;
    }

    public final float getHorizontalScrollPixels() {
        return this.horizontalScrollPixels;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final float getVerticalScrollPixels() {
        return this.verticalScrollPixels;
    }

    public int hashCode() {
        return ((((0 + Float.floatToIntBits(this.verticalScrollPixels)) * 31) + Float.floatToIntBits(this.horizontalScrollPixels)) * 31) + a.a(this.uptimeMillis);
    }

    @NotNull
    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.verticalScrollPixels + ",horizontalScrollPixels=" + this.horizontalScrollPixels + ",uptimeMillis=" + this.uptimeMillis + ')';
    }
}
