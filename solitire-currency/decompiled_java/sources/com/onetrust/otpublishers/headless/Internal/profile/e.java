package com.onetrust.otpublishers.headless.Internal.profile;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21909a;

    public e(@NonNull Context context) {
        this.f21909a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER");
    }

    public final void a() {
        this.f21909a.c().edit().remove("OT_MULTI_PROFILE_DELETE_ID").apply();
    }

    public final void b(@Nullable String str) throws JSONException {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("culture")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("culture");
            if (jSONObject2.has("MobileData")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("MobileData");
                if (jSONObject3.has("multiProfileConsent")) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("multiProfileConsent");
                    boolean zOptBoolean = jSONObject4.optBoolean("isEnabled", false);
                    boolean zOptBoolean2 = jSONObject4.optBoolean("downloadDataAfterSwitch", false);
                    int iOptInt = jSONObject4.optInt("maxProfilesLimit", 6);
                    OTLogger.a("MultiprofileConsent", 3, "Multiprofile consent isEnabled = " + zOptBoolean + ", downloadAfterSwitch = " + zOptBoolean2 + " , maximumProfileLimit = " + iOptInt);
                    SharedPreferences.Editor editorEdit = this.f21909a.c().edit();
                    editorEdit.putBoolean("OT_MULTI_PROFILE_CONSENT_ENABLED", zOptBoolean);
                    editorEdit.putBoolean("OT_MULTI_PROFILE_DOWNLOAD_DATA_AFTER_SWITCH", zOptBoolean2);
                    editorEdit.putInt("OT_MULTI_PROFILE_MAXIMUM_PROFILES_LIMIT", iOptInt);
                    editorEdit.apply();
                }
            }
        }
    }

    public final void c(@Nullable String str) {
        if (str == null || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        this.f21909a.c().edit().putString("OT_MULTI_PROFILE_DELETE_ID", str).apply();
    }
}
