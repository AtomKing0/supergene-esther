package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class LinearGradient extends ShaderBrush {

    @NotNull
    private final List<Color> colors;
    private final long end;
    private final long start;

    @Nullable
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j10, long j11, int i10, kotlin.jvm.internal.k kVar) {
        this(list, list2, j10, j11, i10);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    @NotNull
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo1573createShaderuvyYCjk(long j10) {
        return ShaderKt.m1855LinearGradientShaderVjE6UOU(OffsetKt.Offset((Offset.m1367getXimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1367getXimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1436getWidthimpl(j10) : Offset.m1367getXimpl(this.start), (Offset.m1368getYimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1368getYimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1433getHeightimpl(j10) : Offset.m1368getYimpl(this.start)), OffsetKt.Offset((Offset.m1367getXimpl(this.end) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1367getXimpl(this.end) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1436getWidthimpl(j10) : Offset.m1367getXimpl(this.end), Offset.m1368getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m1433getHeightimpl(j10) : Offset.m1368getYimpl(this.end)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return kotlin.jvm.internal.t.d(this.colors, linearGradient.colors) && kotlin.jvm.internal.t.d(this.stops, linearGradient.stops) && Offset.m1364equalsimpl0(this.start, linearGradient.start) && Offset.m1364equalsimpl0(this.end, linearGradient.end) && TileMode.m1901equalsimpl0(this.tileMode, linearGradient.tileMode);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo1552getIntrinsicSizeNHjbRc() {
        /*
            r6 = this;
            long r0 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m1367getXimpl(r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L16
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L16
            r0 = r2
            goto L17
        L16:
            r0 = r3
        L17:
            r1 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == 0) goto L44
            long r4 = r6.end
            float r0 = androidx.compose.ui.geometry.Offset.m1367getXimpl(r4)
            boolean r4 = java.lang.Float.isInfinite(r0)
            if (r4 != 0) goto L2f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L2f
            r0 = r2
            goto L30
        L2f:
            r0 = r3
        L30:
            if (r0 == 0) goto L44
            long r4 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m1367getXimpl(r4)
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m1367getXimpl(r4)
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            goto L45
        L44:
            r0 = r1
        L45:
            long r4 = r6.start
            float r4 = androidx.compose.ui.geometry.Offset.m1368getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L59
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L59
            r4 = r2
            goto L5a
        L59:
            r4 = r3
        L5a:
            if (r4 == 0) goto L83
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m1368getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L6f
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            if (r2 == 0) goto L83
            long r1 = r6.start
            float r1 = androidx.compose.ui.geometry.Offset.m1368getYimpl(r1)
            long r2 = r6.end
            float r2 = androidx.compose.ui.geometry.Offset.m1368getYimpl(r2)
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
        L83:
            long r0 = androidx.compose.ui.geometry.SizeKt.Size(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.LinearGradient.mo1552getIntrinsicSizeNHjbRc():long");
    }

    public int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m1369hashCodeimpl(this.start)) * 31) + Offset.m1369hashCodeimpl(this.end)) * 31) + TileMode.m1902hashCodeimpl(this.tileMode);
    }

    @NotNull
    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m1384isFinitek4lQ0M(this.start)) {
            str = "start=" + ((Object) Offset.m1375toStringimpl(this.start)) + ", ";
        } else {
            str = "";
        }
        if (OffsetKt.m1384isFinitek4lQ0M(this.end)) {
            str2 = "end=" + ((Object) Offset.m1375toStringimpl(this.end)) + ", ";
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.m1903toStringimpl(this.tileMode)) + ')';
    }

    public /* synthetic */ LinearGradient(List list, List list2, long j10, long j11, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(list, (i11 & 2) != 0 ? null : list2, j10, j11, (i11 & 16) != 0 ? TileMode.Companion.m1905getClamp3opZhB0() : i10, null);
    }

    private LinearGradient(List<Color> list, List<Float> list2, long j10, long j11, int i10) {
        this.colors = list;
        this.stops = list2;
        this.start = j10;
        this.end = j11;
        this.tileMode = i10;
    }
}
