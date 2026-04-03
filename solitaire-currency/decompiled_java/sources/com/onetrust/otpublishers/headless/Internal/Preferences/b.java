package com.onetrust.otpublishers.headless.Internal.Preferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Helper.x;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f21886a;

    public b(e eVar) {
        this.f21886a = eVar;
    }

    @NonNull
    public static JSONObject b(@NonNull Map<String, String> map, @Nullable JSONObject jSONObject) {
        boolean z10;
        if (jSONObject == null) {
            return new JSONObject();
        }
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames == null) {
            return new JSONObject();
        }
        if (map.isEmpty()) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
            try {
                String string = jSONArrayNames.getString(i10);
                JSONObject jSONObject3 = jSONObject.getJSONObject(string);
                if (!com.onetrust.otpublishers.headless.Internal.a.d(jSONObject3) && jSONObject3.has("CookiesCategoryIds")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("CookiesCategoryIds");
                    int i11 = 0;
                    while (true) {
                        if (i11 >= jSONArray.length()) {
                            z10 = false;
                            break;
                        }
                        if (map.containsKey(jSONArray.getString(i11).trim())) {
                            z10 = true;
                            break;
                        }
                        i11++;
                    }
                    if (z10) {
                        jSONObject2.put(string, jSONObject3);
                    }
                }
            } catch (JSONException e10) {
                x.a("General Vendor: error on filtering", e10, "GeneralVendors", 6);
            }
        }
        OTLogger.a("GeneralVendors", 4, "General Vendor: filtered vendors:" + jSONObject2);
        return jSONObject2;
    }

    @NonNull
    public final JSONObject a() {
        String string = this.f21886a.c().getString("OT_GENERAL_VENDORS", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e10) {
                x.a("Something went wrong while parsing savedGeneral Vendors: ", e10, "GeneralVendors", 3);
            }
        }
        return new JSONObject();
    }

    public final void c(@Nullable String str) {
        this.f21886a.c().edit().putString("OT_GENERAL_VENDORS", str).apply();
    }

    public final void d(boolean z10) {
        this.f21886a.c().edit().putBoolean("OT_GENERAL_VENDORS_CONFIGURED", z10).apply();
    }

    public final void e(boolean z10) {
        this.f21886a.c().edit().putBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", z10).apply();
    }

    public final boolean f() {
        return this.f21886a.c().getBoolean("OT_GENERAL_VENDORS_CONFIGURED", false);
    }
}
