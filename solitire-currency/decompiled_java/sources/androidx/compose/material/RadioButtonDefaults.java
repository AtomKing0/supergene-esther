package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class RadioButtonDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m1117colorsRGew2ao(long j10, long j11, long j12, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1370708026);
        long jM953getSecondary0d7_KjU = (i11 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m953getSecondary0d7_KjU() : j10;
        long jM1597copywmQWz5c$default = (i11 & 2) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1597copywmQWz5c$default2 = (i11 & 4) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j12;
        Color colorM1588boximpl = Color.m1588boximpl(jM953getSecondary0d7_KjU);
        Color colorM1588boximpl2 = Color.m1588boximpl(jM1597copywmQWz5c$default);
        Color colorM1588boximpl3 = Color.m1588boximpl(jM1597copywmQWz5c$default2);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(colorM1588boximpl) | composer.changed(colorM1588boximpl2) | composer.changed(colorM1588boximpl3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultRadioButtonColors(jM953getSecondary0d7_KjU, jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) objRememberedValue;
        composer.endReplaceableGroup();
        return defaultRadioButtonColors;
    }
}
