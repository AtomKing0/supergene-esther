package com.moloco.sdk.internal.services.init;

import android.content.SharedPreferences;
import android.util.Base64;
import com.moloco.sdk.internal.MolocoLogger;
import h9.p;
import java.util.Iterator;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f18737e = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final SharedPreferences f18738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final z8.g f18739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.a f18740d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$clearAll$2", f = "InitCache.kt", l = {}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18741j;

        public b(z8.d<? super b> dVar) {
            super(2, dVar);
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
            return g.this.new b(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18741j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            g.this.f18738b.edit().clear().commit();
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$clearCache$2", f = "InitCache.kt", l = {}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18743j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a f18745l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.internal.services.init.a aVar, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f18745l = aVar;
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
            return g.this.new c(this.f18745l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18743j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            com.moloco.sdk.acm.f fVarW = g.this.f18740d.w("SDKInitCacheClear");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, "InitCacheImpl", "Clearing cache for mediation: " + this.f18745l.a(), null, false, 12, null);
                SharedPreferences.Editor editor = g.this.f18738b.edit();
                g gVar = g.this;
                com.moloco.sdk.internal.services.init.a aVar = this.f18745l;
                t.h(editor, "editor");
                gVar.f(aVar, editor);
                editor.remove(this.f18745l.b());
                if (editor.commit()) {
                    MolocoLogger.info$default(molocoLogger, "InitCacheImpl", "Successfully cleared cache for mediation: " + this.f18745l.a(), null, false, 12, null);
                    g.this.f18740d.t(new com.moloco.sdk.acm.c("SDKInitCacheClear").d("Result", "success"));
                    g.this.f18740d.u(fVarW.f("Result", "success"));
                } else {
                    MolocoLogger.warn$default(molocoLogger, "InitCacheImpl", "Failed to clear cache for mediation: " + this.f18745l.a(), null, false, 12, null);
                    g.this.f18740d.t(new com.moloco.sdk.acm.c("SDKInitCacheClear").d("Result", "failure").d("Reason", "commit_failure"));
                    g.this.f18740d.u(fVarW.f("Result", "failure").f("Reason", "commit_failure"));
                }
            } catch (Exception e10) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "InitCacheImpl", "Failed to clear cache for mediation: " + this.f18745l.a() + " with exception", e10, false, 8, null);
                com.moloco.sdk.acm.a aVar2 = g.this.f18740d;
                com.moloco.sdk.acm.c cVarD = new com.moloco.sdk.acm.c("SDKInitCacheClear").d("Result", "failure");
                String simpleName = e10.getClass().getSimpleName();
                t.h(simpleName, "e.javaClass.simpleName");
                aVar2.t(cVarD.d("Reason", simpleName));
                com.moloco.sdk.acm.a aVar3 = g.this.f18740d;
                com.moloco.sdk.acm.f fVarF = fVarW.f("Result", "failure");
                String simpleName2 = e10.getClass().getSimpleName();
                t.h(simpleName2, "e.javaClass.simpleName");
                aVar3.u(fVarF.f("Reason", simpleName2));
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$get$2", f = "InitCache.kt", l = {}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super com.moloco.sdk.i>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18746j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a f18748l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.internal.services.init.a aVar, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f18748l = aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.i> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return g.this.new d(this.f18748l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18746j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            com.moloco.sdk.acm.f fVarW = g.this.f18740d.w("SDKInitCacheRead");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, "InitCacheImpl", "Reading cache for mediation: " + this.f18748l.a(), null, false, 12, null);
                String string = g.this.f18738b.getString(this.f18748l.b(), null);
                com.moloco.sdk.i iVarL = string != null ? com.moloco.sdk.i.l(Base64.decode(string, 0)) : null;
                if (iVarL != null) {
                    MolocoLogger.info$default(molocoLogger, "InitCacheImpl", "Successfully read cache for mediation: " + this.f18748l.a(), null, false, 12, null);
                    g.this.f18740d.u(fVarW.f("Result", "success"));
                    g.this.f18740d.t(new com.moloco.sdk.acm.c("SDKInitCacheRead").d("Result", "success"));
                } else {
                    MolocoLogger.info$default(molocoLogger, "InitCacheImpl", "Failed to read from cache (cache_miss) for mediation: " + this.f18748l.a(), null, false, 12, null);
                    g.this.f18740d.u(fVarW.f("Result", "failure").f("Reason", "cache_miss"));
                    g.this.f18740d.t(new com.moloco.sdk.acm.c("SDKInitCacheRead").d("Result", "failure").d("Reason", "cache_miss"));
                }
                return iVarL;
            } catch (Exception e10) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "InitCacheImpl", "Failed to read cache for mediation: " + this.f18748l.a() + " with exception", e10, false, 8, null);
                com.moloco.sdk.acm.a aVar = g.this.f18740d;
                com.moloco.sdk.acm.f fVarF = fVarW.f("Result", "failure");
                String simpleName = e10.getClass().getSimpleName();
                t.h(simpleName, "e.javaClass.simpleName");
                aVar.u(fVarF.f("Reason", simpleName));
                com.moloco.sdk.acm.a aVar2 = g.this.f18740d;
                com.moloco.sdk.acm.c cVarD = new com.moloco.sdk.acm.c("SDKInitCacheRead").d("Result", "failure");
                String simpleName2 = e10.getClass().getSimpleName();
                t.h(simpleName2, "e.javaClass.simpleName");
                aVar2.t(cVarD.d("Reason", simpleName2));
                return null;
            }
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.init.InitCacheImpl$updateCache$2", f = "InitCache.kt", l = {}, m = "invokeSuspend")
    public static final class e extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18749j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.services.init.a f18751l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.i f18752m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.moloco.sdk.internal.services.init.a aVar, com.moloco.sdk.i iVar, z8.d<? super e> dVar) {
            super(2, dVar);
            this.f18751l = aVar;
            this.f18752m = iVar;
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
            return g.this.new e(this.f18751l, this.f18752m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            String str2;
            String str3;
            a9.d.e();
            if (this.f18749j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            com.moloco.sdk.acm.f fVarW = g.this.f18740d.w("SDKInitCacheWrite");
            try {
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, "InitCacheImpl", "Updating cache for mediation: " + this.f18751l.a(), null, false, 12, null);
                boolean z10 = false;
                String strEncodeToString = Base64.encodeToString(this.f18752m.toByteArray(), 0);
                if (strEncodeToString == null || strEncodeToString.length() == 0) {
                    str2 = "Reason";
                    str3 = strEncodeToString;
                    try {
                        MolocoLogger.warn$default(molocoLogger, "InitCacheImpl", "Failed to encode SDKInitResponse for mediation: " + this.f18751l.a(), null, false, 12, null);
                        z10 = true;
                    } catch (Exception e10) {
                        e = e10;
                        str = str2;
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, "InitCacheImpl", "Failed to update cache for mediation: " + this.f18751l.a() + " with exception", e, false, 8, null);
                        com.moloco.sdk.acm.a aVar = g.this.f18740d;
                        com.moloco.sdk.acm.f fVarF = fVarW.f("Result", "failure");
                        String simpleName = e.getClass().getSimpleName();
                        t.h(simpleName, "e.javaClass.simpleName");
                        aVar.u(fVarF.f(str, simpleName));
                        com.moloco.sdk.acm.a aVar2 = g.this.f18740d;
                        com.moloco.sdk.acm.c cVarD = new com.moloco.sdk.acm.c("SDKInitCacheWrite").d("Result", "failure");
                        String simpleName2 = e.getClass().getSimpleName();
                        t.h(simpleName2, "e.javaClass.simpleName");
                        aVar2.t(cVarD.d(str, simpleName2));
                        return k0.f35197a;
                    }
                } else {
                    str2 = "Reason";
                    str3 = strEncodeToString;
                }
                if (z10 || !g.this.f18738b.edit().putString(this.f18751l.b(), str3).commit()) {
                    String str4 = z10 ? "encoding_failure" : "commit_failure";
                    MolocoLogger.warn$default(molocoLogger, "InitCacheImpl", "Failed to update cache for mediation: " + this.f18751l.a() + " with error: " + str4, null, false, 12, null);
                    str = str2;
                    try {
                        g.this.f18740d.u(fVarW.f("Result", "failure").f(str, str4));
                        g.this.f18740d.t(new com.moloco.sdk.acm.c("SDKInitCacheWrite").d("Result", "failure").d(str, str4));
                    } catch (Exception e11) {
                        e = e11;
                        MolocoLogger.warn$default(MolocoLogger.INSTANCE, "InitCacheImpl", "Failed to update cache for mediation: " + this.f18751l.a() + " with exception", e, false, 8, null);
                        com.moloco.sdk.acm.a aVar3 = g.this.f18740d;
                        com.moloco.sdk.acm.f fVarF2 = fVarW.f("Result", "failure");
                        String simpleName3 = e.getClass().getSimpleName();
                        t.h(simpleName3, "e.javaClass.simpleName");
                        aVar3.u(fVarF2.f(str, simpleName3));
                        com.moloco.sdk.acm.a aVar22 = g.this.f18740d;
                        com.moloco.sdk.acm.c cVarD2 = new com.moloco.sdk.acm.c("SDKInitCacheWrite").d("Result", "failure");
                        String simpleName22 = e.getClass().getSimpleName();
                        t.h(simpleName22, "e.javaClass.simpleName");
                        aVar22.t(cVarD2.d(str, simpleName22));
                    }
                } else {
                    MolocoLogger.info$default(molocoLogger, "InitCacheImpl", "Successfully updated cache for mediation: " + this.f18751l.a(), null, false, 12, null);
                    g.this.f18740d.u(fVarW.f("Result", "success"));
                    g.this.f18740d.t(new com.moloco.sdk.acm.c("SDKInitCacheWrite").d("Result", "success"));
                }
            } catch (Exception e12) {
                e = e12;
                str = "Reason";
            }
            return k0.f35197a;
        }
    }

    public g(@NotNull SharedPreferences sharedPreferences, @NotNull z8.g ioDispatcherContext, @NotNull com.moloco.sdk.acm.a acm) {
        t.i(sharedPreferences, "sharedPreferences");
        t.i(ioDispatcherContext, "ioDispatcherContext");
        t.i(acm, "acm");
        this.f18738b = sharedPreferences;
        this.f18739c = ioDispatcherContext;
        this.f18740d = acm;
    }

    @Override // com.moloco.sdk.internal.services.init.f
    @Nullable
    public Object a(@NotNull z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(this.f18739c, new b(null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }

    @Override // com.moloco.sdk.internal.services.init.f
    @Nullable
    public Object b(@NotNull com.moloco.sdk.internal.services.init.a aVar, @NotNull z8.d<? super com.moloco.sdk.i> dVar) {
        return kotlinx.coroutines.i.g(this.f18739c, new d(aVar, null), dVar);
    }

    @Override // com.moloco.sdk.internal.services.init.f
    @Nullable
    public Object c(@NotNull com.moloco.sdk.internal.services.init.a aVar, @NotNull com.moloco.sdk.i iVar, @NotNull z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(this.f18739c, new e(aVar, iVar, null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }

    @Override // com.moloco.sdk.internal.services.init.f
    @Nullable
    public Object d(@NotNull com.moloco.sdk.internal.services.init.a aVar, @NotNull z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(this.f18739c, new c(aVar, null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }

    public final void f(com.moloco.sdk.internal.services.init.a aVar, SharedPreferences.Editor editor) {
        Iterator<String> it = aVar.c().iterator();
        while (it.hasNext()) {
            editor.remove(it.next());
        }
    }
}
