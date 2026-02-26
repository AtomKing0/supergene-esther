package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Blur.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BlurKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m1276blur1fqSgw(@NotNull Modifier blur, float f10, float f11, @NotNull Shape shape) {
        boolean z10;
        int iM1906getDecal3opZhB0;
        t.i(blur, "$this$blur");
        if (shape != null) {
            iM1906getDecal3opZhB0 = TileMode.Companion.m1905getClamp3opZhB0();
            z10 = true;
        } else {
            z10 = false;
            iM1906getDecal3opZhB0 = TileMode.Companion.m1906getDecal3opZhB0();
        }
        float f12 = 0;
        return ((Dp.m3672compareTo0680j_4(f10, Dp.m3673constructorimpl(f12)) <= 0 || Dp.m3672compareTo0680j_4(f11, Dp.m3673constructorimpl(f12)) <= 0) && !z10) ? blur : GraphicsLayerModifierKt.graphicsLayer(blur, new BlurKt$blur$1(f10, f11, iM1906getDecal3opZhB0, shape, z10));
    }

    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1277blur1fqSgw$default(Modifier modifier, float f10, float f11, BlurredEdgeTreatment blurredEdgeTreatment, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m1280boximpl(BlurredEdgeTreatment.Companion.m1287getRectangleGoahg());
        }
        return m1276blur1fqSgw(modifier, f10, f11, blurredEdgeTreatment.m1286unboximpl());
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m1278blurF8QBwvs(@NotNull Modifier blur, float f10, @NotNull Shape shape) {
        t.i(blur, "$this$blur");
        return m1276blur1fqSgw(blur, f10, f10, shape);
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1279blurF8QBwvs$default(Modifier modifier, float f10, BlurredEdgeTreatment blurredEdgeTreatment, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m1280boximpl(BlurredEdgeTreatment.Companion.m1287getRectangleGoahg());
        }
        return m1278blurF8QBwvs(modifier, f10, blurredEdgeTreatment.m1286unboximpl());
    }
}
