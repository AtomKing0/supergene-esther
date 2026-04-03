package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DrawScopeKt {
    /* JADX INFO: renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m2062clipPathKD09W0M(@NotNull DrawScope clipPath, @NotNull Path path, int i10, @NotNull l<? super DrawScope, k0> block) {
        t.i(clipPath, "$this$clipPath");
        t.i(path, "path");
        t.i(block, "block");
        DrawContext drawContext = clipPath.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2004clipPathmtrdDE(path, i10);
        block.invoke(clipPath);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m2063clipPathKD09W0M$default(DrawScope clipPath, Path path, int i10, l block, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = ClipOp.Companion.m1587getIntersectrtfAjoo();
        }
        t.i(clipPath, "$this$clipPath");
        t.i(path, "path");
        t.i(block, "block");
        DrawContext drawContext = clipPath.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2004clipPathmtrdDE(path, i10);
        block.invoke(clipPath);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m2064clipRectrOu3jXo(@NotNull DrawScope clipRect, float f10, float f11, float f12, float f13, int i10, @NotNull l<? super DrawScope, k0> block) {
        t.i(clipRect, "$this$clipRect");
        t.i(block, "block");
        DrawContext drawContext = clipRect.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2005clipRectN_I0leg(f10, f11, f12, f13, i10);
        block.invoke(clipRect);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m2065clipRectrOu3jXo$default(DrawScope clipRect, float f10, float f11, float f12, float f13, int i10, l block, int i11, Object obj) {
        float f14 = (i11 & 1) != 0 ? 0.0f : f10;
        float f15 = (i11 & 2) != 0 ? 0.0f : f11;
        if ((i11 & 4) != 0) {
            f12 = Size.m1436getWidthimpl(clipRect.mo1996getSizeNHjbRc());
        }
        float f16 = f12;
        if ((i11 & 8) != 0) {
            f13 = Size.m1433getHeightimpl(clipRect.mo1996getSizeNHjbRc());
        }
        float f17 = f13;
        if ((i11 & 16) != 0) {
            i10 = ClipOp.Companion.m1587getIntersectrtfAjoo();
        }
        t.i(clipRect, "$this$clipRect");
        t.i(block, "block");
        DrawContext drawContext = clipRect.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2005clipRectN_I0leg(f14, f15, f16, f17, i10);
        block.invoke(clipRect);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    public static final void drawIntoCanvas(@NotNull DrawScope drawScope, @NotNull l<? super Canvas, k0> block) {
        t.i(drawScope, "<this>");
        t.i(block, "block");
        block.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void inset(@NotNull DrawScope drawScope, float f10, float f11, float f12, float f13, @NotNull l<? super DrawScope, k0> block) {
        t.i(drawScope, "<this>");
        t.i(block, "block");
        drawScope.getDrawContext().getTransform().inset(f10, f11, f12, f13);
        block.invoke(drawScope);
        drawScope.getDrawContext().getTransform().inset(-f10, -f11, -f12, -f13);
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f10, float f11, l block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        t.i(drawScope, "<this>");
        t.i(block, "block");
        drawScope.getDrawContext().getTransform().inset(f10, f11, f10, f11);
        block.invoke(drawScope);
        float f12 = -f10;
        float f13 = -f11;
        drawScope.getDrawContext().getTransform().inset(f12, f13, f12, f13);
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m2066rotateRg1IO4c(@NotNull DrawScope rotate, float f10, long j10, @NotNull l<? super DrawScope, k0> block) {
        t.i(rotate, "$this$rotate");
        t.i(block, "block");
        DrawContext drawContext = rotate.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2008rotateUv8p0NA(f10, j10);
        block.invoke(rotate);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m2067rotateRg1IO4c$default(DrawScope rotate, float f10, long j10, l block, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = rotate.mo1995getCenterF1C5BW0();
        }
        t.i(rotate, "$this$rotate");
        t.i(block, "block");
        DrawContext drawContext = rotate.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2008rotateUv8p0NA(f10, j10);
        block.invoke(rotate);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m2068rotateRadRg1IO4c(@NotNull DrawScope rotateRad, float f10, long j10, @NotNull l<? super DrawScope, k0> block) {
        t.i(rotateRad, "$this$rotateRad");
        t.i(block, "block");
        DrawContext drawContext = rotateRad.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2008rotateUv8p0NA(DegreesKt.degrees(f10), j10);
        block.invoke(rotateRad);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m2069rotateRadRg1IO4c$default(DrawScope rotateRad, float f10, long j10, l block, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = rotateRad.mo1995getCenterF1C5BW0();
        }
        t.i(rotateRad, "$this$rotateRad");
        t.i(block, "block");
        DrawContext drawContext = rotateRad.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2008rotateUv8p0NA(DegreesKt.degrees(f10), j10);
        block.invoke(rotateRad);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m2070scaleFgt4K4Q(@NotNull DrawScope scale, float f10, float f11, long j10, @NotNull l<? super DrawScope, k0> block) {
        t.i(scale, "$this$scale");
        t.i(block, "block");
        DrawContext drawContext = scale.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2009scale0AR0LA0(f10, f11, j10);
        block.invoke(scale);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m2071scaleFgt4K4Q$default(DrawScope scale, float f10, float f11, long j10, l block, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = scale.mo1995getCenterF1C5BW0();
        }
        t.i(scale, "$this$scale");
        t.i(block, "block");
        DrawContext drawContext = scale.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2009scale0AR0LA0(f10, f11, j10);
        block.invoke(scale);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m2072scaleRg1IO4c(@NotNull DrawScope scale, float f10, long j10, @NotNull l<? super DrawScope, k0> block) {
        t.i(scale, "$this$scale");
        t.i(block, "block");
        DrawContext drawContext = scale.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2009scale0AR0LA0(f10, f10, j10);
        block.invoke(scale);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m2073scaleRg1IO4c$default(DrawScope scale, float f10, long j10, l block, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = scale.mo1995getCenterF1C5BW0();
        }
        t.i(scale, "$this$scale");
        t.i(block, "block");
        DrawContext drawContext = scale.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2009scale0AR0LA0(f10, f10, j10);
        block.invoke(scale);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    public static final void translate(@NotNull DrawScope drawScope, float f10, float f11, @NotNull l<? super DrawScope, k0> block) {
        t.i(drawScope, "<this>");
        t.i(block, "block");
        drawScope.getDrawContext().getTransform().translate(f10, f11);
        block.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f10, -f11);
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f10, float f11, l block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        t.i(drawScope, "<this>");
        t.i(block, "block");
        drawScope.getDrawContext().getTransform().translate(f10, f11);
        block.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f10, -f11);
    }

    public static final void withTransform(@NotNull DrawScope drawScope, @NotNull l<? super DrawTransform, k0> transformBlock, @NotNull l<? super DrawScope, k0> drawBlock) {
        t.i(drawScope, "<this>");
        t.i(transformBlock, "transformBlock");
        t.i(drawBlock, "drawBlock");
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        transformBlock.invoke(drawContext.getTransform());
        drawBlock.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    public static final void inset(@NotNull DrawScope drawScope, float f10, @NotNull l<? super DrawScope, k0> block) {
        t.i(drawScope, "<this>");
        t.i(block, "block");
        drawScope.getDrawContext().getTransform().inset(f10, f10, f10, f10);
        block.invoke(drawScope);
        float f11 = -f10;
        drawScope.getDrawContext().getTransform().inset(f11, f11, f11, f11);
    }

    public static final void inset(@NotNull DrawScope drawScope, float f10, float f11, @NotNull l<? super DrawScope, k0> block) {
        t.i(drawScope, "<this>");
        t.i(block, "block");
        drawScope.getDrawContext().getTransform().inset(f10, f11, f10, f11);
        block.invoke(drawScope);
        float f12 = -f10;
        float f13 = -f11;
        drawScope.getDrawContext().getTransform().inset(f12, f13, f12, f13);
    }
}
