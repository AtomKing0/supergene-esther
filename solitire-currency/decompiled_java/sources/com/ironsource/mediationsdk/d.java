package com.ironsource.mediationsdk;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.ironsource.ad;
import com.ironsource.ce;
import com.ironsource.el;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.f5;
import com.ironsource.hj;
import com.ironsource.i9;
import com.ironsource.kb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.o4;
import com.ironsource.q2;
import com.ironsource.rp;
import com.ironsource.u4;
import com.ironsource.y4;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static d A = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13322c = "auctionId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13323d = "armData";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13324e = "isAdUnitCapped";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13325f = "settings";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13326g = "waterfall";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13327h = "genericParams";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13328i = "configurations";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13329j = "instances";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13330k = "${AUCTION_LOSS}";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13331l = "${AUCTION_MBR}";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13332m = "${AUCTION_PRICE}";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13333n = "${DYNAMIC_DEMAND_SOURCE}";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13334o = "${INSTANCE}";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f13335p = "${INSTANCE_TYPE}";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f13336q = "${PLACEMENT_NAME}";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f13337r = "adMarkup";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f13338s = "dynamicDemandSource";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f13339t = "params";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f13340u = "dlpl";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f13341v = "adUnit";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f13342w = "parallelLoad";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f13343x = "bidderExclusive";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f13344y = "showPriorityEnabled";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final boolean f13345z = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f13346a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ce f13347b = el.N().f();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<f5> f13349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f5 f13350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONObject f13351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private JSONObject f13352e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f13353f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f13354g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private o4 f13355h;

        public a(String str) {
            this.f13348a = str;
        }

        public JSONObject b() {
            return this.f13352e;
        }

        public int c() {
            return this.f13353f;
        }

        public String d() {
            return this.f13354g;
        }

        public f5 e() {
            return this.f13350c;
        }

        public JSONObject f() {
            return this.f13351d;
        }

        public o4 g() {
            return this.f13355h;
        }

        public List<f5> h() {
            return this.f13349b;
        }

        public com.ironsource.mediationsdk.demandOnly.p a(String str) {
            o4 o4Var = this.f13355h;
            return o4Var != null ? o4Var.a(str) : new p.b();
        }

        public String a() {
            return this.f13348a;
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f13356d = 15000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f13358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f13359c;

        public b(String str, String str2, String str3) {
            this.f13357a = str;
            this.f13358b = str2;
            this.f13359c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f13357a + ";" + this.f13358b + ";" + this.f13359c;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f13359c).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(f13356d);
                httpURLConnection.setConnectTimeout(f13356d);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                httpURLConnection.disconnect();
                if (responseCode == 200 || responseCode == 204) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
                jSONObject.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, str);
                jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, responseCode);
                jSONObject.put("reason", responseMessage);
                rp.i().a(new kb(IronSourceConstants.TROUBLESHOOTING_FAILED_TO_SEND_AUCTION_URL, jSONObject));
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error("Send auction url failed with params - " + str + ";" + e10.getMessage());
            }
        }
    }

    private enum c {
        NOT_SECURE,
        SECURE
    }

    public static d b() {
        return A;
    }

    public a a(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString("auctionId");
        if (TextUtils.isEmpty(strOptString)) {
            throw new JSONException("Invalid auction response - auction id is missing");
        }
        a aVar = new a(strOptString);
        if (jSONObject.has("settings")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
            aVar.f13350c = new f5(jSONObject2);
            jSONObjectOptJSONObject = jSONObject2.has(f13323d) ? jSONObject2.optJSONObject(f13323d) : null;
            if (jSONObject2.has("genericParams")) {
                aVar.f13351d = jSONObject2.optJSONObject("genericParams");
            }
            if (jSONObject2.has("configurations")) {
                aVar.f13352e = jSONObject2.optJSONObject("configurations");
            }
            if (jSONObject2.has(f13329j)) {
                aVar.f13355h = new o4.a(jSONObject2.optJSONObject(f13329j));
            }
        }
        aVar.f13349b = new ArrayList();
        if (jSONObject.has(f13326g)) {
            JSONArray jSONArray = jSONObject.getJSONArray(f13326g);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                f5 f5Var = new f5(jSONArray.getJSONObject(i10), i10, jSONObjectOptJSONObject);
                if (!f5Var.l()) {
                    aVar.f13353f = 1002;
                    aVar.f13354g = "waterfall " + i10;
                    IronLog.INTERNAL.verbose("AuctionResponseItem " + i10 + " not valid - parsing error");
                    throw new JSONException("invalid response");
                }
                aVar.f13349b.add(f5Var);
            }
        }
        return aVar;
    }

    public String c(String str) {
        String string = "";
        try {
            if (TextUtils.isEmpty(str) || !hj.a(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("params")) {
                return "";
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("parameters = " + jSONObject2);
            if (!jSONObject2.has("dynamicDemandSource")) {
                return "";
            }
            string = jSONObject2.getString("dynamicDemandSource");
            ironLog.verbose("demand source = " + string);
            return string;
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("exception " + e10.getMessage());
            return string;
        }
    }

    private c a() {
        c cVar = c.SECURE;
        if (Build.VERSION.SDK_INT < 28) {
            if (!((ContextProvider.getInstance().getApplicationContext().getApplicationInfo().flags & C.BUFFER_FLAG_FIRST_SAMPLE) != 0)) {
                return cVar;
            }
        } else if (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
            return cVar;
        }
        return c.NOT_SECURE;
    }

    public Map<String, String> b(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        map.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("exception " + e10.getMessage());
        }
        return map;
    }

    public String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("adMarkup") ? jSONObject.getString("adMarkup") : str;
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("exception " + e10.getMessage());
            return str;
        }
    }

    public String a(String str, int i10, f5 f5Var, String str2, String str3, String str4) {
        String strH = f5Var.h();
        return a(str, f5Var.c(), i10, b().c(f5Var.j()), strH, b().a(strH, str2), str3, str4);
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        double d10 = Double.parseDouble(str);
        return Double.parseDouble(str2) == 0.0d ? "" : String.valueOf(Math.round((d10 / r7) * 1000.0d) / 1000.0d);
    }

    public String a(String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7) {
        return str.replace(f13332m, str4).replace(f13330k, str6).replace(f13331l, str5).replace(f13334o, str2).replace(f13335p, Integer.toString(i10)).replace(f13333n, str3).replace(f13336q, str7);
    }

    JSONObject a(i iVar) throws JSONException {
        boolean z10;
        boolean z11;
        ISBannerSize iSBannerSize;
        IronSource.AD_UNIT ad_unitC = iVar.c();
        boolean zS = iVar.s();
        Map<String, Object> mapG = iVar.g();
        List<String> listK = iVar.k();
        h hVarE = iVar.e();
        int iN = iVar.n();
        ISBannerSize iSBannerSizeF = iVar.f();
        IronSourceSegment ironSourceSegmentM = iVar.m();
        boolean zO = iVar.o();
        boolean zP = iVar.p();
        ArrayList<y4> arrayListJ = iVar.j();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> it = mapG.keySet().iterator();
        while (true) {
            z10 = zO;
            z11 = zS;
            String strA = "";
            iSBannerSize = iSBannerSizeF;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            Iterator<String> it2 = it;
            JSONObject jSONObject3 = new JSONObject();
            IronSourceSegment ironSourceSegment = ironSourceSegmentM;
            jSONObject3.put(ad.f11255n0, 2);
            jSONObject3.put(ad.f11231e0, new JSONObject((Map) mapG.get(next)));
            if (hVarE != null) {
                strA = hVarE.a(next);
            }
            jSONObject3.put(ad.f11261q0, strA);
            jSONObject3.put("ts", zP ? 1 : 0);
            jSONObject2.put(next, jSONObject3);
            zO = z10;
            zS = z11 ? 1 : 0;
            iSBannerSizeF = iSBannerSize;
            it = it2;
            ironSourceSegmentM = ironSourceSegment;
        }
        IronSourceSegment ironSourceSegment2 = ironSourceSegmentM;
        int i10 = 2;
        for (String str : listK) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(ad.f11255n0, 1);
            jSONObject4.put(ad.f11261q0, hVarE != null ? hVarE.a(str) : "");
            jSONObject2.put(str, jSONObject4);
        }
        for (y4 y4Var : arrayListJ) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(ad.f11255n0, y4Var.e() ? i10 : 1);
            Map<String, Object> mapF = y4Var.f();
            if (!mapF.isEmpty()) {
                jSONObject5.put(ad.f11231e0, new JSONObject(mapF));
            }
            jSONObject5.put(ad.f11261q0, hVarE != null ? hVarE.a(y4Var.g()) : "");
            jSONObject5.put("ts", zP ? 1 : 0);
            if (!y4Var.h().isEmpty()) {
                jSONObject5.put(f13340u, y4Var.h());
            }
            jSONObject2.put(y4Var.g(), jSONObject5);
            i10 = 2;
        }
        jSONObject.put(ad.f11253m0, jSONObject2);
        if (iVar.u()) {
            jSONObject.put(ad.f11235f1, 1);
        }
        if (iVar.r()) {
            jSONObject.put(ad.f11232e1, 1);
        }
        JSONObject jSONObjectA = new u4(q2.a(ad_unitC)).a();
        a(jSONObjectA, false);
        jSONObjectA.put(ad.f11257o0, iN);
        jSONObjectA.put(ad.f11259p0, a().ordinal());
        if (ironSourceSegment2 != null) {
            jSONObjectA.put(ad.R0, ironSourceSegment2.toJson());
        }
        jSONObject.put(ad.f11246j0, jSONObjectA);
        if (iSBannerSize != null) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(ad.f11237g0, iSBannerSize.getDescription());
            jSONObject6.put(ad.f11243i0, iSBannerSize.getWidth());
            jSONObject6.put(ad.f11240h0, iSBannerSize.getHeight());
            jSONObject.put(ad.f11234f0, jSONObject6);
        }
        jSONObject.put(ad.f11219a0, ad_unitC.toString());
        if (iVar.b() != null) {
            jSONObject.put("adf", iVar.b());
        }
        if (iVar.d() != null) {
            jSONObject.put("mediationAdUnitId", iVar.d());
        }
        if (iVar.t() != null) {
            jSONObject.put(ad.f11228d0, iVar.t());
        }
        jSONObject.put(ad.f11249k0, !z11 ? 1 : 0);
        Object objRemove = jSONObjectA.remove(ad.f11223b1);
        if (objRemove != null) {
            jSONObject.put(ad.f11223b1, objRemove);
        }
        if (z10) {
            jSONObject.put(ad.Z0, 1);
        }
        return jSONObject;
    }

    public void a(String str, String str2, String str3) {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b(str, str2, str3));
    }

    public void a(JSONObject jSONObject, boolean z10) {
        if (jSONObject == null || jSONObject.length() <= 0 || TextUtils.isEmpty(jSONObject.optString(ad.T0)) || !this.f13346a.compareAndSet(false, true)) {
            return;
        }
        rp.i().a(new kb(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED, IronSourceUtils.getMediationAdditionalData(z10, true, -1)));
    }
}
