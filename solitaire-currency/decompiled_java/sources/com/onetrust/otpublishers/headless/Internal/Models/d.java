package com.onetrust.otpublishers.headless.Internal.Models;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f21836b;

    public d(@NonNull Context context) {
        this.f21835a = context;
        this.f21836b = new e(context).c();
    }

    public final boolean a(@NonNull JSONObject jSONObject) {
        long j10;
        String str;
        if (!jSONObject.has("LastReconsentDate")) {
            return false;
        }
        String string = !jSONObject.isNull("LastReconsentDate") ? jSONObject.get("LastReconsentDate").toString() : null;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string) && !jSONObject.isNull("LastReconsentDate")) {
            long j11 = Long.parseLong(string);
            String string2 = this.f21836b.getString("OTT_LAST_GIVEN_CONSENT", "0");
            long j12 = com.onetrust.otpublishers.headless.Internal.c.q(string2) ? 0L : Long.parseLong(string2);
            String string3 = this.f21836b.getString("OTT_LAST_RE_CONSENT_DATE", String.valueOf(-1L));
            if (com.onetrust.otpublishers.headless.Internal.c.q(string3)) {
                OTLogger.a("ShowBanner", 4, "Last re-consent date not initialized, it will be set once OT SDK initialized.");
                j10 = -1;
            } else {
                j10 = Long.parseLong(string3);
            }
            if (j12 == 0 || j11 <= j12) {
                str = (j12 == 0 && j10 != -1 && j11 > j10) ? "Reconsent Status: Show Banner is enabled for current geolocation rule and previous lastReconsentDateFromServer is older than lastReconsentDateFromServer" : "Reconsent Status: Show Banner is enabled for current geolocation rule and user consent is older than lastReconsentDateFromServer";
            }
            OTLogger.a("ShowBanner", 4, str);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #1 {Exception -> 0x0062, blocks: (B:8:0x0029, B:10:0x0035, B:15:0x0057, B:17:0x005d, B:14:0x0052, B:13:0x003c), top: B:145:0x0029, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(@androidx.annotation.Nullable org.json.JSONObject r20) {
        /*
            Method dump skipped, instruction units count: 707
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.Models.d.b(org.json.JSONObject):int");
    }
}
