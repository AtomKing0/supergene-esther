package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import java.util.Collection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerInputEventProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEventProcessor {

    @NotNull
    private final HitPathTracker hitPathTracker;

    @NotNull
    private final HitTestResult<PointerInputFilter> hitResult;
    private boolean isProcessing;

    @NotNull
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer;

    @NotNull
    private final LayoutNode root;

    public PointerInputEventProcessor(@NotNull LayoutNode root) {
        t.i(root, "root");
        this.root = root;
        this.hitPathTracker = new HitPathTracker(root.getCoordinates());
        this.pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.hitResult = new HitTestResult<>();
    }

    /* JADX INFO: renamed from: process-BIzXfog$default, reason: not valid java name */
    public static /* synthetic */ int m2891processBIzXfog$default(PointerInputEventProcessor pointerInputEventProcessor, PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return pointerInputEventProcessor.m2892processBIzXfog(pointerInputEvent, positionCalculator, z10);
    }

    @NotNull
    public final LayoutNode getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: process-BIzXfog, reason: not valid java name */
    public final int m2892processBIzXfog(@NotNull PointerInputEvent pointerEvent, @NotNull PositionCalculator positionCalculator, boolean z10) {
        boolean z11;
        t.i(pointerEvent, "pointerEvent");
        t.i(positionCalculator, "positionCalculator");
        if (this.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        boolean z12 = true;
        try {
            this.isProcessing = true;
            InternalPointerEvent internalPointerEventProduce = this.pointerInputChangeEventProducer.produce(pointerEvent, positionCalculator);
            Collection<PointerInputChange> collectionValues = internalPointerEventProduce.getChanges().values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                z11 = false;
            } else {
                for (PointerInputChange pointerInputChange : collectionValues) {
                    if (pointerInputChange.getPressed() || pointerInputChange.getPreviousPressed()) {
                        z11 = true;
                        break;
                    }
                }
                z11 = false;
            }
            boolean z13 = !z11;
            for (PointerInputChange pointerInputChange2 : internalPointerEventProduce.getChanges().values()) {
                if (z13 || PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange2)) {
                    LayoutNode.m3097hitTestM_7yMNQ$ui_release$default(this.root, pointerInputChange2.m2873getPositionF1C5BW0(), this.hitResult, PointerType.m2931equalsimpl0(pointerInputChange2.m2876getTypeT8wyACA(), PointerType.Companion.m2938getTouchT8wyACA()), false, 8, null);
                    if (!this.hitResult.isEmpty()) {
                        this.hitPathTracker.m2806addHitPathKNwqfcY(pointerInputChange2.m2872getIdJ3iCeTQ(), this.hitResult);
                        this.hitResult.clear();
                    }
                }
            }
            this.hitPathTracker.removeDetachedPointerInputFilters();
            boolean zDispatchChanges = this.hitPathTracker.dispatchChanges(internalPointerEventProduce, z10);
            if (internalPointerEventProduce.getSuppressMovementConsumption()) {
                z12 = false;
            } else {
                Collection<PointerInputChange> collectionValues2 = internalPointerEventProduce.getChanges().values();
                if (!(collectionValues2 instanceof Collection) || !collectionValues2.isEmpty()) {
                    for (PointerInputChange pointerInputChange3 : collectionValues2) {
                        if (PointerEventKt.positionChangedIgnoreConsumed(pointerInputChange3) && pointerInputChange3.isConsumed()) {
                            break;
                        }
                    }
                }
                z12 = false;
            }
            return PointerInputEventProcessorKt.ProcessResult(zDispatchChanges, z12);
        } finally {
            this.isProcessing = false;
        }
    }

    public final void processCancel() {
        this.pointerInputChangeEventProducer.clear();
        this.hitPathTracker.processCancel();
    }
}
