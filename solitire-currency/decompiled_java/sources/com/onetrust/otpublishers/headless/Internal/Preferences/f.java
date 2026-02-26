package com.onetrust.otpublishers.headless.Internal.Preferences;

import androidx.annotation.NonNull;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    @NonNull
    public static String a(@NonNull e eVar) {
        JSONObject jSONObject;
        String string;
        String string2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            string2 = eVar.c().getString("OT_API_FETCH_STATUS_DATA", "");
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while getting status data json, err: "), "OneTrust", 6);
        }
        JSONObject jSONObject3 = !com.onetrust.otpublishers.headless.Internal.c.q(string2) ? new JSONObject(string2) : new JSONObject();
        String string3 = eVar.c().getString("OTT_DOMAIN_DATA", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string3)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(string3);
            } catch (JSONException e11) {
                p.a(e11, new StringBuilder("error while returning domain data, err: "), "OneTrust", 6);
                jSONObject = new JSONObject();
            }
        }
        try {
            string = eVar.c().getString("OT_CULTURE_DATA", "");
        } catch (JSONException e12) {
            p.a(e12, new StringBuilder("Error while getting culture data json on getCultureData, err: "), "OneTrust", 6);
        }
        JSONObject jSONObject4 = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : new JSONObject();
        try {
            jSONObject2.put("status", jSONObject3);
        } catch (JSONException e13) {
            p.a(e13, new StringBuilder("Exception thrown while constructing ott data, err : "), "OTSharedPreferenceHelper", 3);
        }
        try {
            jSONObject2.put(v8.i.D, jSONObject);
        } catch (JSONException e14) {
            p.a(e14, new StringBuilder("Exception thrown while constructing ott data, err : "), "OTSharedPreferenceHelper", 3);
        }
        try {
            jSONObject2.put("culture", jSONObject4);
        } catch (JSONException e15) {
            p.a(e15, new StringBuilder("Exception thrown while constructing ott data, err : "), "OTSharedPreferenceHelper", 3);
        }
        return jSONObject2.toString();
    }
}
