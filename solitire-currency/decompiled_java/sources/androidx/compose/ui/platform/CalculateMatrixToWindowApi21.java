package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {

    @NotNull
    private final int[] tmpLocation = new int[2];

    @NotNull
    private final float[] tmpMatrix = Matrix.m1776constructorimpl$default(null, 1, null);

    /* JADX INFO: renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m3171preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.m1480setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m3166preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m3172preTranslate3XD1CNM(float[] fArr, float f10, float f11) {
        Matrix.m1785resetimpl(this.tmpMatrix);
        Matrix.m1796translateimpl$default(this.tmpMatrix, f10, f11, 0.0f, 4, null);
        AndroidComposeView_androidKt.m3166preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m3173transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m3173transformMatrixToWindowEL8BTi8((View) parent, fArr);
            m3172preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m3172preTranslate3XD1CNM(fArr, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.tmpLocation);
            m3172preTranslate3XD1CNM(fArr, -view.getScrollX(), -view.getScrollY());
            m3172preTranslate3XD1CNM(fArr, r0[0], r0[1]);
        }
        android.graphics.Matrix viewMatrix = view.getMatrix();
        if (viewMatrix.isIdentity()) {
            return;
        }
        kotlin.jvm.internal.t.h(viewMatrix, "viewMatrix");
        m3171preConcattUYjHk(fArr, viewMatrix);
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo3170calculateMatrixToWindowEL8BTi8(@NotNull View view, @NotNull float[] matrix) {
        kotlin.jvm.internal.t.i(view, "view");
        kotlin.jvm.internal.t.i(matrix, "matrix");
        Matrix.m1785resetimpl(matrix);
        m3173transformMatrixToWindowEL8BTi8(view, matrix);
    }
}
