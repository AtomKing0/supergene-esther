package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import android.content.Context;
import androidx.media3.exoplayer.RendererCapabilities;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.p;
import java.util.List;
import kotlin.collections.d0;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import s9.y;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImplKt$isLinearPlaylistItemPlayingFlow$1", f = "AdPlaylistControllerImpl.kt", l = {380}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20812j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ s9.h<k> f20813k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ y<Boolean> f20814l;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImplKt$isLinearPlaylistItemPlayingFlow$1$1", f = "AdPlaylistControllerImpl.kt", l = {RendererCapabilities.DECODER_SUPPORT_MASK}, m = "invokeSuspend")
        public static final class C0432a extends l implements p<k, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f20815j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f20816k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ y<Boolean> f20817l;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g$a$a$a, reason: collision with other inner class name */
            public static final class C0433a implements s9.i<Boolean> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ y<Boolean> f20818a;

                public C0433a(y<Boolean> yVar) {
                    this.f20818a = yVar;
                }

                @Nullable
                public final Object b(boolean z10, @NotNull z8.d<? super k0> dVar) {
                    this.f20818a.setValue(kotlin.coroutines.jvm.internal.b.a(z10));
                    return k0.f35197a;
                }

                @Override // s9.i
                public /* bridge */ /* synthetic */ Object emit(Boolean bool, z8.d dVar) {
                    return b(bool.booleanValue(), dVar);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0432a(y<Boolean> yVar, z8.d<? super C0432a> dVar) {
                super(2, dVar);
                this.f20817l = yVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C0432a c0432a = new C0432a(this.f20817l, dVar);
                c0432a.f20816k = obj;
                return c0432a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@Nullable k kVar, @Nullable z8.d<? super k0> dVar) {
                return ((C0432a) create(kVar, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f20815j;
                if (i10 == 0) {
                    u.b(obj);
                    k kVar = (k) this.f20816k;
                    if (!(kVar instanceof k.c)) {
                        this.f20817l.setValue(null);
                        return k0.f35197a;
                    }
                    m0<Boolean> m0VarIsPlaying = ((k.c) kVar).a().isPlaying();
                    C0433a c0433a = new C0433a(this.f20817l);
                    this.f20815j = 1;
                    if (m0VarIsPlaying.collect(c0433a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                throw new v8.h();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(s9.h<? extends k> hVar, y<Boolean> yVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f20813k = hVar;
            this.f20814l = yVar;
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
            return new a(this.f20813k, this.f20814l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20812j;
            if (i10 == 0) {
                u.b(obj);
                s9.h<k> hVar = this.f20813k;
                C0432a c0432a = new C0432a(this.f20814l, null);
                this.f20812j = 1;
                if (s9.j.l(hVar, c0432a, this) == objE) {
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

    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c mraidAdData, @NotNull z externalLinkHandler, @NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j mraidFullscreenContentController, int i10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService) {
        t.i(mraidAdData, "mraidAdData");
        t.i(externalLinkHandler, "externalLinkHandler");
        t.i(context, "context");
        t.i(mraidFullscreenContentController, "mraidFullscreenContentController");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        return new f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.d.a(mraidAdData, mraidFullscreenContentController, i10, context, externalLinkHandler, customUserEventBuilderService), null);
    }

    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a b(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a ad, @NotNull z externalLinkHandler, @NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, boolean z10, @Nullable Boolean bool, int i10, int i11, int i12, boolean z11, boolean z12) {
        t.i(ad, "ad");
        t.i(externalLinkHandler, "externalLinkHandler");
        t.i(context, "context");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        return new f(j.a(ad, externalLinkHandler, context, customUserEventBuilderService, z10, bool, i10, i11, i12, z11, z12), new h(ad.f(), ad.g().i().b(), ad.e(), null, 8, null));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a g(List<? extends k> list, k kVar) {
        k kVar2 = (k) d0.l0(list, d0.n0(list, kVar) + 1);
        k.b bVar = kVar2 instanceof k.b ? (k.b) kVar2 : null;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public static final a.AbstractC0481a.c.EnumC0483a h(List<? extends k> list, k kVar, a.AbstractC0481a.c.EnumC0483a enumC0483a) {
        return (enumC0483a != a.AbstractC0481a.c.EnumC0483a.SKIP || g(list, kVar) == null) ? enumC0483a : a.AbstractC0481a.c.EnumC0483a.SKIP_DEC;
    }

    public static final a.AbstractC0481a.c i(List<? extends k> list, k kVar, a.AbstractC0481a.c cVar) {
        a.AbstractC0481a.c.EnumC0483a enumC0483aH = h(list, kVar, cVar.c());
        return enumC0483aH == cVar.c() ? cVar : a.AbstractC0481a.c.b(cVar, enumC0483aH, null, null, 6, null);
    }

    public static final s9.h<Boolean> j(s9.h<? extends k> hVar, o0 o0Var) {
        y yVarA = s9.o0.a(null);
        kotlinx.coroutines.k.d(o0Var, null, null, new a(hVar, yVarA, null), 3, null);
        return yVarA;
    }
}
