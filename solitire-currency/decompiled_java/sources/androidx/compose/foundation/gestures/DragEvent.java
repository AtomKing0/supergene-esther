package androidx.compose.foundation.gestures;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
abstract class DragEvent {

    /* JADX INFO: compiled from: Draggable.kt */
    @StabilityInferred(parameters = 0)
    public static final class DragCancelled extends DragEvent {
        public static final int $stable = 0;

        @NotNull
        public static final DragCancelled INSTANCE = new DragCancelled();

        private DragCancelled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: Draggable.kt */
    @StabilityInferred(parameters = 0)
    public static final class DragDelta extends DragEvent {
        public static final int $stable = 0;
        private final float delta;
        private final long pointerPosition;

        public /* synthetic */ DragDelta(float f10, long j10, k kVar) {
            this(f10, j10);
        }

        public final float getDelta() {
            return this.delta;
        }

        /* JADX INFO: renamed from: getPointerPosition-F1C5BW0, reason: not valid java name */
        public final long m243getPointerPositionF1C5BW0() {
            return this.pointerPosition;
        }

        private DragDelta(float f10, long j10) {
            super(null);
            this.delta = f10;
            this.pointerPosition = j10;
        }
    }

    /* JADX INFO: compiled from: Draggable.kt */
    @StabilityInferred(parameters = 0)
    public static final class DragStarted extends DragEvent {
        public static final int $stable = 0;
        private final long startPoint;

        public /* synthetic */ DragStarted(long j10, k kVar) {
            this(j10);
        }

        /* JADX INFO: renamed from: getStartPoint-F1C5BW0, reason: not valid java name */
        public final long m244getStartPointF1C5BW0() {
            return this.startPoint;
        }

        private DragStarted(long j10) {
            super(null);
            this.startPoint = j10;
        }
    }

    /* JADX INFO: compiled from: Draggable.kt */
    @StabilityInferred(parameters = 0)
    public static final class DragStopped extends DragEvent {
        public static final int $stable = 0;
        private final float velocity;

        public DragStopped(float f10) {
            super(null);
            this.velocity = f10;
        }

        public final float getVelocity() {
            return this.velocity;
        }
    }

    private DragEvent() {
    }

    public /* synthetic */ DragEvent(k kVar) {
        this();
    }
}
