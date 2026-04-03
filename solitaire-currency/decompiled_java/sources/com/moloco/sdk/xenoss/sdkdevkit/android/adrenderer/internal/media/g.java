package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import h9.p;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f19424j = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public static final String f19425k = "MediaCacheRepository";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final h f19426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.c f19427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a f19428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d f19429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final o0 f19430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final ConcurrentHashMap<String, y9.a> f19431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final HashSet<String> f19432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final ConcurrentHashMap<String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b> f19433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final o0 f19434i;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final String b(String str) {
            return str + "TEMP";
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$getMediaFile$2", f = "MediaCacheRepository.kt", l = {373, 161}, m = "invokeSuspend")
    public static final class b extends l implements p<o0, z8.d<? super f.a>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19435j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f19436k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f19437l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f19438m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f19439n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f19440o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ g f19441p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, g gVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f19440o = str;
            this.f19441p = gVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super f.a> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f19440o, this.f19441p, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:59:0x019e A[Catch: all -> 0x01e8, Exception -> 0x01eb, TryCatch #6 {Exception -> 0x01eb, all -> 0x01e8, blocks: (B:57:0x0198, B:59:0x019e, B:61:0x01b3, B:64:0x01db), top: B:89:0x0198 }] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01e4  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r26) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 560
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.g.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFile$2", f = "MediaCacheRepository.kt", l = {373}, m = "invokeSuspend")
    public static final class c extends l implements p<o0, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19442j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f19443k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f19444l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f19445m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f19446n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f19447o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ g f19448p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ String f19449q;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFile$2$1$1", f = "MediaCacheRepository.kt", l = {228}, m = "invokeSuspend")
        public static final class a extends l implements p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19450j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ g f19451k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ String f19452l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ File f19453m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ String f19454n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b f19455o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g gVar, String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f19451k = gVar;
                this.f19452l = str;
                this.f19453m = file;
                this.f19454n = str2;
                this.f19455o = bVar;
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
                return new a(this.f19451k, this.f19452l, this.f19453m, this.f19454n, this.f19455o, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19450j;
                if (i10 == 0) {
                    u.b(obj);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a aVar = this.f19451k.f19428c;
                    String str = this.f19452l;
                    File file = this.f19453m;
                    String str2 = this.f19454n;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = this.f19455o;
                    this.f19450j = 1;
                    if (aVar.c(str, file, str2, bVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                this.f19451k.f19432g.remove(this.f19452l);
                this.f19451k.f19433h.remove(this.f19452l);
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, g gVar, String str2, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f19447o = str;
            this.f19448p = gVar;
            this.f19449q = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> dVar) {
            return ((c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new c(this.f19447o, this.f19448p, this.f19449q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            y9.a mutex;
            g gVar;
            String str;
            String str2;
            Object objPutIfAbsent;
            Object objPutIfAbsent2;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c c0384c;
            Object objE = a9.d.e();
            int i10 = this.f19446n;
            if (i10 == 0) {
                u.b(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, g.f19425k, "Streaming media for: " + this.f19447o, null, false, 12, null);
                if (this.f19447o.length() == 0) {
                    return new c.b(f.a.AbstractC0379a.k.f19415a);
                }
                ConcurrentHashMap concurrentHashMap = this.f19448p.f19431f;
                String str3 = this.f19447o;
                Object objB = concurrentHashMap.get(str3);
                if (objB == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str3, (objB = y9.c.b(false, 1, null)))) != null) {
                    objB = objPutIfAbsent;
                }
                mutex = (y9.a) objB;
                t.h(mutex, "mutex");
                g gVar2 = this.f19448p;
                String str4 = this.f19447o;
                String str5 = this.f19449q;
                this.f19442j = mutex;
                this.f19443k = gVar2;
                this.f19444l = str4;
                this.f19445m = str5;
                this.f19446n = 1;
                if (mutex.e(null, this) == objE) {
                    return objE;
                }
                gVar = gVar2;
                str = str4;
                str2 = str5;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str6 = (String) this.f19445m;
                String str7 = (String) this.f19444l;
                g gVar3 = (g) this.f19443k;
                mutex = (y9.a) this.f19442j;
                u.b(obj);
                str2 = str6;
                str = str7;
                gVar = gVar3;
            }
            try {
                com.moloco.sdk.internal.t tVarH = gVar.h();
                if (tVarH instanceof t.a) {
                    return ((t.a) tVarH).a();
                }
                if (!(tVarH instanceof t.b)) {
                    throw new q();
                }
                File fileE = gVar.e(str, (File) ((t.b) tVarH).a());
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, g.f19425k, "Going to download the media file to location: " + fileE.getAbsolutePath(), null, false, 12, null);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b) gVar.f19433h.get(str);
                if (gVar.f19432g.contains(str)) {
                    MolocoLogger.info$default(molocoLogger, g.f19425k, "Media file is already being downloaded, so returning in progress status for url: " + str, null, false, 12, null);
                    if (bVar == null || (c0384c = bVar.d()) == null) {
                        c0384c = new c.C0384c(fileE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a());
                    }
                    return c0384c;
                }
                if (gVar.f19428c.a(fileE)) {
                    return new c.a(fileE);
                }
                MolocoLogger.info$default(molocoLogger, g.f19425k, "Media file needs to be downloaded: " + str, null, false, 12, null);
                gVar.f19432g.add(str);
                ConcurrentHashMap concurrentHashMap2 = gVar.f19433h;
                Object bVar2 = concurrentHashMap2.get(str);
                if (bVar2 == null && (objPutIfAbsent2 = concurrentHashMap2.putIfAbsent(str, (bVar2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b(new c.C0384c(fileE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()))))) != null) {
                    bVar2 = objPutIfAbsent2;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b) bVar2;
                kotlinx.coroutines.k.d(gVar.f19430e, null, null, new a(gVar, str, fileE, str2, bVar3, null), 3, null);
                return bVar3.d();
            } finally {
                mutex.g(null);
            }
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFileStatus$1", f = "MediaCacheRepository.kt", l = {249}, m = "invokeSuspend")
    public static final class d extends l implements p<s9.i<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19456j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19457k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ File f19458l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(File file, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f19458l = file;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            d dVar2 = new d(this.f19458l, dVar);
            dVar2.f19457k = obj;
            return dVar2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull s9.i<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> iVar, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(iVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f19456j;
            if (i10 == 0) {
                u.b(obj);
                s9.i iVar = (s9.i) this.f19457k;
                c.a aVar = new c.a(this.f19458l);
                this.f19456j = 1;
                if (iVar.emit(aVar, this) == objE) {
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

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFileStatus$cacheDir$1", f = "MediaCacheRepository.kt", l = {}, m = "invokeSuspend")
    public static final class e extends l implements p<s9.i<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19459j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.t<File, c.b> f19460k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.moloco.sdk.internal.t<File, c.b> tVar, z8.d<? super e> dVar) {
            super(2, dVar);
            this.f19460k = tVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new e(this.f19460k, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull s9.i<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> iVar, @Nullable z8.d<? super k0> dVar) {
            return ((e) create(iVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19459j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            ((t.a) this.f19460k).a();
            return k0.f35197a;
        }
    }

    public g(@NotNull h mediaConfig, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.c legacyMediaDownloader, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a chunkedMediaDownloader, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d mediaCacheLocationProvider) {
        kotlin.jvm.internal.t.i(mediaConfig, "mediaConfig");
        kotlin.jvm.internal.t.i(legacyMediaDownloader, "legacyMediaDownloader");
        kotlin.jvm.internal.t.i(chunkedMediaDownloader, "chunkedMediaDownloader");
        kotlin.jvm.internal.t.i(mediaCacheLocationProvider, "mediaCacheLocationProvider");
        this.f19426a = mediaConfig;
        this.f19427b = legacyMediaDownloader;
        this.f19428c = chunkedMediaDownloader;
        this.f19429d = mediaCacheLocationProvider;
        this.f19430e = p0.a(com.moloco.sdk.internal.scheduling.c.a().getIo());
        this.f19431f = new ConcurrentHashMap<>();
        this.f19432g = new HashSet<>();
        this.f19433h = new ConcurrentHashMap<>();
        this.f19434i = p0.a(com.moloco.sdk.internal.scheduling.c.a().getIo());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f
    @Nullable
    public Object a(@NotNull String str, @NotNull String str2, @NotNull z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new c(str, this, str2, null), dVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f
    @NotNull
    public s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> b(@NotNull String url) {
        kotlin.jvm.internal.t.i(url, "url");
        com.moloco.sdk.internal.t<File, c.b> tVarH = h();
        if (tVarH instanceof t.a) {
            return s9.j.z(new e(tVarH, null));
        }
        if (!(tVarH instanceof t.b)) {
            throw new q();
        }
        File file = (File) ((t.b) tVarH).a();
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        String str = f19425k;
        MolocoLogger.info$default(molocoLogger, str, "Collecting status for media file: " + url, null, false, 12, null);
        File fileE = e(url, file);
        if (fileE.exists() && this.f19428c.a(fileE)) {
            return s9.j.z(new d(fileE, null));
        }
        MolocoLogger.info$default(molocoLogger, str, "Media file needs to be downloaded: " + url, null, false, 12, null);
        ConcurrentHashMap<String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b> concurrentHashMap = this.f19433h;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = concurrentHashMap.get(url);
        if (bVar == null) {
            MolocoLogger.info$default(molocoLogger, str, "Download has not yet started for: " + url, null, false, 12, null);
            bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b(new c.C0384c(fileE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()));
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVarPutIfAbsent = concurrentHashMap.putIfAbsent(url, bVar);
            if (bVarPutIfAbsent != null) {
                bVar = bVarPutIfAbsent;
            }
        }
        return bVar.g();
    }

    public final File e(String str, File file) {
        return new File(file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g.a(str));
    }

    public final com.moloco.sdk.internal.t<File, c.b> h() {
        com.moloco.sdk.internal.t<File, com.moloco.sdk.internal.l> tVarJ = j();
        if (!(tVarJ instanceof t.a)) {
            if (tVarJ instanceof t.b) {
                return new t.b(((t.b) tVarJ).a());
            }
            throw new q();
        }
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        String str = f19425k;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to retrieve storageDir with error code: ");
        t.a aVar = (t.a) tVarJ;
        sb.append(((com.moloco.sdk.internal.l) aVar.a()).b());
        MolocoLogger.warn$default(molocoLogger, str, sb.toString(), null, false, 12, null);
        switch (((com.moloco.sdk.internal.l) aVar.a()).b()) {
            case 100:
                return new t.a(new c.b(f.a.AbstractC0379a.c.f19407a));
            case 101:
                return new t.a(new c.b(f.a.AbstractC0379a.b.f19406a));
            case 102:
                return new t.a(new c.b(f.a.AbstractC0379a.C0380a.f19405a));
            default:
                return new t.a(new c.b(f.a.AbstractC0379a.d.f19408a));
        }
    }

    @VisibleForTesting
    @NotNull
    public final com.moloco.sdk.internal.t<File, com.moloco.sdk.internal.l> j() {
        com.moloco.sdk.internal.t<File, com.moloco.sdk.internal.l> tVarA = this.f19429d.a();
        if (tVarA instanceof t.a) {
            return this.f19429d.b();
        }
        if (tVarA instanceof t.b) {
            return tVarA;
        }
        throw new q();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f
    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a(@NotNull String url) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c cVarD;
        kotlin.jvm.internal.t.i(url, "url");
        com.moloco.sdk.internal.t<File, c.b> tVarH = h();
        if (tVarH instanceof t.a) {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) ((t.a) tVarH).a();
        }
        if (!(tVarH instanceof t.b)) {
            throw new q();
        }
        File fileE = e(url, (File) ((t.b) tVarH).a());
        if (fileE.exists() && this.f19428c.a(fileE)) {
            return new c.a(fileE);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = this.f19433h.get(url);
        return (bVar == null || (cVarD = bVar.d()) == null) ? new c.C0384c(fileE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()) : cVarD;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f
    @Nullable
    public Object b(@NotNull String str, @NotNull z8.d<? super f.a> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new b(str, this, null), dVar);
    }
}
