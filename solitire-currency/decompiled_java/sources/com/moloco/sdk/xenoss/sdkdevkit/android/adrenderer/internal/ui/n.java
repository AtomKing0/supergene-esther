package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.android.gms.drive.DriveFile;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f19902a = ColorKt.Color$default(71, 118, 238, 0, 8, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f19903b = Color.Companion.m1635getWhite0d7_KjU();

    public static final class a extends v implements h9.q<RowScope, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f19904g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(3);
            this.f19904g = str;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull RowScope Button, @Nullable Composer composer, int i10) {
            kotlin.jvm.internal.t.i(Button, "$this$Button");
            if ((i10 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1091822665, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.DEC.<anonymous>.<anonymous> (DEC.kt:72)");
            }
            String str = this.f19904g;
            if (str == null) {
                str = "";
            }
            TextKt.m1218TextfLXpl1I(str, null, n.f19903b, 0L, null, FontWeight.Companion.getBold(), null, 0L, null, null, 0L, TextOverflow.Companion.m3627getEllipsisgIe3tQ8(), false, 1, null, null, composer, 196992, 3120, 55258);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(RowScope rowScope, Composer composer, Integer num) {
            a(rowScope, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class b extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Modifier f19905g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f19906h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f19907i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f19908j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19909k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f19910l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f19911m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Modifier modifier, String str, String str2, String str3, h9.a<k0> aVar, int i10, int i11) {
            super(2);
            this.f19905g = modifier;
            this.f19906h = str;
            this.f19907i = str2;
            this.f19908j = str3;
            this.f19909k = aVar;
            this.f19910l = i10;
            this.f19911m = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            n.b(this.f19905g, this.f19906h, this.f19907i, this.f19908j, this.f19909k, composer, this.f19910l | 1, this.f19911m);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void b(@Nullable Modifier modifier, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull h9.a<k0> onClick, @Nullable Composer composer, int i10, int i11) {
        Modifier modifier2;
        int i12;
        Modifier.Companion companion;
        int i13;
        Composer composer2;
        Composer composer3;
        Modifier modifier3;
        kotlin.jvm.internal.t.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(267258467);
        int i14 = i11 & 1;
        if (i14 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 14) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i10 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i11 & 4) != 0) {
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & 896) == 0) {
            i12 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i11 & 8) != 0) {
            i12 |= 3072;
        } else if ((i10 & 7168) == 0) {
            i12 |= composerStartRestartGroup.changed(str3) ? 2048 : 1024;
        }
        if ((i11 & 16) != 0) {
            i12 |= 24576;
        } else if ((57344 & i10) == 0) {
            i12 |= composerStartRestartGroup.changed(onClick) ? 16384 : 8192;
        }
        int i15 = i12;
        if ((46811 & i15) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer3 = composerStartRestartGroup;
        } else {
            Modifier modifier4 = i14 != 0 ? Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(267258467, i15, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.DEC (DEC.kt:30)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
            Color.Companion companion2 = Color.Companion;
            Modifier modifierM185clickableXHw0xAI$default = ClickableKt.m185clickableXHw0xAI$default(BackgroundKt.m166backgroundbw27NRU$default(modifierFillMaxSize$default, companion2.m1624getBlack0d7_KjU(), null, 2, null), false, null, null, onClick, 7, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            h9.a<ComposeUiNode> constructor = companion3.getConstructor();
            h9.q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM185clickableXHw0xAI$default);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion4 = Modifier.Companion;
            Modifier modifier5 = modifier4;
            l.i.a(str, null, SizeKt.m440size3ABfNKs(companion4, Dp.m3673constructorimpl(128)), null, null, null, null, 0.0f, null, 0, composerStartRestartGroup, ((i15 >> 3) & 14) | 432, 1016);
            composerStartRestartGroup.startReplaceableGroup(-992665453);
            if (str2 != null) {
                SpacerKt.Spacer(SizeKt.m426height3ABfNKs(companion4, Dp.m3673constructorimpl(12)), composerStartRestartGroup, 6);
                companion = companion4;
                i13 = i15;
                composer2 = composerStartRestartGroup;
                TextKt.m1218TextfLXpl1I(str2, null, companion2.m1635getWhite0d7_KjU(), 0L, null, FontWeight.Companion.getBold(), null, 0L, null, null, 0L, TextOverflow.Companion.m3627getEllipsisgIe3tQ8(), false, 2, null, null, composer2, ((i15 >> 6) & 14) | 196992, 3120, 55258);
            } else {
                companion = companion4;
                i13 = i15;
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            composer3 = composer2;
            SpacerKt.Spacer(SizeKt.m426height3ABfNKs(companion, Dp.m3673constructorimpl(8)), composer3, 6);
            ButtonKt.Button(onClick, null, false, null, null, RoundedCornerShapeKt.getCircleShape(), null, ButtonDefaults.INSTANCE.m901buttonColorsro_MJ88(f19902a, f19903b, 0L, 0L, composer3, (ButtonDefaults.$stable << 12) | 54, 12), null, ComposableLambdaKt.composableLambda(composer3, 1091822665, true, new a(str3)), composer3, ((i13 >> 12) & 14) | DriveFile.MODE_READ_WRITE, 350);
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            composer3.endNode();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(modifier3, str, str2, str3, onClick, i10, i11));
    }
}
