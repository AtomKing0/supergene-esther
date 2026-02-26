package com.moloco.sdk.acm.eventprocessing;

import h9.p;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.eventprocessing.b f17402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.h f17403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final ScheduledExecutorService f17404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final o0 f17405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ScheduledFuture<?> f17406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final y9.a f17407f;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer", f = "RequestSchedulerTimer.kt", l = {68}, m = "resetScheduleAndTriggerNewScheduledUpload")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17408j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17409k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f17410l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17412n;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17410l = obj;
            this.f17412n |= Integer.MIN_VALUE;
            return k.this.a(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer$schedule$1$1", f = "RequestSchedulerTimer.kt", l = {}, m = "invokeSuspend")
    public static final class b extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17413j;

        public b(z8.d<? super b> dVar) {
            super(2, dVar);
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
            return k.this.new b(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f17413j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            k.this.f17402a.a();
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer", f = "RequestSchedulerTimer.kt", l = {68}, m = "scheduleUploadAndPurge")
    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17415j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17416k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f17417l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17419n;

        public c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17417l = obj;
            this.f17419n |= Integer.MIN_VALUE;
            return k.this.c(this);
        }
    }

    public k(@NotNull com.moloco.sdk.acm.eventprocessing.b dbWorkRequest, @NotNull com.moloco.sdk.acm.h opsConfig, @NotNull ScheduledExecutorService scheduler, @NotNull o0 coroutineScope) {
        t.i(dbWorkRequest, "dbWorkRequest");
        t.i(opsConfig, "opsConfig");
        t.i(scheduler, "scheduler");
        t.i(coroutineScope, "coroutineScope");
        this.f17402a = dbWorkRequest;
        this.f17403b = opsConfig;
        this.f17404c = scheduler;
        this.f17405d = coroutineScope;
        this.f17407f = y9.c.b(false, 1, null);
    }

    public static final void e(k this$0) {
        t.i(this$0, "this$0");
        kotlinx.coroutines.k.d(this$0.f17405d, null, null, this$0.new b(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.eventprocessing.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.moloco.sdk.acm.eventprocessing.k.a
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.acm.eventprocessing.k$a r0 = (com.moloco.sdk.acm.eventprocessing.k.a) r0
            int r1 = r0.f17412n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17412n = r1
            goto L18
        L13:
            com.moloco.sdk.acm.eventprocessing.k$a r0 = new com.moloco.sdk.acm.eventprocessing.k$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f17410l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f17412n
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r1 = r0.f17409k
            y9.a r1 = (y9.a) r1
            java.lang.Object r0 = r0.f17408j
            com.moloco.sdk.acm.eventprocessing.k r0 = (com.moloco.sdk.acm.eventprocessing.k) r0
            v8.u.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            v8.u.b(r6)
            y9.a r6 = r5.f17407f
            r0.f17408j = r5
            r0.f17409k = r6
            r0.f17412n = r4
            java.lang.Object r0 = r6.e(r3, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            java.util.concurrent.ScheduledFuture<?> r6 = r0.f17406e     // Catch: java.lang.Throwable -> L63
            if (r6 == 0) goto L5a
            r2 = 0
            boolean r6 = r6.cancel(r2)     // Catch: java.lang.Throwable -> L63
            kotlin.coroutines.jvm.internal.b.a(r6)     // Catch: java.lang.Throwable -> L63
        L5a:
            r0.d()     // Catch: java.lang.Throwable -> L63
            v8.k0 r6 = v8.k0.f35197a     // Catch: java.lang.Throwable -> L63
            r1.g(r3)
            return r6
        L63:
            r6 = move-exception
            r1.g(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.eventprocessing.k.a(z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.eventprocessing.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.moloco.sdk.acm.eventprocessing.k.c
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.acm.eventprocessing.k$c r0 = (com.moloco.sdk.acm.eventprocessing.k.c) r0
            int r1 = r0.f17419n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17419n = r1
            goto L18
        L13:
            com.moloco.sdk.acm.eventprocessing.k$c r0 = new com.moloco.sdk.acm.eventprocessing.k$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f17417l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f17419n
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r1 = r0.f17416k
            y9.a r1 = (y9.a) r1
            java.lang.Object r0 = r0.f17415j
            com.moloco.sdk.acm.eventprocessing.k r0 = (com.moloco.sdk.acm.eventprocessing.k) r0
            v8.u.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            v8.u.b(r6)
            y9.a r6 = r5.f17407f
            r0.f17415j = r5
            r0.f17416k = r6
            r0.f17419n = r4
            java.lang.Object r0 = r6.e(r3, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            r0.d()     // Catch: java.lang.Throwable -> L57
            v8.k0 r6 = v8.k0.f35197a     // Catch: java.lang.Throwable -> L57
            r1.g(r3)
            return r6
        L57:
            r6 = move-exception
            r1.g(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.eventprocessing.k.c(z8.d):java.lang.Object");
    }

    public final void d() {
        ScheduledFuture<?> scheduledFuture = this.f17406e;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            this.f17406e = this.f17404c.scheduleWithFixedDelay(new Runnable() { // from class: com.moloco.sdk.acm.eventprocessing.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.e(this.f17401a);
                }
            }, this.f17403b.e(), this.f17403b.e(), TimeUnit.SECONDS);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ k(com.moloco.sdk.acm.eventprocessing.b bVar, com.moloco.sdk.acm.h hVar, ScheduledExecutorService scheduledExecutorService, o0 o0Var, int i10, kotlin.jvm.internal.k kVar) {
        if ((i10 & 4) != 0) {
            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
            t.h(scheduledExecutorService, "newSingleThreadScheduledExecutor()");
        }
        this(bVar, hVar, scheduledExecutorService, o0Var);
    }
}
