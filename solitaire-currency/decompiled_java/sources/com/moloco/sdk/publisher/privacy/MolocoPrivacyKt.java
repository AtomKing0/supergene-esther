package com.moloco.sdk.publisher.privacy;

import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.moloco.sdk.internal.android_context.b;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import p9.q;

/* JADX INFO: loaded from: classes4.dex */
public final class MolocoPrivacyKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean gdprApplies() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(b.b(null, 1, null));
        if (!defaultSharedPreferences.contains(OTIABTCFKeys.IABTCF_GDPRAPPLIES)) {
            return null;
        }
        try {
            int i10 = defaultSharedPreferences.getInt(OTIABTCFKeys.IABTCF_GDPRAPPLIES, 0);
            if (i10 == 0) {
                return Boolean.FALSE;
            }
            if (i10 != 1) {
                return null;
            }
            return Boolean.TRUE;
        } catch (ClassCastException unused) {
            return Boolean.valueOf(defaultSharedPreferences.getBoolean(OTIABTCFKeys.IABTCF_GDPRAPPLIES, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getTCFConsent() {
        String string = PreferenceManager.getDefaultSharedPreferences(b.b(null, 1, null)).getString("IABTCF_TCString", null);
        if (string == null || q.z(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getUSPrivacyConsentString(String str) {
        String string = PreferenceManager.getDefaultSharedPreferences(b.b(null, 1, null)).getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, null);
        return (string == null || q.z(string)) ? str : string;
    }
}
