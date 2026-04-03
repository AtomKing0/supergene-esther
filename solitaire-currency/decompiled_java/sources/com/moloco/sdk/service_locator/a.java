package com.moloco.sdk.service_locator;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.common.C;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.internal.services.a0;
import com.moloco.sdk.internal.services.b0;
import com.moloco.sdk.internal.services.c0;
import com.moloco.sdk.internal.services.d0;
import com.moloco.sdk.internal.services.e0;
import com.moloco.sdk.internal.services.f0;
import com.moloco.sdk.internal.services.h0;
import com.moloco.sdk.internal.services.init.f;
import com.moloco.sdk.internal.services.m;
import com.moloco.sdk.internal.services.o;
import com.moloco.sdk.internal.services.q;
import com.moloco.sdk.internal.services.r;
import com.moloco.sdk.internal.services.s;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.internal.services.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.u;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.w;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.y;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"StaticFieldLeak"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f18869a = new a();

    /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$a, reason: collision with other inner class name */
    @StabilityInferred(parameters = 0)
    public static final class C0337a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0337a f18870a = new C0337a();

        @NotNull
        public final u a() {
            return y.a(g.f18914a.a(), b.f18871a.c());
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f18871a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18872b = n.a(C0338a.f18877g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final l f18873c = n.a(d.f18880g);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final l f18874d = n.a(C0339b.f18878g);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final l f18875e = n.a(c.f18879g);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f18876f = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$b$a, reason: collision with other inner class name */
        public static final class C0338a extends v implements h9.a<com.moloco.sdk.internal.services.analytics.b> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0338a f18877g = new C0338a();

            public C0338a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.analytics.b invoke() {
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVarC = i.f18932a.c();
                k kVar = k.f18946a;
                return new com.moloco.sdk.internal.services.analytics.b(iVarC, kVar.a(), kVar.b());
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$b$b, reason: collision with other inner class name */
        public static final class C0339b extends v implements h9.a<com.moloco.sdk.internal.services.n> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0339b f18878g = new C0339b();

            public C0339b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.n invoke() {
                return new com.moloco.sdk.internal.services.n(ProcessLifecycleOwner.Companion.get().getLifecycle(), b.f18871a.d());
            }
        }

        public static final class c extends v implements h9.a<com.moloco.sdk.internal.error.c> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f18879g = new c();

            public c() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.error.c invoke() {
                return new com.moloco.sdk.internal.error.c(c.f18881a.a(), new com.moloco.sdk.internal.error.api.b(h.f18920a.f(), com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a()));
            }
        }

        public static final class d extends v implements h9.a<com.moloco.sdk.internal.services.a> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final d f18880g = new d();

            public d() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.a invoke() {
                return new com.moloco.sdk.internal.services.a(b.f18871a.a(), h.f18920a.f());
            }
        }

        @NotNull
        public final com.moloco.sdk.internal.services.analytics.a a() {
            return (com.moloco.sdk.internal.services.analytics.a) f18872b.getValue();
        }

        @NotNull
        public final m b() {
            return (m) f18874d.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.error.b c() {
            return (com.moloco.sdk.internal.error.b) f18875e.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.a d() {
            return (com.moloco.sdk.internal.services.a) f18873c.getValue();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f18881a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18882b = n.a(C0340a.f18884g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f18883c = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$c$a, reason: collision with other inner class name */
        public static final class C0340a extends v implements h9.a<com.moloco.sdk.internal.services.config.b> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0340a f18884g = new C0340a();

            public C0340a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.config.b invoke() {
                return new com.moloco.sdk.internal.services.config.b();
            }
        }

        @NotNull
        public final com.moloco.sdk.internal.services.config.a a() {
            return (com.moloco.sdk.internal.services.config.a) f18882b.getValue();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f18885a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18886b = n.a(C0341a.f18888g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f18887c = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$d$a, reason: collision with other inner class name */
        public static final class C0341a extends v implements h9.a<com.moloco.sdk.internal.error.crash.c> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0341a f18888g = new C0341a();

            public C0341a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.error.crash.c invoke() {
                return new com.moloco.sdk.internal.error.crash.c(new com.moloco.sdk.internal.error.crash.e(kotlin.collections.u.e(new com.moloco.sdk.internal.error.crash.filters.b()), new com.moloco.sdk.internal.error.api.b(h.f18920a.f(), com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a())));
            }
        }

        @NotNull
        public final com.moloco.sdk.internal.error.crash.a a() {
            return (com.moloco.sdk.internal.error.crash.a) f18886b.getValue();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final e f18889a = new e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18890b = n.a(b.f18899g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final l f18891c = n.a(f.f18903g);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final l f18892d = n.a(c.f18900g);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final l f18893e = n.a(g.f18904g);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public static final l f18894f = n.a(C0343e.f18902g);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        public static final l f18895g = n.a(d.f18901g);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        public static final l f18896h = n.a(C0342a.f18898g);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f18897i = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$e$a, reason: collision with other inner class name */
        public static final class C0342a extends v implements h9.a<com.moloco.sdk.internal.services.d> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0342a f18898g = new C0342a();

            public C0342a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.d invoke() {
                return new com.moloco.sdk.internal.services.d(a.f18869a.a());
            }
        }

        public static final class b extends v implements h9.a<com.moloco.sdk.internal.services.v> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f18899g = new b();

            public b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.v invoke() {
                return new com.moloco.sdk.internal.services.v(a.f18869a.a());
            }
        }

        public static final class c extends v implements h9.a<com.moloco.sdk.internal.services.y> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f18900g = new c();

            public c() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.y invoke() {
                return new com.moloco.sdk.internal.services.y(a.f18869a.a());
            }
        }

        public static final class d extends v implements h9.a<a0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final d f18901g = new d();

            public d() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a0 invoke() {
                return new a0(a.f18869a.a());
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$e$e, reason: collision with other inner class name */
        public static final class C0343e extends v implements h9.a<e0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0343e f18902g = new C0343e();

            public C0343e() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final e0 invoke() {
                return new e0(a.f18869a.a());
            }
        }

        public static final class f extends v implements h9.a<q> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final f f18903g = new f();

            public f() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final q invoke() {
                return new q(a.f18869a.a());
            }
        }

        public static final class g extends v implements h9.a<o> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final g f18904g = new g();

            public g() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final o invoke() {
                return new o(a.f18869a.a());
            }
        }

        @NotNull
        public final com.moloco.sdk.internal.services.c a() {
            return (com.moloco.sdk.internal.services.c) f18896h.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.u b() {
            return (com.moloco.sdk.internal.services.u) f18890b.getValue();
        }

        @NotNull
        public final x c() {
            return (x) f18892d.getValue();
        }

        @NotNull
        public final z d() {
            return (z) f18895g.getValue();
        }

        @NotNull
        public final d0 e() {
            return (d0) f18894f.getValue();
        }

        @NotNull
        public final h0 f() {
            return (h0) f18891c.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.l g() {
            return (com.moloco.sdk.internal.services.l) f18893e.getValue();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public static volatile com.moloco.sdk.internal.b f18906b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final f f18905a = new f();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final l f18907c = n.a(c.f18913g);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final l f18908d = n.a(C0344a.f18911g);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final l f18909e = n.a(b.f18912g);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f18910f = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$f$a, reason: collision with other inner class name */
        public static final class C0344a extends v implements h9.a<com.moloco.sdk.internal.services.init.e> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0344a f18911g = new C0344a();

            public C0344a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.init.e invoke() {
                e eVar = e.f18889a;
                return new com.moloco.sdk.internal.services.init.e(eVar.f(), eVar.b(), k.f18946a.e(), BuildConfig.SDK_VERSION_NAME, BuildConfig.MOLOCO_ENDPOINT_INIT_CONFIG, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, i.f18932a.a());
            }
        }

        public static final class b extends v implements h9.a<com.moloco.sdk.internal.services.init.j> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f18912g = new b();

            public b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.init.j invoke() {
                com.moloco.sdk.internal.services.init.d dVarB = f.f18905a.b();
                f.a aVar = com.moloco.sdk.internal.services.init.f.f18735a;
                SharedPreferences sharedPreferences = a.f18869a.a().getSharedPreferences("moloco_sdk_init_cache", 0);
                t.h(sharedPreferences, "context.getSharedPrefere…e\", Context.MODE_PRIVATE)");
                return new com.moloco.sdk.internal.services.init.j(dVarB, aVar.a(sharedPreferences), p0.a(com.moloco.sdk.internal.scheduling.c.a().getIo().plus(y2.b(null, 1, null))));
            }
        }

        public static final class c extends v implements h9.a<com.moloco.sdk.internal.services.init.m> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f18913g = new c();

            public c() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.init.m invoke() {
                return new com.moloco.sdk.internal.services.init.m(BuildConfig.MOLOCO_ENDPOINT_INIT_TRACKING, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.c.a());
            }
        }

        @NotNull
        public final com.moloco.sdk.internal.b a(@NotNull com.moloco.sdk.i initResponse) {
            t.i(initResponse, "initResponse");
            com.moloco.sdk.internal.b cVar = f18906b;
            if (cVar == null) {
                synchronized (this) {
                    cVar = f18906b;
                    if (cVar == null) {
                        cVar = new com.moloco.sdk.internal.c(initResponse, k.f18946a.a(), h.f18920a.c());
                        f18906b = cVar;
                    }
                }
            }
            return cVar;
        }

        @NotNull
        public final com.moloco.sdk.internal.services.init.d b() {
            return (com.moloco.sdk.internal.services.init.d) f18908d.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.init.i c() {
            return (com.moloco.sdk.internal.services.init.i) f18909e.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.init.l d() {
            return (com.moloco.sdk.internal.services.init.l) f18907c.getValue();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final g f18914a = new g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18915b = n.a(b.f18919g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final l f18916c = n.a(C0345a.f18918g);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f18917d = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$g$a, reason: collision with other inner class name */
        public static final class C0345a extends v implements h9.a<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.g> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0345a f18918g = new C0345a();

            public C0345a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.g invoke() {
                g gVar = g.f18914a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h hVarB = gVar.b();
                e eVar = e.f18889a;
                d0 d0VarE = eVar.e();
                b bVar = b.f18871a;
                com.moloco.sdk.internal.error.b bVarC = bVar.c();
                i iVar = i.f18932a;
                return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.g(gVar.b(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.c(eVar.e(), bVar.c(), iVar.a()), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b(hVarB, d0VarE, bVarC, iVar.a()), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.e(a.f18869a.a(), "com.moloco.sdk.xenoss.sdkdevkit.android.cache"));
            }
        }

        public static final class b extends v implements h9.a<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f18919g = new b();

            public b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h invoke() {
                return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h) c.f18881a.a().b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h.class, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a());
            }
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f a() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f) f18916c.getValue();
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h b() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.h) f18915b.getValue();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final h f18920a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18921b = n.a(d.f18930g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final l f18922c = n.a(c.f18929g);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final l f18923d = n.a(b.f18928g);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final l f18924e = n.a(e.f18931g);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public static final l f18925f = n.a(C0346a.f18927g);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f18926g = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$h$a, reason: collision with other inner class name */
        public static final class C0346a extends v implements h9.a<ActivityManager> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0346a f18927g = new C0346a();

            public C0346a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ActivityManager invoke() {
                Object systemService = a.f18869a.a().getSystemService("activity");
                t.g(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                return (ActivityManager) systemService;
            }
        }

        public static final class b extends v implements h9.a<com.moloco.sdk.internal.services.k> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f18928g = new b();

            public b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.k invoke() {
                return new com.moloco.sdk.internal.services.k(a.f18869a.a());
            }
        }

        public static final class c extends v implements h9.a<com.moloco.sdk.internal.services.proto.b> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f18929g = new c();

            public c() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.proto.b invoke() {
                return new com.moloco.sdk.internal.services.proto.b();
            }
        }

        public static final class d extends v implements h9.a<s> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final d f18930g = new d();

            public d() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final s invoke() {
                return new s();
            }
        }

        public static final class e extends v implements h9.a<com.moloco.sdk.internal.d> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final e f18931g = new e();

            public e() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.d invoke() {
                return new com.moloco.sdk.internal.d();
            }
        }

        @NotNull
        public final ActivityManager a() {
            return (ActivityManager) f18925f.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.i b() {
            return (com.moloco.sdk.internal.services.i) f18923d.getValue();
        }

        @NotNull
        public final b0 c() {
            return new c0(d(), k.f18946a.a());
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z d() {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.a0(a.f18869a.a());
        }

        @NotNull
        public final com.moloco.sdk.internal.services.proto.a e() {
            return (com.moloco.sdk.internal.services.proto.a) f18922c.getValue();
        }

        @NotNull
        public final r f() {
            return (r) f18921b.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.a g() {
            return (com.moloco.sdk.internal.a) f18924e.getValue();
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t h() {
            return new w();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final i f18932a = new i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18933b = n.a(C0347a.f18938g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final l f18934c = n.a(b.f18939g);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final l f18935d = n.a(d.f18941g);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final l f18936e = n.a(c.f18940g);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f18937f = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$i$a, reason: collision with other inner class name */
        public static final class C0347a extends v implements h9.a<s7.a> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0347a f18938g = new C0347a();

            public C0347a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final s7.a invoke() {
                e eVar = e.f18889a;
                return com.moloco.sdk.internal.http.a.a(eVar.b().invoke(), eVar.f().invoke());
            }
        }

        public static final class b extends v implements h9.a<com.moloco.sdk.internal.services.g> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f18939g = new b();

            public b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.g invoke() {
                return new com.moloco.sdk.internal.services.g(a.f18869a.a(), e.f18889a.f());
            }
        }

        public static final class c extends v implements h9.a<com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f18940g = new c();

            public c() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i invoke() {
                return com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i.f21737a.a(i.f18932a.d());
            }
        }

        public static final class d extends v implements h9.a<com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.m> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final d f18941g = new d();

            public d() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.m invoke() {
                return new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.m(a.f18869a.a());
            }
        }

        @NotNull
        public final s7.a a() {
            return (s7.a) f18933b.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.e b() {
            return (com.moloco.sdk.internal.services.e) f18934c.getValue();
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i c() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i) f18936e.getValue();
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.l d() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.l) f18935d.getValue();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final j f18942a = new j();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18943b = n.a(C0348a.f18945g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f18944c = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$j$a, reason: collision with other inner class name */
        public static final class C0348a extends v implements h9.a<com.moloco.sdk.internal.services.h> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0348a f18945g = new C0348a();

            public C0348a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.h invoke() {
                SharedPreferences sharedPreferences = a.f18869a.a().getSharedPreferences("moloco_sdk_preferences", 0);
                t.h(sharedPreferences, "sharedPreferences");
                return new com.moloco.sdk.internal.services.h(sharedPreferences);
            }
        }

        @NotNull
        public final f0 a() {
            return (f0) f18943b.getValue();
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final k f18946a = new k();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final l f18947b = n.a(b.f18952g);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final l f18948c = n.a(c.f18953g);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final l f18949d = n.a(C0349a.f18951g);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f18950e = 8;

        /* JADX INFO: renamed from: com.moloco.sdk.service_locator.a$k$a, reason: collision with other inner class name */
        public static final class C0349a extends v implements h9.a<com.moloco.sdk.internal.services.events.c> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0349a f18951g = new C0349a();

            public C0349a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.events.c invoke() {
                return new com.moloco.sdk.internal.services.events.c();
            }
        }

        public static final class b extends v implements h9.a<com.moloco.sdk.internal.services.usertracker.c> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final b f18952g = new b();

            public b() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.usertracker.c invoke() {
                return new com.moloco.sdk.internal.services.usertracker.c(j.f18942a.a());
            }
        }

        public static final class c extends v implements h9.a<com.moloco.sdk.internal.services.usertracker.f> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final c f18953g = new c();

            public c() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final com.moloco.sdk.internal.services.usertracker.f invoke() {
                k kVar = k.f18946a;
                return new com.moloco.sdk.internal.services.usertracker.f(kVar.d(), kVar.c());
            }
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a a() {
            e eVar = e.f18889a;
            com.moloco.sdk.internal.services.u uVarB = eVar.b();
            com.moloco.sdk.internal.services.e eVarB = i.f18932a.b();
            h0 h0VarF = eVar.f();
            com.moloco.sdk.internal.services.l lVarG = eVar.g();
            com.moloco.sdk.internal.services.usertracker.e eVarE = e();
            h hVar = h.f18920a;
            return new com.moloco.sdk.internal.services.events.a(uVarB, eVarB, h0VarF, lVarG, eVarE, hVar.b(), hVar.e(), b(), BuildConfig.SDK_VERSION_NAME);
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b b() {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b) f18949d.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.usertracker.b c() {
            return (com.moloco.sdk.internal.services.usertracker.b) f18947b.getValue();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.usertracker.d d() {
            return new com.moloco.sdk.internal.services.usertracker.a();
        }

        @NotNull
        public final com.moloco.sdk.internal.services.usertracker.e e() {
            return (com.moloco.sdk.internal.services.usertracker.e) f18948c.getValue();
        }
    }

    @NotNull
    public final Context a() {
        return com.moloco.sdk.internal.android_context.b.b(null, 1, null);
    }
}
