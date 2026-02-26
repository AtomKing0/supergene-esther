package androidx.compose.ui.graphics;

import android.graphics.Shader;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BrushKt {
    @NotNull
    public static final ShaderBrush ShaderBrush(@NotNull final Shader shader) {
        kotlin.jvm.internal.t.i(shader, "shader");
        return new ShaderBrush() { // from class: androidx.compose.ui.graphics.BrushKt.ShaderBrush.1
            @Override // androidx.compose.ui.graphics.ShaderBrush
            @NotNull
            /* JADX INFO: renamed from: createShader-uvyYCjk, reason: not valid java name */
            public Shader mo1573createShaderuvyYCjk(long j10) {
                return shader;
            }
        };
    }
}
