package com.moloco.sdk.acm.http;

import com.moloco.sdk.k;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import y7.y;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final s7.a f17446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f17447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f17448c;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.http.PostMetricsRequestImpl", f = "PostMetricsRequest.kt", l = {54}, m = "execute-0E7RQCE")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f17449j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f17451l;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17449j = obj;
            this.f17451l |= Integer.MIN_VALUE;
            Object objA = f.this.a(null, null, this);
            return objA == a9.d.e() ? objA : t.a(objA);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.http.PostMetricsRequestImpl", f = "PostMetricsRequest.kt", l = {133, 82}, m = "makeMetricsRequest-BWLJW6A")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17452j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17453k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f17454l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17456n;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17454l = obj;
            this.f17456n |= Integer.MIN_VALUE;
            Object objB = f.this.b(0L, null, null, this);
            return objB == a9.d.e() ? objB : t.a(objB);
        }
    }

    public static final class c extends v implements l<y.a, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f17457g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j10) {
            super(1);
            this.f17457g = j10;
        }

        public final void a(@NotNull y.a timeout) {
            kotlin.jvm.internal.t.i(timeout, "$this$timeout");
            timeout.g(Long.valueOf(this.f17457g));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(y.a aVar) {
            a(aVar);
            return k0.f35197a;
        }
    }

    public f(@NotNull s7.a httpClient, @NotNull String apiUrl) {
        kotlin.jvm.internal.t.i(httpClient, "httpClient");
        kotlin.jvm.internal.t.i(apiUrl, "apiUrl");
        this.f17446a = httpClient;
        this.f17447b = apiUrl;
        this.f17448c = "PostMetricsRequest";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.http.e
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull com.moloco.sdk.acm.http.d r8, @org.jetbrains.annotations.NotNull h9.l<? super e8.l, v8.k0> r9, @org.jetbrains.annotations.NotNull z8.d<? super v8.t<java.lang.String>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.moloco.sdk.acm.http.f.a
            if (r0 == 0) goto L13
            r0 = r10
            com.moloco.sdk.acm.http.f$a r0 = (com.moloco.sdk.acm.http.f.a) r0
            int r1 = r0.f17451l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17451l = r1
            goto L18
        L13:
            com.moloco.sdk.acm.http.f$a r0 = new com.moloco.sdk.acm.http.f$a
            r0.<init>(r10)
        L18:
            r6 = r0
            java.lang.Object r10 = r6.f17449j
            java.lang.Object r0 = a9.b.e()
            int r1 = r6.f17451l
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            v8.u.b(r10)
            v8.t r10 = (v8.t) r10
            java.lang.Object r8 = r10.j()
            goto L49
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            v8.u.b(r10)
            r6.f17451l = r2
            r2 = 5000(0x1388, double:2.4703E-320)
            r1 = r7
            r4 = r8
            r5 = r9
            java.lang.Object r8 = r1.b(r2, r4, r5, r6)
            if (r8 != r0) goto L49
            return r0
        L49:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.http.f.a(com.moloco.sdk.acm.http.d, h9.l, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee A[Catch: Exception -> 0x0036, TryCatch #2 {Exception -> 0x0036, blocks: (B:13:0x0031, B:40:0x00e0, B:42:0x00ee, B:43:0x010e), top: B:56:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010e A[Catch: Exception -> 0x0036, TRY_LEAVE, TryCatch #2 {Exception -> 0x0036, blocks: (B:13:0x0031, B:40:0x00e0, B:42:0x00ee, B:43:0x010e), top: B:56:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r9, com.moloco.sdk.acm.http.d r11, h9.l<? super e8.l, v8.k0> r12, z8.d<? super v8.t<java.lang.String>> r13) {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.http.f.b(long, com.moloco.sdk.acm.http.d, h9.l, z8.d):java.lang.Object");
    }

    public final byte[] d(d dVar) {
        k kVarBuild = k.h().b(dVar.a()).c(dVar.b()).build();
        kotlin.jvm.internal.t.h(kVarBuild, "newBuilder()\n           …ers)\n            .build()");
        byte[] byteArray = kVarBuild.toByteArray();
        kotlin.jvm.internal.t.h(byteArray, "metricsRequest.toByteArray()");
        return byteArray;
    }
}
