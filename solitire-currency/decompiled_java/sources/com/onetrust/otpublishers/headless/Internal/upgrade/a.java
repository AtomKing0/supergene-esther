package com.onetrust.otpublishers.headless.Internal.upgrade;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Internal.Helper.f;
import com.onetrust.otpublishers.headless.Internal.Helper.j;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.g;
import com.onetrust.otpublishers.headless.Internal.c;
import com.onetrust.otpublishers.headless.Internal.profile.d;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21956a;

    public a(@NonNull Context context) {
        this.f21956a = context;
    }

    @VisibleForTesting
    public final void a() throws JSONException {
        boolean z10;
        SharedPreferences sharedPreferences = this.f21956a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (!c.q(sharedPreferences.getString("OT_MULTI_PROFILE_ID_MAP", null)) && c.q(sharedPreferences.getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null))) {
            SharedPreferences sharedPreferences2 = this.f21956a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            JSONArray jSONArray = new JSONArray(sharedPreferences2.getString("OT_MULTI_PROFILE_ID_MAP", null));
            JSONObject jSONObject = new JSONObject();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                try {
                    this.f21956a.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + string, 0);
                    z10 = true;
                } catch (IllegalArgumentException e10) {
                    OTLogger.a("OneTrust", 6, "Error on file creation, file name = " + string);
                    OTLogger.a("OneTrust", 6, "Error on file creation, error = " + e10.getMessage());
                    z10 = false;
                }
                if (z10) {
                    jSONObject.put(string, string);
                } else {
                    jSONObject.put(string, UUID.randomUUID().toString());
                }
            }
            f.a(jSONObject, sharedPreferences2.edit(), "OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: Exception -> 0x0065, TRY_LEAVE, TryCatch #1 {Exception -> 0x0065, blocks: (B:9:0x002c, B:11:0x0038, B:16:0x005a, B:18:0x0060, B:15:0x0055, B:14:0x003f), top: B:155:0x002c, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(@androidx.annotation.NonNull android.content.SharedPreferences r22) {
        /*
            Method dump skipped, instruction units count: 999
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.upgrade.a.b(android.content.SharedPreferences):void");
    }

    public final void c() {
        SharedPreferences sharedPreferences = this.f21956a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (!sharedPreferences.contains("OT_SDK_VERSION_CODE") || Long.parseLong(this.f21956a.getString(p6.f.f32897e)) > sharedPreferences.getLong("OT_SDK_VERSION_CODE", 0L)) {
            try {
                SharedPreferences sharedPreferences2 = this.f21956a.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                long j10 = Long.parseLong(this.f21956a.getString(p6.f.f32897e));
                long j11 = sharedPreferences2.getLong("OT_SDK_VERSION_CODE", 0L);
                if (j11 < 63500) {
                    if (1 == sharedPreferences2.getInt("OTT_DATA_SUBJECT_IDENTIFIER_TYPE", 1)) {
                        String string = sharedPreferences2.getString("OTT_DATA_SUBJECT_IDENTIFIER", null);
                        if (!c.q(string) && !sharedPreferences2.contains("OT_GENERIC_PROFILE_IDENTIFIER")) {
                            this.f21956a.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0).edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", string).apply();
                        }
                    }
                    b(sharedPreferences2);
                }
                if (j11 < 202310100 && new g(this.f21956a).v()) {
                    e();
                }
                if (j11 < 202402100) {
                    d(sharedPreferences2);
                }
                OTLogger.a("OTSDKUpgrade", 3, "Setting SDK version code = " + j10);
                sharedPreferences2.edit().putLong("OT_SDK_VERSION_CODE", j10).apply();
            } catch (Exception e10) {
                j.a(e10, new StringBuilder("Error on handleSDKUpgradeIfNeeded,Error = "), "OTSDKExceptions", 6);
            }
        }
        try {
            a();
        } catch (JSONException unused) {
            OTLogger.a("OneTrust", 6, "Error on handling upgrade case for multiprofile file name change.");
        }
    }

    @VisibleForTesting
    public final void d(@NonNull SharedPreferences sharedPreferences) {
        boolean z10;
        String string = this.f21956a.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0).getString("OT_ACTIVE_PROFILE_ID", "");
        if (c.q(string)) {
            return;
        }
        SharedPreferences sharedPreferences2 = this.f21956a.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new d(this.f21956a).n(string.toLowerCase(Locale.US)), 0);
        SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
        boolean z11 = true;
        if (!sharedPreferences.contains("OT_GPP_DATA_BACKUP") || sharedPreferences2.contains("OT_GPP_DATA_BACKUP")) {
            z10 = false;
        } else {
            editorEdit.putString("OT_GPP_DATA_BACKUP", sharedPreferences.getString("OT_GPP_DATA_BACKUP", ""));
            z10 = true;
        }
        if (!sharedPreferences.contains("OT_GPP_IS_ENABLED") || sharedPreferences2.contains("OT_GPP_IS_ENABLED")) {
            z11 = z10;
        } else {
            editorEdit.putBoolean("OT_GPP_IS_ENABLED", sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false));
        }
        if (z11) {
            editorEdit.apply();
        }
    }

    @VisibleForTesting
    public final void e() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f21956a);
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        if (defaultSharedPreferences.contains(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS)) {
            OTLogger.a("UpgradeHelper", 3, "Migrating IABTCF_USENONSTANDARDSTACKS - > IABTCF_USENONSTANDARDTEXTS");
            int i10 = defaultSharedPreferences.getInt(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS, 0);
            editorEdit.remove(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS);
            editorEdit.putInt(OTIABTCFKeys.IABTCF_USENONSTANDARDTEXTS, i10);
            editorEdit.apply();
        }
        if (defaultSharedPreferences.contains(OTGppKeys.IAB_GPP_USENONSTANDARDSTACKS)) {
            OTLogger.a("UpgradeHelper", 3, "Migrating IAB_GPP_USENONSTANDARDSTACKS - > IAB_GPP_USENONSTANDARDTEXTS");
            int i11 = defaultSharedPreferences.getInt(OTGppKeys.IAB_GPP_USENONSTANDARDSTACKS, 0);
            editorEdit.remove(OTGppKeys.IAB_GPP_USENONSTANDARDSTACKS);
            editorEdit.putInt(OTGppKeys.IAB_GPP_USENONSTANDARDTEXTS, i11);
            editorEdit.apply();
        }
    }
}
