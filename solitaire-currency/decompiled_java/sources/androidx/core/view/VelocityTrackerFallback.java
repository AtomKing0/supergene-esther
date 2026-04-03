package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    VelocityTrackerFallback() {
    }

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j10;
        int i10 = this.mDataPointsBufferSize;
        if (i10 < 2) {
            return 0.0f;
        }
        int i11 = this.mDataPointsBufferLastUsedIndex;
        int i12 = ((i11 + 20) - (i10 - 1)) % 20;
        long j11 = this.mEventTimes[i11];
        while (true) {
            jArr = this.mEventTimes;
            j10 = jArr[i12];
            if (j11 - j10 <= 100) {
                break;
            }
            this.mDataPointsBufferSize--;
            i12 = (i12 + 1) % 20;
        }
        int i13 = this.mDataPointsBufferSize;
        if (i13 < 2) {
            return 0.0f;
        }
        if (i13 == 2) {
            int i14 = (i12 + 1) % 20;
            if (j10 == jArr[i14]) {
                return 0.0f;
            }
            return this.mMovements[i14] / (r2 - j10);
        }
        float fAbs = 0.0f;
        int i15 = 0;
        for (int i16 = 0; i16 < this.mDataPointsBufferSize - 1; i16++) {
            int i17 = i16 + i12;
            long[] jArr2 = this.mEventTimes;
            long j12 = jArr2[i17 % 20];
            int i18 = (i17 + 1) % 20;
            if (jArr2[i18] != j12) {
                i15++;
                float fKineticEnergyToVelocity = kineticEnergyToVelocity(fAbs);
                float f10 = this.mMovements[i18] / (this.mEventTimes[i18] - j12);
                fAbs += (f10 - fKineticEnergyToVelocity) * Math.abs(f10);
                if (i15 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(fAbs);
    }

    private static float kineticEnergyToVelocity(float f10) {
        return (f10 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f10) * 2.0f));
    }

    void addMovement(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i10 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i10;
        int i11 = this.mDataPointsBufferSize;
        if (i11 != 20) {
            this.mDataPointsBufferSize = i11 + 1;
        }
        this.mMovements[i10] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    void computeCurrentVelocity(int i10) {
        computeCurrentVelocity(i10, Float.MAX_VALUE);
    }

    float getAxisVelocity(int i10) {
        if (i10 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    void computeCurrentVelocity(int i10, float f10) {
        float currentVelocity = getCurrentVelocity() * i10;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f10))) {
            this.mLastComputedVelocity = -Math.abs(f10);
        } else if (this.mLastComputedVelocity > Math.abs(f10)) {
            this.mLastComputedVelocity = Math.abs(f10);
        }
    }
}
