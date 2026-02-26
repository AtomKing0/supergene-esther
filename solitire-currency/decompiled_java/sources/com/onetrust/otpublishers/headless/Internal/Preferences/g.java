package com.onetrust.otpublishers.headless.Internal.Preferences;

import android.content.Context;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Helper.j;
import com.onetrust.otpublishers.headless.Internal.Helper.n;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f21893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f21894b;

    public g(@NonNull Context context) {
        e eVar = new e(context);
        this.f21893a = eVar;
        this.f21894b = new b(eVar);
    }

    public final int a(@NonNull String str) {
        String str2;
        JSONObject jSONObject;
        if (k(str)) {
            return 1;
        }
        String string = this.f21893a.c().getString("OTT_CONSENT_STATUS", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            Locale locale = Locale.ENGLISH;
            String lowerCase = str.toLowerCase(locale);
            try {
                jSONObject = new JSONObject(string.toLowerCase(locale));
            } catch (JSONException unused) {
                jSONObject = null;
            }
            try {
                if (jSONObject.has(lowerCase)) {
                    return jSONObject.getInt(lowerCase);
                }
                return -1;
            } catch (JSONException unused2) {
                str2 = "error in json parsing for customGroup Value = " + jSONObject;
                OTLogger.a("OTSPUtils", 3, str2);
                return -1;
            }
        }
        str2 = "customGroup Value not set.";
        OTLogger.a("OTSPUtils", 3, str2);
        return -1;
    }

    @NonNull
    public final JSONObject b() {
        String string = this.f21893a.c().getString("OTT_CULTURE_DOMAIN_DATA", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while returning culture domain data, err: "), "OneTrust", 6);
            }
        }
        return new JSONObject();
    }

    public final void c(int i10) {
        this.f21893a.c().edit().putInt("OTT_DATA_SUBJECT_IDENTIFIER_TYPE", i10).apply();
    }

    public final void d(@NonNull JSONArray jSONArray) {
        String str;
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
                if (jSONObject.has("CustomGroupId")) {
                    map.put(jSONObject.getString("CustomGroupId"), jSONObject.has("Parent") ? jSONObject.getString("Parent") : "");
                }
            } catch (JSONException e10) {
                n.a(e10, new StringBuilder("JSON exception = "), "OTSPUtils", 6);
            }
        }
        HashMap map2 = new HashMap();
        for (String str2 : map.keySet()) {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str2) && (str = (String) map.get(str2)) != null && !com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                if (map2.get(str) == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    map2.put(str, arrayList);
                } else {
                    List list = (List) map2.get(str);
                    Objects.requireNonNull(list);
                    list.add(str2);
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject(map2);
        JSONObject jSONObject3 = new JSONObject(map);
        com.onetrust.otpublishers.headless.Internal.Helper.f.a(jSONObject3, this.f21893a.c().edit(), "DOMAIN_PARENT_ID_MAP");
        com.onetrust.otpublishers.headless.Internal.Helper.f.a(jSONObject2, this.f21893a.c().edit(), "OTT_PARENT_GROUPS");
        this.f21893a.c().edit().putString("OTT_PARENT_CHILD_GROUPS", jSONObject2.toString()).apply();
        OTLogger.a("OTSPUtils", 4, "parent groups : " + jSONObject2.toString());
        OTLogger.a("OTSPUtils", 4, "parent map = " + jSONObject3.toString());
    }

    public final void e(@NonNull JSONObject jSONObject) {
        OTLogger.a("IAB2V2Flow", 3, "Setting saveDataDeclarationCategories = " + jSONObject.toString());
        com.onetrust.otpublishers.headless.Internal.Helper.f.a(jSONObject, this.f21893a.c().edit(), "OT_DATA_DECLARATION_CATEGORIES");
    }

    public final void f(boolean z10) {
        OTLogger.a("authenticatedConsentFlow", 3, "saveAuthenticatedConsentFlag = " + z10);
        this.f21893a.c().edit().putBoolean("OT_AUTHENTICATED_CONSENT_SERVER_FLAG", z10).apply();
    }

    @NonNull
    public final JSONObject g() {
        try {
            String string = this.f21893a.c().getString("OT_MOBILE_DATA", "");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                return new JSONObject(string);
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while getting mobile data json, err: "), "OneTrust", 6);
        }
        return new JSONObject();
    }

    public final void h(int i10) {
        this.f21893a.c().edit().putInt("OT_MIGRATION_STATUS", i10).apply();
    }

    public final void i(@NonNull JSONObject jSONObject) {
        OTLogger.a("IAB2V2Flow", 3, "Setting vendorCountForCategoryString = " + jSONObject);
        com.onetrust.otpublishers.headless.Internal.Helper.f.a(jSONObject, this.f21893a.c().edit(), "OT_VENDOR_COUNT_FOR_CATEGORIES");
    }

    public final void j(boolean z10) {
        this.f21893a.c().edit().putBoolean("OTT_OFFLINE_DATA_SET_FLAG", z10).apply();
    }

    public final boolean k(@NonNull String str) {
        String string = this.f21893a.c().getString("OTT_ALWAYS_ACTIVE_GROUPS", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return false;
        }
        try {
            Locale locale = Locale.ENGLISH;
            return new JSONObject(string.toLowerCase(locale)).has(str.toLowerCase(locale));
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("Error in getting always active groups "), "OTSPUtils", 6);
            return false;
        }
    }

    @NonNull
    public final JSONObject l() {
        String string = this.f21893a.c().getString("OT_VENDOR_COUNT_FOR_CATEGORIES", "");
        OTLogger.a("IAB2V2Flow", 3, "Getting vendorCountForCategoryString = " + string);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on getting vendor count for categories : "), "OTSPUtils", 6);
            }
        }
        return new JSONObject();
    }

    public final void m(int i10) {
        this.f21893a.c().edit().putInt("OT_UI_MODE_TYPE", i10).apply();
    }

    public final void n(@NonNull String str) {
        OTLogger.a("authenticatedConsentFlow", 3, "saveOTSDKAuthenticatedConsentConfiguration = ".concat(str));
        this.f21893a.c().edit().putString("OT_SDK_AUTHENTICATED_CONSENT_CONFIGURATION", str).apply();
    }

    public final void o(@NonNull String str) {
        StringBuilder sb;
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(str);
        } catch (ParseException e10) {
            e = e10;
            sb = new StringBuilder("Error on converting tc string date, message = ");
            sb.append(e.getMessage());
            OTLogger.a("OTUtils", 6, sb.toString());
            date = null;
        } catch (Exception e11) {
            e = e11;
            sb = new StringBuilder("Error on converting date. Error msg = ");
            sb.append(e.getMessage());
            OTLogger.a("OTUtils", 6, sb.toString());
            date = null;
        }
        if (date != null) {
            this.f21893a.c().edit().putLong("OT_IAB_TC_STR_CREATED_IN_MILLISECONDS", date.getTime()).apply();
            OTLogger.a("TCStringDate", 2, "Updating tc string Created date from profile sync value,Date = " + str + " , milliseconds = " + date.getTime());
        }
    }

    public final boolean p() {
        boolean z10 = this.f21893a.c().getBoolean("OT_AUTHENTICATED_CONSENT_SERVER_FLAG", false);
        OTLogger.a("authenticatedConsentFlow", 3, "isAuthenticatedConsentEnabled = " + z10);
        return z10;
    }

    public final void q(@NonNull String str) {
        StringBuilder sb;
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(str);
        } catch (ParseException e10) {
            e = e10;
            sb = new StringBuilder("Error on converting tc string date, message = ");
            sb.append(e.getMessage());
            OTLogger.a("OTUtils", 6, sb.toString());
            date = null;
        } catch (Exception e11) {
            e = e11;
            sb = new StringBuilder("Error on converting date. Error msg = ");
            sb.append(e.getMessage());
            OTLogger.a("OTUtils", 6, sb.toString());
            date = null;
        }
        if (date != null) {
            this.f21893a.c().edit().putLong("OT_IAB_TC_STR_LAST_UPDATED_IN_MILLISECONDS", date.getTime()).apply();
            OTLogger.a("TCStringDate", 2, "Updating tc string updated date from profile sync value,Date = " + str + " , milliseconds = " + date.getTime());
        }
    }

    public final boolean r() {
        String string = this.f21893a.c().getString("OT_CONSENT_INTEGRATION_DATA", "");
        try {
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while returning consent integration data, err: "), "OneTrust", 6);
        }
        JSONObject jSONObject = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : null;
        if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject)) {
            return false;
        }
        return jSONObject.optBoolean("EnableJWTAuthForKnownUsers");
    }

    public final void s(@NonNull String str) {
        this.f21893a.c().edit().putString("OTT_DATA_SUBJECT_IDENTIFIER", str).apply();
    }

    public final boolean t() {
        boolean z10 = this.f21893a.c().getBoolean("IS_IAB2_V2_TEMPLATE_FLAG", false);
        OTLogger.a("IAB2V2Flow", 3, "Is iab2V2TypeFlag = " + z10);
        return z10;
    }

    public final void u(@NonNull String str) {
        this.f21893a.c().edit().putString("OT_IAB_PURPOSES_TRANSLATED", str).apply();
    }

    public final boolean v() {
        try {
            String string = this.f21893a.c().getString("OTT_PC_DATA", null);
            JSONObject jSONObject = com.onetrust.otpublishers.headless.Internal.c.q(string) ? null : new JSONObject(string);
            if (jSONObject != null) {
                boolean zT = com.onetrust.otpublishers.headless.Internal.c.t(jSONObject.optString("IabType"));
                OTLogger.a("IAB2V2Flow", 3, "Is Iab2v2type = " + zT);
                return zT;
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error on getting iab type : "), "IAB2V2Flow", 6);
        }
        OTLogger.a("IAB2V2Flow", 3, "Iab2v2type false.");
        return false;
    }

    public final void w(@NonNull String str) {
        com.onetrust.otpublishers.headless.Internal.Helper.d.a("Updating consent given time, timeStamp = ", str, "OTSPUtils", 4);
        this.f21893a.c().edit().putString("OTT_LAST_GIVEN_CONSENT", str).apply();
    }

    public final boolean x() {
        String string = this.f21893a.c().getString("OT_CONSENT_INTEGRATION_DATA", "");
        try {
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while returning consent integration data, err: "), "OneTrust", 6);
        }
        JSONObject jSONObject = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : null;
        if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject)) {
            return false;
        }
        return jSONObject.optBoolean("IdentifiedReceiptsAllowed");
    }

    public g(@NonNull e eVar) {
        this.f21893a = eVar;
        this.f21894b = new b(eVar);
    }
}
