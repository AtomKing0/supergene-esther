package com.onetrust.otpublishers.headless.UI.TVUI.datautils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Helper.k;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Helper.x;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.UI.UIProperty.d0;
import com.onetrust.otpublishers.headless.UI.UIProperty.f;
import com.onetrust.otpublishers.headless.UI.UIProperty.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static d f22379h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f22380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f22384e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d0 f22385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f22386g;

    public static synchronized d a() {
        if (f22379h == null) {
            f22379h = new d();
        }
        return f22379h;
    }

    public static void b(int i10, @NonNull JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) throws JSONException {
        if (!jSONArray.getJSONObject(i10).has("ShowSDKListLink") || jSONArray.getJSONObject(i10).getBoolean("ShowSDKListLink")) {
            if (jSONArray.getJSONObject(i10).getString("Type").equals("COOKIE") && jSONArray.getJSONObject(i10).getJSONArray("FirstPartyCookies").length() > 0) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                String strOptString = jSONObject2.optString("GroupNameMobile");
                if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                    strOptString = jSONObject2.optString("GroupName");
                }
                jSONObject.put("GroupName", strOptString);
                jSONObject.put("CustomGroupId", jSONArray.getJSONObject(i10).optString("CustomGroupId", ""));
                jSONArray2.put(jSONObject);
            }
            if (jSONArray.getJSONObject(i10).has("SubGroups")) {
                JSONArray jSONArray3 = jSONArray.getJSONObject(i10).getJSONArray("SubGroups");
                for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONArray3.getJSONObject(i11).getString("Type").equals("COOKIE") && jSONArray3.getJSONObject(i11).getJSONArray("FirstPartyCookies").length() > 0) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i11);
                        String strOptString2 = jSONObject4.optString("GroupNameMobile");
                        if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                            strOptString2 = jSONObject4.optString("GroupName");
                        }
                        jSONObject3.put("GroupName", strOptString2);
                        jSONObject3.put("CustomGroupId", jSONArray3.getJSONObject(i11).optString("CustomGroupId", ""));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
        }
    }

    public static boolean d(@NonNull Context context, @NonNull String str) {
        h hVar;
        boolean z10;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        if (!string.isEmpty() && !com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    if (jSONObject.getInt(str) == 2) {
                        return true;
                    }
                }
            } catch (JSONException e10) {
                x.a("isAlwaysActiveSDK: ", e10, "TVDataUtils", 3);
            }
        }
        return false;
    }

    public final void c(@NonNull Context context) {
        boolean z10;
        h hVar;
        f fVar;
        try {
            JSONObject jSONObject = this.f22380a;
            int i10 = 0;
            if (jSONObject == null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (com.onetrust.otpublishers.headless.Internal.b.a(new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER").c().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()))) {
                    hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z10 = true;
                } else {
                    z10 = false;
                    hVar = null;
                }
                if (z10) {
                    sharedPreferences = hVar;
                }
                String string = sharedPreferences.getString("OTT_PC_DATA", null);
                jSONObject = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : null;
            }
            this.f22380a = jSONObject;
            if (jSONObject == null) {
                return;
            }
            this.f22381b = jSONObject.optString("PcTextColor");
            if (this.f22380a.has("LegIntSettings") && !com.onetrust.otpublishers.headless.Internal.c.q("LegIntSettings")) {
                this.f22380a.getJSONObject("LegIntSettings").getBoolean("PAllowLI");
            }
            String strOptString = this.f22380a.optString("PCenterVendorsListText");
            this.f22382c = this.f22380a.optString("PCenterApplyFiltersText");
            this.f22383d = this.f22380a.optString("PCenterClearFiltersText");
            this.f22384e = this.f22380a.optString("ThirdPartyCookieListText");
            d0 d0VarK = new r(context).k(22);
            this.f22385f = d0VarK;
            if (d0VarK != null) {
                if (com.onetrust.otpublishers.headless.Internal.c.q(d0VarK.f22755r.f22875a.f22724e)) {
                    this.f22385f.f22755r.f22875a.f22724e = strOptString;
                }
                this.f22386g = new f();
                if (b.a().f22355r) {
                    fVar = this.f22386g;
                } else {
                    fVar = this.f22386g;
                    i10 = 8;
                }
                fVar.f22769l = i10;
                if (com.onetrust.otpublishers.headless.Internal.c.q(this.f22385f.f22743f)) {
                    this.f22385f.f22743f = this.f22380a.optString("PcButtonColor");
                }
                f fVar2 = this.f22386g;
                d0 d0Var = this.f22385f;
                fVar2.f22760c = d0Var.f22743f;
                if (com.onetrust.otpublishers.headless.Internal.c.q(d0Var.f22744g)) {
                    this.f22385f.f22744g = this.f22380a.optString("PcTextColor");
                }
                f fVar3 = this.f22386g;
                fVar3.f22759b = this.f22385f.f22744g;
                fVar3.f22766i = b.a().f22344g;
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while parsing PC data for VL rendering, error: "), "OneTrust", 6);
        }
    }

    @NonNull
    public final JSONArray e() {
        return k.a(this.f22380a);
    }
}
