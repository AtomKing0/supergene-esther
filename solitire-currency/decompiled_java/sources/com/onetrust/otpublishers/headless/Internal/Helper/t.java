package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.common.Scopes;
import com.ironsource.f5;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.g f21803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Models.d f21804d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONArray f21806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONArray f21807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e0 f21809i = new e0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21805e = false;

    public t(@NonNull Context context) {
        this.f21801a = context;
        this.f21802b = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        this.f21803c = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
        this.f21804d = new com.onetrust.otpublishers.headless.Internal.Models.d(context);
    }

    public static void D(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        w("MainText", jSONObject, jSONObject2);
        w("MainInfoText", jSONObject, jSONObject2);
        w("AboutText", jSONObject, jSONObject2);
        w("AboutLink", jSONObject, jSONObject2);
        w("AlwaysActiveText", jSONObject, jSONObject2);
        w("VendorLevelOptOut", jSONObject, jSONObject2);
        w("PreferenceCenterPosition", jSONObject, jSONObject2);
        w("PreferenceCenterConfirmText", jSONObject, jSONObject2);
        w("VendorListText", jSONObject, jSONObject2);
        w("PCGrpDescLinkPosition", jSONObject, jSONObject2);
        w("ThirdPartyCookieListText", jSONObject, jSONObject2);
        w("PreferenceCenterManagePreferencesText", jSONObject, jSONObject2);
        c("ShowPreferenceCenterCloseButton", jSONObject, jSONObject2);
        w("CloseText", jSONObject, jSONObject2);
        w("AddLinksToCookiepedia", jSONObject, jSONObject2);
        w("CookieListEnabled", jSONObject, jSONObject2);
        w("Center", jSONObject, jSONObject2);
        w("Panel", jSONObject, jSONObject2);
        w("Popup", jSONObject, jSONObject2);
        w("List", jSONObject, jSONObject2);
        w("Tab", jSONObject, jSONObject2);
        w("PCFirstPartyCookieListText", jSONObject, jSONObject2);
        w("PCViewCookiesText", jSONObject, jSONObject2);
        w("PCenterBackText", jSONObject, jSONObject2);
        w("PCenterVendorsListText", jSONObject, jSONObject2);
        w("PCIABVendorsText", jSONObject, jSONObject2);
        w("PCenterViewPrivacyPolicyText", jSONObject, jSONObject2);
        w("PCenterClearFiltersText", jSONObject, jSONObject2);
        w("PCenterApplyFiltersText", jSONObject, jSONObject2);
        w("PCenterAllowAllConsentText", jSONObject, jSONObject2);
        w("PCenterRejectAllButtonText", jSONObject, jSONObject2);
        c("PCenterShowRejectAllButton", jSONObject, jSONObject2);
        w("ConfirmText", jSONObject, jSONObject2);
        w("PCenterCookiesListText", jSONObject, jSONObject2);
        w("PCenterCancelFiltersText", jSONObject, jSONObject2);
        c("PCenterEnableAccordion", jSONObject, jSONObject2);
        c("IsIabEnabled", jSONObject, jSONObject2);
        w("PCGrpDescType", jSONObject, jSONObject2);
        w("PCVendorFullLegalText", jSONObject, jSONObject2);
        w("IabType", jSONObject, jSONObject2);
        w("PCenterVendorListDescText", jSONObject, jSONObject2);
        w("PCPrivacyLinkActionAriaLabel", jSONObject, jSONObject2);
        w("PCLogoScreenReader", jSONObject, jSONObject2);
        w("PCDSIDCopyAriaLabel", jSONObject, jSONObject2);
        w("CloseText", jSONObject, jSONObject2);
        w("PCenterVendorListSearch", jSONObject, jSONObject2);
        w("PCenterCookieListSearch", jSONObject, jSONObject2);
        w("PCenterVendorListFilterAria", jSONObject, jSONObject2);
        w("PCenterCookieListFilterAria", jSONObject, jSONObject2);
        w("PCVendorListFilterUnselectedAriaLabel", jSONObject, jSONObject2);
        w("PCVendorListFilterSelectedAriaLabel", jSONObject, jSONObject2);
        w("PCIllusText", jSONObject, jSONObject2);
        jSONObject.put("PCenterViewPrivacyPolicyText", jSONObject2.optString("PCenterViewPrivacyPolicyText", ""));
        jSONObject.put("PCenterVendorListLifespan", jSONObject2.optString("PCenterVendorListLifespan", ""));
        jSONObject.put("PCenterVendorListDisclosure", jSONObject2.optString("PCenterVendorListDisclosure", ""));
        jSONObject.put("PCenterVendorListNonCookieUsage", jSONObject2.optString("PCenterVendorListNonCookieUsage", ""));
        jSONObject.put("PCenterVendorListLifespanDay", jSONObject2.optString("PCenterVendorListLifespanDay", ""));
        jSONObject.put("PCenterVendorListLifespanDays", jSONObject2.optString("PCenterVendorListLifespanDays", ""));
        jSONObject.put("PCenterVendorListLifespanMonth", jSONObject2.optString("PCenterVendorListLifespanMonth", ""));
        jSONObject.put("PCenterVendorListLifespanMonths", jSONObject2.optString("PCenterVendorListLifespanMonths", ""));
        jSONObject.put("PCenterVendorListStorageIdentifier", jSONObject2.optString("PCenterVendorListStorageIdentifier", ""));
        jSONObject.put("PCenterVendorListStorageType", jSONObject2.optString("PCenterVendorListStorageType", ""));
        jSONObject.put("PCenterVendorListStorageDomain", jSONObject2.optString("PCenterVendorListStorageDomain", ""));
        jSONObject.put("PCenterVendorListStoragePurposes", jSONObject2.optString("PCenterVendorListStoragePurposes", ""));
        jSONObject.put("UseGoogleVendors", jSONObject2.optBoolean("UseGoogleVendors", false));
        jSONObject.put("PCVLSDomainsUsed", jSONObject2.optString("PCVLSDomainsUsed", ""));
        jSONObject.put("PCVLSUse", jSONObject2.optString("PCVLSUse", ""));
        jSONObject.put("PCVListDataDeclarationText", jSONObject2.optString("PCVListDataDeclarationText", ""));
        jSONObject.put("PCVListDataRetentionText", jSONObject2.optString("PCVListDataRetentionText", ""));
        jSONObject.put("PCVListStdRetentionText", jSONObject2.optString("PCVListStdRetentionText", ""));
        jSONObject.put("PCIABVendorLegIntClaimText", jSONObject2.optString("PCIABVendorLegIntClaimText", ""));
        jSONObject.put("SDKLanguageCode", c.y(jSONObject2));
        jSONObject.put("PCVendorsCountText", jSONObject2.optString("PCVendorsCountText", ""));
        jSONObject.put("PCVendorsCountFeatureText", jSONObject2.optString("PCVendorsCountFeatureText", ""));
        jSONObject.put("PCVendorsCountSpcFeatureText", jSONObject2.optString("PCVendorsCountSpcFeatureText", ""));
        jSONObject.put("PCVendorsCountSpcPurposeText", jSONObject2.optString("PCVendorsCountSpcPurposeText", ""));
    }

    @NonNull
    public static JSONArray a(@NonNull List list, @NonNull JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    com.onetrust.otpublishers.headless.UI.mobiledatautils.f.d(i10, jSONArray, jSONArray2, new JSONObject());
                } catch (JSONException e10) {
                    OTLogger.a("OTSDKListFilter", 6, "Error on parsing Categories list. Error msg = " + e10.getMessage());
                }
            }
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                if (jSONArray2.getJSONObject(i11).has("CustomGroupId")) {
                    arrayList.add(jSONArray2.getJSONObject(i11).getString("CustomGroupId"));
                }
            }
        } catch (JSONException e11) {
            n.a(e11, new StringBuilder("error while computing all categories e:"), "OTData", 6);
        }
        if (list.isEmpty()) {
            list = arrayList;
        }
        JSONArray jSONArray3 = new JSONArray();
        for (int i12 = 0; i12 < list.size(); i12++) {
            try {
                g(jSONArray, jSONArray3, ((String) list.get(i12)).trim());
            } catch (JSONException e12) {
                p.a(e12, new StringBuilder("Error on parsing SDK list. Error msg = "), "OTData", 6);
            }
        }
        OTLogger.a("ContentValues", 3, "getSDKList Final: " + jSONArray3);
        return jSONArray3;
    }

    public static void c(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        if (jSONObject2.has(str)) {
            try {
                jSONObject.put(str, jSONObject2.getBoolean(str));
            } catch (JSONException e10) {
                StringBuilder sb = new StringBuilder("Error in appending pc boolean data. key = ");
                sb.append(str);
                sb.append("Error message : ");
                p.a(e10, sb, "OTData", 6);
            }
        }
    }

    public static void e(@NonNull JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Name", jSONArray2.getJSONObject(i10).getString("Name"));
            jSONObject.put("SdkId", jSONArray2.getJSONObject(i10).getString("SdkId"));
            jSONObject.put("Description", jSONArray2.getJSONObject(i10).getString("Description"));
            jSONArray.put(jSONObject);
        }
    }

    public static void g(@NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, @NonNull String str) throws JSONException {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONArray jSONArray3 = jSONArray.getJSONObject(i10).getJSONArray("FirstPartyCookies");
            String strOptString = jSONArray.getJSONObject(i10).optString("CustomGroupId", "");
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            if (strOptString.equals(str)) {
                e(jSONArray2, jSONArray3);
                if (!jSONObject.has("SubGroups") || jSONObject.optBoolean("ShowSubgroup")) {
                    return;
                }
                for (int i11 = 0; i11 < jSONObject.getJSONArray("SubGroups").length(); i11++) {
                    e(jSONArray2, jSONObject.getJSONArray("SubGroups").getJSONObject(i11).getJSONArray("FirstPartyCookies"));
                }
                return;
            }
            if (jSONObject.has("SubGroups") && !com.onetrust.otpublishers.headless.Internal.a.c(jSONObject.getJSONArray("SubGroups"))) {
                for (int i12 = 0; i12 < jSONObject.getJSONArray("SubGroups").length(); i12++) {
                    JSONObject jSONObject2 = jSONObject.getJSONArray("SubGroups").getJSONObject(i12);
                    if (str.equalsIgnoreCase(jSONObject2.optString("CustomGroupId", ""))) {
                        e(jSONArray2, jSONObject2.getJSONArray("FirstPartyCookies"));
                    }
                }
            }
        }
    }

    public static void h(@NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, @NonNull JSONObject jSONObject, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, int i10, @NonNull JSONObject jSONObject2, @NonNull JSONArray jSONArray3) throws JSONException {
        String strOptString;
        if (com.onetrust.otpublishers.headless.Internal.c.q(jSONArray2.getJSONObject(i10).optString("PurposeId"))) {
            strOptString = "OT_PURPOSE_ID_" + i10;
        } else {
            jSONObject2.put("Id", jSONArray2.getJSONObject(i10).optString("PurposeId"));
            jSONObject2.put("TransactionType", oTPublishersHeadlessSDK.getConsentStatusForGroupId(jSONArray2.getJSONObject(i10).optString("CustomGroupId"), jSONArray2.getJSONObject(i10).getString("Status")) == 0 ? "NOTGIVEN" : "CONFIRMED");
            jSONArray.put(jSONObject2);
            strOptString = jSONArray2.getJSONObject(i10).optString("PurposeId");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("Id", jSONArray2.getJSONObject(i10).optString("PurposeId"));
            jSONObject3.put("TransactionType", jSONArray2.getJSONObject(i10).getString("Status").equals("inactive") ? "NOTGIVEN" : "CONFIRMED");
            jSONArray3.put(jSONObject3);
        }
        jSONObject.put(strOptString, jSONArray2.getJSONObject(i10).optString("CustomGroupId", ""));
    }

    public static void k(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        if (jSONObject2.has("IsIabEnabled") && jSONObject2.has("IabType")) {
            jSONObject.put("IsIabEnabled", jSONObject2.getBoolean("IsIabEnabled"));
            jSONObject.put("IabType", jSONObject2.getString("IabType"));
            if (!jSONObject2.getBoolean("IsIabEnabled") || "".equals(jSONObject2.getString("IabType"))) {
                return;
            }
            w("BannerDPDTitle", jSONObject, jSONObject2);
            if (!jSONObject2.has("BannerDPDDescription") || jSONObject2.isNull("BannerDPDDescription")) {
                return;
            }
            jSONObject.put("BannerDPDDescription", jSONObject2.get("BannerDPDDescription").toString());
        }
    }

    public static boolean n(@NonNull SharedPreferences sharedPreferences, @NonNull JSONObject jSONObject, boolean z10, @NonNull String str) {
        if (jSONObject.has(str) || z10) {
            return z10;
        }
        sharedPreferences.edit().putBoolean("OT_HAS_GROUP_CONFIG_CHANGED", true).apply();
        return true;
    }

    @VisibleForTesting
    public static boolean o(@NonNull SharedPreferences sharedPreferences, @NonNull JSONObject jSONObject, boolean z10, JSONObject jSONObject2, String str) {
        if (str == null) {
            return z10;
        }
        String strOptString = jSONObject2.optString(str.toLowerCase(Locale.ROOT));
        OTLogger.a("OTData", 3, "hasGrpConfigChanged: group type - " + strOptString + "group -" + str);
        return (com.onetrust.otpublishers.headless.Internal.c.q(strOptString) || "BRANCH".equalsIgnoreCase(strOptString) || strOptString.equalsIgnoreCase("IAB2_STACK") || strOptString.equalsIgnoreCase("IAB2V2_STACK")) ? z10 : n(sharedPreferences, jSONObject, z10, str);
    }

    public static boolean q(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull JSONObject jSONObject, boolean z10) throws JSONException {
        int i10 = ("OPT_OUT".equalsIgnoreCase(str2) || "PENDING".equalsIgnoreCase(str2) || "EXPIRED".equalsIgnoreCase(str2) || "WITHDRAWN".equalsIgnoreCase(str2)) ? 0 : "ACTIVE".equalsIgnoreCase(str2) ? 1 : -1;
        if (i10 == -1 || i10 == jSONObject.getInt(str3)) {
            return z10;
        }
        OTLogger.a("OTData", 4, "Status setting to " + i10 + ", groupID = " + str3 + ", purpose id = " + str);
        jSONObject.put(str3, i10);
        return true;
    }

    public static boolean r(@NonNull String str, @NonNull String str2, @NonNull JSONObject jSONObject, boolean z10) throws JSONException {
        int i10 = ("OPT_OUT".equalsIgnoreCase(str2) || "PENDING".equalsIgnoreCase(str2) || "EXPIRED".equalsIgnoreCase(str2) || "WITHDRAWN".equalsIgnoreCase(str2)) ? 0 : "ACTIVE".equalsIgnoreCase(str2) ? 1 : -1;
        if (!jSONObject.has(str) || i10 == -1 || i10 == jSONObject.getInt(str)) {
            return z10;
        }
        OTLogger.a("OTData", 4, "Parent status setting to " + i10 + ", groupID = " + str);
        jSONObject.put(str, i10);
        return true;
    }

    @VisibleForTesting
    public static boolean s(@NonNull JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(Scopes.PROFILE)) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(Scopes.PROFILE);
        if (!jSONObject2.has("sync")) {
            return false;
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject("sync");
        if (jSONObject3.has("shouldShowBannerAsConsentExpired")) {
            return jSONObject3.getBoolean("shouldShowBannerAsConsentExpired");
        }
        return false;
    }

    public static void w(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        if (jSONObject2.has(str)) {
            try {
                jSONObject.put(str, jSONObject2.getString(str));
            } catch (JSONException e10) {
                StringBuilder sb = new StringBuilder("Error in appending pc data key. key = ");
                sb.append(str);
                sb.append("Error message : ");
                p.a(e10, sb, "OTData", 6);
            }
        }
    }

    public static void z(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) throws JSONException {
        w("PcTextColor", jSONObject, jSONObject2);
        w("PcButtonColor", jSONObject, jSONObject2);
        w("PcButtonColor", jSONObject, jSONObject2);
        w("PcButtonTextColor", jSONObject, jSONObject2);
        w("PcBackgroundColor", jSONObject, jSONObject2);
        w("PcMenuColor", jSONObject, jSONObject2);
        w("PcMenuHighLightColor", jSONObject, jSONObject2);
        w("PcLinksTextColor", jSONObject, jSONObject2);
        w("OptanonLogo", jSONObject, jSONObject2);
        c("ShowCookieList", jSONObject, jSONObject2);
        c("PCShowCookieHost", jSONObject, jSONObject2);
        c("PCShowCookieDuration", jSONObject, jSONObject2);
        c("PCShowCookieType", jSONObject, jSONObject2);
        c("PCShowCookieCategory", jSONObject, jSONObject2);
        w("BConsentText", jSONObject, jSONObject2);
        w("BLegitInterestText", jSONObject, jSONObject2);
        if (jSONObject2.has("PCShowCookieDescription") && !jSONObject2.isNull("PCShowCookieDescription")) {
            jSONObject.put("PCShowCookieDescription", jSONObject2.get("PCShowCookieDescription").toString());
        }
        w("AllowHostOptOut", jSONObject, jSONObject2);
        w("IabLegalTextUrl", jSONObject, jSONObject2);
        jSONObject.put("BConsentPurposesText", jSONObject2.optString("BConsentPurposesText", ""));
        jSONObject.put("BLegitimateInterestPurposesText", jSONObject2.optString("BLegitimateInterestPurposesText", ""));
        jSONObject.put("BSpecialFeaturesText", jSONObject2.optString("BSpecialFeaturesText", ""));
        jSONObject.put("BSpecialPurposesText", jSONObject2.optString("BSpecialPurposesText", ""));
        jSONObject.put("BFeaturesText", jSONObject2.optString("BFeaturesText", ""));
    }

    public final boolean A(@NonNull String str, boolean z10) {
        boolean zT = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(v8.i.D)) {
                String strOptString = jSONObject.getJSONObject(v8.i.D).getJSONObject("ruleDetails").optString("type", "");
                e0 e0Var = this.f21809i;
                com.onetrust.otpublishers.headless.Internal.Preferences.e eVar = this.f21802b;
                e0Var.getClass();
                e0.d(eVar, strOptString);
                this.f21803c.f(jSONObject.getJSONObject(v8.i.D).optBoolean("AuthenticatedConsent"));
            }
            if (!jSONObject.has("culture")) {
                return false;
            }
            zT = t(jSONObject, z10);
            y(jSONObject);
            return zT;
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error in formatting ott data with err = "), "OTData", 6);
            return zT;
        }
    }

    @VisibleForTesting
    public final void B(@NonNull String str, boolean z10) {
        if (z10) {
            try {
                if (s(new JSONObject(str))) {
                    return;
                }
                new e(this.f21801a).e();
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error while parsing ottWholeData, error = "), "OTData", 6);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(@androidx.annotation.NonNull org.json.JSONObject r7) {
        /*
            r6 = this;
            java.lang.String r0 = "general"
            java.lang.String r1 = "googleAd"
            java.lang.String r2 = "enableConsent"
            java.lang.String r3 = "prompts"
            r4 = 0
            boolean r5 = r7.has(r3)     // Catch: org.json.JSONException -> L2d
            if (r5 == 0) goto L3b
            org.json.JSONObject r7 = r7.getJSONObject(r3)     // Catch: org.json.JSONException -> L2d
            boolean r3 = r7.has(r1)     // Catch: org.json.JSONException -> L2d
            if (r3 == 0) goto L28
            org.json.JSONObject r7 = r7.getJSONObject(r1)     // Catch: org.json.JSONException -> L2d
            boolean r1 = r7.has(r0)     // Catch: org.json.JSONException -> L2d
            if (r1 == 0) goto L28
            org.json.JSONObject r7 = r7.getJSONObject(r0)     // Catch: org.json.JSONException -> L2d
            goto L29
        L28:
            r7 = r4
        L29:
            if (r7 == 0) goto L3b
            r4 = r7
            goto L3b
        L2d:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error in  parse GoogleAddGeneralData , message = "
            r0.<init>(r1)
            java.lang.String r1 = "AppDataParser"
            r3 = 4
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(r7, r0, r1, r3)
        L3b:
            if (r4 == 0) goto L6f
            boolean r7 = r4.has(r2)     // Catch: org.json.JSONException -> L61
            if (r7 == 0) goto L53
            boolean r7 = r4.getBoolean(r2)     // Catch: org.json.JSONException -> L61
            if (r7 == 0) goto L53
            android.content.Context r7 = r6.f21801a     // Catch: org.json.JSONException -> L61
            boolean r7 = com.onetrust.otpublishers.headless.Internal.c.u(r7)     // Catch: org.json.JSONException -> L61
            if (r7 == 0) goto L53
            r7 = 1
            goto L54
        L53:
            r7 = 0
        L54:
            if (r7 == 0) goto L6f
            com.onetrust.otpublishers.headless.Internal.Helper.p0 r7 = new com.onetrust.otpublishers.headless.Internal.Helper.p0     // Catch: org.json.JSONException -> L61
            r7.<init>()     // Catch: org.json.JSONException -> L61
            android.content.Context r0 = r6.f21801a     // Catch: org.json.JSONException -> L61
            r7.e(r0, r4)     // Catch: org.json.JSONException -> L61
            goto L6f
        L61:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error on checking google add consent logging state. Error = "
            r0.<init>(r1)
            java.lang.String r1 = "GoogleAdInfo"
            r2 = 6
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(r7, r0, r1, r2)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.t.C(org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(@androidx.annotation.NonNull java.lang.String r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.t.E(java.lang.String, boolean):void");
    }

    @VisibleForTesting
    public final void F(@NonNull JSONObject jSONObject) throws JSONException {
        String str;
        JSONArray jSONArray;
        t tVar = this;
        String str2 = "UCPurposesDataHandler";
        String strOptString = "";
        String string = tVar.f21802b.c().getString("OT_UC_PURPOSES_UI_SERVER_DATA", "");
        JSONObject jSONObject2 = new JSONObject(tVar.f21802b.c().getString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", ""));
        JSONObject jSONObject3 = new JSONObject(tVar.f21802b.c().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", ""));
        JSONObject jSONObject4 = new JSONObject(tVar.f21802b.c().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", ""));
        JSONObject jSONObject5 = new JSONObject(string);
        if (jSONObject5.has(OTVendorListMode.GENERAL)) {
            JSONObject jSONObject6 = jSONObject5.getJSONObject(OTVendorListMode.GENERAL);
            if (jSONObject6.has(f5.f12054u)) {
                strOptString = jSONObject6.optString(f5.f12054u);
            }
        }
        if (!com.onetrust.otpublishers.headless.Internal.b.a(strOptString)) {
            OTLogger.a("OTData", 3, "UCP is not enabled from Admin UI for this app id!");
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        if (jSONObject.has(Scopes.PROFILE)) {
            JSONObject jSONObject7 = jSONObject.getJSONObject(Scopes.PROFILE);
            if (jSONObject7.has("sync")) {
                JSONObject jSONObject8 = jSONObject7.getJSONObject("sync");
                if (jSONObject8.has("ucpreferences")) {
                    jSONArray2 = jSONObject8.getJSONArray("ucpreferences");
                }
            }
        }
        int i10 = 0;
        while (i10 < jSONArray2.length()) {
            JSONObject jSONObject9 = jSONArray2.getJSONObject(i10);
            String string2 = jSONObject9.getString("id");
            String string3 = jSONObject9.getString("status");
            JSONArray jSONArray3 = jSONObject9.getJSONArray("topics");
            JSONObject jSONObject10 = jSONObject9.getJSONObject("customPreferences");
            if (jSONObject2.has(string2)) {
                w wVar = new w(tVar.f21801a);
                boolean zEquals = string3.equals("ACTIVE");
                try {
                    JSONObject jSONObjectOptJSONObject = wVar.f21813d.optJSONObject(string2);
                    if (wVar.f21813d.has(string2)) {
                        jSONObjectOptJSONObject.put("userConsentStatus", zEquals ? "ACTIVE" : "OPT_OUT");
                    } else {
                        OTLogger.a(str2, 5, "Invalid ID passed to update UCP Consent values");
                    }
                    OTLogger.a(str2, 3, "Updated purpose object : " + wVar.f21813d.optJSONObject(string2));
                    u.b(wVar.f21810a, wVar.f21813d, wVar.f21815f, wVar.f21814e);
                    wVar.r(wVar.f21813d);
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error in updating consent for purposes :"), str2, 6);
                }
                JSONArray jSONArrayS = wVar.s(string2);
                for (int i11 = 0; i11 < jSONArrayS.length(); i11++) {
                    JSONObject jSONObject11 = jSONArrayS.getJSONObject(i11);
                    wVar.q(jSONObject11.optString("purposeTopicId"), jSONObject11.optString("id"), false);
                }
                if (jSONArray3.length() > 0) {
                    int i12 = 0;
                    while (i12 < jSONArray3.length()) {
                        String strOptString2 = jSONArray3.optString(i12);
                        String str3 = strOptString2 + string2;
                        JSONArray jSONArrayS2 = wVar.s(string2);
                        String str4 = str2;
                        JSONArray jSONArray4 = jSONArray2;
                        for (int i13 = 0; i13 < jSONArrayS2.length(); i13++) {
                            if (jSONArrayS2.getJSONObject(i13).getString("purposeTopicId").equals(str3) && jSONObject3.has(str3)) {
                                wVar.q(str3, strOptString2, true);
                            }
                        }
                        i12++;
                        str2 = str4;
                        jSONArray2 = jSONArray4;
                    }
                }
                str = str2;
                jSONArray = jSONArray2;
                if (jSONObject10.length() > 0) {
                    Iterator<String> itKeys = jSONObject10.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayN = wVar.n(next);
                        for (int i14 = 0; i14 < jSONArrayN.length(); i14++) {
                            JSONObject jSONObject12 = jSONArrayN.getJSONObject(i14);
                            wVar.h(jSONObject12.optString("customPreferenceId"), jSONObject12.optString("purposeOptionsId"), false);
                        }
                        int i15 = 0;
                        JSONArray jSONArrayC = wVar.c(string2);
                        int i16 = 0;
                        while (i16 < jSONArrayC.length()) {
                            if (jSONArrayC.getJSONObject(i16).getString("id").equals(next) && string2.equals(jSONArrayC.getJSONObject(i16).getString("purposeId"))) {
                                JSONArray jSONArray5 = new JSONArray(jSONObject10.getString(next));
                                if (jSONArray5.length() > 0) {
                                    int i17 = i15;
                                    while (i17 < jSONArray5.length()) {
                                        String strOptString3 = jSONArray5.optString(i17);
                                        Iterator<String> it = itKeys;
                                        JSONArray jSONArrayN2 = wVar.n(next);
                                        JSONArray jSONArray6 = jSONArrayC;
                                        JSONObject jSONObject13 = jSONObject2;
                                        int i18 = 0;
                                        while (i18 < jSONArrayN2.length()) {
                                            String str5 = strOptString3 + string2 + next;
                                            JSONObject jSONObject14 = jSONObject3;
                                            if (jSONArrayN2.getJSONObject(i18).getString("purposeOptionsId").equals(str5) && jSONObject4.has(str5)) {
                                                wVar.h(next, str5, true);
                                            }
                                            i18++;
                                            jSONObject3 = jSONObject14;
                                        }
                                        i17++;
                                        itKeys = it;
                                        jSONArrayC = jSONArray6;
                                        jSONObject2 = jSONObject13;
                                        jSONObject3 = jSONObject3;
                                    }
                                }
                            }
                            i16++;
                            itKeys = itKeys;
                            jSONArrayC = jSONArrayC;
                            jSONObject2 = jSONObject2;
                            jSONObject3 = jSONObject3;
                            i15 = 0;
                        }
                    }
                }
            } else {
                str = str2;
                jSONArray = jSONArray2;
            }
            i10++;
            tVar = this;
            str2 = str;
            jSONArray2 = jSONArray;
            jSONObject2 = jSONObject2;
            jSONObject3 = jSONObject3;
        }
    }

    public final void b() {
        JSONObject jSONObject;
        JSONArray jSONArrayNames;
        JSONObject jSONObject2;
        JSONArray jSONArrayNames2;
        JSONObject jSONObject3;
        JSONArray jSONArrayNames3;
        String string = this.f21802b.c().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject(string);
            if (jSONObject4.has("purposes") && (jSONArrayNames3 = (jSONObject3 = jSONObject4.getJSONObject("purposes")).names()) != null) {
                for (int i10 = 0; i10 < jSONObject3.length(); i10++) {
                    jSONObject3.put(jSONArrayNames3.getString(i10), 0);
                }
                jSONObject4.put("purposes", jSONObject3);
            }
            if (jSONObject4.has("purposeLegitimateInterests") && (jSONArrayNames2 = (jSONObject2 = jSONObject4.getJSONObject("purposeLegitimateInterests")).names()) != null) {
                for (int i11 = 0; i11 < jSONObject2.length(); i11++) {
                    jSONObject2.put(jSONArrayNames2.getString(i11), 1);
                }
                jSONObject4.put("purposeLegitimateInterests", jSONObject2);
            }
            if (jSONObject4.has("special_feature_opt_ins") && (jSONArrayNames = (jSONObject = jSONObject4.getJSONObject("special_feature_opt_ins")).names()) != null) {
                for (int i12 = 0; i12 < jSONObject.length(); i12++) {
                    jSONObject.put(jSONArrayNames.getString(i12), 0);
                }
                jSONObject4.put("special_feature_opt_ins", jSONObject);
            }
            this.f21802b.c().edit().putString("OTT_IAB_CONSENTABLE_PURPOSES", jSONObject4.toString()).apply();
            OTLogger.a("OTData", 3, "iab related values cleared on auto re-consent");
        } catch (JSONException e10) {
            n.a(e10, new StringBuilder("Error when setting IAB default values on auto reconsent,"), "OTData", 6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #0 {Exception -> 0x0070, blocks: (B:15:0x0038, B:17:0x0044, B:22:0x0065, B:24:0x006b, B:21:0x0060, B:20:0x004b), top: B:36:0x0038, outer: #1, inners: #2 }] */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(@androidx.annotation.NonNull java.lang.String r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "OneTrust"
            if (r8 == 0) goto Lb6
            r8 = 6
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> La9
            r1.<init>(r7)     // Catch: org.json.JSONException -> La9
            boolean r7 = s(r1)     // Catch: org.json.JSONException -> La9
            if (r7 == 0) goto Lb6
            android.content.Context r7 = r6.f21801a     // Catch: org.json.JSONException -> La9
            java.lang.String r1 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER"
            r2 = 0
            android.content.SharedPreferences r1 = r7.getSharedPreferences(r1, r2)     // Catch: org.json.JSONException -> La9
            com.onetrust.otpublishers.headless.Internal.profile.d r3 = new com.onetrust.otpublishers.headless.Internal.profile.d     // Catch: org.json.JSONException -> La9
            r3.<init>(r7)     // Catch: org.json.JSONException -> La9
            boolean r3 = r3.t()     // Catch: org.json.JSONException -> La9
            java.lang.String r4 = ""
            if (r3 == 0) goto L33
            java.lang.String r3 = "OT_ACTIVE_PROFILE_ID"
            java.lang.String r3 = r1.getString(r3, r4)     // Catch: org.json.JSONException -> La9
            com.onetrust.otpublishers.headless.Internal.Preferences.h r5 = new com.onetrust.otpublishers.headless.Internal.Preferences.h     // Catch: org.json.JSONException -> La9
            r5.<init>(r7, r1, r3)     // Catch: org.json.JSONException -> La9
            r7 = 1
            goto L35
        L33:
            r5 = 0
            r7 = r2
        L35:
            if (r7 == 0) goto L38
            r1 = r5
        L38:
            java.lang.String r7 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r7 = r1.getString(r7, r4)     // Catch: java.lang.Exception -> L70
            boolean r1 = com.onetrust.otpublishers.headless.Internal.c.q(r7)     // Catch: java.lang.Exception -> L70
            if (r1 != 0) goto L60
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4a java.lang.Exception -> L70
            r1.<init>(r7)     // Catch: org.json.JSONException -> L4a java.lang.Exception -> L70
            goto L65
        L4a:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L70
            java.lang.String r3 = "error while returning culture domain data, err: "
            r1.<init>(r3)     // Catch: java.lang.Exception -> L70
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Exception -> L70
            r1.append(r7)     // Catch: java.lang.Exception -> L70
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Exception -> L70
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r8, r7)     // Catch: java.lang.Exception -> L70
        L60:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L70
            r1.<init>()     // Catch: java.lang.Exception -> L70
        L65:
            int r7 = r1.length()     // Catch: java.lang.Exception -> L70
            if (r7 <= 0) goto L87
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Exception -> L70
            goto L87
        L70:
            r7 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> La9
            java.lang.String r3 = "empty data as SDK not yet initialized "
            r1.<init>(r3)     // Catch: org.json.JSONException -> La9
            java.lang.String r7 = r7.getMessage()     // Catch: org.json.JSONException -> La9
            r1.append(r7)     // Catch: org.json.JSONException -> La9
            java.lang.String r7 = r1.toString()     // Catch: org.json.JSONException -> La9
            r1 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.a(r0, r1, r7)     // Catch: org.json.JSONException -> La9
        L87:
            boolean r7 = com.onetrust.otpublishers.headless.Internal.c.q(r4)     // Catch: org.json.JSONException -> La9
            if (r7 == 0) goto L8e
            return
        L8e:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> La9
            r7.<init>(r4)     // Catch: org.json.JSONException -> La9
            com.onetrust.otpublishers.headless.Internal.Helper.t r0 = new com.onetrust.otpublishers.headless.Internal.Helper.t     // Catch: org.json.JSONException -> La9
            android.content.Context r1 = r6.f21801a     // Catch: org.json.JSONException -> La9
            r0.<init>(r1)     // Catch: org.json.JSONException -> La9
            java.lang.String r1 = "Groups"
            org.json.JSONArray r7 = r7.getJSONArray(r1)     // Catch: org.json.JSONException -> La9
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> La9
            r1.<init>()     // Catch: org.json.JSONException -> La9
            r0.j(r7, r1, r2)     // Catch: org.json.JSONException -> La9
            return
        La9:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error on cleanUpIabIfPurposeIfConsentExpired, error: "
            r0.<init>(r1)
            java.lang.String r1 = "OTData"
            com.onetrust.otpublishers.headless.Internal.Helper.p.a(r7, r0, r1, r8)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.t.d(java.lang.String, boolean):void");
    }

    public final void f(@NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, int i10) throws JSONException {
        JSONObject jSONObject = jSONArray2.getJSONObject(i10);
        if (jSONObject.has("SubGroups")) {
            if (jSONObject.getBoolean("ShowInPopup")) {
                jSONArray.put(jSONObject);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = jSONArray2.getJSONObject(i10);
        if (jSONObject2.getString("Type").equals("COOKIE") && jSONObject2.getString("Parent").isEmpty()) {
            if (jSONObject2.getJSONArray("FirstPartyCookies").length() <= 0) {
                return;
            }
        } else if (!jSONObject2.getBoolean("IsIabPurpose") || !jSONObject2.getString("Parent").isEmpty() || !jSONObject2.getBoolean("ShowInPopup") || !e0.h(jSONObject2, this.f21808h)) {
            return;
        }
        jSONArray.put(jSONObject2);
    }

    public final void i(@NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull JSONObject jSONObject3) throws JSONException {
        jSONObject.getJSONObject("consentPayload").put("purposes", jSONArray);
        jSONObject2.getJSONObject("consentPayload").put("purposes", jSONArray);
        SharedPreferences.Editor editorEdit = this.f21802b.c().edit();
        editorEdit.putString("OTT_CONSENT_LOG_DATA", jSONObject.toString());
        editorEdit.putString("OT_CL_DEFAULT_PAYLOAD", jSONObject2.toString());
        editorEdit.putString("OTT_INTERNAL_PURPOSE_GROUP_MAP", jSONObject3.toString());
        editorEdit.apply();
    }

    public final void j(@NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject, boolean z10) {
        try {
            JSONObject jSONObject2 = new JSONObject(this.f21802b.c().getString("OTT_CONSENT_STATUS", JsonUtils.EMPTY_JSON));
            if (!z10) {
                b();
                jSONObject = jSONObject2;
            }
            if (jSONArray.length() > 0) {
                x(jSONArray, jSONObject, z10);
            }
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("error while clearing IAB values on re-consent, err : "), "OTData", 6);
        }
        Context context = this.f21801a;
        OTLogger.a("GoogleVendorHelper", 3, "Resetting user consent on Google vendor list.");
        com.onetrust.otpublishers.headless.Internal.Preferences.e eVar = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        String string = eVar.c().getString("OT_GOOGLE_GVL_COMPLETE_OBJECT", null);
        JSONObject jSONObject3 = new JSONObject();
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return;
        }
        try {
            jSONObject3 = new JSONObject(string);
        } catch (JSONException e11) {
            p.a(e11, new StringBuilder("Error on parsing google vendors on clearUserConsent, error = "), "GoogleVendorHelper", 6);
        }
        a.b(context, eVar, new JSONObject(), jSONObject3);
    }

    public final void l(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, @NonNull JSONObject jSONObject3, boolean z10, @NonNull JSONObject jSONObject4) throws JSONException {
        if (jSONObject3.has("CustomGroupId")) {
            String string = jSONObject3.getString("CustomGroupId");
            if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                return;
            }
            jSONObject.put(string.toLowerCase(Locale.ENGLISH), -1);
            if (jSONObject3.getString("Status").contains("always")) {
                jSONObject4.put(string, jSONObject3.getString("Status"));
            }
            boolean z11 = false;
            if (jSONObject3.has("SubGroups")) {
                JSONArray jSONArray3 = jSONObject3.getJSONArray("SubGroups");
                for (int i10 = 0; i10 < jSONArray3.length(); i10++) {
                    JSONObject jSONObject5 = jSONArray3.getJSONObject(i10);
                    if (jSONObject5.has("CustomGroupId")) {
                        String string2 = jSONObject5.getString("CustomGroupId");
                        jSONObject.put(string2.toLowerCase(Locale.ENGLISH), -1);
                        if (jSONObject5.getString("Status").contains("always")) {
                            jSONObject4.put(string2, jSONObject5.getString("Status"));
                        }
                    }
                }
            }
            if (z10 && jSONObject3.optString("Parent").isEmpty() && jSONObject3.getJSONArray("FirstPartyCookies").length() == 0 && !com.onetrust.otpublishers.headless.Internal.c.q(jSONObject3.optString("PurposeId"))) {
                JSONObject jSONObject6 = new JSONObject();
                String strOptString = jSONObject3.optString("PurposeId");
                String str = jSONObject3.optString("Status").contains("always") ? "NO_CHOICE" : new OTPublishersHeadlessSDK(this.f21801a).getConsentStatusForGroupId(jSONObject3.optString("CustomGroupId"), jSONObject3.optString("Status")) == 0 ? "NOTGIVEN" : "CONFIRMED";
                if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                    return;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject7 = jSONArray.getJSONObject(i11);
                    if (jSONObject7.has("Id") && strOptString.equalsIgnoreCase(jSONObject7.getString("Id"))) {
                        z11 = true;
                        break;
                    }
                    i11++;
                }
                if (z11 || !e0.h(jSONObject3, this.f21808h)) {
                    return;
                }
                jSONObject6.put("Id", strOptString);
                jSONObject6.put("TransactionType", str);
                if (!jSONObject3.optString("Status").contains("always")) {
                    jSONObject2.put(jSONObject3.optString("PurposeId"), string);
                }
                jSONArray.put(jSONObject6);
                jSONArray2.put(jSONObject6);
            }
        }
    }

    public final void m(boolean z10) {
        OTLogger.a("ContentValues", 3, "saveSyncNotificationShowFlag: " + z10);
        this.f21802b.c().edit().putInt("OT_SHOW_SYNC_NOTIFICATION", z10 ? 12 : 10).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x05a6 A[Catch: JSONException -> 0x060b, TryCatch #15 {JSONException -> 0x060b, blocks: (B:160:0x0551, B:168:0x058b, B:170:0x05a6, B:171:0x05ac, B:173:0x05ce, B:178:0x05e6, B:180:0x05f7, B:182:0x05ff, B:175:0x05d5, B:177:0x05db, B:167:0x0586, B:166:0x056f, B:162:0x0567), top: B:344:0x0551, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05ac A[Catch: JSONException -> 0x060b, TryCatch #15 {JSONException -> 0x060b, blocks: (B:160:0x0551, B:168:0x058b, B:170:0x05a6, B:171:0x05ac, B:173:0x05ce, B:178:0x05e6, B:180:0x05f7, B:182:0x05ff, B:175:0x05d5, B:177:0x05db, B:167:0x0586, B:166:0x056f, B:162:0x0567), top: B:344:0x0551, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0359 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0346 A[Catch: JSONException -> 0x0388, TryCatch #3 {JSONException -> 0x0388, blocks: (B:73:0x0233, B:81:0x0273, B:83:0x0346, B:84:0x0351, B:91:0x0378, B:90:0x0363, B:80:0x026e, B:79:0x0257, B:86:0x0359, B:75:0x024f), top: B:320:0x0233, inners: #0, #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(@androidx.annotation.NonNull java.lang.String r18, @androidx.annotation.Nullable com.onetrust.otpublishers.headless.Public.OTCallback r19, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.Public.Response.OTResponse r20, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 2401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.t.p(java.lang.String, com.onetrust.otpublishers.headless.Public.OTCallback, com.onetrust.otpublishers.headless.Public.Response.OTResponse, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK, boolean):boolean");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x08f9  */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r5v9, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r7v26, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v4, types: [org.json.JSONArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(@androidx.annotation.NonNull org.json.JSONObject r42, boolean r43) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 2568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Helper.t.t(org.json.JSONObject, boolean):boolean");
    }

    @VisibleForTesting
    public final boolean u(boolean z10, boolean z11, boolean z12, SharedPreferences.Editor editor) {
        if (z12) {
            if (z10 && !z11) {
                b();
                z10 = false;
            }
            editor.putBoolean("IS_IAB2_V2_TEMPLATE", true);
            editor.putBoolean("IS_IAB2_V0_TEMPLATE", false);
        } else {
            if (z10 && z11) {
                b();
                z10 = false;
            }
            editor.putBoolean("IS_IAB2_V0_TEMPLATE", true);
            editor.putBoolean("IS_IAB2_V2_TEMPLATE", false);
        }
        editor.apply();
        return z10;
    }

    public final void v() {
        String string = this.f21802b.c().getString("OTT_CONSENT_STATUS", "");
        String string2 = this.f21802b.c().getString("OTT_ALWAYS_ACTIVE_GROUPS", "");
        String string3 = this.f21802b.c().getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        try {
            JSONObject jSONObject = new JSONObject();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                jSONObject = new JSONObject(string);
            }
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                JSONArray jSONArrayNames = new JSONObject(string2).names();
                if (!com.onetrust.otpublishers.headless.Internal.a.c(jSONArrayNames)) {
                    for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                        jSONObject.put(jSONArrayNames.getString(i10), 1);
                    }
                }
            }
            new f0(this.f21801a).c(jSONObject);
            if (com.onetrust.otpublishers.headless.Internal.c.q(string3)) {
                return;
            }
            Context context = this.f21801a;
            JSONObject jSONObject2 = new JSONObject(string3);
            if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject2)) {
                return;
            }
            try {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    int i11 = jSONObject2.getInt(next);
                    if (2 == i11) {
                        i11 = 1;
                    }
                    OTLogger.a("OTConsentChanges", 4, "Sending " + next + " broadcast, value = " + i11);
                    Intent intent = new Intent(next);
                    intent.putExtra(OTBroadcastServiceKeys.EVENT_STATUS, i11);
                    intent.setPackage(context.getApplicationContext().getPackageName());
                    context.sendBroadcast(intent);
                }
            } catch (JSONException e10) {
                OTLogger.a("OTConsentChanges", 6, "error in broadcasting SDK status. err = " + e10.getMessage() + " changedConsents = " + jSONObject2.toString());
            }
        } catch (JSONException e11) {
            p.a(e11, new StringBuilder("error while broadcasting default consent values : "), "OTData", 6);
        }
    }

    public final void x(@NonNull JSONArray jSONArray, @NonNull JSONObject jSONObject, boolean z10) throws JSONException {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
            boolean z11 = true;
            int i11 = !jSONObject2.getString("Status").equals("inactive") ? 1 : 0;
            String strOptString = jSONObject2.optString("Parent");
            if (jSONObject2.getBoolean("IsIabPurpose") && jSONObject2.getBoolean("ShowInPopup") && e0.h(jSONObject2, this.f21808h)) {
                jSONObject.put(jSONObject2.optString("CustomGroupId"), i11);
                boolean zK = this.f21803c.k(strOptString);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString) && i11 == 0 && !zK) {
                    if (!strOptString.startsWith("IABV2") && !strOptString.startsWith("IAB2V2") && !strOptString.startsWith("ISFV2") && !strOptString.startsWith("ISF2V2")) {
                        z11 = false;
                    }
                    if (!z11) {
                        jSONObject.put(strOptString, i11);
                    }
                }
            }
        }
        if (z10) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f21802b.c().edit();
        editorEdit.putString("OTT_CONSENT_STATUS", jSONObject.toString());
        String string = this.f21802b.c().getString("OT_IAB_DEFAULT_AVL", "");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            editorEdit.putString("OT_IAB_ACTIVE_VENDORLIST", string);
        }
        editorEdit.apply();
    }

    public final void y(@NonNull JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("culture");
        if (jSONObject2.has("MobileData")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("MobileData");
            e0 e0Var = this.f21809i;
            com.onetrust.otpublishers.headless.Internal.Preferences.e eVar = this.f21802b;
            e0Var.getClass();
            String string = eVar.c().getString("OT_TEMPLATE_TYPE", "");
            String str = com.onetrust.otpublishers.headless.Internal.c.q(string) ? "" : string;
            if (!("IAB2".equalsIgnoreCase(str) || "IAB2V2".equalsIgnoreCase(str)) || jSONObject3.optJSONObject("ccpaData").optBoolean("computeCCPA")) {
                return;
            }
            new g0(this.f21801a).f();
        }
    }
}
