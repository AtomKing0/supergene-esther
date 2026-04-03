package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonKt {

    /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$2, reason: invalid class name */
    /* JADX INFO: compiled from: Button.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
        final /* synthetic */ State<Color> $contentColor$delegate;
        final /* synthetic */ PaddingValues $contentPadding;

        /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Button.kt */
        static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
            final /* synthetic */ PaddingValues $contentPadding;

            /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Button.kt */
            static final class C00871 extends v implements p<Composer, Integer, k0> {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
                final /* synthetic */ PaddingValues $contentPadding;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00871(PaddingValues paddingValues, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10) {
                    super(2);
                    this.$contentPadding = paddingValues;
                    this.$content = qVar;
                    this.$$dirty = i10;
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
                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.m424defaultMinSizeVpY3zN4(companion, buttonDefaults.m907getMinWidthD9Ej5fM(), buttonDefaults.m906getMinHeightD9Ej5fM()), this.$contentPadding);
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    q<RowScope, Composer, Integer, k0> qVar = this.$content;
                    int i11 = ((this.$$dirty >> 18) & 7168) | 432;
                    composer.startReplaceableGroup(693286680);
                    int i12 = i11 >> 3;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, (i12 & 112) | (i12 & 14));
                    composer.startReplaceableGroup(-1323940314);
                    Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    a<ComposeUiNode> constructor = companion2.getConstructor();
                    q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierPadding);
                    int i13 = ((((i11 << 3) & 112) << 9) & 7168) | 6;
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
                    qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i13 >> 3) & 112));
                    composer.startReplaceableGroup(2058660585);
                    composer.startReplaceableGroup(-678309503);
                    if (((i13 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                    } else {
                        qVar.invoke(RowScopeInstance.INSTANCE, composer, Integer.valueOf(((i11 >> 6) & 112) | 6));
                    }
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(PaddingValues paddingValues, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10) {
                super(2);
                this.$contentPadding = paddingValues;
                this.$content = qVar;
                this.$$dirty = i10;
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
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), ComposableLambdaKt.composableLambda(composer, -630330208, true, new C00871(this.$contentPadding, this.$content, this.$$dirty)), composer, 48);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(State<Color> state, PaddingValues paddingValues, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10) {
            super(2);
            this.$contentColor$delegate = state;
            this.$contentPadding = paddingValues;
            this.$content = qVar;
            this.$$dirty = i10;
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
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1600getAlphaimpl(ButtonKt.m911Button$lambda1(this.$contentColor$delegate))))}, ComposableLambdaKt.composableLambda(composer, -1699085201, true, new AnonymousClass1(this.$contentPadding, this.$content, this.$$dirty)), composer, 56);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ButtonKt$Button$3, reason: invalid class name */
    /* JADX INFO: compiled from: Button.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ BorderStroke $border;
        final /* synthetic */ ButtonColors $colors;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ ButtonElevation $elevation;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ a<k0> $onClick;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(a<k0> aVar, Modifier modifier, boolean z10, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$onClick = aVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$interactionSource = mutableInteractionSource;
            this.$elevation = buttonElevation;
            this.$shape = shape;
            this.$border = borderStroke;
            this.$colors = buttonColors;
            this.$contentPadding = paddingValues;
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
            ButtonKt.Button(this.$onClick, this.$modifier, this.$enabled, this.$interactionSource, this.$elevation, this.$shape, this.$border, this.$colors, this.$contentPadding, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Button(@org.jetbrains.annotations.NotNull h9.a<v8.k0> r38, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r39, boolean r40, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r41, @org.jetbrains.annotations.Nullable androidx.compose.material.ButtonElevation r42, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r43, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r44, @org.jetbrains.annotations.Nullable androidx.compose.material.ButtonColors r45, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r46, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r47, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            Method dump skipped, instruction units count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ButtonKt.Button(h9.a, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.ButtonElevation, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ButtonColors, androidx.compose.foundation.layout.PaddingValues, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Button$lambda-1, reason: not valid java name */
    public static final long m911Button$lambda1(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OutlinedButton(@NotNull a<k0> onClick, @Nullable Modifier modifier, boolean z10, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable ButtonElevation buttonElevation, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable ButtonColors buttonColors, @Nullable PaddingValues paddingValues, @NotNull q<? super RowScope, ? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        MutableInteractionSource mutableInteractionSource2;
        t.i(onClick, "onClick");
        t.i(content, "content");
        composer.startReplaceableGroup(-1776134358);
        Modifier modifier2 = (i11 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z11 = (i11 & 4) != 0 ? true : z10;
        if ((i11 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        Button(onClick, modifier2, z11, mutableInteractionSource2, (i11 & 16) != 0 ? null : buttonElevation, (i11 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape, (i11 & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder(composer, 6) : borderStroke, (i11 & 128) != 0 ? ButtonDefaults.INSTANCE.m909outlinedButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors, (i11 & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues, content, composer, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (1879048192 & i10), 0);
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TextButton(@NotNull a<k0> onClick, @Nullable Modifier modifier, boolean z10, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable ButtonElevation buttonElevation, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable ButtonColors buttonColors, @Nullable PaddingValues paddingValues, @NotNull q<? super RowScope, ? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        MutableInteractionSource mutableInteractionSource2;
        t.i(onClick, "onClick");
        t.i(content, "content");
        composer.startReplaceableGroup(288797557);
        Modifier modifier2 = (i11 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z11 = (i11 & 4) != 0 ? true : z10;
        if ((i11 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        Button(onClick, modifier2, z11, mutableInteractionSource2, (i11 & 16) != 0 ? null : buttonElevation, (i11 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape, (i11 & 64) != 0 ? null : borderStroke, (i11 & 128) != 0 ? ButtonDefaults.INSTANCE.m910textButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors, (i11 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues, content, composer, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (1879048192 & i10), 0);
        composer.endReplaceableGroup();
    }
}
