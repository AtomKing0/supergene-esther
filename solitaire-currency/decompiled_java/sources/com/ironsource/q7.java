package com.ironsource;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class q7 implements Callable<u7> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AdData f14439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s7 f14440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r7 f14441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NetworkSettings f14442f;

    class a implements BiddingDataCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ta f14443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BlockingQueue f14444b;

        a(ta taVar, BlockingQueue blockingQueue) {
            this.f14443a = taVar;
            this.f14444b = blockingQueue;
        }

        @Override // com.ironsource.mediationsdk.bidding.BiddingDataCallback
        public void onFailure(@NotNull String str) {
            this.f14444b.add(new u7(q7.this.d(), q7.this.c(), null, ta.a(this.f14443a), str));
        }

        @Override // com.ironsource.mediationsdk.bidding.BiddingDataCallback
        public void onSuccess(@NotNull Map<String, Object> map) {
            this.f14444b.add(new u7(q7.this.d(), q7.this.c(), map, ta.a(this.f14443a), null));
        }
    }

    public q7(int i10, String str, AdData adData, s7 s7Var, r7 r7Var, NetworkSettings networkSettings) {
        this.f14437a = i10;
        this.f14438b = str;
        this.f14439c = adData;
        this.f14440d = s7Var;
        this.f14441e = r7Var;
        this.f14442f = networkSettings;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0081 A[PHI: r0 r2
      0x0081: PHI (r0v4 java.lang.String) = (r0v3 java.lang.String), (r0v7 java.lang.String) binds: [B:7:0x0058, B:11:0x007f] A[DONT_GENERATE, DONT_INLINE]
      0x0081: PHI (r2v8 com.ironsource.r7) = (r2v7 com.ironsource.r7), (r2v12 com.ironsource.r7) binds: [B:7:0x0058, B:11:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ironsource.u7 call() throws java.lang.Exception {
        /*
            r4 = this;
            com.ironsource.ta r0 = new com.ironsource.ta
            r0.<init>()
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r4.c()
            r2.append(r3)
            java.lang.String r3 = " fetching bidding data"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.verbose(r2)
            java.util.concurrent.ArrayBlockingQueue r1 = new java.util.concurrent.ArrayBlockingQueue
            r2 = 1
            r1.<init>(r2)
            com.ironsource.q7$a r2 = new com.ironsource.q7$a
            r2.<init>(r0, r1)
            com.ironsource.s7 r0 = r4.b()     // Catch: java.lang.NoClassDefFoundError -> L34 java.lang.Exception -> L5b
            com.ironsource.mediationsdk.adunit.adapter.utility.AdData r3 = r4.f14439c     // Catch: java.lang.NoClassDefFoundError -> L34 java.lang.Exception -> L5b
            r0.a(r3, r2)     // Catch: java.lang.NoClassDefFoundError -> L34 java.lang.Exception -> L5b
            goto L84
        L34:
            r0 = move-exception
            com.ironsource.i9 r2 = com.ironsource.i9.d()
            r2.a(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error while calling collectBiddingData - "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r2.error(r0)
            com.ironsource.r7 r2 = r4.f14441e
            if (r2 == 0) goto L84
            goto L81
        L5b:
            r0 = move-exception
            com.ironsource.i9 r2 = com.ironsource.i9.d()
            r2.a(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Exception while calling collectBiddingData - "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r2.error(r0)
            com.ironsource.r7 r2 = r4.f14441e
            if (r2 == 0) goto L84
        L81:
            r2.a(r0)
        L84:
            com.ironsource.r7 r0 = r4.f14441e
            if (r0 == 0) goto L8d
            com.ironsource.mediationsdk.model.NetworkSettings r2 = r4.f14442f
            r0.a(r2)
        L8d:
            java.lang.Object r0 = r1.take()
            com.ironsource.u7 r0 = (com.ironsource.u7) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.q7.call():com.ironsource.u7");
    }

    public s7 b() {
        return this.f14440d;
    }

    public String c() {
        return this.f14438b;
    }

    public int d() {
        return this.f14437a;
    }
}
