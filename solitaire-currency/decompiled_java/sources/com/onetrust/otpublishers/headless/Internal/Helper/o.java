package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f21782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.g f21783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f21784c = new JSONObject();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f21785d;

    public o(@NonNull Context context) {
        this.f21785d = context;
        this.f21782a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context).c();
        this.f21783b = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
    }

    public final int a(@NonNull String str, @NonNull String str2, boolean z10) {
        Integer numValueOf;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            String strC = c(str);
            numValueOf = strC != null ? Integer.valueOf(this.f21783b.a(strC)) : null;
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            return -1;
        }
        JSONObject jSONObject = new JSONObject(str2);
        if (!str2.contains(str)) {
            String strC2 = c(str);
            numValueOf = strC2 != null ? Integer.valueOf(this.f21783b.a(strC2)) : null;
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            d.a("Invalid SDK_ID passed - ", str, "SdkListHelper", 4);
            return -1;
        }
        if (jSONObject.getInt(str) == 2) {
            return z10 ? 2 : 1;
        }
        OTLogger.a("SdkListHelper", 4, "SDK_ID " + str + "  Status " + jSONObject.get(str));
        return jSONObject.getInt(str);
    }

    public final int b(@NonNull String str, boolean z10) {
        String string = this.f21782a.getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        d.a("SDK Status Object - ", string, "SdkListHelper", 4);
        try {
            JSONObject jSONObject = this.f21784c;
            return (jSONObject == null || !jSONObject.has(str)) ? a(str, string, z10) : this.f21784c.getInt(str);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while getting sdk status "), "SdkListHelper", 6);
            return -1;
        }
    }

    @Nullable
    public final String c(@NonNull String str) {
        String str2 = "";
        String string = this.f21782a.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        if (string.isEmpty()) {
            OTLogger.a("SdkListHelper", 3, "Empty sdkMap found");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (jSONObject.get(next).toString().contains(str)) {
                    str2 = next;
                }
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while fetching groupId by sdkId : "), "SdkListHelper", 6);
        }
        return str2;
    }

    public final void d(@NonNull JSONObject jSONObject) {
        int iB;
        JSONArray jSONArray = new JSONArray();
        if (jSONObject.getJSONObject("culture").getJSONObject("DomainData").has("Groups")) {
            JSONArray jSONArray2 = jSONObject.getJSONObject("culture").getJSONObject("DomainData").getJSONArray("Groups");
            if (jSONArray2.length() > 0) {
                String string = this.f21782a.getString("OTT_INTERNAL_SDK_GROUP_MAP", null);
                JSONObject jSONObject2 = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : new JSONObject();
                String string2 = this.f21782a.getString("OT_INTERNAL_SDK_STATUS_MAP", "");
                JSONObject jSONObject3 = !com.onetrust.otpublishers.headless.Internal.c.q(string2) ? new JSONObject(string2) : new JSONObject();
                boolean zShouldShowBanner = new OTPublishersHeadlessSDK(this.f21785d).shouldShowBanner();
                for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                    ArrayList arrayList = new ArrayList();
                    if ((!jSONArray2.getJSONObject(i10).has("ShowSDKListLink") || jSONArray2.getJSONObject(i10).getBoolean("ShowSDKListLink")) && jSONArray2.getJSONObject(i10).getJSONArray("FirstPartyCookies").length() > 0) {
                        for (int i11 = 0; i11 < jSONArray2.getJSONObject(i10).getJSONArray("FirstPartyCookies").length(); i11++) {
                            String strOptString = jSONArray2.getJSONObject(i10).getJSONArray("FirstPartyCookies").getJSONObject(i11).optString("SdkId");
                            arrayList.add(strOptString);
                            if (jSONArray2.getJSONObject(i10).optString("Status").contains("always")) {
                                iB = 2;
                            } else {
                                iB = !zShouldShowBanner ? b(strOptString, true) : -1;
                                if (zShouldShowBanner || -1 == iB || 2 == iB) {
                                    iB = 1 ^ (jSONArray2.getJSONObject(i10).optString("Status").equals("inactive") ? 1 : 0);
                                }
                            }
                            jSONObject3.put(strOptString, iB);
                            jSONObject2.put(jSONArray2.getJSONObject(i10).optString("CustomGroupId"), arrayList);
                        }
                        OTLogger.a("SdkListHelper", 4, "Saving SDK Status map = " + jSONObject3);
                        this.f21782a.edit().putString("OT_INTERNAL_SDK_STATUS_MAP", jSONObject3.toString()).apply();
                        jSONArray.put(jSONObject2);
                    }
                }
                f.a(jSONObject2, this.f21782a.edit(), "OTT_INTERNAL_SDK_GROUP_MAP");
            }
        }
    }

    public final void e(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        f0 f0Var;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            int i10 = jSONObject.getInt(next);
            if (jSONObject2.has(next)) {
                int i11 = jSONObject2.getInt(next);
                Context context = this.f21785d;
                boolean z10 = false;
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
                    hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z10 = true;
                } else {
                    hVar = null;
                }
                if (z10) {
                    sharedPreferences = hVar;
                }
                String string = sharedPreferences.getString("OTT_LAST_GIVEN_CONSENT", "0");
                if (0 == (com.onetrust.otpublishers.headless.Internal.c.q(string) ? 0L : Long.parseLong(string))) {
                    jSONObject2.put(next, i10);
                    f0Var = new f0(this.f21785d);
                } else if (i11 != i10) {
                    jSONObject2.put(next, i10);
                    f0Var = new f0(this.f21785d);
                }
                f0Var.b(next, i10);
            }
        }
    }

    @Nullable
    public final JSONArray f(@NonNull String str) {
        String string = this.f21782a.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return jSONArray;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject.has(str) ? new JSONArray(jSONObject.get(str).toString()) : jSONArray;
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while fetching Sdks by group : "), "SdkListHelper", 6);
            return jSONArray;
        }
    }

    public final boolean g(@NonNull String str, boolean z10) {
        JSONArray jSONArrayF = f(str);
        boolean z11 = false;
        for (int i10 = 0; i10 < jSONArrayF.length(); i10++) {
            try {
                i(jSONArrayF.get(i10).toString(), z10);
                z11 = true;
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error while Updating consent of SDK "), "SdkListHelper", 6);
            }
        }
        return z11;
    }

    public final void h(@NonNull String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            try {
                e(this.f21784c, jSONObject);
            } catch (JSONException e10) {
                e = e10;
                p.a(e, new StringBuilder("Error while Saving sdk status "), "SdkListHelper", 6);
            }
        } catch (JSONException e11) {
            e = e11;
            jSONObject = null;
        }
        if (jSONObject != null) {
            f.a(jSONObject, this.f21782a.edit(), "OT_INTERNAL_SDK_STATUS_MAP");
        }
    }

    public final void i(String str, boolean z10) {
        try {
            JSONObject jSONObject = new JSONObject(this.f21782a.getString("OT_INTERNAL_SDK_STATUS_MAP", ""));
            if (!jSONObject.has(str) || 2 == jSONObject.getInt(str)) {
                return;
            }
            this.f21784c.put(str, z10 ? 1 : 0);
            OTLogger.a("SdkListHelper", 4, "Updated SDK status for  - " + str + " To " + this.f21784c.get(str));
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while updating sdk status "), "SdkListHelper", 6);
        }
    }
}
