package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.c0;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    public static final class a extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ BoxScope f19842g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f19843h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f19844i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f19845j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f19846k;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0402a extends kotlin.jvm.internal.q implements h9.a<k0> {
            public C0402a(Object obj) {
                super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "goNextAdPartOrDismissAd", "goNextAdPartOrDismissAd()V", 0);
            }

            public final void c() {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).y();
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                c();
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, boolean z10, int i10) {
            super(2);
            this.f19842g = boxScope;
            this.f19843h = iVar;
            this.f19844i = bVar;
            this.f19845j = z10;
            this.f19846k = i10;
        }

        @Composable
        public final void a(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1306582385, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdGoNextButton.<anonymous>.<anonymous> (AdGoNextButton.kt:46)");
            }
            g.d(this.f19842g, this.f19843h.l(), new C0402a(this.f19843h), new b(this.f19843h), this.f19844i, this.f19845j, composer, (this.f19846k & 14) | 64);
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

    public static final class b extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ BoxScope f19847g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f19848h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ i.a f19849i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f19850j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f19851k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f19852l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, i.a aVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar2, int i10) {
            super(2);
            this.f19847g = boxScope;
            this.f19848h = iVar;
            this.f19849i = aVar;
            this.f19850j = bVar;
            this.f19851k = bVar2;
            this.f19852l = i10;
        }

        public final void a(@Nullable Composer composer, int i10) {
            g.c(this.f19847g, this.f19848h, this.f19849i, this.f19850j, this.f19851k, composer, this.f19852l | 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdGoNextButtonKt$GoNextButton$1$1", f = "AdGoNextButton.kt", l = {87}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19853j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ State<d.a> f19854k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ MutableState<Integer> f19855l;

        public static final class a extends v implements h9.a<Integer> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ State<d.a> f19856g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(State<? extends d.a> state) {
                super(0);
                this.f19856g = state;
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                d.a aVarB = g.b(this.f19856g);
                d.a.b bVar = aVarB instanceof d.a.b ? (d.a.b) aVarB : null;
                return Integer.valueOf(bVar != null ? bVar.a() : 0);
            }
        }

        public static final class b implements s9.i<Integer> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MutableState<Integer> f19857a;

            public b(MutableState<Integer> mutableState) {
                this.f19857a = mutableState;
            }

            @Nullable
            public final Object b(int i10, @NotNull z8.d<? super k0> dVar) {
                g.e(this.f19857a, i10);
                return k0.f35197a;
            }

            @Override // s9.i
            public /* bridge */ /* synthetic */ Object emit(Integer num, z8.d dVar) {
                return b(num.intValue(), dVar);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g$c$c, reason: collision with other inner class name */
        public static final class C0403c implements s9.h<Integer> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.h f19858a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g$c$c$a */
            public static final class a<T> implements s9.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ s9.i f19859a;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g$c$c$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdGoNextButtonKt$GoNextButton$1$1$invokeSuspend$$inlined$filter$1$2", f = "AdGoNextButton.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class C0404a extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    public /* synthetic */ Object f19860j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    public int f19861k;

                    public C0404a(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f19860j = obj;
                        this.f19861k |= Integer.MIN_VALUE;
                        return a.this.emit(null, this);
                    }
                }

                public a(s9.i iVar) {
                    this.f19859a = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // s9.i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull z8.d r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g.c.C0403c.a.C0404a
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g$c$c$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g.c.C0403c.a.C0404a) r0
                        int r1 = r0.f19861k
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f19861k = r1
                        goto L18
                    L13:
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g$c$c$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g$c$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f19860j
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.f19861k
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        v8.u.b(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        v8.u.b(r6)
                        s9.i r6 = r4.f19859a
                        r2 = r5
                        java.lang.Number r2 = (java.lang.Number) r2
                        int r2 = r2.intValue()
                        if (r2 <= 0) goto L48
                        r0.f19861k = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        v8.k0 r5 = v8.k0.f35197a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g.c.C0403c.a.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            public C0403c(s9.h hVar) {
                this.f19858a = hVar;
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull s9.i<? super Integer> iVar, @NotNull z8.d dVar) {
                Object objCollect = this.f19858a.collect(new a(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(State<? extends d.a> state, MutableState<Integer> mutableState, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f19854k = state;
            this.f19855l = mutableState;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new c(this.f19854k, this.f19855l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19853j;
            if (i10 == 0) {
                u.b(obj);
                s9.h hVarM = s9.j.M(new C0403c(SnapshotStateKt.snapshotFlow(new a(this.f19854k))), 1);
                b bVar = new b(this.f19855l);
                this.f19853j = 1;
                if (hVarM.collect(bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    public static final class d extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ BoxScope f19863g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ m0<d.a> f19864h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19865i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h9.l<a.AbstractC0481a.c, k0> f19866j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f19867k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ boolean f19868l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f19869m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(BoxScope boxScope, m0<? extends d.a> m0Var, h9.a<k0> aVar, h9.l<? super a.AbstractC0481a.c, k0> lVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, boolean z10, int i10) {
            super(2);
            this.f19863g = boxScope;
            this.f19864h = m0Var;
            this.f19865i = aVar;
            this.f19866j = lVar;
            this.f19867k = bVar;
            this.f19868l = z10;
            this.f19869m = i10;
        }

        public final void a(@Nullable Composer composer, int i10) {
            g.d(this.f19863g, this.f19864h, this.f19865i, this.f19866j, this.f19867k, this.f19868l, composer, this.f19869m | 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final int a(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    public static final d.a b(State<? extends d.a> state) {
        return state.getValue();
    }

    @Composable
    public static final void c(@NotNull BoxScope boxScope, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel, @Nullable i.a aVar, @Nullable h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, @Nullable h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar2, @Nullable Composer composer, int i10) {
        int i11;
        h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar3;
        kotlin.jvm.internal.t.i(boxScope, "<this>");
        kotlin.jvm.internal.t.i(adViewModel, "adViewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1348191027);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(adViewModel) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(aVar) ? 256 : 128;
        }
        if ((i10 & 7168) == 0) {
            i11 |= composerStartRestartGroup.changed(bVar) ? 2048 : 1024;
        }
        if ((57344 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(bVar2) ? 16384 : 8192;
        }
        int i12 = i11;
        if ((46811 & i12) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1348191027, i12, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdGoNextButton (AdGoNextButton.kt:22)");
            }
            Boolean boolValueOf = aVar != null ? Boolean.valueOf(aVar.a()) : null;
            if (kotlin.jvm.internal.t.d(boolValueOf, Boolean.TRUE)) {
                bVar3 = bVar2;
            } else if (kotlin.jvm.internal.t.d(boolValueOf, Boolean.FALSE)) {
                bVar3 = bVar;
            } else {
                if (boolValueOf != null) {
                    throw new v8.q();
                }
                bVar3 = null;
            }
            boolean z10 = aVar instanceof i.a.C0434a;
            boolean z11 = (z10 || (aVar instanceof i.a.b) || !(aVar instanceof i.a.c)) ? false : true;
            if (bVar3 != null) {
                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1306582385, true, new a(boxScope, adViewModel, bVar3, z11, i12));
                if (z10) {
                    composerStartRestartGroup.startReplaceableGroup(659697405);
                    composableLambda.mo4invoke(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (aVar instanceof i.a.b) {
                    composerStartRestartGroup.startReplaceableGroup(659697461);
                    composableLambda.mo4invoke(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (aVar instanceof i.a.c) {
                    composerStartRestartGroup.startReplaceableGroup(659697520);
                    composableLambda.mo4invoke(composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(659697555);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(boxScope, adViewModel, aVar, bVar, bVar2, i10));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void d(BoxScope boxScope, m0<? extends d.a> m0Var, h9.a<k0> aVar, h9.l<? super a.AbstractC0481a.c, k0> lVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, boolean z10, Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1368533837);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1368533837, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.GoNextButton (AdGoNextButton.kt:70)");
        }
        State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(m0Var, (LifecycleOwner) null, (Lifecycle.State) null, (z8.g) null, composerStartRestartGroup, 8, 7);
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        k0 k0Var = k0.f35197a;
        composerStartRestartGroup.startReplaceableGroup(511388516);
        boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(mutableState);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new c(stateCollectAsStateWithLifecycle, mutableState, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(k0Var, (h9.p<? super o0, ? super z8.d<? super k0>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 70);
        int iC = c0.c(a(mutableState));
        d.a aVarB = b(stateCollectAsStateWithLifecycle);
        d.a.b bVar2 = aVarB instanceof d.a.b ? (d.a.b) aVarB : null;
        int i11 = i10 << 3;
        bVar.invoke(boxScope, Boolean.valueOf(b(stateCollectAsStateWithLifecycle) instanceof d.a.C0463a), Boolean.valueOf(!(b(stateCollectAsStateWithLifecycle) instanceof d.a.c)), aVar, lVar, Boolean.valueOf(z10), c0.a(iC), c0.a(c0.c(bVar2 != null ? bVar2.a() : 0)), composerStartRestartGroup, Integer.valueOf((i10 & 14) | (i11 & 7168) | (i11 & 57344) | (458752 & i10) | ((i10 << 12) & 234881024)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new d(boxScope, m0Var, aVar, lVar, bVar, z10, i10));
    }

    public static final void e(MutableState<Integer> mutableState, int i10) {
        mutableState.setValue(Integer.valueOf(i10));
    }
}
