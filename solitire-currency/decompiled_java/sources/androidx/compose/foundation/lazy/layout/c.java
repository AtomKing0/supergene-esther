package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;

/* JADX INFO: compiled from: LazyLayoutMeasureScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c {
    @Stable
    public static float a(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j10) {
        if (TextUnitType.m3882equalsimpl0(TextUnit.m3853getTypeUIouoOA(j10), TextUnitType.Companion.m3887getSpUIouoOA())) {
            return Dp.m3673constructorimpl(TextUnit.m3854getValueimpl(j10) * lazyLayoutMeasureScope.getFontScale());
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    @Stable
    public static float b(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f10) {
        return Dp.m3673constructorimpl(f10 / lazyLayoutMeasureScope.getDensity());
    }

    @Stable
    public static float c(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i10) {
        return Dp.m3673constructorimpl(i10 / lazyLayoutMeasureScope.getDensity());
    }

    @Stable
    public static long d(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j10) {
        return (j10 > Size.Companion.m1444getUnspecifiedNHjbRc() ? 1 : (j10 == Size.Companion.m1444getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? DpKt.m3695DpSizeYgX7TsA(lazyLayoutMeasureScope.mo292toDpu2uoSUM(Size.m1436getWidthimpl(j10)), lazyLayoutMeasureScope.mo292toDpu2uoSUM(Size.m1433getHeightimpl(j10))) : DpSize.Companion.m3780getUnspecifiedMYxV2XQ();
    }

    @Stable
    public static long e(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j10) {
        return (j10 > DpSize.Companion.m3780getUnspecifiedMYxV2XQ() ? 1 : (j10 == DpSize.Companion.m3780getUnspecifiedMYxV2XQ() ? 0 : -1)) != 0 ? SizeKt.Size(lazyLayoutMeasureScope.mo296toPx0680j_4(DpSize.m3771getWidthD9Ej5fM(j10)), lazyLayoutMeasureScope.mo296toPx0680j_4(DpSize.m3769getHeightD9Ej5fM(j10))) : Size.Companion.m1444getUnspecifiedNHjbRc();
    }

    @Stable
    public static long f(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f10) {
        return TextUnitKt.getSp(f10 / lazyLayoutMeasureScope.getFontScale());
    }

    @Stable
    public static long g(LazyLayoutMeasureScope lazyLayoutMeasureScope, float f10) {
        return TextUnitKt.getSp(f10 / (lazyLayoutMeasureScope.getFontScale() * lazyLayoutMeasureScope.getDensity()));
    }

    @Stable
    public static long h(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i10) {
        return TextUnitKt.getSp(i10 / (lazyLayoutMeasureScope.getFontScale() * lazyLayoutMeasureScope.getDensity()));
    }
}
