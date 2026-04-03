package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class CalculateMatrixToWindowApi29 implements CalculateMatrixToWindow {

    @NotNull
    private final Matrix tmpMatrix = new Matrix();

    @NotNull
    private final int[] tmpPosition = new int[2];

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    @DoNotInline
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo3170calculateMatrixToWindowEL8BTi8(@NotNull View view, @NotNull float[] matrix) {
        kotlin.jvm.internal.t.i(view, "view");
        kotlin.jvm.internal.t.i(matrix, "matrix");
        this.tmpMatrix.reset();
        view.transformMatrixToGlobal(this.tmpMatrix);
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            view = parent;
            parent = view.getParent();
        }
        view.getLocationOnScreen(this.tmpPosition);
        int[] iArr = this.tmpPosition;
        int i10 = iArr[0];
        int i11 = iArr[1];
        view.getLocationInWindow(iArr);
        int[] iArr2 = this.tmpPosition;
        this.tmpMatrix.postTranslate(iArr2[0] - i10, iArr2[1] - i11);
        AndroidMatrixConversions_androidKt.m1480setFromtUYjHk(matrix, this.tmpMatrix);
    }
}
