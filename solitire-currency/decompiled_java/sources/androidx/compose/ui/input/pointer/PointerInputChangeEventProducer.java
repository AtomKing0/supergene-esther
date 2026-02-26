package androidx.compose.ui.input.pointer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerInputEventProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
final class PointerInputChangeEventProducer {

    @NotNull
    private final Map<PointerId, PointerInputData> previousPointerInputData = new LinkedHashMap();

    /* JADX INFO: compiled from: PointerInputEventProcessor.kt */
    private static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final int type;
        private final long uptime;

        public /* synthetic */ PointerInputData(long j10, long j11, boolean z10, int i10, k kVar) {
            this(j10, j11, z10, i10);
        }

        public final boolean getDown() {
            return this.down;
        }

        /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
        public final long m2877getPositionOnScreenF1C5BW0() {
            return this.positionOnScreen;
        }

        /* JADX INFO: renamed from: getType-T8wyACA, reason: not valid java name */
        public final int m2878getTypeT8wyACA() {
            return this.type;
        }

        public final long getUptime() {
            return this.uptime;
        }

        private PointerInputData(long j10, long j11, boolean z10, int i10) {
            this.uptime = j10;
            this.positionOnScreen = j11;
            this.down = z10;
            this.type = i10;
        }
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    @NotNull
    public final InternalPointerEvent produce(@NotNull PointerInputEvent pointerInputEvent, @NotNull PositionCalculator positionCalculator) {
        long uptime;
        boolean down;
        long jMo2941screenToLocalMKHz9U;
        t.i(pointerInputEvent, "pointerInputEvent");
        t.i(positionCalculator, "positionCalculator");
        LinkedHashMap linkedHashMap = new LinkedHashMap(pointerInputEvent.getPointers().size());
        List<PointerInputEventData> pointers = pointerInputEvent.getPointers();
        int size = pointers.size();
        for (int i10 = 0; i10 < size; i10++) {
            PointerInputEventData pointerInputEventData = pointers.get(i10);
            PointerInputData pointerInputData = this.previousPointerInputData.get(PointerId.m2857boximpl(pointerInputEventData.m2886getIdJ3iCeTQ()));
            if (pointerInputData == null) {
                uptime = pointerInputEventData.getUptime();
                jMo2941screenToLocalMKHz9U = pointerInputEventData.m2887getPositionF1C5BW0();
                down = false;
            } else {
                long uptime2 = pointerInputData.getUptime();
                uptime = uptime2;
                down = pointerInputData.getDown();
                jMo2941screenToLocalMKHz9U = positionCalculator.mo2941screenToLocalMKHz9U(pointerInputData.m2877getPositionOnScreenF1C5BW0());
            }
            linkedHashMap.put(PointerId.m2857boximpl(pointerInputEventData.m2886getIdJ3iCeTQ()), new PointerInputChange(pointerInputEventData.m2886getIdJ3iCeTQ(), pointerInputEventData.getUptime(), pointerInputEventData.m2887getPositionF1C5BW0(), pointerInputEventData.getDown(), uptime, jMo2941screenToLocalMKHz9U, down, false, pointerInputEventData.m2890getTypeT8wyACA(), (List) pointerInputEventData.getHistorical(), pointerInputEventData.m2889getScrollDeltaF1C5BW0(), (k) null));
            if (pointerInputEventData.getDown()) {
                this.previousPointerInputData.put(PointerId.m2857boximpl(pointerInputEventData.m2886getIdJ3iCeTQ()), new PointerInputData(pointerInputEventData.getUptime(), pointerInputEventData.m2888getPositionOnScreenF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.m2890getTypeT8wyACA(), null));
            } else {
                this.previousPointerInputData.remove(PointerId.m2857boximpl(pointerInputEventData.m2886getIdJ3iCeTQ()));
            }
        }
        return new InternalPointerEvent(linkedHashMap, pointerInputEvent);
    }
}
