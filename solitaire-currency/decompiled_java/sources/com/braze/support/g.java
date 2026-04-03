package com.braze.support;

import bo.app.nz;
import bo.app.oz;
import bo.app.pz;
import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f8119a = new g();

    public static final ArrayList a(JSONArray geofenceJson) {
        t.i(geofenceJson, "geofenceJson");
        ArrayList arrayList = new ArrayList();
        int length = geofenceJson.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = geofenceJson.optJSONObject(i10);
            if (jSONObjectOptJSONObject == null) {
                try {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f8119a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) nz.f3529a, 6, (Object) null);
                } catch (JSONException e10) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f8119a, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new oz(jSONObjectOptJSONObject), 4, (Object) null);
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f8119a, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) new pz(jSONObjectOptJSONObject), 4, (Object) null);
                }
            } else {
                arrayList.add(new BrazeGeofence(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }
}
