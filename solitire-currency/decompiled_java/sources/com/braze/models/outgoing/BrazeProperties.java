package com.braze.models.outgoing;

import bo.app.bg;
import bo.app.cg;
import bo.app.dg;
import bo.app.eg;
import bo.app.hg;
import com.braze.enums.BrazeDateFormat;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.braze.support.ValidationUtils;
import h9.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeProperties implements IPutIntoJson<JSONObject> {
    public static final bg Companion = new bg();
    private JSONObject propertiesJSONObject;

    public BrazeProperties() {
        this.propertiesJSONObject = new JSONObject();
    }

    private final JSONObject clean(JSONObject jSONObject, boolean z10) throws JSONException {
        ArrayList<String> arrayList = new ArrayList();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            t.h(next, "jsonObjectIterator.next()");
            arrayList.add(next);
        }
        for (String str : arrayList) {
            if (!z10 || Companion.a(str)) {
                Object obj = jSONObject.get(str);
                if (obj instanceof Date) {
                    jSONObject.put(str, DateTimeUtils.formatDate$default((Date) obj, BrazeDateFormat.LONG, null, 2, null));
                }
                if (obj instanceof JSONArray) {
                    jSONObject.put(str, hg.a((JSONArray) obj));
                }
                if (obj instanceof JSONObject) {
                    jSONObject.put(str, clean((JSONObject) obj, false));
                }
            } else {
                jSONObject.remove(str);
            }
        }
        return jSONObject;
    }

    public static /* synthetic */ JSONObject clean$default(BrazeProperties brazeProperties, JSONObject jSONObject, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return brazeProperties.clean(jSONObject, z10);
    }

    public final BrazeProperties addProperty(String key, Object obj) {
        t.i(key, "key");
        if (!Companion.a(key)) {
            return this;
        }
        try {
            if (obj instanceof Long) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), ((Number) obj).intValue());
            } else if (obj instanceof Double) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), ((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), ((Boolean) obj).booleanValue());
            } else if (obj instanceof Date) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), DateTimeUtils.formatDate$default((Date) obj, BrazeDateFormat.LONG, null, 2, null));
            } else if (obj instanceof String) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), ValidationUtils.ensureBrazeFieldLength((String) obj));
            } else if (obj instanceof JSONArray) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), hg.a((JSONArray) obj));
            } else if (obj instanceof JSONObject) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), clean$default(this, (JSONObject) obj, false, 2, null));
            } else if (obj instanceof Map) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), clean$default(this, new JSONObject(hg.a((Map) obj)), false, 2, null));
            } else if (obj == null) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(key), JSONObject.NULL);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new cg(key), 6, (Object) null);
            }
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) dg.f2651a, 4, (Object) null);
        }
        return this;
    }

    public final BrazeProperties clone() {
        try {
            return new BrazeProperties(new JSONObject(forJsonPut().toString()));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (a) eg.f2732a, 4, (Object) null);
            return null;
        }
    }

    public final long getByteSize() {
        String string = this.propertiesJSONObject.toString();
        t.h(string, "propertiesJSONObject.toString()");
        return StringUtils.getByteSize(string);
    }

    public final int getSize() {
        return this.propertiesJSONObject.length();
    }

    public final boolean isInvalid() {
        return getByteSize() > 51200;
    }

    @Override // com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        return this.propertiesJSONObject;
    }

    public BrazeProperties(JSONObject jsonObject) {
        t.i(jsonObject, "jsonObject");
        this.propertiesJSONObject = new JSONObject();
        this.propertiesJSONObject = clean$default(this, jsonObject, false, 2, null);
    }
}
