package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InternalPointerEvent.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InternalPointerEvent {

    @NotNull
    private final Map<PointerId, PointerInputChange> changes;

    @NotNull
    private final PointerInputEvent pointerInputEvent;
    private boolean suppressMovementConsumption;

    public InternalPointerEvent(@NotNull Map<PointerId, PointerInputChange> changes, @NotNull PointerInputEvent pointerInputEvent) {
        t.i(changes, "changes");
        t.i(pointerInputEvent, "pointerInputEvent");
        this.changes = changes;
        this.pointerInputEvent = pointerInputEvent;
    }

    @NotNull
    public final Map<PointerId, PointerInputChange> getChanges() {
        return this.changes;
    }

    @NotNull
    public final MotionEvent getMotionEvent() {
        return this.pointerInputEvent.getMotionEvent();
    }

    @NotNull
    public final PointerInputEvent getPointerInputEvent() {
        return this.pointerInputEvent;
    }

    public final boolean getSuppressMovementConsumption() {
        return this.suppressMovementConsumption;
    }

    /* JADX INFO: renamed from: issuesEnterExitEvent-0FcD4WY, reason: not valid java name */
    public final boolean m2807issuesEnterExitEvent0FcD4WY(long j10) {
        PointerInputEventData pointerInputEventData;
        List<PointerInputEventData> pointers = this.pointerInputEvent.getPointers();
        int size = pointers.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                pointerInputEventData = null;
                break;
            }
            pointerInputEventData = pointers.get(i10);
            if (PointerId.m2860equalsimpl0(pointerInputEventData.m2886getIdJ3iCeTQ(), j10)) {
                break;
            }
            i10++;
        }
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        if (pointerInputEventData2 != null) {
            return pointerInputEventData2.getIssuesEnterExit();
        }
        return false;
    }

    public final void setSuppressMovementConsumption(boolean z10) {
        this.suppressMovementConsumption = z10;
    }
}
