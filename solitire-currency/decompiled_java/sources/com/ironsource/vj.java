package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class vj {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15915i = "WaterfallLifeCycleHolder";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.ironsource.mediationsdk.r f15919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<String> f15920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15921f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<com.ironsource.mediationsdk.r>> f15916a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15917b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15918c = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Timer f15922g = new Timer();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ConcurrentHashMap<String, AdInfo> f15923h = new ConcurrentHashMap<>();

    class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f15924a;

        a(String str) {
            this.f15924a = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("removing waterfall with id " + this.f15924a + " from memory");
                vj.this.f15916a.remove(this.f15924a);
                ironLog.verbose("waterfall size is currently " + vj.this.f15916a.size());
                ironLog.verbose("removing adInfo with id " + this.f15924a + " from memory");
                vj.this.f15923h.remove(this.f15924a);
                ironLog.verbose("adInfo size is currently " + vj.this.f15923h.size());
            } finally {
                cancel();
            }
        }
    }

    public vj(List<String> list, int i10) {
        this.f15920e = list;
        this.f15921f = i10;
    }

    private void b() {
        for (com.ironsource.mediationsdk.r rVar : c()) {
            if (!rVar.equals(this.f15919d)) {
                rVar.q();
            }
        }
    }

    public AdInfo a(String str) {
        if (this.f15923h.containsKey(str)) {
            return this.f15923h.get(str);
        }
        return null;
    }

    public CopyOnWriteArrayList<com.ironsource.mediationsdk.r> c() {
        CopyOnWriteArrayList<com.ironsource.mediationsdk.r> copyOnWriteArrayList = this.f15916a.get(this.f15917b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public String d() {
        return this.f15917b;
    }

    public int e() {
        return this.f15916a.size();
    }

    public com.ironsource.mediationsdk.r f() {
        return this.f15919d;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean g() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ironsource.mediationsdk.r r0 = r2.f15919d     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L13
            java.lang.String r0 = r0.u()     // Catch: java.lang.Throwable -> L16
            java.lang.String r1 = r2.f15918c     // Catch: java.lang.Throwable -> L16
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            monitor-exit(r2)
            return r0
        L16:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.vj.g():boolean");
    }

    public synchronized void a(com.ironsource.mediationsdk.r rVar) {
        IronLog.INTERNAL.verbose();
        com.ironsource.mediationsdk.r rVar2 = this.f15919d;
        if (rVar2 != null && !rVar2.equals(rVar)) {
            this.f15919d.q();
        }
        this.f15919d = rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean b(com.ironsource.mediationsdk.r r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch: java.lang.Throwable -> L74
            r0.verbose()     // Catch: java.lang.Throwable -> L74
            r1 = 1
            if (r6 == 0) goto L53
            boolean r2 = r6.o()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L10
            goto L53
        L10:
            com.ironsource.mediationsdk.r r2 = r5.f15919d     // Catch: java.lang.Throwable -> L74
            r3 = 0
            if (r2 != 0) goto L16
            goto L54
        L16:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = r6.w()     // Catch: java.lang.Throwable -> L74
            com.ironsource.mediationsdk.LoadWhileShowSupportState r4 = com.ironsource.mediationsdk.LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK     // Catch: java.lang.Throwable -> L74
            if (r2 != r4) goto L2f
            com.ironsource.mediationsdk.r r2 = r5.f15919d     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = r2.c()     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = r6.c()     // Catch: java.lang.Throwable -> L74
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L2f
            goto L53
        L2f:
            com.ironsource.mediationsdk.LoadWhileShowSupportState r2 = r6.w()     // Catch: java.lang.Throwable -> L74
            com.ironsource.mediationsdk.LoadWhileShowSupportState r4 = com.ironsource.mediationsdk.LoadWhileShowSupportState.NONE     // Catch: java.lang.Throwable -> L74
            if (r2 == r4) goto L43
            java.util.List<java.lang.String> r2 = r5.f15920e     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = r6.j()     // Catch: java.lang.Throwable -> L74
            boolean r2 = r2.contains(r4)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L54
        L43:
            com.ironsource.mediationsdk.r r2 = r5.f15919d     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = r2.j()     // Catch: java.lang.Throwable -> L74
            java.lang.String r4 = r6.j()     // Catch: java.lang.Throwable -> L74
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L54
        L53:
            r3 = r1
        L54:
            if (r3 == 0) goto L70
            if (r6 == 0) goto L70
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r2.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r6 = r6.c()     // Catch: java.lang.Throwable -> L74
            r2.append(r6)     // Catch: java.lang.Throwable -> L74
            java.lang.String r6 = " will not be added to the auction request"
            r2.append(r6)     // Catch: java.lang.Throwable -> L74
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L74
            r0.verbose(r6)     // Catch: java.lang.Throwable -> L74
        L70:
            r6 = r3 ^ 1
            monitor-exit(r5)
            return r6
        L74:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.vj.b(com.ironsource.mediationsdk.r):boolean");
    }

    public void a(String str, ImpressionData impressionData) {
        if (TextUtils.isEmpty(str) || impressionData == null) {
            return;
        }
        this.f15923h.put(str, new AdInfo(impressionData));
    }

    public void a(CopyOnWriteArrayList<com.ironsource.mediationsdk.r> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        b();
        this.f15916a.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.f15918c)) {
            if (g()) {
                ironLog.verbose("ad from previous waterfall " + this.f15918c + " is still showing - the current waterfall " + this.f15917b + " will be deleted instead");
                String str2 = this.f15917b;
                this.f15917b = this.f15918c;
                this.f15918c = str2;
            }
            this.f15922g.schedule(new a(this.f15918c), this.f15921f);
        }
        this.f15918c = this.f15917b;
        this.f15917b = str;
    }

    public boolean a() {
        return this.f15916a.size() > 5;
    }
}
