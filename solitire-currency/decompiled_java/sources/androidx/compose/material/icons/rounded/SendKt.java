package androidx.compose.material.icons.rounded;

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

/* JADX INFO: compiled from: Send.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SendKt {

    @Nullable
    private static ImageVector _send;

    @NotNull
    public static final ImageVector getSend(@NotNull Icons.Rounded rounded) {
        t.i(rounded, "<this>");
        ImageVector imageVector = _send;
        if (imageVector != null) {
            t.f(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Rounded.Send", Dp.m3673constructorimpl(24.0f), Dp.m3673constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, 96, (k) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m1624getBlack0d7_KjU(), null);
        int iM1885getButtKaPHkGw = StrokeCap.Companion.m1885getButtKaPHkGw();
        int iM1895getBevelLxFBmk8 = StrokeJoin.Companion.m1895getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(3.4f, 20.4f);
        pathBuilder.lineToRelative(17.45f, -7.48f);
        pathBuilder.curveToRelative(0.81f, -0.35f, 0.81f, -1.49f, 0.0f, -1.84f);
        pathBuilder.lineTo(3.4f, 3.6f);
        pathBuilder.curveToRelative(-0.66f, -0.29f, -1.39f, 0.2f, -1.39f, 0.91f);
        pathBuilder.lineTo(2.0f, 9.12f);
        pathBuilder.curveToRelative(0.0f, 0.5f, 0.37f, 0.93f, 0.87f, 0.99f);
        pathBuilder.lineTo(17.0f, 12.0f);
        pathBuilder.lineTo(2.87f, 13.88f);
        pathBuilder.curveToRelative(-0.5f, 0.07f, -0.87f, 0.5f, -0.87f, 1.0f);
        pathBuilder.lineToRelative(0.01f, 4.61f);
        pathBuilder.curveToRelative(0.0f, 0.71f, 0.73f, 1.2f, 1.39f, 0.91f);
        pathBuilder.close();
        ImageVector imageVectorBuild = builder.m2102addPathoIyEayM(pathBuilder.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : solidColor, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : iM1885getButtKaPHkGw, (14336 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : iM1895getBevelLxFBmk8, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f).build();
        _send = imageVectorBuild;
        t.f(imageVectorBuild);
        return imageVectorBuild;
    }
}
