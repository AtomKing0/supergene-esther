package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a7 extends com.applovin.impl.sdk.ad.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f4701k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f4702l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final j7 f4703m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f4704n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final n7 f4705o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final d7 f4706p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f4707q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final c7 f4708r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final y3 f4709s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Set f4710t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Set f4711u;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f4712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f4713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.applovin.impl.sdk.j f4714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f4715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f4716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f4717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private j7 f4718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private n7 f4719h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private d7 f4720i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private c7 f4721j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Set f4722k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Set f4723l;

        public b b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f4713b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }

        public b b(String str) {
            this.f4716e = str;
            return this;
        }

        public b b(Set set) {
            this.f4722k = set;
            return this;
        }

        public b a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f4712a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        public b a(com.applovin.impl.sdk.j jVar) {
            if (jVar != null) {
                this.f4714c = jVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        public b a(String str) {
            this.f4717f = str;
            return this;
        }

        public b a(j7 j7Var) {
            this.f4718g = j7Var;
            return this;
        }

        public b a(n7 n7Var) {
            this.f4719h = n7Var;
            return this;
        }

        public b a(d7 d7Var) {
            this.f4720i = d7Var;
            return this;
        }

        public b a(c7 c7Var) {
            this.f4721j = c7Var;
            return this;
        }

        public b a(Set set) {
            this.f4723l = set;
            return this;
        }

        public b a(long j10) {
            this.f4715d = j10;
            return this;
        }

        public a7 a() {
            return new a7(this);
        }
    }

    public enum c {
        COMPANION_AD,
        VIDEO
    }

    public enum d {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        INDUSTRY_ICON_IMPRESSION,
        INDUSTRY_ICON_CLICK,
        ERROR
    }

    private Set g1() {
        d7 d7Var = this.f4706p;
        return d7Var != null ? d7Var.b() : Collections.emptySet();
    }

    private String j1() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    private Set n1() {
        n7 n7Var = this.f4705o;
        return n7Var != null ? n7Var.b() : Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List t(v4 v4Var) {
        return z6.a(v4Var.a("vimp_urls", new JSONObject()), getClCode(), null, j1(), O(), R0(), this.sdk);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean D0() {
        return getBooleanFromFullResponse("is_persisted_ad", false);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public List F() {
        List listA;
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            return (List) v4Var.a(new Function() { // from class: com.applovin.impl.h8
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f5343a.t((v4) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = z6.a(getJsonObjectFromAdObject("vimp_urls", new JSONObject()), getClCode(), null, j1(), O(), R0(), this.sdk);
        }
        return listA;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean G0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE) && j() != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean H0() {
        return getBooleanFromAdObject("vast_is_streaming", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String N() {
        return this.f4707q;
    }

    public Set a(d dVar, String str) {
        return a(dVar, new String[]{str});
    }

    public void b(String str) {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.b("html_template", str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a7) || !super.equals(obj)) {
            return false;
        }
        a7 a7Var = (a7) obj;
        String str = this.f4701k;
        if (str == null ? a7Var.f4701k != null : !str.equals(a7Var.f4701k)) {
            return false;
        }
        String str2 = this.f4702l;
        if (str2 == null ? a7Var.f4702l != null : !str2.equals(a7Var.f4702l)) {
            return false;
        }
        j7 j7Var = this.f4703m;
        if (j7Var == null ? a7Var.f4703m != null : !j7Var.equals(a7Var.f4703m)) {
            return false;
        }
        n7 n7Var = this.f4705o;
        if (n7Var == null ? a7Var.f4705o != null : !n7Var.equals(a7Var.f4705o)) {
            return false;
        }
        d7 d7Var = this.f4706p;
        if (d7Var == null ? a7Var.f4706p != null : !d7Var.equals(a7Var.f4706p)) {
            return false;
        }
        c7 c7Var = this.f4708r;
        if (c7Var == null ? a7Var.f4708r != null : !c7Var.equals(a7Var.f4708r)) {
            return false;
        }
        Set set = this.f4710t;
        if (set == null ? a7Var.f4710t != null : !set.equals(a7Var.f4710t)) {
            return false;
        }
        Set set2 = this.f4711u;
        Set set3 = a7Var.f4711u;
        return set2 != null ? set2.equals(set3) : set3 == null;
    }

    public d7 f1() {
        return this.f4706p;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri g0() {
        return j();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        return this.f4704n;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    public String h1() {
        return getStringFromAdObject("html_template", "");
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        List listG;
        n7 n7Var = this.f4705o;
        return (n7Var == null || (listG = n7Var.g()) == null || listG.size() <= 0) ? false : true;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f4701k;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f4702l;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        j7 j7Var = this.f4703m;
        int iHashCode4 = (iHashCode3 + (j7Var != null ? j7Var.hashCode() : 0)) * 31;
        n7 n7Var = this.f4705o;
        int iHashCode5 = (iHashCode4 + (n7Var != null ? n7Var.hashCode() : 0)) * 31;
        d7 d7Var = this.f4706p;
        int iHashCode6 = (iHashCode5 + (d7Var != null ? d7Var.hashCode() : 0)) * 31;
        c7 c7Var = this.f4708r;
        int iHashCode7 = (iHashCode6 + (c7Var != null ? c7Var.hashCode() : 0)) * 31;
        Set set = this.f4710t;
        int iHashCode8 = (iHashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set set2 = this.f4711u;
        return iHashCode8 + (set2 != null ? set2.hashCode() : 0);
    }

    public c i1() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? c.COMPANION_AD : c.VIDEO;
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", Boolean.TRUE) && this.f4708r != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri j() {
        n7 n7Var = this.f4705o;
        if (n7Var != null) {
            return n7Var.c();
        }
        return null;
    }

    public g7 k1() {
        n7 n7Var = this.f4705o;
        if (n7Var != null) {
            return n7Var.f();
        }
        return null;
    }

    public long l1() {
        return getLongFromAdObject("real_close_delay", 0L);
    }

    public j7 m1() {
        return this.f4703m;
    }

    public n7 o1() {
        return this.f4705o;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri p0() {
        o7 o7VarP1 = p1();
        if (o7VarP1 != null) {
            return o7VarP1.e();
        }
        return null;
    }

    public o7 p1() {
        Long lF = n0.f(this.sdk);
        return this.f4705o.a(lF != null ? lF.longValue() : 0L);
    }

    public boolean q1() {
        return k1() != null;
    }

    public boolean r1() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.TRUE);
    }

    public void s1() {
        v4 v4Var = this.synchronizedAdObject;
        if (v4Var != null) {
            v4Var.c("vast_is_streaming");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    public boolean t1() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.TRUE);
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "VastAd{title='" + this.f4701k + "', adDescription='" + this.f4702l + "', systemInfo=" + this.f4703m + ", videoCreative=" + this.f4705o + ", companionAd=" + this.f4706p + ", adVerifications=" + this.f4708r + ", impressionTrackers=" + this.f4710t + ", errorTrackers=" + this.f4711u + '}';
    }

    public boolean u1() {
        return getBooleanFromAdObject("cache_video", Boolean.TRUE);
    }

    public boolean v1() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.FALSE);
    }

    public boolean w1() {
        return getBooleanFromAdObject("iopms", Boolean.FALSE);
    }

    public boolean x1() {
        return getBooleanFromAdObject("iopmsfsr", Boolean.TRUE);
    }

    private a7(b bVar) {
        super(bVar.f4712a, bVar.f4713b, bVar.f4714c);
        this.f4701k = bVar.f4716e;
        this.f4703m = bVar.f4718g;
        this.f4702l = bVar.f4717f;
        this.f4705o = bVar.f4719h;
        this.f4706p = bVar.f4720i;
        this.f4708r = bVar.f4721j;
        this.f4710t = bVar.f4722k;
        this.f4711u = bVar.f4723l;
        this.f4709s = new y3(this);
        Uri uriP0 = p0();
        if (uriP0 != null) {
            this.f4707q = uriP0.toString();
        } else {
            this.f4707q = "";
        }
        this.f4704n = bVar.f4715d;
    }

    public Set a(d dVar, String[] strArr) {
        this.sdk.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.sdk.I().a("VastAd", "Retrieving trackers of type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'...");
        }
        if (dVar == d.IMPRESSION) {
            return this.f4710t;
        }
        if (dVar == d.VIDEO_CLICK) {
            return n1();
        }
        if (dVar == d.COMPANION_CLICK) {
            return g1();
        }
        if (dVar == d.VIDEO) {
            return a(c.VIDEO, strArr);
        }
        if (dVar == d.COMPANION) {
            return a(c.COMPANION_AD, strArr);
        }
        if (dVar == d.INDUSTRY_ICON_CLICK) {
            return k1().b();
        }
        if (dVar == d.INDUSTRY_ICON_IMPRESSION) {
            return k1().f();
        }
        if (dVar == d.ERROR) {
            return this.f4711u;
        }
        this.sdk.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.sdk.I().b("VastAd", "Failed to retrieve trackers of invalid type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'");
        }
        return Collections.emptySet();
    }

    public c7 e1() {
        return this.f4708r;
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.r3
    public y3 getAdEventTracker() {
        return this.f4709s;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void J0() {
    }

    private Set a(c cVar, String[] strArr) {
        Map mapD;
        d7 d7Var;
        n7 n7Var;
        if (strArr != null && strArr.length > 0) {
            if (cVar == c.VIDEO && (n7Var = this.f4705o) != null) {
                mapD = n7Var.e();
            } else {
                mapD = (cVar != c.COMPANION_AD || (d7Var = this.f4706p) == null) ? null : d7Var.d();
            }
            HashSet hashSet = new HashSet();
            if (mapD != null && !mapD.isEmpty()) {
                for (String str : strArr) {
                    if (mapD.containsKey(str)) {
                        hashSet.addAll((Collection) mapD.get(str));
                    }
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    public static a7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "full_response", (JSONObject) null);
        if (jSONObject2 == null) {
            return null;
        }
        bVar.f4713b = jSONObject2;
        JSONObject jSONObject3 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject2, "ads", new JSONArray()), 0, (JSONObject) null);
        if (jSONObject3 == null) {
            return null;
        }
        bVar.f4712a = jSONObject3;
        bVar.f4714c = jVar;
        bVar.f4715d = JsonUtils.getLong(jSONObject, "created_at_millis", 0L);
        bVar.f4716e = JsonUtils.getString(jSONObject, "title", "");
        bVar.f4717f = JsonUtils.getString(jSONObject, "ad_description", "");
        bVar.f4718g = j7.a(JsonUtils.getJSONObject(jSONObject, "system_info", (JSONObject) null), jVar);
        bVar.f4719h = n7.a(JsonUtils.getJSONObject(jSONObject, "video_creative", (JSONObject) null), jVar);
        bVar.f4720i = d7.a(JsonUtils.getJSONObject(jSONObject, "companion_ad", (JSONObject) null), jVar);
        bVar.f4721j = c7.a(JsonUtils.getJSONObject(jSONObject, "ad_verifications", (JSONObject) null), jVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "impression_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            k7 k7VarA = k7.a(JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null), jVar);
            if (k7VarA != null) {
                hashSet.add(k7VarA);
            }
        }
        bVar.f4722k = hashSet;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "error_trackers", new JSONArray());
        HashSet hashSet2 = new HashSet();
        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
            k7 k7VarA2 = k7.a(JsonUtils.getJSONObject(jSONArray2, i11, (JSONObject) null), jVar);
            if (k7VarA2 != null) {
                hashSet2.add(k7VarA2);
            }
        }
        bVar.f4723l = hashSet2;
        a7 a7Var = new a7(bVar);
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray());
        for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
            Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray3, i12, null);
            if (objectAtIndex instanceof String) {
                String str = (String) objectAtIndex;
                if (!TextUtils.isEmpty(str)) {
                    a7Var.a(Uri.parse(str));
                }
            }
        }
        return a7Var;
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "created_at_millis", this.f4704n);
        JsonUtils.putString(jSONObject, "title", this.f4701k);
        JsonUtils.putString(jSONObject, "ad_description", this.f4702l);
        j7 j7Var = this.f4703m;
        if (j7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "system_info", j7Var.a());
        }
        n7 n7Var = this.f4705o;
        if (n7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "video_creative", n7Var.a());
        }
        d7 d7Var = this.f4706p;
        if (d7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "companion_ad", d7Var.a());
        }
        c7 c7Var = this.f4708r;
        if (c7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "ad_verifications", c7Var.a());
        }
        if (this.f4710t != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f4710t.iterator();
            while (it.hasNext()) {
                jSONArray.put(((k7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "impression_trackers", jSONArray);
        }
        if (this.f4711u != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.f4711u.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((k7) it2.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "error_trackers", jSONArray2);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it3 = i().iterator();
        while (it3.hasNext()) {
            arrayList.add(((Uri) it3.next()).toString());
        }
        JsonUtils.putJsonArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray((Collection) arrayList));
        v4 v4Var = this.synchronizedFullResponse;
        if (v4Var != null) {
            JsonUtils.putJSONObject(jSONObject, "full_response", v4Var.a());
        } else {
            synchronized (this.fullResponseLock) {
                JsonUtils.putJSONObject(jSONObject, "full_response", this.fullResponse);
            }
        }
        return jSONObject;
    }
}
