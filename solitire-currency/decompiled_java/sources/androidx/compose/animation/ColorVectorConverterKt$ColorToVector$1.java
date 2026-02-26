package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ColorVectorConverter.kt */
/* JADX INFO: loaded from: classes.dex */
final class ColorVectorConverterKt$ColorToVector$1 extends v implements l<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> {
    public static final ColorVectorConverterKt$ColorToVector$1 INSTANCE = new ColorVectorConverterKt$ColorToVector$1();

    /* JADX INFO: renamed from: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ColorVectorConverter.kt */
    static final class AnonymousClass1 extends v implements l<Color, AnimationVector4D> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ AnimationVector4D invoke(Color color) {
            return m39invoke8_81llA(color.m1608unboximpl());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-8_81llA, reason: not valid java name */
        public final AnimationVector4D m39invoke8_81llA(long j10) {
            long jM1595convertvNxB06k = Color.m1595convertvNxB06k(j10, ColorSpaces.INSTANCE.getCieXyz());
            float fM1604getRedimpl = Color.m1604getRedimpl(jM1595convertvNxB06k);
            float fM1603getGreenimpl = Color.m1603getGreenimpl(jM1595convertvNxB06k);
            float fM1601getBlueimpl = Color.m1601getBlueimpl(jM1595convertvNxB06k);
            double d10 = 0.33333334f;
            return new AnimationVector4D(Color.m1600getAlphaimpl(j10), (float) Math.pow(ColorVectorConverterKt.multiplyColumn(0, fM1604getRedimpl, fM1603getGreenimpl, fM1601getBlueimpl, ColorVectorConverterKt.M1), d10), (float) Math.pow(ColorVectorConverterKt.multiplyColumn(1, fM1604getRedimpl, fM1603getGreenimpl, fM1601getBlueimpl, ColorVectorConverterKt.M1), d10), (float) Math.pow(ColorVectorConverterKt.multiplyColumn(2, fM1604getRedimpl, fM1603getGreenimpl, fM1601getBlueimpl, ColorVectorConverterKt.M1), d10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: ColorVectorConverter.kt */
    static final class AnonymousClass2 extends v implements l<AnimationVector4D, Color> {
        final /* synthetic */ ColorSpace $colorSpace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ColorSpace colorSpace) {
            super(1);
            this.$colorSpace = colorSpace;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Color invoke(AnimationVector4D animationVector4D) {
            return Color.m1588boximpl(m40invokevNxB06k(animationVector4D));
        }

        /* JADX INFO: renamed from: invoke-vNxB06k, reason: not valid java name */
        public final long m40invokevNxB06k(@NotNull AnimationVector4D it) {
            t.i(it, "it");
            double d10 = 3.0f;
            float fPow = (float) Math.pow(it.getV2(), d10);
            float fPow2 = (float) Math.pow(it.getV3(), d10);
            float fPow3 = (float) Math.pow(it.getV4(), d10);
            return Color.m1595convertvNxB06k(ColorKt.Color(o.m(ColorVectorConverterKt.multiplyColumn(0, fPow, fPow2, fPow3, ColorVectorConverterKt.InverseM1), -2.0f, 2.0f), o.m(ColorVectorConverterKt.multiplyColumn(1, fPow, fPow2, fPow3, ColorVectorConverterKt.InverseM1), -2.0f, 2.0f), o.m(ColorVectorConverterKt.multiplyColumn(2, fPow, fPow2, fPow3, ColorVectorConverterKt.InverseM1), -2.0f, 2.0f), o.m(it.getV1(), 0.0f, 1.0f), ColorSpaces.INSTANCE.getCieXyz()), this.$colorSpace);
        }
    }

    ColorVectorConverterKt$ColorToVector$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final TwoWayConverter<Color, AnimationVector4D> invoke(@NotNull ColorSpace colorSpace) {
        t.i(colorSpace, "colorSpace");
        return VectorConvertersKt.TwoWayConverter(AnonymousClass1.INSTANCE, new AnonymousClass2(colorSpace));
    }
}
