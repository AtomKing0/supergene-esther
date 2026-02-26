package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21778a;

    public l0(@NonNull Context context) {
    }

    public static void a(boolean z10, boolean z11, @NonNull com.onetrust.otpublishers.headless.Internal.Preferences.g gVar) throws JSONException {
        String str;
        StringBuilder sb;
        boolean zF = gVar.f21894b.f();
        boolean z12 = gVar.f21894b.f21886a.c().getBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", false);
        if (zF && z12) {
            JSONObject jSONObjectA = gVar.f21894b.a();
            new JSONObject();
            JSONArray jSONArrayNames = jSONObjectA.names();
            if (com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayNames)) {
                jSONObjectA = null;
            } else {
                for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                    String string = jSONArrayNames.getString(i10);
                    if (jSONObjectA.has(string)) {
                        try {
                            JSONObject jSONObject = jSONObjectA.getJSONObject(string);
                            int iOptInt = jSONObject.optInt("consent", -1);
                            if (-1 != iOptInt && 2 != iOptInt) {
                                jSONObject.put("consent", String.valueOf(z10 ? 1 : 0));
                                OTLogger.a("GeneralVendors", 4, "Consent updated for Vendor: " + string + " as " + z10);
                            }
                        } catch (JSONException e10) {
                            sb = new StringBuilder("error while updating Vendor status:");
                            sb.append(e10);
                            OTLogger.a("GeneralVendors", 6, sb.toString());
                        }
                    } else {
                        sb = new StringBuilder("Given Vendor ID ");
                        sb.append(string);
                        sb.append(" does not match with any existing vendors. Please check and pass the correct Vendor ID");
                    }
                    OTLogger.a("GeneralVendors", 6, sb.toString());
                }
            }
            if (z11) {
                OTLogger.a("GeneralVendors", 4, "General Vendors saved as :" + jSONObjectA);
                return;
            } else {
                if (jSONObjectA == null) {
                    return;
                }
                gVar.f21894b.c(jSONObjectA.toString());
                str = "General Vendors saved as :" + jSONObjectA;
            }
        } else {
            if (z12) {
                OTLogger.a("GeneralVendors", 3, "General Vendors consent not saved : No Vendors configured");
                return;
            }
            str = "General Vendors consent not saved : Vendor Opt-out disabled from admin settings";
        }
        OTLogger.a("GeneralVendors", 4, str);
    }
}
