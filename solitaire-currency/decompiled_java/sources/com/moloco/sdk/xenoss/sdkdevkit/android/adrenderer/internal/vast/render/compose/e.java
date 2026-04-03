package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.p;
import h9.s;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.LinearKt$Linear$1", f = "Linear.kt", l = {43}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20927j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20928k;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.e$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.LinearKt$Linear$1$1", f = "Linear.kt", l = {}, m = "invokeSuspend")
        public static final class C0447a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f20929j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20930k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0447a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, z8.d<? super C0447a> dVar) {
                super(2, dVar);
                this.f20930k = kVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C0447a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0447a(this.f20930k, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f20929j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                this.f20930k.b();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f20928k = kVar;
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
            return new a(this.f20928k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20927j;
            if (i10 == 0) {
                u.b(obj);
                z8.g main = com.moloco.sdk.internal.scheduling.c.a().getMain();
                C0447a c0447a = new C0447a(this.f20928k, null);
                this.f20927j = 1;
                if (kotlinx.coroutines.i.g(main, c0447a, this) == objE) {
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

    public static final class b extends v implements h9.l<Boolean, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20931g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f20932h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, MutableState<Boolean> mutableState) {
            super(1);
            this.f20931g = kVar;
            this.f20932h = mutableState;
        }

        public final void a(boolean z10) {
            this.f20931g.N(z10);
            e.e(this.f20932h, z10);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Boolean bool) {
            a(bool.booleanValue());
            return k0.f35197a;
        }
    }

    public static final class c extends v implements h9.l<Boolean, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20933g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar) {
            super(1);
            this.f20933g = kVar;
        }

        public final void a(boolean z10) {
            if (z10) {
                this.f20933g.O();
            } else {
                this.f20933g.P();
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Boolean bool) {
            a(bool.booleanValue());
            return k0.f35197a;
        }
    }

    public static final class d extends v implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20934g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> f20935h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> mutableState) {
            super(1);
            this.f20934g = kVar;
            this.f20935h = mutableState;
        }

        public final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i it) {
            t.i(it, "it");
            this.f20934g.H(it);
            e.c(this.f20935h, it);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
            a(iVar);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.e$e, reason: collision with other inner class name */
    public /* synthetic */ class C0448e extends q implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l, k0> {
        public C0448e(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.class, "onError", "onError(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/errors/VastAdShowError;)V", 0);
        }

        public final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l p02) {
            t.i(p02, "p0");
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k) this.receiver).I(p02);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l lVar) {
            a(lVar);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.LinearKt$Linear$2$5", f = "Linear.kt", l = {93}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20936j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20937k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20938l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20939m;

        public static final class a extends v implements p<Offset, Offset, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f20940g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20941h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h9.a<k0> aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar) {
                super(2);
                this.f20940g = aVar;
                this.f20941h = kVar;
            }

            public final void a(long j10, long j11) {
                k0 k0Var;
                h9.a<k0> aVar = this.f20940g;
                if (aVar != null) {
                    aVar.invoke();
                    k0Var = k0.f35197a;
                } else {
                    k0Var = null;
                }
                if (k0Var == null) {
                    this.f20941h.L(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c.f20066a.c(j10));
                }
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Offset offset, Offset offset2) {
                a(offset.m1377unboximpl(), offset2.m1377unboximpl());
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(h9.a<k0> aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, z8.d<? super f> dVar) {
            super(2, dVar);
            this.f20938l = aVar;
            this.f20939m = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            f fVar = new f(this.f20938l, this.f20939m, dVar);
            fVar.f20937k = obj;
            return fVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((f) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20936j;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.f20937k;
                a aVar = new a(this.f20938l, this.f20939m);
                this.f20936j = 1;
                if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b.b(pointerInputScope, aVar, this) == objE) {
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

    public static final class g extends v implements h9.l<Boolean, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>> f20942g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>> mutableState) {
            super(1);
            this.f20942g = mutableState;
        }

        public final void a(boolean z10) {
            e.d(this.f20942g, new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m(Boolean.valueOf(z10)));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Boolean bool) {
            a(bool.booleanValue());
            return k0.f35197a;
        }
    }

    public static final class h extends v implements p<a.AbstractC0481a.c, a.AbstractC0481a.c.EnumC0483a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20943g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar) {
            super(2);
            this.f20943g = kVar;
        }

        public final void a(@NotNull a.AbstractC0481a.c button, @NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
            t.i(button, "button");
            t.i(buttonType, "buttonType");
            this.f20943g.g(button);
            this.f20943g.j(buttonType);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(a.AbstractC0481a.c cVar, a.AbstractC0481a.c.EnumC0483a enumC0483a) {
            a(cVar, enumC0483a);
            return k0.f35197a;
        }
    }

    public /* synthetic */ class i extends q implements h9.l<Boolean, k0> {
        public i(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.class, "onMuteChange", "onMuteChange(Z)V", 0);
        }

        public final void a(boolean z10) {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k) this.receiver).b(z10);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Boolean bool) {
            a(bool.booleanValue());
            return k0.f35197a;
        }
    }

    public /* synthetic */ class j extends q implements h9.a<k0> {
        public j(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.class, "onVastPrivacyIconDisplayed", "onVastPrivacyIconDisplayed()V", 0);
        }

        public final void c() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k) this.receiver).h();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            c();
            return k0.f35197a;
        }
    }

    public /* synthetic */ class k extends q implements h9.a<k0> {
        public k(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k.class, "onVastPrivacyIconClick", "onVastPrivacyIconClick()V", 0);
        }

        public final void c() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k) this.receiver).v();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            c();
            return k0.f35197a;
        }
    }

    public static final class l extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20944g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20945h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Modifier f20946i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h9.u<BoxScope, Boolean, Boolean, p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, h9.l<? super Boolean, k0>, Composer, Integer, k0> f20947j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ s<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, k0> f20948k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> f20949l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ h9.u<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, h9.l<? super Boolean, k0>, h9.a<k0>, Composer, Integer, k0> f20950m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t f20951n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f20952o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ int f20953p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ int f20954q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public l(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVar, h9.a<k0> aVar, Modifier modifier, h9.u<? super BoxScope, ? super Boolean, ? super Boolean, ? super p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, ? super h9.l<? super Boolean, k0>, ? super Composer, ? super Integer, k0> uVar, s<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, k0> sVar, h9.t<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> tVar, h9.u<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super Boolean, k0>, ? super h9.a<k0>, ? super Composer, ? super Integer, k0> uVar2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar2, h9.a<k0> aVar2, int i10, int i11) {
            super(2);
            this.f20944g = kVar;
            this.f20945h = aVar;
            this.f20946i = modifier;
            this.f20947j = uVar;
            this.f20948k = sVar;
            this.f20949l = tVar;
            this.f20950m = uVar2;
            this.f20951n = tVar2;
            this.f20952o = aVar2;
            this.f20953p = i10;
            this.f20954q = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            e.f(this.f20944g, this.f20945h, this.f20946i, this.f20947j, this.f20948k, this.f20949l, this.f20950m, this.f20951n, this.f20952o, composer, this.f20953p | 1, this.f20954q);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class m extends v implements h9.t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<? extends k0>, h9.a<? extends k0>, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Alignment f20955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ PaddingValues f20956h;

        public static final class a extends v implements h9.q<AnimatedVisibilityScope, Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j f20957g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f20958h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f20959i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ int f20960j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, h9.a<k0> aVar, h9.a<k0> aVar2, int i10) {
                super(3);
                this.f20957g = jVar;
                this.f20958h = aVar;
                this.f20959i = aVar2;
                this.f20960j = i10;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@NotNull AnimatedVisibilityScope AnimatedVisibility, @Nullable Composer composer, int i10) {
                t.i(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(366008667, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastIcon.<anonymous>.<anonymous> (Linear.kt:154)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar = this.f20957g;
                if (jVar != null) {
                    h9.a<k0> aVar = this.f20958h;
                    h9.a<k0> aVar2 = this.f20959i;
                    int i11 = this.f20960j >> 3;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i.a(jVar, aVar, aVar2, null, composer, (i11 & 112) | (i11 & 896), 8);
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
        public m(Alignment alignment, PaddingValues paddingValues) {
            super(6);
            this.f20955g = alignment;
            this.f20956h = paddingValues;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull BoxScope boxScope, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, @NotNull h9.a<k0> onDisplayed, @NotNull h9.a<k0> onClick, @Nullable Composer composer, int i10) {
            int i11;
            t.i(boxScope, "$this$null");
            t.i(onDisplayed, "onDisplayed");
            t.i(onClick, "onClick");
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(boxScope) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i10 & 112) == 0) {
                i11 |= composer.changed(jVar) ? 32 : 16;
            }
            if ((i10 & 896) == 0) {
                i11 |= composer.changed(onDisplayed) ? 256 : 128;
            }
            if ((i10 & 7168) == 0) {
                i11 |= composer.changed(onClick) ? 2048 : 1024;
            }
            if ((46811 & i11) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(230981251, i11, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastIcon.<anonymous> (Linear.kt:148)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(jVar != null, PaddingKt.padding(boxScope.align(Modifier.Companion, this.f20955g), this.f20956h), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 366008667, true, new a(jVar, onDisplayed, onClick, i11)), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.t
        public /* bridge */ /* synthetic */ k0 invoke(BoxScope boxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, h9.a<? extends k0> aVar, h9.a<? extends k0> aVar2, Composer composer, Integer num) {
            a(boxScope, jVar, aVar, aVar2, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long> a(State<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Long>> state) {
        return state.getValue();
    }

    @Composable
    @NotNull
    public static final h9.t<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, h9.a<k0>, h9.a<k0>, Composer, Integer, k0> b(@Nullable Alignment alignment, @Nullable PaddingValues paddingValues, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1649000562);
        if ((i11 & 1) != 0) {
            alignment = Alignment.Companion.getBottomStart();
        }
        if ((i11 & 2) != 0) {
            paddingValues = PaddingKt.m392PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1649000562, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastIcon (Linear.kt:145)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 230981251, true, new m(alignment, paddingValues));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final void c(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> mutableState, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar) {
        mutableState.setValue(iVar);
    }

    public static final void d(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>> mutableState, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> mVar) {
        mutableState.setValue(mVar);
    }

    public static final void e(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k r38, @org.jetbrains.annotations.Nullable h9.a<v8.k0> r39, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r40, @org.jetbrains.annotations.Nullable h9.u<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super h9.p<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0481a.c.EnumC0483a, v8.k0>, ? super h9.l<? super java.lang.Boolean, v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r41, @org.jetbrains.annotations.Nullable h9.s<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r42, @org.jetbrains.annotations.Nullable h9.t<? super androidx.compose.foundation.layout.BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super h9.a<v8.k0>, ? super h9.a<v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r43, @org.jetbrains.annotations.Nullable h9.u<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super h9.l<? super java.lang.Boolean, v8.k0>, ? super h9.a<v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r44, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t r45, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r46, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r47, int r48, int r49) {
        /*
            Method dump skipped, instruction units count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.e.f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k, h9.a, androidx.compose.ui.Modifier, h9.u, h9.s, h9.t, h9.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t, h9.a, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final boolean g(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i h(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i> mutableState) {
        return mutableState.getValue();
    }

    public static final boolean l(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j m(State<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> state) {
        return state.getValue();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean> n(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m<Boolean>> mutableState) {
        return mutableState.getValue();
    }
}
