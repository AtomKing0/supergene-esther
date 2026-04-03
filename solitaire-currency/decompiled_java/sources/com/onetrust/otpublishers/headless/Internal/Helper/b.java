package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21753a;

    public b(@NonNull Context context) {
        this.f21753a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
    }

    public final void a(@NonNull String str) {
        SharedPreferences.Editor editorEdit;
        int i10;
        if (str.equals("OPT_IN")) {
            editorEdit = this.f21753a.c().edit();
            i10 = 1;
        } else {
            if (!str.equals("OPT_OUT")) {
                this.f21753a.c().edit().putInt("OT_AGE_GATE_USER_CONSENT_STATUS", -1).apply();
                OTLogger.a("AgeGateConsentHandler", 3, "Saving Age Gate Consent :" + this.f21753a.c().getInt("OT_AGE_GATE_USER_CONSENT_STATUS", -1));
            }
            editorEdit = this.f21753a.c().edit();
            i10 = 0;
        }
        editorEdit.putInt("OT_AGE_GATE_USER_CONSENT_STATUS", i10).apply();
        OTLogger.a("AgeGateConsentHandler", 3, "Saving Age Gate Consent :" + this.f21753a.c().getInt("OT_AGE_GATE_USER_CONSENT_STATUS", -1));
    }
}
