package androidx.transition;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f10) {
        return (float) (((double) Math.signum(f10)) * Math.sqrt(Math.abs(f10) * 2.0f));
    }

    public void addDataPoint(long j10, float f10) {
        int i10 = (this.mIndex + 1) % 20;
        this.mIndex = i10;
        this.mTimeSamples[i10] = j10;
        this.mDataSamples[i10] = f10;
    }

    float calculateVelocity() {
        float fKineticEnergyToVelocity;
        int i10 = this.mIndex;
        if (i10 == 0 && this.mTimeSamples[i10] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j10 = this.mTimeSamples[i10];
        int i11 = 0;
        long j11 = j10;
        while (true) {
            long j12 = this.mTimeSamples[i10];
            if (j12 == Long.MIN_VALUE) {
                break;
            }
            float f10 = j10 - j12;
            float fAbs = Math.abs(j12 - j11);
            if (f10 > 100.0f || fAbs > 40.0f) {
                break;
            }
            if (i10 == 0) {
                i10 = 20;
            }
            i10--;
            i11++;
            if (i11 >= 20) {
                break;
            }
            j11 = j12;
        }
        if (i11 < 2) {
            return 0.0f;
        }
        if (i11 == 2) {
            int i12 = this.mIndex;
            int i13 = i12 == 0 ? 19 : i12 - 1;
            long[] jArr = this.mTimeSamples;
            float f11 = jArr[i12] - jArr[i13];
            if (f11 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            fKineticEnergyToVelocity = (fArr[i12] - fArr[i13]) / f11;
        } else {
            int i14 = this.mIndex;
            int i15 = (((i14 - i11) + 20) + 1) % 20;
            int i16 = ((i14 + 1) + 20) % 20;
            long j13 = this.mTimeSamples[i15];
            float f12 = this.mDataSamples[i15];
            int i17 = i15 + 1;
            float fKineticEnergyToVelocity2 = 0.0f;
            for (int i18 = i17 % 20; i18 != i16; i18 = (i18 + 1) % 20) {
                long j14 = this.mTimeSamples[i18];
                float f13 = j14 - j13;
                if (f13 != 0.0f) {
                    float f14 = this.mDataSamples[i18];
                    float f15 = (f14 - f12) / f13;
                    fKineticEnergyToVelocity2 += (f15 - kineticEnergyToVelocity(fKineticEnergyToVelocity2)) * Math.abs(f15);
                    if (i18 == i17) {
                        fKineticEnergyToVelocity2 *= 0.5f;
                    }
                    f12 = f14;
                    j13 = j14;
                }
            }
            fKineticEnergyToVelocity = kineticEnergyToVelocity(fKineticEnergyToVelocity2);
        }
        return fKineticEnergyToVelocity * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
