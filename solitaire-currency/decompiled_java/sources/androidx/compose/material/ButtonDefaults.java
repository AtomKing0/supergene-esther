package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;

    @NotNull
    private static final PaddingValues ContentPadding;

    @NotNull
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize;

    @NotNull
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;

    static {
        float fM3673constructorimpl = Dp.m3673constructorimpl(16);
        ButtonHorizontalPadding = fM3673constructorimpl;
        float f10 = 8;
        float fM3673constructorimpl2 = Dp.m3673constructorimpl(f10);
        ButtonVerticalPadding = fM3673constructorimpl2;
        PaddingValues paddingValuesM395PaddingValuesa9UjIt4 = PaddingKt.m395PaddingValuesa9UjIt4(fM3673constructorimpl, fM3673constructorimpl2, fM3673constructorimpl, fM3673constructorimpl2);
        ContentPadding = paddingValuesM395PaddingValuesa9UjIt4;
        MinWidth = Dp.m3673constructorimpl(64);
        MinHeight = Dp.m3673constructorimpl(36);
        IconSize = Dp.m3673constructorimpl(18);
        IconSpacing = Dp.m3673constructorimpl(f10);
        OutlinedBorderSize = Dp.m3673constructorimpl(1);
        float fM3673constructorimpl3 = Dp.m3673constructorimpl(f10);
        TextButtonHorizontalPadding = fM3673constructorimpl3;
        TextButtonContentPadding = PaddingKt.m395PaddingValuesa9UjIt4(fM3673constructorimpl3, paddingValuesM395PaddingValuesa9UjIt4.mo382calculateTopPaddingD9Ej5fM(), fM3673constructorimpl3, paddingValuesM395PaddingValuesa9UjIt4.mo379calculateBottomPaddingD9Ej5fM());
    }

    private ButtonDefaults() {
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m901buttonColorsro_MJ88(long j10, long j11, long j12, long j13, @Nullable Composer composer, int i10, int i11) {
        long jM1644compositeOverOWjLjI;
        composer.startReplaceableGroup(1870371134);
        long jM951getPrimary0d7_KjU = (i11 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j10;
        long jM969contentColorForek8zF_U = (i11 & 2) != 0 ? ColorsKt.m969contentColorForek8zF_U(jM951getPrimary0d7_KjU, composer, i10 & 14) : j11;
        if ((i11 & 4) != 0) {
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            jM1644compositeOverOWjLjI = ColorKt.m1644compositeOverOWjLjI(Color.m1597copywmQWz5c$default(materialTheme.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.getColors(composer, 6).m955getSurface0d7_KjU());
        } else {
            jM1644compositeOverOWjLjI = j12;
        }
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM951getPrimary0d7_KjU, jM969contentColorForek8zF_U, jM1644compositeOverOWjLjI, (i11 & 8) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j13, null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v6 ??, still in use, count: 1, list:
          (r2v6 ?? I:java.lang.Object) from 0x0096: INVOKE (r19v0 ?? I:androidx.compose.runtime.Composer), (r2v6 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:151)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    /* JADX INFO: renamed from: elevation-R_JCAzs, reason: not valid java name */
    public final androidx.compose.material.ButtonElevation m902elevationR_JCAzs(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v6 ??, still in use, count: 1, list:
          (r2v6 ?? I:java.lang.Object) from 0x0096: INVOKE (r19v0 ?? I:androidx.compose.runtime.Composer), (r2v6 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:151)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r14v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    @Composable
    /* JADX INFO: renamed from: elevation-yajeYGU, reason: not valid java name */
    public final /* synthetic */ ButtonElevation m903elevationyajeYGU(float f10, float f11, float f12, Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1428576874);
        if ((i11 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(2);
        }
        float f13 = f10;
        if ((i11 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(8);
        }
        float f14 = f11;
        if ((i11 & 4) != 0) {
            f12 = Dp.m3673constructorimpl(0);
        }
        float f15 = 4;
        ButtonElevation buttonElevationM902elevationR_JCAzs = m902elevationR_JCAzs(f13, f14, f12, Dp.m3673constructorimpl(f15), Dp.m3673constructorimpl(f15), composer, (i10 & 14) | 27648 | (i10 & 112) | (i10 & 896) | ((i10 << 6) & 458752), 0);
        composer.endReplaceableGroup();
        return buttonElevationM902elevationR_JCAzs;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m904getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m905getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m906getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m907getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    @Composable
    @NotNull
    public final BorderStroke getOutlinedBorder(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-2091313033);
        BorderStroke borderStrokeM180BorderStrokecXLIe8U = BorderStrokeKt.m180BorderStrokecXLIe8U(OutlinedBorderSize, Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        composer.endReplaceableGroup();
        return borderStrokeM180BorderStrokecXLIe8U;
    }

    /* JADX INFO: renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m908getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    @NotNull
    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m909outlinedButtonColorsRGew2ao(long j10, long j11, long j12, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-2124406093);
        long jM955getSurface0d7_KjU = (i11 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU() : j10;
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM955getSurface0d7_KjU, (i11 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j11, jM955getSurface0d7_KjU, (i11 & 4) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j12, null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: textButtonColors-RGew2ao, reason: not valid java name */
    public final ButtonColors m910textButtonColorsRGew2ao(long j10, long j11, long j12, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(182742216);
        long jM1633getTransparent0d7_KjU = (i11 & 1) != 0 ? Color.Companion.m1633getTransparent0d7_KjU() : j10;
        DefaultButtonColors defaultButtonColors = new DefaultButtonColors(jM1633getTransparent0d7_KjU, (i11 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j11, jM1633getTransparent0d7_KjU, (i11 & 4) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j12, null);
        composer.endReplaceableGroup();
        return defaultButtonColors;
    }
}
