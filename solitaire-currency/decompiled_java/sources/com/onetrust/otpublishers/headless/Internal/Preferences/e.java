package com.onetrust.otpublishers.headless.Internal.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f21889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f21890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f21891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f21892d;

    public e(@NonNull Context context, @NonNull String str) {
        this.f21892d = context;
        this.f21889a = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat(str), 0);
    }

    public final void a() {
        if (this.f21891c) {
            try {
                com.onetrust.otpublishers.headless.Internal.profile.d dVar = new com.onetrust.otpublishers.headless.Internal.profile.d(this.f21892d);
                String string = dVar.f21906a.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        dVar.i(jSONArray.getString(i10));
                    }
                }
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on clearing multi-profile files. Error = "), "OneTrust", 6);
            }
        }
        this.f21889a.edit().clear().apply();
    }

    public final void b(@Nullable String str) {
        if (com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            return;
        }
        c().edit().putString("OTT_IDENTIFIER_TYPE", str).apply();
    }

    @NonNull
    public final SharedPreferences c() {
        return this.f21891c ? this.f21890b : this.f21889a;
    }

    public final boolean d() {
        SharedPreferences sharedPreferencesC = c();
        String string = sharedPreferencesC.getString("OTT_CREATE_CONSENT_PROFILE_STRING", null);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            boolean z10 = Boolean.parseBoolean(string);
            int i10 = sharedPreferencesC.getInt("OTT_DATA_SUBJECT_IDENTIFIER_TYPE", 1);
            if (!z10 || i10 != 1) {
                return z10;
            }
        }
        return false;
    }

    public e(@NonNull Context context) {
        this.f21892d = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        this.f21889a = sharedPreferences;
        if (l.a(context)) {
            this.f21891c = true;
            this.f21890b = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
        }
    }
}
