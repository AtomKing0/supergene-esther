package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f19255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f19256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final e0 f19257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e f19258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j f19259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final MraidActivity.a f19260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g f19261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final o0 f19262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public b.a f19263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c f19264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19266l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19267m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19268n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19269o;

    public /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, v8.k0> {
        public a(Object obj) {
            super(1, obj, g0.class, "onError", "onError(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/errors/MraidAdError;)V", 0);
        }

        public final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d p02) {
            kotlin.jvm.internal.t.i(p02, "p0");
            ((g0) this.receiver).l(p02);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
            a(dVar);
            return v8.k0.f35197a;
        }
    }

    public static final class b extends kotlin.jvm.internal.v implements h9.a<v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c f19270g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar) {
            super(0);
            this.f19270g = cVar;
        }

        public final void b() {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar = this.f19270g;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            b();
            return v8.k0.f35197a;
        }
    }

    public /* synthetic */ class c extends kotlin.jvm.internal.q implements h9.a<v8.k0> {
        public c(Object obj) {
            super(0, obj, g0.class, "destroy", "destroy()V", 0);
        }

        public final void c() {
            ((g0) this.receiver).destroy();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            c();
            return v8.k0.f35197a;
        }
    }

    public /* synthetic */ class d extends kotlin.jvm.internal.q implements h9.a<v8.k0> {
        public d(Object obj) {
            super(0, obj, g0.class, "onForciblyClosed", "onForciblyClosed()V", 0);
        }

        public final void c() {
            ((g0) this.receiver).p();
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            c();
            return v8.k0.f35197a;
        }
    }

    public g0(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull e0 mraidAdLoader, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e mraidBaseAd, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j mraidFullscreenController, @NotNull MraidActivity.a mraidActivity) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(mraidAdLoader, "mraidAdLoader");
        kotlin.jvm.internal.t.i(mraidBaseAd, "mraidBaseAd");
        kotlin.jvm.internal.t.i(mraidFullscreenController, "mraidFullscreenController");
        kotlin.jvm.internal.t.i(mraidActivity, "mraidActivity");
        this.f19255a = context;
        this.f19256b = watermark;
        this.f19257c = mraidAdLoader;
        this.f19258d = mraidBaseAd;
        this.f19259e = mraidFullscreenController;
        this.f19260f = mraidActivity;
        this.f19261g = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.MRAID;
        this.f19262h = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        Boolean bool = Boolean.FALSE;
        s9.y<Boolean> yVarA = s9.o0.a(bool);
        this.f19266l = yVarA;
        this.f19267m = yVarA;
        s9.y<Boolean> yVarA2 = s9.o0.a(bool);
        this.f19268n = yVarA2;
        this.f19269o = yVarA2;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f19262h, null, 1, null);
        this.f19258d.destroy();
        this.f19266l.setValue(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void g(long j10, @Nullable b.a aVar) {
        this.f19263i = aVar;
        this.f19258d.a0(new a(this));
        this.f19257c.g(j10, aVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h
    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getCreativeType() {
        return this.f19261g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    @NotNull
    public m0<Boolean> isLoaded() {
        return this.f19257c.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    @NotNull
    public m0<Boolean> j() {
        return this.f19269o;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a
    @NotNull
    public m0<Boolean> l() {
        return this.f19267m;
    }

    public final void p() {
        this.f19268n.setValue(Boolean.TRUE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d options, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar) {
        kotlin.jvm.internal.t.i(options, "options");
        this.f19258d.Z(new b(cVar));
        this.f19264j = cVar;
        this.f19265k = true;
        com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> tVarB = this.f19257c.b();
        if (tVarB instanceof t.a) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) ((t.a) tVarB).a();
            if (cVar != null) {
                cVar.a(dVar);
                return;
            }
            return;
        }
        if (!(tVarB instanceof t.b)) {
            throw new v8.q();
        }
        if (this.f19260f.c((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) ((t.b) tVarB).a(), this.f19259e, this.f19255a, options, this.f19256b, new c(this), new d(this))) {
            this.f19266l.setValue(Boolean.TRUE);
        } else if (cVar != null) {
            cVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_FULLSCREEN_AD_ACTIVITY_SHOW_FAILED_ERROR);
        }
    }

    public final void l(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
        if (this.f19265k) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c cVar = this.f19264j;
            if (cVar != null) {
                cVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
                return;
            }
            return;
        }
        b.a aVar = this.f19263i;
        if (aVar != null) {
            aVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
        }
    }
}
