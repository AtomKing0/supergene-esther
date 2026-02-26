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
public final class SweepGradient extends ShaderBrush {
    private final long center;

    @NotNull
    private final List<Color> colors;

    @Nullable
    private final List<Float> stops;

    public /* synthetic */ SweepGradient(long j10, List list, List list2, kotlin.jvm.internal.k kVar) {
        this(j10, list, list2);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    @NotNull
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public Shader mo1573createShaderuvyYCjk(long j10) {
        long jOffset;
        if (OffsetKt.m1388isUnspecifiedk4lQ0M(this.center)) {
            jOffset = SizeKt.m1446getCenteruvyYCjk(j10);
        } else {
            jOffset = OffsetKt.Offset((Offset.m1367getXimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1367getXimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1436getWidthimpl(j10) : Offset.m1367getXimpl(this.center), Offset.m1368getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m1433getHeightimpl(j10) : Offset.m1368getYimpl(this.center));
        }
        return ShaderKt.m1859SweepGradientShader9KIMszo(jOffset, this.colors, this.stops);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) obj;
        return Offset.m1364equalsimpl0(this.center, sweepGradient.center) && kotlin.jvm.internal.t.d(this.colors, sweepGradient.colors) && kotlin.jvm.internal.t.d(this.stops, sweepGradient.stops);
    }

    public int hashCode() {
        int iM1369hashCodeimpl = ((Offset.m1369hashCodeimpl(this.center) * 31) + this.colors.hashCode()) * 31;
        List<Float> list = this.stops;
        return iM1369hashCodeimpl + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str;
        if (OffsetKt.m1386isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m1375toStringimpl(this.center)) + ", ";
        } else {
            str = "";
        }
        return "SweepGradient(" + str + "colors=" + this.colors + ", stops=" + this.stops + ')';
    }

    public /* synthetic */ SweepGradient(long j10, List list, List list2, int i10, kotlin.jvm.internal.k kVar) {
        this(j10, list, (i10 & 4) != 0 ? null : list2, null);
    }

    private SweepGradient(long j10, List<Color> list, List<Float> list2) {
        this.center = j10;
        this.colors = list;
        this.stops = list2;
    }
}
