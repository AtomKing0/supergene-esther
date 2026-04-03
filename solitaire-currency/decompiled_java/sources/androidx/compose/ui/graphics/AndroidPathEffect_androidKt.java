package androidx.compose.ui.graphics;

import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.PathDashPathEffect;
import androidx.compose.ui.graphics.StampedPathEffectStyle;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPathEffect.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPathEffect_androidKt {
    @NotNull
    public static final PathEffect actualChainPathEffect(@NotNull PathEffect outer, @NotNull PathEffect inner) {
        kotlin.jvm.internal.t.i(outer, "outer");
        kotlin.jvm.internal.t.i(inner, "inner");
        return new AndroidPathEffect(new ComposePathEffect(((AndroidPathEffect) outer).getNativePathEffect(), ((AndroidPathEffect) inner).getNativePathEffect()));
    }

    @NotNull
    public static final PathEffect actualCornerPathEffect(float f10) {
        return new AndroidPathEffect(new CornerPathEffect(f10));
    }

    @NotNull
    public static final PathEffect actualDashPathEffect(@NotNull float[] intervals, float f10) {
        kotlin.jvm.internal.t.i(intervals, "intervals");
        return new AndroidPathEffect(new DashPathEffect(intervals, f10));
    }

    @NotNull
    /* JADX INFO: renamed from: actualStampedPathEffect-7aD1DOk, reason: not valid java name */
    public static final PathEffect m1504actualStampedPathEffect7aD1DOk(@NotNull Path shape, float f10, float f11, int i10) {
        kotlin.jvm.internal.t.i(shape, "shape");
        if (shape instanceof AndroidPath) {
            return new AndroidPathEffect(new PathDashPathEffect(((AndroidPath) shape).getInternalPath(), f10, f11, m1505toAndroidPathDashPathEffectStyleoQv6xUo(i10)));
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @NotNull
    public static final android.graphics.PathEffect asAndroidPathEffect(@NotNull PathEffect pathEffect) {
        kotlin.jvm.internal.t.i(pathEffect, "<this>");
        return ((AndroidPathEffect) pathEffect).getNativePathEffect();
    }

    @NotNull
    /* JADX INFO: renamed from: toAndroidPathDashPathEffectStyle-oQv6xUo, reason: not valid java name */
    public static final PathDashPathEffect.Style m1505toAndroidPathDashPathEffectStyleoQv6xUo(int i10) {
        StampedPathEffectStyle.Companion companion = StampedPathEffectStyle.Companion;
        return StampedPathEffectStyle.m1871equalsimpl0(i10, companion.m1875getMorphYpspkwk()) ? PathDashPathEffect.Style.MORPH : StampedPathEffectStyle.m1871equalsimpl0(i10, companion.m1876getRotateYpspkwk()) ? PathDashPathEffect.Style.ROTATE : StampedPathEffectStyle.m1871equalsimpl0(i10, companion.m1877getTranslateYpspkwk()) ? PathDashPathEffect.Style.TRANSLATE : PathDashPathEffect.Style.TRANSLATE;
    }

    @NotNull
    public static final PathEffect toComposePathEffect(@NotNull android.graphics.PathEffect pathEffect) {
        kotlin.jvm.internal.t.i(pathEffect, "<this>");
        return new AndroidPathEffect(pathEffect);
    }
}
