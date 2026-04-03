package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f21818a;

    public z(@NonNull Context context) {
        this.f21818a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context).c();
    }

    public final void a() {
        this.f21818a.edit().putInt("OT_UCP_USER_CONSENT_STATUS", 1).apply();
    }

    public final void b() {
        this.f21818a.edit().putInt("OTT_USER_CONSENT_STATUS", 1).apply();
    }
}
