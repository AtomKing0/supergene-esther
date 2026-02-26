package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ImageVector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageVectorKt {
    @NotNull
    public static final ImageVector.Builder group(@NotNull ImageVector.Builder builder, @NotNull String name, float f10, float f11, float f12, float f13, float f14, float f15, float f16, @NotNull List<? extends PathNode> clipPathData, @NotNull l<? super ImageVector.Builder, k0> block) {
        t.i(builder, "<this>");
        t.i(name, "name");
        t.i(clipPathData, "clipPathData");
        t.i(block, "block");
        builder.addGroup(name, f10, f11, f12, f13, f14, f15, f16, clipPathData);
        block.invoke(builder);
        builder.clearGroup();
        return builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageVector.Builder group$default(ImageVector.Builder builder, String str, float f10, float f11, float f12, float f13, float f14, float f15, float f16, List list, l block, int i10, Object obj) {
        String name = (i10 & 1) != 0 ? "" : str;
        float f17 = (i10 & 2) != 0 ? 0.0f : f10;
        float f18 = (i10 & 4) != 0 ? 0.0f : f11;
        float f19 = (i10 & 8) != 0 ? 0.0f : f12;
        float f20 = (i10 & 16) != 0 ? 1.0f : f13;
        float f21 = (i10 & 32) == 0 ? f14 : 1.0f;
        float f22 = (i10 & 64) != 0 ? 0.0f : f15;
        float f23 = (i10 & 128) != 0 ? 0.0f : f16;
        List clipPathData = (i10 & 256) != 0 ? VectorKt.getEmptyPath() : list;
        t.i(builder, "<this>");
        t.i(name, "name");
        t.i(clipPathData, "clipPathData");
        t.i(block, "block");
        builder.addGroup(name, f17, f18, f19, f20, f21, f22, f23, clipPathData);
        block.invoke(builder);
        builder.clearGroup();
        return builder;
    }

    @NotNull
    /* JADX INFO: renamed from: path-R_LF-3I, reason: not valid java name */
    public static final ImageVector.Builder m2103pathR_LF3I(@NotNull ImageVector.Builder path, @NotNull String name, @Nullable Brush brush, float f10, @Nullable Brush brush2, float f11, float f12, int i10, int i11, float f13, int i12, @NotNull l<? super PathBuilder, k0> pathBuilder) {
        t.i(path, "$this$path");
        t.i(name, "name");
        t.i(pathBuilder, "pathBuilder");
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder.invoke(pathBuilder2);
        return path.m2102addPathoIyEayM(pathBuilder2.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : i12, (14336 & 4) != 0 ? "" : name, (14336 & 8) != 0 ? null : brush, (14336 & 16) != 0 ? 1.0f : f10, (14336 & 32) == 0 ? brush2 : null, (14336 & 64) != 0 ? 1.0f : f11, (14336 & 128) != 0 ? 0.0f : f12, (14336 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i10, (14336 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i11, (14336 & 1024) != 0 ? 4.0f : f13, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f);
    }

    /* JADX INFO: renamed from: path-R_LF-3I$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m2104pathR_LF3I$default(ImageVector.Builder path, String str, Brush brush, float f10, Brush brush2, float f11, float f12, int i10, int i11, float f13, int i12, l pathBuilder, int i13, Object obj) {
        String name = (i13 & 1) != 0 ? "" : str;
        Brush brush3 = (i13 & 2) != 0 ? null : brush;
        float f14 = (i13 & 4) != 0 ? 1.0f : f10;
        Brush brush4 = (i13 & 8) != 0 ? null : brush2;
        float f15 = (i13 & 16) != 0 ? 1.0f : f11;
        float f16 = (i13 & 32) != 0 ? 0.0f : f12;
        int defaultStrokeLineCap = (i13 & 64) != 0 ? VectorKt.getDefaultStrokeLineCap() : i10;
        int defaultStrokeLineJoin = (i13 & 128) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i11;
        float f17 = (i13 & 256) != 0 ? 4.0f : f13;
        int defaultFillType = (i13 & 512) != 0 ? VectorKt.getDefaultFillType() : i12;
        t.i(path, "$this$path");
        t.i(name, "name");
        t.i(pathBuilder, "pathBuilder");
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder.invoke(pathBuilder2);
        return path.m2102addPathoIyEayM(pathBuilder2.getNodes(), (14336 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (14336 & 4) != 0 ? "" : name, (14336 & 8) != 0 ? null : brush3, (14336 & 16) != 0 ? 1.0f : f14, (14336 & 32) == 0 ? brush4 : null, (14336 & 64) != 0 ? 1.0f : f15, (14336 & 128) != 0 ? 0.0f : f16, (14336 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : defaultStrokeLineCap, (14336 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : defaultStrokeLineJoin, (14336 & 1024) != 0 ? 4.0f : f17, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f);
    }
}
