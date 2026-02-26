package androidx.compose.material.icons.sharp;

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

/* JADX INFO: compiled from: ArrowBack.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ArrowBackKt {

    @Nullable
    private static ImageVector _arrowBack;

    @NotNull
    public static final ImageVector getArrowBack(@NotNull Icons.Sharp sharp) {
        t.i(sharp, "<this>");
        ImageVector imageVector = _arrowBack;
        if (imageVector != null) {
            t.f(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.ArrowBack", Dp.m3673constructorimpl(24.0f), Dp.m3673constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (k) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1624getBlack0d7_KjU(), null);
        int iM1885getButtKaPHkGw = StrokeCap.Companion.m1885getButtKaPHkGw();
        int iM1895getBevelLxFBmk8 = StrokeJoin.Companion.m1895getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(20.0f, 11.0f);
        pathBuilder.horizontalLineTo(7.83f);
        pathBuilder.lineToRelative(5.59f, -5.59f);
        pathBuilder.lineTo(12.0f, 4.0f);
        pathBuilder.lineToRelative(-8.0f, 8.0f);
        pathBuilder.lineToRelative(8.0f, 8.0f);
        pathBuilder.lineToRelative(1.41f, -1.41f);
        pathBuilder.lineTo(7.83f, 13.0f);
        pathBuilder.horizontalLineTo(20.0f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.close();
        ImageVector imageVectorBuild = builder.m2102addPathoIyEayM(pathBuilder.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1885getButtKaPHkGw, (14336 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1895getBevelLxFBmk8, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f).build();
        _arrowBack = imageVectorBuild;
        t.f(imageVectorBuild);
        return imageVectorBuild;
    }
}
