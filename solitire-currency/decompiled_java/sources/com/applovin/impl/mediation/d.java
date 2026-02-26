package com.applovin.impl.mediation;

import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.d5;
import com.applovin.impl.g3;
import com.applovin.impl.j5;
import com.applovin.impl.l2;
import com.applovin.impl.l4;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.q2;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.w4;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f6100b = new HashMap(4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f6101c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f6102d = new HashMap(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f6103e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f6104f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f6105g = new Object();

    class a implements d5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f6106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f6107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f6108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MaxAdFormat f6109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f6110e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f6111f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f6112g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC0165a f6113h;

        a(long j10, Map map, String str, MaxAdFormat maxAdFormat, Map map2, Map map3, Context context, a.InterfaceC0165a interfaceC0165a) {
            this.f6106a = j10;
            this.f6107b = map;
            this.f6108c = str;
            this.f6109d = maxAdFormat;
            this.f6110e = map2;
            this.f6111f = map3;
            this.f6112g = context;
            this.f6113h = interfaceC0165a;
        }

        @Override // com.applovin.impl.d5.b
        public void a(JSONArray jSONArray) {
            this.f6107b.put("sct_ms", Long.valueOf(SystemClock.elapsedRealtime() - this.f6106a));
            this.f6107b.put("calfc", Integer.valueOf(d.this.b(this.f6108c)));
            j5 j5Var = new j5(this.f6108c, this.f6109d, this.f6110e, this.f6111f, this.f6107b, jSONArray, this.f6112g, d.this.f6099a, this.f6113h);
            if (((Boolean) d.this.f6099a.a(g3.f5246u7)).booleanValue()) {
                d.this.f6099a.j0().a((w4) j5Var, r5.b.MEDIATION);
            } else {
                d.this.f6099a.j0().a(j5Var);
            }
        }
    }

    public enum b {
        PUBLISHER_INITIATED("publisher_initiated"),
        SEQUENTIAL_OR_PRECACHE("sequential_or_precache"),
        REFRESH("refresh"),
        EXPONENTIAL_RETRY("exponential_retry"),
        EXPIRED("expired"),
        NATIVE_AD_PLACER("native_ad_placer");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6122a;

        b(String str) {
            this.f6122a = str;
        }

        public String b() {
            return this.f6122a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements a.InterfaceC0165a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f6123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference f6124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f6125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final C0166d f6126d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final MaxAdFormat f6127e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Map f6128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Map f6129g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Map f6130h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f6131i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f6132j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f6133k;

        /* synthetic */ c(Map map, Map map2, Map map3, C0166d c0166d, MaxAdFormat maxAdFormat, long j10, long j11, d dVar, com.applovin.impl.sdk.j jVar, Context context, a aVar) {
            this(map, map2, map3, c0166d, maxAdFormat, j10, j11, dVar, jVar, context);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, MaxError maxError) {
            this.f6125c.c(str);
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f6132j;
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) maxError.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f6123a.Q().processWaterfallInfoPostback(str, this.f6127e, maxAdWaterfallInfoImpl, maxError, this.f6133k, jElapsedRealtime);
            }
            boolean z10 = maxError.getCode() == -5603 && z6.c(this.f6123a) && ((Boolean) this.f6123a.a(l4.O5)).booleanValue();
            if (this.f6123a.a(g3.f5239o7, this.f6127e) && this.f6126d.f6136c < this.f6131i && !z10) {
                C0166d.e(this.f6126d);
                final int iPow = (int) Math.pow(2.0d, this.f6126d.f6136c);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6322a.a(iPow, str);
                    }
                }, TimeUnit.SECONDS.toMillis(iPow));
                return;
            }
            this.f6126d.f6136c = 0;
            this.f6126d.f6135b.set(false);
            if (this.f6126d.f6137d != null) {
                MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxError;
                maxErrorImpl.setLoadTag(this.f6126d.f6134a);
                maxErrorImpl.setRequestLatencyMillis(jElapsedRealtime);
                l2.a(this.f6126d.f6137d, str, maxError);
                this.f6126d.f6137d = null;
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            q2 q2Var = (q2) maxAd;
            q2Var.i(this.f6126d.f6134a);
            q2Var.a(SystemClock.elapsedRealtime() - this.f6132j);
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) q2Var.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f6123a.Q().processWaterfallInfoPostback(q2Var.getAdUnitId(), this.f6127e, maxAdWaterfallInfoImpl, null, this.f6133k, q2Var.getRequestLatencyMillis());
            }
            this.f6125c.a(maxAd.getAdUnitId());
            this.f6126d.f6136c = 0;
            if (this.f6126d.f6137d == null) {
                this.f6125c.a(q2Var);
                this.f6126d.f6135b.set(false);
                return;
            }
            q2Var.A().c().a(this.f6126d.f6137d);
            this.f6126d.f6137d.onAdLoaded(q2Var);
            if (q2Var.L().endsWith("load")) {
                this.f6126d.f6137d.onAdRevenuePaid(q2Var);
            }
            this.f6126d.f6137d = null;
            if ((!this.f6123a.c(g3.f5237m7).contains(maxAd.getAdUnitId()) && !this.f6123a.a(g3.f5236l7, maxAd.getFormat())) || this.f6123a.l0().c() || this.f6123a.l0().d()) {
                this.f6126d.f6135b.set(false);
                return;
            }
            Context contextN = (Context) this.f6124b.get();
            if (contextN == null) {
                contextN = com.applovin.impl.sdk.j.n();
            }
            this.f6132j = SystemClock.elapsedRealtime();
            this.f6133k = System.currentTimeMillis();
            this.f6130h.put("art", b.SEQUENTIAL_OR_PRECACHE.b());
            this.f6125c.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f6128f, this.f6129g, this.f6130h, contextN, this);
        }

        private c(Map map, Map map2, Map map3, C0166d c0166d, MaxAdFormat maxAdFormat, long j10, long j11, d dVar, com.applovin.impl.sdk.j jVar, Context context) {
            this.f6123a = jVar;
            this.f6124b = new WeakReference(context);
            this.f6125c = dVar;
            this.f6126d = c0166d;
            this.f6127e = maxAdFormat;
            this.f6129g = map2;
            this.f6128f = map;
            this.f6130h = map3;
            this.f6132j = j10;
            this.f6133k = j11;
            if (CollectionUtils.getBoolean(map2, "disable_auto_retries")) {
                this.f6131i = -1;
            } else if (maxAdFormat.isAdViewAd() && CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) {
                this.f6131i = Math.min(2, ((Integer) jVar.a(g3.f5238n7)).intValue());
            } else {
                this.f6131i = ((Integer) jVar.a(g3.f5238n7)).intValue();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i10, String str) {
            this.f6129g.put("retry_delay_sec", Integer.valueOf(i10));
            this.f6129g.put("retry_attempt", Integer.valueOf(this.f6126d.f6136c));
            Context contextN = (Context) this.f6124b.get();
            if (contextN == null) {
                contextN = com.applovin.impl.sdk.j.n();
            }
            this.f6130h.put("art", b.EXPONENTIAL_RETRY.b());
            this.f6130h.put("era", Integer.valueOf(this.f6126d.f6136c));
            this.f6133k = System.currentTimeMillis();
            this.f6125c.a(str, this.f6127e, this.f6128f, this.f6129g, this.f6130h, contextN, this);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.d$d, reason: collision with other inner class name */
    private static class C0166d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f6135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f6136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile a.InterfaceC0165a f6137d;

        /* synthetic */ C0166d(String str, a aVar) {
            this(str);
        }

        static /* synthetic */ int e(C0166d c0166d) {
            int i10 = c0166d.f6136c;
            c0166d.f6136c = i10 + 1;
            return i10;
        }

        private C0166d(String str) {
            this.f6135b = new AtomicBoolean();
            this.f6134a = str;
        }
    }

    public d(com.applovin.impl.sdk.j jVar) {
        this.f6099a = jVar;
    }

    private String b(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            str3 = "-" + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        return sb.toString();
    }

    private q2 e(String str) {
        q2 q2Var;
        synchronized (this.f6103e) {
            q2Var = (q2) this.f6102d.get(str);
            this.f6102d.remove(str);
        }
        return q2Var;
    }

    public void c(String str, String str2) {
        synchronized (this.f6101c) {
            this.f6100b.remove(b(str, str2));
        }
    }

    public boolean d(String str) {
        boolean z10;
        synchronized (this.f6103e) {
            z10 = this.f6102d.get(str) != null;
        }
        return z10;
    }

    public int b(String str) {
        int iIntValue;
        synchronized (this.f6105g) {
            Integer num = (Integer) this.f6104f.get(str);
            iIntValue = num != null ? num.intValue() : 0;
        }
        return iIntValue;
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, b bVar, Map map, Map map2, Context context, a.InterfaceC0165a interfaceC0165a) {
        q2 q2VarE = (this.f6099a.l0().d() || z6.f(com.applovin.impl.sdk.j.n())) ? null : e(str);
        if (q2VarE != null) {
            q2VarE.i(str2);
            q2VarE.A().c().a(interfaceC0165a);
            interfaceC0165a.onAdLoaded(q2VarE);
            if (q2VarE.L().endsWith("load")) {
                interfaceC0165a.onAdRevenuePaid(q2VarE);
            }
        }
        C0166d c0166dA = a(str, str2);
        if (!c0166dA.f6135b.compareAndSet(false, true)) {
            if (c0166dA.f6137d != null && c0166dA.f6137d != interfaceC0165a) {
                com.applovin.impl.sdk.n.j("MediationAdLoadManager", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
            }
            c0166dA.f6137d = interfaceC0165a;
            return;
        }
        if (q2VarE == null) {
            c0166dA.f6137d = interfaceC0165a;
        }
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        mapSynchronizedMap.put("art", bVar.b());
        if (StringUtils.isValidString(str2)) {
            mapSynchronizedMap.put("alt", str2);
        }
        a(str, maxAdFormat, map, map2, mapSynchronizedMap, context, new c(map, map2, mapSynchronizedMap, c0166dA, maxAdFormat, SystemClock.elapsedRealtime(), System.currentTimeMillis(), this, this.f6099a, context, null));
    }

    public void c(String str) {
        synchronized (this.f6105g) {
            this.f6099a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f6099a.I().a("MediationAdLoadManager", "Incrementing ad load failures count for ad unit ID: " + str);
            }
            Integer num = (Integer) this.f6104f.get(str);
            if (num == null) {
                num = 0;
            }
            this.f6104f.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, Context context, a.InterfaceC0165a interfaceC0165a) {
        this.f6099a.j0().a((w4) new d5(str, maxAdFormat, map, context, this.f6099a, new a(SystemClock.elapsedRealtime(), map3, str, maxAdFormat, map, map2, context, interfaceC0165a)), r5.b.MEDIATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q2 q2Var) {
        synchronized (this.f6103e) {
            if (this.f6102d.containsKey(q2Var.getAdUnitId())) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "Ad in cache already: " + q2Var.getAdUnitId());
            }
            this.f6102d.put(q2Var.getAdUnitId(), q2Var);
        }
    }

    private C0166d a(String str, String str2) {
        C0166d c0166d;
        synchronized (this.f6101c) {
            String strB = b(str, str2);
            c0166d = (C0166d) this.f6100b.get(strB);
            if (c0166d == null) {
                c0166d = new C0166d(str2, null);
                this.f6100b.put(strB, c0166d);
            }
        }
        return c0166d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.f6105g) {
            this.f6099a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f6099a.I().a("MediationAdLoadManager", "Clearing ad load failures count for ad unit ID: " + str);
            }
            this.f6104f.remove(str);
        }
    }
}
