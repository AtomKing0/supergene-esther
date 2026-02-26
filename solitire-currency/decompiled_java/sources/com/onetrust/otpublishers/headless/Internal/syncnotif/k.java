package com.onetrust.otpublishers.headless.Internal.syncnotif;

import android.content.Context;
import android.content.SharedPreferences;
import com.onetrust.otpublishers.headless.Internal.Helper.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21954d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f21951a = new JSONObject();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f21952b = new JSONObject();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21955e = 10;

    public static void a(Context context) {
        com.onetrust.otpublishers.headless.Internal.Preferences.h hVar;
        if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(context, "AppDataParser")) {
            boolean z10 = false;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
                hVar = new com.onetrust.otpublishers.headless.Internal.Preferences.h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z10 = true;
            } else {
                hVar = null;
            }
            if (z10) {
                sharedPreferences = hVar;
            }
            sharedPreferences.edit().putInt("OT_SHOW_SYNC_NOTIFICATION", 10).apply();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.fragment.app.FragmentActivity r19, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration r20, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r21) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.syncnotif.k.b(androidx.fragment.app.FragmentActivity, com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK):void");
    }
}
