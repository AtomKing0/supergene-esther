package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GraphicsLayerModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerModifierKt {
    @Stable
    @NotNull
    public static final Modifier graphicsLayer(@NotNull Modifier modifier, @NotNull h9.l<? super GraphicsLayerScope, v8.k0> block) {
        kotlin.jvm.internal.t.i(modifier, "<this>");
        kotlin.jvm.internal.t.i(block, "block");
        return modifier.then(new BlockGraphicsLayerModifier(block, InspectableValueKt.isDebugInspectorInfoEnabled() ? new GraphicsLayerModifierKt$graphicsLayer$$inlined$debugInspectorInfo$1(block) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    /* JADX INFO: renamed from: graphicsLayer-2Xn7asI, reason: not valid java name */
    public static final /* synthetic */ Modifier m1732graphicsLayer2Xn7asI(Modifier graphicsLayer, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, long j10, Shape shape, boolean z10, RenderEffect renderEffect) {
        kotlin.jvm.internal.t.i(graphicsLayer, "$this$graphicsLayer");
        kotlin.jvm.internal.t.i(shape, "shape");
        return m1734graphicsLayerpANQ8Wg(graphicsLayer, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, j10, shape, z10, renderEffect, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: graphicsLayer-pANQ8Wg, reason: not valid java name */
    public static final Modifier m1734graphicsLayerpANQ8Wg(@NotNull Modifier graphicsLayer, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, long j10, @NotNull Shape shape, boolean z10, @Nullable RenderEffect renderEffect, long j11, long j12) {
        kotlin.jvm.internal.t.i(graphicsLayer, "$this$graphicsLayer");
        kotlin.jvm.internal.t.i(shape, "shape");
        return graphicsLayer.then(new SimpleGraphicsLayerModifier(f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, j10, shape, z10, renderEffect, j11, j12, InspectableValueKt.isDebugInspectorInfoEnabled() ? new GraphicsLayerModifierKt$graphicsLayerpANQ8Wg$$inlined$debugInspectorInfo$1(f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, j10, shape, z10, renderEffect, j11, j12) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: graphicsLayer-pANQ8Wg$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1735graphicsLayerpANQ8Wg$default(Modifier modifier, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, long j10, Shape shape, boolean z10, RenderEffect renderEffect, long j11, long j12, int i10, Object obj) {
        return m1734graphicsLayerpANQ8Wg(modifier, (i10 & 1) != 0 ? 1.0f : f10, (i10 & 2) != 0 ? 1.0f : f11, (i10 & 4) == 0 ? f12 : 1.0f, (i10 & 8) != 0 ? 0.0f : f13, (i10 & 16) != 0 ? 0.0f : f14, (i10 & 32) != 0 ? 0.0f : f15, (i10 & 64) != 0 ? 0.0f : f16, (i10 & 128) != 0 ? 0.0f : f17, (i10 & 256) == 0 ? f18 : 0.0f, (i10 & 512) != 0 ? 8.0f : f19, (i10 & 1024) != 0 ? TransformOrigin.Companion.m1923getCenterSzJe1aQ() : j10, (i10 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i10 & 4096) != 0 ? false : z10, (i10 & 8192) != 0 ? null : renderEffect, (i10 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j11, (i10 & 32768) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j12);
    }

    @Stable
    /* JADX INFO: renamed from: graphicsLayer-sKFY_QE, reason: not valid java name */
    public static final /* synthetic */ Modifier m1736graphicsLayersKFY_QE(Modifier graphicsLayer, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, long j10, Shape shape, boolean z10) {
        kotlin.jvm.internal.t.i(graphicsLayer, "$this$graphicsLayer");
        kotlin.jvm.internal.t.i(shape, "shape");
        return m1735graphicsLayerpANQ8Wg$default(graphicsLayer, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19, j10, shape, z10, null, 0L, 0L, 49152, null);
    }

    @Stable
    @NotNull
    public static final Modifier toolingGraphicsLayer(@NotNull Modifier modifier) {
        kotlin.jvm.internal.t.i(modifier, "<this>");
        return InspectableValueKt.isDebugInspectorInfoEnabled() ? modifier.then(m1735graphicsLayerpANQ8Wg$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 65535, null)) : modifier;
    }
}
