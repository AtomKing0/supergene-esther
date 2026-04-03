package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.d0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final d0 f19389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.error.b f19390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final s7.a f19391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f19392d;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.LegacyMediaDownloader$downloadMedia$2", f = "LegacyMediaDownloader.kt", l = {42, 52, 63, 63}, m = "invokeSuspend")
    public static final class a extends l implements p<o0, z8.d<? super f.a>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19393j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f19394k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f19395l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f19397n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ File f19398o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, File file, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f19397n = str;
            this.f19398o = file;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super f.a> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new a(this.f19397n, this.f19398o, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x015b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x017b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x017c  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0205  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0236  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) throws com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.k {
            /*
                Method dump skipped, instruction units count: 607
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b extends v implements h9.l<u.a, k0> {

        public static final class a extends v implements p<u.b, Integer, Long> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final a f19400g = new a();

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

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.c$b$b, reason: collision with other inner class name */
        public static final class C0378b extends v implements p<u.c, a8.c, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ c f19401g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0378b(c cVar) {
                super(2);
                this.f19401g = cVar;
            }

            public final void a(@NotNull u.c modifyRequest, @NotNull a8.c it) {
                t.i(modifyRequest, "$this$modifyRequest");
                t.i(it, "it");
                MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f19401g.f19392d, "Retry attempt #" + modifyRequest.b() + " for " + modifyRequest.a().i(), null, false, 12, null);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(u.c cVar, a8.c cVar2) {
                a(cVar, cVar2);
                return k0.f35197a;
            }
        }

        public b() {
            super(1);
        }

        public final void a(@NotNull u.a retry) {
            t.i(retry, "$this$retry");
            retry.u(10);
            u.a.c(retry, false, a.f19400g, 1, null);
            retry.o(10, true);
            retry.s(10);
            retry.l(new C0378b(c.this));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(u.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    public c(@NotNull d0 connectivityService, @NotNull com.moloco.sdk.internal.error.b errorReportingService, @NotNull s7.a httpClient) {
        t.i(connectivityService, "connectivityService");
        t.i(errorReportingService, "errorReportingService");
        t.i(httpClient, "httpClient");
        this.f19389a = connectivityService;
        this.f19390b = errorReportingService;
        this.f19391c = httpClient;
        this.f19392d = "LegacyMediaDownloader";
    }

    @Nullable
    public Object c(@NotNull String str, @NotNull File file, @NotNull z8.d<? super f.a> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new a(str, file, null), dVar);
    }

    public final Object d(String str, z8.d<? super b8.c> dVar) {
        s7.a aVar = this.f19391c;
        a8.c cVar = new a8.c();
        a8.e.b(cVar, str);
        y7.v.i(cVar, new b());
        cVar.n(e8.t.f25351b.a());
        return new b8.g(cVar, aVar).d(dVar);
    }

    public final String f(boolean z10) {
        return z10 ? "HTTP_REQUEST_COMPLETE_TIMEOUT" : "HTTP_REQUEST_NOT_COMPLETE_TIMEOUT";
    }
}
