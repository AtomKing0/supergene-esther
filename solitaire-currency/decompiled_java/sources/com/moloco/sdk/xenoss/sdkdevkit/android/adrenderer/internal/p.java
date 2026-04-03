package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f19681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f19682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g f19683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final o0 f19684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final j f19685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19689i;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastFullscreenAdImpl$show$1", f = "VastFullscreenAd.kt", l = {89}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19690j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p f19692l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q f19693m;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.p$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0389a extends kotlin.jvm.internal.q implements h9.a<v8.k0> {
            public C0389a(Object obj) {
                super(0, obj, p.class, "onClose", "onClose()V", 0);
            }

            public final void c() {
                ((p) this.receiver).t();
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ v8.k0 invoke() {
                c();
                return v8.k0.f35197a;
            }
        }

        public static final class b extends kotlin.jvm.internal.v implements h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, v8.k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ p f19694g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p f19695h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(p pVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p pVar2) {
                super(1);
                this.f19694g = pVar;
                this.f19695h = pVar2;
            }

            public final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b event) {
                kotlin.jvm.internal.t.i(event, "event");
                this.f19694g.m(event, this.f19695h);
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ v8.k0 invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
                a(bVar);
                return v8.k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p pVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q qVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f19692l = pVar;
            this.f19693m = qVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return p.this.new a(this.f19692l, this.f19693m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19690j;
            try {
                if (i10 == 0) {
                    v8.u.b(obj);
                    com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> tVarB = p.this.f19685e.b();
                    if (tVarB instanceof t.a) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((t.a) tVarB).a();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p pVar = this.f19692l;
                        if (pVar != null) {
                            pVar.a(cVar);
                        }
                        return v8.k0.f35197a;
                    }
                    if (!(tVarB instanceof t.b)) {
                        throw new v8.q();
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((t.b) tVarB).a();
                    if (!aVar.g().e().exists()) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, "VastFullscreenAdImpl", "VAST ad media file does not exist", null, false, 12, null);
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p pVar2 = this.f19692l;
                        if (pVar2 != null) {
                            pVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l.VAST_AD_EXOPLAYER_SET_MEDIA_FILE_NOT_EXISTS_ERROR);
                        }
                        return v8.k0.f35197a;
                    }
                    VastActivity.a aVar2 = VastActivity.f20076c;
                    Context context = p.this.f19681a;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q qVar = this.f19693m;
                    C0389a c0389a = new C0389a(p.this);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar = p.this.f19682b;
                    b bVar = new b(p.this, this.f19692l);
                    this.f19690j = 1;
                    if (aVar2.a(aVar, context, qVar, c0389a, rVar, bVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                p.this.f19686f.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                return v8.k0.f35197a;
            } catch (Throwable th) {
                p.this.f19686f.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                throw th;
            }
        }
    }

    public p(@NotNull Context context, @NotNull com.moloco.sdk.internal.ortb.model.c bid, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, @NotNull u decLoader, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(bid, "bid");
        kotlin.jvm.internal.t.i(loadVast, "loadVast");
        kotlin.jvm.internal.t.i(decLoader, "decLoader");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        this.f19681a = context;
        this.f19682b = watermark;
        this.f19683c = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.VAST;
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f19684d = o0VarA;
        this.f19685e = new j(bid, o0VarA, loadVast, decLoader, z10);
        Boolean bool = Boolean.FALSE;
        s9.y<Boolean> yVarA = s9.o0.a(bool);
        this.f19686f = yVarA;
        this.f19687g = yVarA;
        s9.y<Boolean> yVarA2 = s9.o0.a(bool);
        this.f19688h = yVarA2;
        this.f19689i = yVarA2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        this.f19688h.setValue(Boolean.TRUE);
        this.f19686f.setValue(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f19684d, null, 1, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void g(long j10, @Nullable b.a aVar) {
        this.f19685e.g(j10, aVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h
    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getCreativeType() {
        return this.f19683c;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    @NotNull
    public m0<Boolean> isLoaded() {
        return this.f19685e.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a
    @NotNull
    public m0<Boolean> l() {
        return this.f19687g;
    }

    public final void m(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p pVar) {
        if (kotlin.jvm.internal.t.d(bVar, b.g.f20761a)) {
            y();
            return;
        }
        if (kotlin.jvm.internal.t.d(bVar, b.C0428b.f20756a)) {
            y();
            return;
        }
        if (kotlin.jvm.internal.t.d(bVar, b.d.f20758a)) {
            y();
            return;
        }
        if (kotlin.jvm.internal.t.d(bVar, b.i.f20763a)) {
            if (pVar != null) {
                pVar.a(true);
                return;
            }
            return;
        }
        if (kotlin.jvm.internal.t.d(bVar, b.c.f20757a)) {
            if (pVar != null) {
                pVar.a(false);
            }
        } else if (kotlin.jvm.internal.t.d(bVar, b.a.f20755a)) {
            if (pVar != null) {
                pVar.a();
            }
        } else if (bVar instanceof b.f) {
            if (pVar != null) {
                pVar.a(((b.f) bVar).a());
            }
        } else {
            if (kotlin.jvm.internal.t.d(bVar, b.h.f20762a)) {
                return;
            }
            kotlin.jvm.internal.t.d(bVar, b.e.f20759a);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q options, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p pVar) {
        kotlin.jvm.internal.t.i(options, "options");
        kotlinx.coroutines.k.d(this.f19684d, null, null, new a(pVar, options, null), 3, null);
    }

    public final void y() {
        this.f19686f.setValue(Boolean.TRUE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    @NotNull
    public m0<Boolean> j() {
        return this.f19689i;
    }
}
