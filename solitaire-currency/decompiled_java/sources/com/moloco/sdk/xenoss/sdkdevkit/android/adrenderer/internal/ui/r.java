package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
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
public final class r {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButtonKt$LifecycleAwareAdCountdownButton$1$1", f = "LifecycleAwareAdCountdownButton.kt", l = {46}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19929j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ State<c0> f19930k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ State<h9.a<k0>> f19931l;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r$a$a, reason: collision with other inner class name */
        public static final class C0407a extends v implements h9.a<c0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ State<c0> f19932g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0407a(State<c0> state) {
                super(0);
                this.f19932g = state;
            }

            public final int b() {
                return r.a(this.f19932g);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ c0 invoke() {
                return c0.a(b());
            }
        }

        public static final class b implements s9.i<c0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ State<h9.a<k0>> f19933a;

            /* JADX WARN: Multi-variable type inference failed */
            public b(State<? extends h9.a<k0>> state) {
                this.f19933a = state;
            }

            @Nullable
            public final Object b(int i10, @NotNull z8.d<? super k0> dVar) {
                r.c(this.f19933a).invoke();
                return k0.f35197a;
            }

            @Override // s9.i
            public /* bridge */ /* synthetic */ Object emit(c0 c0Var, z8.d dVar) {
                return b(c0Var.g(), dVar);
            }
        }

        public static final class c implements s9.h<c0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.h f19934a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r$a$c$a, reason: collision with other inner class name */
            public static final class C0408a<T> implements s9.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ s9.i f19935a;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r$a$c$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButtonKt$LifecycleAwareAdCountdownButton$1$1$invokeSuspend$$inlined$filter$1$2", f = "LifecycleAwareAdCountdownButton.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                public static final class C0409a extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    public /* synthetic */ Object f19936j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    public int f19937k;

                    public C0409a(z8.d dVar) {
                        super(dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f19936j = obj;
                        this.f19937k |= Integer.MIN_VALUE;
                        return C0408a.this.emit(null, this);
                    }
                }

                public C0408a(s9.i iVar) {
                    this.f19935a = iVar;
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
                        boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r.a.c.C0408a.C0409a
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r$a$c$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r.a.c.C0408a.C0409a) r0
                        int r1 = r0.f19937k
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f19937k = r1
                        goto L18
                    L13:
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r$a$c$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r$a$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f19936j
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.f19937k
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
                        s9.i r6 = r4.f19935a
                        r2 = r5
                        v8.c0 r2 = (v8.c0) r2
                        int r2 = r2.g()
                        if (r2 != 0) goto L48
                        r0.f19937k = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        v8.k0 r5 = v8.k0.f35197a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r.a.c.C0408a.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            public c(s9.h hVar) {
                this.f19934a = hVar;
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull s9.i<? super c0> iVar, @NotNull z8.d dVar) {
                Object objCollect = this.f19934a.collect(new C0408a(iVar), dVar);
                return objCollect == a9.d.e() ? objCollect : k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(State<c0> state, State<? extends h9.a<k0>> state2, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f19930k = state;
            this.f19931l = state2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new a(this.f19930k, this.f19931l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19929j;
            if (i10 == 0) {
                u.b(obj);
                c cVar = new c(SnapshotStateKt.snapshotFlow(new C0407a(this.f19930k)));
                b bVar = new b(this.f19931l);
                this.f19929j = 1;
                if (cVar.collect(bVar, this) == objE) {
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

    public static final class b extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ BoxScope f19939g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<c0> f19940h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f19941i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f19942j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19943k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f19944l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ h9.l<a.AbstractC0481a.c, k0> f19945m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f19946n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ boolean f19947o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f19948p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<c0> mVar, boolean z10, boolean z11, h9.a<k0> aVar, h9.a<k0> aVar2, h9.l<? super a.AbstractC0481a.c, k0> lVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, boolean z12, int i10) {
            super(2);
            this.f19939g = boxScope;
            this.f19940h = mVar;
            this.f19941i = z10;
            this.f19942j = z11;
            this.f19943k = aVar;
            this.f19944l = aVar2;
            this.f19945m = lVar;
            this.f19946n = bVar;
            this.f19947o = z12;
            this.f19948p = i10;
        }

        public final void a(@Nullable Composer composer, int i10) {
            r.b(this.f19939g, this.f19940h, this.f19941i, this.f19942j, this.f19943k, this.f19944l, this.f19945m, this.f19946n, this.f19947o, composer, this.f19948p | 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final int a(State<c0> state) {
        return state.getValue().g();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void b(@NotNull BoxScope boxScope, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<c0> initialSecondsLeft, boolean z10, boolean z11, @NotNull h9.a<k0> onCountdownFinished, @NotNull h9.a<k0> onClick, @NotNull h9.l<? super a.AbstractC0481a.c, k0> onButtonRendered, @NotNull h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> basedOnAdCountdownButton, boolean z12, @Nullable Composer composer, int i10) {
        int i11;
        Composer composer2;
        kotlin.jvm.internal.t.i(boxScope, "<this>");
        kotlin.jvm.internal.t.i(initialSecondsLeft, "initialSecondsLeft");
        kotlin.jvm.internal.t.i(onCountdownFinished, "onCountdownFinished");
        kotlin.jvm.internal.t.i(onClick, "onClick");
        kotlin.jvm.internal.t.i(onButtonRendered, "onButtonRendered");
        kotlin.jvm.internal.t.i(basedOnAdCountdownButton, "basedOnAdCountdownButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1386467363);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(initialSecondsLeft) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i10 & 7168) == 0) {
            i11 |= composerStartRestartGroup.changed(z11) ? 2048 : 1024;
        }
        if ((i10 & 57344) == 0) {
            i11 |= composerStartRestartGroup.changed(onCountdownFinished) ? 16384 : 8192;
        }
        if ((i10 & 458752) == 0) {
            i11 |= composerStartRestartGroup.changed(onClick) ? 131072 : 65536;
        }
        if ((3670016 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(onButtonRendered) ? 1048576 : 524288;
        }
        if ((29360128 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(basedOnAdCountdownButton) ? 8388608 : 4194304;
        }
        if ((i10 & 234881024) == 0) {
            i11 |= composerStartRestartGroup.changed(z12) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i11;
        if ((191739611 & i12) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1386467363, i12, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.LifecycleAwareAdCountdownButton (LifecycleAwareAdCountdownButton.kt:24)");
            }
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(z8.h.f37608a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composerStartRestartGroup.endReplaceableGroup();
            o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(initialSecondsLeft);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.n.b(initialSecondsLeft.a().g(), coroutineScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle((m0) objRememberedValue2, (LifecycleOwner) null, (Lifecycle.State) null, (z8.g) null, composerStartRestartGroup, 8, 7);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onCountdownFinished, composerStartRestartGroup, (i12 >> 12) & 14);
            k0 k0Var = k0.f35197a;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new a(stateCollectAsStateWithLifecycle, stateRememberUpdatedState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(k0Var, (h9.p<? super o0, ? super z8.d<? super k0>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 70);
            Boolean boolValueOf = Boolean.valueOf(z11);
            Boolean boolValueOf2 = Boolean.valueOf(z10);
            Boolean boolValueOf3 = Boolean.valueOf(z12);
            c0 c0VarA = initialSecondsLeft.a();
            c0 c0VarA2 = c0.a(a(stateCollectAsStateWithLifecycle));
            int i13 = i12 & 14;
            int i14 = i12 >> 6;
            composer2 = composerStartRestartGroup;
            basedOnAdCountdownButton.invoke(boxScope, boolValueOf, boolValueOf2, onClick, onButtonRendered, boolValueOf3, c0VarA, c0VarA2, composer2, Integer.valueOf(i13 | (i14 & 112) | (i12 & 896) | (i14 & 7168) | (i14 & 57344) | ((i12 >> 9) & 458752) | ((i12 << 3) & 234881024)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(boxScope, initialSecondsLeft, z10, z11, onCountdownFinished, onClick, onButtonRendered, basedOnAdCountdownButton, z12, i10));
    }

    public static final h9.a<k0> c(State<? extends h9.a<k0>> state) {
        return state.getValue();
    }
}
