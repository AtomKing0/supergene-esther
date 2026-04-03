package com.moloco.sdk.acm.eventprocessing;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.ironsource.ad;
import com.moloco.sdk.acm.db.MetricsDb;
import h9.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.y;

/* JADX INFO: loaded from: classes4.dex */
public final class DBRequestWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.db.d f17361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f17362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final Map<String, String> f17363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final l<e8.l, k0> f17364e;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.eventprocessing.DBRequestWorker", f = "DBWorkRequest.kt", l = {110}, m = "doWork")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17365j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f17366k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f17368m;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17366k = obj;
            this.f17368m |= Integer.MIN_VALUE;
            return DBRequestWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBRequestWorker(@NotNull Context context, @NotNull WorkerParameters params) {
        super(context, params);
        t.i(context, "context");
        t.i(params, "params");
        this.f17360a = "DBRequestWorker";
        this.f17361b = MetricsDb.f17323a.b(context).c();
        this.f17362c = getInputData().getString("url");
        Map mapJ = r0.j(y.a("AppKey", getInputData().getString("AppKey")), y.a("AppBundle", getInputData().getString("AppBundle")), y.a("AppVersion", getInputData().getString("AppVersion")), y.a("OS", getInputData().getString("OS")), y.a(ad.f11278z, getInputData().getString(ad.f11278z)), y.a("SdkVersion", getInputData().getString("SdkVersion")), y.a("Mediator", getInputData().getString("Mediator")));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapJ.entrySet()) {
            if (((String) entry.getValue()) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.f17363d = linkedHashMap;
        this.f17364e = new com.moloco.sdk.acm.http.a().a((String) linkedHashMap.get("SdkVersion"), (String) linkedHashMap.get(ad.f11278z), (String) linkedHashMap.get("AppKey"), (String) linkedHashMap.get("AppBundle"), (String) linkedHashMap.get("AppVersion"), (String) linkedHashMap.get("Mediator"));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull z8.d<? super androidx.work.ListenableWorker.Result> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.moloco.sdk.acm.eventprocessing.DBRequestWorker.a
            if (r0 == 0) goto L13
            r0 = r10
            com.moloco.sdk.acm.eventprocessing.DBRequestWorker$a r0 = (com.moloco.sdk.acm.eventprocessing.DBRequestWorker.a) r0
            int r1 = r0.f17368m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17368m = r1
            goto L18
        L13:
            com.moloco.sdk.acm.eventprocessing.DBRequestWorker$a r0 = new com.moloco.sdk.acm.eventprocessing.DBRequestWorker$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f17366k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f17368m
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r0 = r0.f17365j
            com.moloco.sdk.acm.eventprocessing.DBRequestWorker r0 = (com.moloco.sdk.acm.eventprocessing.DBRequestWorker) r0
            v8.u.b(r10)     // Catch: java.lang.Exception -> L32
            v8.t r10 = (v8.t) r10     // Catch: java.lang.Exception -> L32
            r10.j()     // Catch: java.lang.Exception -> L32
            goto L73
        L32:
            r10 = move-exception
            goto L7f
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3c:
            v8.u.b(r10)
            java.lang.String r10 = r9.f17362c     // Catch: java.lang.Exception -> L7d
            if (r10 == 0) goto L72
            com.moloco.sdk.acm.http.b r10 = com.moloco.sdk.acm.http.b.f17436a     // Catch: java.lang.Exception -> L7d
            s7.a r2 = com.moloco.sdk.acm.http.c.b()     // Catch: java.lang.Exception -> L7d
            java.lang.String r4 = r9.f17362c     // Catch: java.lang.Exception -> L7d
            r10.b(r2, r4)     // Catch: java.lang.Exception -> L7d
            com.moloco.sdk.acm.eventprocessing.h r2 = new com.moloco.sdk.acm.eventprocessing.h     // Catch: java.lang.Exception -> L7d
            com.moloco.sdk.acm.http.e r10 = r10.d()     // Catch: java.lang.Exception -> L7d
            com.moloco.sdk.acm.db.d r4 = r9.f17361b     // Catch: java.lang.Exception -> L7d
            com.moloco.sdk.acm.eventprocessing.e r5 = new com.moloco.sdk.acm.eventprocessing.e     // Catch: java.lang.Exception -> L7d
            com.moloco.sdk.acm.services.h r6 = new com.moloco.sdk.acm.services.h     // Catch: java.lang.Exception -> L7d
            r6.<init>()     // Catch: java.lang.Exception -> L7d
            r7 = 720(0x2d0, double:3.557E-321)
            r5.<init>(r6, r7)     // Catch: java.lang.Exception -> L7d
            h9.l<e8.l, v8.k0> r6 = r9.f17364e     // Catch: java.lang.Exception -> L7d
            r2.<init>(r10, r4, r5, r6)     // Catch: java.lang.Exception -> L7d
            r0.f17365j = r9     // Catch: java.lang.Exception -> L7d
            r0.f17368m = r3     // Catch: java.lang.Exception -> L7d
            java.lang.Object r10 = r2.a(r0)     // Catch: java.lang.Exception -> L7d
            if (r10 != r1) goto L72
            return r1
        L72:
            r0 = r9
        L73:
            androidx.work.ListenableWorker$Result r10 = androidx.work.ListenableWorker.Result.success()     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = "{\n            if (url !=…esult.success()\n        }"
            kotlin.jvm.internal.t.h(r10, r1)     // Catch: java.lang.Exception -> L32
            goto La9
        L7d:
            r10 = move-exception
            r0 = r9
        L7f:
            com.moloco.sdk.acm.services.e r1 = com.moloco.sdk.acm.services.e.f17473a
            java.lang.String r2 = r0.f17360a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Work Manager failure: "
            r0.append(r3)
            java.lang.String r10 = r10.getMessage()
            r0.append(r10)
            java.lang.String r3 = r0.toString()
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            com.moloco.sdk.acm.services.e.e(r1, r2, r3, r4, r5, r6, r7)
            androidx.work.ListenableWorker$Result r10 = androidx.work.ListenableWorker.Result.failure()
            java.lang.String r0 = "{\n            MolocoMetr…esult.failure()\n        }"
            kotlin.jvm.internal.t.h(r10, r0)
        La9:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.eventprocessing.DBRequestWorker.doWork(z8.d):java.lang.Object");
    }
}
