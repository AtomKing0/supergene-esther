package androidx.compose.animation.core;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpringSimulation {
    private double dampedFreq;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f10) {
        this.finalPosition = f10;
    }

    private final void init() {
        if (this.initialized) {
            return;
        }
        if (this.finalPosition == SpringSimulationKt.getUNSET()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f10 = this.dampingRatio;
        double d10 = ((double) f10) * ((double) f10);
        if (f10 > 1.0f) {
            double d11 = this.naturalFreq;
            double d12 = d10 - ((double) 1);
            this.gammaPlus = (((double) (-f10)) * d11) + (d11 * Math.sqrt(d12));
            double d13 = -this.dampingRatio;
            double d14 = this.naturalFreq;
            this.gammaMinus = (d13 * d14) - (d14 * Math.sqrt(d12));
        } else if (f10 >= 0.0f && f10 < 1.0f) {
            this.dampedFreq = this.naturalFreq * Math.sqrt(((double) 1) - d10);
        }
        this.initialized = true;
    }

    public final float getAcceleration(float f10, float f11) {
        float f12 = f10 - this.finalPosition;
        double d10 = this.naturalFreq;
        return (float) (((-(d10 * d10)) * ((double) f12)) - (((d10 * 2.0d) * ((double) this.dampingRatio)) * ((double) f11)));
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final float getStiffness() {
        double d10 = this.naturalFreq;
        return (float) (d10 * d10);
    }

    public final void setDampingRatio(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f10;
        this.initialized = false;
    }

    public final void setFinalPosition(float f10) {
        this.finalPosition = f10;
    }

    public final void setStiffness(float f10) {
        if (getStiffness() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f10);
        this.initialized = false;
    }

    /* JADX INFO: renamed from: updateValues-IJZedt4$animation_core_release, reason: not valid java name */
    public final long m120updateValuesIJZedt4$animation_core_release(float f10, float f11, long j10) {
        double dCos;
        double dExp;
        init();
        float f12 = f10 - this.finalPosition;
        double d10 = j10 / 1000.0d;
        float f13 = this.dampingRatio;
        if (f13 > 1.0f) {
            double d11 = f12;
            double d12 = this.gammaMinus;
            double d13 = f11;
            double d14 = this.gammaPlus;
            double d15 = d11 - (((d12 * d11) - d13) / (d12 - d14));
            double d16 = ((d11 * d12) - d13) / (d12 - d14);
            dExp = (Math.exp(d12 * d10) * d15) + (Math.exp(this.gammaPlus * d10) * d16);
            double d17 = this.gammaMinus;
            double dExp2 = d15 * d17 * Math.exp(d17 * d10);
            double d18 = this.gammaPlus;
            dCos = dExp2 + (d16 * d18 * Math.exp(d18 * d10));
        } else {
            if (f13 == 1.0f) {
                double d19 = this.naturalFreq;
                double d20 = f12;
                double d21 = ((double) f11) + (d19 * d20);
                double d22 = d20 + (d21 * d10);
                double dExp3 = Math.exp((-d19) * d10) * d22;
                double dExp4 = d22 * Math.exp((-this.naturalFreq) * d10);
                double d23 = this.naturalFreq;
                dCos = (dExp4 * (-d23)) + (d21 * Math.exp((-d23) * d10));
                dExp = dExp3;
            } else {
                double d24 = ((double) 1) / this.dampedFreq;
                double d25 = this.naturalFreq;
                double d26 = f12;
                double d27 = d24 * ((((double) f13) * d25 * d26) + ((double) f11));
                double dExp5 = Math.exp(((double) (-f13)) * d25 * d10) * ((Math.cos(this.dampedFreq * d10) * d26) + (Math.sin(this.dampedFreq * d10) * d27));
                double d28 = this.naturalFreq;
                float f14 = this.dampingRatio;
                double d29 = (-d28) * dExp5 * ((double) f14);
                double dExp6 = Math.exp(((double) (-f14)) * d28 * d10);
                double d30 = this.dampedFreq;
                double dSin = (-d30) * d26 * Math.sin(d30 * d10);
                double d31 = this.dampedFreq;
                dCos = d29 + (dExp6 * (dSin + (d27 * d31 * Math.cos(d31 * d10))));
                dExp = dExp5;
            }
        }
        return SpringSimulationKt.Motion((float) (dExp + ((double) this.finalPosition)), (float) dCos);
    }
}
