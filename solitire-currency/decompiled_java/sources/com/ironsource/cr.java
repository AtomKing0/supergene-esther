package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.environment.StringUtils;
import com.ironsource.m8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.qe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class cr {
    protected static final boolean A = false;
    protected static final String A0 = "parallelInit";
    protected static final String A1 = "adSourceName";
    protected static final int B = 60;
    protected static final String B0 = "waitUntilAllProvidersFinishInit";
    protected static final String B1 = "providerNetworkKey";
    protected static final int C = 10000;
    protected static final String C0 = "sharedManagersThread";
    protected static final String C1 = "spId";
    protected static final int D = 10000;
    protected static final String D0 = "parallelLoad";
    protected static final String D1 = "mpis";
    protected static final int E = -1;
    protected static final String E0 = "bidderExclusive";
    protected static final String E1 = "auction";
    protected static final int F = 5000;
    protected static final String F0 = "adapterTimeOutInSeconds";
    protected static final String F1 = "auctionData";
    protected static final int G = 3;
    protected static final String G0 = "atim";
    protected static final String G1 = "auctioneerURL";
    protected static final int H = 3;
    protected static final String H0 = "bannerInterval";
    protected static final String H1 = "extAuctioneerURL";
    protected static final int I = 3;
    protected static final String I0 = "isOneFlow";
    protected static final String I1 = "objectPerWaterfall";
    protected static final int J = 0;
    protected static final String J0 = "expiredDurationInMinutes";
    protected static final String J1 = "minTimeBeforeFirstAuction";
    protected static final int K = 2;
    protected static final String K0 = "server";
    protected static final String K1 = "timeToWaitBeforeAuction";
    protected static final int L = 15;
    protected static final String L0 = "publisher";
    protected static final String L1 = "timeToWaitBeforeLoad";
    protected static final long M = 10000;
    protected static final String M0 = "console";
    protected static final String M1 = "auctionRetryInterval";
    protected static final boolean N = false;
    protected static final String N0 = "sendUltraEvents";
    protected static final String N1 = "isLoadWhileShow";
    protected static final long O = 3000;
    protected static final String O0 = "sendEventsToggle";
    protected static final String O1 = "auctionTrials";
    protected static final boolean P = false;
    protected static final String P0 = "eventsCompression";
    protected static final String P1 = "auctionTimeout";
    protected static final boolean Q = false;
    protected static final String Q0 = "eventsCompressionLevel";
    protected static final String Q1 = "auctionSavedHistory";
    protected static final int R = 30000;
    protected static final String R0 = "serverEventsURL";
    protected static final String R1 = "disableLoadWhileShowSupportFor";
    protected static final int S = -1;
    protected static final String S0 = "serverEventsType";
    protected static final String S1 = "timeToDeleteOldWaterfallAfterAuction";
    protected static final int T = 5000;
    protected static final String T0 = "backupThreshold";
    protected static final String T1 = "compressAuctionRequest";
    protected static final int U = 1;
    protected static final String U0 = "maxNumberOfEvents";
    protected static final String U1 = "compressAuctionResponse";
    protected static final boolean V = false;
    protected static final String V0 = "maxEventsPerBatch";
    protected static final String V1 = "encryptionVersion";
    protected static final int W = 15000;
    protected static final String W0 = "optOut";
    protected static final String W1 = "shouldSendBannerBURLFromImpression";
    protected static final int X = 15000;
    protected static final String X0 = "optIn";
    protected static final String X1 = "impressionTimeout";
    protected static final String Y = "providerOrder";
    protected static final String Y0 = "triggerEvents";
    protected static final String Y1 = "optInKeys";
    protected static final String Z = "providerSettings";
    protected static final String Z0 = "nonConnectivityEvents";
    protected static final String Z1 = "tokenGenericParams";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected static final String f11614a0 = "configurations";

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    protected static final String f11615a1 = "shouldSendPublisherLogsOnUIThread";

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    protected static final String f11616a2 = "compressToken";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected static final String f11617b0 = "genericParams";

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    protected static final String f11618b1 = "pixel";

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    protected static final String f11619b2 = "compressExternalToken";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected static final String f11620c0 = "adUnits";

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    protected static final String f11621c1 = "pixelEventsUrl";

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    protected static final String f11622c2 = "instanceType";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected static final String f11623d0 = "providerLoadName";

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    protected static final String f11624d1 = "pixelEventsEnabled";

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    protected static final String f11625d2 = "maxAdsPerSession";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected static final String f11626e0 = "application";

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    protected static final String f11627e1 = "placements";

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    protected static final String f11628e2 = "reward";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    protected static final String f11629f0 = "rewardedVideo";

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    protected static final String f11630f1 = "placementId";

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    protected static final String f11631f2 = "name";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected static final String f11632g0 = "interstitial";

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    protected static final String f11633g1 = "placementName";

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    protected static final String f11634g2 = "amount";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    protected static final String f11635h0 = "banner";

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    protected static final String f11636h1 = "delivery";

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    protected static final String f11637h2 = "bannerRefreshRate";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    protected static final String f11638i0 = "nativeAd";

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    protected static final String f11639i1 = "isDefault";

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    protected static final String f11640i2 = "protocolVersion";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    protected static final String f11641j0 = "integration";

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    protected static final String f11642j1 = "capping";

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    protected static final String f11643j2 = "adFormats";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    protected static final String f11644k0 = "loggers";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    protected static final String f11645k1 = "pacing";

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    protected static final String f11646k2 = "adUnits";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f11647l = "appKey";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    protected static final String f11648l0 = "segment";

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    protected static final String f11649l1 = "enabled";

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    protected static final String f11650l2 = "rewarded";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f11651m = "userId";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    protected static final String f11652m0 = "events";

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    protected static final String f11653m1 = "maxImpressions";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f11654n = "response";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected static final String f11655n0 = "crashReporter";

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    protected static final String f11656n1 = "numOfSeconds";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected static final String f11657o = "error";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected static final String f11658o0 = "token";

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    protected static final String f11659o1 = "unit";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected static final int f11660p = 3;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    protected static final String f11661p0 = "external";

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    protected static final String f11662p1 = "virtualItemName";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected static final boolean f11663q = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    protected static final String f11664q0 = "mediationTypes";

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    protected static final String f11665q1 = "virtualItemCount";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected static final boolean f11666r = true;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    protected static final String f11667r0 = "providerDefaultInstance";

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    protected static final String f11668r1 = "uuidEnabled";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected static final boolean f11669s = true;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    protected static final String f11670s0 = "testSuite";

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    protected static final String f11671s1 = "abt";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected static final int f11672t = 2;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    protected static final String f11673t0 = "controllerUrl";

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    protected static final String f11674t1 = "delayLoadFailure";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected static final int f11675u = 2;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    protected static final String f11676u0 = "AdQuality";

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    protected static final String f11677u1 = "keysToInclude";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected static final int f11678v = 1;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    protected static final String f11679v0 = "initSDK";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    protected static final String f11680v1 = "reporterURL";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected static final int f11681w = 1;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected static final String f11682w0 = "settings";

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    protected static final String f11683w1 = "reporterKeyword";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected static final boolean f11684x = true;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    protected static final String f11685x0 = "collectBiddingDataTimeout";

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    protected static final String f11686x1 = "includeANR";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected static final boolean f11687y = false;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    protected static final String f11688y0 = "collectBiddingDataAsyncEnabled";

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    protected static final String f11689y1 = "timeout";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected static final boolean f11690z = false;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    protected static final String f11691z0 = "providers";

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    protected static final String f11692z1 = "setIgnoreDebugger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private qo f11693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private so f11694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m8 f11695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f11698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f11699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f11700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private qe.a f11701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private xb f11703k;

    public enum a {
        NOT_SET("0"),
        CACHE("1"),
        SERVER("2");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11708a;

        a(String str) {
            this.f11708a = str;
        }

        public String a() {
            return this.f11708a;
        }
    }

    public cr(Context context, String str, String str2, String str3) {
        this.f11700h = a.NOT_SET;
        this.f11702j = false;
        this.f11699g = context;
        this.f11701i = el.I().m();
        try {
            this.f11698f = TextUtils.isEmpty(str3) ? new JSONObject() : new JSONObject(str3);
            this.f11702j = n();
            s();
            q();
            r();
            this.f11696d = TextUtils.isEmpty(str) ? "" : str;
            this.f11697e = TextUtils.isEmpty(str2) ? "" : str2;
            b(this.f11698f);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            a();
        }
    }

    private int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i10) {
        int iOptInt = 0;
        if (jSONObject.has(str)) {
            iOptInt = jSONObject.optInt(str, 0);
        } else if (jSONObject2.has(str)) {
            iOptInt = jSONObject2.optInt(str, 0);
        }
        return iOptInt == 0 ? i10 : iOptInt;
    }

    @NotNull
    public static st b(@Nullable cr crVar) {
        return (crVar == null || !crVar.p()) ? st.a() : crVar.c().b().j();
    }

    private c1 c(JSONObject jSONObject) {
        c1 c1Var = new c1();
        JSONObject jSONObjectC = c(jSONObject, "AdQuality");
        if (jSONObjectC != null) {
            c1Var.a(jSONObjectC.optBoolean(f11679v0));
        }
        return c1Var;
    }

    private Context d() {
        return this.f11699g;
    }

    private InterstitialPlacement e(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean(f11639i1, false);
            co coVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                InterstitialPlacement interstitialPlacement = new InterstitialPlacement(iOptInt, strOptString, zOptBoolean, coVarA);
                if (coVarA == null) {
                    return interstitialPlacement;
                }
                this.f11701i.c(this.f11699g, interstitialPlacement, IronSource.AD_UNIT.INTERSTITIAL);
                return interstitialPlacement;
            }
        }
        return null;
    }

    private ul f(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean(f11639i1, false);
            co coVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                ul ulVar = new ul(iOptInt, strOptString, zOptBoolean, coVarA);
                if (coVarA == null) {
                    return ulVar;
                }
                this.f11701i.c(this.f11699g, ulVar, IronSource.AD_UNIT.NATIVE_AD);
                return ulVar;
            }
        }
        return null;
    }

    private Placement g(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean(f11639i1, false);
            String strOptString2 = jSONObject.optString(f11662p1, "");
            int iOptInt2 = jSONObject.optInt(f11665q1, -1);
            co coVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && iOptInt2 > 0) {
                Placement placement = new Placement(iOptInt, strOptString, zOptBoolean, strOptString2, iOptInt2, coVarA);
                if (coVarA == null) {
                    return placement;
                }
                this.f11701i.c(this.f11699g, placement, IronSource.AD_UNIT.REWARDED_VIDEO);
                return placement;
            }
        }
        return null;
    }

    private String l() {
        return this.f11702j ? "rewarded" : f11629f0;
    }

    private boolean m() {
        JSONObject jSONObjectC;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectC2 = c(this.f11698f, "providerOrder");
        JSONArray jSONArrayNames = jSONObjectC2.names();
        if (jSONArrayNames == null) {
            return true;
        }
        JSONObject jSONObjectC3 = c(c(this.f11698f, "configurations"), b());
        for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
            String strOptString = jSONArrayNames.optString(i10);
            JSONArray jSONArrayOptJSONArray2 = jSONObjectC2.optJSONArray(strOptString);
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0 && (jSONObjectC = c(jSONObjectC3, strOptString)) != null && ((jSONArrayOptJSONArray = jSONObjectC.optJSONArray("placements")) == null || jSONArrayOptJSONArray.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean n() {
        int iOptInt;
        try {
            iOptInt = this.f11698f.optInt(f11640i2, 0);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            iOptInt = 0;
        }
        return iOptInt == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0939  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q() {
        /*
            Method dump skipped, instruction units count: 2922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.cr.q():void");
    }

    private void r() {
        try {
            JSONObject jSONObjectC = c(this.f11698f, "providerOrder");
            JSONArray jSONArrayB = b(jSONObjectC, l());
            JSONArray jSONArrayB2 = b(jSONObjectC, "interstitial");
            JSONArray jSONArrayB3 = b(jSONObjectC, "banner");
            JSONArray jSONArrayB4 = b(jSONObjectC, "nativeAd");
            this.f11693a = new qo();
            if (jSONArrayB != null && c() != null && c().f() != null) {
                for (int i10 = 0; i10 < jSONArrayB.length(); i10++) {
                    String strOptString = jSONArrayB.optString(i10);
                    this.f11693a.d(strOptString);
                    NetworkSettings networkSettingsB = so.c().b(strOptString);
                    if (networkSettingsB != null) {
                        networkSettingsB.setRewardedVideoPriority(i10);
                    }
                }
            }
            if (jSONArrayB2 != null && c() != null && c().d() != null) {
                for (int i11 = 0; i11 < jSONArrayB2.length(); i11++) {
                    String strOptString2 = jSONArrayB2.optString(i11);
                    this.f11693a.b(strOptString2);
                    NetworkSettings networkSettingsB2 = so.c().b(strOptString2);
                    if (networkSettingsB2 != null) {
                        networkSettingsB2.setInterstitialPriority(i11);
                    }
                }
            }
            if (jSONArrayB3 != null) {
                for (int i12 = 0; i12 < jSONArrayB3.length(); i12++) {
                    String strOptString3 = jSONArrayB3.optString(i12);
                    this.f11693a.a(strOptString3);
                    NetworkSettings networkSettingsB3 = so.c().b(strOptString3);
                    if (networkSettingsB3 != null) {
                        networkSettingsB3.setBannerPriority(i12);
                    }
                }
            }
            if (jSONArrayB4 != null) {
                for (int i13 = 0; i13 < jSONArrayB4.length(); i13++) {
                    String strOptString4 = jSONArrayB4.optString(i13);
                    this.f11693a.c(strOptString4);
                    NetworkSettings networkSettingsB4 = so.c().b(strOptString4);
                    if (networkSettingsB4 != null) {
                        networkSettingsB4.setNativeAdPriority(i13);
                    }
                }
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    private void s() {
        JSONObject jSONObject;
        Iterator<String> it;
        cr crVar;
        NetworkSettings networkSettings;
        cr crVar2 = this;
        try {
            crVar2.f11694b = so.c();
            JSONObject jSONObjectC = crVar2.c(crVar2.f11698f, "providerSettings");
            Iterator<String> itKeys = jSONObjectC.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectC.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("mpis", false);
                    String strOptString = jSONObjectOptJSONObject.optString("spId", "0");
                    String strOptString2 = jSONObjectOptJSONObject.optString("adSourceName", null);
                    String strOptString3 = jSONObjectOptJSONObject.optString("providerNetworkKey", null);
                    String strOptString4 = jSONObjectOptJSONObject.optString("providerLoadName", next);
                    String strOptString5 = jSONObjectOptJSONObject.optString("providerDefaultInstance", strOptString4);
                    JSONObject jSONObjectC2 = crVar2.c(jSONObjectOptJSONObject, b());
                    JSONObject jSONObjectC3 = crVar2.c(jSONObjectOptJSONObject, "application");
                    JSONObject jSONObjectC4 = crVar2.c(jSONObjectC2, l());
                    JSONObject jSONObjectC5 = crVar2.c(jSONObjectC2, "interstitial");
                    JSONObject jSONObjectC6 = crVar2.c(jSONObjectC2, "banner");
                    JSONObject jSONObjectC7 = crVar2.c(jSONObjectC2, "nativeAd");
                    JSONObject jSONObjectMergeJsons = IronSourceUtils.mergeJsons(jSONObjectC4, jSONObjectC3);
                    JSONObject jSONObjectMergeJsons2 = IronSourceUtils.mergeJsons(jSONObjectC5, jSONObjectC3);
                    JSONObject jSONObjectMergeJsons3 = IronSourceUtils.mergeJsons(jSONObjectC6, jSONObjectC3);
                    JSONObject jSONObjectMergeJsons4 = IronSourceUtils.mergeJsons(jSONObjectC7, jSONObjectC3);
                    if (crVar2.f11694b.a(next)) {
                        NetworkSettings networkSettingsB = crVar2.f11694b.b(next);
                        JSONObject rewardedVideoSettings = networkSettingsB.getRewardedVideoSettings();
                        JSONObject interstitialSettings = networkSettingsB.getInterstitialSettings();
                        JSONObject bannerSettings = networkSettingsB.getBannerSettings();
                        JSONObject nativeAdSettings = networkSettingsB.getNativeAdSettings();
                        networkSettingsB.setRewardedVideoSettings(IronSourceUtils.mergeJsons(rewardedVideoSettings, jSONObjectMergeJsons));
                        networkSettingsB.setInterstitialSettings(IronSourceUtils.mergeJsons(interstitialSettings, jSONObjectMergeJsons2));
                        networkSettingsB.setBannerSettings(IronSourceUtils.mergeJsons(bannerSettings, jSONObjectMergeJsons3));
                        networkSettingsB.setNativeAdSettings(IronSourceUtils.mergeJsons(nativeAdSettings, jSONObjectMergeJsons4));
                        networkSettingsB.setIsMultipleInstances(zOptBoolean);
                        networkSettingsB.setSubProviderId(strOptString);
                        networkSettingsB.setAdSourceNameForEvents(strOptString2);
                        networkSettingsB.setProviderNetworkKey(strOptString3);
                    } else {
                        if (crVar2.b(strOptString4)) {
                            jSONObject = jSONObjectC;
                            NetworkSettings networkSettingsB2 = crVar2.f11694b.b("Mediation");
                            JSONObject rewardedVideoSettings2 = networkSettingsB2.getRewardedVideoSettings();
                            JSONObject interstitialSettings2 = networkSettingsB2.getInterstitialSettings();
                            JSONObject bannerSettings2 = networkSettingsB2.getBannerSettings();
                            JSONObject nativeAdSettings2 = networkSettingsB2.getNativeAdSettings();
                            it = itKeys;
                            JSONObject jSONObject2 = new JSONObject(rewardedVideoSettings2.toString());
                            JSONObject jSONObject3 = new JSONObject(interstitialSettings2.toString());
                            try {
                                networkSettings = new NetworkSettings(next, strOptString4, strOptString5, strOptString3, jSONObjectC3, IronSourceUtils.mergeJsons(jSONObject2, jSONObjectMergeJsons), IronSourceUtils.mergeJsons(jSONObject3, jSONObjectMergeJsons2), IronSourceUtils.mergeJsons(new JSONObject(bannerSettings2.toString()), jSONObjectMergeJsons3), IronSourceUtils.mergeJsons(new JSONObject(nativeAdSettings2.toString()), jSONObjectMergeJsons4));
                                networkSettings.setIsMultipleInstances(zOptBoolean);
                                networkSettings.setSubProviderId(strOptString);
                                networkSettings.setAdSourceNameForEvents(strOptString2);
                                crVar = this;
                            } catch (Exception e10) {
                                e = e10;
                                i9.d().a(e);
                                IronLog.INTERNAL.error(e.toString());
                                return;
                            }
                        } else {
                            try {
                                jSONObject = jSONObjectC;
                                it = itKeys;
                                crVar = crVar2;
                                networkSettings = new NetworkSettings(next, strOptString4, strOptString5, strOptString3, jSONObjectC3, jSONObjectMergeJsons, jSONObjectMergeJsons2, jSONObjectMergeJsons3, jSONObjectMergeJsons4);
                                networkSettings.setIsMultipleInstances(zOptBoolean);
                                networkSettings.setSubProviderId(strOptString);
                                networkSettings.setAdSourceNameForEvents(strOptString2);
                            } catch (Exception e11) {
                                e = e11;
                                i9.d().a(e);
                                IronLog.INTERNAL.error(e.toString());
                                return;
                            }
                        }
                        crVar.f11694b.a(networkSettings);
                        crVar2 = crVar;
                        jSONObjectC = jSONObject;
                        itKeys = it;
                    }
                }
            }
            crVar2.f11694b.b();
        } catch (Exception e12) {
            e = e12;
        }
    }

    public a h() {
        return this.f11700h;
    }

    public JSONObject i() {
        return this.f11698f;
    }

    public qo j() {
        return this.f11693a;
    }

    public so k() {
        return this.f11694b;
    }

    public boolean o() {
        return !TextUtils.isEmpty(c().g().b());
    }

    public boolean p() {
        JSONObject jSONObject = this.f11698f;
        return (((((jSONObject != null) && !jSONObject.has("error")) && this.f11693a != null) && this.f11694b != null) && this.f11695c != null) && m();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.f11696d);
            jSONObject.put("userId", this.f11697e);
            jSONObject.put("response", this.f11698f);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        return jSONObject.toString();
    }

    public cr(cr crVar) {
        this.f11700h = a.NOT_SET;
        this.f11702j = false;
        try {
            this.f11699g = crVar.d();
            this.f11698f = new JSONObject(crVar.f11698f.toString());
            this.f11696d = crVar.f11696d;
            this.f11697e = crVar.f11697e;
            this.f11702j = crVar.f11702j;
            this.f11693a = crVar.j();
            this.f11694b = crVar.k();
            this.f11695c = crVar.c();
            this.f11700h = crVar.h();
            this.f11701i = el.I().m();
            b(this.f11698f);
        } catch (Exception e10) {
            i9.d().a(e10);
            a();
        }
    }

    private long a(JSONObject jSONObject, JSONObject jSONObject2, String str, long j10) {
        long jOptLong = jSONObject.has(str) ? jSONObject.optLong(str, 0L) : jSONObject2.has(str) ? jSONObject2.optLong(str, 0L) : 0L;
        return jOptLong == 0 ? j10 : jOptLong;
    }

    private String b() {
        return this.f11702j ? "adFormats" : r2.f14625c;
    }

    private b7 d(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean(f11639i1, false);
            co coVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                b7 b7Var = new b7(iOptInt, strOptString, zOptBoolean, coVarA);
                if (coVarA == null) {
                    return b7Var;
                }
                this.f11701i.c(this.f11699g, b7Var, IronSource.AD_UNIT.BANNER);
                return b7Var;
            }
        }
        return null;
    }

    private dt h(JSONObject jSONObject) {
        dt dtVar = new dt();
        JSONObject jSONObjectC = c(jSONObject, "testSuite");
        if (jSONObjectC != null) {
            dtVar.b(jSONObjectC.optString("controllerUrl"));
        }
        return dtVar;
    }

    public m8 c() {
        return this.f11695c;
    }

    public xb e() {
        return this.f11703k;
    }

    public vg f() {
        return new vg(this.f11696d, this.f11697e);
    }

    public List<IronSource.AD_UNIT> g() {
        qo qoVar;
        qo qoVar2;
        qo qoVar3;
        qo qoVar4;
        if (this.f11698f == null || this.f11695c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f11695c.f() != null && (qoVar4 = this.f11693a) != null && !qoVar4.d().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
        if (this.f11695c.d() != null && (qoVar3 = this.f11693a) != null && !qoVar3.b().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
        }
        if (this.f11695c.c() != null && (qoVar2 = this.f11693a) != null && !qoVar2.a().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.BANNER);
        }
        if (this.f11695c.e() != null && (qoVar = this.f11693a) != null && !qoVar.c().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.NATIVE_AD);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[PHI: r7
      0x0036: PHI (r7v3 com.ironsource.go) = (r7v1 com.ironsource.go), (r7v2 com.ironsource.go) binds: [B:10:0x0034, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ironsource.co a(org.json.JSONObject r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            com.ironsource.co$b r1 = new com.ironsource.co$b
            r1.<init>()
            java.lang.String r2 = "delivery"
            r3 = 1
            boolean r2 = r10.optBoolean(r2, r3)
            r1.a(r2)
            java.lang.String r2 = "capping"
            org.json.JSONObject r2 = r10.optJSONObject(r2)
            java.lang.String r4 = "enabled"
            r5 = 0
            if (r2 == 0) goto L59
            java.lang.String r6 = "unit"
            java.lang.String r6 = r2.optString(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L45
            com.ironsource.go r7 = com.ironsource.go.PER_DAY
            java.lang.String r8 = r7.toString()
            boolean r8 = r8.equals(r6)
            if (r8 == 0) goto L38
        L36:
            r0 = r7
            goto L45
        L38:
            com.ironsource.go r7 = com.ironsource.go.PER_HOUR
            java.lang.String r8 = r7.toString()
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L45
            goto L36
        L45:
            java.lang.String r6 = "maxImpressions"
            int r6 = r2.optInt(r6, r5)
            boolean r2 = r2.optBoolean(r4, r5)
            if (r2 == 0) goto L55
            if (r6 <= 0) goto L55
            r2 = r3
            goto L56
        L55:
            r2 = r5
        L56:
            r1.a(r2, r0, r6)
        L59:
            java.lang.String r0 = "pacing"
            org.json.JSONObject r10 = r10.optJSONObject(r0)
            if (r10 == 0) goto L74
            java.lang.String r0 = "numOfSeconds"
            int r0 = r10.optInt(r0, r5)
            boolean r10 = r10.optBoolean(r4, r5)
            if (r10 == 0) goto L70
            if (r0 <= 0) goto L70
            goto L71
        L70:
            r3 = r5
        L71:
            r1.a(r3, r0)
        L74:
            com.ironsource.co r10 = r1.a()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.cr.a(org.json.JSONObject):com.ironsource.co");
    }

    private JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        if (!this.f11702j) {
            return jSONObject.optJSONArray(str);
        }
        JSONObject jSONObjectC = c(jSONObject, str);
        String strA = a(str);
        if (jSONObjectC == null || strA == null) {
            return null;
        }
        return jSONObjectC.optJSONArray(strA);
    }

    @Nullable
    private JSONObject c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    @NotNull
    private JSONObject d(JSONObject jSONObject, String str) {
        JSONObject jSONObjectC = c(jSONObject, str);
        return jSONObjectC != null ? jSONObjectC : new JSONObject();
    }

    public static a a(cr crVar) {
        return crVar != null ? crVar.h() : a.NOT_SET;
    }

    private void b(@NotNull JSONObject jSONObject) {
        this.f11703k = new xb(jSONObject.optJSONObject(kq.f12887d));
    }

    private String a(String str) {
        try {
            JSONObject jSONObjectC = c(c(c(c(this.f11698f, "configurations"), "adFormats"), str), r2.f14625c);
            if (jSONObjectC == null) {
                return null;
            }
            Iterator<String> itKeys = jSONObjectC.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectC2 = c(jSONObjectC, next);
                if (jSONObjectC2 != null && jSONObjectC2.optBoolean(f11639i1)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return null;
        }
    }

    private boolean b(String str) {
        return this.f11694b.a("Mediation") && StringUtils.toLowerCase("IronSource").equals(StringUtils.toLowerCase(str));
    }

    private void a() {
        this.f11698f = new JSONObject();
        this.f11696d = "";
        this.f11697e = "";
        this.f11693a = new qo();
        this.f11694b = so.c();
        this.f11695c = new m8.a().a();
        this.f11701i = el.I().m();
        b(this.f11698f);
    }

    public void a(a aVar) {
        this.f11700h = aVar;
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z10) {
        return jSONObject.has(str) ? jSONObject.optBoolean(str, z10) : jSONObject2.has(str) ? jSONObject2.optBoolean(str, z10) : z10;
    }

    private int[] a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArrayOptJSONArray.length()];
        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
            iArr[i10] = jSONArrayOptJSONArray.optInt(i10);
        }
        return iArr;
    }
}
