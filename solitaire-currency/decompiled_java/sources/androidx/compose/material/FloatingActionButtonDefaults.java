package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Composable
    /* JADX INFO: renamed from: elevation-ixp7dh8, reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m1043elevationixp7dh8(float f10, float f11, Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-654132828);
        if ((i11 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(6);
        }
        float f12 = f10;
        if ((i11 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(12);
        }
        float f13 = 8;
        FloatingActionButtonElevation floatingActionButtonElevationM1044elevationxZ9QkE = m1044elevationxZ9QkE(f12, f11, Dp.m3673constructorimpl(f13), Dp.m3673constructorimpl(f13), composer, (i10 & 14) | 3456 | (i10 & 112) | (57344 & (i10 << 6)), 0);
        composer.endReplaceableGroup();
        return floatingActionButtonElevationM1044elevationxZ9QkE;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m1044elevationxZ9QkE(float f10, float f11, float f12, float f13, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(380403812);
        if ((i11 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(6);
        }
        float f14 = f10;
        if ((i11 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(12);
        }
        float f15 = f11;
        if ((i11 & 4) != 0) {
            f12 = Dp.m3673constructorimpl(8);
        }
        float f16 = f12;
        if ((i11 & 8) != 0) {
            f13 = Dp.m3673constructorimpl(8);
        }
        float f17 = f13;
        Object[] objArr = {Dp.m3671boximpl(f14), Dp.m3671boximpl(f15), Dp.m3671boximpl(f16), Dp.m3671boximpl(f17)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i12 = 0; i12 < 4; i12++) {
            zChanged |= composer.changed(objArr[i12]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultFloatingActionButtonElevation(f14, f15, f16, f17, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) objRememberedValue;
        composer.endReplaceableGroup();
        return defaultFloatingActionButtonElevation;
    }
}
