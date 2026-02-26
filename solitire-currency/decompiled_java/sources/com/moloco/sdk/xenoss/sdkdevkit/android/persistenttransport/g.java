package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import h9.p;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting(otherwise = 2)
public final class g implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final s7.a f21723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final o0 f21724c;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.NonPersistentHttpRequestImpl$send$1", f = "NonPersistentHttpRequest.kt", l = {48, 52}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21725j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f21726k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f21728m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f21728m = str;
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
            return g.this.new a(this.f21728m, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0094 -> B:28:0x0097). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r14.f21726k
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L28
                if (r1 == r4) goto L1f
                if (r1 != r2) goto L17
                int r1 = r14.f21725j
                v8.u.b(r15)
                r15 = r14
                goto L97
            L17:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L1f:
                int r1 = r14.f21725j
                v8.u.b(r15)
                r5 = r1
                r1 = r0
                r0 = r14
                goto L77
            L28:
                v8.u.b(r15)
                r15 = r14
                r1 = r3
            L2d:
                r5 = 5
                if (r1 >= r5) goto L99
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                r6 = 0
                android.content.Context r6 = com.moloco.sdk.internal.android_context.b.b(r6, r4, r6)
                boolean r5 = r5.c(r6)
                com.moloco.sdk.internal.MolocoLogger r6 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
                java.lang.String r7 = "NonPersistentRequest"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "Network available: "
                r8.append(r9)
                r8.append(r5)
                java.lang.String r9 = " for non persistent request"
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r9 = 0
                r10 = 0
                r11 = 12
                r12 = 0
                com.moloco.sdk.internal.MolocoLogger.info$default(r6, r7, r8, r9, r10, r11, r12)
                if (r5 == 0) goto L7e
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                s7.a r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.b(r5)
                java.lang.String r6 = r15.f21728m
                r15.f21725j = r1
                r15.f21726k = r4
                java.lang.Object r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(r5, r6, r15)
                if (r5 != r0) goto L72
                return r0
            L72:
                r13 = r0
                r0 = r15
                r15 = r5
                r5 = r1
                r1 = r13
            L77:
                java.lang.Boolean r15 = (java.lang.Boolean) r15
                boolean r15 = r15.booleanValue()
                goto L82
            L7e:
                r5 = r1
                r1 = r0
                r0 = r15
                r15 = r3
            L82:
                if (r15 == 0) goto L87
                v8.k0 r15 = v8.k0.f35197a
                return r15
            L87:
                r0.f21725j = r5
                r0.f21726k = r2
                r6 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r15 = kotlinx.coroutines.y0.a(r6, r0)
                if (r15 != r1) goto L94
                return r1
            L94:
                r15 = r0
                r0 = r1
                r1 = r5
            L97:
                int r1 = r1 + r4
                goto L2d
            L99:
                v8.k0 r15 = v8.k0.f35197a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.NonPersistentHttpRequestImpl$sendPost$1", f = "NonPersistentHttpRequest.kt", l = {63, 67}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21729j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f21730k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f21732m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ byte[] f21733n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ e8.c f21734o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, byte[] bArr, e8.c cVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f21732m = str;
            this.f21733n = bArr;
            this.f21734o = cVar;
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
            return g.this.new b(this.f21732m, this.f21733n, this.f21734o, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:28:0x009b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r14.f21730k
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L28
                if (r1 == r4) goto L1f
                if (r1 != r2) goto L17
                int r1 = r14.f21729j
                v8.u.b(r15)
                r15 = r14
                goto L9b
            L17:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L1f:
                int r1 = r14.f21729j
                v8.u.b(r15)
                r5 = r1
                r1 = r0
                r0 = r14
                goto L7b
            L28:
                v8.u.b(r15)
                r15 = r14
                r1 = r3
            L2d:
                r5 = 5
                if (r1 >= r5) goto L9d
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                r6 = 0
                android.content.Context r6 = com.moloco.sdk.internal.android_context.b.b(r6, r4, r6)
                boolean r5 = r5.c(r6)
                com.moloco.sdk.internal.MolocoLogger r6 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
                java.lang.String r7 = "NonPersistentRequest"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "Network available: "
                r8.append(r9)
                r8.append(r5)
                java.lang.String r9 = " for non persistent request"
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r9 = 0
                r10 = 0
                r11 = 12
                r12 = 0
                com.moloco.sdk.internal.MolocoLogger.info$default(r6, r7, r8, r9, r10, r11, r12)
                if (r5 == 0) goto L82
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                s7.a r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.b(r5)
                java.lang.String r6 = r15.f21732m
                byte[] r7 = r15.f21733n
                e8.c r8 = r15.f21734o
                r15.f21729j = r1
                r15.f21730k = r4
                java.lang.Object r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.b(r5, r6, r7, r8, r15)
                if (r5 != r0) goto L76
                return r0
            L76:
                r13 = r0
                r0 = r15
                r15 = r5
                r5 = r1
                r1 = r13
            L7b:
                java.lang.Boolean r15 = (java.lang.Boolean) r15
                boolean r15 = r15.booleanValue()
                goto L86
            L82:
                r5 = r1
                r1 = r0
                r0 = r15
                r15 = r3
            L86:
                if (r15 == 0) goto L8b
                v8.k0 r15 = v8.k0.f35197a
                return r15
            L8b:
                r0.f21729j = r5
                r0.f21730k = r2
                r6 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r15 = kotlinx.coroutines.y0.a(r6, r0)
                if (r15 != r1) goto L98
                return r1
            L98:
                r15 = r0
                r0 = r1
                r1 = r5
            L9b:
                int r1 = r1 + r4
                goto L2d
            L9d:
                v8.k0 r15 = v8.k0.f35197a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public g(@NotNull s7.a httpClient) {
        t.i(httpClient, "httpClient");
        this.f21723b = httpClient;
        this.f21724c = p0.a(com.moloco.sdk.internal.scheduling.c.a().getDefault());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(@NotNull String url) {
        t.i(url, "url");
        kotlinx.coroutines.k.d(this.f21724c, null, null, new a(url, null), 3, null);
    }

    @VisibleForTesting(otherwise = 2)
    public final boolean c(@NotNull Context context) {
        t.i(context, "context");
        Object systemService = context.getSystemService("connectivity");
        t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return d((ConnectivityManager) systemService);
    }

    @RequiresApi(23)
    public final boolean d(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(@NotNull String url, @NotNull byte[] body, @NotNull e8.c contentType) {
        t.i(url, "url");
        t.i(body, "body");
        t.i(contentType, "contentType");
        kotlinx.coroutines.k.d(this.f21724c, null, null, new b(url, body, contentType, null), 3, null);
    }
}
