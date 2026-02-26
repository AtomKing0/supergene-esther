package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f21761a;

    public g(@NonNull Context context) {
        this.f21761a = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context).c();
    }

    public final void a(@NonNull String str) {
        v.a(this.f21761a, "INTERACTION_TYPE", str);
    }
}
