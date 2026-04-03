package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class RadialGradient extends ShaderBrush {
    private final long center;

    @NotNull
    private final List<Color> colors;
    private final float radius;

    @Nullable
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RadialGradient(List list, List list2, long j10, float f10, int i10, kotlin.jvm.internal.k kVar) {
        this(list, list2, j10, f10, i10);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    @NotNull
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo1573createShaderuvyYCjk(long j10) {
        float fM1436getWidthimpl;
        float fM1433getHeightimpl;
        if (OffsetKt.m1388isUnspecifiedk4lQ0M(this.center)) {
            long jM1446getCenteruvyYCjk = SizeKt.m1446getCenteruvyYCjk(j10);
            fM1436getWidthimpl = Offset.m1367getXimpl(jM1446getCenteruvyYCjk);
            fM1433getHeightimpl = Offset.m1368getYimpl(jM1446getCenteruvyYCjk);
        } else {
            fM1436getWidthimpl = (Offset.m1367getXimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1367getXimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1436getWidthimpl(j10) : Offset.m1367getXimpl(this.center);
            fM1433getHeightimpl = (Offset.m1368getYimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1368getYimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1433getHeightimpl(j10) : Offset.m1368getYimpl(this.center);
        }
        List<Color> list = this.colors;
        List<Float> list2 = this.stops;
        long jOffset = OffsetKt.Offset(fM1436getWidthimpl, fM1433getHeightimpl);
        float f10 = this.radius;
        return ShaderKt.m1857RadialGradientShader8uybcMk(jOffset, f10 == Float.POSITIVE_INFINITY ? Size.m1435getMinDimensionimpl(j10) / 2 : f10, list, list2, this.tileMode);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        if (kotlin.jvm.internal.t.d(this.colors, radialGradient.colors) && kotlin.jvm.internal.t.d(this.stops, radialGradient.stops) && Offset.m1364equalsimpl0(this.center, radialGradient.center)) {
            return ((this.radius > radialGradient.radius ? 1 : (this.radius == radialGradient.radius ? 0 : -1)) == 0) && TileMode.m1901equalsimpl0(this.tileMode, radialGradient.tileMode);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long mo1552getIntrinsicSizeNHjbRc() {
        float f10 = this.radius;
        if (!((Float.isInfinite(f10) || Float.isNaN(f10)) ? false : true)) {
            return Size.Companion.m1444getUnspecifiedNHjbRc();
        }
        float f11 = this.radius;
        float f12 = 2;
        return SizeKt.Size(f11 * f12, f11 * f12);
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m1369hashCodeimpl(this.center)) * 31) + Float.floatToIntBits(this.radius)) * 31) + TileMode.m1902hashCodeimpl(this.tileMode);
    }

    @NotNull
    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m1386isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m1375toStringimpl(this.center)) + ", ";
        } else {
            str = "";
        }
        float f10 = this.radius;
        if ((Float.isInfinite(f10) || Float.isNaN(f10)) ? false : true) {
            str2 = "radius=" + this.radius + ", ";
        }
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.m1903toStringimpl(this.tileMode)) + ')';
    }

    public /* synthetic */ RadialGradient(List list, List list2, long j10, float f10, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(list, (i11 & 2) != 0 ? null : list2, j10, f10, (i11 & 16) != 0 ? TileMode.Companion.m1905getClamp3opZhB0() : i10, null);
    }

    private RadialGradient(List<Color> list, List<Float> list2, long j10, float f10, int i10) {
        this.colors = list;
        this.stops = list2;
        this.center = j10;
        this.radius = f10;
        this.tileMode = i10;
    }
}
