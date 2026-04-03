package com.moloco.sdk.acm;

import androidx.lifecycle.ProcessLifecycleOwner;
import com.moloco.sdk.acm.db.MetricsDb;
import h9.p;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.moloco.sdk.acm.eventprocessing.f f17294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.moloco.sdk.acm.services.d f17295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static h f17296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private static g f17297e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static com.moloco.sdk.acm.eventprocessing.i f17303k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17293a = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final y9.a f17298f = y9.c.b(false, 1, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final o0 f17299g = p0.a(e1.b().plus(y2.b(null, 1, null)));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AtomicReference<k> f17300h = new AtomicReference<>(k.UNINITIALIZED);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final CopyOnWriteArrayList<f> f17301i = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final CopyOnWriteArrayList<com.moloco.sdk.acm.c> f17302j = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: com.moloco.sdk.acm.a$a, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.AndroidClientMetrics$initialize$1", f = "AndroidClientMetrics.kt", l = {258, 124}, m = "invokeSuspend")
    public static final class C0287a extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17304j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f17305k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.acm.e f17306l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0287a(com.moloco.sdk.acm.e eVar, com.moloco.sdk.acm.b bVar, z8.d<? super C0287a> dVar) {
            super(2, dVar);
            this.f17306l = eVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C0287a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new C0287a(this.f17306l, null, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [y9.a] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v3, types: [y9.a] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            y9.a aVar;
            ?? r22;
            Object objE = a9.d.e();
            ?? r23 = this.f17305k;
            try {
                try {
                } catch (Throwable th) {
                    r23.g(null);
                    throw th;
                }
            } catch (IllegalStateException e10) {
                com.moloco.sdk.acm.services.e.e(com.moloco.sdk.acm.services.e.f17473a, "MetricsDb", "Unable to create metrics db", e10, false, 8, null);
                a.f17300h.set(k.UNINITIALIZED);
            } catch (Exception e11) {
                com.moloco.sdk.acm.services.e.e(com.moloco.sdk.acm.services.e.f17473a, "AndroidClientMetrics", "Initialization error", e11, false, 8, null);
                a.f17300h.set(k.UNINITIALIZED);
            }
            if (r23 == 0) {
                u.b(obj);
                com.moloco.sdk.acm.db.d dVarC = MetricsDb.f17323a.b(this.f17306l.c()).c();
                com.moloco.sdk.acm.services.h hVar = new com.moloco.sdk.acm.services.h();
                a aVar2 = a.f17293a;
                com.moloco.sdk.acm.eventprocessing.c cVar = new com.moloco.sdk.acm.eventprocessing.c(aVar2.p(), this.f17306l.c());
                a.f17303k = new com.moloco.sdk.acm.eventprocessing.k(cVar, aVar2.p(), null, a.f17299g, 4, null);
                a.f17295c = new com.moloco.sdk.acm.services.d(ProcessLifecycleOwner.Companion.get().getLifecycle(), new com.moloco.sdk.acm.services.a(cVar, a.f17299g));
                com.moloco.sdk.acm.eventprocessing.i iVar = a.f17303k;
                if (iVar == null) {
                    t.A("requestScheduler");
                    iVar = null;
                }
                com.moloco.sdk.acm.services.d dVar = a.f17295c;
                if (dVar == null) {
                    t.A("applicationLifecycleTracker");
                    dVar = null;
                }
                a.f17294b = new com.moloco.sdk.acm.eventprocessing.g(dVarC, hVar, iVar, dVar);
                a.f17300h.set(k.INITIALIZED);
                y9.a aVar3 = a.f17298f;
                this.f17304j = aVar3;
                this.f17305k = 1;
                Object objE2 = aVar3.e(null, this);
                aVar = aVar3;
                if (objE2 == objE) {
                    return objE;
                }
            } else {
                if (r23 != 1) {
                    if (r23 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    y9.a aVar4 = (y9.a) this.f17304j;
                    u.b(obj);
                    r23 = aVar4;
                    k0 k0Var = k0.f35197a;
                    r22 = r23;
                    r22.g(null);
                    a.f17293a.s();
                    return k0.f35197a;
                }
                y9.a aVar5 = (y9.a) this.f17304j;
                u.b(obj);
                aVar = aVar5;
            }
            g gVar = a.f17297e;
            r22 = aVar;
            if (gVar != null) {
                a aVar6 = a.f17293a;
                a.f17297e = null;
                com.moloco.sdk.acm.services.e.f(com.moloco.sdk.acm.services.e.f17473a, "AndroidClientMetrics", "Updating config with pending config", false, 4, null);
                this.f17304j = aVar;
                this.f17305k = 2;
                r23 = aVar;
                if (aVar6.y(gVar, this) == objE) {
                    return objE;
                }
                k0 k0Var2 = k0.f35197a;
                r22 = r23;
            }
            r22.g(null);
            a.f17293a.s();
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.AndroidClientMetrics$processQueuedEvents$1", f = "AndroidClientMetrics.kt", l = {234, 235}, m = "invokeSuspend")
    public static final class b extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17307j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f17308k;

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
            return new b(dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r8.f17308k
                r2 = 0
                java.lang.String r3 = "eventProcessor"
                java.lang.String r4 = "it"
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L2b
                if (r1 == r6) goto L23
                if (r1 != r5) goto L1b
                java.lang.Object r1 = r8.f17307j
                java.util.Iterator r1 = (java.util.Iterator) r1
                v8.u.b(r9)
                goto L62
            L1b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L23:
                java.lang.Object r1 = r8.f17307j
                java.util.Iterator r1 = (java.util.Iterator) r1
                v8.u.b(r9)
                goto L36
            L2b:
                v8.u.b(r9)
                java.util.concurrent.CopyOnWriteArrayList r9 = com.moloco.sdk.acm.a.g()
                java.util.Iterator r1 = r9.iterator()
            L36:
                boolean r9 = r1.hasNext()
                if (r9 == 0) goto L5a
                java.lang.Object r9 = r1.next()
                com.moloco.sdk.acm.f r9 = (com.moloco.sdk.acm.f) r9
                com.moloco.sdk.acm.eventprocessing.f r7 = com.moloco.sdk.acm.a.c()
                if (r7 != 0) goto L4c
                kotlin.jvm.internal.t.A(r3)
                r7 = r2
            L4c:
                kotlin.jvm.internal.t.h(r9, r4)
                r8.f17307j = r1
                r8.f17308k = r6
                java.lang.Object r9 = r7.a(r9, r8)
                if (r9 != r0) goto L36
                return r0
            L5a:
                java.util.concurrent.CopyOnWriteArrayList r9 = com.moloco.sdk.acm.a.f()
                java.util.Iterator r1 = r9.iterator()
            L62:
                boolean r9 = r1.hasNext()
                if (r9 == 0) goto L86
                java.lang.Object r9 = r1.next()
                com.moloco.sdk.acm.c r9 = (com.moloco.sdk.acm.c) r9
                com.moloco.sdk.acm.eventprocessing.f r6 = com.moloco.sdk.acm.a.c()
                if (r6 != 0) goto L78
                kotlin.jvm.internal.t.A(r3)
                r6 = r2
            L78:
                kotlin.jvm.internal.t.h(r9, r4)
                r8.f17307j = r1
                r8.f17308k = r5
                java.lang.Object r9 = r6.b(r9, r8)
                if (r9 != r0) goto L62
                return r0
            L86:
                java.util.concurrent.CopyOnWriteArrayList r9 = com.moloco.sdk.acm.a.g()
                r9.clear()
                java.util.concurrent.CopyOnWriteArrayList r9 = com.moloco.sdk.acm.a.f()
                r9.clear()
                v8.k0 r9 = v8.k0.f35197a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.AndroidClientMetrics$recordCountEvent$1", f = "AndroidClientMetrics.kt", l = {190}, m = "invokeSuspend")
    public static final class c extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17309j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.acm.c f17310k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.acm.c cVar, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f17310k = cVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((c) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new c(this.f17310k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f17309j;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.acm.eventprocessing.f fVar = a.f17294b;
                if (fVar == null) {
                    t.A("eventProcessor");
                    fVar = null;
                }
                com.moloco.sdk.acm.c cVar = this.f17310k;
                this.f17309j = 1;
                if (fVar.b(cVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.AndroidClientMetrics$recordTimerEvent$1", f = "AndroidClientMetrics.kt", l = {225}, m = "invokeSuspend")
    public static final class d extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17311j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ f f17312k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f fVar, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f17312k = fVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new d(this.f17312k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f17311j;
            if (i10 == 0) {
                u.b(obj);
                com.moloco.sdk.acm.eventprocessing.f fVar = a.f17294b;
                if (fVar == null) {
                    t.A("eventProcessor");
                    fVar = null;
                }
                f fVar2 = this.f17312k;
                this.f17311j = 1;
                if (fVar.a(fVar2, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.AndroidClientMetrics", f = "AndroidClientMetrics.kt", l = {258, 164}, m = "updateConfig")
    public static final class e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17313j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17314k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f17315l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17317n;

        public e(z8.d<? super e> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17315l = obj;
            this.f17317n |= Integer.MIN_VALUE;
            return a.this.x(null, this);
        }
    }

    private a() {
    }

    public static /* synthetic */ void r(a aVar, com.moloco.sdk.acm.e eVar, com.moloco.sdk.acm.b bVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bVar = null;
        }
        aVar.q(eVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        kotlinx.coroutines.k.d(f17299g, null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object y(g gVar, z8.d<? super k0> dVar) {
        String strA = gVar.a();
        if (strA != null) {
            f17293a.p().b(strA);
        }
        Long lB = gVar.b();
        if (lB != null) {
            f17293a.p().a(lB.longValue());
        }
        com.moloco.sdk.acm.eventprocessing.i iVar = f17303k;
        if (iVar == null) {
            t.A("requestScheduler");
            iVar = null;
        }
        Object objA = iVar.a(dVar);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    @NotNull
    public final h p() {
        h hVar = f17296d;
        if (hVar != null) {
            return hVar;
        }
        t.A("opsConfig");
        return null;
    }

    public final void q(@NotNull com.moloco.sdk.acm.e config, @Nullable com.moloco.sdk.acm.b bVar) {
        t.i(config, "config");
        com.moloco.sdk.acm.services.e.m(com.moloco.sdk.acm.services.e.f17473a, "AndroidClientMetrics", "ACM initialize", false, 4, null);
        if (androidx.compose.animation.core.d.a(f17300h, k.UNINITIALIZED, k.INITIALIZING)) {
            v(j.a(config));
            kotlinx.coroutines.k.d(f17299g, null, null, new C0287a(config, bVar, null), 3, null);
        }
    }

    public final void t(@NotNull com.moloco.sdk.acm.c event) {
        t.i(event, "event");
        if (f17300h.get() == k.INITIALIZED) {
            kotlinx.coroutines.k.d(f17299g, null, null, new c(event, null), 3, null);
        } else {
            f17302j.add(event);
            com.moloco.sdk.acm.services.e.f(com.moloco.sdk.acm.services.e.f17473a, "AndroidClientMetrics", "Moloco Client Metrics not initialized", false, 4, null);
        }
    }

    public final void u(@NotNull f event) {
        t.i(event, "event");
        event.e();
        if (f17300h.get() == k.INITIALIZED) {
            kotlinx.coroutines.k.d(f17299g, null, null, new d(event, null), 3, null);
        } else {
            f17301i.add(event);
            com.moloco.sdk.acm.services.e.f(com.moloco.sdk.acm.services.e.f17473a, "AndroidClientMetrics", "Moloco Client Metrics not initialized", false, 4, null);
        }
    }

    public final void v(@NotNull h hVar) {
        t.i(hVar, "<set-?>");
        f17296d = hVar;
    }

    @NotNull
    public final f w(@NotNull String eventName) {
        t.i(eventName, "eventName");
        if (f17300h.get() != k.INITIALIZED) {
            com.moloco.sdk.acm.services.e.f(com.moloco.sdk.acm.services.e.f17473a, "AndroidClientMetrics", "Moloco Client Metrics not initialized", false, 4, null);
        }
        f fVarA = f.Companion.a(eventName);
        fVarA.d();
        return fVarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(@org.jetbrains.annotations.NotNull com.moloco.sdk.acm.g r14, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.moloco.sdk.acm.a.e
            if (r0 == 0) goto L13
            r0 = r15
            com.moloco.sdk.acm.a$e r0 = (com.moloco.sdk.acm.a.e) r0
            int r1 = r0.f17317n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f17317n = r1
            goto L18
        L13:
            com.moloco.sdk.acm.a$e r0 = new com.moloco.sdk.acm.a$e
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.f17315l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f17317n
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            v8.u.b(r15)
            goto L8f
        L2d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L35:
            java.lang.Object r14 = r0.f17314k
            y9.a r14 = (y9.a) r14
            java.lang.Object r0 = r0.f17313j
            com.moloco.sdk.acm.g r0 = (com.moloco.sdk.acm.g) r0
            v8.u.b(r15)
            r15 = r14
            r14 = r0
            goto L6d
        L43:
            v8.u.b(r15)
            java.util.concurrent.atomic.AtomicReference<com.moloco.sdk.acm.k> r15 = com.moloco.sdk.acm.a.f17300h
            java.lang.Object r15 = r15.get()
            com.moloco.sdk.acm.k r2 = com.moloco.sdk.acm.k.INITIALIZED
            if (r15 == r2) goto L7a
            com.moloco.sdk.acm.services.e r6 = com.moloco.sdk.acm.services.e.f17473a
            java.lang.String r7 = "AndroidClientMetrics"
            java.lang.String r8 = "ACM updateConfig called when the SDK was not initialized. Initialize the SDK first."
            r9 = 0
            r10 = 0
            r11 = 12
            r12 = 0
            com.moloco.sdk.acm.services.e.l(r6, r7, r8, r9, r10, r11, r12)
            y9.a r15 = com.moloco.sdk.acm.a.f17298f
            r0.f17313j = r14
            r0.f17314k = r15
            r0.f17317n = r5
            java.lang.Object r0 = r15.e(r3, r0)
            if (r0 != r1) goto L6d
            return r1
        L6d:
            com.moloco.sdk.acm.a.f17297e = r14     // Catch: java.lang.Throwable -> L75
            v8.k0 r14 = v8.k0.f35197a     // Catch: java.lang.Throwable -> L75
            r15.g(r3)
            return r14
        L75:
            r14 = move-exception
            r15.g(r3)
            throw r14
        L7a:
            com.moloco.sdk.acm.services.e r5 = com.moloco.sdk.acm.services.e.f17473a
            java.lang.String r6 = "AndroidClientMetrics"
            java.lang.String r7 = "ACM update called. ACM initialized already, proceeding with update"
            r8 = 0
            r9 = 4
            r10 = 0
            com.moloco.sdk.acm.services.e.m(r5, r6, r7, r8, r9, r10)
            r0.f17317n = r4
            java.lang.Object r14 = r13.y(r14, r0)
            if (r14 != r1) goto L8f
            return r1
        L8f:
            v8.k0 r14 = v8.k0.f35197a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.a.x(com.moloco.sdk.acm.g, z8.d):java.lang.Object");
    }
}
