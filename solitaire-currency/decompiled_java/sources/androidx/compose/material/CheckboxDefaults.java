package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CheckboxDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final CheckboxColors m916colorszjMxDiM(long j10, long j11, long j12, long j13, long j14, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(469524104);
        long jM953getSecondary0d7_KjU = (i11 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m953getSecondary0d7_KjU() : j10;
        long jM1597copywmQWz5c$default = (i11 & 2) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM955getSurface0d7_KjU = (i11 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU() : j12;
        long jM1597copywmQWz5c$default2 = (i11 & 8) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long jM1597copywmQWz5c$default3 = (i11 & 16) != 0 ? Color.m1597copywmQWz5c$default(jM953getSecondary0d7_KjU, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j14;
        Object[] objArr = {Color.m1588boximpl(jM953getSecondary0d7_KjU), Color.m1588boximpl(jM1597copywmQWz5c$default), Color.m1588boximpl(jM955getSurface0d7_KjU), Color.m1588boximpl(jM1597copywmQWz5c$default2), Color.m1588boximpl(jM1597copywmQWz5c$default3)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i12 = 0; i12 < 5; i12++) {
            zChanged |= composer.changed(objArr[i12]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultCheckboxColors(jM955getSurface0d7_KjU, Color.m1597copywmQWz5c$default(jM955getSurface0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM953getSecondary0d7_KjU, Color.m1597copywmQWz5c$default(jM953getSecondary0d7_KjU, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM1597copywmQWz5c$default2, Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default2, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), jM1597copywmQWz5c$default3, jM953getSecondary0d7_KjU, jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, jM1597copywmQWz5c$default3, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultCheckboxColors defaultCheckboxColors = (DefaultCheckboxColors) objRememberedValue;
        composer.endReplaceableGroup();
        return defaultCheckboxColors;
    }
}
