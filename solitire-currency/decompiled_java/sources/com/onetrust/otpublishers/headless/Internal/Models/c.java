package com.onetrust.otpublishers.headless.Internal.Models;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Helper.f;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.e;
import com.unity3d.services.UnityAdsConstants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f21832a = new JSONObject();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f21833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21834c;

    public c(@NonNull Context context) {
        this.f21833b = new e(context);
        this.f21834c = context;
    }

    public final void a(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull JSONObject jSONObject) {
        String str4;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            this.f21832a.put("InteractionType", str);
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            this.f21832a.put("Country", str2);
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str3)) {
            JSONObject jSONObject2 = new JSONObject(str3);
            if (jSONObject2.has("InteractionType") || jSONObject2.has("Country")) {
                jSONObject2.remove("InteractionType");
                jSONObject2.remove("Country");
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    this.f21832a.put(next, jSONObject2.get(next));
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error on merging appendedCustomDSElements. Error msg = "), "DsDataElementPayload", 6);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Context context = this.f21834c;
        sb.append(context.getApplicationInfo().loadLabel(context.getPackageManager()).toString());
        sb.append(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH);
        Context context2 = this.f21834c;
        try {
            str4 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 1).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            OTLogger.a("DsDataElementPayload", 6, "Error on getting Application versionName. Error msg = " + e11.getMessage());
            str4 = "";
        }
        sb.append(str4);
        String str5 = sb.toString() + " " + System.getProperty("http.agent");
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str5)) {
            this.f21832a.put("UserAgent", str5);
        }
        jSONObject.put("dsDataElements", this.f21832a);
        OTLogger.a("DsDataElementPayload", 4, "DS DataElement Object : " + jSONObject.getJSONObject("dsDataElements"));
    }

    public final void b(@NonNull JSONObject jSONObject) {
        f.a(jSONObject, this.f21833b.c().edit(), "OT_DS_DATA_ELEMENT_OBJECT");
    }
}
