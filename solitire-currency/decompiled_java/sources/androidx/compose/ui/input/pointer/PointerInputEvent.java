package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerInputEvent.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEvent {

    @NotNull
    private final MotionEvent motionEvent;

    @NotNull
    private final List<PointerInputEventData> pointers;
    private final long uptime;

    public PointerInputEvent(long j10, @NotNull List<PointerInputEventData> pointers, @NotNull MotionEvent motionEvent) {
        t.i(pointers, "pointers");
        t.i(motionEvent, "motionEvent");
        this.uptime = j10;
        this.pointers = pointers;
        this.motionEvent = motionEvent;
    }

    @NotNull
    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }

    @NotNull
    public final List<PointerInputEventData> getPointers() {
        return this.pointers;
    }

    public final long getUptime() {
        return this.uptime;
    }
}
