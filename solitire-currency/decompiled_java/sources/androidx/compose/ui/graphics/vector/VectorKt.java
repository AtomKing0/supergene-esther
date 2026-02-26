package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import h9.l;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Vector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VectorKt {

    @NotNull
    public static final String DefaultGroupName = "";

    @NotNull
    public static final String DefaultPathName = "";
    public static final float DefaultPivotX = 0.0f;
    public static final float DefaultPivotY = 0.0f;
    public static final float DefaultRotation = 0.0f;
    public static final float DefaultScaleX = 1.0f;
    public static final float DefaultScaleY = 1.0f;
    public static final float DefaultStrokeLineMiter = 4.0f;
    public static final float DefaultStrokeLineWidth = 0.0f;
    public static final float DefaultTranslationX = 0.0f;
    public static final float DefaultTranslationY = 0.0f;
    public static final float DefaultTrimPathEnd = 1.0f;
    public static final float DefaultTrimPathOffset = 0.0f;
    public static final float DefaultTrimPathStart = 0.0f;

    @NotNull
    private static final List<PathNode> EmptyPath = v.l();
    private static final int DefaultStrokeLineCap = StrokeCap.Companion.m1885getButtKaPHkGw();
    private static final int DefaultStrokeLineJoin = StrokeJoin.Companion.m1896getMiterLxFBmk8();
    private static final int DefaultTintBlendMode = BlendMode.Companion.m1546getSrcIn0nO6VwU();
    private static final long DefaultTintColor = Color.Companion.m1633getTransparent0d7_KjU();
    private static final int DefaultFillType = PathFillType.Companion.m1825getNonZeroRgk1Os();

    @NotNull
    public static final List<PathNode> PathData(@NotNull l<? super PathBuilder, k0> block) {
        t.i(block, "block");
        PathBuilder pathBuilder = new PathBuilder();
        block.invoke(pathBuilder);
        return pathBuilder.getNodes();
    }

    @NotNull
    public static final List<PathNode> addPathNodes(@Nullable String str) {
        return str == null ? EmptyPath : new PathParser().parsePathString(str).toNodes();
    }

    public static final int getDefaultFillType() {
        return DefaultFillType;
    }

    public static final int getDefaultStrokeLineCap() {
        return DefaultStrokeLineCap;
    }

    public static final int getDefaultStrokeLineJoin() {
        return DefaultStrokeLineJoin;
    }

    public static final int getDefaultTintBlendMode() {
        return DefaultTintBlendMode;
    }

    public static final long getDefaultTintColor() {
        return DefaultTintColor;
    }

    @NotNull
    public static final List<PathNode> getEmptyPath() {
        return EmptyPath;
    }
}
