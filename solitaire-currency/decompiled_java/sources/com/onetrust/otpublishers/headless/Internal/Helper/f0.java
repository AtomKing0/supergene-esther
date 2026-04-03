package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import com.onetrust.otpublishers.headless.Public.OTConsentInteractionType;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21760a;

    public f0(Context context) {
        this.f21760a = context;
    }

    public final void a(@NonNull String str) {
        if (!((OTConsentInteractionType.BANNER_BACK.equalsIgnoreCase(str) || OTConsentInteractionType.PC_CLOSE.equalsIgnoreCase(str) || OTConsentInteractionType.UC_PC_CONFIRM.equalsIgnoreCase(str)) ? false : true)) {
            d.a("Not sending OTConsentUpdated broadcast. Interaction type = ", str, "OTConsentChanges", 3);
            return;
        }
        OTLogger.a("OTConsentChanges", 4, "Sending OTConsentUpdated action broadcast. Interaction type = " + str);
        Intent intent = new Intent();
        intent.setAction(OTBroadcastServiceKeys.OT_CONSENT_UPDATED);
        intent.setPackage(this.f21760a.getApplicationContext().getPackageName());
        this.f21760a.sendBroadcast(intent);
    }

    public final void b(@NonNull String str, int i10) {
        OTLogger.a("OTConsentChanges", 4, "Sending " + str + " broadcast, value = " + i10);
        Intent intent = new Intent(str);
        intent.putExtra(OTBroadcastServiceKeys.EVENT_STATUS, i10);
        intent.setPackage(this.f21760a.getApplicationContext().getPackageName());
        this.f21760a.sendBroadcast(intent);
    }

    public final void c(@NonNull JSONObject jSONObject) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        Context context = this.f21760a;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_GROUP_ID_OBJECT", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(string);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                int i10 = jSONObject.getInt(next);
                if (jSONObject2.has(next)) {
                    b(next, i10);
                }
            }
        } catch (JSONException e10) {
            OTLogger.a("OTConsentChanges", 6, "error in broadcasting status. err = " + e10.getMessage() + " changedConsents = " + jSONObject.toString());
        }
    }
}
