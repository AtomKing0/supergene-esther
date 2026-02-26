package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CanvasDrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScopeKt {

    @NotNull
    private static final Density DefaultDensity = DensityKt.Density(1.0f, 1.0f);

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt.asDrawTransform.1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
            public void mo2004clipPathmtrdDE(@NotNull Path path, int i10) {
                t.i(path, "path");
                drawContext.getCanvas().mo1461clipPathmtrdDE(path, i10);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
            public void mo2005clipRectN_I0leg(float f10, float f11, float f12, float f13, int i10) {
                drawContext.getCanvas().mo1462clipRectN_I0leg(f10, f11, f12, f13, i10);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
            public long mo2006getCenterF1C5BW0() {
                return SizeKt.m1446getCenteruvyYCjk(mo2007getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
            public long mo2007getSizeNHjbRc() {
                return drawContext.mo2002getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float f10, float f11, float f12, float f13) {
                Canvas canvas = drawContext.getCanvas();
                DrawContext drawContext2 = drawContext;
                long jSize = SizeKt.Size(Size.m1436getWidthimpl(mo2007getSizeNHjbRc()) - (f12 + f10), Size.m1433getHeightimpl(mo2007getSizeNHjbRc()) - (f13 + f11));
                if (!(Size.m1436getWidthimpl(jSize) >= 0.0f && Size.m1433getHeightimpl(jSize) >= 0.0f)) {
                    throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
                }
                drawContext2.mo2003setSizeuvyYCjk(jSize);
                canvas.translate(f10, f11);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
            public void mo2008rotateUv8p0NA(float f10, long j10) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10));
                canvas.rotate(f10);
                canvas.translate(-Offset.m1367getXimpl(j10), -Offset.m1368getYimpl(j10));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
            public void mo2009scale0AR0LA0(float f10, float f11, long j10) {
                Canvas canvas = drawContext.getCanvas();
                canvas.translate(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10));
                canvas.scale(f10, f11);
                canvas.translate(-Offset.m1367getXimpl(j10), -Offset.m1368getYimpl(j10));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
            public void mo2010transform58bKbWc(@NotNull float[] matrix) {
                t.i(matrix, "matrix");
                drawContext.getCanvas().mo1464concat58bKbWc(matrix);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float f10, float f11) {
                drawContext.getCanvas().translate(f10, f11);
            }
        };
    }
}
