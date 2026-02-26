package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WhitePoint.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WhitePoint {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f773x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f774y;

    public WhitePoint(float f10, float f11) {
        this.f773x = f10;
        this.f774y = f11;
    }

    public static /* synthetic */ WhitePoint copy$default(WhitePoint whitePoint, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = whitePoint.f773x;
        }
        if ((i10 & 2) != 0) {
            f11 = whitePoint.f774y;
        }
        return whitePoint.copy(f10, f11);
    }

    public final float component1() {
        return this.f773x;
    }

    public final float component2() {
        return this.f774y;
    }

    @NotNull
    public final WhitePoint copy(float f10, float f11) {
        return new WhitePoint(f10, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) obj;
        return t.d(Float.valueOf(this.f773x), Float.valueOf(whitePoint.f773x)) && t.d(Float.valueOf(this.f774y), Float.valueOf(whitePoint.f774y));
    }

    public final float getX() {
        return this.f773x;
    }

    public final float getY() {
        return this.f774y;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f773x) * 31) + Float.floatToIntBits(this.f774y);
    }

    @NotNull
    public String toString() {
        return "WhitePoint(x=" + this.f773x + ", y=" + this.f774y + ')';
    }

    @NotNull
    public final float[] toXyz$ui_graphics_release() {
        float f10 = this.f773x;
        float f11 = this.f774y;
        return new float[]{f10 / f11, 1.0f, ((1.0f - f10) - f11) / f11};
    }

    public WhitePoint(float f10, float f11, float f12) {
        this(f10, f11, f12, f10 + f11 + f12);
    }

    private WhitePoint(float f10, float f11, float f12, float f13) {
        this(f10 / f13, f11 / f13);
    }
}
