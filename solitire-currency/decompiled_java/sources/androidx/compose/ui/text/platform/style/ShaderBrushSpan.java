package androidx.compose.ui.text.platform.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ShaderBrushSpan.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {

    @NotNull
    private final ShaderBrush shaderBrush;

    @Nullable
    private Size size;

    public ShaderBrushSpan(@NotNull ShaderBrush shaderBrush) {
        t.i(shaderBrush, "shaderBrush");
        this.shaderBrush = shaderBrush;
    }

    @NotNull
    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    @Nullable
    /* JADX INFO: renamed from: getSize-VsRJwc0, reason: not valid java name */
    public final Size m3540getSizeVsRJwc0() {
        return this.size;
    }

    /* JADX INFO: renamed from: setSize-iaC8Vc4, reason: not valid java name */
    public final void m3541setSizeiaC8Vc4(@Nullable Size size) {
        this.size = size;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@Nullable TextPaint textPaint) {
        Size size;
        if (textPaint == null || (size = this.size) == null) {
            return;
        }
        textPaint.setShader(this.shaderBrush.mo1573createShaderuvyYCjk(size.m1441unboximpl()));
    }
}
