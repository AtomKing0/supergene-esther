package androidx.compose.ui.graphics;

import android.graphics.Shader;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Shader.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ShaderKt {
    @NotNull
    /* JADX INFO: renamed from: ImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m1853ImageShaderF49vj9s(@NotNull ImageBitmap image, int i10, int i11) {
        kotlin.jvm.internal.t.i(image, "image");
        return AndroidShader_androidKt.m1506ActualImageShaderF49vj9s(image, i10, i11);
    }

    /* JADX INFO: renamed from: ImageShader-F49vj9s$default, reason: not valid java name */
    public static /* synthetic */ Shader m1854ImageShaderF49vj9s$default(ImageBitmap imageBitmap, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = TileMode.Companion.m1905getClamp3opZhB0();
        }
        if ((i12 & 4) != 0) {
            i11 = TileMode.Companion.m1905getClamp3opZhB0();
        }
        return m1853ImageShaderF49vj9s(imageBitmap, i10, i11);
    }

    @NotNull
    /* JADX INFO: renamed from: LinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m1855LinearGradientShaderVjE6UOU(long j10, long j11, @NotNull List<Color> colors, @Nullable List<Float> list, int i10) {
        kotlin.jvm.internal.t.i(colors, "colors");
        return AndroidShader_androidKt.m1507ActualLinearGradientShaderVjE6UOU(j10, j11, colors, list, i10);
    }

    /* JADX INFO: renamed from: LinearGradientShader-VjE6UOU$default, reason: not valid java name */
    public static /* synthetic */ Shader m1856LinearGradientShaderVjE6UOU$default(long j10, long j11, List list, List list2, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i11 & 16) != 0) {
            i10 = TileMode.Companion.m1905getClamp3opZhB0();
        }
        return m1855LinearGradientShaderVjE6UOU(j10, j11, list, list3, i10);
    }

    @NotNull
    /* JADX INFO: renamed from: RadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m1857RadialGradientShader8uybcMk(long j10, float f10, @NotNull List<Color> colors, @Nullable List<Float> list, int i10) {
        kotlin.jvm.internal.t.i(colors, "colors");
        return AndroidShader_androidKt.m1508ActualRadialGradientShader8uybcMk(j10, f10, colors, list, i10);
    }

    /* JADX INFO: renamed from: RadialGradientShader-8uybcMk$default, reason: not valid java name */
    public static /* synthetic */ Shader m1858RadialGradientShader8uybcMk$default(long j10, float f10, List list, List list2, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i11 & 16) != 0) {
            i10 = TileMode.Companion.m1905getClamp3opZhB0();
        }
        return m1857RadialGradientShader8uybcMk(j10, f10, list, list3, i10);
    }

    @NotNull
    /* JADX INFO: renamed from: SweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m1859SweepGradientShader9KIMszo(long j10, @NotNull List<Color> colors, @Nullable List<Float> list) {
        kotlin.jvm.internal.t.i(colors, "colors");
        return AndroidShader_androidKt.m1509ActualSweepGradientShader9KIMszo(j10, colors, list);
    }

    /* JADX INFO: renamed from: SweepGradientShader-9KIMszo$default, reason: not valid java name */
    public static /* synthetic */ Shader m1860SweepGradientShader9KIMszo$default(long j10, List list, List list2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list2 = null;
        }
        return m1859SweepGradientShader9KIMszo(j10, list, list2);
    }
}
