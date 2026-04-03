package com.onetrust.otpublishers.headless.Internal.authenticatedconsent;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import java.time.Instant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21898a;

    public c(@NonNull Context context) {
        this.f21898a = context;
    }

    public static boolean b(long j10, @NonNull JSONObject jSONObject) throws JSONException {
        long epochMilli;
        if (!jSONObject.has("preferences")) {
            return false;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("preferences");
        if (jSONArray.length() == 0) {
            return false;
        }
        long j11 = 0;
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
            if (jSONObject2.has("consentDate")) {
                String string = jSONObject2.getString("consentDate");
                epochMilli = ("null".equalsIgnoreCase(string) || com.onetrust.otpublishers.headless.Internal.c.q(string) || Build.VERSION.SDK_INT < 26) ? -1L : Instant.parse(string).toEpochMilli();
            } else {
                epochMilli = 0;
            }
            if (epochMilli > j11) {
                j11 = epochMilli;
            }
        }
        OTLogger.a("authenticatedConsentFlow", 3, "recent consented time stamp = " + j11);
        return j10 > j11;
    }

    public static boolean d(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("fetch");
        return jSONObject2.has("preferences") && jSONObject2.getJSONArray("preferences").length() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.authenticatedconsent.c.a():void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:5|(2:7|(1:9)(4:10|(1:12)(1:13)|14|(2:16|17)))(13:19|(3:21|(4:26|(1:28)(1:29)|30|(1:32))|33)|34|(1:36)(1:37)|(1:39)|40|55|41|(1:43)(1:47)|48|(2:57|50)|53|54)|18|34|(0)(0)|(0)|40|55|41|(0)(0)|48|(0)|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
    
        com.onetrust.otpublishers.headless.Internal.Helper.p.a(r0, new java.lang.StringBuilder("error while getting profile data json, err: "), "OneTrust", 6);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ee A[Catch: JSONException -> 0x00f4, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00f4, blocks: (B:41:0x00e2, B:43:0x00ee), top: B:55:0x00e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(@androidx.annotation.Nullable java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.authenticatedconsent.c.c(java.lang.String):boolean");
    }

    public final boolean e() {
        h hVar;
        boolean z10;
        String string;
        Context context = this.f21898a;
        boolean zD = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        try {
            string = sharedPreferences.getString("OT_PROFILE_DATA", "");
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("error while getting profile data json, err: "), "OneTrust", 6);
        }
        JSONObject jSONObject = !com.onetrust.otpublishers.headless.Internal.c.q(string) ? new JSONObject(string) : new JSONObject();
        if (jSONObject.has("fetch")) {
            try {
                zD = d(jSONObject);
            } catch (JSONException unused) {
                OTLogger.a("authenticatedConsentFlow", 6, "Error on parsing profile data.");
            }
        }
        OTLogger.a("authenticatedConsentFlow", 3, "New user profile flow = " + zD);
        return zD;
    }
}
