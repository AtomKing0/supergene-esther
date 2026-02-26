package com.onetrust.otpublishers.headless.gpp;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f23796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f23797b;

    public e(Context context) {
        this.f23796a = context;
        this.f23797b = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
    }

    public static int b(boolean z10) {
        return z10 ? 1 : 2;
    }

    @NonNull
    public static StringBuilder c(@NonNull HashMap map, @NonNull String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            Integer num = (Integer) map.get(str);
            if (num != null) {
                sb.append(g.a(num.intValue(), 2));
            }
        }
        return sb;
    }

    public final int a(String str) {
        int i10;
        if (!d(str)) {
            return 0;
        }
        Context context = this.f23796a;
        JSONObject jSONObject = new JSONObject();
        new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
        com.onetrust.otpublishers.headless.Internal.Preferences.g gVar = new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
        new JSONObject();
        new com.onetrust.otpublishers.headless.Internal.Preferences.e(context);
        new com.onetrust.otpublishers.headless.Internal.Preferences.g(context);
        try {
            i10 = jSONObject.has(str) ? jSONObject.getInt(str) : gVar.a(str);
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error while getting updated value of Purpose Consent "), "CustomGroupDetails", 6);
            i10 = -1;
        }
        return i10 == 1 ? 2 : 1;
    }

    public final boolean d(@NonNull String str) {
        boolean zHas;
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return false;
        }
        String string = this.f23797b.c().getString("OT_UI_VALID_GROUP_IDS", "");
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            zHas = false;
        } else {
            Locale locale = Locale.ENGLISH;
            zHas = new JSONObject(string.toLowerCase(locale)).has(str.toLowerCase(locale));
        }
        return zHas;
    }

    public final boolean e(@NonNull String str) {
        h hVar;
        boolean z10;
        Context context = this.f23796a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
            z10 = false;
        }
        new c(context);
        if (z10) {
            sharedPreferences = hVar;
        }
        if (sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false)) {
            com.onetrust.otpublishers.headless.Internal.Preferences.e eVar = this.f23797b;
            String string = eVar.c().getString("OT_TEMPLATE_TYPE", "");
            String str2 = com.onetrust.otpublishers.headless.Internal.c.q(string) ? "" : string;
            if (eVar.c().getBoolean("OT_USE_GPP_USNATIONAL", false)) {
                str2 = "USNATIONAL";
            }
            if (str.equalsIgnoreCase(str2)) {
                return false;
            }
        }
        return true;
    }
}
