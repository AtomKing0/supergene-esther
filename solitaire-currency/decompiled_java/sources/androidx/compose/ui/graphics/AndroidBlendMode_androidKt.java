package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.BlendMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidBlendMode.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidBlendMode_androidKt {
    /* JADX INFO: renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m1458isSupporteds9anfk8(int i10) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m1517equalsimpl0(i10, BlendMode.Companion.m1548getSrcOver0nO6VwU()) || m1460toPorterDuffModes9anfk8(i10) != PorterDuff.Mode.SRC_OVER;
    }

    @RequiresApi(29)
    @NotNull
    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m1459toAndroidBlendModes9anfk8(int i10) {
        BlendMode.Companion companion = BlendMode.Companion;
        return BlendMode.m1517equalsimpl0(i10, companion.m1521getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m1517equalsimpl0(i10, companion.m1544getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m1517equalsimpl0(i10, companion.m1527getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m1517equalsimpl0(i10, companion.m1548getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m1517equalsimpl0(i10, companion.m1531getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m1517equalsimpl0(i10, companion.m1546getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m1517equalsimpl0(i10, companion.m1529getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m1517equalsimpl0(i10, companion.m1547getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m1517equalsimpl0(i10, companion.m1530getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m1517equalsimpl0(i10, companion.m1545getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m1517equalsimpl0(i10, companion.m1528getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m1517equalsimpl0(i10, companion.m1549getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m1517equalsimpl0(i10, companion.m1540getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m1517equalsimpl0(i10, companion.m1537getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m1517equalsimpl0(i10, companion.m1542getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m1517equalsimpl0(i10, companion.m1539getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m1517equalsimpl0(i10, companion.m1525getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m1517equalsimpl0(i10, companion.m1535getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m1517equalsimpl0(i10, companion.m1524getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m1517equalsimpl0(i10, companion.m1523getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m1517equalsimpl0(i10, companion.m1533getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m1517equalsimpl0(i10, companion.m1543getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m1517equalsimpl0(i10, companion.m1526getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m1517equalsimpl0(i10, companion.m1532getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m1517equalsimpl0(i10, companion.m1538getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m1517equalsimpl0(i10, companion.m1534getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m1517equalsimpl0(i10, companion.m1541getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m1517equalsimpl0(i10, companion.m1522getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m1517equalsimpl0(i10, companion.m1536getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    @NotNull
    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m1460toPorterDuffModes9anfk8(int i10) {
        BlendMode.Companion companion = BlendMode.Companion;
        return BlendMode.m1517equalsimpl0(i10, companion.m1521getClear0nO6VwU()) ? PorterDuff.Mode.CLEAR : BlendMode.m1517equalsimpl0(i10, companion.m1544getSrc0nO6VwU()) ? PorterDuff.Mode.SRC : BlendMode.m1517equalsimpl0(i10, companion.m1527getDst0nO6VwU()) ? PorterDuff.Mode.DST : BlendMode.m1517equalsimpl0(i10, companion.m1548getSrcOver0nO6VwU()) ? PorterDuff.Mode.SRC_OVER : BlendMode.m1517equalsimpl0(i10, companion.m1531getDstOver0nO6VwU()) ? PorterDuff.Mode.DST_OVER : BlendMode.m1517equalsimpl0(i10, companion.m1546getSrcIn0nO6VwU()) ? PorterDuff.Mode.SRC_IN : BlendMode.m1517equalsimpl0(i10, companion.m1529getDstIn0nO6VwU()) ? PorterDuff.Mode.DST_IN : BlendMode.m1517equalsimpl0(i10, companion.m1547getSrcOut0nO6VwU()) ? PorterDuff.Mode.SRC_OUT : BlendMode.m1517equalsimpl0(i10, companion.m1530getDstOut0nO6VwU()) ? PorterDuff.Mode.DST_OUT : BlendMode.m1517equalsimpl0(i10, companion.m1545getSrcAtop0nO6VwU()) ? PorterDuff.Mode.SRC_ATOP : BlendMode.m1517equalsimpl0(i10, companion.m1528getDstAtop0nO6VwU()) ? PorterDuff.Mode.DST_ATOP : BlendMode.m1517equalsimpl0(i10, companion.m1549getXor0nO6VwU()) ? PorterDuff.Mode.XOR : BlendMode.m1517equalsimpl0(i10, companion.m1540getPlus0nO6VwU()) ? PorterDuff.Mode.ADD : BlendMode.m1517equalsimpl0(i10, companion.m1542getScreen0nO6VwU()) ? PorterDuff.Mode.SCREEN : BlendMode.m1517equalsimpl0(i10, companion.m1539getOverlay0nO6VwU()) ? PorterDuff.Mode.OVERLAY : BlendMode.m1517equalsimpl0(i10, companion.m1525getDarken0nO6VwU()) ? PorterDuff.Mode.DARKEN : BlendMode.m1517equalsimpl0(i10, companion.m1535getLighten0nO6VwU()) ? PorterDuff.Mode.LIGHTEN : BlendMode.m1517equalsimpl0(i10, companion.m1537getModulate0nO6VwU()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
