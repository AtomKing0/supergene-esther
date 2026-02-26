package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f21772b = new JSONObject();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f21773c = new JSONObject();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f21774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.g f21775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f21776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f21777g;

    public k0(@NonNull Context context) {
        this.f21771a = context;
        this.f21774d = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context).c();
        this.f21775e = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
        this.f21777g = new o(context);
    }

    @VisibleForTesting
    public static void c(@NonNull c cVar, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        for (int i10 = 0; i10 < jSONObject2.length(); i10++) {
            String string = jSONObject2.names().getString(i10);
            if (cVar.z(string)) {
                jSONObject.getJSONObject(cVar.v(string)).put(c.s(string), jSONObject2.getInt(string));
            }
        }
        OTLogger.a("CustomGroupDetails", 3, "IAB purposes updated : " + jSONObject);
    }

    public final int a(@NonNull String str) {
        try {
            return this.f21772b.has(str) ? this.f21772b.getInt(str) : this.f21775e.a(str);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while getting updated value of Purpose Consent "), "CustomGroupDetails", 6);
            return -1;
        }
    }

    public final void b() {
        new com.onetrust.otpublishers.headless.gpp.templates.d(this.f21771a).a();
        new com.onetrust.otpublishers.headless.gpp.templates.a(this.f21771a).a();
        new com.onetrust.otpublishers.headless.gpp.templates.f(this.f21771a).b();
        new com.onetrust.otpublishers.headless.gpp.templates.b(this.f21771a).a();
        new com.onetrust.otpublishers.headless.gpp.templates.c(this.f21771a).a();
        new com.onetrust.otpublishers.headless.gpp.templates.e(this.f21771a).a();
        new com.onetrust.otpublishers.headless.gpp.d(this.f21771a).d();
    }

    public final void d(@NonNull String str, @Nullable JSONObject jSONObject, boolean z10) {
        JSONObject jSONObject2;
        String string;
        String string2;
        boolean z11;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z12;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        if (z10) {
            d.a("updated IAB user choices", str, "CustomGroupDetails", 4);
            v.a(this.f21774d, "OTT_IAB_CONSENTABLE_PURPOSES", str);
            if (jSONObject != null) {
                f.a(jSONObject, this.f21774d.edit(), "OT_IAB_ACTIVE_VENDORLIST");
            }
            StringBuilder sb = new StringBuilder("is IAB enabled : ");
            Context context = this.f21771a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            SharedPreferences sharedPreferencesA = c0.a(context, "OTT_DEFAULT_USER");
            Boolean bool = Boolean.FALSE;
            if (h.a(bool, sharedPreferencesA, "OT_ENABLE_MULTI_PROFILE")) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z11 = true;
            } else {
                z11 = false;
                hVar = null;
            }
            if (z11) {
                sharedPreferences = hVar;
            }
            sb.append(sharedPreferences.getBoolean("IS_IAB2_TEMPLATE", false));
            OTLogger.a("CustomGroupDetails", 4, sb.toString());
            Context context2 = this.f21771a;
            SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (h.a(bool, c0.a(context2, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
                hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                z12 = true;
            } else {
                z12 = false;
                hVar2 = null;
            }
            if (z12) {
                sharedPreferences2 = hVar2;
            }
            if (sharedPreferences2.getBoolean("IS_IAB2_TEMPLATE", false)) {
                Context context3 = this.f21771a;
                new c(context3).i(context3, false);
            }
        } else {
            d.a("updated IAB user choices ", str, "CustomGroupDetails", 4);
            this.f21774d.edit().putString("OTT_IAB_CONSENTABLE_PURPOSES", str).apply();
            this.f21773c = new JSONObject();
            Context context4 = this.f21771a;
            new c(context4).i(context4, false);
        }
        Context context5 = this.f21771a;
        com.onetrust.otpublishers.headless.Internal.Preferences.g gVar = this.f21775e;
        if (gVar.f21893a.c().getBoolean("OT_GOOGLE_VENDORS_ENABLED_STATE", false)) {
            try {
                string2 = gVar.f21893a.c().getString("OT_GOOGLE_ACTIVE_VENDOR_LIST", null);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("error while getting culture data json on getActiveGoogleVendors, err: "), "OneTrust", 6);
            }
            JSONObject jSONObject3 = !com.onetrust.otpublishers.headless.Internal.c.q(string2) ? new JSONObject(string2) : null;
            try {
                jSONObject2 = null;
                try {
                    string = gVar.f21893a.c().getString("OT_GOOGLE_VENDOR_DATA", null);
                } catch (JSONException e11) {
                    e = e11;
                    p.a(e, new StringBuilder("error while getting culture data json on getGoogleVendorsData, err: "), "OneTrust", 6);
                }
            } catch (JSONException e12) {
                e = e12;
                jSONObject2 = null;
            }
            JSONObject jSONObject4 = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : jSONObject2;
            try {
                if (jSONObject3 == null) {
                    OTLogger.a("GoogleVendorHelper", 5, "Google additional string not generated: Google vendor data is null");
                    return;
                }
                String string3 = "" + ((jSONObject4 == null || !jSONObject4.has("vendorListVersion")) ? "1" : jSONObject4.getString("vendorListVersion")) + "~";
                JSONArray jSONArrayNames = jSONObject3.names();
                if (jSONArrayNames != null) {
                    StringBuilder sb2 = new StringBuilder(string3);
                    boolean z13 = true;
                    for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                        String string4 = jSONArrayNames.getString(i10);
                        if ("1".equalsIgnoreCase(jSONObject3.getJSONObject(string4).getString("consent"))) {
                            if (!z13) {
                                sb2.append(".");
                            }
                            sb2.append(string4);
                            z13 = false;
                        }
                    }
                    string3 = sb2.toString();
                }
                PreferenceManager.getDefaultSharedPreferences(context5).edit().putString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, string3).apply();
                OTLogger.a("GoogleVendorHelper", 4, "Google consent string, IABTCF_AddtlConsent = " + string3);
            } catch (JSONException e13) {
                p.a(e13, new StringBuilder("Error on parsing google vendor status.Error message = "), "GoogleVendorHelper", 6);
            }
        }
    }

    public final void e(@NonNull String str, boolean z10) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        Context context = this.f21771a;
        new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z11 = true;
        } else {
            hVar = null;
            z11 = false;
        }
        if (z11) {
            sharedPreferences = hVar;
        }
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        String string = sharedPreferences.getString("OTT_INTERNAL_SDK_GROUP_MAP", "");
        JSONArray jSONArray = new JSONArray();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray(jSONObject.get(str).toString());
                }
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error while fetching Sdks by group : "), "SdkListHelper", 6);
            }
        }
        OTLogger.a("CustomGroupDetails", 4, "SDK Ids of  : " + str + " is " + jSONArray);
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                this.f21777g.i(jSONArray.get(i10).toString(), z10);
            } catch (JSONException e11) {
                p.a(e11, new StringBuilder("Error in setting group sdk status "), "OneTrust", 6);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0342 A[Catch: JSONException -> 0x0382, TryCatch #0 {JSONException -> 0x0382, blocks: (B:132:0x0330, B:148:0x0370, B:135:0x0342, B:137:0x0348, B:139:0x034e, B:142:0x0359, B:144:0x035f, B:146:0x0369, B:147:0x036d), top: B:208:0x0330 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03a8 A[Catch: Exception -> 0x03ad, TRY_LEAVE, TryCatch #3 {Exception -> 0x03ad, blocks: (B:153:0x039e, B:155:0x03a8), top: B:214:0x039e }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x040c A[Catch: JSONException -> 0x042a, TryCatch #12 {JSONException -> 0x042a, blocks: (B:167:0x03ff, B:169:0x040c, B:171:0x0412, B:173:0x041c, B:175:0x0422), top: B:232:0x03ff }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x044d A[Catch: Exception -> 0x0454, TRY_LEAVE, TryCatch #9 {Exception -> 0x0454, blocks: (B:181:0x0440, B:183:0x044d), top: B:226:0x0440 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 1242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.k0.f(boolean, boolean):void");
    }

    public final void g(boolean z10, boolean z11, @NonNull JSONObject jSONObject, boolean z12) throws JSONException {
        boolean z13;
        boolean z14;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2;
        boolean z15;
        JSONArray jSONArray;
        boolean z16;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar3;
        boolean z17;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar4;
        if (jSONObject.length() > 0) {
            JSONArray jSONArrayNames = jSONObject.getJSONObject("purposes").names();
            JSONArray jSONArrayNames2 = jSONObject.getJSONObject("special_feature_opt_ins").names();
            JSONArray jSONArrayNames3 = jSONObject.getJSONObject("stacks").names();
            JSONArray jSONArrayNames4 = jSONObject.getJSONObject("purposeLegitimateInterests").names();
            Context context = this.f21771a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            SharedPreferences sharedPreferencesA = c0.a(context, "OTT_DEFAULT_USER");
            Boolean bool = Boolean.FALSE;
            if (h.a(bool, sharedPreferencesA, "OT_ENABLE_MULTI_PROFILE")) {
                jSONArray = jSONArrayNames2;
                hVar3 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z16 = true;
            } else {
                jSONArray = jSONArrayNames2;
                z16 = false;
                hVar3 = null;
            }
            if (z16) {
                sharedPreferences = hVar3;
            }
            String string = sharedPreferences.getString("OT_IAB_ACTIVE_VENDORLIST", "");
            OTLogger.a("IABHelper", 3, com.onetrust.otpublishers.headless.Internal.c.q(string) ? "Vendor List is empty" : "Saved IAB Active Vendor List : " + string);
            JSONObject jSONObject2 = com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject() : new JSONObject(string);
            if (!z11) {
                Context context2 = this.f21771a;
                SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (h.a(bool, c0.a(context2, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
                    hVar4 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z17 = true;
                } else {
                    z17 = false;
                    hVar4 = null;
                }
                if (z17) {
                    sharedPreferences2 = hVar4;
                }
                if (sharedPreferences2.getBoolean("IS_IAB2_TEMPLATE", false)) {
                    if (jSONArrayNames != null && jSONArrayNames.length() > 0) {
                        for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                            jSONObject.getJSONObject("purposes").put(jSONArrayNames.getString(i10), z10 ? 1 : 0);
                        }
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            jSONObject.getJSONObject("special_feature_opt_ins").put(jSONArray.getString(i11), z10 ? 1 : 0);
                        }
                    }
                    if (jSONArrayNames3 != null && jSONArrayNames3.length() > 0) {
                        for (int i12 = 0; i12 < jSONArrayNames3.length(); i12++) {
                            jSONObject.getJSONObject("stacks").put(jSONArrayNames3.getString(i12), z10 ? 1 : 0);
                        }
                    }
                    OTLogger.a("RejectAllFlow", 3, "Is interaction type reject all = " + (!z10) + " , reject all type isRejectObjectToLI = " + z12);
                    for (int i13 = 0; i13 < jSONObject2.length(); i13++) {
                        JSONArray jSONArrayNames5 = jSONObject2.names();
                        if (jSONArrayNames5 != null) {
                            if (jSONObject2.getJSONObject(jSONArrayNames5.get(i13).toString()).getInt("consent") >= 0) {
                                jSONObject2.getJSONObject(jSONArrayNames5.get(i13).toString()).put("consent", z10 ? 1 : 0);
                            }
                            if (jSONObject2.getJSONObject(jSONArrayNames5.get(i13).toString()).getInt(OTVendorUtils.LEGITIMATE_CONSENT_TYPE) >= 0 && (z10 || z12)) {
                                jSONObject2.getJSONObject(jSONArrayNames5.get(i13).toString()).put(OTVendorUtils.LEGITIMATE_CONSENT_TYPE, z10 ? 1 : 0);
                            }
                        }
                    }
                    if ((z10 || z12) && jSONArrayNames4 != null && jSONArrayNames4.length() > 0) {
                        int i14 = 0;
                        while (i14 < jSONArrayNames4.length()) {
                            JSONArray jSONArray2 = jSONArrayNames4;
                            if (!"1".equals(jSONArray2.getString(i14))) {
                                jSONObject.getJSONObject("purposeLegitimateInterests").put(jSONArray2.getString(i14), z10 ? 1 : 0);
                            }
                            i14++;
                            jSONArrayNames4 = jSONArray2;
                        }
                    }
                }
            }
            z13 = true;
            d(jSONObject.toString(), jSONObject2, true);
        } else {
            z13 = true;
        }
        Context context3 = this.f21771a;
        SharedPreferences sharedPreferences3 = context3.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        SharedPreferences sharedPreferencesA2 = c0.a(context3, "OTT_DEFAULT_USER");
        Boolean bool2 = Boolean.FALSE;
        if (h.a(bool2, sharedPreferencesA2, "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context3, sharedPreferences3, sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", ""));
            z14 = z13;
        } else {
            z14 = false;
            hVar = null;
        }
        if (z14) {
            sharedPreferences3 = hVar;
        }
        if (sharedPreferences3.getBoolean("IS_IAB2_TEMPLATE", false)) {
            return;
        }
        Context context4 = this.f21771a;
        SharedPreferences sharedPreferences4 = context4.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (h.a(bool2, c0.a(context4, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
            hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context4, sharedPreferences4, sharedPreferences4.getString("OT_ACTIVE_PROFILE_ID", ""));
            z15 = z13;
        } else {
            hVar2 = null;
            z15 = false;
        }
        new com.onetrust.otpublishers.headless.gpp.c(context4);
        if (z15) {
            sharedPreferences4 = hVar2;
        }
        new com.onetrust.otpublishers.headless.Internal.Preferences.a(this.f21771a).b(sharedPreferences4.getBoolean("OT_GPP_IS_ENABLED", false) ? OTGppKeys.IAB_GPP_GDPRAPPLIES : OTIABTCFKeys.IABTCF_GDPRAPPLIES, 0);
        OTLogger.a("CustomGroupDetails", 4, "Setting gdprApplies value to 0.");
    }

    public final void h(boolean z10, boolean z11, boolean z12, @Nullable String str) {
        if (!z12 || com.onetrust.otpublishers.headless.Internal.c.q(str) || str == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        boolean z13 = false;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (jSONObject.getInt(next) == 1) {
                z13 = true;
            } else if (jSONObject.getInt(next) == 0) {
                z13 = false;
            }
            if (z11) {
                this.f21777g.i(next, z13);
            } else {
                this.f21777g.i(next, z10);
            }
        }
        this.f21777g.h(str);
    }

    public final boolean i(@NonNull com.onetrust.otpublishers.headless.Internal.Models.d dVar) {
        try {
            return dVar.a(this.f21775e.b());
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while getting old consent "), "CustomGroupDetails", 6);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(@androidx.annotation.Nullable java.lang.String r12, @androidx.annotation.NonNull org.json.JSONObject r13, @androidx.annotation.NonNull org.json.JSONObject r14) throws org.json.JSONException {
        /*
            r11 = this;
            com.onetrust.otpublishers.headless.Internal.Helper.g0 r0 = new com.onetrust.otpublishers.headless.Internal.Helper.g0
            android.content.Context r1 = r11.f21771a
            r0.<init>(r1)
            java.lang.String r1 = r0.e()
            boolean r2 = com.onetrust.otpublishers.headless.Internal.c.q(r12)
            if (r2 == 0) goto L17
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            goto L1d
        L17:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r12)
            r12 = r2
        L1d:
            java.util.Iterator r2 = r13.keys()
            r3 = 0
            r4 = r3
        L23:
            boolean r5 = r2.hasNext()
            java.lang.String r6 = "FIRST_TIME_CONSENT_LOG"
            if (r5 == 0) goto L5f
            java.lang.Object r5 = r2.next()
            java.lang.String r5 = (java.lang.String) r5
            int r7 = r13.getInt(r5)
            boolean r8 = r12.has(r5)
            r9 = 1
            if (r8 == 0) goto L4a
            int r8 = r12.getInt(r5)
            android.content.SharedPreferences r10 = r11.f21774d
            boolean r6 = r10.getBoolean(r6, r9)
            if (r6 != 0) goto L4a
            if (r8 == r7) goto L51
        L4a:
            r12.put(r5, r7)
            r14.put(r5, r7)
            r4 = r9
        L51:
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L23
            if (r7 != r9) goto L5a
            goto L5b
        L5a:
            r9 = r3
        L5b:
            r0.d(r9, r3)
            goto L23
        L5f:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "consent values saved as  "
            r13.<init>(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            java.lang.String r14 = "CustomGroupDetails"
            r0 = 4
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r14, r0, r13)
            android.content.SharedPreferences r13 = r11.f21774d
            android.content.SharedPreferences$Editor r13 = r13.edit()
            android.content.SharedPreferences$Editor r13 = r13.putBoolean(r6, r3)
            r13.apply()
            android.content.SharedPreferences r13 = r11.f21774d
            android.content.SharedPreferences$Editor r13 = r13.edit()
            java.lang.String r14 = "OTT_CONSENT_STATUS"
            com.onetrust.otpublishers.headless.Internal.Helper.f.a(r12, r13, r14)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.k0.j(java.lang.String, org.json.JSONObject, org.json.JSONObject):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(boolean r8, boolean r9, @androidx.annotation.Nullable org.json.JSONArray r10, org.json.JSONObject r11) throws org.json.JSONException {
        /*
            r7 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "purposes"
            boolean r2 = r11.has(r1)
            if (r2 == 0) goto L11
            org.json.JSONObject r0 = r11.getJSONObject(r1)
        L11:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "special_feature_opt_ins"
            boolean r3 = r11.has(r2)
            if (r3 == 0) goto L22
            org.json.JSONObject r1 = r11.getJSONObject(r2)
        L22:
            r11 = 0
            if (r10 == 0) goto L82
            int r2 = r10.length()
            if (r2 <= 0) goto L82
            r2 = r11
        L2c:
            int r3 = r10.length()
            r4 = 1
            if (r2 >= r3) goto L80
            java.lang.String r3 = r10.getString(r2)
            java.lang.String r5 = "IAB"
            boolean r5 = r3.startsWith(r5)
            java.lang.String r6 = "ISF"
            if (r5 != 0) goto L47
            boolean r5 = r3.startsWith(r6)
            if (r5 == 0) goto L67
        L47:
            java.lang.String r5 = com.onetrust.otpublishers.headless.Internal.Helper.c.s(r3)
            boolean r5 = r0.has(r5)
            if (r5 != 0) goto L64
            boolean r5 = r3.startsWith(r6)
            if (r5 == 0) goto L62
            java.lang.String r5 = com.onetrust.otpublishers.headless.Internal.Helper.c.s(r3)
            boolean r5 = r1.has(r5)
            if (r5 == 0) goto L62
            goto L64
        L62:
            r5 = r11
            goto L65
        L64:
            r5 = r4
        L65:
            if (r5 == 0) goto L69
        L67:
            r5 = r4
            goto L6a
        L69:
            r5 = r11
        L6a:
            if (r5 == 0) goto L7d
            if (r9 != 0) goto L70
            r4 = r8
            goto L7a
        L70:
            com.onetrust.otpublishers.headless.Internal.Preferences.g r5 = r7.f21775e
            int r5 = r5.a(r3)
            if (r5 != r4) goto L79
            goto L7a
        L79:
            r4 = r11
        L7a:
            r7.q(r3, r4)
        L7d:
            int r2 = r2 + 1
            goto L2c
        L80:
            r11 = r4
            goto L8a
        L82:
            r8 = 6
            java.lang.String r9 = "No categories found to update"
            java.lang.String r10 = "CustomGroupDetails"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r10, r8, r9)
        L8a:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.k0.k(boolean, boolean, org.json.JSONArray, org.json.JSONObject):boolean");
    }

    public final int l(@NonNull String str) {
        boolean z10;
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        boolean z11;
        JSONObject jSONObject;
        int i10 = -1;
        try {
            if (this.f21773c.has(str)) {
                return this.f21773c.getInt(str);
            }
            Context context = this.f21771a;
            boolean zA = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            com.onetrust.otpublishers.headless.Internal.Preferences.h hVar2 = null;
            if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                z10 = false;
                hVar = null;
            }
            Context context2 = this.f21771a;
            SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (new com.onetrust.otpublishers.headless.Internal.profile.d(context2).t()) {
                hVar2 = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                sharedPreferences2 = hVar2;
            }
            String string = sharedPreferences2.getString("OTT_CULTURE_DOMAIN_DATA", "");
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e10) {
                    OTLogger.a("OneTrust", 6, "error while returning culture domain data, err: " + e10.getMessage());
                    jSONObject = new JSONObject();
                }
            }
            Context context3 = this.f21771a;
            String strS = c.s(str);
            if (z10) {
                sharedPreferences = hVar;
            }
            String string2 = sharedPreferences.getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
            try {
                zA = new com.onetrust.otpublishers.headless.Internal.Models.d(context3).a(jSONObject);
            } catch (JSONException e11) {
                OTLogger.a("IABHelper", 3, "error on checking reconsent for IAB status, " + e11);
            }
            try {
                if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                    JSONObject jSONObject2 = new JSONObject(string2);
                    if (!jSONObject2.getJSONObject("purposeLegitimateInterests").has(strS)) {
                        return -1;
                    }
                    if (!zA) {
                        i10 = jSONObject2.getJSONObject("purposeLegitimateInterests").getInt(strS);
                        return i10;
                    }
                }
            } catch (JSONException e12) {
                OTLogger.a("IABHelper", 3, "unable to get iab consent status" + e12);
            }
            return 1;
        } catch (JSONException e13) {
            p.a(e13, new StringBuilder("Error while getting updated value of Purpose Legit Interest "), "CustomGroupDetails", 6);
            return i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0105 A[SYNTHETIC] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.k0.m():java.lang.String");
    }

    public final void n(boolean z10, boolean z11) {
        String string = this.f21774d.getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        this.f21774d.getString("OTT_ALWAYS_ACTIVE_GROUPS", "");
        String string2 = this.f21774d.getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar = null;
        if (!this.f21774d.contains("OT_GROUP_ID_OBJECT")) {
            com.onetrust.otpublishers.headless.Internal.Preferences.g gVar = this.f21775e;
            gVar.getClass();
            JSONArray jSONArray = new JSONArray();
            String string3 = gVar.f21893a.c().getString("OTT_PC_DATA", null);
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string3)) {
                try {
                    jSONArray = new JSONObject(string3).getJSONArray("Groups");
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error on getting pc group array, message = "), "OTSPUtils", 6);
                }
            }
            k.c(jSONArray, this.f21774d);
        }
        String string4 = this.f21774d.getString("OT_GROUP_ID_OBJECT", "");
        try {
            JSONObject jSONObject = new JSONObject();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string4)) {
                jSONObject = new JSONObject(string4);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                jSONObject2 = new JSONObject(string);
            }
            boolean zK = k(z10, z11, jSONObject.names(), jSONObject2);
            boolean z12 = false;
            if (this.f21775e.f21893a.c().getBoolean("OT_GOOGLE_VENDORS_ENABLED_STATE", false) && !z11) {
                a.d(this.f21774d, this.f21775e, z10);
            }
            l0.a(z10, z11, this.f21775e);
            Context context = this.f21771a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (new com.onetrust.otpublishers.headless.Internal.profile.d(context).t()) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z12 = true;
            }
            if (z12) {
                sharedPreferences = hVar;
            }
            g(z10, z11, jSONObject2, !"LIActiveIfLegalBasis".equalsIgnoreCase(sharedPreferences.getString("OT_SDK_REJECT_ALL_TYPE", "ObjectToLI")));
            h(z10, z11, zK, string2);
            f(z11, true);
        } catch (JSONException e11) {
            p.a(e11, new StringBuilder("error while fetching all categories"), "CustomGroupDetails", 6);
        }
    }

    public final boolean o(@NonNull String str, boolean z10) {
        try {
            if (this.f21775e.k(str)) {
                OTLogger.a("CustomGroupDetails", 4, "Consent not updated for Always Active group : " + str);
                return false;
            }
            this.f21772b.put(str, z10 ? 1 : 0);
            OTLogger.a("CustomGroupDetails", 3, "Consent updated for group : " + str + " with value : " + z10);
            return true;
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error in updating consent status. err = "), "CustomGroupDetails", 6);
            return false;
        }
    }

    public final void p() {
        if (this.f21774d.getBoolean("OT_HAS_GROUP_CONFIG_CHANGED", false)) {
            this.f21774d.edit().putBoolean("OT_HAS_GROUP_CONFIG_CHANGED", false).apply();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(@androidx.annotation.NonNull java.lang.String r9, boolean r10) {
        /*
            r8 = this;
            android.content.Context r0 = r8.f21771a
            java.lang.String r1 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r2 = 0
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)
            boolean r3 = com.onetrust.otpublishers.headless.Internal.Helper.l.a(r0)
            java.lang.String r4 = ""
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L20
            java.lang.String r3 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r3 = r1.getString(r3, r4)
            com.onetrust.otpublishers.headless.Internal.Preferences.h r7 = new com.onetrust.otpublishers.headless.Internal.Preferences.h
            r7.<init>(r0, r1, r3)
            r0 = r5
            goto L22
        L20:
            r0 = r2
            r7 = r6
        L22:
            if (r0 == 0) goto L25
            r1 = r7
        L25:
            java.lang.String r0 = "OTT_CONSENT_STATUS"
            java.lang.String r0 = r1.getString(r0, r4)
            r1 = 4
            if (r0 == 0) goto L5a
            boolean r3 = com.onetrust.otpublishers.headless.Internal.c.q(r0)
            if (r3 != 0) goto L5a
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r4 = r9.toLowerCase(r3)
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4b
            java.lang.String r0 = r0.toLowerCase(r3)     // Catch: org.json.JSONException -> L4b
            r7.<init>(r0)     // Catch: org.json.JSONException -> L4b
            boolean r0 = r7.has(r4)     // Catch: org.json.JSONException -> L4a
            if (r0 == 0) goto L61
            goto L62
        L4a:
            r6 = r7
        L4b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "error in json parsing for customGroup Value = "
            r0.<init>(r3)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            goto L5c
        L5a:
            java.lang.String r0 = "customGroup Value not set."
        L5c:
            java.lang.String r3 = "OTSPUtils"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r3, r1, r0)
        L61:
            r5 = r2
        L62:
            if (r5 == 0) goto L6e
            boolean r0 = r8.o(r9, r10)
            if (r0 == 0) goto L6d
            r8.e(r9, r10)
        L6d:
            return r0
        L6e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Group ID doesn't exist/not allowed to update status for "
            r10.<init>(r0)
            r10.append(r9)
            java.lang.String r9 = " groupId."
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.String r10 = "CustomGroupDetails"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r10, r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.k0.q(java.lang.String, boolean):boolean");
    }
}
