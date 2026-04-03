package androidx.compose.ui.input.pointer.util;

import androidx.compose.animation.a;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes.dex */
final class PointAtTime {
    private final long point;
    private final long time;

    public /* synthetic */ PointAtTime(long j10, long j11, k kVar) {
        this(j10, j11);
    }

    /* JADX INFO: renamed from: copy-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ PointAtTime m2951copy3MmeM6k$default(PointAtTime pointAtTime, long j10, long j11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = pointAtTime.point;
        }
        if ((i10 & 2) != 0) {
            j11 = pointAtTime.time;
        }
        return pointAtTime.m2953copy3MmeM6k(j10, j11);
    }

    /* JADX INFO: renamed from: component1-F1C5BW0, reason: not valid java name */
    public final long m2952component1F1C5BW0() {
        return this.point;
    }

    public final long component2() {
        return this.time;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-3MmeM6k, reason: not valid java name */
    public final PointAtTime m2953copy3MmeM6k(long j10, long j11) {
        return new PointAtTime(j10, j11, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointAtTime)) {
            return false;
        }
        PointAtTime pointAtTime = (PointAtTime) obj;
        return Offset.m1364equalsimpl0(this.point, pointAtTime.point) && this.time == pointAtTime.time;
    }

    /* JADX INFO: renamed from: getPoint-F1C5BW0, reason: not valid java name */
    public final long m2954getPointF1C5BW0() {
        return this.point;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (Offset.m1369hashCodeimpl(this.point) * 31) + a.a(this.time);
    }

    @NotNull
    public String toString() {
        return "PointAtTime(point=" + ((Object) Offset.m1375toStringimpl(this.point)) + ", time=" + this.time + ')';
    }

    private PointAtTime(long j10, long j11) {
        this.point = j10;
        this.time = j11;
    }
}
