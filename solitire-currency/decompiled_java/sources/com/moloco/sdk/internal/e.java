package com.moloco.sdk.internal;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.c0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v8.l f17606a = v8.n.a(a.f17610g);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f17607b = Color.Companion.m1635getWhite0d7_KjU();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f17608c = s.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f17609d;

    public static final class a extends kotlin.jvm.internal.v implements h9.a<com.moloco.sdk.internal.ortb.model.o> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f17610g = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.internal.ortb.model.o invoke() {
            long j10 = e.f17608c;
            int iC = c0.c(30);
            com.moloco.sdk.internal.ortb.model.l lVar = com.moloco.sdk.internal.ortb.model.l.End;
            com.moloco.sdk.internal.ortb.model.u uVar = com.moloco.sdk.internal.ortb.model.u.Top;
            int i10 = 10;
            Color color = null;
            kotlin.jvm.internal.k kVar = null;
            com.moloco.sdk.internal.ortb.model.s sVar = new com.moloco.sdk.internal.ortb.model.s(5, i10, iC, lVar, uVar, j10, color, 64, kVar);
            int i11 = 0;
            boolean z10 = false;
            return new com.moloco.sdk.internal.ortb.model.o(sVar, sVar, new com.moloco.sdk.internal.ortb.model.p(i11, com.moloco.sdk.internal.ortb.model.l.Center, com.moloco.sdk.internal.ortb.model.u.Bottom, e.f17608c, null), new com.moloco.sdk.internal.ortb.model.n(z10, i10, com.moloco.sdk.internal.ortb.model.l.Start, uVar, j10, (c0) null, color, 96, kVar), (com.moloco.sdk.internal.ortb.model.g) null, true, new com.moloco.sdk.internal.ortb.model.a(false, false, (String) null, 6, (kotlin.jvm.internal.k) null), (com.moloco.sdk.internal.ortb.model.t) null, (com.moloco.sdk.internal.ortb.model.j) (0 == true ? 1 : 0), (com.moloco.sdk.internal.ortb.model.i) null, RendererCapabilities.DECODER_SUPPORT_MASK, (kotlin.jvm.internal.k) null);
        }
    }

    public static final class b extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.s f17611g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i f17612h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.internal.ortb.model.s sVar, com.moloco.sdk.internal.ortb.model.i iVar) {
            super(2);
            this.f17611g = sVar;
            this.f17612h = iVar;
        }

        @Composable
        @Nullable
        public final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(113929444);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(113929444, i10, -1, "com.moloco.sdk.internal.determineSkipCloseBehaviorFromDec.<anonymous> (AggregatedOptions.kt:181)");
            }
            float fM3673constructorimpl = Dp.m3673constructorimpl(this.f17611g.c());
            long jM3695DpSizeYgX7TsA = DpKt.m3695DpSizeYgX7TsA(fM3673constructorimpl, fM3673constructorimpl);
            Alignment alignmentA = e.a(this.f17611g.f(), this.f17611g.h());
            PaddingValues paddingValuesM392PaddingValues0680j_4 = PaddingKt.m392PaddingValues0680j_4(Dp.m3673constructorimpl(this.f17611g.g()));
            long jE = this.f17611g.e();
            long sp = TextUnitKt.getSp(this.f17611g.c());
            TextUnitKt.m3867checkArithmeticR2X_6o(sp);
            long jPack = TextUnitKt.pack(TextUnit.m3852getRawTypeimpl(sp), TextUnit.m3854getValueimpl(sp) / 2);
            long jM3776timesGh9hcWk = DpSize.m3776timesGh9hcWk(jM3695DpSizeYgX7TsA, 0.4f);
            Color colorA = this.f17611g.a();
            h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> bVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.d.b(alignmentA, paddingValuesM392PaddingValues0680j_4, jE, jM3695DpSizeYgX7TsA, jPack, e.k(jM3776timesGh9hcWk, colorA != null ? colorA.m1608unboximpl() : e.f17607b, composer, 0), null, this.f17612h, composer, 0, 64);
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

    public static final class c extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f17613g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.s f17614h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i f17615i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z10, com.moloco.sdk.internal.ortb.model.s sVar, com.moloco.sdk.internal.ortb.model.i iVar) {
            super(2);
            this.f17613g = z10;
            this.f17614h = sVar;
            this.f17615i = iVar;
        }

        @Composable
        @Nullable
        public final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> bVarB;
            composer.startReplaceableGroup(-1451072431);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1451072431, i10, -1, "com.moloco.sdk.internal.toCloseButton.<anonymous> (AggregatedOptions.kt:199)");
            }
            if (this.f17613g) {
                bVarB = null;
            } else {
                float fM3673constructorimpl = Dp.m3673constructorimpl(this.f17614h.c());
                long jM3695DpSizeYgX7TsA = DpKt.m3695DpSizeYgX7TsA(fM3673constructorimpl, fM3673constructorimpl);
                Alignment alignmentA = e.a(this.f17614h.f(), this.f17614h.h());
                PaddingValues paddingValuesM392PaddingValues0680j_4 = PaddingKt.m392PaddingValues0680j_4(Dp.m3673constructorimpl(this.f17614h.g()));
                long jE = this.f17614h.e();
                long sp = TextUnitKt.getSp(this.f17614h.c());
                TextUnitKt.m3867checkArithmeticR2X_6o(sp);
                long jPack = TextUnitKt.pack(TextUnit.m3852getRawTypeimpl(sp), TextUnit.m3854getValueimpl(sp) / 2);
                Painter painterPainterResource = PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18858f, composer, 0);
                long jM3776timesGh9hcWk = DpSize.m3776timesGh9hcWk(jM3695DpSizeYgX7TsA, 0.45f);
                Color colorA = this.f17614h.a();
                bVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o.b(alignmentA, paddingValuesM392PaddingValues0680j_4, jE, jM3695DpSizeYgX7TsA, jPack, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o.a(painterPainterResource, jM3776timesGh9hcWk, null, colorA != null ? colorA.m1608unboximpl() : e.f17607b, composer, 8, 4), null, this.f17615i, composer, 0, 64);
            }
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

    public static final class d extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, h9.u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, ? extends k0>, ? super h9.l<? super Boolean, ? extends k0>, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o f17616g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f17616g = oVar;
        }

        @Composable
        @Nullable
        public final h9.u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            long jM3695DpSizeYgX7TsA;
            composer.startReplaceableGroup(-540184598);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-540184598, i10, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:76)");
            }
            if (this.f17616g.g().c() != null) {
                float fM3673constructorimpl = Dp.m3673constructorimpl(r1.g());
                jM3695DpSizeYgX7TsA = DpKt.m3695DpSizeYgX7TsA(fM3673constructorimpl, fM3673constructorimpl);
            } else {
                jM3695DpSizeYgX7TsA = e.f17609d;
            }
            Alignment alignmentA = e.a(this.f17616g.g().e(), this.f17616g.g().h());
            PaddingValues paddingValuesM392PaddingValues0680j_4 = PaddingKt.m392PaddingValues0680j_4(Dp.m3673constructorimpl(this.f17616g.g().g()));
            long jM3776timesGh9hcWk = DpSize.m3776timesGh9hcWk(jM3695DpSizeYgX7TsA, 0.6f);
            long jD = this.f17616g.g().d();
            Color colorA = this.f17616g.g().a();
            h9.u<BoxScope, Boolean, Boolean, h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> uVarE = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.e(jM3695DpSizeYgX7TsA, jM3776timesGh9hcWk, null, colorA != null ? colorA.m1608unboximpl() : e.f17607b, alignmentA, paddingValuesM392PaddingValues0680j_4, jD, PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18864l, composer, 0), PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18865m, composer, 0), null, composer, 150994944, IronSourceConstants.SDK_INIT_SUCCESS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return uVarE;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ h9.u<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, ? extends k0>, ? super h9.l<? super Boolean, ? extends k0>, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.e$e, reason: collision with other inner class name */
    public static final class C0301e extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o f17617g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0301e(com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f17617g = oVar;
        }

        @Composable
        @Nullable
        public final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> bVarB;
            composer.startReplaceableGroup(-1721735675);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1721735675, i10, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:91)");
            }
            com.moloco.sdk.internal.ortb.model.s sVarI = this.f17617g.i();
            if (sVarI == null) {
                bVarB = null;
            } else {
                com.moloco.sdk.internal.ortb.model.o oVar = this.f17617g;
                float fM3673constructorimpl = Dp.m3673constructorimpl(sVarI.c());
                long jM3695DpSizeYgX7TsA = DpKt.m3695DpSizeYgX7TsA(fM3673constructorimpl, fM3673constructorimpl);
                Alignment alignmentA = e.a(sVarI.f(), sVarI.h());
                PaddingValues paddingValuesM392PaddingValues0680j_4 = PaddingKt.m392PaddingValues0680j_4(Dp.m3673constructorimpl(sVarI.g()));
                long jE = sVarI.e();
                long sp = TextUnitKt.getSp(sVarI.c());
                TextUnitKt.m3867checkArithmeticR2X_6o(sp);
                long jPack = TextUnitKt.pack(TextUnit.m3852getRawTypeimpl(sp), TextUnit.m3854getValueimpl(sp) / 2);
                long jM3776timesGh9hcWk = DpSize.m3776timesGh9hcWk(jM3695DpSizeYgX7TsA, 0.4f);
                Color colorA = sVarI.a();
                bVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.d.b(alignmentA, paddingValuesM392PaddingValues0680j_4, jE, jM3695DpSizeYgX7TsA, jPack, e.k(jM3776timesGh9hcWk, colorA != null ? colorA.m1608unboximpl() : e.f17607b, composer, 0), null, oVar.d(), composer, 0, 64);
            }
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

    public static final class f extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, h9.u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super h9.a<? extends k0>, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f17618g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o f17619h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z10, com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f17618g = z10;
            this.f17619h = oVar;
        }

        @Composable
        @Nullable
        public final h9.u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            h9.u<BoxScope, Boolean, m0<? extends i.a>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, Composer, Integer, k0> uVarB;
            com.moloco.sdk.internal.ortb.model.g gVarE;
            composer.startReplaceableGroup(-937155833);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-937155833, i10, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:109)");
            }
            if (this.f17618g || (gVarE = this.f17619h.e()) == null) {
                uVarB = null;
            } else {
                Alignment alignmentA = e.a(gVarE.d(), gVarE.h());
                PaddingValues paddingValuesM392PaddingValues0680j_4 = PaddingKt.m392PaddingValues0680j_4(Dp.m3673constructorimpl(gVarE.f()));
                String strG = gVarE.g();
                long jC = gVarE.c();
                Color colorA = gVarE.a();
                uVarB = s.b(alignmentA, paddingValuesM392PaddingValues0680j_4, strG, jC, colorA != null ? colorA.m1608unboximpl() : s.a(), gVarE.e(), composer, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return uVarB;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ h9.u<? super BoxScope, ? super Boolean, ? super m0<? extends i.a>, ? super h9.l<? super a.AbstractC0481a.c, ? extends k0>, ? super h9.a<? extends k0>, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class g extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, h9.s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f17620g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o f17621h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(boolean z10, com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f17620g = z10;
            this.f17621h = oVar;
        }

        @Composable
        @Nullable
        public final h9.s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            com.moloco.sdk.internal.ortb.model.p pVarH;
            composer.startReplaceableGroup(-590534265);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-590534265, i10, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:127)");
            }
            h9.s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> sVarD = (this.f17620g || (pVarH = this.f17621h.h()) == null) ? null : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.d(e.a(pVarH.c(), pVarH.e()), PaddingKt.m392PaddingValues0680j_4(Dp.m3673constructorimpl(pVarH.d())), pVarH.a(), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return sVarD;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ h9.s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class h extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, h9.t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<? extends k0>, ? super h9.a<? extends k0>, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.o f17622g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(com.moloco.sdk.internal.ortb.model.o oVar) {
            super(2);
            this.f17622g = oVar;
        }

        @Composable
        @Nullable
        public final h9.t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(-1028492539);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1028492539, i10, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:141)");
            }
            com.moloco.sdk.internal.ortb.model.t tVarJ = this.f17622g.j();
            composer.startReplaceableGroup(656099296);
            h9.t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> tVarB = tVarJ == null ? null : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.e.b(e.a(tVarJ.a(), tVarJ.d()), PaddingKt.m392PaddingValues0680j_4(Dp.m3673constructorimpl(tVarJ.c())), composer, 0, 0);
            composer.endReplaceableGroup();
            if (tVarB == null) {
                tVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.e.b(null, null, composer, 0, 3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return tVarB;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ h9.t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<? extends k0>, ? super h9.a<? extends k0>, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    static {
        float f10 = 30;
        f17609d = DpKt.m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(f10), Dp.m3673constructorimpl(f10));
    }

    @NotNull
    public static final Alignment a(@NotNull com.moloco.sdk.internal.ortb.model.l horizontalAlignment, @NotNull com.moloco.sdk.internal.ortb.model.u verticalAlignment) {
        kotlin.jvm.internal.t.i(horizontalAlignment, "horizontalAlignment");
        kotlin.jvm.internal.t.i(verticalAlignment, "verticalAlignment");
        com.moloco.sdk.internal.ortb.model.u uVar = com.moloco.sdk.internal.ortb.model.u.Top;
        if (verticalAlignment == uVar && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Start || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Left)) {
            return Alignment.Companion.getTopStart();
        }
        if (verticalAlignment == uVar && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Center) {
            return Alignment.Companion.getTopCenter();
        }
        if (verticalAlignment == uVar && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.End || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Right)) {
            return Alignment.Companion.getTopEnd();
        }
        com.moloco.sdk.internal.ortb.model.u uVar2 = com.moloco.sdk.internal.ortb.model.u.Center;
        if (verticalAlignment == uVar2 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Start || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Left)) {
            return Alignment.Companion.getCenterStart();
        }
        if (verticalAlignment == uVar2 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Center) {
            return Alignment.Companion.getCenter();
        }
        if (verticalAlignment == uVar2 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.End || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Right)) {
            return Alignment.Companion.getCenterEnd();
        }
        com.moloco.sdk.internal.ortb.model.u uVar3 = com.moloco.sdk.internal.ortb.model.u.Bottom;
        return (verticalAlignment == uVar3 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Start || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Left)) ? Alignment.Companion.getBottomStart() : (verticalAlignment == uVar3 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Center) ? Alignment.Companion.getBottomCenter() : (verticalAlignment == uVar3 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.End || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.Right)) ? Alignment.Companion.getBottomEnd() : Alignment.Companion.getTopStart();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d b(com.moloco.sdk.internal.ortb.model.o oVar, boolean z10) {
        com.moloco.sdk.internal.ortb.model.k kVarD;
        c0 c0VarA;
        int iD = oVar.c().d();
        h9.w wVarD = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.d(0L, h(z10, oVar.c(), oVar.f(), oVar.d()), 1, null);
        com.moloco.sdk.internal.ortb.model.j jVarF = oVar.f();
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d(iD, wVarD, (jVarF == null || (kVarD = jVarF.d()) == null || (c0VarA = kVarD.a()) == null) ? 0 : c0VarA.g(), g(oVar.c(), z10, null, 2, null));
    }

    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f c() {
        return d(p());
    }

    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f d(@NotNull com.moloco.sdk.internal.ortb.model.o oVar) {
        kotlin.jvm.internal.t.i(oVar, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d dVarB = b(oVar, true);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f(l(oVar, true), dVarB, dVarB);
    }

    public static final h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f(com.moloco.sdk.internal.ortb.model.s sVar, boolean z10, com.moloco.sdk.internal.ortb.model.i iVar) {
        return new c(z10, sVar, iVar);
    }

    public static /* synthetic */ h9.p g(com.moloco.sdk.internal.ortb.model.s sVar, boolean z10, com.moloco.sdk.internal.ortb.model.i iVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = null;
        }
        return f(sVar, z10, iVar);
    }

    @NotNull
    public static final h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> h(boolean z10, @NotNull com.moloco.sdk.internal.ortb.model.s close, @Nullable com.moloco.sdk.internal.ortb.model.j jVar, @Nullable com.moloco.sdk.internal.ortb.model.i iVar) {
        kotlin.jvm.internal.t.i(close, "close");
        return jVar == null ? f(close, z10, iVar) : new b(close, iVar);
    }

    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f i() {
        return j(p());
    }

    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f j(@NotNull com.moloco.sdk.internal.ortb.model.o oVar) {
        kotlin.jvm.internal.t.i(oVar, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d dVarB = b(oVar, false);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f(l(oVar, false), dVarB, dVarB);
    }

    @Composable
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.m k(long j10, long j11, Composer composer, int i10) {
        composer.startReplaceableGroup(-868162195);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-868162195, i10, -1, "com.moloco.sdk.internal.defaultMolocoSkipAfterCountdownButtonPart (AggregatedOptions.kt:156)");
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.m mVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.d.a(PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18859g, composer, 0), j10, null, j11, composer, ((i10 << 3) & 112) | 8 | ((i10 << 6) & 7168), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mVarA;
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q l(com.moloco.sdk.internal.ortb.model.o oVar, boolean z10) {
        com.moloco.sdk.internal.ortb.model.k kVarD;
        c0 c0VarA;
        boolean zF = oVar.g().f();
        Boolean bool = oVar.i() == null ? null : Boolean.TRUE;
        com.moloco.sdk.internal.ortb.model.s sVarI = oVar.i();
        int iD = sVarI != null ? sVarI.d() : 0;
        com.moloco.sdk.internal.ortb.model.a aVarA = oVar.a();
        boolean z11 = aVarA != null && aVarA.b() && oVar.a().d();
        com.moloco.sdk.internal.ortb.model.a aVarA2 = oVar.a();
        boolean z12 = aVarA2 != null && aVarA2.b();
        int iD2 = oVar.c().d();
        com.moloco.sdk.internal.ortb.model.j jVarF = oVar.f();
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q(zF, bool, iD, iD2, (jVarF == null || (kVarD = jVarF.d()) == null || (c0VarA = kVarD.a()) == null) ? 0 : c0VarA.g(), z11, z12, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.b((1023 & 1) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : 0L, (1023 & 2) != 0 ? k.i.f21111g : new d(oVar), (1023 & 4) != 0 ? k.j.f21112g : f(oVar.c(), z10, oVar.d()), (1023 & 8) != 0 ? k.C0456k.f21113g : new C0301e(oVar), (1023 & 16) != 0 ? k.l.f21114g : new f(z10, oVar), (1023 & 32) != 0 ? null : o.b(oVar.k()), (1023 & 64) != 0 ? k.m.f21115g : new g(z10, oVar), (1023 & 128) != 0 ? k.n.f21116g : new h(oVar), (1023 & 256) != 0 ? k.o.f21117g : null, (1023 & 512) != 0 ? a.h.f18920a.h() : null));
    }

    public static final com.moloco.sdk.internal.ortb.model.o p() {
        return (com.moloco.sdk.internal.ortb.model.o) f17606a.getValue();
    }
}
