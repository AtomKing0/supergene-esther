package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.annotation.SuppressLint;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$a, reason: collision with other inner class name */
    public static final class C0396a extends v implements h9.l<SemanticsPropertyReceiver, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f19763g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0396a(String str) {
            super(1);
            this.f19763g = str;
        }

        public final void a(@NotNull SemanticsPropertyReceiver semantics) {
            kotlin.jvm.internal.t.i(semantics, "$this$semantics");
            String str = this.f19763g;
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return k0.f35197a;
        }
    }

    public static final class b extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h9.l<String, k0> f19764g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f19765h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(h9.l<? super String, k0> lVar, String str) {
            super(0);
            this.f19764g = lVar;
            this.f19765h = str;
        }

        public final void b() {
            this.f19764g.invoke(this.f19765h);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }
    }

    public static final class c extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Modifier f19766g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f19767h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.l<String, k0> f19768i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f19769j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f19770k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Modifier modifier, String str, h9.l<? super String, k0> lVar, int i10, int i11) {
            super(2);
            this.f19766g = modifier;
            this.f19767h = str;
            this.f19768i = lVar;
            this.f19769j = i10;
            this.f19770k = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            a.a(this.f19766g, this.f19767h, this.f19768i, composer, this.f19769j | 1, this.f19770k);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class d extends v implements h9.l<String, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ z f19771g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f19772h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(z zVar, String str) {
            super(1);
            this.f19771g = zVar;
            this.f19772h = str;
        }

        public final void a(@NotNull String it) {
            kotlin.jvm.internal.t.i(it, "it");
            this.f19771g.a(this.f19772h);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(String str) {
            a(str);
            return k0.f35197a;
        }
    }

    public static final class e extends v implements h9.s<BoxScope, h9.l<? super a.AbstractC0481a.c, ? extends k0>, m0<? extends i.a>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Modifier f19773g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f19774h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.l<String, k0> f19775i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f19776j;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$e$a, reason: collision with other inner class name */
        public static final class C0397a extends v implements h9.q<Modifier, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Modifier f19777g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ String f19778h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ h9.l<String, k0> f19779i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ int f19780j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0397a(Modifier modifier, String str, h9.l<? super String, k0> lVar, int i10) {
                super(3);
                this.f19777g = modifier;
                this.f19778h = str;
                this.f19779i = lVar;
                this.f19780j = i10;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull Modifier trackableModifier, @Nullable Composer composer, int i10) {
                int i11;
                kotlin.jvm.internal.t.i(trackableModifier, "trackableModifier");
                if ((i10 & 14) == 0) {
                    i11 = (composer.changed(trackableModifier) ? 4 : 2) | i10;
                } else {
                    i11 = i10;
                }
                if ((i11 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1432640859, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous>.<anonymous>.<anonymous> (AdBadge.kt:88)");
                }
                Modifier modifierThen = this.f19777g.then(trackableModifier);
                String str = this.f19778h;
                h9.l<String, k0> lVar = this.f19779i;
                int i12 = this.f19780j;
                a.a(modifierThen, str, lVar, composer, (i12 & 112) | ((i12 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return k0.f35197a;
            }
        }

        public static final class b extends v implements h9.q<Modifier, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Modifier f19781g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ String f19782h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ h9.l<String, k0> f19783i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ int f19784j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(Modifier modifier, String str, h9.l<? super String, k0> lVar, int i10) {
                super(3);
                this.f19781g = modifier;
                this.f19782h = str;
                this.f19783i = lVar;
                this.f19784j = i10;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull Modifier trackableModifier, @Nullable Composer composer, int i10) {
                int i11;
                kotlin.jvm.internal.t.i(trackableModifier, "trackableModifier");
                if ((i10 & 14) == 0) {
                    i11 = (composer.changed(trackableModifier) ? 4 : 2) | i10;
                } else {
                    i11 = i10;
                }
                if ((i11 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-159323954, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous>.<anonymous>.<anonymous> (AdBadge.kt:100)");
                }
                Modifier modifierThen = this.f19781g.then(trackableModifier);
                String str = this.f19782h;
                h9.l<String, k0> lVar = this.f19783i;
                int i12 = this.f19784j;
                a.a(modifierThen, str, lVar, composer, (i12 & 112) | ((i12 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(Modifier modifier, String str, h9.l<? super String, k0> lVar, int i10) {
            super(5);
            this.f19773g = modifier;
            this.f19774h = str;
            this.f19775i = lVar;
            this.f19776j = i10;
        }

        public static final i.a a(State<? extends i.a> state) {
            return state.getValue();
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void b(@NotNull BoxScope boxScope, @NotNull h9.l<? super a.AbstractC0481a.c, k0> onButtonRendered, @Nullable m0<? extends i.a> m0Var, @Nullable Composer composer, int i10) {
            kotlin.jvm.internal.t.i(boxScope, "$this$null");
            kotlin.jvm.internal.t.i(onButtonRendered, "onButtonRendered");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1620589869, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous> (AdBadge.kt:80)");
            }
            if (m0Var != null) {
                Modifier modifier = this.f19773g;
                String str = this.f19774h;
                h9.l<String, k0> lVar = this.f19775i;
                int i11 = this.f19776j;
                i.a aVarA = a(SnapshotStateKt.collectAsState(m0Var, null, composer, 8, 1));
                if (aVarA instanceof i.a.c) {
                    composer.startReplaceableGroup(-1855563398);
                    t.c(null, a.AbstractC0481a.c.EnumC0483a.AD_BADGE, onButtonRendered, ComposableLambdaKt.composableLambda(composer, -1432640859, true, new C0397a(modifier, str, lVar, i11)), composer, ((i10 << 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof i.a.C0434a) {
                    composer.startReplaceableGroup(-1855562947);
                    t.c(null, a.AbstractC0481a.c.EnumC0483a.AD_BADGE, onButtonRendered, ComposableLambdaKt.composableLambda(composer, -159323954, true, new b(modifier, str, lVar, i11)), composer, ((i10 << 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof i.a.b) {
                    composer.startReplaceableGroup(-1855562502);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof i.a.d) {
                    composer.startReplaceableGroup(-1855562444);
                    composer.endReplaceableGroup();
                } else if (aVarA == null) {
                    composer.startReplaceableGroup(-1855562409);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(-1855562385);
                    composer.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.s
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, h9.l<? super a.AbstractC0481a.c, ? extends k0> lVar, m0<? extends i.a> m0Var, Composer composer, Integer num) {
            b(boxScope, lVar, m0Var, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class f extends v implements h9.l<String, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ z f19785g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f19786h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(z zVar, String str) {
            super(1);
            this.f19785g = zVar;
            this.f19786h = str;
        }

        public final void a(@NotNull String it) {
            kotlin.jvm.internal.t.i(it, "it");
            this.f19785g.a(this.f19786h);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(String str) {
            a(str);
            return k0.f35197a;
        }
    }

    public static final class g extends v implements h9.r<BoxScope, h9.l<? super a.AbstractC0481a.c, ? extends k0>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Modifier f19787g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f19788h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.l<String, k0> f19789i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f19790j;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$g$a, reason: collision with other inner class name */
        public static final class C0398a extends v implements h9.q<Modifier, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Modifier f19791g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ String f19792h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ h9.l<String, k0> f19793i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ int f19794j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0398a(Modifier modifier, String str, h9.l<? super String, k0> lVar, int i10) {
                super(3);
                this.f19791g = modifier;
                this.f19792h = str;
                this.f19793i = lVar;
                this.f19794j = i10;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull Modifier trackableModifier, @Nullable Composer composer, int i10) {
                int i11;
                kotlin.jvm.internal.t.i(trackableModifier, "trackableModifier");
                if ((i10 & 14) == 0) {
                    i11 = (composer.changed(trackableModifier) ? 4 : 2) | i10;
                } else {
                    i11 = i10;
                }
                if ((i11 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2083907100, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge.<anonymous>.<anonymous> (AdBadge.kt:135)");
                }
                Modifier modifierThen = this.f19791g.then(trackableModifier);
                String str = this.f19792h;
                h9.l<String, k0> lVar = this.f19793i;
                int i12 = this.f19794j;
                a.a(modifierThen, str, lVar, composer, (i12 & 112) | ((i12 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(Modifier modifier, String str, h9.l<? super String, k0> lVar, int i10) {
            super(4);
            this.f19787g = modifier;
            this.f19788h = str;
            this.f19789i = lVar;
            this.f19790j = i10;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull BoxScope boxScope, @NotNull h9.l<? super a.AbstractC0481a.c, k0> onButtonRendered, @Nullable Composer composer, int i10) {
            kotlin.jvm.internal.t.i(boxScope, "$this$null");
            kotlin.jvm.internal.t.i(onButtonRendered, "onButtonRendered");
            if ((i10 & 112) == 0) {
                i10 |= composer.changed(onButtonRendered) ? 32 : 16;
            }
            if ((i10 & 721) == 144 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1426546556, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge.<anonymous> (AdBadge.kt:131)");
            }
            t.c(null, a.AbstractC0481a.c.EnumC0483a.AD_BADGE, onButtonRendered, ComposableLambdaKt.composableLambda(composer, 2083907100, true, new C0398a(this.f19787g, this.f19788h, this.f19789i, this.f19790j)), composer, ((i10 << 3) & 896) | 3120, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, h9.l<? super a.AbstractC0481a.c, ? extends k0> lVar, Composer composer, Integer num) {
            a(boxScope, lVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void a(@Nullable Modifier modifier, @NotNull String clickUrl, @NotNull h9.l<? super String, k0> onClick, @Nullable Composer composer, int i10, int i11) {
        Modifier modifier2;
        int i12;
        Modifier modifier3;
        kotlin.jvm.internal.t.i(clickUrl, "clickUrl");
        kotlin.jvm.internal.t.i(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1037954372);
        int i13 = i11 & 1;
        if (i13 != 0) {
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
            i12 |= composerStartRestartGroup.changed(clickUrl) ? 32 : 16;
        }
        if ((i11 & 4) != 0) {
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & 896) == 0) {
            i12 |= composerStartRestartGroup.changed(onClick) ? 256 : 128;
        }
        if ((i12 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i13 != 0 ? Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037954372, i12, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdBadge (AdBadge.kt:41)");
            }
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed("Ad Badge");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new C0396a("Ad Badge");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM432requiredSize3ABfNKs = SizeKt.m432requiredSize3ABfNKs(SemanticsModifierKt.semantics$default(modifier3, false, (h9.l) objRememberedValue, 1, null), Dp.m3673constructorimpl(12));
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged2 = composerStartRestartGroup.changed(onClick) | composerStartRestartGroup.changed(clickUrl);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new b(onClick, clickUrl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            IconKt.m1048Iconww6aTOc(PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18857e, composerStartRestartGroup, 0), "Ad Badge", ClickableKt.m185clickableXHw0xAI$default(modifierM432requiredSize3ABfNKs, false, null, null, (h9.a) objRememberedValue2, 7, null), Color.Companion.m1634getUnspecified0d7_KjU(), composerStartRestartGroup, 3128, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new c(modifier3, clickUrl, onClick, i10, i11));
    }

    @Composable
    @SuppressLint({"ComposableNaming"})
    @NotNull
    public static final h9.s<BoxScope, h9.l<? super a.AbstractC0481a.c, k0>, m0<? extends i.a>, Composer, Integer, k0> b(@Nullable Modifier modifier, @Nullable String str, @Nullable z zVar, @Nullable h9.l<? super String, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-751111043);
        if ((i11 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i11 & 2) != 0) {
            str = "https://cdn-f.adsmoloco.com/moloco-cdn/privacy.html";
        }
        if ((i11 & 4) != 0) {
            zVar = a.h.f18920a.d();
        }
        if ((i11 & 8) != 0) {
            lVar = new d(zVar, str);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-751111043, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge (AdBadge.kt:74)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1620589869, true, new e(modifier, str, lVar, i10));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    @Composable
    @SuppressLint({"ComposableNaming"})
    @NotNull
    public static final h9.r<BoxScope, h9.l<? super a.AbstractC0481a.c, k0>, Composer, Integer, k0> c(@Nullable Modifier modifier, @Nullable String str, @Nullable z zVar, @Nullable h9.l<? super String, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(210063909);
        if ((i11 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i11 & 2) != 0) {
            str = "https://cdn-f.adsmoloco.com/moloco-cdn/privacy.html";
        }
        if ((i11 & 4) != 0) {
            zVar = a.h.f18920a.d();
        }
        if ((i11 & 8) != 0) {
            lVar = new f(zVar, str);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(210063909, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge (AdBadge.kt:125)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1426546556, true, new g(modifier, str, lVar, i10));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }
}
