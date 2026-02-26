package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import android.content.Context;
import android.view.View;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.q;
import h9.s;
import h9.t;
import h9.u;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.c0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    public static final class a extends v implements q<i.a, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f f21009g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> f21010h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> f21011i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> f21012j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0> f21013k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t f21014l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f21015m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f21016n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ int f21017o;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0451a extends kotlin.jvm.internal.q implements h9.a<k0> {
            public C0451a(Object obj) {
                super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onReplay", "onReplay()V", 0);
            }

            public final void c() {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).A();
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                c();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar, u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, ? super h9.l<? super Boolean, k0>, ? super Composer, ? super Integer, k0> uVar, s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, k0> sVar, t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> tVar, u<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super Boolean, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> uVar2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, int i10, int i11) {
            super(3);
            this.f21009g = fVar;
            this.f21010h = uVar;
            this.f21011i = sVar;
            this.f21012j = tVar;
            this.f21013k = uVar2;
            this.f21014l = tVar2;
            this.f21015m = iVar;
            this.f21016n = i10;
            this.f21017o = i11;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@Nullable i.a aVar, @Nullable Composer composer, int i10) {
            int i11;
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(aVar) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i11 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1768186749, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastRenderer.<anonymous>.<anonymous> (VastRenderer.kt:88)");
            }
            if (aVar instanceof i.a.C0434a) {
                composer.startReplaceableGroup(1861252962);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h hVarB = ((i.a.C0434a) aVar).b();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar = this.f21009g;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.a.b(hVarB, fVar != null ? fVar.a() : null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.c) {
                composer.startReplaceableGroup(1861253196);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVarB = ((i.a.c) aVar).b();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar2 = this.f21009g;
                h9.a<k0> aVarC = fVar2 != null ? fVar2.c() : null;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> uVar = this.f21010h;
                s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> sVar = this.f21011i;
                t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> tVar = this.f21012j;
                u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0> uVar2 = this.f21013k;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar2 = this.f21014l;
                C0451a c0451a = new C0451a(this.f21015m);
                int i12 = this.f21016n;
                int i13 = (i12 & 7168) | RendererCapabilities.DECODER_SUPPORT_MASK;
                int i14 = i12 >> 12;
                int i15 = this.f21017o << 18;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.e.f(kVarB, aVarC, modifierFillMaxSize$default, uVar, sVar, tVar, uVar2, tVar2, c0451a, composer, (i14 & 458752) | i13 | (57344 & i14) | (3670016 & i15) | (i15 & 29360128), 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.b) {
                composer.startReplaceableGroup(1861253656);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e eVarB = ((i.a.b) aVar).b();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar3 = this.f21009g;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.c.b(eVarB, fVar3 != null ? fVar3.b() : null, this.f21012j, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), composer, ((this.f21016n >> 21) & 896) | 3072, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.d) {
                composer.startReplaceableGroup(1861253940);
                composer.endReplaceableGroup();
            } else if (aVar == null) {
                composer.startReplaceableGroup(1861253979);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1861253995);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(i.a aVar, Composer composer, Integer num) {
            a(aVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.l<a.AbstractC0481a.c, k0> {
        public b(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
        }

        public final void a(@NotNull a.AbstractC0481a.c p02) {
            kotlin.jvm.internal.t.i(p02, "p0");
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).g(p02);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(a.AbstractC0481a.c cVar) {
            a(cVar);
            return k0.f35197a;
        }
    }

    public /* synthetic */ class c extends kotlin.jvm.internal.q implements h9.a<k0> {
        public c(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onCTA", "onCTA()V", 0);
        }

        public final void c() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).B();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            c();
            return k0.f35197a;
        }
    }

    public /* synthetic */ class d extends kotlin.jvm.internal.q implements h9.l<a.AbstractC0481a.c, k0> {
        public d(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
        }

        public final void a(@NotNull a.AbstractC0481a.c p02) {
            kotlin.jvm.internal.t.i(p02, "p0");
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).g(p02);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(a.AbstractC0481a.c cVar) {
            a(cVar);
            return k0.f35197a;
        }
    }

    public static final class e extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f21018g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Modifier f21019h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f21020i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> f21021j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f21022k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f21023l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0> f21024m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f f21025n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> f21026o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> f21027p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0> f21028q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t f21029r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ int f21030s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ int f21031t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ int f21032u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, Modifier modifier, long j10, u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, ? super h9.l<? super Boolean, k0>, ? super Composer, ? super Integer, k0> uVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar2, u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> uVar2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar, s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, k0> sVar, t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> tVar, u<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super Boolean, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> uVar3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar2, int i10, int i11, int i12) {
            super(2);
            this.f21018g = iVar;
            this.f21019h = modifier;
            this.f21020i = j10;
            this.f21021j = uVar;
            this.f21022k = bVar;
            this.f21023l = bVar2;
            this.f21024m = uVar2;
            this.f21025n = fVar;
            this.f21026o = sVar;
            this.f21027p = tVar;
            this.f21028q = uVar3;
            this.f21029r = tVar2;
            this.f21030s = i10;
            this.f21031t = i11;
            this.f21032u = i12;
        }

        public final void a(@Nullable Composer composer, int i10) {
            k.g(this.f21018g, this.f21019h, this.f21020i, this.f21021j, this.f21022k, this.f21023l, this.f21024m, this.f21025n, this.f21026o, this.f21027p, this.f21028q, this.f21029r, composer, this.f21030s | 1, this.f21031t, this.f21032u);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class f extends v implements u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, ? extends k0>, h9.a<? extends k0>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Alignment f21033g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ PaddingValues f21034h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f21035i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f21036j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ long f21037k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21038l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f21039m;

        public static final class a extends v implements q<AnimatedVisibilityScope, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ h9.l<a.AbstractC0481a.c, k0> f21040g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f21041h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ State<i.a> f21042i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ String f21043j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ String f21044k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ long f21045l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f21046m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f21047n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ int f21048o;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k$f$a$a, reason: collision with other inner class name */
            public static final class C0452a extends v implements q<Modifier, Composer, Integer, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ String f21049g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ String f21050h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ long f21051i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f21052j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f21053k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ int f21054l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ int f21055m;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k$f$a$a$a, reason: collision with other inner class name */
                public static final class C0453a extends v implements h9.a<k0> {

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    public final /* synthetic */ h9.a<k0> f21056g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    public final /* synthetic */ h9.a<k0> f21057h;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0453a(h9.a<k0> aVar, h9.a<k0> aVar2) {
                        super(0);
                        this.f21056g = aVar;
                        this.f21057h = aVar2;
                    }

                    public final void b() {
                        this.f21056g.invoke();
                        h9.a<k0> aVar = this.f21057h;
                        if (aVar != null) {
                            aVar.invoke();
                        }
                    }

                    @Override // h9.a
                    public /* bridge */ /* synthetic */ k0 invoke() {
                        b();
                        return k0.f35197a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0452a(String str, String str2, long j10, h9.a<k0> aVar, h9.a<k0> aVar2, int i10, int i11) {
                    super(3);
                    this.f21049g = str;
                    this.f21050h = str2;
                    this.f21051i = j10;
                    this.f21052j = aVar;
                    this.f21053k = aVar2;
                    this.f21054l = i10;
                    this.f21055m = i11;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void a(@NotNull Modifier it, @Nullable Composer composer, int i10) {
                    kotlin.jvm.internal.t.i(it, "it");
                    if ((i10 & 14) == 0) {
                        i10 |= composer.changed(it) ? 4 : 2;
                    }
                    if ((i10 & 91) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(668786503, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:321)");
                    }
                    String str = this.f21049g;
                    String str2 = this.f21050h;
                    long j10 = this.f21051i;
                    h9.a<k0> aVar = this.f21052j;
                    h9.a<k0> aVar2 = this.f21053k;
                    composer.startReplaceableGroup(511388516);
                    boolean zChanged = composer.changed(aVar) | composer.changed(aVar2);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new C0453a(aVar, aVar2);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    int i11 = this.f21055m;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.b(it, str, str2, j10, (h9.a) objRememberedValue, composer, (i10 & 14) | ((i11 >> 9) & 112) | ((i11 >> 3) & 896) | ((i11 << 3) & 7168), 0);
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

            public static final class b extends v implements q<Modifier, Composer, Integer, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ String f21058g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ String f21059h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ long f21060i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f21061j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f21062k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ int f21063l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ int f21064m;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k$f$a$b$a, reason: collision with other inner class name */
                public static final class C0454a extends v implements h9.a<k0> {

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    public final /* synthetic */ h9.a<k0> f21065g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    public final /* synthetic */ h9.a<k0> f21066h;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0454a(h9.a<k0> aVar, h9.a<k0> aVar2) {
                        super(0);
                        this.f21065g = aVar;
                        this.f21066h = aVar2;
                    }

                    public final void b() {
                        this.f21065g.invoke();
                        h9.a<k0> aVar = this.f21066h;
                        if (aVar != null) {
                            aVar.invoke();
                        }
                    }

                    @Override // h9.a
                    public /* bridge */ /* synthetic */ k0 invoke() {
                        b();
                        return k0.f35197a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(String str, String str2, long j10, h9.a<k0> aVar, h9.a<k0> aVar2, int i10, int i11) {
                    super(3);
                    this.f21058g = str;
                    this.f21059h = str2;
                    this.f21060i = j10;
                    this.f21061j = aVar;
                    this.f21062k = aVar2;
                    this.f21063l = i10;
                    this.f21064m = i11;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void a(@NotNull Modifier it, @Nullable Composer composer, int i10) {
                    kotlin.jvm.internal.t.i(it, "it");
                    if ((i10 & 14) == 0) {
                        i10 |= composer.changed(it) ? 4 : 2;
                    }
                    if ((i10 & 91) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2141882576, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:338)");
                    }
                    String str = this.f21058g;
                    String str2 = this.f21059h;
                    long j10 = this.f21060i;
                    h9.a<k0> aVar = this.f21061j;
                    h9.a<k0> aVar2 = this.f21062k;
                    composer.startReplaceableGroup(511388516);
                    boolean zChanged = composer.changed(aVar) | composer.changed(aVar2);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new C0454a(aVar, aVar2);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    int i11 = this.f21064m;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.b(it, str, str2, j10, (h9.a) objRememberedValue, composer, (i10 & 14) | ((i11 >> 9) & 112) | ((i11 >> 3) & 896) | ((i11 << 3) & 7168), 0);
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
            public a(h9.l<? super a.AbstractC0481a.c, k0> lVar, int i10, State<? extends i.a> state, String str, String str2, long j10, h9.a<k0> aVar, h9.a<k0> aVar2, int i11) {
                super(3);
                this.f21040g = lVar;
                this.f21041h = i10;
                this.f21042i = state;
                this.f21043j = str;
                this.f21044k = str2;
                this.f21045l = j10;
                this.f21046m = aVar;
                this.f21047n = aVar2;
                this.f21048o = i11;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer, int i10) {
                kotlin.jvm.internal.t.i(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1639156335, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous> (VastRenderer.kt:305)");
                }
                i.a aVarC = f.c(this.f21042i);
                if (aVarC instanceof i.a.C0434a) {
                    composer.startReplaceableGroup(-1987572557);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t.c(null, a.AbstractC0481a.c.EnumC0483a.CTA, this.f21040g, ComposableLambdaKt.composableLambda(composer, 668786503, true, new C0452a(this.f21043j, this.f21044k, this.f21045l, this.f21046m, this.f21047n, this.f21041h, this.f21048o)), composer, ((this.f21041h >> 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarC instanceof i.a.c) {
                    composer.startReplaceableGroup(-1987571961);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t.c(null, a.AbstractC0481a.c.EnumC0483a.CTA, this.f21040g, ComposableLambdaKt.composableLambda(composer, -2141882576, true, new b(this.f21043j, this.f21044k, this.f21045l, this.f21046m, this.f21047n, this.f21041h, this.f21048o)), composer, ((this.f21041h >> 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarC instanceof i.a.b) {
                    composer.startReplaceableGroup(-1987571367);
                    composer.endReplaceableGroup();
                } else if (aVarC instanceof i.a.d) {
                    composer.startReplaceableGroup(-1987571280);
                    composer.endReplaceableGroup();
                } else if (aVarC == null) {
                    composer.startReplaceableGroup(-1987571245);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(-1987571220);
                    composer.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Alignment alignment, PaddingValues paddingValues, String str, String str2, long j10, h9.a<k0> aVar, int i10) {
            super(7);
            this.f21033g = alignment;
            this.f21034h = paddingValues;
            this.f21035i = str;
            this.f21036j = str2;
            this.f21037k = j10;
            this.f21038l = aVar;
            this.f21039m = i10;
        }

        public static final i.a c(State<? extends i.a> state) {
            return state.getValue();
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void b(@NotNull BoxScope boxScope, boolean z10, @NotNull m0<? extends i.a> currentAdPartFlow, @NotNull h9.l<? super a.AbstractC0481a.c, k0> onButtonRendered, @NotNull h9.a<k0> onCTA, @Nullable Composer composer, int i10) {
            kotlin.jvm.internal.t.i(boxScope, "$this$null");
            kotlin.jvm.internal.t.i(currentAdPartFlow, "currentAdPartFlow");
            kotlin.jvm.internal.t.i(onButtonRendered, "onButtonRendered");
            kotlin.jvm.internal.t.i(onCTA, "onCTA");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1650189719, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous> (VastRenderer.kt:296)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z10, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.Companion, this.f21033g)), this.f21034h), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 1639156335, true, new a(onButtonRendered, i10, SnapshotStateKt.collectAsState(currentAdPartFlow, null, composer, 8, 1), this.f21035i, this.f21036j, this.f21037k, onCTA, this.f21038l, this.f21039m)), composer, ((i10 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.u
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, Boolean bool, m0<? extends i.a> m0Var, h9.l<? super a.AbstractC0481a.c, ? extends k0> lVar, h9.a<? extends k0> aVar, Composer composer, Integer num) {
            b(boxScope, bool.booleanValue(), m0Var, lVar, aVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class g extends v implements u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, ? extends k0>, h9.l<? super Boolean, ? extends k0>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Alignment f21067g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ PaddingValues f21068h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Painter f21069i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Painter f21070j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21071k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f21072l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f21073m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f21074n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Shape f21075o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ long f21076p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ int f21077q;

        public static final class a extends v implements q<AnimatedVisibilityScope, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ boolean f21078g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ Painter f21079h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ Painter f21080i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ MutableState<a.AbstractC0481a.c> f21081j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ h9.p<a.AbstractC0481a.c, a.AbstractC0481a.c.EnumC0483a, k0> f21082k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ int f21083l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ h9.l<Boolean, k0> f21084m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f21085n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ boolean f21086o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ long f21087p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public final /* synthetic */ long f21088q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public final /* synthetic */ long f21089r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public final /* synthetic */ Shape f21090s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public final /* synthetic */ long f21091t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public final /* synthetic */ int f21092u;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k$g$a$a, reason: collision with other inner class name */
            public static final class C0455a extends v implements h9.l<a.AbstractC0481a.c, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ h9.p<a.AbstractC0481a.c, a.AbstractC0481a.c.EnumC0483a, k0> f21093g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ boolean f21094h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ MutableState<a.AbstractC0481a.c> f21095i;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0455a(h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0> pVar, boolean z10, MutableState<a.AbstractC0481a.c> mutableState) {
                    super(1);
                    this.f21093g = pVar;
                    this.f21094h = z10;
                    this.f21095i = mutableState;
                }

                public final void a(@NotNull a.AbstractC0481a.c it) {
                    kotlin.jvm.internal.t.i(it, "it");
                    g.e(this.f21095i, it);
                    this.f21093g.mo4invoke(g.d(this.f21095i), this.f21094h ? a.AbstractC0481a.c.EnumC0483a.MUTE : a.AbstractC0481a.c.EnumC0483a.UNMUTE);
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(a.AbstractC0481a.c cVar) {
                    a(cVar);
                    return k0.f35197a;
                }
            }

            public static final class b extends v implements h9.l<SemanticsPropertyReceiver, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ String f21096g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(String str) {
                    super(1);
                    this.f21096g = str;
                }

                public final void a(@NotNull SemanticsPropertyReceiver semantics) {
                    kotlin.jvm.internal.t.i(semantics, "$this$semantics");
                    String str = this.f21096g;
                    SemanticsPropertiesKt.setContentDescription(semantics, str);
                    SemanticsPropertiesKt.setTestTag(semantics, str);
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    a(semanticsPropertyReceiver);
                    return k0.f35197a;
                }
            }

            public static final class c extends v implements h9.a<k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ h9.l<Boolean, k0> f21097g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ boolean f21098h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ h9.p<a.AbstractC0481a.c, a.AbstractC0481a.c.EnumC0483a, k0> f21099i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f21100j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ MutableState<a.AbstractC0481a.c> f21101k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public c(h9.l<? super Boolean, k0> lVar, boolean z10, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0> pVar, h9.a<k0> aVar, MutableState<a.AbstractC0481a.c> mutableState) {
                    super(0);
                    this.f21097g = lVar;
                    this.f21098h = z10;
                    this.f21099i = pVar;
                    this.f21100j = aVar;
                    this.f21101k = mutableState;
                }

                public final void b() {
                    this.f21097g.invoke(Boolean.valueOf(!this.f21098h));
                    g.e(this.f21101k, new a.AbstractC0481a.c(this.f21098h ? a.AbstractC0481a.c.EnumC0483a.MUTE : a.AbstractC0481a.c.EnumC0483a.UNMUTE, g.d(this.f21101k).d(), g.d(this.f21101k).e()));
                    this.f21099i.mo4invoke(g.d(this.f21101k), this.f21098h ? a.AbstractC0481a.c.EnumC0483a.UNMUTE : a.AbstractC0481a.c.EnumC0483a.MUTE);
                    h9.a<k0> aVar = this.f21100j;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                }

                @Override // h9.a
                public /* bridge */ /* synthetic */ k0 invoke() {
                    b();
                    return k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(boolean z10, Painter painter, Painter painter2, MutableState<a.AbstractC0481a.c> mutableState, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0> pVar, int i10, h9.l<? super Boolean, k0> lVar, h9.a<k0> aVar, boolean z11, long j10, long j11, long j12, Shape shape, long j13, int i11) {
                super(3);
                this.f21078g = z10;
                this.f21079h = painter;
                this.f21080i = painter2;
                this.f21081j = mutableState;
                this.f21082k = pVar;
                this.f21083l = i10;
                this.f21084m = lVar;
                this.f21085n = aVar;
                this.f21086o = z11;
                this.f21087p = j10;
                this.f21088q = j11;
                this.f21089r = j12;
                this.f21090s = shape;
                this.f21091t = j13;
                this.f21092u = i11;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer, int i10) {
                kotlin.jvm.internal.t.i(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-844484331, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultMuteButton.<anonymous>.<anonymous> (VastRenderer.kt:243)");
                }
                Painter painter = this.f21078g ? this.f21079h : this.f21080i;
                Modifier.Companion companion = Modifier.Companion;
                a.AbstractC0481a.c cVarD = g.d(this.f21081j);
                Object obj = this.f21081j;
                Object obj2 = this.f21082k;
                Object objValueOf = Boolean.valueOf(this.f21078g);
                h9.p<a.AbstractC0481a.c, a.AbstractC0481a.c.EnumC0483a, k0> pVar = this.f21082k;
                boolean z10 = this.f21078g;
                MutableState<a.AbstractC0481a.c> mutableState = this.f21081j;
                composer.startReplaceableGroup(1618982084);
                boolean zChanged = composer.changed(obj) | composer.changed(obj2) | composer.changed(objValueOf);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new C0455a(pVar, z10, mutableState);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier modifierA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers.a.a(companion, cVarD, (h9.l) objRememberedValue);
                composer.startReplaceableGroup(1157296644);
                boolean zChanged2 = composer.changed("mute_button");
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new b("mute_button");
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierA, false, (h9.l) objRememberedValue2, 1, null);
                MutableState<a.AbstractC0481a.c> mutableState2 = this.f21081j;
                h9.p<a.AbstractC0481a.c, a.AbstractC0481a.c.EnumC0483a, k0> pVar2 = this.f21082k;
                h9.a<k0> aVar = this.f21085n;
                Object[] objArr = {this.f21084m, Boolean.valueOf(this.f21078g), mutableState2, pVar2, aVar};
                h9.l<Boolean, k0> lVar = this.f21084m;
                boolean z11 = this.f21078g;
                composer.startReplaceableGroup(-568225417);
                boolean zChanged3 = false;
                for (int i11 = 0; i11 < 5; i11++) {
                    zChanged3 |= composer.changed(objArr[i11]);
                }
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new c(lVar, z11, pVar2, aVar, mutableState2);
                    composer.updateRememberedValue(objRememberedValue3);
                }
                composer.endReplaceableGroup();
                boolean z12 = this.f21086o;
                long j10 = this.f21087p;
                long j11 = this.f21088q;
                long j12 = this.f21089r;
                Shape shape = this.f21090s;
                long j13 = this.f21091t;
                int i12 = ((this.f21083l << 6) & 7168) | 24584;
                int i13 = this.f21092u;
                int i14 = i12 | ((i13 >> 3) & 458752);
                int i15 = i13 << 18;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.p.a(painter, (h9.a) objRememberedValue3, modifierSemantics$default, z12, "mute/unmute", j10, j11, j12, shape, j13, composer, i14 | (i15 & 3670016) | (i15 & 29360128) | (i15 & 234881024) | (i15 & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Alignment alignment, PaddingValues paddingValues, Painter painter, Painter painter2, h9.a<k0> aVar, long j10, long j11, long j12, Shape shape, long j13, int i10) {
            super(7);
            this.f21067g = alignment;
            this.f21068h = paddingValues;
            this.f21069i = painter;
            this.f21070j = painter2;
            this.f21071k = aVar;
            this.f21072l = j10;
            this.f21073m = j11;
            this.f21074n = j12;
            this.f21075o = shape;
            this.f21076p = j13;
            this.f21077q = i10;
        }

        public static final a.AbstractC0481a.c d(MutableState<a.AbstractC0481a.c> mutableState) {
            return mutableState.getValue();
        }

        public static final void e(MutableState<a.AbstractC0481a.c> mutableState, a.AbstractC0481a.c cVar) {
            mutableState.setValue(cVar);
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void b(@NotNull BoxScope boxScope, boolean z10, boolean z11, @NotNull h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0> onButtonReplaced, @NotNull h9.l<? super Boolean, k0> onMuteChange, @Nullable Composer composer, int i10) {
            int i11;
            kotlin.jvm.internal.t.i(boxScope, "$this$null");
            kotlin.jvm.internal.t.i(onButtonReplaced, "onButtonReplaced");
            kotlin.jvm.internal.t.i(onMuteChange, "onMuteChange");
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(boxScope) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(z10) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i11 |= composer.changed(z11) ? 256 : 128;
            }
            if ((i10 & 7168) == 0) {
                i11 |= composer.changed(onButtonReplaced) ? 2048 : 1024;
            }
            if ((i10 & 57344) == 0) {
                i11 |= composer.changed(onMuteChange) ? 16384 : 8192;
            }
            if ((374491 & i11) == 74898 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1840636691, i11, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultMuteButton.<anonymous> (VastRenderer.kt:228)");
            }
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.b.a(a.AbstractC0481a.c.EnumC0483a.MUTE), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            int i12 = i11;
            AnimatedVisibilityKt.AnimatedVisibility(z10, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.Companion, this.f21067g)), this.f21068h), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, -844484331, true, new a(z11, this.f21069i, this.f21070j, (MutableState) objRememberedValue, onButtonReplaced, i12, onMuteChange, this.f21071k, z10, this.f21072l, this.f21073m, this.f21074n, this.f21075o, this.f21076p, this.f21077q)), composer, ((i12 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.u
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, Boolean bool, Boolean bool2, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, ? extends k0> pVar, h9.l<? super Boolean, ? extends k0> lVar, Composer composer, Integer num) {
            b(boxScope, bool.booleanValue(), bool2.booleanValue(), pVar, lVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class h extends v implements s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Alignment f21102g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ PaddingValues f21103h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f21104i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f21105j;

        public static final class a extends v implements q<AnimatedVisibilityScope, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ boolean f21106g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i f21107h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ long f21108i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ int f21109j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ int f21110k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(boolean z10, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, long j10, int i10, int i11) {
                super(3);
                this.f21106g = z10;
                this.f21107h = iVar;
                this.f21108i = j10;
                this.f21109j = i10;
                this.f21110k = i11;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer, int i10) {
                kotlin.jvm.internal.t.i(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-429085079, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar.<anonymous>.<anonymous> (VastRenderer.kt:379)");
                }
                boolean z10 = this.f21106g;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar = this.f21107h;
                long j10 = this.f21108i;
                int i11 = this.f21109j >> 3;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.j.d(z10, iVar, null, j10, composer, (i11 & 112) | (i11 & 14) | ((this.f21110k << 3) & 7168), 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.q
            public /* bridge */ /* synthetic */ k0 invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Alignment alignment, PaddingValues paddingValues, long j10, int i10) {
            super(5);
            this.f21102g = alignment;
            this.f21103h = paddingValues;
            this.f21104i = j10;
            this.f21105j = i10;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull BoxScope boxScope, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress, @Nullable Composer composer, int i10) {
            int i11;
            int i12;
            kotlin.jvm.internal.t.i(boxScope, "$this$null");
            kotlin.jvm.internal.t.i(progress, "progress");
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(boxScope) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(z10) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i12 = (composer.changed(progress) ? 256 : 128) | i11;
            } else {
                i12 = i11;
            }
            if ((i12 & 5851) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1403272127, i12, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar.<anonymous> (VastRenderer.kt:371)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z10 || ((progress instanceof i.c) && ((i.c) progress).a() > 0), PaddingKt.padding(boxScope.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), this.f21102g), this.f21103h), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, -429085079, true, new a(z10, progress, this.f21104i, i12, this.f21105j)), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.s
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), iVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class i extends v implements h9.p<Composer, Integer, u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, ? extends k0>, ? super h9.l<? super Boolean, ? extends k0>, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final i f21111g = new i();

        public i() {
            super(2);
        }

        @Composable
        @NotNull
        public final u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(983535076);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(983535076, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:175)");
            }
            u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> uVarE = k.e(0L, 0L, null, 0L, null, null, 0L, null, null, null, composer, 0, 1023);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return uVarE;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, ? extends k0>, ? super h9.l<? super Boolean, ? extends k0>, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class j extends v implements h9.p<Composer, Integer, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final j f21112g = new j();

        public j() {
            super(2);
        }

        @Composable
        @NotNull
        public final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(699790980);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(699790980, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:176)");
            }
            h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> bVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o.b(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return bVarB;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k$k, reason: collision with other inner class name */
    public static final class C0456k extends v implements h9.p<Composer, Integer, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0456k f21113g = new C0456k();

        public C0456k() {
            super(2);
        }

        @Composable
        @NotNull
        public final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(1077132061);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1077132061, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:177)");
            }
            h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> bVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.d.b(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return bVarB;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class l extends v implements h9.p<Composer, Integer, u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super h9.a<? extends k0>, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final l f21114g = new l();

        public l() {
            super(2);
        }

        @Composable
        @NotNull
        public final u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(-932310693);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-932310693, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:178)");
            }
            u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0> uVarF = k.f(null, null, 0L, null, null, null, composer, 0, 63);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return uVarF;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super h9.a<? extends k0>, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class m extends v implements h9.p<Composer, Integer, s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final m f21115g = new m();

        public m() {
            super(2);
        }

        @Composable
        @NotNull
        public final s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(1142669469);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1142669469, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:180)");
            }
            s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> sVarD = k.d(null, null, 0L, composer, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return sVarD;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class n extends v implements h9.p<Composer, Integer, t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<? extends k0>, ? super h9.a<? extends k0>, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final n f21116g = new n();

        public n() {
            super(2);
        }

        @Composable
        @NotNull
        public final t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(-1702378369);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1702378369, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:181)");
            }
            t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> tVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.e.b(null, null, composer, 0, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return tVarB;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<? extends k0>, ? super h9.a<? extends k0>, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class o extends v implements h9.p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final o f21117g = new o();

        public o() {
            super(2);
        }

        @Composable
        @Nullable
        public final Void a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(480790443);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(480790443, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:182)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return null;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Object obj, Object obj2) {
            return a((Composer) obj, ((Number) obj2).intValue());
        }
    }

    public static final class p extends v implements h9.p<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ComposeView> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f21118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0>> f21119h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21120i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21121j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0>> f21122k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f f21123l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0>> f21124m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0>> f21125n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0>> f21126o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t f21127p;

        public static final class a extends v implements h9.p<Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f21128g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ long f21129h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0>> f21130i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21131j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21132k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0>> f21133l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f f21134m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ h9.p<Composer, Integer, s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0>> f21135n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ h9.p<Composer, Integer, t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0>> f21136o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0>> f21137p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t f21138q;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k$p$a$a, reason: collision with other inner class name */
            public static final class C0457a extends v implements h9.p<Composer, Integer, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f21139g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ long f21140h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0>> f21141i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21142j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21143k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0>> f21144l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f f21145m;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                public final /* synthetic */ h9.p<Composer, Integer, s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0>> f21146n;

                /* JADX INFO: renamed from: o, reason: collision with root package name */
                public final /* synthetic */ h9.p<Composer, Integer, t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0>> f21147o;

                /* JADX INFO: renamed from: p, reason: collision with root package name */
                public final /* synthetic */ h9.p<Composer, Integer, u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0>> f21148p;

                /* JADX INFO: renamed from: q, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t f21149q;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0457a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, long j10, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, ? super h9.l<? super Boolean, k0>, ? super Composer, ? super Integer, k0>> pVar, h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar2, h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar3, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar4, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar, h9.p<? super Composer, ? super Integer, ? extends s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, k0>> pVar5, h9.p<? super Composer, ? super Integer, ? extends t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar6, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super Boolean, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar7, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar) {
                    super(2);
                    this.f21139g = iVar;
                    this.f21140h = j10;
                    this.f21141i = pVar;
                    this.f21142j = pVar2;
                    this.f21143k = pVar3;
                    this.f21144l = pVar4;
                    this.f21145m = fVar;
                    this.f21146n = pVar5;
                    this.f21147o = pVar6;
                    this.f21148p = pVar7;
                    this.f21149q = tVar;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void a(@Nullable Composer composer, int i10) {
                    if ((i10 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-379781047, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:190)");
                    }
                    k.g(this.f21139g, null, this.f21140h, this.f21141i.mo4invoke(composer, 0), this.f21142j.mo4invoke(composer, 0), this.f21143k.mo4invoke(composer, 0), this.f21144l.mo4invoke(composer, 0), this.f21145m, this.f21146n.mo4invoke(composer, 0), this.f21147o.mo4invoke(composer, 0), this.f21148p.mo4invoke(composer, 0), this.f21149q, composer, 0, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // h9.p
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                    a(composer, num.intValue());
                    return k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, long j10, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, ? super h9.l<? super Boolean, k0>, ? super Composer, ? super Integer, k0>> pVar, h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar2, h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar3, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar4, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar, h9.p<? super Composer, ? super Integer, ? extends s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, k0>> pVar5, h9.p<? super Composer, ? super Integer, ? extends t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar6, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super Boolean, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar7, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar) {
                super(2);
                this.f21128g = iVar;
                this.f21129h = j10;
                this.f21130i = pVar;
                this.f21131j = pVar2;
                this.f21132k = pVar3;
                this.f21133l = pVar4;
                this.f21134m = fVar;
                this.f21135n = pVar5;
                this.f21136o = pVar6;
                this.f21137p = pVar7;
                this.f21138q = tVar;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@Nullable Composer composer, int i10) {
                if ((i10 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1390785882, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:189)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, ComposableLambdaKt.composableLambda(composer, -379781047, true, new C0457a(this.f21128g, this.f21129h, this.f21130i, this.f21131j, this.f21132k, this.f21133l, this.f21134m, this.f21135n, this.f21136o, this.f21137p, this.f21138q)), composer, 48, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                a(composer, num.intValue());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public p(long j10, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, ? super h9.l<? super Boolean, k0>, ? super Composer, ? super Integer, k0>> pVar, h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar2, h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar3, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar4, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar, h9.p<? super Composer, ? super Integer, ? extends s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, k0>> pVar5, h9.p<? super Composer, ? super Integer, ? extends t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar6, h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super Boolean, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> pVar7, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar) {
            super(2);
            this.f21118g = j10;
            this.f21119h = pVar;
            this.f21120i = pVar2;
            this.f21121j = pVar3;
            this.f21122k = pVar4;
            this.f21123l = fVar;
            this.f21124m = pVar5;
            this.f21125n = pVar6;
            this.f21126o = pVar7;
            this.f21127p = tVar;
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ComposeView mo4invoke(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel) {
            kotlin.jvm.internal.t.i(context, "context");
            kotlin.jvm.internal.t.i(adViewModel, "adViewModel");
            ComposeView composeView = new ComposeView(context, null, 0, 6, null);
            long j10 = this.f21118g;
            h9.p<Composer, Integer, u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0>> pVar = this.f21119h;
            h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> pVar2 = this.f21120i;
            h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> pVar3 = this.f21121j;
            h9.p<Composer, Integer, u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0>> pVar4 = this.f21122k;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar = this.f21123l;
            h9.p<Composer, Integer, s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0>> pVar5 = this.f21124m;
            h9.p<Composer, Integer, t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0>> pVar6 = this.f21125n;
            h9.p<Composer, Integer, u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0>> pVar7 = this.f21126o;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar = this.f21127p;
            composeView.setId(com.moloco.sdk.q.f18866a);
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1390785882, true, new a(adViewModel, j10, pVar, pVar2, pVar3, pVar4, fVar, pVar5, pVar6, pVar7, tVar)));
            return composeView;
        }
    }

    public static final i.a a(State<? extends i.a> state) {
        return state.getValue();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable:[androidx.compose.ui.UiComposable]][androidx.compose.ui.UiComposable:[_]][androidx.compose.ui.UiComposable:[_]][androidx.compose.ui.UiComposable:[androidx.compose.ui.UiComposable]][androidx.compose.ui.UiComposable:[androidx.compose.ui.UiComposable]][androidx.compose.ui.UiComposable:[androidx.compose.ui.UiComposable]][androidx.compose.ui.UiComposable:[androidx.compose.ui.UiComposable]]]")
    @NotNull
    public static final h9.p<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> b(long j10, @NotNull h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, ? super h9.l<? super Boolean, k0>, ? super Composer, ? super Integer, k0>> muteButton, @NotNull h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> adCloseCountdownButton, @NotNull h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> adSkipCountdownButton, @NotNull h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> ctaButton, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar, @NotNull h9.p<? super Composer, ? super Integer, ? extends s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, k0>> progressBar, @NotNull h9.p<? super Composer, ? super Integer, ? extends t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> vastIcon, @NotNull h9.p<? super Composer, ? super Integer, ? extends u<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super Boolean, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0>> playbackControl, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t viewVisibilityTracker) {
        kotlin.jvm.internal.t.i(muteButton, "muteButton");
        kotlin.jvm.internal.t.i(adCloseCountdownButton, "adCloseCountdownButton");
        kotlin.jvm.internal.t.i(adSkipCountdownButton, "adSkipCountdownButton");
        kotlin.jvm.internal.t.i(ctaButton, "ctaButton");
        kotlin.jvm.internal.t.i(progressBar, "progressBar");
        kotlin.jvm.internal.t.i(vastIcon, "vastIcon");
        kotlin.jvm.internal.t.i(playbackControl, "playbackControl");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        return new p(j10, muteButton, adCloseCountdownButton, adSkipCountdownButton, ctaButton, fVar, progressBar, vastIcon, playbackControl, viewVisibilityTracker);
    }

    @Composable
    @NotNull
    public static final s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> d(@Nullable Alignment alignment, @Nullable PaddingValues paddingValues, long j10, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-381485229);
        if ((i11 & 1) != 0) {
            alignment = Alignment.Companion.getBottomCenter();
        }
        Alignment alignment2 = alignment;
        if ((i11 & 2) != 0) {
            paddingValues = PaddingKt.m392PaddingValues0680j_4(Dp.m3673constructorimpl(0));
        }
        PaddingValues paddingValues2 = paddingValues;
        if ((i11 & 4) != 0) {
            j10 = MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m951getPrimary0d7_KjU();
        }
        long j11 = j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-381485229, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar (VastRenderer.kt:367)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1403272127, true, new h(alignment2, paddingValues2, j11, i10));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    @Composable
    @NotNull
    public static final u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> e(long j10, long j11, @Nullable Shape shape, long j12, @Nullable Alignment alignment, @Nullable PaddingValues paddingValues, long j13, @Nullable Painter painter, @Nullable Painter painter2, @Nullable h9.a<k0> aVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1174713072);
        long jB = (i11 & 1) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b() : j10;
        long j14 = (i11 & 2) != 0 ? jB : j11;
        Shape shapeE = (i11 & 4) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.e() : shape;
        long jD = (i11 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d() : j12;
        Alignment topStart = (i11 & 16) != 0 ? Alignment.Companion.getTopStart() : alignment;
        PaddingValues paddingValuesM392PaddingValues0680j_4 = (i11 & 32) != 0 ? PaddingKt.m392PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        long jM951getPrimary0d7_KjU = (i11 & 64) != 0 ? MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m951getPrimary0d7_KjU() : j13;
        Painter painterPainterResource = (i11 & 128) != 0 ? PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18855c, composer, 0) : painter;
        Painter painterPainterResource2 = (i11 & 256) != 0 ? PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18856d, composer, 0) : painter2;
        h9.a<k0> aVar2 = (i11 & 512) != 0 ? null : aVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1174713072, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultMuteButton (VastRenderer.kt:217)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1840636691, true, new g(topStart, paddingValuesM392PaddingValues0680j_4, painterPainterResource, painterPainterResource2, aVar2, jM951getPrimary0d7_KjU, jB, j14, shapeE, jD, i10));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    @Composable
    @NotNull
    public static final u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0> f(@Nullable Alignment alignment, @Nullable PaddingValues paddingValues, long j10, @Nullable String str, @Nullable String str2, @Nullable h9.a<k0> aVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-927875671);
        Alignment bottomEnd = (i11 & 1) != 0 ? Alignment.Companion.getBottomEnd() : alignment;
        PaddingValues paddingValuesM392PaddingValues0680j_4 = (i11 & 2) != 0 ? PaddingKt.m392PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        long jM951getPrimary0d7_KjU = (i11 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m951getPrimary0d7_KjU() : j10;
        String strStringResource = (i11 & 8) != 0 ? StringResources_androidKt.stringResource(r.f18867a, composer, 0) : str;
        String str3 = (i11 & 16) != 0 ? null : str2;
        h9.a<k0> aVar2 = (i11 & 32) != 0 ? null : aVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-927875671, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton (VastRenderer.kt:289)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1650189719, true, new f(bottomEnd, paddingValuesM392PaddingValues0680j_4, str3, strStringResource, jM951getPrimary0d7_KjU, aVar2, i10));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r12v1, types: [h9.u] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v2, types: [androidx.compose.foundation.layout.PaddingValues, androidx.compose.ui.Alignment] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r44v3, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f] */
    /* JADX WARN: Type inference failed for: r48v3, types: [h9.u] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v19, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f] */
    /* JADX WARN: Type inference failed for: r9v20 */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i r42, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r43, long r44, @org.jetbrains.annotations.Nullable h9.u<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super h9.p<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a.c.EnumC0483a, v8.k0>, ? super h9.l<? super java.lang.Boolean, v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r46, @org.jetbrains.annotations.Nullable h9.b<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super h9.a<v8.k0>, ? super h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a.c, v8.k0>, ? super java.lang.Boolean, ? super v8.c0, ? super v8.c0, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r47, @org.jetbrains.annotations.Nullable h9.b<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super h9.a<v8.k0>, ? super h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a.c, v8.k0>, ? super java.lang.Boolean, ? super v8.c0, ? super v8.c0, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r48, @org.jetbrains.annotations.Nullable h9.u<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super s9.m0<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, ? super h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a.c, v8.k0>, ? super h9.a<v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r49, @org.jetbrains.annotations.Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f r50, @org.jetbrains.annotations.Nullable h9.s<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r51, @org.jetbrains.annotations.Nullable h9.t<? super androidx.compose.foundation.layout.BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<v8.k0>, ? super h9.a<v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r52, @org.jetbrains.annotations.Nullable h9.u<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super java.lang.Boolean, v8.k0>, ? super h9.a<v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r53, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t r54, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            Method dump skipped, instruction units count: 1310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.g(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, androidx.compose.ui.Modifier, long, h9.u, h9.b, h9.b, h9.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f, h9.s, h9.t, h9.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final boolean h(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
