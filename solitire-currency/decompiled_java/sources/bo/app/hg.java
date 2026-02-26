package bo.app;

import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v8.s;

/* JADX INFO: loaded from: classes2.dex */
public abstract class hg {
    public static final JSONArray a(JSONArray jSONArray) throws JSONException {
        kotlin.jvm.internal.t.i(jSONArray, "<this>");
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = jSONArray.get(i10);
            if (obj instanceof Date) {
                jSONArray2.put(DateTimeUtils.formatDate$default((Date) obj, BrazeDateFormat.LONG, null, 2, null));
            } else if (obj instanceof JSONArray) {
                jSONArray2.put(a((JSONArray) obj));
            } else if (obj instanceof Map) {
                jSONArray2.put(a((Map) obj));
            } else {
                jSONArray2.put(obj);
            }
        }
        return jSONArray2;
    }

    public static final LinkedHashMap a(Map map) throws JSONException {
        kotlin.jvm.internal.t.i(map, "<this>");
        Set setKeySet = map.keySet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof String) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        List list = (List) new s(arrayList, arrayList2).b();
        if (!list.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) map, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new gg(list), 6, (Object) null);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() instanceof String) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object value = entry2.getValue();
            if ((value instanceof Date) || (value instanceof Map) || (value instanceof Long) || (value instanceof Integer) || (value instanceof Double) || (value instanceof Boolean) || (value instanceof String) || (value instanceof JSONObject) || (value instanceof JSONArray) || value == null) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(kotlin.collections.q0.d(linkedHashMap2.size()));
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            Object key = entry3.getKey();
            Object value2 = entry3.getValue();
            if (value2 instanceof Date) {
                value2 = DateTimeUtils.formatDate$default((Date) value2, BrazeDateFormat.LONG, null, 2, null);
            } else if (value2 instanceof JSONArray) {
                value2 = a((JSONArray) value2);
            } else if (value2 instanceof Map) {
                value2 = a((Map) value2);
            }
            linkedHashMap3.put(key, value2);
        }
        return linkedHashMap3;
    }
}
