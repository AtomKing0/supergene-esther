package com.onetrust.otpublishers.headless.UI.TVUI.datautils;

import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.UI.Helper.l;
import io.sentry.protocol.ViewHierarchyNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static e E;
    public String D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f22387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f22388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22389c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22390d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22391e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22392f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f22393g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22394h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f22395i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f22396j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f22397k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f22398l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f22399m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f22400n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f22401o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f22402p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f22403q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f22404r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f22405s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f22406t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f22407u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f22408v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f22409w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f22410x = "";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f22411y = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f22412z = "";
    public String A = "";
    public String B = "";
    public String C = OTVendorListMode.IAB;

    public static synchronized e a() {
        if (E == null) {
            E = new e();
        }
        return E;
    }

    @NonNull
    public static String b(@NonNull JSONObject jSONObject) {
        return (jSONObject.has(ViewHierarchyNode.JsonKeys.IDENTIFIER) || jSONObject.has("name")) ? jSONObject.optString(ViewHierarchyNode.JsonKeys.IDENTIFIER).isEmpty() ? jSONObject.optString("name") : jSONObject.optString(ViewHierarchyNode.JsonKeys.IDENTIFIER) : "";
    }

    @NonNull
    public static String c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z10) {
        String strOptString;
        String strOptString2 = jSONObject.optString("SDKLanguageCode");
        if (!jSONObject2.has("urls")) {
            return "";
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("urls");
            String str = null;
            if (jSONArrayOptJSONArray != null) {
                int i10 = 0;
                while (true) {
                    if (i10 >= jSONArrayOptJSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i10);
                    if (strOptString2.equalsIgnoreCase(jSONObject3.optString("langId"))) {
                        strOptString = jSONObject3.optString(z10 ? "legIntClaim" : "privacy");
                    } else {
                        strOptString = null;
                    }
                    if (strOptString != null) {
                        str = strOptString;
                        break;
                    }
                    i10++;
                }
            }
            return str != null ? str : "";
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error on getting iab2v2 vendor policy url, error = "), "IAB2V2Flow", 6);
            return "";
        }
    }

    public final void d(@NonNull JSONObject jSONObject, @NonNull String str) {
        String strOptString;
        this.f22388b = jSONObject;
        this.C = str;
        if (this.f22387a == null || jSONObject == null) {
            return;
        }
        this.f22389c = jSONObject.optString("name");
        this.f22394h = this.f22387a.optString("PCenterVendorListLifespan") + " : ";
        this.f22396j = this.f22387a.optString("PCenterVendorListDisclosure");
        this.f22397k = this.f22387a.optString("BConsentPurposesText");
        this.f22398l = this.f22387a.optString("BLegitimateInterestPurposesText");
        this.f22401o = this.f22387a.optString("BSpecialFeaturesText");
        this.f22400n = this.f22387a.optString("BSpecialPurposesText");
        this.f22399m = this.f22387a.optString("BFeaturesText");
        this.D = this.f22387a.optString("IabType");
        if (OTVendorListMode.IAB.equalsIgnoreCase(this.C)) {
            String str2 = this.D;
            JSONObject jSONObject2 = this.f22387a;
            JSONObject jSONObject3 = this.f22388b;
            strOptString = com.onetrust.otpublishers.headless.Internal.c.t(str2) ? c(jSONObject2, jSONObject3, false) : jSONObject3.optString("policyUrl");
        } else {
            strOptString = this.f22388b.optString("policyUrl");
        }
        this.f22390d = strOptString;
        this.f22391e = com.onetrust.otpublishers.headless.Internal.c.t(this.D) ? c(this.f22387a, this.f22388b, true) : "";
        this.f22392f = this.f22387a.optString("PCenterViewPrivacyPolicyText");
        this.f22393g = this.f22387a.optString("PCIABVendorLegIntClaimText");
        this.f22395i = l.d(this.f22388b.optLong("cookieMaxAgeSeconds"), this.f22387a);
        this.f22402p = this.f22387a.optString("PCenterVendorListNonCookieUsage");
        this.f22411y = this.f22387a.optString("PCVListDataDeclarationText");
        this.f22412z = this.f22387a.optString("PCVListDataRetentionText");
        this.A = this.f22387a.optString("PCVListStdRetentionText");
        this.B = this.f22387a.optString("PCenterVendorListLifespanDays");
        this.f22403q = this.f22388b.optString("deviceStorageDisclosureUrl");
        this.f22404r = this.f22387a.optString("PCenterVendorListStorageIdentifier") + " : ";
        this.f22405s = this.f22387a.optString("PCenterVendorListStorageType") + " : ";
        this.f22406t = this.f22387a.optString("PCenterVendorListLifespan") + " : ";
        this.f22407u = this.f22387a.optString("PCenterVendorListStorageDomain") + " : ";
        this.f22408v = this.f22387a.optString("PCenterVendorListStoragePurposes") + " : ";
        this.f22409w = this.f22387a.optString("PCVLSDomainsUsed");
        this.f22410x = this.f22387a.optString("PCVLSUse") + " : ";
    }
}
