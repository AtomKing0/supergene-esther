package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.d0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import e8.o;
import h9.p;
import java.io.File;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import y7.u;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final h f19353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final d0 f19354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.error.b f19355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final s7.a f19356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f19357e;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl", f = "ChunkedMediaDownloader.kt", l = {293, 293}, m = "downloadFullFile")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19358j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f19359k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f19360l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f19361m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f19363o;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f19361m = obj;
            this.f19363o |= Integer.MIN_VALUE;
            return b.this.k(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$b, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl$downloadMedia$2", f = "ChunkedMediaDownloader.kt", l = {94, 105, 137, 148}, m = "invokeSuspend")
    public static final class C0376b extends l implements p<o0, z8.d<? super f.a>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19364j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19365k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f19366l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f19367m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f19368n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f19369o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f19370p;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ String f19372r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ File f19373s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a f19374t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ String f19375u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0376b(String str, File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, String str2, z8.d<? super C0376b> dVar) {
            super(2, dVar);
            this.f19372r = str;
            this.f19373s = file;
            this.f19374t = aVar;
            this.f19375u = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super f.a> dVar) {
            return ((C0376b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return b.this.new C0376b(this.f19372r, this.f19373s, this.f19374t, this.f19375u, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x041b A[Catch: Exception -> 0x0419, TRY_LEAVE, TryCatch #2 {Exception -> 0x0419, blocks: (B:50:0x0170, B:53:0x018b, B:55:0x0193, B:57:0x0197, B:58:0x01a1, B:60:0x01a4, B:63:0x01f5, B:66:0x0206, B:68:0x0261, B:70:0x02b8, B:72:0x02bf, B:78:0x0305, B:82:0x033a, B:86:0x0358, B:88:0x035c, B:91:0x0375, B:92:0x038b, B:77:0x02e9, B:94:0x03ae, B:95:0x03b3, B:96:0x03b4, B:103:0x041b), top: B:115:0x0170 }] */
        /* JADX WARN: Removed duplicated region for block: B:115:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0193 A[Catch: Exception -> 0x0419, TryCatch #2 {Exception -> 0x0419, blocks: (B:50:0x0170, B:53:0x018b, B:55:0x0193, B:57:0x0197, B:58:0x01a1, B:60:0x01a4, B:63:0x01f5, B:66:0x0206, B:68:0x0261, B:70:0x02b8, B:72:0x02bf, B:78:0x0305, B:82:0x033a, B:86:0x0358, B:88:0x035c, B:91:0x0375, B:92:0x038b, B:77:0x02e9, B:94:0x03ae, B:95:0x03b3, B:96:0x03b4, B:103:0x041b), top: B:115:0x0170 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01a4 A[Catch: Exception -> 0x0419, TryCatch #2 {Exception -> 0x0419, blocks: (B:50:0x0170, B:53:0x018b, B:55:0x0193, B:57:0x0197, B:58:0x01a1, B:60:0x01a4, B:63:0x01f5, B:66:0x0206, B:68:0x0261, B:70:0x02b8, B:72:0x02bf, B:78:0x0305, B:82:0x033a, B:86:0x0358, B:88:0x035c, B:91:0x0375, B:92:0x038b, B:77:0x02e9, B:94:0x03ae, B:95:0x03b3, B:96:0x03b4, B:103:0x041b), top: B:115:0x0170 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0205 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0206 A[Catch: Exception -> 0x0419, TryCatch #2 {Exception -> 0x0419, blocks: (B:50:0x0170, B:53:0x018b, B:55:0x0193, B:57:0x0197, B:58:0x01a1, B:60:0x01a4, B:63:0x01f5, B:66:0x0206, B:68:0x0261, B:70:0x02b8, B:72:0x02bf, B:78:0x0305, B:82:0x033a, B:86:0x0358, B:88:0x035c, B:91:0x0375, B:92:0x038b, B:77:0x02e9, B:94:0x03ae, B:95:0x03b3, B:96:0x03b4, B:103:0x041b), top: B:115:0x0170 }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x035c A[Catch: Exception -> 0x0419, TryCatch #2 {Exception -> 0x0419, blocks: (B:50:0x0170, B:53:0x018b, B:55:0x0193, B:57:0x0197, B:58:0x01a1, B:60:0x01a4, B:63:0x01f5, B:66:0x0206, B:68:0x0261, B:70:0x02b8, B:72:0x02bf, B:78:0x0305, B:82:0x033a, B:86:0x0358, B:88:0x035c, B:91:0x0375, B:92:0x038b, B:77:0x02e9, B:94:0x03ae, B:95:0x03b3, B:96:0x03b4, B:103:0x041b), top: B:115:0x0170 }] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0371  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0375 A[Catch: Exception -> 0x0419, TryCatch #2 {Exception -> 0x0419, blocks: (B:50:0x0170, B:53:0x018b, B:55:0x0193, B:57:0x0197, B:58:0x01a1, B:60:0x01a4, B:63:0x01f5, B:66:0x0206, B:68:0x0261, B:70:0x02b8, B:72:0x02bf, B:78:0x0305, B:82:0x033a, B:86:0x0358, B:88:0x035c, B:91:0x0375, B:92:0x038b, B:77:0x02e9, B:94:0x03ae, B:95:0x03b3, B:96:0x03b4, B:103:0x041b), top: B:115:0x0170 }] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x038b A[Catch: Exception -> 0x0419, TryCatch #2 {Exception -> 0x0419, blocks: (B:50:0x0170, B:53:0x018b, B:55:0x0193, B:57:0x0197, B:58:0x01a1, B:60:0x01a4, B:63:0x01f5, B:66:0x0206, B:68:0x0261, B:70:0x02b8, B:72:0x02bf, B:78:0x0305, B:82:0x033a, B:86:0x0358, B:88:0x035c, B:91:0x0375, B:92:0x038b, B:77:0x02e9, B:94:0x03ae, B:95:0x03b3, B:96:0x03b4, B:103:0x041b), top: B:115:0x0170 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x040b -> B:100:0x040e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r37) {
            /*
                Method dump skipped, instruction units count: 1125
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.C0376b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class c extends v implements h9.l<u.a, k0> {

        public static final class a extends v implements p<u.b, Integer, Long> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final a f19377g = new a();

            public a() {
                super(2);
            }

            @NotNull
            public final Long a(@NotNull u.b delayMillis, int i10) {
                t.i(delayMillis, "$this$delayMillis");
                return 100L;
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Long mo4invoke(u.b bVar, Integer num) {
                return a(bVar, num.intValue());
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$c$b, reason: collision with other inner class name */
        public static final class C0377b extends v implements p<u.c, a8.c, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ b f19378g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0377b(b bVar) {
                super(2);
                this.f19378g = bVar;
            }

            public final void a(@NotNull u.c modifyRequest, @NotNull a8.c it) {
                t.i(modifyRequest, "$this$modifyRequest");
                t.i(it, "it");
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f19378g.f19357e, "Retry attempt #" + modifyRequest.b() + " for " + modifyRequest.a().i(), null, false, 12, null);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(u.c cVar, a8.c cVar2) {
                a(cVar, cVar2);
                return k0.f35197a;
            }
        }

        public c() {
            super(1);
        }

        public final void a(@NotNull u.a retry) {
            t.i(retry, "$this$retry");
            retry.u(10);
            u.a.c(retry, false, a.f19377g, 1, null);
            retry.o(10, true);
            retry.s(10);
            retry.l(new C0377b(b.this));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(u.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    public static final class d extends v implements h9.l<e8.l, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f19379g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ b f19380h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f19381i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f19382j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j10, b bVar, int i10, String str) {
            super(1);
            this.f19379g = j10;
            this.f19380h = bVar;
            this.f19381i = i10;
            this.f19382j = str;
        }

        public final void a(@NotNull e8.l headers) {
            t.i(headers, "$this$headers");
            String str = "bytes=" + this.f19379g + '-' + Math.min(this.f19379g + ((long) this.f19380h.f19353a.a()), this.f19381i);
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            String str2 = this.f19380h.f19357e;
            StringBuilder sb = new StringBuilder();
            sb.append("Adding ");
            o oVar = o.f25274a;
            sb.append(oVar.s());
            sb.append(" header: ");
            sb.append(str);
            MolocoLogger.info$default(molocoLogger, str2, sb.toString(), null, false, 12, null);
            headers.f(oVar.s(), str);
            if (this.f19382j != null) {
                MolocoLogger.info$default(molocoLogger, this.f19380h.f19357e, "Adding " + oVar.o() + " header: " + this.f19382j, null, false, 12, null);
                headers.f(oVar.o(), this.f19382j);
                MolocoLogger.info$default(molocoLogger, this.f19380h.f19357e, "Adding " + oVar.l() + " header: " + this.f19382j, null, false, 12, null);
                headers.f(oVar.l(), this.f19382j);
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(e8.l lVar) {
            a(lVar);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl", f = "ChunkedMediaDownloader.kt", l = {275, 277}, m = "writeChunkToFile")
    public static final class e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19383j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f19384k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f19385l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f19386m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f19388o;

        public e(z8.d<? super e> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f19386m = obj;
            this.f19388o |= Integer.MIN_VALUE;
            return b.this.t(null, null, this);
        }
    }

    public b(@NotNull h mediaConfig, @NotNull d0 connectivityService, @NotNull com.moloco.sdk.internal.error.b errorReportingService, @NotNull s7.a httpClient) {
        t.i(mediaConfig, "mediaConfig");
        t.i(connectivityService, "connectivityService");
        t.i(errorReportingService, "errorReportingService");
        t.i(httpClient, "httpClient");
        this.f19353a = mediaConfig;
        this.f19354b = connectivityService;
        this.f19355c = errorReportingService;
        this.f19356d = httpClient;
        this.f19357e = "ChunkedMediaDownloader";
    }

    public final String A(File file) {
        File fileB = B(file);
        if (fileB.exists()) {
            return f9.k.h(fileB, null, 1, null);
        }
        return null;
    }

    public final File B(File file) {
        return new File(file.getParent(), file.getName() + ".range");
    }

    public final void C(File file) {
        w(file).delete();
    }

    public final void D(File file) {
        B(file).delete();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public boolean a(@NotNull File file) {
        t.i(file, "file");
        return file.exists() && !B(file).exists();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public boolean b(@NotNull File file) {
        t.i(file, "file");
        return file.exists() && B(file).exists();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    @Nullable
    public Object c(@NotNull String str, @NotNull File file, @NotNull String str2, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, @NotNull z8.d<? super f.a> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new C0376b(str, file, aVar, str2, null), dVar);
    }

    public final f.a g(File file, b8.c cVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar) {
        int iE0 = cVar.f().e0();
        if (400 <= iE0 && iE0 < 500) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19357e, "Failed to fetch media from url: " + b8.e.e(cVar).getUrl() + ", status: " + cVar.f(), null, false, 12, null);
            if (aVar != null) {
                aVar.a(new c.b(f.a.AbstractC0379a.e.f19409a));
            }
            return f.a.AbstractC0379a.e.f19409a;
        }
        if (500 > iE0 || iE0 >= 600) {
            return new f.a.b(file);
        }
        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f19357e, "Failed to fetch media from url: " + b8.e.e(cVar).getUrl() + ", status: " + cVar.f(), null, false, 12, null);
        if (aVar != null) {
            aVar.a(new c.b(f.a.AbstractC0379a.h.f19412a));
        }
        return f.a.AbstractC0379a.h.f19412a;
    }

    public final f.a h(File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar) {
        C(file);
        D(file);
        if (aVar != null) {
            aVar.c(new c.a(file));
        }
        return new f.a.b(file);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.io.File r18, b8.c r19, z8.d<? super v8.k0> r20) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.k(java.io.File, b8.c, z8.d):java.lang.Object");
    }

    public final Object l(String str, long j10, int i10, String str2, z8.d<? super b8.c> dVar) {
        s7.a aVar = this.f19356d;
        a8.c cVar = new a8.c();
        a8.e.b(cVar, str);
        y7.v.i(cVar, new c());
        a8.e.a(cVar, new d(j10, this, i10, str2));
        cVar.n(e8.t.f25351b.a());
        return new b8.g(cVar, aVar).d(dVar);
    }

    public final void p(File file, b8.c cVar) {
        e8.k kVarB = cVar.b();
        o oVar = o.f25274a;
        String str = kVarB.get(oVar.l());
        if (str != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f19357e, oVar.l() + ": " + str, null, false, 12, null);
            f9.k.k(w(file), str, null, 2, null);
            return;
        }
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.f19357e, "No " + oVar.l() + " in header", null, false, 12, null);
        C(file);
    }

    public final void q(File file, String str) {
        f9.k.k(B(file), str, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095 A[LOOP:0: B:27:0x008f->B:29:0x0095, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008a -> B:26:0x008d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.io.File r19, b8.c r20, z8.d<? super v8.k0> r21) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.t(java.io.File, b8.c, z8.d):java.lang.Object");
    }

    public final File w(File file) {
        return new File(file.getParent(), file.getName() + ".etag");
    }

    public final String z(File file) {
        File fileW = w(file);
        if (fileW.exists()) {
            return f9.k.h(fileW, null, 1, null);
        }
        return null;
    }
}
