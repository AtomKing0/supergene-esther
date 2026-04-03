package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import j9.c;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    @Stable
    public static int a(Density density, long j10) {
        return c.c(density.mo295toPxR2X_6o(j10));
    }

    @Stable
    public static int b(Density density, float f10) {
        float fMo296toPx0680j_4 = density.mo296toPx0680j_4(f10);
        if (Float.isInfinite(fMo296toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return c.c(fMo296toPx0680j_4);
    }

    @Stable
    public static float c(Density density, long j10) {
        if (TextUnitType.m3882equalsimpl0(TextUnit.m3853getTypeUIouoOA(j10), TextUnitType.Companion.m3887getSpUIouoOA())) {
            return Dp.m3673constructorimpl(TextUnit.m3854getValueimpl(j10) * density.getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    @Stable
    public static float d(Density density, float f10) {
        return Dp.m3673constructorimpl(f10 / density.getDensity());
    }

    @Stable
    public static float e(Density density, int i10) {
        return Dp.m3673constructorimpl(i10 / density.getDensity());
    }

    @Stable
    public static long f(Density density, long j10) {
        return (j10 > Size.Companion.m1444getUnspecifiedNHjbRc() ? 1 : (j10 == Size.Companion.m1444getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? DpKt.m3695DpSizeYgX7TsA(density.mo292toDpu2uoSUM(Size.m1436getWidthimpl(j10)), density.mo292toDpu2uoSUM(Size.m1433getHeightimpl(j10))) : DpSize.Companion.m3780getUnspecifiedMYxV2XQ();
    }

    @Stable
    public static float g(Density density, long j10) {
        if (TextUnitType.m3882equalsimpl0(TextUnit.m3853getTypeUIouoOA(j10), TextUnitType.Companion.m3887getSpUIouoOA())) {
            return TextUnit.m3854getValueimpl(j10) * density.getFontScale() * density.getDensity();
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    @Stable
    public static float h(Density density, float f10) {
        return f10 * density.getDensity();
    }

    @Stable
    @NotNull
    public static Rect i(Density density, @NotNull DpRect dpRect) {
        t.i(dpRect, "<this>");
        return new Rect(density.mo296toPx0680j_4(dpRect.m3756getLeftD9Ej5fM()), density.mo296toPx0680j_4(dpRect.m3758getTopD9Ej5fM()), density.mo296toPx0680j_4(dpRect.m3757getRightD9Ej5fM()), density.mo296toPx0680j_4(dpRect.m3755getBottomD9Ej5fM()));
    }

    @Stable
    public static long j(Density density, long j10) {
        return (j10 > DpSize.Companion.m3780getUnspecifiedMYxV2XQ() ? 1 : (j10 == DpSize.Companion.m3780getUnspecifiedMYxV2XQ() ? 0 : -1)) != 0 ? SizeKt.Size(density.mo296toPx0680j_4(DpSize.m3771getWidthD9Ej5fM(j10)), density.mo296toPx0680j_4(DpSize.m3769getHeightD9Ej5fM(j10))) : Size.Companion.m1444getUnspecifiedNHjbRc();
    }

    @Stable
    public static long k(Density density, float f10) {
        return TextUnitKt.getSp(f10 / density.getFontScale());
    }

    @Stable
    public static long l(Density density, float f10) {
        return TextUnitKt.getSp(f10 / (density.getFontScale() * density.getDensity()));
    }

    @Stable
    public static long m(Density density, int i10) {
        return TextUnitKt.getSp(i10 / (density.getFontScale() * density.getDensity()));
    }
}
