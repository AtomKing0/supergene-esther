package com.ironsource;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.g2;
import com.ironsource.k7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class ou<Smash extends k7<?>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    k7<?> f14272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<String> f14273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f14274f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    pu f14276h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<Smash>> f14269a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14270b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14271c = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Timer f14275g = new Timer();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f14277i = 5;

    class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14278a;

        a(String str) {
            this.f14278a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.f14278a + " from memory");
                ou.this.f14269a.remove(this.f14278a);
                ironLog.verbose("waterfall size is currently " + ou.this.f14269a.size());
            } finally {
                cancel();
            }
        }
    }

    public ou(List<String> list, int i10, pu puVar) {
        this.f14273e = list;
        this.f14274f = i10;
        this.f14276h = puVar;
    }

    private void a() {
        for (Smash smash : b()) {
            if (!smash.equals(this.f14272d)) {
                smash.M();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean e() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ironsource.k7<?> r0 = r2.f14272d     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1b
            boolean r0 = r0.C()     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1b
            com.ironsource.k7<?> r0 = r2.f14272d     // Catch: java.lang.Throwable -> L1e
            java.lang.String r0 = r0.h()     // Catch: java.lang.Throwable -> L1e
            java.lang.String r1 = r2.f14271c     // Catch: java.lang.Throwable -> L1e
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1b
            r0 = 1
            goto L1c
        L1b:
            r0 = 0
        L1c:
            monitor-exit(r2)
            return r0
        L1e:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.ou.e():boolean");
    }

    public List<Smash> b() {
        CopyOnWriteArrayList<Smash> copyOnWriteArrayList = this.f14269a.get(this.f14270b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
    }

    public String c() {
        return this.f14270b;
    }

    public k7<?> d() {
        return this.f14272d;
    }

    public void a(g2.a aVar, CopyOnWriteArrayList<Smash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        a();
        if (aVar == g2.a.AUTOMATIC_LOAD_WHILE_SHOW || aVar == g2.a.MANUAL_WITH_LOAD_ON_SHOW) {
            this.f14269a.put(str, copyOnWriteArrayList);
            if (!TextUtils.isEmpty(this.f14271c)) {
                if (e()) {
                    ironLog.verbose("ad from previous waterfall " + this.f14271c + " is still showing - the current waterfall " + this.f14270b + " will be deleted instead");
                    String str2 = this.f14270b;
                    this.f14270b = this.f14271c;
                    this.f14271c = str2;
                }
                this.f14275g.schedule(new a(this.f14271c), this.f14274f);
            }
        } else {
            this.f14269a.clear();
            this.f14269a.put(str, copyOnWriteArrayList);
        }
        this.f14271c = this.f14270b;
        this.f14270b = str;
        if (this.f14269a.size() > 5) {
            this.f14276h.a(this.f14269a.size());
        }
    }

    public synchronized void b(k7<?> k7Var) {
        IronLog.INTERNAL.verbose();
        this.f14272d = k7Var;
    }

    public synchronized void a(k7<?> k7Var) {
        IronLog.INTERNAL.verbose();
        k7<?> k7Var2 = this.f14272d;
        if (k7Var2 != null && !k7Var2.equals(k7Var)) {
            this.f14272d.M();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0049 A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:29:0x0049, B:6:0x0008, B:8:0x000d, B:11:0x0012, B:13:0x0016, B:16:0x001d, B:18:0x0021, B:21:0x002e, B:23:0x0032, B:25:0x003a), top: B:35:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean a(com.ironsource.g2.a r1, java.lang.String r2, java.lang.String r3, com.ironsource.mediationsdk.LoadWhileShowSupportState r4, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface r5, com.ironsource.mediationsdk.IronSource.AD_UNIT r6) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r5 = r0.a(r5, r6, r2)     // Catch: java.lang.Throwable -> L61
            if (r5 == 0) goto L8
            goto L46
        L8:
            com.ironsource.g2$a r5 = com.ironsource.g2.a.AUTOMATIC_LOAD_WHILE_SHOW     // Catch: java.lang.Throwable -> L61
            r6 = 1
            if (r1 == r5) goto L12
            com.ironsource.g2$a r5 = com.ironsource.g2.a.MANUAL_WITH_LOAD_ON_SHOW     // Catch: java.lang.Throwable -> L61
            if (r1 == r5) goto L12
            goto L47
        L12:
            com.ironsource.k7<?> r1 = r0.f14272d     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L47
            boolean r1 = r1.C()     // Catch: java.lang.Throwable -> L61
            if (r1 != 0) goto L1d
            goto L47
        L1d:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r1 = com.ironsource.mediationsdk.LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK     // Catch: java.lang.Throwable -> L61
            if (r4 != r1) goto L2e
            com.ironsource.k7<?> r1 = r0.f14272d     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L61
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L2e
            goto L46
        L2e:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r1 = com.ironsource.mediationsdk.LoadWhileShowSupportState.NONE     // Catch: java.lang.Throwable -> L61
            if (r4 == r1) goto L3a
            java.util.List<java.lang.String> r1 = r0.f14273e     // Catch: java.lang.Throwable -> L61
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L47
        L3a:
            com.ironsource.k7<?> r1 = r0.f14272d     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = r1.n()     // Catch: java.lang.Throwable -> L61
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L47
        L46:
            r6 = 0
        L47:
            if (r6 != 0) goto L5f
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L61
            r3.append(r2)     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = " will not be added to the auction request"
            r3.append(r2)     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L61
            r1.verbose(r2)     // Catch: java.lang.Throwable -> L61
        L5f:
            monitor-exit(r0)
            return r6
        L61:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.ou.a(com.ironsource.g2$a, java.lang.String, java.lang.String, com.ironsource.mediationsdk.LoadWhileShowSupportState, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface, com.ironsource.mediationsdk.IronSource$AD_UNIT):boolean");
    }

    public boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.AD_UNIT ad_unit, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(ad_unit)) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }
}
