package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class v {
    public static void a(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }
}
