package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.y;

/* JADX INFO: compiled from: VisibilityThresholds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VisibilityThresholdsKt {
    private static final float DpVisibilityThreshold = 0.1f;
    private static final float PxVisibilityThreshold = 0.5f;

    @NotNull
    private static final Rect rectVisibilityThreshold;

    @NotNull
    private static final Map<TwoWayConverter<?, ?>, Float> visibilityThresholdMap;

    static {
        Float fValueOf = Float.valueOf(0.5f);
        rectVisibilityThreshold = new Rect(0.5f, 0.5f, 0.5f, 0.5f);
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(s.f29839a);
        Float fValueOf2 = Float.valueOf(1.0f);
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(Dp.Companion);
        Float fValueOf3 = Float.valueOf(0.1f);
        visibilityThresholdMap = r0.j(y.a(vectorConverter, fValueOf2), y.a(VectorConvertersKt.getVectorConverter(IntSize.Companion), fValueOf2), y.a(VectorConvertersKt.getVectorConverter(IntOffset.Companion), fValueOf2), y.a(VectorConvertersKt.getVectorConverter(m.f29832a), Float.valueOf(0.01f)), y.a(VectorConvertersKt.getVectorConverter(Rect.Companion), fValueOf), y.a(VectorConvertersKt.getVectorConverter(Size.Companion), fValueOf), y.a(VectorConvertersKt.getVectorConverter(Offset.Companion), fValueOf), y.a(vectorConverter2, fValueOf3), y.a(VectorConvertersKt.getVectorConverter(DpOffset.Companion), fValueOf3));
    }

    public static final int getVisibilityThreshold(@NotNull s sVar) {
        t.i(sVar, "<this>");
        return 1;
    }

    @NotNull
    public static final Map<TwoWayConverter<?, ?>, Float> getVisibilityThresholdMap() {
        return visibilityThresholdMap;
    }

    public static final long getVisibilityThreshold(@NotNull IntOffset.Companion companion) {
        t.i(companion, "<this>");
        return IntOffsetKt.IntOffset(1, 1);
    }

    public static final long getVisibilityThreshold(@NotNull Offset.Companion companion) {
        t.i(companion, "<this>");
        return OffsetKt.Offset(0.5f, 0.5f);
    }

    public static final long getVisibilityThreshold(@NotNull DpOffset.Companion companion) {
        t.i(companion, "<this>");
        Dp.Companion companion2 = Dp.Companion;
        return DpKt.m3694DpOffsetYgX7TsA(getVisibilityThreshold(companion2), getVisibilityThreshold(companion2));
    }

    public static final long getVisibilityThreshold(@NotNull Size.Companion companion) {
        t.i(companion, "<this>");
        return SizeKt.Size(0.5f, 0.5f);
    }

    public static final long getVisibilityThreshold(@NotNull IntSize.Companion companion) {
        t.i(companion, "<this>");
        return IntSizeKt.IntSize(1, 1);
    }

    @NotNull
    public static final Rect getVisibilityThreshold(@NotNull Rect.Companion companion) {
        t.i(companion, "<this>");
        return rectVisibilityThreshold;
    }

    public static final float getVisibilityThreshold(@NotNull Dp.Companion companion) {
        t.i(companion, "<this>");
        return Dp.m3673constructorimpl(0.1f);
    }
}
