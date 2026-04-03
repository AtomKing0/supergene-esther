package com.onetrust.otpublishers.headless.Public.uiutils;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Helper.c;
import com.onetrust.otpublishers.headless.Internal.Helper.f;
import com.onetrust.otpublishers.headless.Internal.Helper.j;
import com.onetrust.otpublishers.headless.Internal.Helper.m0;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.b;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OTVendorUtils {
    public static final String CONSENT_TYPE = "consent";
    public static final String LEGITIMATE_CONSENT_TYPE = "legIntStatus";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ItemListener f22029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f22030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f22031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f22032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f22033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f22034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f22035g;
    public m0 generalVendorStatus;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f22036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f22037i;

    public interface ItemListener {
        void onItemClick(@NonNull String str, boolean z10);
    }

    public OTVendorUtils(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3) {
        this.f22030b = new JSONObject();
        this.f22032d = new JSONObject();
        if (jSONObject != null) {
            this.f22030b = jSONObject;
        }
        if (jSONObject2 != null) {
            this.f22032d = jSONObject2;
        }
        if (jSONObject3 != null) {
            this.f22034f = jSONObject3;
            this.generalVendorStatus = new m0(jSONObject3);
        }
    }

    public static void a(@NonNull String str, @NonNull String str2, boolean z10, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        jSONObject2.putOpt(str, z10 ? "1" : "0");
        jSONObject.put(str2, jSONObject2);
    }

    public void clearValues(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.f22030b = jSONObject;
        this.f22031c = null;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        this.f22032d = jSONObject2;
        this.f22033e = null;
        if (this.f22034f == null) {
            this.f22034f = new JSONObject();
            this.generalVendorStatus.f21779a = new JSONObject();
        } else {
            this.f22034f = jSONObject3;
            this.generalVendorStatus.f21779a = jSONObject3;
        }
        this.generalVendorStatus.f21780b = null;
    }

    @NonNull
    public JSONObject getVendorListWithUserSelection(@NonNull String str) {
        if ("google".equalsIgnoreCase(str)) {
            JSONObject jSONObject = this.f22033e;
            return jSONObject == null ? this.f22032d : jSONObject;
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            JSONObject jSONObject2 = this.f22031c;
            return jSONObject2 == null ? this.f22030b : jSONObject2;
        }
        m0 m0Var = this.generalVendorStatus;
        JSONObject jSONObject3 = m0Var.f21780b;
        return jSONObject3 == null ? m0Var.f21779a : jSONObject3;
    }

    @Nullable
    public JSONObject getVendorListWithUserSelectionWithoutFallback(@NonNull String str) {
        return "google".equalsIgnoreCase(str) ? this.f22033e : OTVendorListMode.IAB.equalsIgnoreCase(str) ? this.f22031c : this.generalVendorStatus.f21780b;
    }

    @NonNull
    public JSONObject getVendorsByPurpose(@NonNull Map<String, String> map, @Nullable JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strS = c.s(entry.getKey());
            String value = entry.getValue();
            value.getClass();
            switch (value) {
                case "IAB2V2_FEATURE":
                case "IAB2_FEATURE":
                    str = "features";
                    break;
                case "IAB2_PURPOSE":
                case "IAB2V2_PURPOSE":
                    str = "purposes";
                    break;
                case "IAB2V2_SPL_FEATURE":
                case "IAB2_SPL_FEATURE":
                    str = "specialFeatures";
                    break;
                case "IAB2V2_STACK":
                case "IAB2_STACK":
                    str = "stacks";
                    break;
                case "IAB2V2_SPL_PURPOSE":
                case "IAB2_SPL_PURPOSE":
                    str = "specialPurposes";
                    break;
                default:
                    str = null;
                    break;
            }
            if (str != null) {
                try {
                    a(jSONObject, jSONObject2, strS, str);
                } catch (Exception e10) {
                    j.a(e10, new StringBuilder("Vendors purpose list data error "), "VendorArray", 6);
                }
            }
        }
        return jSONObject2;
    }

    @NonNull
    public JSONObject getVendorsListObject(@NonNull String str) {
        return "google".equalsIgnoreCase(str) ? this.f22032d : OTVendorListMode.IAB.equalsIgnoreCase(str) ? this.f22030b : this.f22034f;
    }

    public boolean isAllVendorEnabled(@NonNull JSONObject jSONObject) {
        String string;
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames == null) {
            return false;
        }
        int i10 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= jSONArrayNames.length()) {
                return true;
            }
            try {
                string = jSONArrayNames.getString(i10);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Vendor list data error "), "OneTrust", 6);
            }
            if ("0".equalsIgnoreCase(jSONObject.getJSONObject(string).getString("consent"))) {
                OTLogger.a("VendorArray", 4, "consent status 0 for vendorID = " + string);
            } else {
                z10 = false;
            }
            if (z10) {
                return false;
            }
            i10++;
        }
    }

    public void refreshList(@NonNull String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if ("google".equalsIgnoreCase(str) && (jSONObject2 = this.f22033e) != null) {
            this.f22032d = jSONObject2;
        } else if (!OTVendorListMode.IAB.equalsIgnoreCase(str) || (jSONObject = this.f22031c) == null) {
            this.f22034f = this.generalVendorStatus.f21780b;
        } else {
            this.f22030b = jSONObject;
        }
    }

    public void saveVendorConsentStatus(@NonNull SharedPreferences sharedPreferences, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject != null) {
            f.a(jSONObject, sharedPreferences.edit(), "OT_IAB_ACTIVE_VENDORLIST");
        }
        if (jSONObject2 != null) {
            f.a(jSONObject2, sharedPreferences.edit(), "OT_GOOGLE_ACTIVE_VENDOR_LIST");
        }
        m0 m0Var = this.generalVendorStatus;
        OTLogger.a("GeneralVendors", 4, "General Vendors saved as " + m0Var.f21779a);
        f.a(m0Var.f21779a, sharedPreferences.edit(), "OT_GENERAL_VENDORS");
    }

    public void setFilteredList(@NotNull String str, @NotNull JSONObject jSONObject, boolean z10) {
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            this.f22036h = jSONObject;
        } else if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            this.f22035g = jSONObject;
        } else if ("google".equalsIgnoreCase(str)) {
            this.f22037i = jSONObject;
        }
        if (z10) {
            updateSelectAllButtonStatus(str);
        }
    }

    public void setSelectAllButtonListener(@Nullable ItemListener itemListener) {
        this.f22029a = itemListener;
    }

    public void setVendorsListObject(@NonNull String str, @NonNull JSONObject jSONObject, boolean z10) {
        if ("google".equalsIgnoreCase(str)) {
            this.f22032d = jSONObject;
        } else if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            this.f22030b = jSONObject;
        } else {
            this.f22034f = jSONObject;
        }
        if (z10) {
            updateSelectAllButtonStatus(str);
        }
    }

    public void updateAllGeneralVendorState(boolean z10, @NonNull String str, @NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        JSONArray jSONArrayNames;
        if (jSONObject2 == null || (jSONArrayNames = jSONObject2.names()) == null) {
            return;
        }
        for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
            try {
                String string = jSONArrayNames.getString(i10);
                if (jSONObject.has(string)) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject(string);
                    updateGeneralVendorsConsent(z10, str, jSONObject3);
                    jSONObject.put(string, jSONObject3);
                }
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error in reading string from JSONObject, error = "), "VendorArray", 6);
            }
        }
    }

    public void updateAllVendorState(boolean z10, @NonNull String str, @NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        JSONArray jSONArrayNames;
        if (jSONObject2 == null || (jSONArrayNames = jSONObject2.names()) == null) {
            return;
        }
        for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
            try {
                String string = jSONArrayNames.getString(i10);
                if (jSONObject.has(string)) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject(string);
                    updateVendorsConsent(z10, str, jSONObject3);
                    jSONObject.put(string, jSONObject3);
                }
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error in reading string from JSONObject, error = "), "VendorArray", 6);
            }
        }
    }

    public void updateAllVendorsConsentLocal(@NonNull String str, boolean z10) {
        JSONObject jSONObjectA;
        JSONObject jSONObject;
        if ("google".equalsIgnoreCase(str)) {
            jSONObjectA = a(str);
            jSONObject = this.f22032d;
        } else {
            boolean zEqualsIgnoreCase = OTVendorListMode.IAB.equalsIgnoreCase(str);
            jSONObjectA = a(str);
            if (!zEqualsIgnoreCase) {
                updateAllGeneralVendorState(z10, "consent", this.generalVendorStatus.f21779a, jSONObjectA);
                return;
            }
            jSONObject = this.f22030b;
        }
        updateAllVendorState(z10, "consent", jSONObject, jSONObjectA);
    }

    public void updateGeneralVendorsConsent(boolean z10, @NonNull String str, @NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt(str) <= -1 || jSONObject.getInt(str) == 2) {
            return;
        }
        jSONObject.putOpt(str, z10 ? "1" : "0");
    }

    public void updateSelectAllButtonStatus(@NonNull String str) {
        JSONObject jSONObject = OTVendorListMode.IAB.equalsIgnoreCase(str) ? this.f22035g : OTVendorListMode.GENERAL.equalsIgnoreCase(str) ? this.f22036h : "google".equalsIgnoreCase(str) ? this.f22037i : null;
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            if (jSONObject == null) {
                jSONObject = this.f22034f;
            }
        } else if ("google".equalsIgnoreCase(str)) {
            if (jSONObject == null) {
                jSONObject = this.f22032d;
            }
        } else if (jSONObject == null) {
            jSONObject = this.f22030b;
        }
        ItemListener itemListener = this.f22029a;
        if (itemListener != null) {
            itemListener.onItemClick(str, isAllVendorEnabled(jSONObject));
        }
    }

    public void updateVendorConsentStatus(@NonNull String str, @NonNull String str2, boolean z10) {
        try {
            if (a(str, str2, false)) {
                OTLogger.a("VendorArray", 4, "Vendor (" + str2 + ") consent updated to " + z10 + ".");
                a(str, "consent", str2, z10);
            } else {
                OTLogger.a("VendorArray", 6, "Not updated consent for Vendor (" + str2 + "), Consent not configured for this vendor Id.");
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("JSON exception on category status map put call. Error msg = "), "VendorArray", 6);
        }
    }

    public void updateVendorConsentStatusBasedOnCategoryStatus(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z10, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            HashMap map = new HashMap();
            map.put(str2, "COOKIE");
            JSONObject jSONObject = new JSONObject(str3);
            if (jSONObject.has(str2)) {
                JSONArray jSONArray = jSONObject.getJSONArray(str2);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    map.put(jSONArray.get(i10).toString(), "COOKIE");
                }
            }
            JSONArray jSONArrayNames = b.b(map, oTPublishersHeadlessSDK.getVendorListUI(OTVendorListMode.GENERAL)).names();
            if (jSONArrayNames != null) {
                for (int i11 = 0; i11 < jSONArrayNames.length(); i11++) {
                    oTPublishersHeadlessSDK.updateVendorConsent(str, jSONArrayNames.getString(i11), z10);
                }
            }
        }
    }

    public void updateVendorLegitInterest(@NonNull String str, @NonNull String str2, boolean z10) {
        try {
            if (a(str, str2, true)) {
                a(str, LEGITIMATE_CONSENT_TYPE, str2, z10);
                OTLogger.a("VendorArray", 4, "Vendor (" + str2 + ")  legit interest updated to " + z10 + ".");
            } else {
                OTLogger.a("VendorArray", 6, "Not updated LI for Vendor (" + str2 + "), LI not configured for this vendor Id.");
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("JSON exception on category status map put call. Error msg = "), "VendorArray", 6);
        }
    }

    public void updateVendorObjectLocalState(@NonNull String str) {
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            if (getVendorListWithUserSelectionWithoutFallback(str) == null) {
                m0 m0Var = this.generalVendorStatus;
                new JSONObject();
                m0Var.f21780b = m0Var.f21779a;
                return;
            }
            return;
        }
        if ("google".equalsIgnoreCase(str)) {
            if (getVendorListWithUserSelectionWithoutFallback(str) == null) {
                this.f22033e = this.f22032d;
            }
        } else if (OTVendorListMode.IAB.equalsIgnoreCase(str) && getVendorListWithUserSelectionWithoutFallback(str) == null) {
            this.f22031c = this.f22030b;
        }
    }

    public void updateVendorsConsent(boolean z10, @NonNull String str, @NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt(str) > -1) {
            jSONObject.putOpt(str, z10 ? "1" : "0");
        }
    }

    @NonNull
    public static JSONObject getVendorsListObject(@NonNull JSONObject jSONObject, @NonNull String str) {
        return jSONObject.has(str) ? jSONObject.getJSONObject(str) : new JSONObject();
    }

    @Nullable
    public final JSONObject a(@NonNull String str) {
        JSONObject jSONObject = OTVendorListMode.IAB.equalsIgnoreCase(str) ? this.f22035g : OTVendorListMode.GENERAL.equalsIgnoreCase(str) ? this.f22036h : "google".equalsIgnoreCase(str) ? this.f22037i : null;
        return jSONObject == null ? "google".equalsIgnoreCase(str) ? this.f22032d : OTVendorListMode.IAB.equalsIgnoreCase(str) ? this.f22030b : OTVendorListMode.GENERAL.equalsIgnoreCase(str) ? this.f22034f : jSONObject : jSONObject;
    }

    public final boolean a(@NonNull String str, @NonNull String str2, boolean z10) {
        try {
            JSONObject vendorListWithUserSelection = getVendorListWithUserSelection(str);
            if (vendorListWithUserSelection.has(str2) && z10) {
                if (vendorListWithUserSelection.getJSONObject(str2).getInt(LEGITIMATE_CONSENT_TYPE) <= -1) {
                    return false;
                }
            } else if (!vendorListWithUserSelection.has(str2) || z10 || vendorListWithUserSelection.getJSONObject(str2).getInt("consent") <= -1) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("unable to get vendor status "), "VendorArray", 6);
            return false;
        }
    }

    public static void a(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull String str, @NonNull String str2) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject3 = jSONObject.getJSONObject(next);
            Objects.requireNonNull(str2);
            int i10 = 0;
            if (str2.equals("purposes")) {
                JSONArray jSONArray = jSONObject3.getJSONArray("purposes");
                if (jSONObject3.getJSONArray(str2).length() > 0) {
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        if (jSONArray.getString(i11).equals(str)) {
                            jSONObject2.put(next, jSONObject3);
                        }
                    }
                }
                if (jSONObject3.getJSONArray("legIntPurposes").length() > 0 && jSONObject3.getInt(LEGITIMATE_CONSENT_TYPE) >= 0) {
                    while (i10 < jSONObject3.getJSONArray("legIntPurposes").length()) {
                        if (jSONObject3.getJSONArray("legIntPurposes").getString(i10).equals(str)) {
                            jSONObject2.put(next, jSONObject3);
                        }
                        i10++;
                    }
                }
            } else {
                JSONArray jSONArray2 = jSONObject3.getJSONArray(str2);
                if (jSONObject3.getJSONArray(str2).length() > 0) {
                    while (i10 < jSONArray2.length()) {
                        if (jSONArray2.getString(i10).equals(str)) {
                            jSONObject2.put(next, jSONObject3);
                        }
                        i10++;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5 A[PHI: r0 r10
      0x00f5: PHI (r0v8 org.json.JSONObject) = (r0v7 org.json.JSONObject), (r0v12 org.json.JSONObject) binds: [B:48:0x00f3, B:38:0x00d2] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r10v4 org.json.JSONObject) = (r10v2 org.json.JSONObject), (r10v8 org.json.JSONObject) binds: [B:48:0x00f3, B:38:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb A[PHI: r0 r10
      0x00fb: PHI (r0v10 org.json.JSONObject) = (r0v7 org.json.JSONObject), (r0v12 org.json.JSONObject) binds: [B:48:0x00f3, B:38:0x00d2] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r10v6 org.json.JSONObject) = (r10v2 org.json.JSONObject), (r10v8 org.json.JSONObject) binds: [B:48:0x00f3, B:38:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(@androidx.annotation.NonNull java.lang.String r10, @androidx.annotation.NonNull java.lang.String r11, @androidx.annotation.NonNull java.lang.String r12, boolean r13) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils.a(java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }
}
