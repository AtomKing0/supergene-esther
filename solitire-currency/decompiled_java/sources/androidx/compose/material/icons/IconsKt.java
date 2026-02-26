package androidx.compose.material.icons;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Icons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IconsKt {
    public static final float MaterialIconDimension = 24.0f;

    @NotNull
    public static final ImageVector materialIcon(@NotNull String name, @NotNull l<? super ImageVector.Builder, ImageVector.Builder> block) {
        t.i(name, "name");
        t.i(block, "block");
        return block.invoke(new ImageVector.Builder(name, Dp.m3673constructorimpl(24.0f), Dp.m3673constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (k) null)).build();
    }

    @NotNull
    /* JADX INFO: renamed from: materialPath-YwgOQQI, reason: not valid java name */
    public static final ImageVector.Builder m1219materialPathYwgOQQI(@NotNull ImageVector.Builder materialPath, float f10, float f11, int i10, @NotNull l<? super PathBuilder, k0> pathBuilder) {
        t.i(materialPath, "$this$materialPath");
        t.i(pathBuilder, "pathBuilder");
        SolidColor solidColor = new SolidColor(Color.Companion.m1624getBlack0d7_KjU(), null);
        int iM1885getButtKaPHkGw = StrokeCap.Companion.m1885getButtKaPHkGw();
        int iM1895getBevelLxFBmk8 = StrokeJoin.Companion.m1895getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder.invoke(pathBuilder2);
        return materialPath.m2102addPathoIyEayM(pathBuilder2.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : i10, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : f10, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : f11, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1885getButtKaPHkGw, (14336 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1895getBevelLxFBmk8, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f);
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m1220materialPathYwgOQQI$default(ImageVector.Builder materialPath, float f10, float f11, int i10, l pathBuilder, int i11, Object obj) {
        float f12 = (i11 & 1) != 0 ? 1.0f : f10;
        float f13 = (i11 & 2) != 0 ? 1.0f : f11;
        int defaultFillType = (i11 & 4) != 0 ? VectorKt.getDefaultFillType() : i10;
        t.i(materialPath, "$this$materialPath");
        t.i(pathBuilder, "pathBuilder");
        SolidColor solidColor = new SolidColor(Color.Companion.m1624getBlack0d7_KjU(), null);
        int iM1885getButtKaPHkGw = StrokeCap.Companion.m1885getButtKaPHkGw();
        int iM1895getBevelLxFBmk8 = StrokeJoin.Companion.m1895getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder.invoke(pathBuilder2);
        return materialPath.m2102addPathoIyEayM(pathBuilder2.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : f12, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : f13, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1885getButtKaPHkGw, (14336 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1895getBevelLxFBmk8, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f);
    }

    public static /* synthetic */ void getMaterialIconDimension$annotations() {
    }
}
