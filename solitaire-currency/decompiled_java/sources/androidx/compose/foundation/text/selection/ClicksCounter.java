package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextSelectionMouseDetector.kt */
/* JADX INFO: loaded from: classes.dex */
final class ClicksCounter {
    private int clicks;

    @Nullable
    private PointerInputChange prevClick;

    @NotNull
    private final ViewConfiguration viewConfiguration;

    public ClicksCounter(@NotNull ViewConfiguration viewConfiguration) {
        t.i(viewConfiguration, "viewConfiguration");
        this.viewConfiguration = viewConfiguration;
    }

    public final int getClicks() {
        return this.clicks;
    }

    @Nullable
    public final PointerInputChange getPrevClick() {
        return this.prevClick;
    }

    public final boolean positionIsTolerable(@NotNull PointerInputChange prevClick, @NotNull PointerInputChange newClick) {
        t.i(prevClick, "prevClick");
        t.i(newClick, "newClick");
        return ((double) Offset.m1365getDistanceimpl(Offset.m1371minusMKHz9U(newClick.m2873getPositionF1C5BW0(), prevClick.m2873getPositionF1C5BW0()))) < 100.0d;
    }

    public final void setClicks(int i10) {
        this.clicks = i10;
    }

    public final void setPrevClick(@Nullable PointerInputChange pointerInputChange) {
        this.prevClick = pointerInputChange;
    }

    public final boolean timeIsTolerable(@NotNull PointerInputChange prevClick, @NotNull PointerInputChange newClick) {
        t.i(prevClick, "prevClick");
        t.i(newClick, "newClick");
        return newClick.getUptimeMillis() - prevClick.getUptimeMillis() < this.viewConfiguration.getDoubleTapTimeoutMillis();
    }

    public final void update(@NotNull PointerEvent event) {
        t.i(event, "event");
        PointerInputChange pointerInputChange = this.prevClick;
        PointerInputChange pointerInputChange2 = event.getChanges().get(0);
        if (pointerInputChange != null && timeIsTolerable(pointerInputChange, pointerInputChange2) && positionIsTolerable(pointerInputChange, pointerInputChange2)) {
            this.clicks++;
        } else {
            this.clicks = 1;
        }
        this.prevClick = pointerInputChange2;
    }
}
