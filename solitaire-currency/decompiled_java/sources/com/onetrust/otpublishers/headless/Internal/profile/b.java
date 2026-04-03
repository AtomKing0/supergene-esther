package com.onetrust.otpublishers.headless.Internal.profile;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Helper.j;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f21901b;

    public b(@NonNull Context context) {
        this.f21901b = context;
        this.f21900a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER");
    }

    public final void a(@Nullable String str) {
        if (str == null || com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        this.f21900a.c().edit().putString("OT_ACTIVE_PROFILE_ID", lowerCase).apply();
        OTLogger.a("MultiProfileFile", 3, "Active profile set to = " + lowerCase);
    }

    public final boolean b(@Nullable String str, @Nullable String str2, boolean z10, boolean z11) {
        boolean z12;
        boolean z13;
        OTLogger.a("MultiProfileFile", 3, "setProfile called, currentActiveProfileId = " + str + " , newProfileID = " + str2 + " , backupDefaultSharedPreferenceData = " + z10 + ", restoreDefaultSharedPreferenceData = " + z11);
        if (str2 == null || com.onetrust.otpublishers.headless.Internal.c.q(str2)) {
            return false;
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        a aVar = new a(this.f21901b);
        if (lowerCase.equalsIgnoreCase(str)) {
            z12 = false;
            z13 = false;
        } else {
            z12 = z10;
            z13 = z11;
        }
        boolean z14 = z13;
        try {
            aVar.d(str, z12, z12, true, true, true, false);
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("Error on backupDataWithExceptionHandling,Error = "), "OTSDKExceptions", 6);
        }
        a(lowerCase);
        try {
            if (!d.d(this.f21900a, str2)) {
                try {
                    aVar.c(lowerCase, z14, true, true);
                } catch (Exception e11) {
                    OTLogger.a("OTSDKExceptions", 6, "Error on restoreDataWithExceptionHandling,Error = " + e11.getMessage());
                }
            }
            return true;
        } catch (JSONException e12) {
            p.a(e12, new StringBuilder("Error on updating multi-profile id maps. Error = "), "MultiProfileFile", 6);
            return false;
        }
    }

    public b(Context context, @NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar) {
        this.f21901b = context;
        this.f21900a = eVar;
    }
}
