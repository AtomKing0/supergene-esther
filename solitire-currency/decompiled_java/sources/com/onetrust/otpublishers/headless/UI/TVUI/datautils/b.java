package com.onetrust.otpublishers.headless.UI.TVUI.datautils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.UI.UIProperty.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static b f22337w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f22338a;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f22352o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f22356s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f22357t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22339b = "On";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22340c = "Off";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22341d = "SUB-CATEGORIES";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22342e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f22343f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f22344g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22345h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f22346i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f22347j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f22348k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f22349l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f22350m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f22351n = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f22353p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f22354q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f22355r = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f22358u = new f();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public f f22359v = new f();

    public static synchronized b a() {
        if (f22337w == null) {
            f22337w = new b();
        }
        return f22337w;
    }

    public final void b(@NonNull Context context) {
        boolean z10;
        h hVar;
        h hVar2;
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject jSONObject = this.f22338a;
            if (jSONObject == null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                    hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z10 = true;
                } else {
                    z10 = false;
                    hVar = null;
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (new com.onetrust.otpublishers.headless.Internal.profile.d(context).t()) {
                    hVar2 = hVar;
                    new h(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                } else {
                    hVar2 = hVar;
                }
                SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (new com.onetrust.otpublishers.headless.Internal.profile.d(context).t()) {
                    new h(context, sharedPreferences3, sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", ""));
                }
                String string = (z10 ? hVar2 : sharedPreferences).getString("OT_OTT_DATA", null);
                jSONObject = com.onetrust.otpublishers.headless.Internal.c.q(string) ? null : new JSONObject(string);
            }
            this.f22338a = jSONObject;
            if (com.onetrust.otpublishers.headless.Internal.a.d(jSONObject)) {
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = this.f22338a.optJSONObject("preferenceCenterData");
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("purposeList") && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("purposeList")) != null) {
                this.f22339b = jSONObjectOptJSONObject.optString("ActiveText");
                this.f22340c = jSONObjectOptJSONObject.optString("InactiveText");
                this.f22341d = jSONObjectOptJSONObject.optString("SubCategoryHeaderText");
                this.f22352o = jSONObjectOptJSONObject.optBoolean("InteractionChoiceIsConsentShow");
                OTLogger.a("OTTDataParser", 3, "isInteractionChoiceIsConsent: " + this.f22352o);
                this.f22353p = jSONObjectOptJSONObject.optString("InteractionChoiceText");
            }
            JSONObject jSONObject2 = this.f22338a.getJSONObject("bannerData");
            d(jSONObject2, true);
            c(jSONObject2);
            JSONObject jSONObject3 = this.f22338a.getJSONObject("preferenceCenterData");
            d(jSONObject3, false);
            if (jSONObject3.has("menu")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("menu");
                this.f22346i = jSONObject4.optString("color");
                this.f22347j = jSONObject4.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
                this.f22348k = jSONObject4.optString("focusColor");
                this.f22349l = jSONObject4.optString("focusTextColor");
                this.f22350m = jSONObject4.optString("activeColor");
                this.f22351n = jSONObject4.optString("activeTextColor");
            }
            JSONObject jSONObject5 = this.f22338a;
            if (jSONObject5.has("vendorListData")) {
                JSONObject jSONObject6 = jSONObject5.getJSONObject("vendorListData");
                if (jSONObject6.has(OTVendorListMode.GENERAL)) {
                    JSONObject jSONObject7 = jSONObject6.getJSONObject(OTVendorListMode.GENERAL);
                    if (jSONObject7.has("showFilterIcon")) {
                        this.f22355r = jSONObject7.getBoolean("showFilterIcon");
                    }
                }
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while parsing OTT data, error: "), "OneTrust", 6);
        }
    }

    @VisibleForTesting
    public final void c(@NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BUTTONS)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_BUTTONS);
            if (jSONObject2.has(OTUXParamsKeys.OT_UX_SHOW_PREFERENCES)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(OTUXParamsKeys.OT_UX_SHOW_PREFERENCES);
                f fVar = new f();
                if (jSONObject3.has("color")) {
                    fVar.f22759b = jSONObject3.getString("color");
                }
                if (jSONObject3.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
                    fVar.f22760c = jSONObject3.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
                }
                this.f22359v = fVar;
            }
            if (jSONObject2.has(OTUXParamsKeys.OT_UX_LINK_VENDOR_LIST)) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject(OTUXParamsKeys.OT_UX_LINK_VENDOR_LIST);
                f fVar2 = new f();
                if (jSONObject4.has("color")) {
                    fVar2.f22759b = jSONObject4.getString("color");
                }
                if (jSONObject4.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
                    fVar2.f22760c = jSONObject4.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
                }
                this.f22358u = fVar2;
            }
        }
    }

    public final void d(@NonNull JSONObject jSONObject, boolean z10) throws JSONException {
        if (jSONObject.has(OTVendorListMode.GENERAL)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(OTVendorListMode.GENERAL);
            if (!z10) {
                this.f22344g = jSONObject2.optString("buttonFocusColor");
                this.f22345h = jSONObject2.optString("buttonFocusTextColor");
                this.f22357t = jSONObject2.optBoolean("buttonBorderShow");
            } else {
                this.f22342e = jSONObject2.optString("buttonFocusColor");
                this.f22343f = jSONObject2.optString("buttonFocusTextColor");
                this.f22354q = jSONObject2.optString(TtmlNode.TAG_LAYOUT, TtmlNode.RIGHT);
                this.f22356s = jSONObject2.optBoolean("buttonBorderShow");
            }
        }
    }
}
