package com.moloco.sdk.internal.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.core.net.ConnectivityManagerCompat;
import com.moloco.sdk.internal.MolocoLogger;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18625b;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.ConnectivityServiceImpl", f = "ConnectivityService.kt", l = {40}, m = "waitForNetwork")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f18626j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f18628l;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18626j = obj;
            this.f18628l |= Integer.MIN_VALUE;
            return e0.this.a(0L, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.ConnectivityServiceImpl$waitForNetwork$hasConnectivity$1", f = "ConnectivityService.kt", l = {46}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18629j;

        public b(z8.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super Boolean> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e0.this.new b(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18629j;
            if (i10 != 0 && i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            while (!e0.this.d()) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, e0.this.f18625b, "waiting because of no network connection", null, false, 12, null);
                this.f18629j = 1;
                if (y0.a(100L, this) == objE) {
                    return objE;
                }
            }
            return kotlin.coroutines.jvm.internal.b.a(true);
        }
    }

    public e0(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f18624a = context;
        this.f18625b = "ConnectivityServiceImpl";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.d0
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(long r5, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.moloco.sdk.internal.services.e0.a
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.internal.services.e0$a r0 = (com.moloco.sdk.internal.services.e0.a) r0
            int r1 = r0.f18628l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18628l = r1
            goto L18
        L13:
            com.moloco.sdk.internal.services.e0$a r0 = new com.moloco.sdk.internal.services.e0$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f18626j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18628l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            v8.u.b(r7)
            com.moloco.sdk.internal.services.e0$b r7 = new com.moloco.sdk.internal.services.e0$b
            r2 = 0
            r7.<init>(r2)
            r0.f18628l = r3
            java.lang.Object r7 = kotlinx.coroutines.f3.e(r5, r7, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L4c
            boolean r5 = r7.booleanValue()
            goto L4d
        L4c:
            r5 = 0
        L4d:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.e0.a(long, z8.d):java.lang.Object");
    }

    @Override // com.moloco.sdk.internal.services.d0
    public boolean b() {
        try {
            return ConnectivityManagerCompat.isActiveNetworkMetered(b(this.f18624a));
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "isNetworkMetered", e10.toString(), e10, false, 8, null);
            return false;
        }
    }

    public boolean d() {
        NetworkCapabilities networkCapabilities;
        Object systemService = this.f18624a.getSystemService("connectivity");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    public final ConnectivityManager b(Context context) {
        Object systemService = context.getSystemService("connectivity");
        kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }
}
