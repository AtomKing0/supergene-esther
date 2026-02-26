package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LayerMatrixCache.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayerMatrixCache<T> {

    @Nullable
    private Matrix androidMatrixCache;

    @NotNull
    private final h9.p<T, Matrix, v8.k0> getMatrix;

    @Nullable
    private float[] inverseMatrixCache;
    private boolean isDirty;
    private boolean isInverseDirty;
    private boolean isInverseValid;

    @Nullable
    private float[] matrixCache;

    @Nullable
    private Matrix previousAndroidMatrix;

    /* JADX WARN: Multi-variable type inference failed */
    public LayerMatrixCache(@NotNull h9.p<? super T, ? super Matrix, v8.k0> getMatrix) {
        kotlin.jvm.internal.t.i(getMatrix, "getMatrix");
        this.getMatrix = getMatrix;
        this.isDirty = true;
        this.isInverseDirty = true;
        this.isInverseValid = true;
    }

    @Nullable
    /* JADX INFO: renamed from: calculateInverseMatrix-bWbORWo, reason: not valid java name */
    public final float[] m3189calculateInverseMatrixbWbORWo(T t10) {
        float[] fArrM1776constructorimpl$default = this.inverseMatrixCache;
        if (fArrM1776constructorimpl$default == null) {
            fArrM1776constructorimpl$default = androidx.compose.ui.graphics.Matrix.m1776constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArrM1776constructorimpl$default;
        }
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.m3187invertToJiSxe2E(m3190calculateMatrixGrdbGEg(t10), fArrM1776constructorimpl$default);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            return fArrM1776constructorimpl$default;
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: calculateMatrix-GrdbGEg, reason: not valid java name */
    public final float[] m3190calculateMatrixGrdbGEg(T t10) {
        float[] fArrM1776constructorimpl$default = this.matrixCache;
        if (fArrM1776constructorimpl$default == null) {
            fArrM1776constructorimpl$default = androidx.compose.ui.graphics.Matrix.m1776constructorimpl$default(null, 1, null);
            this.matrixCache = fArrM1776constructorimpl$default;
        }
        if (!this.isDirty) {
            return fArrM1776constructorimpl$default;
        }
        Matrix matrix = this.androidMatrixCache;
        if (matrix == null) {
            matrix = new Matrix();
            this.androidMatrixCache = matrix;
        }
        this.getMatrix.mo4invoke(t10, matrix);
        Matrix matrix2 = this.previousAndroidMatrix;
        if (matrix2 == null || !kotlin.jvm.internal.t.d(matrix, matrix2)) {
            AndroidMatrixConversions_androidKt.m1480setFromtUYjHk(fArrM1776constructorimpl$default, matrix);
            this.androidMatrixCache = matrix2;
            this.previousAndroidMatrix = matrix;
        }
        this.isDirty = false;
        return fArrM1776constructorimpl$default;
    }

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }
}
