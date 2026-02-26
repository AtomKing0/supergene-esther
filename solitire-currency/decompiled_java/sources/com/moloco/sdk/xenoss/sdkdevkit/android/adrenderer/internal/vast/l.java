package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements k {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserImpl", f = "VastParser.kt", l = {65}, m = "invoke")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20265j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20266k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20268m;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20266k = obj;
            this.f20268m |= Integer.MIN_VALUE;
            return l.this.b(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[Catch: all -> 0x002d, TryCatch #3 {all -> 0x002d, blocks: (B:12:0x0029, B:24:0x005f, B:26:0x0063, B:27:0x0069), top: B:44:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069 A[Catch: all -> 0x002d, TRY_LEAVE, TryCatch #3 {all -> 0x002d, blocks: (B:12:0x0029, B:24:0x005f, B:26:0x0063, B:27:0x0069), top: B:44:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l.a
            if (r0 == 0) goto L13
            r0 = r8
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l.a) r0
            int r1 = r0.f20268m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20268m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f20266k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20268m
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r7 = r0.f20265j
            java.io.Closeable r7 = (java.io.Closeable) r7
            v8.u.b(r8)     // Catch: java.lang.Throwable -> L2d
            goto L5f
        L2d:
            r8 = move-exception
            goto L79
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            v8.u.b(r8)
            java.io.StringReader r8 = new java.io.StringReader     // Catch: java.lang.Exception -> L7f
            r8.<init>(r7)     // Catch: java.lang.Exception -> L7f
            org.xmlpull.v1.XmlPullParser r7 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L75
            java.lang.String r2 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r4 = 0
            r7.setFeature(r2, r4)     // Catch: java.lang.Throwable -> L75
            r7.setInput(r8)     // Catch: java.lang.Throwable -> L75
            java.lang.String r2 = "parser"
            kotlin.jvm.internal.t.h(r7, r2)     // Catch: java.lang.Throwable -> L75
            r0.f20265j = r8     // Catch: java.lang.Throwable -> L75
            r0.f20268m = r3     // Catch: java.lang.Throwable -> L75
            java.lang.Object r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.B0(r7, r0)     // Catch: java.lang.Throwable -> L75
            if (r7 != r1) goto L5c
            return r1
        L5c:
            r5 = r8
            r8 = r7
            r7 = r5
        L5f:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y r8 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y) r8     // Catch: java.lang.Throwable -> L2d
            if (r8 == 0) goto L69
            com.moloco.sdk.internal.t$b r0 = new com.moloco.sdk.internal.t$b     // Catch: java.lang.Throwable -> L2d
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L2d
            goto L70
        L69:
            com.moloco.sdk.internal.t$a r0 = new com.moloco.sdk.internal.t$a     // Catch: java.lang.Throwable -> L2d
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k r8 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_NO_XML_TAG_ERROR     // Catch: java.lang.Throwable -> L2d
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L2d
        L70:
            r8 = 0
            f9.c.a(r7, r8)     // Catch: java.lang.Exception -> L7f
            goto L86
        L75:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L79:
            throw r8     // Catch: java.lang.Throwable -> L7a
        L7a:
            r0 = move-exception
            f9.c.a(r7, r8)     // Catch: java.lang.Exception -> L7f
            throw r0     // Catch: java.lang.Exception -> L7f
        L7f:
            com.moloco.sdk.internal.t$a r0 = new com.moloco.sdk.internal.t$a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_XML_PARSE_ERROR
            r0.<init>(r7)
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l.b(java.lang.String, z8.d):java.lang.Object");
    }
}
