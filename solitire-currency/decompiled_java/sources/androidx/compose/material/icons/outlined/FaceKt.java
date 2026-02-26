package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Face.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FaceKt {

    @Nullable
    private static ImageVector _face;

    @NotNull
    public static final ImageVector getFace(@NotNull Icons.Outlined outlined) {
        t.i(outlined, "<this>");
        ImageVector imageVector = _face;
        if (imageVector != null) {
            t.f(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Face", Dp.m3673constructorimpl(24.0f), Dp.m3673constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (k) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1624getBlack0d7_KjU(), null);
        int iM1885getButtKaPHkGw = StrokeCap.Companion.m1885getButtKaPHkGw();
        int iM1895getBevelLxFBmk8 = StrokeJoin.Companion.m1895getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(10.25f, 13.0f);
        pathBuilder.curveToRelative(0.0f, 0.69f, -0.56f, 1.25f, -1.25f, 1.25f);
        pathBuilder.reflectiveCurveTo(7.75f, 13.69f, 7.75f, 13.0f);
        pathBuilder.reflectiveCurveToRelative(0.56f, -1.25f, 1.25f, -1.25f);
        pathBuilder.reflectiveCurveToRelative(1.25f, 0.56f, 1.25f, 1.25f);
        pathBuilder.close();
        pathBuilder.moveTo(15.0f, 11.75f);
        pathBuilder.curveToRelative(-0.69f, 0.0f, -1.25f, 0.56f, -1.25f, 1.25f);
        pathBuilder.reflectiveCurveToRelative(0.56f, 1.25f, 1.25f, 1.25f);
        pathBuilder.reflectiveCurveToRelative(1.25f, -0.56f, 1.25f, -1.25f);
        pathBuilder.reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f);
        pathBuilder.close();
        pathBuilder.moveTo(22.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, 5.52f, -4.48f, 10.0f, -10.0f, 10.0f);
        pathBuilder.reflectiveCurveTo(2.0f, 17.52f, 2.0f, 12.0f);
        pathBuilder.reflectiveCurveTo(6.48f, 2.0f, 12.0f, 2.0f);
        pathBuilder.reflectiveCurveToRelative(10.0f, 4.48f, 10.0f, 10.0f);
        pathBuilder.close();
        pathBuilder.moveTo(10.66f, 4.12f);
        pathBuilder.curveTo(12.06f, 6.44f, 14.6f, 8.0f, 17.5f, 8.0f);
        pathBuilder.curveToRelative(0.46f, 0.0f, 0.91f, -0.05f, 1.34f, -0.12f);
        pathBuilder.curveTo(17.44f, 5.56f, 14.9f, 4.0f, 12.0f, 4.0f);
        pathBuilder.curveToRelative(-0.46f, 0.0f, -0.91f, 0.05f, -1.34f, 0.12f);
        pathBuilder.close();
        pathBuilder.moveTo(4.42f, 9.47f);
        pathBuilder.curveToRelative(1.71f, -0.97f, 3.03f, -2.55f, 3.66f, -4.44f);
        pathBuilder.curveTo(6.37f, 6.0f, 5.05f, 7.58f, 4.42f, 9.47f);
        pathBuilder.close();
        pathBuilder.moveTo(20.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, -0.78f, -0.12f, -1.53f, -0.33f, -2.24f);
        pathBuilder.curveToRelative(-0.7f, 0.15f, -1.42f, 0.24f, -2.17f, 0.24f);
        pathBuilder.curveToRelative(-3.13f, 0.0f, -5.92f, -1.44f, -7.76f, -3.69f);
        pathBuilder.curveTo(8.69f, 8.87f, 6.6f, 10.88f, 4.0f, 11.86f);
        pathBuilder.curveToRelative(0.01f, 0.04f, 0.0f, 0.09f, 0.0f, 0.14f);
        pathBuilder.curveToRelative(0.0f, 4.41f, 3.59f, 8.0f, 8.0f, 8.0f);
        pathBuilder.reflectiveCurveToRelative(8.0f, -3.59f, 8.0f, -8.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = builder.m2102addPathoIyEayM(pathBuilder.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1885getButtKaPHkGw, (14336 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1895getBevelLxFBmk8, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f).build();
        _face = imageVectorBuild;
        t.f(imageVectorBuild);
        return imageVectorBuild;
    }
}
