package androidx.compose.ui.input.pointer.util;

import androidx.compose.animation.a;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes.dex */
final class VelocityEstimate {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final VelocityEstimate None;
    private final float confidence;
    private final long durationMillis;
    private final long offset;
    private final long pixelsPerSecond;

    /* JADX INFO: compiled from: VelocityTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final VelocityEstimate getNone() {
            return VelocityEstimate.None;
        }
    }

    static {
        Offset.Companion companion = Offset.Companion;
        None = new VelocityEstimate(companion.m1383getZeroF1C5BW0(), 1.0f, 0L, companion.m1383getZeroF1C5BW0(), null);
    }

    public /* synthetic */ VelocityEstimate(long j10, float f10, long j11, long j12, k kVar) {
        this(j10, f10, j11, j12);
    }

    /* JADX INFO: renamed from: component1-F1C5BW0, reason: not valid java name */
    public final long m2956component1F1C5BW0() {
        return this.pixelsPerSecond;
    }

    public final float component2() {
        return this.confidence;
    }

    public final long component3() {
        return this.durationMillis;
    }

    /* JADX INFO: renamed from: component4-F1C5BW0, reason: not valid java name */
    public final long m2957component4F1C5BW0() {
        return this.offset;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-PZAlG8E, reason: not valid java name */
    public final VelocityEstimate m2958copyPZAlG8E(long j10, float f10, long j11, long j12) {
        return new VelocityEstimate(j10, f10, j11, j12, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VelocityEstimate)) {
            return false;
        }
        VelocityEstimate velocityEstimate = (VelocityEstimate) obj;
        return Offset.m1364equalsimpl0(this.pixelsPerSecond, velocityEstimate.pixelsPerSecond) && t.d(Float.valueOf(this.confidence), Float.valueOf(velocityEstimate.confidence)) && this.durationMillis == velocityEstimate.durationMillis && Offset.m1364equalsimpl0(this.offset, velocityEstimate.offset);
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    /* JADX INFO: renamed from: getOffset-F1C5BW0, reason: not valid java name */
    public final long m2959getOffsetF1C5BW0() {
        return this.offset;
    }

    /* JADX INFO: renamed from: getPixelsPerSecond-F1C5BW0, reason: not valid java name */
    public final long m2960getPixelsPerSecondF1C5BW0() {
        return this.pixelsPerSecond;
    }

    public int hashCode() {
        return (((((Offset.m1369hashCodeimpl(this.pixelsPerSecond) * 31) + Float.floatToIntBits(this.confidence)) * 31) + a.a(this.durationMillis)) * 31) + Offset.m1369hashCodeimpl(this.offset);
    }

    @NotNull
    public String toString() {
        return "VelocityEstimate(pixelsPerSecond=" + ((Object) Offset.m1375toStringimpl(this.pixelsPerSecond)) + ", confidence=" + this.confidence + ", durationMillis=" + this.durationMillis + ", offset=" + ((Object) Offset.m1375toStringimpl(this.offset)) + ')';
    }

    private VelocityEstimate(long j10, float f10, long j11, long j12) {
        this.pixelsPerSecond = j10;
        this.confidence = f10;
        this.durationMillis = j11;
        this.offset = j12;
    }
}
