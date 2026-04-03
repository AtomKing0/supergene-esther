package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Shader.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(@NotNull Shader shader, @NotNull h9.l<? super Matrix, v8.k0> lVar) {
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        lVar.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
