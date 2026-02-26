package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxErrorCode;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t5 extends w4 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final AtomicBoolean f7437p = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f7438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MaxAdFormat f7439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f7440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f7441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a.InterfaceC0165a f7442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final WeakReference f7443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f7444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f7445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final List f7446o;

    private class b extends w4 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f7447g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f7448h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final q2 f7449i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final List f7450j;

        class a extends z2 {
            a(a.InterfaceC0165a interfaceC0165a) {
                super(interfaceC0165a);
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f7447g;
                com.applovin.impl.sdk.n unused = b.this.f7679c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f7679c.a(b.this.f7678b, "Ad failed to load in " + jElapsedRealtime + " ms for " + t5.this.f7439h.getLabel() + " ad unit " + t5.this.f7438g + " with error: " + maxError);
                }
                b.this.b("failed to load ad: " + maxError.getCode());
                b bVar = b.this;
                bVar.a(bVar.f7449i, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, jElapsedRealtime, maxError);
                if (b.this.f7448h >= b.this.f7450j.size() - 1) {
                    t5.this.b(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                } else {
                    b bVar2 = b.this;
                    b.this.f7677a.j0().a((w4) new b(bVar2.f7448h + 1, b.this.f7450j), r5.b.MEDIATION);
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                b.this.b("loaded ad");
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f7447g;
                com.applovin.impl.sdk.n unused = b.this.f7679c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f7679c.a(b.this.f7678b, "Ad loaded in " + jElapsedRealtime + "ms for " + t5.this.f7439h.getLabel() + " ad unit " + t5.this.f7438g);
                }
                q2 q2Var = (q2) maxAd;
                b.this.a(q2Var, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, jElapsedRealtime, null);
                int i10 = b.this.f7448h;
                while (true) {
                    i10++;
                    if (i10 >= b.this.f7450j.size()) {
                        t5.this.b(q2Var);
                        return;
                    } else {
                        b bVar = b.this;
                        bVar.a((q2) bVar.f7450j.get(i10), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1L, null);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Loading ad " + (this.f7448h + 1) + " of " + this.f7450j.size() + " from " + this.f7449i.c() + " for " + t5.this.f7439h.getLabel() + " ad unit " + t5.this.f7438g);
            }
            b("started to load ad");
            Context context = (Context) t5.this.f7443l.get();
            Activity activityN0 = context instanceof Activity ? (Activity) context : this.f7677a.n0();
            this.f7677a.T().b(this.f7449i);
            this.f7677a.Q().loadThirdPartyMediatedAd(t5.this.f7438g, this.f7449i, activityN0, new a(t5.this.f7442k));
        }

        private b(int i10, List list) {
            super(t5.this.f7678b, t5.this.f7677a, t5.this.f7438g);
            this.f7447g = SystemClock.elapsedRealtime();
            this.f7448h = i10;
            this.f7449i = (q2) list.get(i10);
            this.f7450j = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(q2 q2Var, MaxNetworkResponseInfo.AdLoadState adLoadState, long j10, MaxError maxError) {
            t5.this.f7446o.add(new MaxNetworkResponseInfoImpl(adLoadState, l3.a(q2Var.b()), q2Var.F(), q2Var.S(), j10, q2Var.C(), maxError));
        }
    }

    t5(String str, MaxAdFormat maxAdFormat, Map map, JSONObject jSONObject, Context context, com.applovin.impl.sdk.j jVar, a.InterfaceC0165a interfaceC0165a) {
        super("TaskProcessMediationWaterfall", jVar, str);
        this.f7438g = str;
        this.f7439h = maxAdFormat;
        this.f7440i = jSONObject;
        this.f7442k = interfaceC0165a;
        this.f7443l = new WeakReference(context);
        this.f7444m = JsonUtils.getString(jSONObject, "mcode", "");
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ads", new JSONArray());
        this.f7441j = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.f7441j.add(q2.a(map, JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null), jSONObject, jVar));
        }
        this.f7446o = new ArrayList(this.f7441j.size());
    }

    @Override // java.lang.Runnable
    public void run() {
        final MaxErrorImpl maxErrorImpl;
        this.f7445n = SystemClock.elapsedRealtime();
        int i10 = 0;
        if (this.f7440i.optBoolean("is_testing", false) && !this.f7677a.l0().c() && f7437p.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ae
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4875a.e();
                }
            });
        }
        if (this.f7441j.size() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Starting waterfall for " + this.f7439h.getLabel() + " ad unit " + this.f7438g + " with " + this.f7441j.size() + " ad(s)...");
            }
            this.f7677a.j0().a(new b(i10, this.f7441j));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.k(this.f7678b, "No ads were returned from the server for " + this.f7439h.getLabel() + " ad unit " + this.f7438g);
        }
        z6.a(this.f7438g, this.f7439h, this.f7440i, this.f7677a);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f7440i, "settings", new JSONObject());
        long j10 = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
        if (l3.a(this.f7440i, this.f7438g, this.f7677a)) {
            maxErrorImpl = new MaxErrorImpl(MaxErrorCode.INVALID_AD_UNIT_ID, "Ad Unit ID " + this.f7438g + " is invalid or disabled.\nMake sure to use an Ad Unit ID from the MAX dashboard that is enabled and configured for the current application.\nFor more information, see https://developers.applovin.com/en/getting-started#step-2-create-an-ad-unit\nNote: New ad units cannot load ads until 30-60 minutes after they are created");
            if (z6.c(this.f7677a) && ((Boolean) this.f7677a.a(l4.O5)).booleanValue()) {
                j10 = 0;
            }
        } else {
            maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device");
        }
        if (j10 <= 0) {
            b(maxErrorImpl);
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(j10);
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.be
            @Override // java.lang.Runnable
            public final void run() {
                this.f4925a.b(maxErrorImpl);
            }
        };
        if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", Boolean.FALSE).booleanValue()) {
            c0.a(millis, this.f7677a, runnable);
        } else {
            AppLovinSdkUtils.runOnUiThreadDelayed(runnable, millis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        z6.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", this.f7677a.n0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q2 q2Var) {
        this.f7677a.T().c(q2Var);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f7445n;
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.d(this.f7678b, "Waterfall loaded in " + jElapsedRealtime + "ms from " + q2Var.c() + " for " + this.f7439h.getLabel() + " ad unit " + this.f7438g);
        }
        q2Var.a(new MaxAdWaterfallInfoImpl(q2Var, jElapsedRealtime, this.f7446o, this.f7444m));
        l2.f(this.f7442k, q2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(MaxError maxError) {
        if (maxError.getCode() == 204) {
            this.f7677a.E().c(v1.f7571u);
        } else if (maxError.getCode() == -5001) {
            this.f7677a.E().c(v1.f7572v);
        } else {
            this.f7677a.E().c(v1.f7573w);
        }
        ArrayList arrayList = new ArrayList(this.f7446o.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : this.f7446o) {
            if (maxNetworkResponseInfo.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                arrayList.add(maxNetworkResponseInfo);
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("======FAILED AD LOADS======");
            sb.append("\n");
            int i10 = 0;
            while (i10 < arrayList.size()) {
                MaxNetworkResponseInfo maxNetworkResponseInfo2 = (MaxNetworkResponseInfo) arrayList.get(i10);
                i10++;
                sb.append(i10);
                sb.append(") ");
                sb.append(maxNetworkResponseInfo2.getMediatedNetwork().getName());
                sb.append("\n");
                sb.append("..code: ");
                sb.append(maxNetworkResponseInfo2.getError().getCode());
                sb.append("\n");
                sb.append("..message: ");
                sb.append(maxNetworkResponseInfo2.getError().getMessage());
                sb.append("\n");
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f7445n;
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.d(this.f7678b, "Waterfall failed in " + jElapsedRealtime + "ms for " + this.f7439h.getLabel() + " ad unit " + this.f7438g + " with error: " + maxError);
        }
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl(null, JsonUtils.getString(this.f7440i, "waterfall_name", ""), JsonUtils.getString(this.f7440i, "waterfall_test_name", ""), jElapsedRealtime, this.f7446o, JsonUtils.optList(JsonUtils.getJSONArray(this.f7440i, "mwf_info_urls", null), Collections.EMPTY_LIST), this.f7444m));
        l2.a(this.f7442k, this.f7438g, maxError);
    }
}
