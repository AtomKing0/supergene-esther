package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class eg {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString(str);
        if (strOptString.length() == 0) {
            return null;
        }
        return strOptString;
    }
}
