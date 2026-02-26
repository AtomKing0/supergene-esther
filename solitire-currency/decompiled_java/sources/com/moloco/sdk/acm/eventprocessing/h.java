package com.moloco.sdk.acm.eventprocessing;

import h9.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.http.e f17392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.db.d f17393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final e f17394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final l<e8.l, k0> f17395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f17396e;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.eventprocessing.RequestAndPurgeDBImpl", f = "RequestAndPurgeDB.kt", l = {38, 48}, m = "invoke-IoAF18A")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17397j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f17398k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f17400m;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17398k = obj;
            this.f17400m |= Integer.MIN_VALUE;
            Object objA = h.this.a(this);
            return objA == a9.d.e() ? objA : t.a(objA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull com.moloco.sdk.acm.http.e metricsRequest, @NotNull com.moloco.sdk.acm.db.d metricsDAO, @NotNull e dataAgeChecker, @NotNull l<? super e8.l, k0> headers) {
        kotlin.jvm.internal.t.i(metricsRequest, "metricsRequest");
        kotlin.jvm.internal.t.i(metricsDAO, "metricsDAO");
        kotlin.jvm.internal.t.i(dataAgeChecker, "dataAgeChecker");
        kotlin.jvm.internal.t.i(headers, "headers");
        this.f17392a = metricsRequest;
        this.f17393b = metricsDAO;
        this.f17394c = dataAgeChecker;
        this.f17395d = headers;
        this.f17396e = "RequestAndPurgeDB";
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull z8.d<? super v8.t<java.lang.String>> r11) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.eventprocessing.h.a(z8.d):java.lang.Object");
    }
}
