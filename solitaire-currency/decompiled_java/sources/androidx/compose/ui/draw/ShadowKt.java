package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ShadowKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: shadow-s4CzXII, reason: not valid java name */
    public static final Modifier m1295shadows4CzXII(@NotNull Modifier shadow, float f10, @NotNull Shape shape, boolean z10, long j10, long j11) {
        t.i(shadow, "$this$shadow");
        t.i(shape, "shape");
        if (Dp.m3672compareTo0680j_4(f10, Dp.m3673constructorimpl(0)) > 0 || z10) {
            return InspectableValueKt.inspectableWrapper(shadow, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ShadowKt$shadows4CzXII$$inlined$debugInspectorInfo$1(f10, shape, z10, j10, j11) : InspectableValueKt.getNoInspectorInfo(), GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new ShadowKt$shadow$2$1(f10, shape, z10, j10, j11)));
        }
        return shadow;
    }

    /* JADX INFO: renamed from: shadow-s4CzXII$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1296shadows4CzXII$default(Modifier modifier, float f10, Shape shape, boolean z10, long j10, long j11, int i10, Object obj) {
        boolean z11;
        Shape rectangleShape = (i10 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        if ((i10 & 4) != 0) {
            z11 = false;
            if (Dp.m3672compareTo0680j_4(f10, Dp.m3673constructorimpl(0)) > 0) {
                z11 = true;
            }
        } else {
            z11 = z10;
        }
        return m1295shadows4CzXII(modifier, f10, rectangleShape, z11, (i10 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j10, (i10 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j11);
    }

    @Stable
    /* JADX INFO: renamed from: shadow-ziNgDLE, reason: not valid java name */
    public static final /* synthetic */ Modifier m1297shadowziNgDLE(Modifier shadow, float f10, Shape shape, boolean z10) {
        t.i(shadow, "$this$shadow");
        t.i(shape, "shape");
        return m1295shadows4CzXII(shadow, f10, shape, z10, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    /* JADX INFO: renamed from: shadow-ziNgDLE$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1298shadowziNgDLE$default(Modifier modifier, float f10, Shape shape, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i10 & 4) != 0) {
            z10 = false;
            if (Dp.m3672compareTo0680j_4(f10, Dp.m3673constructorimpl(0)) > 0) {
                z10 = true;
            }
        }
        return m1297shadowziNgDLE(modifier, f10, shape, z10);
    }
}
