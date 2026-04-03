package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;

    @NotNull
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = Dp.m3673constructorimpl(32);
    private static final float OutlinedBorderSize = Dp.m3673constructorimpl(1);
    private static final float LeadingIconSize = Dp.m3673constructorimpl(20);
    private static final float SelectedIconSize = Dp.m3673constructorimpl(18);

    private ChipDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m931chipColors5tl4gsc(long j10, long j11, long j12, long j13, long j14, long j15, @Nullable Composer composer, int i10, int i11) {
        long jM1644compositeOverOWjLjI;
        long jM1644compositeOverOWjLjI2;
        composer.startReplaceableGroup(1838505436);
        if ((i11 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM1644compositeOverOWjLjI = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(materialTheme.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            jM1644compositeOverOWjLjI = j10;
        }
        long jM1597copywmQWz5c$default = (i11 & 2) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1597copywmQWz5c$default2 = (i11 & 4) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j12;
        if ((i11 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            jM1644compositeOverOWjLjI2 = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(materialTheme2.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            jM1644compositeOverOWjLjI2 = j13;
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(jM1644compositeOverOWjLjI, jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, jM1644compositeOverOWjLjI2, (i11 & 16) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j14, (i11 & 32) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j15, null);
        composer.endReplaceableGroup();
        return defaultChipColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m932filterChipColorsJ08w3E(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, @Nullable Composer composer, int i10, int i11) {
        long jM1644compositeOverOWjLjI;
        long jM1644compositeOverOWjLjI2;
        composer.startReplaceableGroup(830140629);
        if ((i11 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM1644compositeOverOWjLjI = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(materialTheme.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            jM1644compositeOverOWjLjI = j10;
        }
        long jM1597copywmQWz5c$default = (i11 & 2) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1597copywmQWz5c$default2 = (i11 & 4) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j12;
        if ((i11 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            jM1644compositeOverOWjLjI2 = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(materialTheme2.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            jM1644compositeOverOWjLjI2 = j13;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(jM1644compositeOverOWjLjI, jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, jM1644compositeOverOWjLjI2, (i11 & 16) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j14, (i11 & 32) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j15, (i11 & 64) != 0 ? ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), jM1644compositeOverOWjLjI) : j16, (i11 & 128) != 0 ? ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM1597copywmQWz5c$default) : j17, (i11 & 256) != 0 ? ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM1597copywmQWz5c$default2) : j18, null);
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m933getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m934getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    @Composable
    @NotNull
    public final BorderStroke getOutlinedBorder(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1650225597);
        BorderStroke borderStrokeM180BorderStrokecXLIe8U = BorderStrokeKt.m180BorderStrokecXLIe8U(OutlinedBorderSize, Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        composer.endReplaceableGroup();
        return borderStrokeM180BorderStrokecXLIe8U;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m935getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* JADX INFO: renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m936getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m937outlinedChipColors5tl4gsc(long j10, long j11, long j12, long j13, long j14, long j15, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1763922662);
        long jM955getSurface0d7_KjU = (i11 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU() : j10;
        long jM1597copywmQWz5c$default = (i11 & 2) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1597copywmQWz5c$default2 = (i11 & 4) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j12;
        ChipColors chipColorsM931chipColors5tl4gsc = m931chipColors5tl4gsc(jM955getSurface0d7_KjU, jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, (i11 & 8) != 0 ? jM955getSurface0d7_KjU : j13, (i11 & 16) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j14, (i11 & 32) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j15, composer, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (i10 & 3670016), 0);
        composer.endReplaceableGroup();
        return chipColorsM931chipColors5tl4gsc;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m938outlinedFilterChipColorsJ08w3E(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(346878099);
        long jM955getSurface0d7_KjU = (i11 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU() : j10;
        long jM1597copywmQWz5c$default = (i11 & 2) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1597copywmQWz5c$default2 = (i11 & 4) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j12;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(jM955getSurface0d7_KjU, jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, (i11 & 8) != 0 ? jM955getSurface0d7_KjU : j13, (i11 & 16) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j14, (i11 & 32) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j15, (i11 & 64) != 0 ? ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM955getSurface0d7_KjU) : j16, (i11 & 128) != 0 ? ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM1597copywmQWz5c$default) : j17, (i11 & 256) != 0 ? ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), jM1597copywmQWz5c$default2) : j18, null);
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }
}
