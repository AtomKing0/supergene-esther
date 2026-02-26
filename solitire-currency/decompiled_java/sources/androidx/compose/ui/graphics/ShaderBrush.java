package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Brush.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class ShaderBrush extends Brush {
    private long createdSize;

    @Nullable
    private Shader internalShader;

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.m1444getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo1551applyToPq9zytI(long j10, @NotNull Paint p10, float f10) {
        kotlin.jvm.internal.t.i(p10, "p");
        Shader shaderMo1573createShaderuvyYCjk = this.internalShader;
        if (shaderMo1573createShaderuvyYCjk == null || !Size.m1432equalsimpl0(this.createdSize, j10)) {
            shaderMo1573createShaderuvyYCjk = mo1573createShaderuvyYCjk(j10);
            this.internalShader = shaderMo1573createShaderuvyYCjk;
            this.createdSize = j10;
        }
        long jMo1482getColor0d7_KjU = p10.mo1482getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m1599equalsimpl0(jMo1482getColor0d7_KjU, companion.m1624getBlack0d7_KjU())) {
            p10.mo1488setColor8_81llA(companion.m1624getBlack0d7_KjU());
        }
        if (!kotlin.jvm.internal.t.d(p10.getShader(), shaderMo1573createShaderuvyYCjk)) {
            p10.setShader(shaderMo1573createShaderuvyYCjk);
        }
        if (p10.getAlpha() == f10) {
            return;
        }
        p10.setAlpha(f10);
    }

    @NotNull
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo1573createShaderuvyYCjk(long j10);
}
