package com.onetrust.otpublishers.headless.UI.mobiledatautils;

import android.content.Context;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Helper.x;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.UI.UIProperty.b0;
import com.onetrust.otpublishers.headless.UI.UIProperty.z;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f23648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f23649b;

    @NonNull
    public static ArrayList b(@NonNull JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                d(i10, jSONArray, jSONArray2, new JSONObject());
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on parsing Categories list. Error msg = "), "OTSDKListFilter", 6);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
            try {
                JSONObject jSONObject = jSONArray2.getJSONObject(i11);
                if (jSONObject.has("CustomGroupId")) {
                    arrayList.add(jSONObject.getString("CustomGroupId"));
                }
            } catch (JSONException e11) {
                p.a(e11, new StringBuilder("Error on parsing Categories list to get category string list. Error msg = "), "OTSDKListFilter", 6);
            }
        }
        return arrayList;
    }

    public static void d(int i10, @NonNull JSONArray jSONArray, @NonNull JSONArray jSONArray2, @NonNull JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
        if (!jSONObject2.has("ShowSDKListLink") || jSONObject2.getBoolean("ShowSDKListLink")) {
            if ((jSONObject2.getString("Type").equals("COOKIE") && jSONObject2.getJSONArray("FirstPartyCookies").length() > 0) || !jSONObject2.optBoolean("ShowSubgroup", false)) {
                String strOptString = jSONObject2.optString("GroupNameMobile");
                if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString)) {
                    strOptString = jSONObject2.optString("GroupName");
                }
                jSONObject.put("GroupName", strOptString);
                jSONObject.put("CustomGroupId", jSONObject2.getString("CustomGroupId"));
                jSONArray2.put(jSONObject);
            }
            if (jSONObject2.has("SubGroups") && jSONObject2.optBoolean("ShowSubgroup", false)) {
                JSONArray jSONArray3 = jSONObject2.getJSONArray("SubGroups");
                for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONArray3.getJSONObject(i11).getString("Type").equals("COOKIE") && jSONArray3.getJSONObject(i11).getJSONArray("FirstPartyCookies").length() > 0) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i11);
                        String strOptString2 = jSONObject4.optString("GroupNameMobile");
                        if (com.onetrust.otpublishers.headless.Internal.c.q(strOptString2)) {
                            strOptString2 = jSONObject4.optString("GroupName");
                        }
                        jSONObject3.put("GroupName", strOptString2);
                        jSONObject3.put("CustomGroupId", jSONArray3.getJSONObject(i11).getString("CustomGroupId"));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
        }
    }

    public final z a() {
        return this.f23648a;
    }

    public final void c(@NonNull int i10, @NonNull Context context, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        try {
            this.f23649b = oTPublishersHeadlessSDK.getPreferenceCenterData();
            z zVarE = new b0(context).e(i10);
            this.f23648a = zVarE;
            String str = zVarE.f22876a;
            String strOptString = this.f23649b.optString("PcBackgroundColor");
            String str2 = "#FFFFFF";
            if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
                str = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString) ? strOptString : i10 == 11 ? "#2F2F2F" : "#FFFFFF";
            }
            zVarE.f22876a = str;
            z zVar = this.f23648a;
            String str3 = zVar.f22885j;
            String strOptString2 = this.f23649b.optString("PcButtonColor");
            if (com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
                str3 = !com.onetrust.otpublishers.headless.Internal.c.q(strOptString2) ? strOptString2 : i10 == 11 ? "#80BE5A" : "#6CC04A";
            }
            zVar.f22885j = str3;
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar = this.f23648a.f22887l;
            String str4 = cVar.f22722c;
            String strOptString3 = this.f23649b.optString("PcTextColor");
            if (!com.onetrust.otpublishers.headless.Internal.c.q(str4)) {
                str2 = str4;
            } else if (!com.onetrust.otpublishers.headless.Internal.c.q(strOptString3)) {
                str2 = strOptString3;
            } else if (i10 != 11) {
                str2 = "#696969";
            }
            cVar.f22722c = str2;
            com.onetrust.otpublishers.headless.UI.UIProperty.f fVar = this.f23648a.f22888m;
            fVar.f22764g = this.f23649b.optString("PCenterApplyFiltersText");
            if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.c())) {
                fVar.f22760c = this.f23649b.optString("PcButtonTextColor");
            }
            if (com.onetrust.otpublishers.headless.Internal.c.q(fVar.f22759b)) {
                fVar.f22759b = this.f23649b.optString("PcButtonColor");
            }
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar2 = this.f23648a.f22886k;
            if (com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22724e)) {
                cVar2.f22724e = this.f23649b.optString("PCenterCancelFiltersText");
            }
            if (com.onetrust.otpublishers.headless.Internal.c.q(cVar2.f22722c)) {
                cVar2.f22722c = this.f23649b.optString("PcTextColor");
            }
            com.onetrust.otpublishers.headless.UI.UIProperty.c cVar3 = this.f23648a.f22887l;
            if (com.onetrust.otpublishers.headless.Internal.c.q(cVar3.f22722c)) {
                cVar3.f22722c = this.f23649b.optString("PcTextColor");
            }
        } catch (JSONException e10) {
            x.a("failed to initialize SDK list filter data, e: ", e10, "OTSDKListFilter", 6);
        }
    }
}
