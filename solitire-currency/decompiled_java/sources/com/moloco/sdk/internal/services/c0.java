package com.moloco.sdk.internal.services;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class c0 implements b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18610c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z f18611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f18612b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.ClickthroughServiceImpl", f = "ClickthroughService.kt", l = {63, 67}, m = "runClickThrough")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18613j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18614k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f18615l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18617n;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18615l = obj;
            this.f18617n |= Integer.MIN_VALUE;
            return c0.this.a(null, null, null, null, this);
        }
    }

    public c0(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z externalLinkHandler, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService) {
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        this.f18611a = externalLinkHandler;
        this.f18612b = customUserEventBuilderService;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.b0
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a r20, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i r21, @org.jetbrains.annotations.Nullable s9.x<v8.k0> r22, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r23) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.c0.a(java.lang.String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i, s9.x, z8.d):java.lang.Object");
    }
}
