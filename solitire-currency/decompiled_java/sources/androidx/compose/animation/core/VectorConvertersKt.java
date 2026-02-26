package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VectorConvertersKt {

    @NotNull
    private static final TwoWayConverter<Float, AnimationVector1D> FloatToVector = TwoWayConverter(VectorConvertersKt$FloatToVector$1.INSTANCE, VectorConvertersKt$FloatToVector$2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<Integer, AnimationVector1D> IntToVector = TwoWayConverter(VectorConvertersKt$IntToVector$1.INSTANCE, VectorConvertersKt$IntToVector$2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<Dp, AnimationVector1D> DpToVector = TwoWayConverter(VectorConvertersKt$DpToVector$1.INSTANCE, VectorConvertersKt$DpToVector$2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<DpOffset, AnimationVector2D> DpOffsetToVector = TwoWayConverter(VectorConvertersKt$DpOffsetToVector$1.INSTANCE, VectorConvertersKt$DpOffsetToVector$2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<Size, AnimationVector2D> SizeToVector = TwoWayConverter(VectorConvertersKt$SizeToVector$1.INSTANCE, VectorConvertersKt$SizeToVector$2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<Offset, AnimationVector2D> OffsetToVector = TwoWayConverter(VectorConvertersKt$OffsetToVector$1.INSTANCE, VectorConvertersKt$OffsetToVector$2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<IntOffset, AnimationVector2D> IntOffsetToVector = TwoWayConverter(VectorConvertersKt$IntOffsetToVector$1.INSTANCE, VectorConvertersKt$IntOffsetToVector$2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<IntSize, AnimationVector2D> IntSizeToVector = TwoWayConverter(VectorConvertersKt$IntSizeToVector$1.INSTANCE, VectorConvertersKt$IntSizeToVector$2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<Rect, AnimationVector4D> RectToVector = TwoWayConverter(VectorConvertersKt$RectToVector$1.INSTANCE, VectorConvertersKt$RectToVector$2.INSTANCE);

    @NotNull
    public static final <T, V extends AnimationVector> TwoWayConverter<T, V> TwoWayConverter(@NotNull l<? super T, ? extends V> convertToVector, @NotNull l<? super V, ? extends T> convertFromVector) {
        t.i(convertToVector, "convertToVector");
        t.i(convertFromVector, "convertFromVector");
        return new TwoWayConverterImpl(convertToVector, convertFromVector);
    }

    @NotNull
    public static final TwoWayConverter<Float, AnimationVector1D> getVectorConverter(@NotNull m mVar) {
        t.i(mVar, "<this>");
        return FloatToVector;
    }

    public static final float lerp(float f10, float f11, float f12) {
        return (f10 * (1 - f12)) + (f11 * f12);
    }

    @NotNull
    public static final TwoWayConverter<Integer, AnimationVector1D> getVectorConverter(@NotNull s sVar) {
        t.i(sVar, "<this>");
        return IntToVector;
    }

    @NotNull
    public static final TwoWayConverter<Rect, AnimationVector4D> getVectorConverter(@NotNull Rect.Companion companion) {
        t.i(companion, "<this>");
        return RectToVector;
    }

    @NotNull
    public static final TwoWayConverter<Dp, AnimationVector1D> getVectorConverter(@NotNull Dp.Companion companion) {
        t.i(companion, "<this>");
        return DpToVector;
    }

    @NotNull
    public static final TwoWayConverter<DpOffset, AnimationVector2D> getVectorConverter(@NotNull DpOffset.Companion companion) {
        t.i(companion, "<this>");
        return DpOffsetToVector;
    }

    @NotNull
    public static final TwoWayConverter<Size, AnimationVector2D> getVectorConverter(@NotNull Size.Companion companion) {
        t.i(companion, "<this>");
        return SizeToVector;
    }

    @NotNull
    public static final TwoWayConverter<Offset, AnimationVector2D> getVectorConverter(@NotNull Offset.Companion companion) {
        t.i(companion, "<this>");
        return OffsetToVector;
    }

    @NotNull
    public static final TwoWayConverter<IntOffset, AnimationVector2D> getVectorConverter(@NotNull IntOffset.Companion companion) {
        t.i(companion, "<this>");
        return IntOffsetToVector;
    }

    @NotNull
    public static final TwoWayConverter<IntSize, AnimationVector2D> getVectorConverter(@NotNull IntSize.Companion companion) {
        t.i(companion, "<this>");
        return IntSizeToVector;
    }
}
