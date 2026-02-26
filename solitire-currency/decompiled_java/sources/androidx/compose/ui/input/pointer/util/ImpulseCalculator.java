package androidx.compose.ui.input.pointer.util;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes.dex */
final class ImpulseCalculator {
    private float work;
    private long previousT = Long.MAX_VALUE;
    private float previousX = Float.NaN;
    private boolean initialCondition = true;

    public final void addPosition(long j10, float f10) {
        if (this.previousT == Long.MAX_VALUE || Float.isNaN(this.previousX)) {
            this.previousT = j10;
            this.previousX = f10;
            return;
        }
        if (j10 == this.previousT) {
            this.previousX = f10;
            return;
        }
        float fKineticEnergyToVelocity = VelocityTrackerKt.kineticEnergyToVelocity(this.work);
        float f11 = (f10 - this.previousX) / ((j10 - this.previousT) * 0.001f);
        float fAbs = this.work + ((f11 - fKineticEnergyToVelocity) * Math.abs(f11));
        this.work = fAbs;
        if (this.initialCondition) {
            this.work = fAbs * 0.5f;
            this.initialCondition = false;
        }
        this.previousT = j10;
        this.previousX = f10;
    }

    public final float getVelocity() {
        return VelocityTrackerKt.kineticEnergyToVelocity(this.work);
    }

    public final void reset() {
        this.work = 0.0f;
        this.previousT = Long.MAX_VALUE;
        this.previousX = Float.NaN;
        this.initialCondition = true;
    }
}
