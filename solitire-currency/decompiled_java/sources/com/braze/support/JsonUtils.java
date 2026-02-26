package com.braze.support;

import android.os.Bundle;
import bo.app.a40;
import bo.app.g40;
import bo.app.h40;
import bo.app.i40;
import bo.app.y30;
import bo.app.z30;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.q;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonUtils {
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("JsonUtils");

    public static final boolean areJsonObjectsEqual(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        t.h(itKeys, "target.keys()");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                return false;
            }
            Object objOpt = jSONObject.opt(next);
            Object objOpt2 = jSONObject2.opt(next);
            if ((objOpt instanceof JSONObject) && (objOpt2 instanceof JSONObject)) {
                if (!isEqualTo((JSONObject) objOpt, (JSONObject) objOpt2)) {
                    return false;
                }
            } else if (objOpt != null && objOpt2 != null && !t.d(objOpt, objOpt2)) {
                return false;
            }
        }
        return true;
    }

    public static final <T> JSONArray constructJsonArray(Collection<? extends IPutIntoJson<T>> collection) {
        t.i(collection, "<this>");
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends IPutIntoJson<T>> it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().forJsonPut());
        }
        return jSONArray;
    }

    public static final Map<String, String> convertJSONObjectToMap(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return r0.g();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        t.h(itKeys, "this.keys()");
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            t.h(key, "key");
            String string = jSONObject.getString(key);
            t.h(string, "this.getString(key)");
            linkedHashMap.put(key, string);
        }
        return linkedHashMap;
    }

    public static final List<String> convertStringJsonArrayToList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            try {
                String string = jSONArray.getString(i10);
                t.h(string, "this.getString(i)");
                arrayList.add(string);
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new y30(i10, jSONArray), 8, (Object) null);
            }
        }
        return arrayList;
    }

    public static final JSONObject deepcopy(JSONObject jSONObject) {
        t.i(jSONObject, "<this>");
        return new JSONObject(jSONObject.toString());
    }

    public static final Integer getColorIntegerOrNull(JSONObject jSONObject, String str) {
        t.i(jSONObject, "<this>");
        if (str == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return Integer.valueOf(jSONObject.getInt(str));
        } catch (Throwable th) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, th, false, (h9.a) z30.f4392a, 8, (Object) null);
            return null;
        }
    }

    public static final Double getDoubleOrNull(JSONObject jSONObject, String str) {
        t.i(jSONObject, "<this>");
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return Double.valueOf(jSONObject.optDouble(str));
    }

    public static final String getOptionalString(JSONObject jSONObject, String str) {
        t.i(jSONObject, "<this>");
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    public static final String getPrettyPrintedString(JSONObject jSONObject) throws JSONException {
        String string = "";
        if (jSONObject != null) {
            try {
                string = jSONObject.toString(2);
            } catch (Throwable th) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, th, false, (h9.a) a40.f2349a, 8, (Object) null);
            }
            t.h(string, "try {\n        this.toStr…ring.\" }\n        \"\"\n    }");
        }
        return string;
    }

    public static final boolean isEqualTo(JSONObject jSONObject, JSONObject jSONObject2) {
        return areJsonObjectsEqual(jSONObject, jSONObject2);
    }

    public static final JSONObject mergeJsonObjects(JSONObject oldJson, JSONObject newJson) {
        t.i(oldJson, "oldJson");
        t.i(newJson, "newJson");
        JSONObject jSONObject = new JSONObject();
        Iterator<String> itKeys = oldJson.keys();
        t.h(itKeys, "oldJson.keys()");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject.put(next, oldJson.get(next));
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new g40(next), 8, (Object) null);
            }
        }
        Iterator<String> itKeys2 = newJson.keys();
        t.h(itKeys2, "newJson.keys()");
        while (itKeys2.hasNext()) {
            String next2 = itKeys2.next();
            try {
                jSONObject.put(next2, newJson.get(next2));
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) new h40(next2), 8, (Object) null);
            }
        }
        return jSONObject;
    }

    public static final <TargetEnum extends Enum<TargetEnum>> TargetEnum optEnum(JSONObject jsonObject, String key, Class<TargetEnum> targetEnumClass, TargetEnum targetenum) {
        t.i(jsonObject, "jsonObject");
        t.i(key, "key");
        t.i(targetEnumClass, "targetEnumClass");
        try {
            String string = jsonObject.getString(key);
            t.h(string, "jsonObject.getString(key)");
            Locale US = Locale.US;
            t.h(US, "US");
            String enumValue = string.toUpperCase(US);
            t.h(enumValue, "this as java.lang.String).toUpperCase(locale)");
            t.i(enumValue, "enumValue");
            t.i(targetEnumClass, "targetEnumClass");
            TargetEnum targetenum2 = (TargetEnum) Enum.valueOf(targetEnumClass, enumValue);
            return targetenum2 == null ? targetenum : targetenum2;
        } catch (Exception unused) {
            return targetenum;
        }
    }

    public static final Bundle parseJsonObjectIntoBundle(String str) {
        Bundle bundle = new Bundle();
        if (str != null && !q.z(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) i40.f3019a, 8, (Object) null);
            }
        }
        return bundle;
    }

    public static final JSONObject plus(JSONObject jSONObject, JSONObject otherJson) {
        t.i(jSONObject, "<this>");
        t.i(otherJson, "otherJson");
        return mergeJsonObjects(jSONObject, otherJson);
    }

    public static final <T> JSONArray constructJsonArray(T[] tArr) {
        t.i(tArr, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (T t10 : tArr) {
            jSONArray.put(t10);
        }
        return jSONArray;
    }
}
