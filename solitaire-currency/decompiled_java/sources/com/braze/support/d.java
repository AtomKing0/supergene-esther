package com.braze.support;

import bo.app.nn;
import bo.app.on;
import bo.app.pn;
import bo.app.qn;
import bo.app.rn;
import bo.app.sn;
import bo.app.tn;
import bo.app.un;
import bo.app.vn;
import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.q;
import p9.r;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8115a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f8116b = v.n("$add", "$remove", "$update", "$identifier_key", "$identifier_value", "$new_object");

    public static final boolean a(String str, Set blocklistedAttributes) {
        t.i(blocklistedAttributes, "blocklistedAttributes");
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f8115a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) un.f4032a, 6, (Object) null);
            return false;
        }
        if (!blocklistedAttributes.contains(str)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f8115a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new vn(str), 6, (Object) null);
        return false;
    }

    public final Object a(Object value, int i10) {
        Object date$default;
        d dVar;
        t.i(value, "value");
        if ((value instanceof Boolean) || (value instanceof Integer) || (value instanceof Float) || (value instanceof Long) || (value instanceof Double)) {
            return value;
        }
        if (value instanceof String) {
            date$default = ValidationUtils.ensureBrazeFieldLength((String) value);
        } else {
            int i11 = 2;
            if (value instanceof Date) {
                try {
                    date$default = DateTimeUtils.formatDate$default((Date) value, BrazeDateFormat.LONG, null, 2, null);
                } catch (Exception e10) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new nn(value), 4, (Object) null);
                }
            } else {
                if (value instanceof JSONObject) {
                    if (i10 == 0 && value.toString().length() > 76800) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new on(value), 6, (Object) null);
                    } else {
                        JSONObject jSONObject = (JSONObject) value;
                        int i12 = i10 + 1;
                        if (i12 > 50) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) sn.f3870a, 7, (Object) null);
                        } else {
                            JSONObject jSONObject2 = new JSONObject();
                            Iterator<String> itKeys = jSONObject.keys();
                            t.h(itKeys, "json.keys()");
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                String strEnsureBrazeFieldLength = ValidationUtils.ensureBrazeFieldLength(next);
                                d dVar2 = f8115a;
                                if (((q.z(strEnsureBrazeFieldLength) | r.P(strEnsureBrazeFieldLength, "$", false, i11, null)) || r.P(strEnsureBrazeFieldLength, ".", false, i11, null)) && (!f8116b.contains(strEnsureBrazeFieldLength))) {
                                    dVar = dVar2;
                                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) dVar2, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new tn(next), 6, (Object) null);
                                } else {
                                    dVar = dVar2;
                                }
                                if (!q.z(strEnsureBrazeFieldLength)) {
                                    if (jSONObject.isNull(next)) {
                                        jSONObject2.put(next, JSONObject.NULL);
                                    } else {
                                        Object obj = jSONObject.get(next);
                                        t.h(obj, "json.get(key)");
                                        Object objA = dVar.a(obj, i12);
                                        if (objA != null) {
                                            jSONObject2.put(strEnsureBrazeFieldLength, objA);
                                        }
                                    }
                                }
                                i11 = 2;
                            }
                            date$default = jSONObject2;
                        }
                    }
                } else if (value instanceof JSONArray) {
                    if (i10 == 0 && value.toString().length() > 76800) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new pn(value), 6, (Object) null);
                    } else {
                        JSONArray jSONArray = (JSONArray) value;
                        int i13 = i10 + 1;
                        if (i13 > 50) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) rn.f3797a, 7, (Object) null);
                        } else {
                            JSONArray jSONArray2 = new JSONArray();
                            int length = jSONArray.length();
                            for (int i14 = 0; i14 < length; i14++) {
                                Object obj2 = jSONArray.get(i14);
                                t.h(obj2, "jsonArray.get(i)");
                                Object objA2 = a(obj2, i13);
                                if (objA2 == null) {
                                    return null;
                                }
                                jSONArray2.put(objA2);
                            }
                            return jSONArray2;
                        }
                    }
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new qn(value), 6, (Object) null);
                    return null;
                }
                return null;
            }
        }
        return date$default;
    }
}
