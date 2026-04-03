package com.moloco.sdk.acm.eventprocessing;

import android.database.sqlite.SQLiteException;
import h9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f17375e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.db.d f17376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.services.g f17377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final i f17378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.services.c f17379d;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processCountEvent$2", f = "EventProcessor.kt", l = {49}, m = "invokeSuspend")
    public static final class b extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17380j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.acm.c f17382l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.acm.c cVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f17382l = cVar;
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
            return g.this.new b(this.f17382l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f17380j;
            if (i10 == 0) {
                u.b(obj);
                g gVar = g.this;
                String strC = this.f17382l.c();
                com.moloco.sdk.acm.db.c cVar = com.moloco.sdk.acm.db.c.COUNT;
                long jA = this.f17382l.a();
                List<com.moloco.sdk.acm.d> listB = this.f17382l.b();
                ArrayList arrayList = new ArrayList(w.v(listB, 10));
                Iterator<T> it = listB.iterator();
                while (it.hasNext()) {
                    arrayList.add(com.moloco.sdk.acm.i.a((com.moloco.sdk.acm.d) it.next()));
                }
                this.f17380j = 1;
                if (gVar.e(strC, cVar, jA, arrayList, this) == objE) {
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

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processEvent$2", f = "EventProcessor.kt", l = {79, 80}, m = "invokeSuspend")
    public static final class c extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17383j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f17384k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ g f17385l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.acm.db.c f17386m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f17387n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ List<String> f17388o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, g gVar, com.moloco.sdk.acm.db.c cVar, long j10, List<String> list, z8.d<? super c> dVar) {
            super(2, dVar);
            this.f17384k = str;
            this.f17385l = gVar;
            this.f17386m = cVar;
            this.f17387n = j10;
            this.f17388o = list;
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
            return new c(this.f17384k, this.f17385l, this.f17386m, this.f17387n, this.f17388o, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f17383j;
            try {
            } catch (SQLiteException e10) {
                com.moloco.sdk.acm.services.e.f(com.moloco.sdk.acm.services.e.f17473a, "EventProcessor", "Database error: " + e10.getMessage(), false, 4, null);
            } catch (Exception e11) {
                com.moloco.sdk.acm.services.e.f(com.moloco.sdk.acm.services.e.f17473a, "EventProcessor", "Unexpected error while processing event: " + e11.getMessage(), false, 4, null);
            }
            if (i10 == 0) {
                u.b(obj);
                this.f17385l.f17376a.b(new com.moloco.sdk.acm.db.b(0L, this.f17384k, this.f17385l.f17377b.invoke(), this.f17386m, kotlin.coroutines.jvm.internal.b.e(this.f17387n), this.f17388o, 1, null));
                i iVar = this.f17385l.f17378c;
                this.f17383j = 1;
                if (iVar.c(this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    return k0.f35197a;
                }
                u.b(obj);
            }
            com.moloco.sdk.acm.services.c cVar = this.f17385l.f17379d;
            this.f17383j = 2;
            if (cVar.a(this) == objE) {
                return objE;
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.eventprocessing.EventProcessorImpl$processTimerEvent$2", f = "EventProcessor.kt", l = {58, 60}, m = "invokeSuspend")
    public static final class d extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17389j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.acm.f f17390k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ g f17391l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.acm.f fVar, g gVar, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f17390k = fVar;
            this.f17391l = gVar;
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
            return new d(this.f17390k, this.f17391l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f17389j;
            if (i10 == 0) {
                u.b(obj);
                if (this.f17390k.c() > 0) {
                    g gVar = this.f17391l;
                    String strB = this.f17390k.b();
                    com.moloco.sdk.acm.db.c cVar = com.moloco.sdk.acm.db.c.TIMER;
                    long jC = this.f17390k.c();
                    List<com.moloco.sdk.acm.d> listA = this.f17390k.a();
                    ArrayList arrayList = new ArrayList(w.v(listA, 10));
                    Iterator<T> it = listA.iterator();
                    while (it.hasNext()) {
                        arrayList.add(com.moloco.sdk.acm.i.a((com.moloco.sdk.acm.d) it.next()));
                    }
                    this.f17389j = 1;
                    if (gVar.e(strB, cVar, jC, arrayList, this) == objE) {
                        return objE;
                    }
                } else {
                    g gVar2 = this.f17391l;
                    String str = "negative_time_" + this.f17390k.b();
                    com.moloco.sdk.acm.db.c cVar2 = com.moloco.sdk.acm.db.c.TIMER;
                    long jC2 = this.f17390k.c();
                    List<com.moloco.sdk.acm.d> listA2 = this.f17390k.a();
                    ArrayList arrayList2 = new ArrayList(w.v(listA2, 10));
                    Iterator<T> it2 = listA2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(com.moloco.sdk.acm.i.a((com.moloco.sdk.acm.d) it2.next()));
                    }
                    this.f17389j = 2;
                    if (gVar2.e(str, cVar2, jC2, arrayList2, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    public g(@NotNull com.moloco.sdk.acm.db.d metricsDAO, @NotNull com.moloco.sdk.acm.services.g timeProviderService, @NotNull i requestScheduler, @NotNull com.moloco.sdk.acm.services.c applicationLifecycle) {
        t.i(metricsDAO, "metricsDAO");
        t.i(timeProviderService, "timeProviderService");
        t.i(requestScheduler, "requestScheduler");
        t.i(applicationLifecycle, "applicationLifecycle");
        this.f17376a = metricsDAO;
        this.f17377b = timeProviderService;
        this.f17378c = requestScheduler;
        this.f17379d = applicationLifecycle;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.f
    @Nullable
    public Object a(@NotNull com.moloco.sdk.acm.f fVar, @NotNull z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(e1.b(), new d(fVar, this, null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }

    @Override // com.moloco.sdk.acm.eventprocessing.f
    @Nullable
    public Object b(@NotNull com.moloco.sdk.acm.c cVar, @NotNull z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(e1.b(), new b(cVar, null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }

    public final Object e(String str, com.moloco.sdk.acm.db.c cVar, long j10, List<String> list, z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(e1.b(), new c(str, this, cVar, j10, list, null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }
}
