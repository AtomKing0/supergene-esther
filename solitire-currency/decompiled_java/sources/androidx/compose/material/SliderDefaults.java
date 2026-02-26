package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;

    @NotNull
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    private SliderDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m1122colorsq0g_0yA(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, @Nullable Composer composer, int i10, int i11, int i12) {
        long jM1644compositeOverOWjLjI;
        composer.startReplaceableGroup(436017687);
        long jM951getPrimary0d7_KjU = (i12 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j10;
        if ((i12 & 2) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM1644compositeOverOWjLjI = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(materialTheme.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            jM1644compositeOverOWjLjI = j11;
        }
        long jM951getPrimary0d7_KjU2 = (i12 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j12;
        long jM1597copywmQWz5c$default = (i12 & 8) != 0 ? Color.m1597copywmQWz5c$default(jM951getPrimary0d7_KjU2, 0.24f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long jM1597copywmQWz5c$default2 = (i12 & 16) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j14;
        long jM1597copywmQWz5c$default3 = (i12 & 32) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default2, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long jM1597copywmQWz5c$default4 = (i12 & 64) != 0 ? Color.m1597copywmQWz5c$default(ColorsKt.m969contentColorForek8zF_U(jM951getPrimary0d7_KjU2, composer, (i10 >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j16;
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(jM951getPrimary0d7_KjU, jM1644compositeOverOWjLjI, jM951getPrimary0d7_KjU2, jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, jM1597copywmQWz5c$default3, jM1597copywmQWz5c$default4, (i12 & 128) != 0 ? Color.m1597copywmQWz5c$default(jM951getPrimary0d7_KjU2, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j17, (i12 & 256) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default4, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j18, (i12 & 512) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default3, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j19, null);
        composer.endReplaceableGroup();
        return defaultSliderColors;
    }
}
