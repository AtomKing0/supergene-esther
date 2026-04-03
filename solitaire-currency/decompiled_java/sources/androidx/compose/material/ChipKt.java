package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChipKt {
    private static final float LeadingIconEndSpacing;
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float TrailingIconSpacing;
    private static final float HorizontalPadding = Dp.m3673constructorimpl(12);
    private static final float LeadingIconStartSpacing = Dp.m3673constructorimpl(4);
    private static final float SelectedIconContainerSize = Dp.m3673constructorimpl(24);

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$2, reason: invalid class name */
    /* JADX INFO: compiled from: Chip.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ ChipColors $colors;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
        final /* synthetic */ State<Color> $contentColor$delegate;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;

        /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Chip.kt */
        static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ ChipColors $colors;
            final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
            final /* synthetic */ boolean $enabled;
            final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;

            /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Chip.kt */
            static final class C00881 extends v implements p<Composer, Integer, k0> {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ ChipColors $colors;
                final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
                final /* synthetic */ boolean $enabled;
                final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00881(p<? super Composer, ? super Integer, k0> pVar, ChipColors chipColors, boolean z10, int i10, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar) {
                    super(2);
                    this.$leadingIcon = pVar;
                    this.$colors = chipColors;
                    this.$enabled = z10;
                    this.$$dirty = i10;
                    this.$content = qVar;
                }

                /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
                private static final long m941invoke$lambda1$lambda0(State<Color> state) {
                    return state.getValue().m1608unboximpl();
                }

                @Override // h9.p
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return k0.f35197a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i10) {
                    if ((i10 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    Modifier.Companion companion = Modifier.Companion;
                    Modifier modifierM403paddingqDBjuR0$default = PaddingKt.m403paddingqDBjuR0$default(SizeKt.m425defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m934getMinHeightD9Ej5fM(), 1, null), this.$leadingIcon == null ? ChipKt.HorizontalPadding : Dp.m3673constructorimpl(0), 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    p<Composer, Integer, k0> pVar = this.$leadingIcon;
                    ChipColors chipColors = this.$colors;
                    boolean z10 = this.$enabled;
                    int i11 = this.$$dirty;
                    q<RowScope, Composer, Integer, k0> qVar = this.$content;
                    composer.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
                    composer.startReplaceableGroup(-1323940314);
                    Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    a<ComposeUiNode> constructor = companion2.getConstructor();
                    q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM403paddingqDBjuR0$default);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    composer.disableReusing();
                    Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer);
                    Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
                    Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                    Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                    composer.enableReusing();
                    qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    composer.startReplaceableGroup(-678309503);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    composer.startReplaceableGroup(951468004);
                    composer.startReplaceableGroup(2084788874);
                    if (pVar != null) {
                        SpacerKt.Spacer(SizeKt.m445width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer, 6);
                        State<Color> stateLeadingIconContentColor = chipColors.leadingIconContentColor(z10, composer, ((i11 >> 6) & 14) | ((i11 >> 15) & 112));
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1588boximpl(m941invoke$lambda1$lambda0(stateLeadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1600getAlphaimpl(m941invoke$lambda1$lambda0(stateLeadingIconContentColor))))}, pVar, composer, ((i11 >> 18) & 112) | 8);
                        SpacerKt.Spacer(SizeKt.m445width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer, 6);
                    }
                    composer.endReplaceableGroup();
                    qVar.invoke(rowScopeInstance, composer, Integer.valueOf(((i11 >> 21) & 112) | 6));
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(p<? super Composer, ? super Integer, k0> pVar, ChipColors chipColors, boolean z10, int i10, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar) {
                super(2);
                this.$leadingIcon = pVar;
                this.$colors = chipColors;
                this.$enabled = z10;
                this.$$dirty = i10;
                this.$content = qVar;
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return k0.f35197a;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer, int i10) {
                if ((i10 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                } else {
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.composableLambda(composer, -1131213696, true, new C00881(this.$leadingIcon, this.$colors, this.$enabled, this.$$dirty, this.$content)), composer, 48);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(State<Color> state, p<? super Composer, ? super Integer, k0> pVar, ChipColors chipColors, boolean z10, int i10, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar) {
            super(2);
            this.$contentColor$delegate = state;
            this.$leadingIcon = pVar;
            this.$colors = chipColors;
            this.$enabled = z10;
            this.$$dirty = i10;
            this.$content = qVar;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1600getAlphaimpl(ChipKt.m939Chip$lambda1(this.$contentColor$delegate))))}, ComposableLambdaKt.composableLambda(composer, 667535631, true, new AnonymousClass1(this.$leadingIcon, this.$colors, this.$enabled, this.$$dirty, this.$content)), composer, 56);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$Chip$3, reason: invalid class name */
    /* JADX INFO: compiled from: Chip.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ ChipColors $colors;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ a<k0> $onClick;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(a<k0> aVar, Modifier modifier, boolean z10, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, p<? super Composer, ? super Integer, k0> pVar, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$onClick = aVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$interactionSource = mutableInteractionSource;
            this.$shape = shape;
            this.$border = borderStroke;
            this.$colors = chipColors;
            this.$leadingIcon = pVar;
            this.$content = qVar;
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
            ChipKt.Chip(this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$shape, this.$border, this.$colors, this.$leadingIcon, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Chip.kt */
    static final class C09182 extends v implements l<SemanticsPropertyReceiver, k0> {
        public static final C09182 INSTANCE = new C09182();

        C09182() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            SemanticsPropertiesKt.m3247setRolekuIjeqM(semantics, Role.Companion.m3235getCheckboxo7Vup1c());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Chip.kt */
    static final class C09193 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ SelectableChipColors $colors;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
        final /* synthetic */ State<Color> $contentColor;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ p<Composer, Integer, k0> $selectedIcon;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;

        /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: Chip.kt */
        static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ int $$dirty1;
            final /* synthetic */ SelectableChipColors $colors;
            final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
            final /* synthetic */ State<Color> $contentColor;
            final /* synthetic */ boolean $enabled;
            final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
            final /* synthetic */ boolean $selected;
            final /* synthetic */ p<Composer, Integer, k0> $selectedIcon;
            final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;

            /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$3$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Chip.kt */
            static final class C00891 extends v implements p<Composer, Integer, k0> {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ int $$dirty1;
                final /* synthetic */ SelectableChipColors $colors;
                final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
                final /* synthetic */ State<Color> $contentColor;
                final /* synthetic */ boolean $enabled;
                final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
                final /* synthetic */ boolean $selected;
                final /* synthetic */ p<Composer, Integer, k0> $selectedIcon;
                final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00891(p<? super Composer, ? super Integer, k0> pVar, boolean z10, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, SelectableChipColors selectableChipColors, boolean z11, int i11, State<Color> state) {
                    super(2);
                    this.$leadingIcon = pVar;
                    this.$selected = z10;
                    this.$selectedIcon = pVar2;
                    this.$trailingIcon = pVar3;
                    this.$content = qVar;
                    this.$$dirty1 = i10;
                    this.$colors = selectableChipColors;
                    this.$enabled = z11;
                    this.$$dirty = i11;
                    this.$contentColor = state;
                }

                @Override // h9.p
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return k0.f35197a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i10) {
                    RowScopeInstance rowScopeInstance;
                    int i11;
                    Modifier modifierClip;
                    if ((i10 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    Modifier.Companion companion = Modifier.Companion;
                    Modifier modifierM403paddingqDBjuR0$default = PaddingKt.m403paddingqDBjuR0$default(SizeKt.m425defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m934getMinHeightD9Ej5fM(), 1, null), (this.$leadingIcon != null || (this.$selected && this.$selectedIcon != null)) ? Dp.m3673constructorimpl(0) : ChipKt.HorizontalPadding, 0.0f, this.$trailingIcon == null ? ChipKt.HorizontalPadding : Dp.m3673constructorimpl(0), 0.0f, 10, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Companion companion2 = Alignment.Companion;
                    Alignment.Vertical centerVertically = companion2.getCenterVertically();
                    p<Composer, Integer, k0> pVar = this.$leadingIcon;
                    boolean z10 = this.$selected;
                    p<Composer, Integer, k0> pVar2 = this.$selectedIcon;
                    q<RowScope, Composer, Integer, k0> qVar = this.$content;
                    int i12 = this.$$dirty1;
                    p<Composer, Integer, k0> pVar3 = this.$trailingIcon;
                    SelectableChipColors selectableChipColors = this.$colors;
                    boolean z11 = this.$enabled;
                    int i13 = this.$$dirty;
                    State<Color> state = this.$contentColor;
                    composer.startReplaceableGroup(693286680);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
                    composer.startReplaceableGroup(-1323940314);
                    Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                    a<ComposeUiNode> constructor = companion3.getConstructor();
                    q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM403paddingqDBjuR0$default);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    composer.disableReusing();
                    Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer);
                    Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m1265setimpl(composerM1258constructorimpl, density, companion3.getSetDensity());
                    Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
                    Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
                    composer.enableReusing();
                    qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    composer.startReplaceableGroup(-678309503);
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    composer.startReplaceableGroup(1218705642);
                    composer.startReplaceableGroup(-1943412137);
                    if (pVar != null || (z10 && pVar2 != null)) {
                        SpacerKt.Spacer(SizeKt.m445width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer, 6);
                        composer.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
                        composer.startReplaceableGroup(-1323940314);
                        Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        a<ComposeUiNode> constructor2 = companion3.getConstructor();
                        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf2 = LayoutKt.materializerOf(companion);
                        rowScopeInstance = rowScopeInstance2;
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor2);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer composerM1258constructorimpl2 = Updater.m1258constructorimpl(composer);
                        Updater.m1265setimpl(composerM1258constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1265setimpl(composerM1258constructorimpl2, density2, companion3.getSetDensity());
                        Updater.m1265setimpl(composerM1258constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                        Updater.m1265setimpl(composerM1258constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                        composer.enableReusing();
                        qVarMaterializerOf2.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        composer.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer.startReplaceableGroup(-626917591);
                        composer.startReplaceableGroup(649985595);
                        if (pVar != null) {
                            State<Color> stateLeadingIconColor = selectableChipColors.leadingIconColor(z11, z10, composer, ((i13 >> 9) & 14) | ((i13 << 3) & 112) | ((i13 >> 15) & 896));
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(stateLeadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1600getAlphaimpl(stateLeadingIconColor.getValue().m1608unboximpl())))}, pVar, composer, ((i13 >> 21) & 112) | 8);
                        }
                        composer.endReplaceableGroup();
                        composer.startReplaceableGroup(-1943411323);
                        if (z10 && pVar2 != null) {
                            long jM1608unboximpl = state.getValue().m1608unboximpl();
                            composer.startReplaceableGroup(649986426);
                            if (pVar != null) {
                                modifierClip = ClipKt.clip(BackgroundKt.m165backgroundbw27NRU(SizeKt.m432requiredSize3ABfNKs(companion, ChipKt.SelectedIconContainerSize), state.getValue().m1608unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                jM1608unboximpl = selectableChipColors.backgroundColor(z11, z10, composer, ((i13 >> 9) & 14) | ((i13 << 3) & 112) | ((i13 >> 15) & 896)).getValue().m1608unboximpl();
                            } else {
                                modifierClip = companion;
                            }
                            composer.endReplaceableGroup();
                            Alignment center = companion2.getCenter();
                            composer.startReplaceableGroup(733328855);
                            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
                            composer.startReplaceableGroup(-1323940314);
                            Density density3 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            a<ComposeUiNode> constructor3 = companion3.getConstructor();
                            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf3 = LayoutKt.materializerOf(modifierClip);
                            if (!(composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(constructor3);
                            } else {
                                composer.useNode();
                            }
                            composer.disableReusing();
                            Composer composerM1258constructorimpl3 = Updater.m1258constructorimpl(composer);
                            Updater.m1265setimpl(composerM1258constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m1265setimpl(composerM1258constructorimpl3, density3, companion3.getSetDensity());
                            Updater.m1265setimpl(composerM1258constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
                            Updater.m1265setimpl(composerM1258constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
                            composer.enableReusing();
                            qVarMaterializerOf3.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
                            composer.startReplaceableGroup(2058660585);
                            composer.startReplaceableGroup(-2137368960);
                            composer.startReplaceableGroup(-370889391);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1588boximpl(jM1608unboximpl))}, pVar2, composer, ((i13 >> 24) & 112) | 8);
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endNode();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                        }
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        i11 = 6;
                        SpacerKt.Spacer(SizeKt.m445width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer, 6);
                    } else {
                        rowScopeInstance = rowScopeInstance2;
                        i11 = 6;
                    }
                    composer.endReplaceableGroup();
                    qVar.invoke(rowScopeInstance, composer, Integer.valueOf((i12 & 112) | i11));
                    if (pVar3 != null) {
                        SpacerKt.Spacer(SizeKt.m445width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer, i11);
                        pVar3.mo4invoke(composer, Integer.valueOf(i12 & 14));
                        SpacerKt.Spacer(SizeKt.m445width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer, i11);
                    }
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(p<? super Composer, ? super Integer, k0> pVar, boolean z10, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, SelectableChipColors selectableChipColors, boolean z11, int i11, State<Color> state) {
                super(2);
                this.$leadingIcon = pVar;
                this.$selected = z10;
                this.$selectedIcon = pVar2;
                this.$trailingIcon = pVar3;
                this.$content = qVar;
                this.$$dirty1 = i10;
                this.$colors = selectableChipColors;
                this.$enabled = z11;
                this.$$dirty = i11;
                this.$contentColor = state;
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return k0.f35197a;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer, int i10) {
                if ((i10 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                } else {
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.composableLambda(composer, -1543702066, true, new C00891(this.$leadingIcon, this.$selected, this.$selectedIcon, this.$trailingIcon, this.$content, this.$$dirty1, this.$colors, this.$enabled, this.$$dirty, this.$contentColor)), composer, 48);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09193(State<Color> state, p<? super Composer, ? super Integer, k0> pVar, boolean z10, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, SelectableChipColors selectableChipColors, boolean z11, int i11) {
            super(2);
            this.$contentColor = state;
            this.$leadingIcon = pVar;
            this.$selected = z10;
            this.$selectedIcon = pVar2;
            this.$trailingIcon = pVar3;
            this.$content = qVar;
            this.$$dirty1 = i10;
            this.$colors = selectableChipColors;
            this.$enabled = z11;
            this.$$dirty = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1600getAlphaimpl(this.$contentColor.getValue().m1608unboximpl())))}, ComposableLambdaKt.composableLambda(composer, 1582291359, true, new AnonymousClass1(this.$leadingIcon, this.$selected, this.$selectedIcon, this.$trailingIcon, this.$content, this.$$dirty1, this.$colors, this.$enabled, this.$$dirty, this.$contentColor)), composer, 56);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ChipKt$FilterChip$4, reason: invalid class name */
    /* JADX INFO: compiled from: Chip.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ SelectableChipColors $colors;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ a<k0> $onClick;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ p<Composer, Integer, k0> $selectedIcon;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(boolean z10, a<k0> aVar, Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11, int i12) {
            super(2);
            this.$selected = z10;
            this.$onClick = aVar;
            this.$modifier = modifier;
            this.$enabled = z11;
            this.$interactionSource = mutableInteractionSource;
            this.$shape = shape;
            this.$border = borderStroke;
            this.$colors = selectableChipColors;
            this.$leadingIcon = pVar;
            this.$selectedIcon = pVar2;
            this.$trailingIcon = pVar3;
            this.$content = qVar;
            this.$$changed = i10;
            this.$$changed1 = i11;
            this.$$default = i12;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            ChipKt.FilterChip(this.$selected, this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$shape, this.$border, this.$colors, this.$leadingIcon, this.$selectedIcon, this.$trailingIcon, this.$content, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    static {
        float f10 = 8;
        LeadingIconEndSpacing = Dp.m3673constructorimpl(f10);
        TrailingIconSpacing = Dp.m3673constructorimpl(f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Chip(@org.jetbrains.annotations.NotNull h9.a<v8.k0> r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, boolean r35, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r37, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r38, @org.jetbrains.annotations.Nullable androidx.compose.material.ChipColors r39, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r40, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r41, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.Chip(h9.a, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ChipColors, h9.p, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Chip$lambda-1, reason: not valid java name */
    public static final long m939Chip$lambda1(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FilterChip(boolean r44, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r45, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r46, boolean r47, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r48, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r49, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r50, @org.jetbrains.annotations.Nullable androidx.compose.material.SelectableChipColors r51, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r52, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r53, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r54, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r55, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r56, int r57, int r58, int r59) {
        /*
            Method dump skipped, instruction units count: 874
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.FilterChip(boolean, h9.a, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.SelectableChipColors, h9.p, h9.p, h9.p, h9.q, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
