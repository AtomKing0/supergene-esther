package com.ironsource;

import com.ironsource.qf;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class xi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f16191a = "ManRewInst_";

    public static String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String a(mi miVar) {
        return (miVar.i() ? qf.e.Banner : miVar.n() ? qf.e.RewardedVideo : qf.e.Interstitial).toString();
    }

    public static String a(JSONObject jSONObject) {
        if (!jSONObject.optBoolean("rewarded")) {
            return jSONObject.optString("name");
        }
        return f16191a + jSONObject.optString("name");
    }
}
