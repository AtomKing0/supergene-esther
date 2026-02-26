package bo.app;

import bo.app.a50;
import bo.app.tr;
import bo.app.v80;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class v80 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f4079n = BrazeLogger.getBrazeLogTag((Class<?>) v80.class);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f4080o = TimeUnit.HOURS.toMillis(1);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f4081p = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cs f4082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c10 f4083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f4086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b2 f4087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReentrantLock f4088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i90 f4089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f4092k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final rd0 f4093l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public z40 f4094m;

    public v80(cs dispatchDataProvider, y70 requestExecutor, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.i(dispatchDataProvider, "dispatchDataProvider");
        kotlin.jvm.internal.t.i(requestExecutor, "requestExecutor");
        this.f4082a = dispatchDataProvider;
        this.f4083b = requestExecutor;
        this.f4084c = z10;
        this.f4085d = z11;
        this.f4086e = new LinkedHashMap();
        this.f4088g = new ReentrantLock();
        this.f4090i = -1L;
        this.f4091j = -1L;
        this.f4092k = new AtomicInteger(0);
        this.f4093l = new rd0(dispatchDataProvider.b().i(), dispatchDataProvider.b().j(), pd0.a(dispatchDataProvider));
        this.f4094m = z40.GOOD;
        a().c(new IEventSubscriber() { // from class: i.i0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                v80.a(this.f26539a, (tr) obj);
            }
        }, tr.class);
        a().c(new IEventSubscriber() { // from class: i.j0
            @Override // com.braze.events.IEventSubscriber
            public final void trigger(Object obj) {
                v80.a(this.f26541a, (a50) obj);
            }
        }, a50.class);
    }

    public static final void a(v80 this$0, tr trVar) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(trVar, "<name for destructuring parameter 0>");
        int i10 = trVar.f3965a;
        l00 l00Var = trVar.f3968d;
        ReentrantLock reentrantLock = this$0.f4088g;
        reentrantLock.lock();
        try {
            if (b80.f2423a[gc0.a(i10)] == 1 && l00Var != null) {
                this$0.a(l00Var);
            }
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean b(long j10) {
        return !this.f4082a.b().C() || this.f4093l.a(j10) >= 1.0d;
    }

    public final void b() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f4079n, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) p80.f3609a, 14, (Object) null);
        b2 b2Var = this.f4087f;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        cp cpVar = new cp(this.f4082a.b(), ((ci0) this.f4082a.f2596a).f2550b.getBaseUrlForRequests(), new k50(null, null, null, null));
        this.f4082a.a(cpVar);
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        a(this, jNowInMilliseconds, cpVar, new z80(cpVar, jNowInMilliseconds, jNowInMilliseconds, a90.PENDING_START, 0, null), new s80());
    }

    public static final void a(v80 this$0, a50 it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f4079n, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new z70(it), 14, (Object) null);
        this$0.f4094m = it.f2352b;
    }

    public final void a(l00 request) {
        uu bmVar;
        kotlin.jvm.internal.t.i(request, "request");
        k00 k00VarC = request.c();
        if (!this.f4086e.containsKey(k00VarC)) {
            int iOrdinal = k00VarC.ordinal();
            if (iOrdinal == 0) {
                bmVar = new bm(this.f4082a);
            } else if (iOrdinal == 1) {
                bmVar = new tx(this.f4082a);
            } else if (iOrdinal == 2) {
                bmVar = new eo(this.f4082a);
            } else if (iOrdinal != 3) {
                switch (iOrdinal) {
                    case 8:
                        bmVar = new y90(this.f4082a);
                        break;
                    case 9:
                        bmVar = new da0(this.f4082a);
                        break;
                    case 10:
                        bmVar = new fs(this.f4082a);
                        break;
                    default:
                        bmVar = new iq(k00VarC, this.f4082a);
                        break;
                }
            } else {
                bmVar = new ed0(this.f4082a);
            }
            this.f4086e.put(k00VarC, bmVar);
        } else {
            bmVar = (uu) this.f4086e.get(k00VarC);
        }
        uu uuVar = bmVar;
        if (uuVar == null) {
            return;
        }
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        kotlin.jvm.internal.t.i(request, "request");
        request.a(uuVar.f4044b.a());
        uuVar.f4048f.add(new z80(request, jNowInMilliseconds + uuVar.f4050h, jNowInMilliseconds, a90.PENDING_START, 0, null));
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, uuVar, (BrazeLogger.Priority) null, (Throwable) null, uuVar.d(), new ku(jNowInMilliseconds, uuVar), 3, (Object) null);
    }

    public static boolean a(v80 v80Var, long j10, l00 l00Var, z80 z80Var, a80 a80Var) {
        c10 c10Var;
        v80Var.getClass();
        boolean z10 = l00Var.a() || v80Var.f4084c;
        if (z10) {
            c10Var = ((ci0) v80Var.f4082a.f2596a).C;
        } else {
            c10Var = v80Var.f4083b;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) v80Var, (BrazeLogger.Priority) null, (Throwable) null, true, (h9.a) new c80(z10, z80Var, j10), 3, (Object) null);
        c10Var.a(z80Var, a80Var, false);
        return z10;
    }

    public final vw a() {
        return this.f4082a.a();
    }

    public final boolean a(long j10) {
        if (this.f4085d && this.f4094m == z40.NONE) {
            return true;
        }
        i90 i90Var = this.f4089h;
        if (i90Var != null && j10 < this.f4091j) {
            if (kotlin.jvm.internal.t.d(((ci0) this.f4082a.f2596a).f2566r.f3233d.getString("auth_signature", null), ((tg) i90Var.f3035a).f3948i)) {
                return true;
            }
        }
        return !b(j10);
    }

    public static void a(v80 v80Var) {
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        ReentrantLock reentrantLock = v80Var.f4088g;
        reentrantLock.lock();
        try {
            if (!v80Var.a(jNowInMilliseconds)) {
                Iterator it = v80Var.f4086e.entrySet().iterator();
                while (it.hasNext()) {
                    v80Var.a(jNowInMilliseconds, (uu) ((Map.Entry) it.next()).getValue());
                }
            }
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(long j10, uu queue) throws NoSuchAlgorithmException {
        String str;
        String str2;
        a90 a90Var;
        int i10;
        String str3 = "queue";
        kotlin.jvm.internal.t.i(queue, "queue");
        if (j10 <= queue.f4049g) {
            return;
        }
        queue.a(j10);
        ArrayList arrayList = queue.f4048f;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((z80) obj).f4413d == a90.BATCHED) {
                arrayList2.add(obj);
            }
        }
        if (!arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                int i11 = ((z80) it.next()).f4417h;
                loop1: while (true) {
                    i10 = i11;
                    while (it.hasNext()) {
                        i11 = ((z80) it.next()).f4417h;
                        if (i10 < i11) {
                            break;
                        }
                    }
                }
                ArrayList arrayList3 = queue.f4048f;
                ArrayList<z80> arrayList4 = new ArrayList();
                for (Object obj2 : arrayList3) {
                    a90 a90Var2 = ((z80) obj2).f4413d;
                    if (a90Var2 == a90.PENDING_START || a90Var2 == a90.PENDING_RETRY) {
                        arrayList4.add(obj2);
                    }
                }
                for (z80 z80Var : arrayList4) {
                    z80Var.f4417h = i10;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, queue, (BrazeLogger.Priority) null, (Throwable) null, queue.d(), new lu(z80Var, j10, i10), 3, (Object) null);
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        ArrayList<z80> arrayList5 = new ArrayList();
        ArrayList arrayList6 = queue.f4048f;
        ArrayList arrayList7 = new ArrayList();
        for (Object obj3 : arrayList6) {
            a90 a90Var3 = ((z80) obj3).f4413d;
            if (a90Var3 == a90.BATCHED || a90Var3 == a90.COMPLETE) {
                arrayList7.add(obj3);
            }
        }
        arrayList5.addAll(arrayList7);
        ArrayList arrayList8 = queue.f4048f;
        ArrayList arrayList9 = new ArrayList();
        for (Object obj4 : arrayList8) {
            z80 z80Var2 = (z80) obj4;
            if (z80Var2.f4417h >= 15 && ((a90Var = z80Var2.f4413d) == a90.PENDING_RETRY || a90Var == a90.PENDING_START)) {
                arrayList9.add(obj4);
            }
        }
        arrayList5.addAll(arrayList9);
        for (z80 z80Var3 : arrayList5) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, uu.f4042k, (BrazeLogger.Priority) null, (Throwable) null, queue.d(), (h9.a) new mu(j10, z80Var3), 6, (Object) null);
            z80Var3.f4410a.a((v00) queue.f4044b.a());
        }
        queue.f4048f.removeAll(arrayList5);
        ArrayList arrayList10 = queue.f4048f;
        ArrayList<z80> arrayList11 = new ArrayList();
        for (Object obj5 : arrayList10) {
            z80 z80Var4 = (z80) obj5;
            a90 a90Var4 = z80Var4.f4413d;
            if (a90Var4 == a90.PENDING_START || a90Var4 == a90.PENDING_RETRY) {
                if (j10 >= z80Var4.f4411b) {
                    arrayList11.add(obj5);
                }
            }
        }
        for (z80 requestInfo : arrayList11) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, this, (BrazeLogger.Priority) null, (Throwable) null, queue.d(), new m80(j10, requestInfo), 3, (Object) null);
            if (!b(j10)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) n80.f3474a, 7, (Object) null);
            } else {
                rd0 rd0VarB = queue.b();
                if (rd0VarB == null || rd0VarB.a(j10) >= 1.0d) {
                    l00 l00VarA = this.f4082a.a(requestInfo.f4410a);
                    kotlin.jvm.internal.t.i(queue, str3);
                    kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
                    g80 g80Var = new g80(this, requestInfo, queue);
                    requestInfo.a(j10, a90.IN_FLIGHT);
                    rd0 rd0VarB2 = queue.b();
                    requestInfo.f4415f = (rd0VarB2 == null ? null : Integer.valueOf((int) rd0VarB2.a(j10))) != null ? Integer.valueOf(n9.o.e(r0.intValue() - 1, 0)) : null;
                    requestInfo.f4414e = n9.o.e(((int) this.f4093l.a(j10)) - 1, 0);
                    if (!a(this, j10, l00VarA, requestInfo, g80Var)) {
                        kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
                        this.f4093l.b();
                        if (b(j10)) {
                            str = str3;
                            str2 = "requestInfo";
                        } else {
                            str = str3;
                            str2 = "requestInfo";
                            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new k80(requestInfo, j10, this.f4093l.c(), this), 7, (Object) null);
                        }
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, true, (h9.a) new l80(this, j10), 3, (Object) null);
                        kotlin.jvm.internal.t.i(requestInfo, str2);
                        rd0 rd0VarB3 = queue.b();
                        if (rd0VarB3 != null) {
                            rd0VarB3.b();
                            rd0 rd0VarB4 = queue.b();
                            if (rd0VarB4 != null && rd0VarB4.a(j10) < 1.0d) {
                                BrazeLogger.brazelog$default(brazeLogger, queue, (BrazeLogger.Priority) null, (Throwable) null, queue.d(), new pu(requestInfo, j10, rd0VarB3.c(), rd0VarB3), 3, (Object) null);
                            }
                            BrazeLogger.brazelog$default(brazeLogger, (Object) queue, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new qu(j10, queue), 7, (Object) null);
                        }
                    }
                } else {
                    str = str3;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) o80.f3547a, 7, (Object) null);
                    rd0 rd0VarB5 = queue.b();
                    requestInfo.f4411b = (rd0VarB5 != null ? rd0VarB5.c() : 0L) + j10;
                }
                str3 = str;
            }
        }
    }
}
