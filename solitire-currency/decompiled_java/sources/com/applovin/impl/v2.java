package com.applovin.impl;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v2 implements Comparable, AppLovinCommunicatorSubscriber {
    private final List A;
    private final List B;
    private final List C;
    private final List D;
    private final Map E;
    private final boolean F;
    private final boolean G;
    private final n6 H;
    private final boolean I;
    private final String J;
    private final Map K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f7576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f7578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f7579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f7580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f7581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f7583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f7584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f7585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f7586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f7587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f7588n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f7589o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f7590p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f7591q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f7592r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f7593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f7594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f7595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f7596v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f7597w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f7598x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f7599y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f7600z;

    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7606a;

        a(String str) {
            this.f7606a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f7606a;
        }
    }

    public enum b {
        NOT_SUPPORTED("Not Supported", SupportMenu.CATEGORY_MASK, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", SupportMenu.CATEGORY_MASK, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", SupportMenu.CATEGORY_MASK, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f7614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f7615c;

        b(String str, int i10, String str2) {
            this.f7613a = str;
            this.f7614b = i10;
            this.f7615c = str2;
        }

        public String b() {
            return this.f7615c;
        }

        public String c() {
            return this.f7613a;
        }

        public int d() {
            return this.f7614b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x025f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public v2(org.json.JSONObject r22, com.applovin.impl.sdk.j r23) {
        /*
            Method dump skipped, instruction units count: 819
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.v2.<init>(org.json.JSONObject, com.applovin.impl.sdk.j):void");
    }

    private a a() {
        a aVar = this.f7578d ? this.f7579e ? a.COMPLETE : this.f7581g ? a.MISSING : a.INCOMPLETE_INTEGRATION : this.f7579e ? a.INCOMPLETE_INTEGRATION : a.MISSING;
        if (aVar == a.MISSING) {
            return aVar;
        }
        Iterator it = this.f7600z.iterator();
        while (it.hasNext()) {
            if (!((c4) it.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        Iterator it2 = this.A.iterator();
        while (it2.hasNext()) {
            if (!((d1) it2.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        return (!this.f7589o || com.applovin.impl.sdk.j.y0()) ? F() ? a.INCOMPLETE_INTEGRATION : aVar : a.INVALID_INTEGRATION;
    }

    public boolean A() {
        return this.f7579e;
    }

    public boolean B() {
        return this.f7580f;
    }

    public boolean C() {
        return this.f7582h;
    }

    public boolean D() {
        return this.I;
    }

    public boolean E() {
        return this.f7589o;
    }

    public boolean F() {
        if (!this.f7588n || !StringUtils.isValidString(this.f7593s)) {
            return false;
        }
        return !z6.d(this.f7593s).equals(z6.a(this.f7594t, this.f7593s.split("\\.").length));
    }

    public boolean G() {
        return this.f7578d;
    }

    public boolean H() {
        return this.f7576b == a.MISSING && this.f7585k;
    }

    public boolean I() {
        return this.G;
    }

    public boolean J() {
        return this.f7586l;
    }

    public boolean K() {
        return this.f7587m;
    }

    public String b() {
        return this.f7592r;
    }

    public String c() {
        return this.f7594t;
    }

    public Map d() {
        return this.K;
    }

    public String e() {
        return this.J;
    }

    public List f() {
        return this.A;
    }

    public String g() {
        return this.f7591q;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public int h() {
        return this.f7598x;
    }

    public int i() {
        return this.f7577c;
    }

    public final String j() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------- ");
        sb.append(this.f7590p);
        sb.append(" ----------");
        sb.append("\nStatus  - ");
        sb.append(this.f7576b.b());
        sb.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb.append((!this.f7578d || TextUtils.isEmpty(this.f7593s)) ? "UNAVAILABLE" : this.f7593s);
        sb.append("\nAdapter - ");
        if (this.f7579e && !TextUtils.isEmpty(this.f7594t)) {
            str = this.f7594t;
        }
        sb.append(str);
        for (c4 c4Var : n()) {
            if (!c4Var.c()) {
                sb.append("\n* MISSING ");
                sb.append(c4Var.b());
                sb.append(": ");
                sb.append(c4Var.a());
            }
        }
        for (d1 d1Var : f()) {
            if (!d1Var.c()) {
                sb.append("\n* MISSING ");
                sb.append(d1Var.b());
                sb.append(": ");
                sb.append(d1Var.a());
            }
        }
        return sb.toString();
    }

    public String k() {
        return this.f7595u;
    }

    public List l() {
        return this.C;
    }

    public String m() {
        return this.f7590p;
    }

    public List n() {
        return this.f7600z;
    }

    public final com.applovin.impl.sdk.j o() {
        return this.f7575a;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.f7592r.equals(string)) {
            this.f7577c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter maxAdapterA = l3.a(string, this.f7575a);
            if (maxAdapterA != null) {
                String strA = l3.a(maxAdapterA);
                if (this.f7593s.equals(strA)) {
                    return;
                }
                this.f7593s = strA;
                this.f7575a.r().a(this.f7593s, string);
            }
        }
    }

    public String p() {
        return this.f7593s;
    }

    public a q() {
        return this.f7576b;
    }

    public List r() {
        return this.f7599y;
    }

    public List s() {
        return this.B;
    }

    public n6 t() {
        return this.H;
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.f7590p + ", displayName=" + this.f7591q + ", sdkAvailable=" + this.f7578d + ", sdkVersion=" + this.f7593s + ", adapterAvailable=" + this.f7579e + ", adapterVersion=" + this.f7594t + "}";
    }

    public List u() {
        return this.D;
    }

    public String v() {
        return this.f7596v;
    }

    public String w() {
        return this.f7597w;
    }

    public Map x() {
        return this.E;
    }

    public b y() {
        if (!this.f7583i) {
            return b.NOT_SUPPORTED;
        }
        a aVar = this.f7576b;
        return (aVar == a.COMPLETE || (aVar == a.INCOMPLETE_INTEGRATION && G() && A())) ? !this.f7575a.l0().c() ? b.DISABLED : (this.f7584j && (this.f7577c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.f7577c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? b.NOT_INITIALIZED : b.READY : b.INVALID_INTEGRATION;
    }

    public boolean z() {
        return this.F;
    }

    private List a(MaxAdapter maxAdapter, boolean z10) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAppOpenAdapter) {
            arrayList.add(MaxAdFormat.APP_OPEN);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            if (z10) {
                arrayList.add(MaxAdFormat.MREC);
            }
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f7592r.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            c4 c4Var = new c4("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", com.applovin.impl.sdk.j.n());
            if (c4Var.c()) {
                arrayList.add(c4Var);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, App.JsonKeys.APP_PERMISSIONS, new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                arrayList.add(new c4(next, jSONObject2.getString(next), com.applovin.impl.sdk.j.n()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", null), null);
    }

    private List a(JSONObject jSONObject, String str, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new d1(jSONObject2, jVar));
            }
        }
        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i11, (JSONObject) null);
            if (jSONObject3 != null && d1.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", null), JsonUtils.getString(jSONObject3, "max_adapter_version", null))) {
                arrayList.add(new d1(jSONObject3, jVar));
            }
        }
        return arrayList;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(v2 v2Var) {
        return this.f7591q.compareToIgnoreCase(v2Var.f7591q);
    }
}
