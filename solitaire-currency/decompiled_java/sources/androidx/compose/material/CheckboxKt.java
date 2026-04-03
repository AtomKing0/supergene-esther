package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import h9.a;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxRippleRadius = Dp.m3673constructorimpl(24);
    private static final float CheckboxSize = Dp.m3673constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    /* JADX INFO: renamed from: androidx.compose.material.CheckboxKt$Checkbox$3, reason: invalid class name */
    /* JADX INFO: compiled from: Checkbox.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ CheckboxColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<Boolean, k0> $onCheckedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(boolean z10, l<? super Boolean, k0> lVar, Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, int i10, int i11) {
            super(2);
            this.$checked = z10;
            this.$onCheckedChange = lVar;
            this.$modifier = modifier;
            this.$enabled = z11;
            this.$interactionSource = mutableInteractionSource;
            this.$colors = checkboxColors;
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
            CheckboxKt.Checkbox(this.$checked, this.$onCheckedChange, this.$modifier, this.$enabled, this.$interactionSource, this.$colors, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.CheckboxKt$CheckboxImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: Checkbox.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ CheckboxColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ ToggleableState $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z10, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, int i10) {
            super(2);
            this.$enabled = z10;
            this.$value = toggleableState;
            this.$modifier = modifier;
            this.$colors = checkboxColors;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            CheckboxKt.CheckboxImpl(this.$enabled, this.$value, this.$modifier, this.$colors, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.CheckboxKt$TriStateCheckbox$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Checkbox.kt */
    static final class C09172 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ CheckboxColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ a<k0> $onClick;
        final /* synthetic */ ToggleableState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09172(ToggleableState toggleableState, a<k0> aVar, Modifier modifier, boolean z10, MutableInteractionSource mutableInteractionSource, CheckboxColors checkboxColors, int i10, int i11) {
            super(2);
            this.$state = toggleableState;
            this.$onClick = aVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$interactionSource = mutableInteractionSource;
            this.$colors = checkboxColors;
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
            CheckboxKt.TriStateCheckbox(this.$state, this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$colors, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        float f10 = 2;
        CheckboxDefaultPadding = Dp.m3673constructorimpl(f10);
        StrokeWidth = Dp.m3673constructorimpl(f10);
        RadiusSize = Dp.m3673constructorimpl(f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Checkbox(boolean r26, @org.jetbrains.annotations.Nullable h9.l<? super java.lang.Boolean, v8.k0> r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, boolean r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r30, @org.jetbrains.annotations.Nullable androidx.compose.material.CheckboxColors r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.Checkbox(boolean, h9.l, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0209 A[LOOP:0: B:77:0x0207->B:78:0x0209, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0221  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CheckboxImpl(boolean r34, androidx.compose.ui.state.ToggleableState r35, androidx.compose.ui.Modifier r36, androidx.compose.material.CheckboxColors r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            Method dump skipped, instruction units count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-10, reason: not valid java name */
    public static final long m917CheckboxImpl$lambda10(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-4, reason: not valid java name */
    public static final float m918CheckboxImpl$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-6, reason: not valid java name */
    public static final float m919CheckboxImpl$lambda6(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-8, reason: not valid java name */
    public static final long m920CheckboxImpl$lambda8(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CheckboxImpl$lambda-9, reason: not valid java name */
    public static final long m921CheckboxImpl$lambda9(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0144  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TriStateCheckbox(@org.jetbrains.annotations.NotNull androidx.compose.ui.state.ToggleableState r25, @org.jetbrains.annotations.Nullable h9.a<v8.k0> r26, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r27, boolean r28, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r29, @org.jetbrains.annotations.Nullable androidx.compose.material.CheckboxColors r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, h9.a, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.CheckboxColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m929drawBox1wkBAMs(DrawScope drawScope, long j10, long j11, float f10, float f11) {
        float f12 = f11 / 2.0f;
        Stroke stroke = new Stroke(f11, 0.0f, 0, 0, null, 30, null);
        float fM1436getWidthimpl = Size.m1436getWidthimpl(drawScope.mo1996getSizeNHjbRc());
        if (Color.m1599equalsimpl0(j10, j11)) {
            b.M(drawScope, j10, 0L, SizeKt.Size(fM1436getWidthimpl, fM1436getWidthimpl), CornerRadiusKt.CornerRadius$default(f10, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        float f13 = fM1436getWidthimpl - (2 * f11);
        b.M(drawScope, j10, OffsetKt.Offset(f11, f11), SizeKt.Size(f13, f13), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f10 - f11), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f14 = fM1436getWidthimpl - f11;
        b.M(drawScope, j11, OffsetKt.Offset(f12, f12), SizeKt.Size(f14, f14), CornerRadiusKt.CornerRadius$default(f10 - f12, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m930drawCheck3IgeMak(DrawScope drawScope, long j10, float f10, float f11, float f12, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f12, 0.0f, StrokeCap.Companion.m1887getSquareKaPHkGw(), 0, null, 26, null);
        float fM1436getWidthimpl = Size.m1436getWidthimpl(drawScope.mo1996getSizeNHjbRc());
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f11);
        float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f11);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f11);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f11);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * fM1436getWidthimpl, fLerp3 * fM1436getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fM1436getWidthimpl, fLerp2 * fM1436getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * fM1436getWidthimpl, fM1436getWidthimpl * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f10, checkDrawingCache.getPathToDraw(), true);
        b.G(drawScope, checkDrawingCache.getPathToDraw(), j10, 0.0f, stroke, null, 0, 52, null);
    }
}
