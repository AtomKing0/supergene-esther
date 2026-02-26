package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    public static final class a extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Painter f19912g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19913h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Modifier f19914i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f19915j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f19916k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f19917l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f19918m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f19919n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Shape f19920o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ long f19921p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ int f19922q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ int f19923r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Painter painter, h9.a<k0> aVar, Modifier modifier, boolean z10, String str, long j10, long j11, long j12, Shape shape, long j13, int i10, int i11) {
            super(2);
            this.f19912g = painter;
            this.f19913h = aVar;
            this.f19914i = modifier;
            this.f19915j = z10;
            this.f19916k = str;
            this.f19917l = j10;
            this.f19918m = j11;
            this.f19919n = j12;
            this.f19920o = shape;
            this.f19921p = j13;
            this.f19922q = i10;
            this.f19923r = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            p.a(this.f19912g, this.f19913h, this.f19914i, this.f19915j, this.f19916k, this.f19917l, this.f19918m, this.f19919n, this.f19920o, this.f19921p, composer, this.f19922q | 1, this.f19923r);
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
    public static final void a(@NotNull Painter painter, @NotNull h9.a<k0> onClick, @Nullable Modifier modifier, boolean z10, @Nullable String str, long j10, long j11, long j12, @Nullable Shape shape, long j13, @Nullable Composer composer, int i10, int i11) {
        long jM951getPrimary0d7_KjU;
        int i12;
        long j14;
        kotlin.jvm.internal.t.i(painter, "painter");
        kotlin.jvm.internal.t.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2002285559);
        Modifier modifier2 = (i11 & 4) != 0 ? Modifier.Companion : modifier;
        boolean z11 = (i11 & 8) != 0 ? true : z10;
        String str2 = (i11 & 16) != 0 ? null : str;
        if ((i11 & 32) != 0) {
            jM951getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m951getPrimary0d7_KjU();
            i12 = i10 & (-458753);
        } else {
            jM951getPrimary0d7_KjU = j10;
            i12 = i10;
        }
        long jB = (i11 & 64) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b() : j11;
        if ((i11 & 128) != 0) {
            i12 &= -29360129;
            j14 = jB;
        } else {
            j14 = j12;
        }
        Shape shapeE = (i11 & 256) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.e() : shape;
        long jD = (i11 & 512) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d() : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2002285559, i12, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.GenericIconButton (GenericIconButton.kt:34)");
        }
        Modifier modifierM166backgroundbw27NRU$default = BackgroundKt.m166backgroundbw27NRU$default(ClipKt.clip(SizeKt.m441size6HolHcs(modifier2, jB), shapeE), jD, null, 2, null);
        Indication indicationM1237rememberRipple9IZ8Weo = RippleKt.m1237rememberRipple9IZ8Weo(true, 0.0f, 0L, composerStartRestartGroup, 6, 6);
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        Modifier modifierM182clickableO2vRcR0 = ClickableKt.m182clickableO2vRcR0(modifierM166backgroundbw27NRU$default, (MutableInteractionSource) objRememberedValue, indicationM1237rememberRipple9IZ8Weo, z11, str2, Role.m3227boximpl(Role.Companion.m3234getButtono7Vup1c()), onClick);
        Alignment center = Alignment.Companion.getCenter();
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        Shape shape2 = shapeE;
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        long j15 = jB;
        h9.a<ComposeUiNode> constructor = companion.getConstructor();
        h9.q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM182clickableO2vRcR0);
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        IconKt.m1048Iconww6aTOc(painter, str2, SizeKt.m441size6HolHcs(Modifier.Companion, j14), jM951getPrimary0d7_KjU, composerStartRestartGroup, ((i12 >> 9) & 112) | 8 | ((i12 >> 6) & 7168), 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new a(painter, onClick, modifier2, z11, str2, jM951getPrimary0d7_KjU, j15, j14, shape2, jD, i10, i11));
    }
}
