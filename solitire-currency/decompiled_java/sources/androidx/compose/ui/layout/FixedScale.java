package androidx.compose.ui.layout;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContentScale.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class FixedScale implements ContentScale {
    private final float value;

    public FixedScale(float f10) {
        this.value = f10;
    }

    public static /* synthetic */ FixedScale copy$default(FixedScale fixedScale, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = fixedScale.value;
        }
        return fixedScale.copy(f10);
    }

    public final float component1() {
        return this.value;
    }

    @Override // androidx.compose.ui.layout.ContentScale
    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
    public long mo2978computeScaleFactorH7hwNQA(long j10, long j11) {
        float f10 = this.value;
        return ScaleFactorKt.ScaleFactor(f10, f10);
    }

    @NotNull
    public final FixedScale copy(float f10) {
        return new FixedScale(f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FixedScale) && t.d(Float.valueOf(this.value), Float.valueOf(((FixedScale) obj).value));
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    @NotNull
    public String toString() {
        return "FixedScale(value=" + this.value + ')';
    }
}
