package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SwitchDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors m1159colorsSQMK_m0(long j10, long j11, float f10, long j12, long j13, float f11, long j14, long j15, long j16, long j17, @Nullable Composer composer, int i10, int i11, int i12) {
        long j18;
        long jM1644compositeOverOWjLjI;
        float f12;
        long jM1644compositeOverOWjLjI2;
        long j19;
        int i13;
        long jM1644compositeOverOWjLjI3;
        composer.startReplaceableGroup(-1032127534);
        long jM954getSecondaryVariant0d7_KjU = (i12 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m954getSecondaryVariant0d7_KjU() : j10;
        long j20 = (i12 & 2) != 0 ? jM954getSecondaryVariant0d7_KjU : j11;
        float f13 = (i12 & 4) != 0 ? 0.54f : f10;
        long jM955getSurface0d7_KjU = (i12 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU() : j12;
        long jM950getOnSurface0d7_KjU = (i12 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU() : j13;
        float f14 = (i12 & 32) != 0 ? 0.38f : f11;
        if ((i12 & 64) != 0) {
            j18 = jM954getSecondaryVariant0d7_KjU;
            jM1644compositeOverOWjLjI = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(jM954getSecondaryVariant0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            j18 = jM954getSecondaryVariant0d7_KjU;
            jM1644compositeOverOWjLjI = j14;
        }
        if ((i12 & 128) != 0) {
            f12 = f14;
            jM1644compositeOverOWjLjI2 = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(j20, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            f12 = f14;
            jM1644compositeOverOWjLjI2 = j15;
        }
        if ((i12 & 256) != 0) {
            j19 = jM1644compositeOverOWjLjI;
            i13 = 6;
            jM1644compositeOverOWjLjI3 = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(jM955getSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            j19 = jM1644compositeOverOWjLjI;
            i13 = 6;
            jM1644compositeOverOWjLjI3 = j16;
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j18, Color.m1597copywmQWz5c$default(j20, f13, 0.0f, 0.0f, 0.0f, 14, null), jM955getSurface0d7_KjU, Color.m1597copywmQWz5c$default(jM950getOnSurface0d7_KjU, f12, 0.0f, 0.0f, 0.0f, 14, null), j19, Color.m1597copywmQWz5c$default(jM1644compositeOverOWjLjI2, f13, 0.0f, 0.0f, 0.0f, 14, null), jM1644compositeOverOWjLjI3, Color.m1597copywmQWz5c$default((i12 & 512) != 0 ? ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(jM950getOnSurface0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, i13), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU()) : j17, f12, 0.0f, 0.0f, 0.0f, 14, null), null);
        composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
