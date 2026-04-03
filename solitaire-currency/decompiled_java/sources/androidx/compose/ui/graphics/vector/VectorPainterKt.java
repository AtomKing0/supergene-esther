package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import h9.l;
import h9.p;
import h9.r;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: VectorPainter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VectorPainterKt {

    @NotNull
    public static final String RootGroupName = "VectorRootGroup";

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: VectorPainter.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ Map<String, VectorConfig> $configs;
        final /* synthetic */ VectorNode $vectorNode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(VectorNode vectorNode, Map<String, ? extends VectorConfig> map) {
            super(2);
            this.$vectorNode = vectorNode;
            this.$configs = map;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                VectorPainterKt.RenderVectorGroup((VectorGroup) this.$vectorNode, this.$configs, composer, 64, 0);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2, reason: invalid class name */
    /* JADX INFO: compiled from: VectorPainter.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Map<String, VectorConfig> $configs;
        final /* synthetic */ VectorGroup $group;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(VectorGroup vectorGroup, Map<String, ? extends VectorConfig> map, int i10, int i11) {
            super(2);
            this.$group = vectorGroup;
            this.$configs = map;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            VectorPainterKt.RenderVectorGroup(this.$group, this.$configs, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorPainterKt$rememberVectorPainter$3, reason: invalid class name */
    /* JADX INFO: compiled from: VectorPainter.kt */
    static final class AnonymousClass3 extends v implements r<Float, Float, Composer, Integer, k0> {
        final /* synthetic */ ImageVector $image;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ImageVector imageVector) {
            super(4);
            this.$image = imageVector;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(Float f10, Float f11, Composer composer, Integer num) {
            invoke(f10.floatValue(), f11.floatValue(), composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
        @Composable
        public final void invoke(float f10, float f11, @Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                VectorPainterKt.RenderVectorGroup(this.$image.getRoot(), null, composer, 0, 2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RenderVectorGroup(@org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.vector.VectorGroup r23, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, ? extends androidx.compose.ui.graphics.vector.VectorConfig> r24, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void mirror(DrawScope drawScope, l<? super DrawScope, k0> lVar) {
        long jMo1995getCenterF1C5BW0 = drawScope.mo1995getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo2009scale0AR0LA0(-1.0f, 1.0f, jMo1995getCenterF1C5BW0);
        lVar.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
    }

    @Composable
    @NotNull
    public static final VectorPainter rememberVectorPainter(@NotNull ImageVector image, @Nullable Composer composer, int i10) {
        t.i(image, "image");
        composer.startReplaceableGroup(1413834416);
        VectorPainter vectorPainterM2130rememberVectorPaintervIP8VLU = m2130rememberVectorPaintervIP8VLU(image.m2098getDefaultWidthD9Ej5fM(), image.m2097getDefaultHeightD9Ej5fM(), image.getViewportWidth(), image.getViewportHeight(), image.getName(), image.m2100getTintColor0d7_KjU(), image.m2099getTintBlendMode0nO6VwU(), image.getAutoMirror(), ComposableLambdaKt.composableLambda(composer, 1873274766, true, new AnonymousClass3(image)), composer, 100663296, 0);
        composer.endReplaceableGroup();
        return vectorPainterM2130rememberVectorPaintervIP8VLU;
    }

    @Composable
    @ComposableOpenTarget(index = -1)
    @NotNull
    /* JADX INFO: renamed from: rememberVectorPainter-mlNsNFs, reason: not valid java name */
    public static final VectorPainter m2129rememberVectorPaintermlNsNFs(float f10, float f11, float f12, float f13, @Nullable String str, long j10, int i10, @NotNull r<? super Float, ? super Float, ? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i11, int i12) {
        t.i(content, "content");
        composer.startReplaceableGroup(-964365210);
        VectorPainter vectorPainterM2130rememberVectorPaintervIP8VLU = m2130rememberVectorPaintervIP8VLU(f10, f11, (i12 & 4) != 0 ? Float.NaN : f12, (i12 & 8) != 0 ? Float.NaN : f13, (i12 & 16) != 0 ? RootGroupName : str, (i12 & 32) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j10, (i12 & 64) != 0 ? BlendMode.Companion.m1546getSrcIn0nO6VwU() : i10, false, content, composer, (i11 & 14) | 12582912 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | ((i11 << 3) & 234881024), 0);
        composer.endReplaceableGroup();
        return vectorPainterM2130rememberVectorPaintervIP8VLU;
    }

    @Composable
    @ComposableOpenTarget(index = -1)
    @NotNull
    /* JADX INFO: renamed from: rememberVectorPainter-vIP8VLU, reason: not valid java name */
    public static final VectorPainter m2130rememberVectorPaintervIP8VLU(float f10, float f11, float f12, float f13, @Nullable String str, long j10, int i10, boolean z10, @NotNull r<? super Float, ? super Float, ? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i11, int i12) {
        t.i(content, "content");
        composer.startReplaceableGroup(1068590786);
        float f14 = (i12 & 4) != 0 ? Float.NaN : f12;
        float f15 = (i12 & 8) == 0 ? f13 : Float.NaN;
        String str2 = (i12 & 16) != 0 ? RootGroupName : str;
        long jM1634getUnspecified0d7_KjU = (i12 & 32) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j10;
        int iM1546getSrcIn0nO6VwU = (i12 & 64) != 0 ? BlendMode.Companion.m1546getSrcIn0nO6VwU() : i10;
        boolean z11 = (i12 & 128) != 0 ? false : z10;
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        float fMo296toPx0680j_4 = density.mo296toPx0680j_4(f10);
        float fMo296toPx0680j_42 = density.mo296toPx0680j_4(f11);
        if (Float.isNaN(f14)) {
            f14 = fMo296toPx0680j_4;
        }
        if (Float.isNaN(f15)) {
            f15 = fMo296toPx0680j_42;
        }
        Color colorM1588boximpl = Color.m1588boximpl(jM1634getUnspecified0d7_KjU);
        BlendMode blendModeM1514boximpl = BlendMode.m1514boximpl(iM1546getSrcIn0nO6VwU);
        int i13 = i11 >> 15;
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(colorM1588boximpl) | composer.changed(blendModeM1514boximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = !Color.m1599equalsimpl0(jM1634getUnspecified0d7_KjU, Color.Companion.m1634getUnspecified0d7_KjU()) ? ColorFilter.Companion.m1642tintxETnrds(jM1634getUnspecified0d7_KjU, iM1546getSrcIn0nO6VwU) : null;
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        ColorFilter colorFilter = (ColorFilter) objRememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new VectorPainter();
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        VectorPainter vectorPainter = (VectorPainter) objRememberedValue2;
        vectorPainter.m2128setSizeuvyYCjk$ui_release(SizeKt.Size(fMo296toPx0680j_4, fMo296toPx0680j_42));
        vectorPainter.setAutoMirror$ui_release(z11);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.RenderVector$ui_release(str2, f14, f15, content, composer, ((i11 >> 12) & 14) | 32768 | (i13 & 7168));
        composer.endReplaceableGroup();
        return vectorPainter;
    }
}
