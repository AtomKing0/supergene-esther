package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Colors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColorsKt {

    @NotNull
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(ColorsKt$LocalColors$1.INSTANCE);

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m968contentColorFor4WTKRHQ(@NotNull Colors contentColorFor, long j10) {
        t.i(contentColorFor, "$this$contentColorFor");
        return Color.m1599equalsimpl0(j10, contentColorFor.m951getPrimary0d7_KjU()) ? contentColorFor.m948getOnPrimary0d7_KjU() : Color.m1599equalsimpl0(j10, contentColorFor.m952getPrimaryVariant0d7_KjU()) ? contentColorFor.m948getOnPrimary0d7_KjU() : Color.m1599equalsimpl0(j10, contentColorFor.m953getSecondary0d7_KjU()) ? contentColorFor.m949getOnSecondary0d7_KjU() : Color.m1599equalsimpl0(j10, contentColorFor.m954getSecondaryVariant0d7_KjU()) ? contentColorFor.m949getOnSecondary0d7_KjU() : Color.m1599equalsimpl0(j10, contentColorFor.m944getBackground0d7_KjU()) ? contentColorFor.m946getOnBackground0d7_KjU() : Color.m1599equalsimpl0(j10, contentColorFor.m955getSurface0d7_KjU()) ? contentColorFor.m950getOnSurface0d7_KjU() : Color.m1599equalsimpl0(j10, contentColorFor.m945getError0d7_KjU()) ? contentColorFor.m947getOnError0d7_KjU() : Color.Companion.m1634getUnspecified0d7_KjU();
    }

    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m969contentColorForek8zF_U(long j10, @Nullable Composer composer, int i10) {
        long jM968contentColorFor4WTKRHQ = m968contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j10);
        return (jM968contentColorFor4WTKRHQ > Color.Companion.m1634getUnspecified0d7_KjU() ? 1 : (jM968contentColorFor4WTKRHQ == Color.Companion.m1634getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? jM968contentColorFor4WTKRHQ : ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl();
    }

    @NotNull
    /* JADX INFO: renamed from: darkColors-2qZNXz8, reason: not valid java name */
    public static final Colors m970darkColors2qZNXz8(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21) {
        return new Colors(j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, false, null);
    }

    /* JADX INFO: renamed from: darkColors-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ Colors m971darkColors2qZNXz8$default(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, int i10, Object obj) {
        long jColor = (i10 & 1) != 0 ? ColorKt.Color(4290479868L) : j10;
        long jColor2 = (i10 & 2) != 0 ? ColorKt.Color(4281794739L) : j11;
        long jColor3 = (i10 & 4) != 0 ? ColorKt.Color(4278442694L) : j12;
        return m970darkColors2qZNXz8(jColor, jColor2, jColor3, (i10 & 8) != 0 ? jColor3 : j13, (i10 & 16) != 0 ? ColorKt.Color(4279374354L) : j14, (i10 & 32) != 0 ? ColorKt.Color(4279374354L) : j15, (i10 & 64) != 0 ? ColorKt.Color(4291782265L) : j16, (i10 & 128) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : j17, (i10 & 256) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : j18, (i10 & 512) != 0 ? Color.Companion.m1635getWhite0d7_KjU() : j19, (i10 & 1024) != 0 ? Color.Companion.m1635getWhite0d7_KjU() : j20, (i10 & 2048) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : j21);
    }

    @NotNull
    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }

    public static final long getPrimarySurface(@NotNull Colors colors) {
        t.i(colors, "<this>");
        return colors.isLight() ? colors.m951getPrimary0d7_KjU() : colors.m955getSurface0d7_KjU();
    }

    @NotNull
    /* JADX INFO: renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m972lightColors2qZNXz8(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21) {
        return new Colors(j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, true, null);
    }

    public static final void updateColorsFrom(@NotNull Colors colors, @NotNull Colors other) {
        t.i(colors, "<this>");
        t.i(other, "other");
        colors.m963setPrimary8_81llA$material_release(other.m951getPrimary0d7_KjU());
        colors.m964setPrimaryVariant8_81llA$material_release(other.m952getPrimaryVariant0d7_KjU());
        colors.m965setSecondary8_81llA$material_release(other.m953getSecondary0d7_KjU());
        colors.m966setSecondaryVariant8_81llA$material_release(other.m954getSecondaryVariant0d7_KjU());
        colors.m956setBackground8_81llA$material_release(other.m944getBackground0d7_KjU());
        colors.m967setSurface8_81llA$material_release(other.m955getSurface0d7_KjU());
        colors.m957setError8_81llA$material_release(other.m945getError0d7_KjU());
        colors.m960setOnPrimary8_81llA$material_release(other.m948getOnPrimary0d7_KjU());
        colors.m961setOnSecondary8_81llA$material_release(other.m949getOnSecondary0d7_KjU());
        colors.m958setOnBackground8_81llA$material_release(other.m946getOnBackground0d7_KjU());
        colors.m962setOnSurface8_81llA$material_release(other.m950getOnSurface0d7_KjU());
        colors.m959setOnError8_81llA$material_release(other.m947getOnError0d7_KjU());
        colors.setLight$material_release(other.isLight());
    }
}
