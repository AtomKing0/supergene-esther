package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Connector.kt */
/* JADX INFO: loaded from: classes.dex */
public class Connector {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final ColorSpace destination;
    private final int renderIntent;

    @NotNull
    private final ColorSpace source;

    @Nullable
    private final float[] transform;

    @NotNull
    private final ColorSpace transformDestination;

    @NotNull
    private final ColorSpace transformSource;

    /* JADX INFO: compiled from: Connector.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        public final float[] m1953computeTransformYBCOT_4(ColorSpace colorSpace, ColorSpace colorSpace2, int i10) {
            if (!RenderIntent.m1958equalsimpl0(i10, RenderIntent.Companion.m1962getAbsoluteuksYyKA())) {
                return null;
            }
            long jM1948getModelxdoWZVw = colorSpace.m1948getModelxdoWZVw();
            ColorModel.Companion companion = ColorModel.Companion;
            boolean zM1939equalsimpl0 = ColorModel.m1939equalsimpl0(jM1948getModelxdoWZVw, companion.m1946getRgbxdoWZVw());
            boolean zM1939equalsimpl02 = ColorModel.m1939equalsimpl0(colorSpace2.m1948getModelxdoWZVw(), companion.m1946getRgbxdoWZVw());
            if (zM1939equalsimpl0 && zM1939equalsimpl02) {
                return null;
            }
            if (!zM1939equalsimpl0 && !zM1939equalsimpl02) {
                return null;
            }
            if (!zM1939equalsimpl0) {
                colorSpace = colorSpace2;
            }
            Rgb rgb = (Rgb) colorSpace;
            float[] xyz$ui_graphics_release = zM1939equalsimpl0 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = zM1939equalsimpl02 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            return new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]};
        }

        @NotNull
        public final Connector identity$ui_graphics_release(@NotNull final ColorSpace source) {
            t.i(source, "source");
            final int iM1964getRelativeuksYyKA = RenderIntent.Companion.m1964getRelativeuksYyKA();
            return new Connector(source, iM1964getRelativeuksYyKA) { // from class: androidx.compose.ui.graphics.colorspace.Connector$Companion$identity$1
                {
                    super(source, source, iM1964getRelativeuksYyKA, null);
                }

                @Override // androidx.compose.ui.graphics.colorspace.Connector
                @NotNull
                public float[] transform(@NotNull float[] v10) {
                    t.i(v10, "v");
                    return v10;
                }
            };
        }
    }

    /* JADX INFO: compiled from: Connector.kt */
    public static final class RgbConnector extends Connector {

        @NotNull
        private final Rgb mDestination;

        @NotNull
        private final Rgb mSource;

        @NotNull
        private final float[] mTransform;

        public /* synthetic */ RgbConnector(Rgb rgb, Rgb rgb2, int i10, k kVar) {
            this(rgb, rgb2, i10);
        }

