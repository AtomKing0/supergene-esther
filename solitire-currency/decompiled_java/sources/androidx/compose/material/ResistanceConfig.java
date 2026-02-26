package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ResistanceConfig {
    private final float basis;
    private final float factorAtMax;
    private final float factorAtMin;

    public ResistanceConfig(float f10, float f11, float f12) {
        this.basis = f10;
        this.factorAtMin = f11;
        this.factorAtMax = f12;
    }

    public final float computeResistance(float f10) {
        float f11 = f10 < 0.0f ? this.factorAtMin : this.factorAtMax;
        if (f11 == 0.0f) {
            return 0.0f;
        }
        return (this.basis / f11) * ((float) Math.sin((o.m(f10 / this.basis, -1.0f, 1.0f) * 3.1415927f) / 2));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResistanceConfig)) {
            return false;
        }
        ResistanceConfig resistanceConfig = (ResistanceConfig) obj;
        if (!(this.basis == resistanceConfig.basis)) {
            return false;
        }
        if (this.factorAtMin == resistanceConfig.factorAtMin) {
            return (this.factorAtMax > resistanceConfig.factorAtMax ? 1 : (this.factorAtMax == resistanceConfig.factorAtMax ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float getBasis() {
        return this.basis;
    }

    public final float getFactorAtMax() {
        return this.factorAtMax;
    }

    public final float getFactorAtMin() {
        return this.factorAtMin;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.basis) * 31) + Float.floatToIntBits(this.factorAtMin)) * 31) + Float.floatToIntBits(this.factorAtMax);
    }

    @NotNull
    public String toString() {
        return "ResistanceConfig(basis=" + this.basis + ", factorAtMin=" + this.factorAtMin + ", factorAtMax=" + this.factorAtMax + ')';
    }

    public /* synthetic */ ResistanceConfig(float f10, float f11, float f12, int i10, k kVar) {
        this(f10, (i10 & 2) != 0 ? 10.0f : f11, (i10 & 4) != 0 ? 10.0f : f12);
    }
}
