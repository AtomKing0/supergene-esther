package androidx.compose.ui.input.pointer.util;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.VelocityKt;
import java.util.ArrayList;
import kotlin.collections.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class VelocityTracker {
    public static final int $stable = 8;
    private int index;

    @NotNull
    private final PointAtTime[] samples;
    private final boolean useImpulse;

    public VelocityTracker() {
        PointAtTime[] pointAtTimeArr = new PointAtTime[20];
        for (int i10 = 0; i10 < 20; i10++) {
            pointAtTimeArr[i10] = null;
        }
        this.samples = pointAtTimeArr;
        this.useImpulse = true;
    }

    /* JADX INFO: renamed from: getImpulseVelocity-9UxMQ8M, reason: not valid java name */
    private final long m2961getImpulseVelocity9UxMQ8M() {
        PointAtTime pointAtTime = this.samples[this.index];
        if (pointAtTime == null) {
            return VelocityKt.Velocity(0.0f, 0.0f);
        }
        ImpulseCalculator impulseCalculator = new ImpulseCalculator();
        ImpulseCalculator impulseCalculator2 = new ImpulseCalculator();
        int i10 = this.index;
        int i11 = 0;
        PointAtTime pointAtTime2 = pointAtTime;
        do {
            i10 = (i10 + 1) % 20;
            PointAtTime pointAtTime3 = this.samples[i10];
            if (pointAtTime3 != null) {
                long time = pointAtTime.getTime() - pointAtTime3.getTime();
                long jAbs = Math.abs(pointAtTime3.getTime() - pointAtTime2.getTime());
                if (time <= 100) {
                    if (jAbs > 40) {
                        impulseCalculator.reset();
                        impulseCalculator2.reset();
                    }
                    long j10 = -time;
                    impulseCalculator.addPosition(j10, Offset.m1367getXimpl(pointAtTime3.m2954getPointF1C5BW0()));
                    impulseCalculator2.addPosition(j10, Offset.m1368getYimpl(pointAtTime3.m2954getPointF1C5BW0()));
                    i11++;
                }
                pointAtTime2 = pointAtTime;
            }
            if (i10 == this.index) {
                break;
            }
        } while (i11 < 20);
        return i11 < 3 ? VelocityKt.Velocity(0.0f, 0.0f) : VelocityKt.Velocity(impulseCalculator.getVelocity(), impulseCalculator2.getVelocity());
    }

    private final VelocityEstimate getLsq2VelocityEstimate() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i10 = this.index;
        PointAtTime pointAtTime = this.samples[i10];
        if (pointAtTime == null) {
            return VelocityEstimate.Companion.getNone();
        }
        int i11 = 0;
        PointAtTime pointAtTime2 = pointAtTime;
        while (true) {
            PointAtTime pointAtTime3 = this.samples[i10];
            if (pointAtTime3 == null) {
                break;
            }
            float time = pointAtTime.getTime() - pointAtTime3.getTime();
            float fAbs = Math.abs(pointAtTime3.getTime() - pointAtTime2.getTime());
            if (time > 100.0f || fAbs > 40.0f) {
                break;
            }
            long jM2954getPointF1C5BW0 = pointAtTime3.m2954getPointF1C5BW0();
            arrayList.add(Float.valueOf(Offset.m1367getXimpl(jM2954getPointF1C5BW0)));
            arrayList2.add(Float.valueOf(Offset.m1368getYimpl(jM2954getPointF1C5BW0)));
            arrayList3.add(Float.valueOf(-time));
            if (i10 == 0) {
                i10 = 20;
            }
            i10--;
            i11++;
            if (i11 >= 20) {
                pointAtTime2 = pointAtTime3;
                break;
            }
            pointAtTime2 = pointAtTime3;
        }
        if (i11 < 3) {
            return new VelocityEstimate(Offset.Companion.m1383getZeroF1C5BW0(), 1.0f, pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m1371minusMKHz9U(pointAtTime.m2954getPointF1C5BW0(), pointAtTime2.m2954getPointF1C5BW0()), null);
        }
        try {
            PolynomialFit polynomialFitPolyFitLeastSquares = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList, 2);
            PolynomialFit polynomialFitPolyFitLeastSquares2 = VelocityTrackerKt.polyFitLeastSquares(arrayList3, arrayList2, 2);
            float f10 = 1000;
            return new VelocityEstimate(OffsetKt.Offset(polynomialFitPolyFitLeastSquares.getCoefficients().get(1).floatValue() * f10, polynomialFitPolyFitLeastSquares2.getCoefficients().get(1).floatValue() * f10), polynomialFitPolyFitLeastSquares.getConfidence() * polynomialFitPolyFitLeastSquares2.getConfidence(), pointAtTime.getTime() - pointAtTime2.getTime(), Offset.m1371minusMKHz9U(pointAtTime.m2954getPointF1C5BW0(), pointAtTime2.m2954getPointF1C5BW0()), null);
        } catch (IllegalArgumentException unused) {
            return VelocityEstimate.Companion.getNone();
        }
    }

    /* JADX INFO: renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m2962addPositionUv8p0NA(long j10, long j11) {
        int i10 = (this.index + 1) % 20;
        this.index = i10;
        this.samples[i10] = new PointAtTime(j11, j10, null);
    }

    /* JADX INFO: renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m2963calculateVelocity9UxMQ8M() {
        if (this.useImpulse) {
            return m2961getImpulseVelocity9UxMQ8M();
        }
        long jM2960getPixelsPerSecondF1C5BW0 = getLsq2VelocityEstimate().m2960getPixelsPerSecondF1C5BW0();
        return VelocityKt.Velocity(Offset.m1367getXimpl(jM2960getPixelsPerSecondF1C5BW0), Offset.m1368getYimpl(jM2960getPixelsPerSecondF1C5BW0));
    }

    public final void resetTracking() {
        o.v(this.samples, null, 0, 0, 6, null);
    }
}
