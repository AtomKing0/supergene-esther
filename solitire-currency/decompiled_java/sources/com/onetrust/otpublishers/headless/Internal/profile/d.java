package com.onetrust.otpublishers.headless.Internal.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.onetrust.otpublishers.headless.Internal.Helper.f;
import com.onetrust.otpublishers.headless.Internal.Helper.h;
import com.onetrust.otpublishers.headless.Internal.Helper.j0;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Network.n;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTRenameProfileParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.onetrust.otpublishers.headless.Internal.Preferences.e f21906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f21907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21908c;

    public d(@NonNull Context context) {
        this.f21908c = context;
        com.onetrust.otpublishers.headless.Internal.Preferences.e eVar = new com.onetrust.otpublishers.headless.Internal.Preferences.e(context, "OTT_DEFAULT_USER");
        this.f21906a = eVar;
        this.f21907b = new b(context, eVar);
    }

    public static boolean d(@NonNull com.onetrust.otpublishers.headless.Internal.Preferences.e eVar, @NonNull String str) throws JSONException {
        String string = eVar.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
        JSONArray jSONArray = new JSONArray();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on getting multi-profile id maps. Error = "), "MultiprofileConsent", 6);
            }
        }
        Locale locale = Locale.US;
        String lowerCase = str.toLowerCase(locale);
        String lowerCase2 = lowerCase.toLowerCase(locale);
        int i10 = 0;
        while (true) {
            if (i10 >= jSONArray.length()) {
                i10 = -1;
                break;
            }
            if (lowerCase2.equalsIgnoreCase(jSONArray.getString(i10))) {
                break;
            }
            i10++;
        }
        if (-1 != i10) {
            return false;
        }
        OTLogger.a("MultiprofileConsent", 3, "Adding profileID " + lowerCase + " to the profile map.");
        jSONArray.put(lowerCase);
        String string2 = eVar.c().getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
        JSONObject jSONObject = string2 != null ? new JSONObject(string2) : new JSONObject();
        String string3 = eVar.c().getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
        if (!lowerCase.equalsIgnoreCase(string3)) {
            string3 = UUID.randomUUID().toString();
        }
        jSONObject.put(lowerCase, string3);
        eVar.c().edit().putString("OT_MULTI_PROFILE_ID_MAP", jSONArray.toString()).apply();
        f.a(jSONObject, eVar.c().edit(), "OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP");
        return true;
    }

    @Nullable
    public final String a(@Nullable OTSdkParams oTSdkParams) {
        OTProfileSyncParams otProfileSyncParams;
        if (oTSdkParams != null && (otProfileSyncParams = oTSdkParams.getOtProfileSyncParams()) != null) {
            String identifier = otProfileSyncParams.getIdentifier();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(identifier)) {
                return identifier;
            }
            if (identifier != null && identifier.isEmpty()) {
                return o();
            }
        }
        return this.f21906a.c().getString("OTT_DATA_SUBJECT_IDENTIFIER", null);
    }

    public final void b() {
        e eVar = new e(this.f21908c);
        String string = eVar.f21909a.c().getString("OT_MULTI_PROFILE_DELETE_ID", null);
        if (string == null || com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return;
        }
        try {
            i(string);
            OTLogger.a("authenticatedConsentFlow", 4, "Deleting the old profile : ".concat(string));
            eVar.a();
        } catch (JSONException e10) {
            StringBuilder sb = new StringBuilder("Error on profile delete : ");
            sb.append(string);
            sb.append(" , error = ");
            p.a(e10, sb, "authenticatedConsentFlow", 6);
        }
    }

    public final void c(@NonNull String str, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        d dVar = new d(this.f21908c);
        Context context = this.f21908c;
        new n(context).h(null, com.onetrust.otpublishers.headless.Internal.Preferences.f.a(dVar.f21906a), null, null, oTPublishersHeadlessSDK, false);
        new com.onetrust.otpublishers.headless.Internal.Helper.c(context).h(context, dVar.f21906a.c().getString("OT_IAB_GLOBAL_VENDORLIST", ""));
        com.onetrust.otpublishers.headless.Internal.Helper.a.c(context, dVar.f21906a.c().getString("OT_GOOGLE_GVL_COMPLETE_OBJECT", null));
        OTLogger.a("MultiprofileConsent", 4, "The user’s profile has been switched successfully. Profile switched to : " + str);
    }

    public final boolean e(@NonNull OTRenameProfileParams oTRenameProfileParams) {
        boolean z10;
        String oldProfileID = oTRenameProfileParams.getOldProfileID();
        if (com.onetrust.otpublishers.headless.Internal.c.q(oldProfileID)) {
            OTLogger.a("OneTrust", 5, "Empty oldProfileID passed,  using the generic profile Id as oldProfileID.");
            oldProfileID = m();
            oTRenameProfileParams = OTRenameProfileParams.OTRenameProfileParamsBuilder.newInstance().setOldProfileID(oldProfileID).setNewProfileID(oTRenameProfileParams.getNewProfileID()).setIdentifierType(oTRenameProfileParams.getIdentifierType()).build();
        }
        String newProfileID = oTRenameProfileParams.getNewProfileID();
        if (com.onetrust.otpublishers.headless.Internal.c.q(oldProfileID)) {
            OTLogger.a("OneTrust", 5, "Empty oldProfileID passed,  and no Active profile exist. Rename profile failed.");
        } else {
            if (!com.onetrust.otpublishers.headless.Internal.c.q(newProfileID)) {
                z10 = true;
                String string = this.f21906a.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
                if (!z10 && !com.onetrust.otpublishers.headless.Internal.c.q(string)) {
                    try {
                        return f(oTRenameProfileParams, string);
                    } catch (JSONException e10) {
                        p.a(e10, new StringBuilder("JSON error on renameProfile. Error = "), "MultiprofileConsent", 6);
                        return false;
                    }
                }
            }
            OTLogger.a("OneTrust", 5, "Empty newProfileID passed,  Please pass a valid user ID to update.");
        }
        z10 = false;
        String string2 = this.f21906a.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
        return !z10 ? false : false;
    }

    public final boolean f(@NonNull OTRenameProfileParams oTRenameProfileParams, String str) throws JSONException {
        boolean z10;
        boolean z11;
        boolean z12;
        JSONArray jSONArray = new JSONArray(str);
        String oldProfileID = oTRenameProfileParams.getOldProfileID();
        String newProfileID = oTRenameProfileParams.getNewProfileID();
        String lowerCase = oldProfileID.toLowerCase(Locale.US);
        int i10 = 0;
        while (true) {
            if (i10 >= jSONArray.length()) {
                i10 = -1;
                break;
            }
            if (lowerCase.equalsIgnoreCase(jSONArray.getString(i10))) {
                break;
            }
            i10++;
        }
        if (-1 != i10) {
            z10 = true;
        } else {
            OTLogger.a("MultiprofileConsent", 5, "No user profile found with ID " + oldProfileID + ". Please pass a valid user ID to update");
            z10 = false;
        }
        String lowerCase2 = newProfileID.toLowerCase(Locale.US);
        int i11 = 0;
        while (true) {
            if (i11 >= jSONArray.length()) {
                i11 = -1;
                break;
            }
            if (lowerCase2.equalsIgnoreCase(jSONArray.getString(i11))) {
                break;
            }
            i11++;
        }
        if (-1 != i11) {
            OTLogger.a("MultiprofileConsent", 5, "Two users cannot have the same user ID " + newProfileID + ". Thus, pass a unique user ID");
            z11 = false;
        } else {
            z11 = true;
        }
        if (z10 && z11) {
            OTLogger.a("MultiprofileConsent", 5, "Renaming profile ID from  " + oldProfileID + " , to " + newProfileID + " .");
            String strM = m();
            String string = this.f21906a.c().getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
            com.onetrust.otpublishers.headless.Internal.Preferences.e eVar = this.f21906a;
            String string2 = eVar.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
            JSONArray jSONArray2 = new JSONArray();
            if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                try {
                    jSONArray2 = new JSONArray(string2);
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error on getting multi-profile id maps. Error = "), "MultiprofileConsent", 6);
                }
            }
            Locale locale = Locale.US;
            String lowerCase3 = newProfileID.toLowerCase(locale);
            String lowerCase4 = lowerCase3.toLowerCase(locale);
            int i12 = 0;
            while (true) {
                if (i12 >= jSONArray2.length()) {
                    i12 = -1;
                    break;
                }
                if (lowerCase4.equalsIgnoreCase(jSONArray2.getString(i12))) {
                    break;
                }
                i12++;
            }
            if (-1 != i12) {
                z12 = false;
            } else {
                String strN = n(oldProfileID.toLowerCase(locale));
                k(oldProfileID);
                OTLogger.a("MultiprofileConsent", 3, "Adding profileID " + lowerCase3 + " to the profile map.");
                jSONArray2.put(lowerCase3);
                String string3 = eVar.c().getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
                JSONObject jSONObject = string3 != null ? new JSONObject(string3) : new JSONObject();
                jSONObject.put(lowerCase3, strN);
                eVar.c().edit().putString("OT_MULTI_PROFILE_ID_MAP", jSONArray2.toString()).apply();
                f.a(jSONObject, eVar.c().edit(), "OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP");
                z12 = true;
            }
            if (z12) {
                String oldProfileID2 = oTRenameProfileParams.getOldProfileID();
                String newProfileID2 = oTRenameProfileParams.getNewProfileID();
                if (oldProfileID2.equalsIgnoreCase(strM)) {
                    this.f21907b.a(newProfileID2);
                }
                if (oldProfileID2.equalsIgnoreCase(string)) {
                    v("");
                }
                try {
                    j0 j0Var = new j0(this.f21908c);
                    j0Var.b(this.f21908c, newProfileID2);
                    j0Var.f21770b.c(2);
                    j0Var.f21770b.f21893a.b(oTRenameProfileParams.getIdentifierType());
                    return true;
                } catch (JSONException e11) {
                    p.a(e11, new StringBuilder("error in updating consent : "), "MultiprofileConsent", 6);
                }
            }
        }
        return false;
    }

    public final boolean g(@Nullable OTCallback oTCallback, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK, @NonNull String str, @Nullable String str2, @Nullable String str3, boolean z10) {
        boolean zI;
        String lowerCase = str.toLowerCase(Locale.US);
        try {
            zI = i(lowerCase);
        } catch (JSONException e10) {
            StringBuilder sb = new StringBuilder("Exception on profile delete for id = ");
            sb.append(lowerCase);
            sb.append(" . Exception = ");
            p.a(e10, sb, "MultiprofileConsent", 6);
            zI = false;
        }
        if (zI) {
            if (lowerCase.equalsIgnoreCase(this.f21906a.c().getString("OT_GENERIC_PROFILE_IDENTIFIER", null))) {
                v("");
            }
            if (lowerCase.equalsIgnoreCase(m())) {
                u("");
                l(oTCallback, oTPublishersHeadlessSDK, o(), str2, str3, z10);
            } else if (oTCallback != null) {
                oTCallback.onSuccess(new OTResponse(OTResponseType.OT_SUCCESS, 14, this.f21908c.getResources().getString(p6.f.f32910r), ""));
            }
        } else if (oTCallback != null) {
            oTCallback.onFailure(new OTResponse(OTResponseType.OT_ERROR, 13, this.f21908c.getResources().getString(p6.f.f32909q), ""));
        }
        return zI;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b A[Catch: Exception -> 0x0060, TRY_LEAVE, TryCatch #0 {Exception -> 0x0060, blocks: (B:9:0x0027, B:11:0x0033, B:16:0x0055, B:18:0x005b, B:15:0x0050, B:14:0x003a), top: B:41:0x0027, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(@androidx.annotation.NonNull com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r9, @androidx.annotation.Nullable com.onetrust.otpublishers.headless.Public.OTCallback r10) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.profile.d.h(com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK, com.onetrust.otpublishers.headless.Public.OTCallback):boolean");
    }

    public final boolean i(@NonNull String str) {
        String str2;
        String lowerCase = str.toLowerCase(Locale.US);
        String strP = p(lowerCase);
        boolean z10 = true;
        if (!com.onetrust.otpublishers.headless.Internal.c.q(strP)) {
            String str3 = "com.onetrust.otpublishers.headless.preference.OTT_USER_" + strP;
            this.f21908c.getSharedPreferences(str3, 0).edit().clear().apply();
            if (Build.VERSION.SDK_INT >= 24) {
                if (this.f21908c.deleteSharedPreferences(str3)) {
                    OTLogger.a("MultiprofileConsent", 4, "Profile file " + str3 + " deleted.");
                    str2 = "Profile " + lowerCase + " deleted.";
                } else {
                    OTLogger.a("MultiprofileConsent", 4, "Failed to delete profile file " + str3 + " .");
                    str2 = "Failed to delete profile " + lowerCase + " .";
                    z10 = false;
                }
                OTLogger.a("MultiprofileConsent", 4, str2);
            }
        }
        k(lowerCase);
        return z10;
    }

    public final void j() {
        OTLogger.a("multiProfileEnabled", 3, "enableMultiProfile called.");
        this.f21906a.c().edit().putString("OT_ENABLE_MULTI_PROFILE", Boolean.TRUE.toString()).apply();
    }

    public final void k(@NonNull String str) {
        String string = this.f21906a.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
        String string2 = this.f21906a.c().getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string) || com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
            return;
        }
        JSONArray jSONArray = new JSONArray(string);
        JSONObject jSONObject = new JSONObject(string2);
        String lowerCase = str.toLowerCase(Locale.US);
        int i10 = 0;
        while (true) {
            if (i10 >= jSONArray.length()) {
                i10 = -1;
                break;
            } else if (lowerCase.equalsIgnoreCase(jSONArray.getString(i10))) {
                break;
            } else {
                i10++;
            }
        }
        if (-1 != i10) {
            jSONObject.remove(jSONArray.getString(i10));
            jSONArray.remove(i10);
            this.f21906a.c().edit().putString("OT_MULTI_PROFILE_ID_MAP", jSONArray.toString()).apply();
            f.a(jSONObject, this.f21906a.c().edit(), "OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: Exception -> 0x0065, TRY_LEAVE, TryCatch #0 {Exception -> 0x0065, blocks: (B:9:0x002d, B:11:0x0039, B:16:0x005a, B:18:0x0060, B:15:0x0055, B:14:0x0040), top: B:82:0x002d, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(@androidx.annotation.Nullable com.onetrust.otpublishers.headless.Public.OTCallback r19, @androidx.annotation.NonNull com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r20, @androidx.annotation.NonNull java.lang.String r21, @androidx.annotation.Nullable java.lang.String r22, @androidx.annotation.Nullable java.lang.String r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onetrust.otpublishers.headless.Internal.profile.d.l(com.onetrust.otpublishers.headless.Public.OTCallback, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK, java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    @Nullable
    public final String m() {
        return this.f21906a.c().getString("OT_ACTIVE_PROFILE_ID", "");
    }

    @NonNull
    public final String n(@NonNull String str) {
        String strP = p(str);
        return strP != null ? strP : o();
    }

    @NonNull
    public final String o() {
        String string = this.f21906a.c().getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        v(string2);
        return string2;
    }

    @Nullable
    public final String p(@NonNull String str) {
        String string = this.f21906a.c().getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                String string2 = new JSONObject(string).getString(str);
                if (!com.onetrust.otpublishers.headless.Internal.c.q(string2)) {
                    return string2;
                }
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on profile ID file name map. Error = "), "MultiprofileConsent", 6);
            }
        }
        Context context = this.f21908c;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(sharedPreferences.getString("OT_MULTI_PROFILE_ID_MAP", null)) && com.onetrust.otpublishers.headless.Internal.c.q(sharedPreferences.getString("OT_MULTI_PROFILE_PROFILE_ID_FILE_MAP", null))) {
            if (!(context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getLong("OT_SDK_VERSION_CODE", 0L) >= 63900)) {
                try {
                    this.f21908c.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + str, 0);
                    z10 = true;
                } catch (IllegalArgumentException e11) {
                    OTLogger.a("MultiprofileConsent", 6, "Error on file creation, file name = " + str);
                    OTLogger.a("MultiprofileConsent", 6, "Error on file creation, error = " + e11.getMessage());
                }
                if (z10) {
                    return str;
                }
            }
        }
        return null;
    }

    public final int q() {
        String string = this.f21906a.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
        if (com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            return -1;
        }
        try {
            return new JSONArray(string).length();
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error on getting profilemap JSON. Error = "), "MultiprofileConsent", 6);
            return -1;
        }
    }

    public final boolean r(@Nullable String str) {
        if (str == null) {
            return false;
        }
        String string = this.f21906a.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
        if (!com.onetrust.otpublishers.headless.Internal.c.q(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                String lowerCase = str.toLowerCase(Locale.US);
                int i10 = 0;
                while (true) {
                    if (i10 >= jSONArray.length()) {
                        i10 = -1;
                        break;
                    }
                    if (lowerCase.equalsIgnoreCase(jSONArray.getString(i10))) {
                        break;
                    }
                    i10++;
                }
                return true ^ (-1 != i10);
            } catch (JSONException e10) {
                p.a(e10, new StringBuilder("Error on getting profilemap. Error = "), "MultiprofileConsent", 6);
            }
        }
        return false;
    }

    @VisibleForTesting
    public final int s(@Nullable String str) {
        String strM = m();
        if (!com.onetrust.otpublishers.headless.Internal.c.q(strM) && strM.equalsIgnoreCase(str)) {
            return 0;
        }
        if (!com.onetrust.otpublishers.headless.Internal.c.q(str)) {
            this.f21907b.b(strM, str, true, true);
            return 1;
        }
        if (str == null && com.onetrust.otpublishers.headless.Internal.c.q(strM)) {
            this.f21907b.b(strM, o(), false, false);
            return 2;
        }
        if (str == null && !com.onetrust.otpublishers.headless.Internal.c.q(strM)) {
            return 3;
        }
        if (str == null || !str.isEmpty()) {
            return -1;
        }
        this.f21907b.b(strM, o(), true, true);
        return 4;
    }

    public final boolean t() {
        return h.a(Boolean.FALSE, this.f21906a.c(), "OT_ENABLE_MULTI_PROFILE");
    }

    public final void u(@NonNull String str) {
        this.f21906a.c().edit().putString("OT_ACTIVE_PROFILE_ID", str.toLowerCase(Locale.US)).apply();
    }

    public final void v(@NonNull String str) {
        this.f21906a.c().edit().putString("OT_GENERIC_PROFILE_IDENTIFIER", str).apply();
    }
}
