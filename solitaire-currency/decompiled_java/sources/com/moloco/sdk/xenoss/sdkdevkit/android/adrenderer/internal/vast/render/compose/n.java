package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import h9.p;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z8.g f21162a = com.moloco.sdk.internal.scheduling.c.a().getMain();

    public static final class a extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21163g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ o0 f21164h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f21165i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f21166j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ State<h9.l<Boolean, k0>> f21167k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ State<h9.l<Boolean, k0>> f21168l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ State<h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0>> f21169m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ State<h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0>> f21170n;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$a$a, reason: collision with other inner class name */
        public static final class C0458a implements DisposableEffectResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f21171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21172b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ State f21173c;

            public C0458a(List list, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, State state) {
                this.f21171a = list;
                this.f21172b = fVar;
                this.f21173c = state;
            }

            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Iterator it = this.f21171a.iterator();
                while (it.hasNext()) {
                    b2.a.a((b2) it.next(), null, 1, null);
                }
                this.f21172b.destroy();
                n.a(this.f21173c).invoke(Boolean.FALSE);
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$jobs$1", f = "VastVideoPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class b extends kotlin.coroutines.jvm.internal.l implements p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21174j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f21175k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ MutableState<Boolean> f21176l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ MutableState<Boolean> f21177m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21178n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ State<h9.l<Boolean, k0>> f21179o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ State<h9.l<Boolean, k0>> f21180p;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, State<? extends h9.l<? super Boolean, k0>> state, State<? extends h9.l<? super Boolean, k0>> state2, z8.d<? super b> dVar) {
                super(2, dVar);
                this.f21176l = mutableState;
                this.f21177m = mutableState2;
                this.f21178n = fVar;
                this.f21179o = state;
                this.f21180p = state2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                b bVar = new b(this.f21176l, this.f21177m, this.f21178n, this.f21179o, this.f21180p, dVar);
                bVar.f21175k = obj;
                return bVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b bVar, @Nullable z8.d<? super k0> dVar) {
                return ((b) create(bVar, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21174j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.b) this.f21175k;
                n.a(this.f21179o).invoke(kotlin.coroutines.jvm.internal.b.a(bVar.b()));
                this.f21176l.setValue(kotlin.coroutines.jvm.internal.b.a(bVar.b()));
                this.f21177m.setValue(kotlin.coroutines.jvm.internal.b.a(bVar.a()));
                n.e(this.f21180p).invoke(kotlin.coroutines.jvm.internal.b.a(bVar.c()));
                View viewF = this.f21178n.F();
                if (viewF != null) {
                    viewF.setKeepScreenOn(bVar.a());
                }
                return k0.f35197a;
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$jobs$2", f = "VastVideoPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class c extends kotlin.coroutines.jvm.internal.l implements p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21181j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f21182k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ State<h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0>> f21183l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public c(State<? extends h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0>> state, z8.d<? super c> dVar) {
                super(2, dVar);
                this.f21183l = state;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                c cVar = new c(this.f21183l, dVar);
                cVar.f21182k = obj;
                return cVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, @Nullable z8.d<? super k0> dVar) {
                return ((c) create(iVar, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21181j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                n.g(this.f21183l).invoke((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i) this.f21182k);
                return k0.f35197a;
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$1$jobs$3", f = "VastVideoPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class d extends kotlin.coroutines.jvm.internal.l implements p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21184j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f21185k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ State<h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0>> f21186l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public d(State<? extends h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0>> state, z8.d<? super d> dVar) {
                super(2, dVar);
                this.f21186l = state;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                d dVar2 = new d(this.f21186l, dVar);
                dVar2.f21185k = obj;
                return dVar2;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l lVar, @Nullable z8.d<? super k0> dVar) {
                return ((d) create(lVar, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21184j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                n.h(this.f21186l).invoke((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l) this.f21185k);
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, o0 o0Var, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, State<? extends h9.l<? super Boolean, k0>> state, State<? extends h9.l<? super Boolean, k0>> state2, State<? extends h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0>> state3, State<? extends h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0>> state4) {
            super(1);
            this.f21163g = fVar;
            this.f21164h = o0Var;
            this.f21165i = mutableState;
            this.f21166j = mutableState2;
            this.f21167k = state;
            this.f21168l = state2;
            this.f21169m = state3;
            this.f21170n = state4;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            return new C0458a(kotlin.collections.v.n(s9.j.D(s9.j.G(this.f21163g.isPlaying(), new b(this.f21165i, this.f21166j, this.f21163g, this.f21167k, this.f21168l, null)), this.f21164h), s9.j.D(s9.j.G(this.f21163g.o(), new c(this.f21169m, null)), this.f21164h), s9.j.D(s9.j.G(s9.j.u(this.f21163g.e()), new d(this.f21170n, null)), this.f21164h)), this.f21163g, this.f21167k);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$2", f = "VastVideoPlayer.kt", l = {112, 114}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f21187j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f21188k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21189l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f21189l = fVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f21189l, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r7.f21188k
                r2 = 0
                r3 = 2
                r4 = 4
                r5 = 1
                if (r1 == 0) goto L29
                if (r1 == r5) goto L20
                if (r1 != r3) goto L18
                java.lang.Object r0 = r7.f21187j
                android.view.View r0 = (android.view.View) r0
                v8.u.b(r8)
                goto L59
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L20:
                java.lang.Object r1 = r7.f21187j
                android.view.View r1 = (android.view.View) r1
                v8.u.b(r8)
                r8 = r1
                goto L45
            L29:
                v8.u.b(r8)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f r8 = r7.f21189l
                android.view.View r8 = r8.F()
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f r1 = r7.f21189l
                if (r8 != 0) goto L37
                goto L3a
            L37:
                r8.setVisibility(r4)
            L3a:
                r7.f21187j = r8
                r7.f21188k = r5
                java.lang.Object r1 = r1.a(r7)
                if (r1 != r0) goto L45
                return r0
            L45:
                if (r8 != 0) goto L48
                goto L4b
            L48:
                r8.setVisibility(r2)
            L4b:
                r7.f21187j = r8
                r7.f21188k = r3
                r5 = 50
                java.lang.Object r1 = kotlinx.coroutines.y0.a(r5, r7)
                if (r1 != r0) goto L58
                return r0
            L58:
                r0 = r8
            L59:
                if (r0 != 0) goto L5c
                goto L5f
            L5c:
                r0.setVisibility(r4)
            L5f:
                if (r0 != 0) goto L62
                goto L65
            L62:
                r0.setVisibility(r2)
            L65:
                v8.k0 r8 = v8.k0.f35197a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$3", f = "VastVideoPlayer.kt", l = {121}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21190j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21191k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f21192l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> f21193m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> f21194n;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$3$1", f = "VastVideoPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21195j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21196k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ String f21197l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> f21198m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> f21199n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f21196k = fVar;
                this.f21197l = str;
                this.f21198m = mVar;
                this.f21199n = mVar2;
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
                return new a(this.f21196k, this.f21197l, this.f21198m, this.f21199n, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21195j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar = this.f21196k;
                String str = this.f21197l;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar = this.f21198m;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2 = this.f21199n;
                fVar.a(str);
                fVar.seekTo(mVar.a().longValue());
                n.f(fVar, mVar2);
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar2, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f21191k = fVar;
            this.f21192l = str;
            this.f21193m = mVar;
            this.f21194n = mVar2;
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
            return new c(this.f21191k, this.f21192l, this.f21193m, this.f21194n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21190j;
            if (i10 == 0) {
                u.b(obj);
                z8.g gVar = n.f21162a;
                a aVar = new a(this.f21191k, this.f21192l, this.f21193m, this.f21194n, null);
                this.f21190j = 1;
                if (kotlinx.coroutines.i.g(gVar, aVar, this) == objE) {
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

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$4", f = "VastVideoPlayer.kt", l = {135}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21200j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21201k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> f21202l;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$4$1", f = "VastVideoPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21203j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21204k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> f21205l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f21204k = fVar;
                this.f21205l = mVar;
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
                return new a(this.f21204k, this.f21205l, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21203j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                n.f(this.f21204k, this.f21205l);
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f21201k = fVar;
            this.f21202l = mVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new d(this.f21201k, this.f21202l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21200j;
            if (i10 == 0) {
                u.b(obj);
                z8.g gVar = n.f21162a;
                a aVar = new a(this.f21201k, this.f21202l, null);
                this.f21200j = 1;
                if (kotlinx.coroutines.i.g(gVar, aVar, this) == objE) {
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

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$5", f = "VastVideoPlayer.kt", l = {143}, m = "invokeSuspend")
    public static final class e extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21206j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21207k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ boolean f21208l;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastVideoPlayerKt$VastVideoPlayer$5$1", f = "VastVideoPlayer.kt", l = {}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21209j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f f21210k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ boolean f21211l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, boolean z10, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f21210k = fVar;
                this.f21211l = z10;
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
                return new a(this.f21210k, this.f21211l, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21209j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                this.f21210k.a(this.f21211l);
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, boolean z10, z8.d<? super e> dVar) {
            super(2, dVar);
            this.f21207k = fVar;
            this.f21208l = z10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((e) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new e(this.f21207k, this.f21208l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21206j;
            if (i10 == 0) {
                u.b(obj);
                z8.g gVar = n.f21162a;
                a aVar = new a(this.f21207k, this.f21208l, null);
                this.f21206j = 1;
                if (kotlinx.coroutines.i.g(gVar, aVar, this) == objE) {
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

    public static final class f extends v implements h9.l<Context, FrameLayout> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ View f21212g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(View view) {
            super(1);
            this.f21212g = view;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FrameLayout invoke(@NotNull Context it) {
            t.i(it, "it");
            FrameLayout frameLayout = new FrameLayout(it);
            frameLayout.addView(this.f21212g, new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }
    }

    public static final class g extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f21213g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f21214h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> f21215i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> f21216j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f21217k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.l<Boolean, k0> f21218l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ h9.l<Boolean, k0> f21219m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t f21220n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0> f21221o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0> f21222p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ Modifier f21223q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ int f21224r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ int f21225s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ int f21226t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(String str, boolean z10, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> mVar2, boolean z11, h9.l<? super Boolean, k0> lVar, h9.l<? super Boolean, k0> lVar2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar, h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0> lVar3, h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0> lVar4, Modifier modifier, int i10, int i11, int i12) {
            super(2);
            this.f21213g = str;
            this.f21214h = z10;
            this.f21215i = mVar;
            this.f21216j = mVar2;
            this.f21217k = z11;
            this.f21218l = lVar;
            this.f21219m = lVar2;
            this.f21220n = tVar;
            this.f21221o = lVar3;
            this.f21222p = lVar4;
            this.f21223q = modifier;
            this.f21224r = i10;
            this.f21225s = i11;
            this.f21226t = i12;
        }

        public final void a(@Nullable Composer composer, int i10) {
            n.d(this.f21213g, this.f21214h, this.f21215i, this.f21216j, this.f21217k, this.f21218l, this.f21219m, this.f21220n, this.f21221o, this.f21222p, this.f21223q, composer, this.f21224r | 1, this.f21225s, this.f21226t);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class h extends v implements h9.a<MutableState<Boolean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final h f21227g = new h();

        public h() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MutableState<Boolean> invoke() {
            return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        }
    }

    public static final class i extends v implements h9.a<MutableState<Boolean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final i f21228g = new i();

        public i() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MutableState<Boolean> invoke() {
            return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        }
    }

    public static final h9.l<Boolean, k0> a(State<? extends h9.l<? super Boolean, k0>> state) {
        return (h9.l) state.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012b  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(@org.jetbrains.annotations.NotNull java.lang.String r34, boolean r35, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<java.lang.Boolean> r36, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<java.lang.Long> r37, boolean r38, @org.jetbrains.annotations.NotNull h9.l<? super java.lang.Boolean, v8.k0> r39, @org.jetbrains.annotations.NotNull h9.l<? super java.lang.Boolean, v8.k0> r40, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t r41, @org.jetbrains.annotations.NotNull h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, v8.k0> r42, @org.jetbrains.annotations.NotNull h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, v8.k0> r43, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r44, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r45, int r46, int r47, int r48) {
        /*
            Method dump skipped, instruction units count: 822
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.d(java.lang.String, boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m, boolean, h9.l, h9.l, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t, h9.l, h9.l, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final h9.l<Boolean, k0> e(State<? extends h9.l<? super Boolean, k0>> state) {
        return (h9.l) state.getValue();
    }

    public static final void f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar) {
        if (mVar.a().booleanValue()) {
            fVar.play();
        } else {
            fVar.pause();
        }
    }

    public static final h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0> g(State<? extends h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0>> state) {
        return (h9.l) state.getValue();
    }

    public static final h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0> h(State<? extends h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0>> state) {
        return (h9.l) state.getValue();
    }
}
