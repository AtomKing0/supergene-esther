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

/* JADX INFO: compiled from: Edit.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EditKt {

    @Nullable
    private static ImageVector _edit;

    @NotNull
    public static final ImageVector getEdit(@NotNull Icons.Outlined outlined) {
        t.i(outlined, "<this>");
        ImageVector imageVector = _edit;
        if (imageVector != null) {
            t.f(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Edit", Dp.m3673constructorimpl(24.0f), Dp.m3673constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (k) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1624getBlack0d7_KjU(), null);
        int iM1885getButtKaPHkGw = StrokeCap.Companion.m1885getButtKaPHkGw();
        int iM1895getBevelLxFBmk8 = StrokeJoin.Companion.m1895getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(14.06f, 9.02f);
        pathBuilder.lineToRelative(0.92f, 0.92f);
        pathBuilder.lineTo(5.92f, 19.0f);
        pathBuilder.lineTo(5.0f, 19.0f);
        pathBuilder.verticalLineToRelative(-0.92f);
        pathBuilder.lineToRelative(9.06f, -9.06f);
        pathBuilder.moveTo(17.66f, 3.0f);
        pathBuilder.curveToRelative(-0.25f, 0.0f, -0.51f, 0.1f, -0.7f, 0.29f);
        pathBuilder.lineToRelative(-1.83f, 1.83f);
        pathBuilder.lineToRelative(3.75f, 3.75f);
        pathBuilder.lineToRelative(1.83f, -1.83f);
        pathBuilder.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        pathBuilder.lineToRelative(-2.34f, -2.34f);
        pathBuilder.curveToRelative(-0.2f, -0.2f, -0.45f, -0.29f, -0.71f, -0.29f);
        pathBuilder.close();
        pathBuilder.moveTo(14.06f, 6.19f);
        pathBuilder.lineTo(3.0f, 17.25f);
        pathBuilder.lineTo(3.0f, 21.0f);
        pathBuilder.horizontalLineToRelative(3.75f);
        pathBuilder.lineTo(17.81f, 9.94f);
        pathBuilder.lineToRelative(-3.75f, -3.75f);
        pathBuilder.close();
        ImageVector imageVectorBuild = builder.m2102addPathoIyEayM(pathBuilder.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1885getButtKaPHkGw, (14336 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1895getBevelLxFBmk8, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f).build();
        _edit = imageVectorBuild;
        t.f(imageVectorBuild);
        return imageVectorBuild;
    }
}
