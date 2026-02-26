package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import java.util.Map;
import kotlin.collections.p0;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class UrlGetRequestWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f21697a = {o0.f(new e0(UrlGetRequestWorker.class, "url", "<v#0>", 0))};

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker", f = "PersistentHttpRequest.kt", l = {82}, m = "doWork")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f21698j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f21699k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f21701m;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21699k = obj;
            this.f21701m |= Integer.MIN_VALUE;
            return UrlGetRequestWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlGetRequestWorker(@NotNull Context context, @NotNull WorkerParameters params) {
        super(com.moloco.sdk.internal.android_context.b.a(context), params);
        t.i(context, "context");
        t.i(params, "params");
    }

    public static final String b(Map<String, Object> map) {
        t.h(map, "doWork$lambda$0(...)");
        return (String) p0.a(map, f21697a[0].getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull z8.d<? super androidx.work.ListenableWorker.Result> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker.a
            if (r0 == 0) goto L13
            r0 = r12
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker.a) r0
            int r1 = r0.f21701m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21701m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker$a
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f21699k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f21701m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f21698j
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker) r0
            v8.u.b(r12)
            goto L77
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L35:
            v8.u.b(r12)
            com.moloco.sdk.service_locator.a$i r12 = com.moloco.sdk.service_locator.a.i.f18932a
            s7.a r12 = r12.a()
            androidx.work.Data r2 = r11.getInputData()
            java.util.Map r2 = r2.getKeyValueMap()
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Sending request to "
            r5.append(r6)
            java.lang.String r6 = b(r2)
            r5.append(r6)
            java.lang.String r6 = r5.toString()
            java.lang.String r5 = "PersistentHttpRequest"
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r2 = b(r2)
            r0.f21698j = r11
            r0.f21701m = r3
            java.lang.Object r12 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(r12, r2, r0)
            if (r12 != r1) goto L76
            return r1
        L76:
            r0 = r11
        L77:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L89
            androidx.work.ListenableWorker$Result r12 = androidx.work.ListenableWorker.Result.success()
            java.lang.String r0 = "success()"
            kotlin.jvm.internal.t.h(r12, r0)
            goto La3
        L89:
            int r12 = r0.getRunAttemptCount()
            r0 = 5
            if (r12 < r0) goto L9a
            androidx.work.ListenableWorker$Result r12 = androidx.work.ListenableWorker.Result.failure()
            java.lang.String r0 = "failure()"
            kotlin.jvm.internal.t.h(r12, r0)
            goto La3
        L9a:
            androidx.work.ListenableWorker$Result r12 = androidx.work.ListenableWorker.Result.retry()
            java.lang.String r0 = "retry()"
            kotlin.jvm.internal.t.h(r12, r0)
        La3:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlGetRequestWorker.doWork(z8.d):java.lang.Object");
    }
}
