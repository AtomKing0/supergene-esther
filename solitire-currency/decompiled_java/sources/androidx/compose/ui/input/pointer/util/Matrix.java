package androidx.compose.ui.input.pointer.util;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes.dex */
final class Matrix {

    @NotNull
    private final Vector[] elements;

    public Matrix(int i10, int i11) {
        Vector[] vectorArr = new Vector[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            vectorArr[i12] = new Vector(i11);
        }
        this.elements = vectorArr;
    }

    public final float get(int i10, int i11) {
        return this.elements[i10].get(i11);
    }

    @NotNull
    public final Vector getRow(int i10) {
        return this.elements[i10];
    }

    public final void set(int i10, int i11, float f10) {
        this.elements[i10].set(i11, f10);
    }
}
