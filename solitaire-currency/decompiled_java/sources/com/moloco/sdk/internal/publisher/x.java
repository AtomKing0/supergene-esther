package com.moloco.sdk.internal.publisher;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18333c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.ortb.a f18334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final y f18335b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", l = {33, 46}, m = "parse")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18336j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18337k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f18338l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18340n;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18338l = obj;
            this.f18340n |= Integer.MIN_VALUE;
            return x.this.b(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", l = {71}, m = "parseBidResponse")
    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18341j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18342k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18344m;

        public c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18342k = obj;
            this.f18344m |= Integer.MIN_VALUE;
            return x.this.d(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", l = {58}, m = "processBidResponse$moloco_sdk_release")
    public static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18345j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f18346k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18348m;

        public d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18346k = obj;
            this.f18348m |= Integer.MIN_VALUE;
            return x.this.c(null, this);
        }
    }

    public x(@NotNull com.moloco.sdk.internal.ortb.a bidResponseParser, @NotNull y bidProcessor) {
        kotlin.jvm.internal.t.i(bidResponseParser, "bidResponseParser");
        kotlin.jvm.internal.t.i(bidProcessor, "bidProcessor");
        this.f18334a = bidResponseParser;
        this.f18335b = bidProcessor;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(@org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.internal.q>> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.moloco.sdk.internal.publisher.x.b
            if (r0 == 0) goto L13
            r0 = r14
            com.moloco.sdk.internal.publisher.x$b r0 = (com.moloco.sdk.internal.publisher.x.b) r0
            int r1 = r0.f18340n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18340n = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.x$b r0 = new com.moloco.sdk.internal.publisher.x$b
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f18338l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18340n
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r14)
            goto L9a
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L34:
            java.lang.Object r12 = r0.f18337k
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r0.f18336j
            com.moloco.sdk.internal.publisher.x r13 = (com.moloco.sdk.internal.publisher.x) r13
            v8.u.b(r14)
            goto L6c
        L40:
            v8.u.b(r14)
            com.moloco.sdk.internal.MolocoLogger r5 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r2 = "parse() called with bidResponseJson: "
            r14.append(r2)
            r14.append(r13)
            java.lang.String r7 = r14.toString()
            java.lang.String r6 = "BidLoader"
            r8 = 0
            r9 = 4
            r10 = 0
            com.moloco.sdk.internal.MolocoLogger.debug$default(r5, r6, r7, r8, r9, r10)
            r0.f18336j = r11
            r0.f18337k = r12
            r0.f18340n = r4
            java.lang.Object r14 = r11.c(r13, r0)
            if (r14 != r1) goto L6b
            return r1
        L6b:
            r13 = r11
        L6c:
            java.lang.String r14 = (java.lang.String) r14
            if (r14 != 0) goto L7e
            com.moloco.sdk.publisher.MolocoAdError$ErrorType r13 = com.moloco.sdk.publisher.MolocoAdError.ErrorType.AD_BID_PARSE_ERROR
            com.moloco.sdk.internal.n r14 = com.moloco.sdk.internal.n.BID_LOAD_ERROR_CANNOT_PROCESS_BID_RESPONSE
            com.moloco.sdk.internal.q r12 = com.moloco.sdk.internal.r.a(r12, r13, r14)
            com.moloco.sdk.internal.t$a r13 = new com.moloco.sdk.internal.t$a
            r13.<init>(r12)
            return r13
        L7e:
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r5 = "BidLoader"
            java.lang.String r6 = "Processed the bidResponse, proceeding with parsing it."
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r4, r5, r6, r7, r8, r9, r10)
            r2 = 0
            r0.f18336j = r2
            r0.f18337k = r2
            r0.f18340n = r3
            java.lang.Object r14 = r13.d(r14, r12, r0)
            if (r14 != r1) goto L9a
            return r1
        L9a:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.x.b(java.lang.String, java.lang.String, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.String> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.moloco.sdk.internal.publisher.x.d
            if (r0 == 0) goto L13
            r0 = r9
            com.moloco.sdk.internal.publisher.x$d r0 = (com.moloco.sdk.internal.publisher.x.d) r0
            int r1 = r0.f18348m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18348m = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.x$d r0 = new com.moloco.sdk.internal.publisher.x$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f18346k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18348m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.f18345j
            java.lang.String r8 = (java.lang.String) r8
            v8.u.b(r9)
            goto L45
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            v8.u.b(r9)
            com.moloco.sdk.internal.publisher.y r9 = r7.f18335b
            r0.f18345j = r8
            r0.f18348m = r3
            java.lang.Object r9 = r9.b(r8, r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L58
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r1 = "BidLoader"
            java.lang.String r2 = "Found no pre-preprocessor for the current mediation. Returning the original bid response."
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            com.moloco.sdk.internal.MolocoLogger.warn$default(r0, r1, r2, r3, r4, r5, r6)
            return r9
        L58:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.x.c(java.lang.String, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r8, java.lang.String r9, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.internal.q>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.moloco.sdk.internal.publisher.x.c
            if (r0 == 0) goto L13
            r0 = r10
            com.moloco.sdk.internal.publisher.x$c r0 = (com.moloco.sdk.internal.publisher.x.c) r0
            int r1 = r0.f18344m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18344m = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.x$c r0 = new com.moloco.sdk.internal.publisher.x$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f18342k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18344m
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.f18341j
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            v8.u.b(r10)
            goto L46
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            v8.u.b(r10)
            com.moloco.sdk.internal.ortb.a r10 = r7.f18334a
            r0.f18341j = r9
            r0.f18344m = r3
            java.lang.Object r10 = r10.b(r8, r0)
            if (r10 != r1) goto L46
            return r1
        L46:
            com.moloco.sdk.internal.t r10 = (com.moloco.sdk.internal.t) r10
            boolean r8 = r10 instanceof com.moloco.sdk.internal.t.a
            if (r8 == 0) goto L70
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            com.moloco.sdk.internal.t$a r10 = (com.moloco.sdk.internal.t.a) r10
            java.lang.Object r8 = r10.a()
            r3 = r8
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.String r1 = "BidLoader"
            java.lang.String r2 = "parseBidResponse failed to parse BID json string."
            r4 = 0
            r5 = 8
            r6 = 0
            com.moloco.sdk.internal.MolocoLogger.error$default(r0, r1, r2, r3, r4, r5, r6)
            com.moloco.sdk.publisher.MolocoAdError$ErrorType r8 = com.moloco.sdk.publisher.MolocoAdError.ErrorType.AD_BID_PARSE_ERROR
            com.moloco.sdk.internal.n r10 = com.moloco.sdk.internal.n.BID_LOAD_ERROR_CANNOT_PARSE_BID_RESPONSE
            com.moloco.sdk.internal.q r8 = com.moloco.sdk.internal.r.a(r9, r8, r10)
            com.moloco.sdk.internal.t$a r9 = new com.moloco.sdk.internal.t$a
            r9.<init>(r8)
            goto L94
        L70:
            boolean r8 = r10 instanceof com.moloco.sdk.internal.t.b
            if (r8 == 0) goto L95
            com.moloco.sdk.internal.t$b r9 = new com.moloco.sdk.internal.t$b
            com.moloco.sdk.internal.t$b r10 = (com.moloco.sdk.internal.t.b) r10
            java.lang.Object r8 = r10.a()
            com.moloco.sdk.internal.ortb.model.e r8 = (com.moloco.sdk.internal.ortb.model.e) r8
            java.util.List r8 = r8.c()
            r10 = 0
            java.lang.Object r8 = r8.get(r10)
            com.moloco.sdk.internal.ortb.model.r r8 = (com.moloco.sdk.internal.ortb.model.r) r8
            java.util.List r8 = r8.c()
            java.lang.Object r8 = r8.get(r10)
            r9.<init>(r8)
        L94:
            return r9
        L95:
            v8.q r8 = new v8.q
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.x.d(java.lang.String, java.lang.String, z8.d):java.lang.Object");
    }
}
