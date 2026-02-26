package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
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
public final class UrlPostRequestWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f21702a = {o0.f(new e0(UrlPostRequestWorker.class, "url", "<v#0>", 0))};

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlPostRequestWorker", f = "PersistentHttpRequest.kt", l = {102}, m = "doWork")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f21703j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f21704k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f21705l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f21707n;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21705l = obj;
            this.f21707n |= Integer.MIN_VALUE;
            return UrlPostRequestWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlPostRequestWorker(@NotNull Context context, @NotNull WorkerParameters params) {
        super(com.moloco.sdk.internal.android_context.b.a(context), params);
        t.i(context, "context");
        t.i(params, "params");
    }

    public static final String b(Map<String, Object> map) {
        t.h(map, "doWork$lambda$0(...)");
        return (String) p0.a(map, f21702a[0].getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull z8.d<? super androidx.work.ListenableWorker.Result> r13) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.UrlPostRequestWorker.doWork(z8.d):java.lang.Object");
    }
}
