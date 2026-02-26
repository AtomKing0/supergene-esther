package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h {
    public static boolean a(Boolean bool, SharedPreferences sharedPreferences, String str) {
        return com.onetrust.otpublishers.headless.Internal.b.a(sharedPreferences.getString(str, bool.toString()));
    }
}
