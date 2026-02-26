package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.unit.Dp;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt {

    @NotNull
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    /* JADX INFO: renamed from: androidx.compose.material.SwitchKt$Switch$2, reason: invalid class name */
    /* JADX INFO: compiled from: Switch.kt */
    static final class AnonymousClass2 extends v implements p<Boolean, Boolean, ThresholdConfig> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ ThresholdConfig mo4invoke(Boolean bool, Boolean bool2) {
            return invoke(bool.booleanValue(), bool2.booleanValue());
        }

        @NotNull
        public final ThresholdConfig invoke(boolean z10, boolean z11) {
            return new FractionalThreshold(0.5f);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwitchKt$Switch$4, reason: invalid class name */
    /* JADX INFO: compiled from: Switch.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ SwitchColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<Boolean, k0> $onCheckedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(boolean z10, l<? super Boolean, k0> lVar, Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, SwitchColors switchColors, int i10, int i11) {
            super(2);
            this.$checked = z10;
            this.$onCheckedChange = lVar;
            this.$modifier = modifier;
            this.$enabled = z11;
            this.$interactionSource = mutableInteractionSource;
            this.$colors = switchColors;
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
            SwitchKt.Switch(this.$checked, this.$onCheckedChange, this.$modifier, this.$enabled, this.$interactionSource, this.$colors, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwitchKt$SwitchImpl$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Switch.kt */
    static final class C09544 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ SwitchColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ BoxScope $this_SwitchImpl;
        final /* synthetic */ State<Float> $thumbValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09544(BoxScope boxScope, boolean z10, boolean z11, SwitchColors switchColors, State<Float> state, InteractionSource interactionSource, int i10) {
            super(2);
            this.$this_SwitchImpl = boxScope;
            this.$checked = z10;
            this.$enabled = z11;
            this.$colors = switchColors;
            this.$thumbValue = state;
            this.$interactionSource = interactionSource;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SwitchKt.SwitchImpl(this.$this_SwitchImpl, this.$checked, this.$enabled, this.$colors, this.$thumbValue, this.$interactionSource, composer, this.$$changed | 1);
        }
    }

    static {
        float fM3673constructorimpl = Dp.m3673constructorimpl(34);
        TrackWidth = fM3673constructorimpl;
        TrackStrokeWidth = Dp.m3673constructorimpl(14);
        float fM3673constructorimpl2 = Dp.m3673constructorimpl(20);
        ThumbDiameter = fM3673constructorimpl2;
        ThumbRippleRadius = Dp.m3673constructorimpl(24);
        DefaultSwitchPadding = Dp.m3673constructorimpl(2);
        SwitchWidth = fM3673constructorimpl;
        SwitchHeight = fM3673constructorimpl2;
        ThumbPathLength = Dp.m3673constructorimpl(fM3673constructorimpl - fM3673constructorimpl2);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m3673constructorimpl(1);
        ThumbPressedElevation = Dp.m3673constructorimpl(6);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014e  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Switch(boolean r35, @org.jetbrains.annotations.Nullable h9.l<? super java.lang.Boolean, v8.k0> r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r37, boolean r38, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r39, @org.jetbrains.annotations.Nullable androidx.compose.material.SwitchColors r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            Method dump skipped, instruction units count: 787
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, h9.l, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SwitchImpl(BoxScope boxScope, boolean z10, boolean z11, SwitchColors switchColors, State<Float> state, InteractionSource interactionSource, Composer composer, int i10) {
        int i11;
        int i12;
        long jM1161SwitchImpl$lambda7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1834839253);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 256 : 128;
        }
        if ((i10 & 7168) == 0) {
            i11 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(state) ? 16384 : 8192;
        }
        if ((458752 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        if ((374491 & i11) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i13 = (i11 >> 15) & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(interactionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (p<? super o0, ? super d<? super k0>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, i13);
            float f10 = snapshotStateList.isEmpty() ^ true ? ThumbPressedElevation : ThumbDefaultElevation;
            int i14 = ((i11 >> 3) & 896) | ((i11 >> 6) & 14) | (i11 & 112);
            State<Color> stateTrackColor = switchColors.trackColor(z11, z10, composerStartRestartGroup, i14);
            Modifier.Companion companion2 = Modifier.Companion;
            Alignment.Companion companion3 = Alignment.Companion;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(companion2, companion3.getCenter()), 0.0f, 1, null);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(stateTrackColor);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new SwitchKt$SwitchImpl$2$1(stateTrackColor);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierFillMaxSize$default, (l) objRememberedValue3, composerStartRestartGroup, 0);
            State<Color> stateThumbColor = switchColors.thumbColor(z11, z10, composerStartRestartGroup, i14);
            ElevationOverlay elevationOverlay = (ElevationOverlay) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalElevationOverlay());
            float fM3673constructorimpl = Dp.m3673constructorimpl(((Dp) composerStartRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m3687unboximpl() + f10);
            composerStartRestartGroup.startReplaceableGroup(-539245361);
            if (!Color.m1599equalsimpl0(m1161SwitchImpl$lambda7(stateThumbColor), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m955getSurface0d7_KjU()) || elevationOverlay == null) {
                i12 = 1157296644;
                jM1161SwitchImpl$lambda7 = m1161SwitchImpl$lambda7(stateThumbColor);
            } else {
                i12 = 1157296644;
                jM1161SwitchImpl$lambda7 = elevationOverlay.mo985apply7g2Lkgo(m1161SwitchImpl$lambda7(stateThumbColor), fM3673constructorimpl, composerStartRestartGroup, 0);
            }
            long j10 = jM1161SwitchImpl$lambda7;
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = boxScope.align(companion2, companion3.getCenterStart());
            composerStartRestartGroup.startReplaceableGroup(i12);
            boolean zChanged3 = composerStartRestartGroup.changed(state);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new SwitchKt$SwitchImpl$3$1(state);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m165backgroundbw27NRU(ShadowKt.m1296shadows4CzXII$default(SizeKt.m432requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (l) objRememberedValue4), interactionSource, RippleKt.m1237rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composerStartRestartGroup, 54, 4)), ThumbDiameter), f10, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), j10, RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C09544(boxScope, z10, z11, switchColors, state, interactionSource, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: SwitchImpl$lambda-5, reason: not valid java name */
    public static final long m1160SwitchImpl$lambda5(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    /* JADX INFO: renamed from: SwitchImpl$lambda-7, reason: not valid java name */
    private static final long m1161SwitchImpl$lambda7(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1164drawTrackRPmYEkk(DrawScope drawScope, long j10, float f10, float f11) {
        float f12 = f11 / 2;
        b.C(drawScope, j10, androidx.compose.ui.geometry.OffsetKt.Offset(f12, Offset.m1368getYimpl(drawScope.mo1995getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f10 - f12, Offset.m1368getYimpl(drawScope.mo1995getCenterF1C5BW0())), f11, StrokeCap.Companion.m1886getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }
}
