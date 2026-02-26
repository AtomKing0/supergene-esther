package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import h9.p;
import h9.q;
import java.util.List;
import kotlin.collections.d0;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.i0;
import s9.m0;
import s9.x;
import s9.y;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<k> f20768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h f20769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final o0 f20770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final y<k> f20771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final m0<i.a> f20772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f20773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final s9.h<Boolean> f20774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f20775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.c f20776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final x<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> f20777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> f20778k;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$1", f = "AdPlaylistControllerImpl.kt", l = {}, m = "invokeSuspend")
    public static final class a extends l implements p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20779j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20780k;

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = f.this.new a(dVar);
            aVar.f20780k = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(bVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f20779j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b) this.f20780k;
            if (bVar instanceof b.c) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.f20769b;
                if (hVar != null) {
                    hVar.b(z.Companion);
                }
                f.this.T(new b.f(((b.c) bVar).a()));
            } else if (bVar instanceof b.a) {
                f.this.T(b.a.f20755a);
            } else if (bVar instanceof b.C0435b) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar2 = f.this.f20769b;
                if (hVar2 != null) {
                    kotlin.coroutines.jvm.internal.b.a(hVar2.c());
                }
                f.this.T(b.C0428b.f20756a);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$2", f = "AdPlaylistControllerImpl.kt", l = {}, m = "invokeSuspend")
    public static final class b extends l implements p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20782j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20783k;

        public b(z8.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = f.this.new b(dVar);
            bVar.f20783k = obj;
            return bVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar, @Nullable z8.d<? super k0> dVar2) {
            return ((b) create(dVar, dVar2)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f20782j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d) this.f20783k;
            if (dVar instanceof d.C0464d) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.f20769b;
                if (hVar != null) {
                    hVar.b(z.Linear);
                }
                f.this.T(new b.f(((d.C0464d) dVar).a()));
            } else if (t.d(dVar, d.a.f21356a)) {
                f.this.T(b.a.f20755a);
            } else if (t.d(dVar, d.e.f21360a)) {
                f.this.T(b.i.f20763a);
                f.this.R();
            } else if (t.d(dVar, d.b.f21357a)) {
                f.this.T(b.c.f20757a);
                f.this.L();
            } else if (t.d(dVar, d.c.f21358a)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar2 = f.this.f20769b;
                if (hVar2 != null) {
                    kotlin.coroutines.jvm.internal.b.a(hVar2.c());
                }
                f.this.T(b.g.f20761a);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$3", f = "AdPlaylistControllerImpl.kt", l = {}, m = "invokeSuspend")
    public static final class c extends l implements p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20785j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20786k;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20788a;

            static {
                int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.values().length];
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.ClickThrough.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.DisplayStarted.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f20788a = iArr;
            }
        }

        public c(z8.d<? super c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            c cVar = f.this.new c(dVar);
            cVar.f20786k = obj;
            return cVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b bVar, @Nullable z8.d<? super k0> dVar) {
            return ((c) create(bVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f20785j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            int i10 = a.f20788a[((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b) this.f20786k).ordinal()];
            if (i10 == 1) {
                f.this.T(b.a.f20755a);
            } else if (i10 == 2) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.f20769b;
                if (hVar != null) {
                    kotlin.coroutines.jvm.internal.b.a(hVar.c());
                }
                f.this.T(b.d.f20758a);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$4", f = "AdPlaylistControllerImpl.kt", l = {}, m = "invokeSuspend")
    public static final class d extends l implements p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.l, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20789j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20790k;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20792a;

            static {
                int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.l.values().length];
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.l.SkipOrClose.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.l.ClickThrough.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f20792a = iArr;
            }
        }

        public d(z8.d<? super d> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            d dVar2 = f.this.new d(dVar);
            dVar2.f20790k = obj;
            return dVar2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.l lVar, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(lVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f20789j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            int i10 = a.f20792a[((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.l) this.f20790k).ordinal()];
            if (i10 == 1) {
                f.this.T(b.i.f20763a);
                f.this.R();
            } else if (i10 == 2) {
                f.this.T(b.a.f20755a);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$canReplay$1", f = "AdPlaylistControllerImpl.kt", l = {}, m = "invokeSuspend")
    public static final class e extends l implements q<k, Boolean, z8.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20793j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20794k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20795l;

        public e(z8.d<? super e> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable k kVar, @Nullable Boolean bool, @Nullable z8.d<? super Boolean> dVar) {
            e eVar = f.this.new e(dVar);
            eVar.f20794k = kVar;
            eVar.f20795l = bool;
            return eVar.invokeSuspend(k0.f35197a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r3) {
            /*
                r2 = this;
                a9.b.e()
                int r0 = r2.f20793j
                if (r0 != 0) goto L36
                v8.u.b(r3)
                java.lang.Object r3 = r2.f20794k
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k r3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k) r3
                java.lang.Object r0 = r2.f20795l
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                if (r3 == 0) goto L30
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f r1 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.this
                java.util.List r1 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.W(r1)
                java.lang.Object r1 = kotlin.collections.t.t0(r1)
                boolean r3 = kotlin.jvm.internal.t.d(r3, r1)
                if (r3 == 0) goto L30
                r3 = 1
                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.b.a(r3)
                boolean r0 = kotlin.jvm.internal.t.d(r0, r1)
                if (r0 != 0) goto L30
                goto L31
            L30:
                r3 = 0
            L31:
                java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.b.a(r3)
                return r3
            L36:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$f, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$onEvent$1", f = "AdPlaylistControllerImpl.kt", l = {239}, m = "invokeSuspend")
    public static final class C0429f extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20797j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b f20799l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0429f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, z8.d<? super C0429f> dVar) {
            super(2, dVar);
            this.f20799l = bVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C0429f) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return f.this.new C0429f(this.f20799l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20797j;
            if (i10 == 0) {
                u.b(obj);
                x xVar = f.this.f20777j;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar = this.f20799l;
                this.f20797j = 1;
                if (xVar.emit(bVar, this) == objE) {
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

    public static final class g implements s9.h<i.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.h f20800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f20801b;

        public static final class a<T> implements s9.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.i f20802a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f20803b;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$special$$inlined$map$1$2", f = "AdPlaylistControllerImpl.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
            public static final class C0430a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public /* synthetic */ Object f20804j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public int f20805k;

                public C0430a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f20804j = obj;
                    this.f20805k |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(s9.i iVar, f fVar) {
                this.f20802a = iVar;
                this.f20803b = fVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull z8.d r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.g.a.C0430a
                    if (r0 == 0) goto L13
                    r0 = r7
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.g.a.C0430a) r0
                    int r1 = r0.f20805k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f20805k = r1
                    goto L18
                L13:
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.f20804j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f20805k
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    v8.u.b(r7)
                    goto L92
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    v8.u.b(r7)
                    s9.i r7 = r5.f20802a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f r2 = r5.f20803b
                    java.util.List r2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.W(r2)
                    java.lang.Object r2 = kotlin.collections.t.u0(r2)
                    boolean r2 = kotlin.jvm.internal.t.d(r2, r6)
                    boolean r4 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.a
                    if (r4 == 0) goto L56
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$a r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$a r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.a) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a r6 = r6.a()
                    r4.<init>(r6, r2)
                    goto L89
                L56:
                    boolean r4 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.c
                    if (r4 == 0) goto L66
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$c r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$c
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$c r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.c) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c r6 = r6.a()
                    r4.<init>(r6, r2)
                    goto L89
                L66:
                    boolean r4 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.b
                    if (r4 == 0) goto L76
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$b r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$b
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$b r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.b) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a r6 = r6.a()
                    r4.<init>(r6, r2)
                    goto L89
                L76:
                    boolean r4 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.d
                    if (r4 == 0) goto L86
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$d r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$d
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$d r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.d) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j r6 = r6.a()
                    r4.<init>(r6, r2)
                    goto L89
                L86:
                    if (r6 != 0) goto L95
                    r4 = 0
                L89:
                    r0.f20805k = r3
                    java.lang.Object r6 = r7.emit(r4, r0)
                    if (r6 != r1) goto L92
                    return r1
                L92:
                    v8.k0 r6 = v8.k0.f35197a
                    return r6
                L95:
                    v8.q r6 = new v8.q
                    r6.<init>()
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.g.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public g(s9.h hVar, f fVar) {
            this.f20800a = hVar;
            this.f20801b = fVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull s9.i<? super i.a> iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f20800a.collect(new a(iVar, this.f20801b), dVar);
            return objCollect == a9.d.e() ? objCollect : k0.f35197a;
        }
    }

    public static final class h implements s9.h<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.h f20807a;

        public static final class a<T> implements s9.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.i f20808a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$special$$inlined$map$2$2", f = "AdPlaylistControllerImpl.kt", l = {Sdk$SDKError.b.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
            public static final class C0431a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public /* synthetic */ Object f20809j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public int f20810k;

                public C0431a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f20809j = obj;
                    this.f20810k |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(s9.i iVar) {
                this.f20808a = iVar;
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
                    boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.h.a.C0431a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.h.a.C0431a) r0
                    int r1 = r0.f20810k
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f20810k = r1
                    goto L18
                L13:
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f20809j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f20810k
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    v8.u.b(r6)
                    goto L70
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    v8.u.b(r6)
                    s9.i r6 = r4.f20808a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k) r5
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.a
                    if (r2 == 0) goto L47
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$a r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.a) r5
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a r5 = r5.a()
                    boolean r5 = r5.C()
                    goto L63
                L47:
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.c
                    if (r2 == 0) goto L56
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$c r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.c) r5
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c r5 = r5.a()
                    boolean r5 = r5.C()
                    goto L63
                L56:
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.b
                    if (r2 == 0) goto L5b
                    goto L62
                L5b:
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.d
                    if (r2 == 0) goto L60
                    goto L62
                L60:
                    if (r5 != 0) goto L73
                L62:
                    r5 = 0
                L63:
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r5)
                    r0.f20810k = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L70
                    return r1
                L70:
                    v8.k0 r5 = v8.k0.f35197a
                    return r5
                L73:
                    v8.q r5 = new v8.q
                    r5.<init>()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.h.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        public h(s9.h hVar) {
            this.f20807a = hVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull s9.i<? super Boolean> iVar, @NotNull z8.d dVar) {
            Object objCollect = this.f20807a.collect(new a(iVar), dVar);
            return objCollect == a9.d.e() ? objCollect : k0.f35197a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull List<? extends k> playlist, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar) {
        s9.h hVarG;
        t.i(playlist, "playlist");
        this.f20768a = playlist;
        this.f20769b = hVar;
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f20770c = o0VarA;
        y<k> yVarA = s9.o0.a(null);
        this.f20771d = yVarA;
        g gVar = new g(yVarA, this);
        i0.a aVar = i0.f33702a;
        this.f20772e = s9.j.L(gVar, o0VarA, i0.a.b(aVar, 0L, 0L, 3, null), null);
        h hVar2 = new h(yVarA);
        i0 i0VarB = i0.a.b(aVar, 0L, 0L, 3, null);
        Boolean bool = Boolean.FALSE;
        this.f20773f = s9.j.L(hVar2, o0VarA, i0VarB, bool);
        s9.h<Boolean> hVarJ = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.j(yVarA, o0VarA);
        this.f20774g = hVarJ;
        this.f20775h = s9.j.L(s9.j.m(yVarA, hVarJ, new e(null)), o0VarA, i0.a.b(aVar, 0L, 0L, 3, null), bool);
        this.f20776i = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.e.a(yVarA, o0VarA);
        x<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> xVarB = e0.b(0, 0, null, 7, null);
        this.f20777j = xVarB;
        this.f20778k = xVarB;
        for (k kVar : playlist) {
            if (kVar instanceof k.a) {
                hVarG = s9.j.G(((k.a) kVar).a().a(), new a(null));
            } else if (kVar instanceof k.c) {
                hVarG = s9.j.G(((k.c) kVar).a().a(), new b(null));
            } else if (kVar instanceof k.b) {
                hVarG = s9.j.G(((k.b) kVar).a().a(), new c(null));
            } else {
                if (!(kVar instanceof k.d)) {
                    throw new v8.q();
                }
                hVarG = s9.j.G(((k.d) kVar).a().a(), new d(null));
            }
            s9.j.D(hVarG, this.f20770c);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void A() {
        C();
        T(b.h.f20762a);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void B() {
        k value = this.f20771d.getValue();
        if (value instanceof k.a) {
            ((k.a) value).a().L(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.f.a());
            return;
        }
        if (value instanceof k.c) {
            ((k.c) value).a().L(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.f.a());
            return;
        }
        if (value instanceof k.b) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdController", "Empty CTA DEC playlist item reached", null, false, 12, null);
        } else if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdController", "Empty CTA Mraid playlist item reached", null, false, 12, null);
        } else if (value == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdController", "Empty CTA playlist item reached", null, false, 12, null);
        }
    }

    public final void C() {
        k kVar = (k) d0.k0(this.f20768a);
        if (kVar == null) {
            return;
        }
        V(kVar);
    }

    public final boolean L() {
        List<k> list = this.f20768a;
        k kVar = (k) d0.l0(list, d0.n0(list, this.f20771d.getValue()) + 1);
        if (kVar == null) {
            return false;
        }
        V(kVar);
        return true;
    }

    public final void R() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a aVarG = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.g(this.f20768a, this.f20771d.getValue());
        if (aVarG != null) {
            aVarG.u();
        }
        if (L()) {
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = this.f20769b;
        if (hVar != null) {
            hVar.a();
        }
        T(b.e.f20759a);
    }

    public final b2 T(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
        return kotlinx.coroutines.k.d(this.f20770c, null, null, new C0429f(bVar, null), 3, null);
    }

    public final void V(k kVar) {
        this.f20771d.setValue(kVar);
        if (kVar instanceof k.c) {
            ((k.c) kVar).a().r();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a
    @NotNull
    public s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> a() {
        return this.f20778k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a
    public void d() {
        C();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f20770c, null, 1, null);
        for (k kVar : this.f20768a) {
            if (kVar instanceof k.a) {
                ((k.a) kVar).a().destroy();
            } else if (kVar instanceof k.c) {
                ((k.c) kVar).a().destroy();
            } else if (kVar instanceof k.b) {
                ((k.b) kVar).a().destroy();
            } else if (kVar instanceof k.d) {
                ((k.d) kVar).a().destroy();
            }
        }
        V(null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void g(@NotNull a.AbstractC0481a.c button) {
        t.i(button, "button");
        a.AbstractC0481a.c cVarI = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.i(this.f20768a, this.f20771d.getValue(), button);
        k value = this.f20771d.getValue();
        if (value instanceof k.c) {
            ((k.c) value).a().g(cVarI);
            return;
        }
        if (value instanceof k.a) {
            ((k.a) value).a().g(cVarI);
            return;
        }
        if (value instanceof k.b) {
            ((k.b) value).a().g(cVarI);
            return;
        }
        if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdController", "Empty onButtonRendered MRAID playlist item reached", null, false, 12, null);
            return;
        }
        if (value == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdController", "Displaying " + cVarI.c() + " at position: " + cVarI.d() + " of size: " + cVarI.e() + " in unknown playlist item type", null, false, 12, null);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    @NotNull
    public m0<i.a> j() {
        return this.f20772e;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    @NotNull
    public m0<d.a> l() {
        return this.f20776i.l();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    @NotNull
    public m0<Boolean> n() {
        return this.f20773f;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void y() {
        if (l().getValue() instanceof d.a.C0463a) {
            k value = this.f20771d.getValue();
            k.c cVar = value instanceof k.c ? (k.c) value : null;
            if (cVar != null) {
                cVar.a().g();
            } else {
                R();
            }
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void j(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        t.i(buttonType, "buttonType");
        a.AbstractC0481a.c.EnumC0483a enumC0483aH = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.h(this.f20768a, this.f20771d.getValue(), buttonType);
        k value = this.f20771d.getValue();
        if (value instanceof k.c) {
            ((k.c) value).a().j(enumC0483aH);
            return;
        }
        if (value instanceof k.a) {
            ((k.a) value).a().j(enumC0483aH);
            return;
        }
        if (value instanceof k.b) {
            ((k.b) value).a().j(enumC0483aH);
            return;
        }
        if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdController", "Empty onButtonUnRendered MRAID playlist item reached", null, false, 12, null);
            return;
        }
        if (value == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdController", "Unrendering " + enumC0483aH + " in unknown playlist item type", null, false, 12, null);
        }
    }
}