        /* JADX INFO: renamed from: computeTransform-YBCOT_4, reason: not valid java name */
        private final float[] m1954computeTransformYBCOT_4(Rgb rgb, Rgb rgb2, int i10) {
            if (ColorSpaceKt.compare(rgb.getWhitePoint(), rgb2.getWhitePoint())) {
                return ColorSpaceKt.mul3x3(rgb2.getInverseTransform$ui_graphics_release(), rgb.getTransform$ui_graphics_release());
            }
            float[] transform$ui_graphics_release = rgb.getTransform$ui_graphics_release();
            float[] inverseTransform$ui_graphics_release = rgb2.getInverseTransform$ui_graphics_release();
            float[] xyz$ui_graphics_release = rgb.getWhitePoint().toXyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = rgb2.getWhitePoint().toXyz$ui_graphics_release();
            WhitePoint whitePoint = rgb.getWhitePoint();
            Illuminant illuminant = Illuminant.INSTANCE;
            if (!ColorSpaceKt.compare(whitePoint, illuminant.getD50())) {
                float[] transform$ui_graphics_release2 = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
                float[] d50Xyz$ui_graphics_release = illuminant.getD50Xyz$ui_graphics_release();
                float[] fArrCopyOf = Arrays.copyOf(d50Xyz$ui_graphics_release, d50Xyz$ui_graphics_release.length);
                t.h(fArrCopyOf, "copyOf(this, size)");
                transform$ui_graphics_release = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release2, xyz$ui_graphics_release, fArrCopyOf), rgb.getTransform$ui_graphics_release());
            }
            if (!ColorSpaceKt.compare(rgb2.getWhitePoint(), illuminant.getD50())) {
                float[] transform$ui_graphics_release3 = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
                float[] d50Xyz$ui_graphics_release2 = illuminant.getD50Xyz$ui_graphics_release();
                float[] fArrCopyOf2 = Arrays.copyOf(d50Xyz$ui_graphics_release2, d50Xyz$ui_graphics_release2.length);
                t.h(fArrCopyOf2, "copyOf(this, size)");
                inverseTransform$ui_graphics_release = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release3, xyz$ui_graphics_release2, fArrCopyOf2), rgb2.getTransform$ui_graphics_release()));
            }
            if (RenderIntent.m1958equalsimpl0(i10, RenderIntent.Companion.m1962getAbsoluteuksYyKA())) {
                transform$ui_graphics_release = ColorSpaceKt.mul3x3Diag(new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]}, transform$ui_graphics_release);
            }
            return ColorSpaceKt.mul3x3(inverseTransform$ui_graphics_release, transform$ui_graphics_release);
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        @NotNull
        public float[] transform(@NotNull float[] v10) {
            t.i(v10, "v");
            v10[0] = (float) this.mSource.getEotf().invoke(Double.valueOf(v10[0])).doubleValue();
            v10[1] = (float) this.mSource.getEotf().invoke(Double.valueOf(v10[1])).doubleValue();
            v10[2] = (float) this.mSource.getEotf().invoke(Double.valueOf(v10[2])).doubleValue();
            ColorSpaceKt.mul3x3Float3(this.mTransform, v10);
            v10[0] = (float) this.mDestination.getOetf().invoke(Double.valueOf(v10[0])).doubleValue();
            v10[1] = (float) this.mDestination.getOetf().invoke(Double.valueOf(v10[1])).doubleValue();
            v10[2] = (float) this.mDestination.getOetf().invoke(Double.valueOf(v10[2])).doubleValue();
            return v10;
        }

        private RgbConnector(Rgb rgb, Rgb rgb2, int i10) {
            super(rgb, rgb2, rgb, rgb2, i10, null, null);
            this.mSource = rgb;
            this.mDestination = rgb2;
            this.mTransform = m1954computeTransformYBCOT_4(rgb, rgb2, i10);
        }
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i10, k kVar) {
        this(colorSpace, colorSpace2, i10);
    }

    @NotNull
    public final ColorSpace getDestination() {
        return this.destination;
    }

    /* JADX INFO: renamed from: getRenderIntent-uksYyKA, reason: not valid java name */
    public final int m1951getRenderIntentuksYyKA() {
        return this.renderIntent;
    }

    @NotNull
    public final ColorSpace getSource() {
        return this.source;
    }

    @NotNull
    public final float[] transform(float f10, float f11, float f12) {
        return transform(new float[]{f10, f11, f12});
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i10, float[] fArr, k kVar) {
        this(colorSpace, colorSpace2, colorSpace3, colorSpace4, i10, fArr);
    }

    @NotNull
    public float[] transform(@NotNull float[] v10) {
        t.i(v10, "v");
        float[] xyz = this.transformSource.toXyz(v10);
        float[] fArr = this.transform;
        if (fArr != null) {
            xyz[0] = xyz[0] * fArr[0];
            xyz[1] = xyz[1] * fArr[1];
            xyz[2] = xyz[2] * fArr[2];
        }
        return this.transformDestination.fromXyz(xyz);
    }

    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i10, float[] fArr) {
        this.source = colorSpace;
        this.destination = colorSpace2;
        this.transformSource = colorSpace3;
        this.transformDestination = colorSpace4;
        this.renderIntent = i10;
        this.transform = fArr;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i10) {
        long jM1948getModelxdoWZVw = colorSpace.m1948getModelxdoWZVw();
        ColorModel.Companion companion = ColorModel.Companion;
        this(colorSpace, colorSpace2, ColorModel.m1939equalsimpl0(jM1948getModelxdoWZVw, companion.m1946getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace, Illuminant.INSTANCE.getD50(), null, 2, null) : colorSpace, ColorModel.m1939equalsimpl0(colorSpace2.m1948getModelxdoWZVw(), companion.m1946getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace2, Illuminant.INSTANCE.getD50(), null, 2, null) : colorSpace2, i10, Companion.m1953computeTransformYBCOT_4(colorSpace, colorSpace2, i10), null);
    }
}
