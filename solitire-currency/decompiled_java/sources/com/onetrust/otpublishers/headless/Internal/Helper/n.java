package com.onetrust.otpublishers.headless.Internal.Helper;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class n {
    public static void a(JSONException jSONException, StringBuilder sb, String str, int i10) {
        sb.append(jSONException.toString());
        OTLogger.a(str, i10, sb.toString());
    }
}
