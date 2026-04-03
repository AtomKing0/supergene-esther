package com.onetrust.otpublishers.headless.UI.mobiledatautils;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.UIProperty.o;
import com.onetrust.otpublishers.headless.UI.UIProperty.v;
import com.onetrust.otpublishers.headless.UI.UIProperty.w;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f23636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f23637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23640h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f23643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public w f23644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public v f23645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OTPublishersHeadlessSDK f23646n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Context f23647o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f23633a = new JSONObject();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f23641i = false;

    public static void c(o oVar, String str, JSONObject jSONObject) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(oVar.f22787a.f22722c)) {
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = oVar.f22787a;
            String strOptString = jSONObject.optString("PcLinksTextColor");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(cVar.f22722c)) {
                strOptString = cVar.f22722c;
            }
            cVar.f22722c = strOptString;
        }
        if (com.onetrust.otpublishers.headless.Internal.c.q(oVar.f22787a.f22724e)) {
            oVar.f22787a.f22724e = str;
        }
    }

    public static boolean d(@NonNull JSONObject jSONObject) throws JSONException {
        boolean z10;
        boolean z11 = !com.onetrust.otpublishers.headless.Internal.a.c(jSONObject.optJSONArray("GeneralVendorsIds"));
        if (!jSONObject.has("SubGroups") && z11) {
            return true;
        }
        if (!jSONObject.has("SubGroups") || jSONObject.getBoolean("IsIabPurpose")) {
            z10 = false;
        } else {
            JSONArray jSONArray = jSONObject.getJSONArray("SubGroups");
            z10 = false;
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                if (jSONObject2.getBoolean("IsIabPurpose")) {
                    return false;
                }
                if (!com.onetrust.otpublishers.headless.Internal.a.c(jSONObject2.optJSONArray("GeneralVendorsIds"))) {
                    z10 = true;
                }
            }
        }
        return z11 || z10;
    }

    public static boolean g(@NonNull JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ShowSDKListLink") && !jSONObject.getBoolean("ShowSDKListLink")) {
            return false;
        }
        if (!jSONObject.getBoolean("IsIabPurpose") && jSONObject.getJSONArray("FirstPartyCookies").length() > 0) {
            return true;
        }
        if (jSONObject.has("SubGroups")) {
            JSONArray jSONArray = jSONObject.getJSONArray("SubGroups");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                if (!jSONArray.getJSONObject(i10).getBoolean("IsIabPurpose")) {
                    return true;
                }
            }
        }
        return false;
    }

    @NonNull
    public final Bundle a(@NonNull HashMap map) {
        Bundle bundle = new Bundle();
        try {
            if (!this.f23633a.getBoolean("IsIabPurpose") && !com.onetrust.otpublishers.headless.Internal.a.c(this.f23633a.getJSONArray("GeneralVendorsIds"))) {
                map.put(this.f23636d, this.f23634b);
            }
            i(map);
            bundle.putBoolean("IS_FILTERED_VENDOR_LIST", true);
            bundle.putString("PURPOSE_MAP", map.toString());
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("General vendor: error while setting filtered groups "), "PC Detail", 6);
        }
        return bundle;
    }

    @NonNull
    public final JSONObject b() {
        return this.f23633a;
    }

    @NonNull
    public final Bundle e(@NonNull HashMap map) {
        Bundle bundle = new Bundle();
        try {
            if (!this.f23635c && this.f23633a.getBoolean("IsIabPurpose")) {
                map.put(this.f23636d, this.f23634b);
            }
            k(map);
            bundle.putBoolean("IS_FILTERED_VENDOR_LIST", true);
            bundle.putString("PURPOSE_MAP", map.toString());
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error in parsing vendorlist link on setCategoriesForVendorList: "), "PC Detail", 6);
        }
        return bundle;
    }

    public final String f() {
        return this.f23643k;
    }

    public final v h() {
        return this.f23645m;
    }

    public final void i(@NonNull HashMap map) throws JSONException {
        if (this.f23633a.has("SubGroups")) {
            JSONArray jSONArray = this.f23633a.getJSONArray("SubGroups");
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (!jSONObject.getBoolean("IsIabPurpose")) {
                    map.put(jSONObject.getString("CustomGroupId"), jSONObject.getString("Type"));
                }
            }
        }
    }

    public final w j() {
        return this.f23644l;
    }

    public final void k(@NonNull HashMap map) throws JSONException {
        if (this.f23633a.has("SubGroups")) {
            JSONArray jSONArray = this.f23633a.getJSONArray("SubGroups");
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject.getBoolean("IsIabPurpose")) {
                    map.put(jSONObject.getString("CustomGroupId"), jSONObject.getString("Type"));
                }
            }
        }
    }

    public final boolean l() {
        return this.f23639g;
    }

    public final boolean m() {
        return this.f23638f;
    }

    public final boolean n() {
        return this.f23637e;
    }
}
