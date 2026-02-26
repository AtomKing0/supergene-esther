package com.ironsource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f16045a;

    public wp() {
        this.f16045a = new JSONObject();
    }

    public static Object b(Object obj) throws JSONException {
        if (!(obj instanceof Map)) {
            if (!(obj instanceof Iterable)) {
                return obj;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            return jSONArray;
        }
        JSONObject jSONObject = new JSONObject();
        Map map = (Map) obj;
        for (Object obj2 : map.keySet()) {
            if (obj2 != null) {
                jSONObject.put(obj2.toString(), b(map.get(obj2)));
            }
        }
        return jSONObject;
    }

    private void f(String str) {
        try {
            this.f16045a = new JSONObject(str);
        } catch (Exception e10) {
            i9.d().a(e10);
            this.f16045a = new JSONObject();
        }
    }

    public int a(String str, int i10) {
        return this.f16045a.optInt(str, i10);
    }

    public boolean c(String str) {
        return this.f16045a.optBoolean(str);
    }

    public String d(String str) {
        return this.f16045a.optString(str, null);
    }

    public boolean e(String str) {
        return a().isNull(str);
    }

    public String toString() {
        JSONObject jSONObject = this.f16045a;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public wp(String str) {
        f(str);
    }

    private Object a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof JSONObject ? b((JSONObject) obj) : obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public Object b(String str) {
        try {
            return a().get(str);
        } catch (JSONException e10) {
            i9.d().a(e10);
            return null;
        }
    }

    private Map<String, Object> b(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, a(jSONObject.get(next)));
        }
        return map;
    }

    public String a(String str, String str2) {
        return this.f16045a.optString(str, str2);
    }

    public List a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(a(jSONArray.get(i10)));
        }
        return arrayList;
    }

    public void b(String str, String str2) {
        try {
            this.f16045a.put(str, str2);
        } catch (Exception e10) {
            i9.d().a(e10);
        }
    }

    public JSONObject a() {
        return this.f16045a;
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            this.f16045a.put(str, jSONObject);
        } catch (Exception e10) {
            i9.d().a(e10);
        }
    }

    public boolean a(String str) {
        return a().has(str);
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject.names() == null;
    }
}
