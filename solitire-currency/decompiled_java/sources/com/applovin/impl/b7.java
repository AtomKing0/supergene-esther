package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import io.sentry.protocol.Gpu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b7 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f4907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f4909d;

    private b7(String str, List list, String str2, Set set) {
        this.f4906a = str;
        this.f4907b = list;
        this.f4908c = str2;
        this.f4909d = set;
    }

    public static b7 a(b8 b8Var, e7 e7Var, com.applovin.impl.sdk.j jVar) {
        try {
            String str = (String) b8Var.a().get(OTUXParamsKeys.OT_UX_VENDOR);
            b8 b8VarB = b8Var.b("VerificationParameters");
            String strD = b8VarB != null ? b8VarB.d() : null;
            List listA = b8Var.a("JavaScriptResource");
            ArrayList arrayList = new ArrayList(listA.size());
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                h7 h7VarA = h7.a((b8) it.next(), jVar);
                if (h7VarA != null) {
                    arrayList.add(h7VarA);
                }
            }
            HashMap map = new HashMap();
            m7.a(b8Var, map, e7Var, jVar);
            return new b7(str, arrayList, strD, (Set) map.get("verificationNotExecuted"));
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastAdVerification", "Error occurred while initializing", th);
            }
            jVar.A().a("VastAdVerification", th);
            return null;
        }
    }

    public Set b() {
        return this.f4909d;
    }

    public List c() {
        return this.f4907b;
    }

    public String d() {
        return this.f4906a;
    }

    public String e() {
        return this.f4908c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b7 b7Var = (b7) obj;
        String str = this.f4906a;
        if (str == null ? b7Var.f4906a != null : !str.equals(b7Var.f4906a)) {
            return false;
        }
        List list = this.f4907b;
        if (list == null ? b7Var.f4907b != null : !list.equals(b7Var.f4907b)) {
            return false;
        }
        String str2 = this.f4908c;
        if (str2 == null ? b7Var.f4908c != null : !str2.equals(b7Var.f4908c)) {
            return false;
        }
        Set set = this.f4909d;
        Set set2 = b7Var.f4909d;
        return set != null ? set.equals(set2) : set2 == null;
    }

    public int hashCode() {
        String str = this.f4906a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.f4907b;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f4908c;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set set = this.f4909d;
        return iHashCode3 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.f4906a + "'javascriptResources='" + this.f4907b + "'verificationParameters='" + this.f4908c + "'errorEventTrackers='" + this.f4909d + "'}";
    }

    public static b7 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, Gpu.JsonKeys.VENDOR_ID, null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "javascript_resources", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            h7 h7VarA = h7.a(JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null), jVar);
            if (h7VarA != null) {
                arrayList.add(h7VarA);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "verification_parameters", null);
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "error_event_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
            k7 k7VarA = k7.a(JsonUtils.getJSONObject(jSONArray2, i11, (JSONObject) null), jVar);
            if (k7VarA != null) {
                hashSet.add(k7VarA);
            }
        }
        return new b7(string, arrayList, string2, hashSet);
    }

    @Override // com.applovin.impl.d4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, Gpu.JsonKeys.VENDOR_ID, this.f4906a);
        if (this.f4907b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f4907b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((h7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "javascript_resources", jSONArray);
        }
        JsonUtils.putString(jSONObject, "verification_parameters", this.f4908c);
        if (this.f4909d != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.f4909d.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((k7) it2.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "error_event_trackers", jSONArray2);
        }
        return jSONObject;
    }
}
