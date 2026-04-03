package com.onetrust.otpublishers.headless.Internal.Helper;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f {
    public static void a(JSONObject jSONObject, SharedPreferences.Editor editor, String str) {
        editor.putString(str, jSONObject.toString()).apply();
    }
}
