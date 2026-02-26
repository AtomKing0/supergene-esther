package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Outline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutlineKt {
    public static final void addOutline(@NotNull Path path, @NotNull Outline outline) {
        kotlin.jvm.internal.t.i(path, "<this>");
        kotlin.jvm.internal.t.i(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            path.addRect(((Outline.Rectangle) outline).getRect());
        } else if (outline instanceof Outline.Rounded) {
            path.addRoundRect(((Outline.Rounded) outline).getRoundRect());
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new v8.q();
            }
            f1.c(path, ((Outline.Generic) outline).getPath(), 0L, 2, null);
        }
    }

    public static final void drawOutline(@NotNull Canvas canvas, @NotNull Outline outline, @NotNull Paint paint) {
        kotlin.jvm.internal.t.i(canvas, "<this>");
        kotlin.jvm.internal.t.i(outline, "outline");
        kotlin.jvm.internal.t.i(paint, "paint");
        if (outline instanceof Outline.Rectangle) {
            canvas.drawRect(((Outline.Rectangle) outline).getRect(), paint);
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new v8.q();
            }
            canvas.drawPath(((Outline.Generic) outline).getPath(), paint);
        } else {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                canvas.drawPath(roundRectPath$ui_graphics_release, paint);
            } else {
                canvas.drawRoundRect(rounded.getRoundRect().getLeft(), rounded.getRoundRect().getTop(), rounded.getRoundRect().getRight(), rounded.getRoundRect().getBottom(), CornerRadius.m1342getXimpl(rounded.getRoundRect().m1415getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m1343getYimpl(rounded.getRoundRect().m1415getBottomLeftCornerRadiuskKHJgLs()), paint);
            }
        }
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg, reason: not valid java name */
    public static final void m1801drawOutlinehn5TExg(@NotNull DrawScope drawOutline, @NotNull Outline outline, @NotNull Brush brush, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        Path path;
        kotlin.jvm.internal.t.i(drawOutline, "$this$drawOutline");
        kotlin.jvm.internal.t.i(outline, "outline");
        kotlin.jvm.internal.t.i(brush, "brush");
        kotlin.jvm.internal.t.i(style, "style");
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawOutline.mo1991drawRectAsUm42w(brush, topLeft(rect), size(rect), f10, style, colorFilter, i10);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                drawOutline.mo1993drawRoundRectZuiqVtQ(brush, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m1342getXimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, null), f10, style, colorFilter, i10);
                return;
            }
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new v8.q();
            }
            path = ((Outline.Generic) outline).getPath();
        }
        drawOutline.mo1987drawPathGBMwjPU(path, brush, f10, style, colorFilter, i10);
    }

    /* JADX INFO: renamed from: drawOutline-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m1802drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f10, DrawStyle drawStyle, ColorFilter colorFilter, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            f10 = 1.0f;
        }
        float f11 = f10;
        if ((i11 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i11 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i11 & 32) != 0) {
            i10 = DrawScope.Companion.m2026getDefaultBlendMode0nO6VwU();
        }
        m1801drawOutlinehn5TExg(drawScope, outline, brush, f11, drawStyle2, colorFilter2, i10);
    }

    /* JADX INFO: renamed from: drawOutline-wDX37Ww, reason: not valid java name */
    public static final void m1803drawOutlinewDX37Ww(@NotNull DrawScope drawOutline, @NotNull Outline outline, long j10, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        Path path;
        kotlin.jvm.internal.t.i(drawOutline, "$this$drawOutline");
        kotlin.jvm.internal.t.i(outline, "outline");
        kotlin.jvm.internal.t.i(style, "style");
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawOutline.mo1992drawRectnJ9OG0(j10, topLeft(rect), size(rect), f10, style, colorFilter, i10);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                drawOutline.mo1994drawRoundRectuAw5IA(j10, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m1342getXimpl(roundRect.m1415getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, null), style, f10, colorFilter, i10);
                return;
            }
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new v8.q();
            }
            path = ((Outline.Generic) outline).getPath();
        }
        drawOutline.mo1988drawPathLG529CI(path, j10, f10, style, colorFilter, i10);
    }

    private static final void drawOutlineHelper(DrawScope drawScope, Outline outline, h9.p<? super DrawScope, ? super Rect, v8.k0> pVar, h9.p<? super DrawScope, ? super RoundRect, v8.k0> pVar2, h9.p<? super DrawScope, ? super Path, v8.k0> pVar3) {
        if (outline instanceof Outline.Rectangle) {
            pVar.mo4invoke(drawScope, ((Outline.Rectangle) outline).getRect());
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Generic)) {
                throw new v8.q();
            }
            pVar3.mo4invoke(drawScope, ((Outline.Generic) outline).getPath());
        } else {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                pVar3.mo4invoke(drawScope, roundRectPath$ui_graphics_release);
            } else {
                pVar2.mo4invoke(drawScope, rounded.getRoundRect());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            long r0 = r6.m1415getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r0)
            long r1 = r6.m1416getBottomRightCornerRadiuskKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L18
            r0 = r1
            goto L19
        L18:
            r0 = r2
        L19:
            if (r0 == 0) goto L4f
            long r3 = r6.m1416getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r3)
            long r3 = r6.m1418getTopRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L31
            r0 = r1
            goto L32
        L31:
            r0 = r2
        L32:
            if (r0 == 0) goto L4f
            long r3 = r6.m1418getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r3)
            long r3 = r6.m1417getTopLeftCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m1342getXimpl(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L4a
            r0 = r1
            goto L4b
        L4a:
            r0 = r2
        L4b:
            if (r0 == 0) goto L4f
            r0 = r1
            goto L50
        L4f:
            r0 = r2
        L50:
            long r3 = r6.m1415getBottomLeftCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r3)
            long r4 = r6.m1416getBottomRightCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L66
            r3 = r1
            goto L67
        L66:
            r3 = r2
        L67:
            if (r3 == 0) goto L9d
            long r3 = r6.m1416getBottomRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r3)
            long r4 = r6.m1418getTopRightCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L7f
            r3 = r1
            goto L80
        L7f:
            r3 = r2
        L80:
            if (r3 == 0) goto L9d
            long r3 = r6.m1418getTopRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r3)
            long r4 = r6.m1417getTopLeftCornerRadiuskKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.m1343getYimpl(r4)
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 != 0) goto L98
            r6 = r1
            goto L99
        L98:
            r6 = r2
        L99:
            if (r6 == 0) goto L9d
            r6 = r1
            goto L9e
        L9d:
            r6 = r2
        L9e:
            if (r0 == 0) goto La3
            if (r6 == 0) goto La3
            goto La4
        La3:
            r1 = r2
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.OutlineKt.hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    private static final long size(Rect rect) {
        return SizeKt.Size(rect.getWidth(), rect.getHeight());
    }

    private static final long topLeft(Rect rect) {
        return OffsetKt.Offset(rect.getLeft(), rect.getTop());
    }

    private static final long size(RoundRect roundRect) {
        return SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
    }

    private static final long topLeft(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
    }
}
