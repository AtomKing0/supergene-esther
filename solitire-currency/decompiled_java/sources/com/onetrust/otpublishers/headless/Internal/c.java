package com.onetrust.otpublishers.headless.Internal;

import android.app.UiModeManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.onetrust.otpublishers.headless.Internal.Helper.c0;
import com.onetrust.otpublishers.headless.Internal.Helper.d;
import com.onetrust.otpublishers.headless.Internal.Helper.g0;
import com.onetrust.otpublishers.headless.Internal.Helper.j;
import com.onetrust.otpublishers.headless.Internal.Helper.j0;
import com.onetrust.otpublishers.headless.Internal.Helper.l;
import com.onetrust.otpublishers.headless.Internal.Helper.p;
import com.onetrust.otpublishers.headless.Internal.Helper.q;
import com.onetrust.otpublishers.headless.Internal.Helper.t;
import com.onetrust.otpublishers.headless.Internal.Helper.v;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Internal.Preferences.e;
import com.onetrust.otpublishers.headless.Internal.Preferences.g;
import com.onetrust.otpublishers.headless.Internal.Preferences.h;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTThemeConstants;
import com.onetrust.otpublishers.headless.UI.TVUI.fragments.k;
import com.onetrust.otpublishers.headless.UI.fragment.a3;
import com.onetrust.otpublishers.headless.UI.fragment.c1;
import com.onetrust.otpublishers.headless.UI.fragment.h1;
import com.onetrust.otpublishers.headless.UI.fragment.i0;
import com.onetrust.otpublishers.headless.UI.fragment.l0;
import com.onetrust.otpublishers.headless.UI.fragment.m2;
import com.onetrust.otpublishers.headless.UI.fragment.o0;
import com.onetrust.otpublishers.headless.UI.fragment.r;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    @NonNull
    public static OTSdkParams a(@NonNull Context context) {
        h hVar;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (l.a(context)) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OTT_REGION_CODE", null);
        String string2 = sharedPreferences.getString("OTT_COUNTRY_CODE", null);
        String string3 = sharedPreferences.getString("OTT_CREATE_CONSENT_PROFILE_STRING", null);
        String string4 = sharedPreferences.getString("OTT_PROFILE_SYNC_PROFILE_STRING", null);
        String string5 = sharedPreferences.getString("OTT_DATA_SUBJECT_IDENTIFIER", null);
        String string6 = sharedPreferences.getString("OTT_IDENTIFIER_TYPE", null);
        String string7 = sharedPreferences.getString("OTT_PROFILE_SYNC_PROFILE_AUTH", null);
        String string8 = sharedPreferences.getString("OTT_PROFILE_TENANT_ID", null);
        String string9 = sharedPreferences.getString("OTT_PROFILE_SYNC_GROUP_ID", null);
        OTProfileSyncParams.OTProfileSyncParamsBuilder oTProfileSyncParamsBuilderNewInstance = OTProfileSyncParams.OTProfileSyncParamsBuilder.newInstance();
        if (string4 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setSyncProfile(string4);
        }
        if (string5 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setIdentifier(string5);
        }
        if (string6 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setIdentifierType(string6);
        }
        if (string7 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setSyncProfileAuth(string7);
        }
        if (string8 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setTenantId(string8);
        }
        if (string9 != null) {
            oTProfileSyncParamsBuilderNewInstance = oTProfileSyncParamsBuilderNewInstance.setSyncGroupId(string9);
        }
        OTSdkParams.SdkParamsBuilder profileSyncParams = OTSdkParams.SdkParamsBuilder.newInstance().setProfileSyncParams(oTProfileSyncParamsBuilderNewInstance.build());
        if (string3 != null) {
            profileSyncParams = profileSyncParams.shouldCreateProfile(string3);
        }
        String string10 = sharedPreferences.getString("OTT_SDK_API_VERSION", null);
        if (string10 != null) {
            profileSyncParams = profileSyncParams.setAPIVersion(string10);
        }
        if (string != null) {
            profileSyncParams = profileSyncParams.setOTRegionCode(string);
        }
        if (string2 != null) {
            profileSyncParams = profileSyncParams.setOTCountryCode(string2);
        }
        return profileSyncParams.build();
    }

    @Nullable
    public static Date b(@NonNull String str) {
        try {
            return new Date(str);
        } catch (Exception e10) {
            j.a(e10, new StringBuilder("Error on converting tc string date on update, message = "), "OTUtils", 6);
            return null;
        }
    }

    @NonNull
    public static void c(@NonNull Context context, int i10) {
        h hVar;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        sharedPreferences.edit().putInt("OneTrustBannerShownToUser", i10).apply();
    }

    public static void d(@NonNull Context context, @Nullable OTSdkParams oTSdkParams, boolean z10) {
        boolean z11;
        h hVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        boolean z12 = true;
        h hVar2 = null;
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z11 = true;
        } else {
            z11 = false;
            hVar = null;
        }
        if (z11) {
            sharedPreferences = hVar;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (oTSdkParams != null) {
            if (oTSdkParams.getCreateProfile() != null) {
                editorEdit.putString("OTT_CREATE_CONSENT_PROFILE_STRING", oTSdkParams.getCreateProfile());
            }
            if (oTSdkParams.getOTCountryCode() != null) {
                editorEdit.putString("OTT_COUNTRY_CODE", oTSdkParams.getOTCountryCode());
            }
            if (oTSdkParams.getOTRegionCode() != null) {
                editorEdit.putString("OTT_REGION_CODE", oTSdkParams.getOTRegionCode());
            }
            if (oTSdkParams.getOTSdkAPIVersion() != null) {
                editorEdit.putString("OTT_SDK_API_VERSION", oTSdkParams.getOTSdkAPIVersion());
            }
            if (oTSdkParams.getOtBannerHeight() != null) {
                editorEdit.putString("OTT_BANNER_POSITION", oTSdkParams.getOtBannerHeight());
            } else {
                editorEdit.putString("OTT_BANNER_POSITION", "");
            }
            boolean syncWebSDKConsent = oTSdkParams.getSyncWebSDKConsent();
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (l.a(context)) {
                hVar2 = new h(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
            } else {
                z12 = false;
            }
            if (syncWebSDKConsent) {
                String string = (z12 ? hVar2 : sharedPreferences2).getString("OTT_DOMAIN", "");
                SharedPreferences sharedPreferences3 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (l.a(context)) {
                    new h(context, sharedPreferences3, sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", ""));
                }
                if (string.trim().equals(context.getSharedPreferences("com.onetrust.otpublisherssdk.Internal.preference", 0).getString("APPLICATION_ID_TO_LOAD", "").trim())) {
                    if ((z12 ? hVar2 : sharedPreferences2).getInt("OT_MIGRATION_STATUS", 5) != 3) {
                        if (z12) {
                            sharedPreferences2 = hVar2;
                        }
                        sharedPreferences2.edit().putInt("OT_MIGRATION_STATUS", 0).apply();
                        OTLogger.a("OneTrust", 4, "Configured for Syncing data from Web SDK");
                    }
                } else {
                    if (z12) {
                        sharedPreferences2 = hVar2;
                    }
                    sharedPreferences2.edit().putInt("OT_MIGRATION_STATUS", 4).apply();
                    OTLogger.a("OneTrust", 5, "No data found in Web SDK for the domain id passed. Hence cannot sync Web SDK consent data. \nTo sync Web SDK consent data, please pass same appID as Web SDK.");
                }
            } else {
                if (z12) {
                    sharedPreferences2 = hVar2;
                }
                sharedPreferences2.edit().putInt("OT_MIGRATION_STATUS", 5).apply();
                OTLogger.a("OTUtils", 4, "syncWebSDKConsent Disabled.");
            }
            OTProfileSyncParams otProfileSyncParams = oTSdkParams.getOtProfileSyncParams();
            if (otProfileSyncParams != null) {
                if (otProfileSyncParams.getSyncProfile() != null) {
                    editorEdit.putString("OTT_PROFILE_SYNC_PROFILE_STRING", otProfileSyncParams.getSyncProfile());
                }
                s(context, otProfileSyncParams.getIdentifier());
                String identifierType = otProfileSyncParams.getIdentifierType();
                if (identifierType != null) {
                    editorEdit.putString("OTT_IDENTIFIER_TYPE", identifierType);
                }
                if (otProfileSyncParams.getSyncProfileAuth() != null) {
                    editorEdit.putString("OTT_PROFILE_SYNC_PROFILE_AUTH", otProfileSyncParams.getSyncProfileAuth());
                }
                if (otProfileSyncParams.getTenantId() != null) {
                    editorEdit.putString("OTT_PROFILE_TENANT_ID", otProfileSyncParams.getTenantId());
                }
                if (otProfileSyncParams.getSyncGroupId() != null) {
                    editorEdit.putString("OTT_PROFILE_SYNC_GROUP_ID", otProfileSyncParams.getSyncGroupId());
                }
                OTLogger.a("OTUtils", 3, "OTSync Profile params : " + otProfileSyncParams.toString());
            }
            OTUXParams oTUXParams = oTSdkParams.getOTUXParams();
            if (oTUXParams != null) {
                if (oTUXParams.getUxParam() != null) {
                    g(context, oTUXParams.getUxParam());
                }
                if (oTUXParams.getOTSDKTheme() != null) {
                    p(context, oTUXParams.getOTSDKTheme());
                }
            }
        }
        editorEdit.putBoolean("OTT_LOAD_OFFLINE_DATA", z10);
        editorEdit.apply();
        OTLogger.a("OTUtils", 4, "saving OTSDK parameters to preferences");
    }

    public static void e(@NonNull Context context, @NonNull String str) {
        String str2;
        try {
            Uri uri = Uri.parse(str);
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            if (com.onetrust.otpublishers.headless.UI.mobiledatautils.c.i(context, "OT_BANNERloadExternalURL")) {
                customTabsIntentBuild.launchUrl(context, uri);
            }
        } catch (ActivityNotFoundException unused) {
            str2 = "Could not load the url : URL passed may be invalid " + str;
            OTLogger.a("OneTrust", 6, str2);
        } catch (Exception unused2) {
            str2 = "Could not find class androidx.browser.customtabs.CustomTabsIntent$Builder, add implementation 'androidx.browser:browser:{version}' to gradle file";
            OTLogger.a("OneTrust", 6, str2);
        }
    }

    public static void f(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        h hVar;
        String str4;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        String string = (z10 ? hVar : sharedPreferences).getString("OTT_BLOBLOCATION", "");
        String string2 = (z10 ? hVar : sharedPreferences).getString("OTT_DOMAIN", "");
        String string3 = (z10 ? hVar : sharedPreferences).getString("OTT_LANG_CODE", "");
        String str5 = string.trim() + string2.trim();
        String str6 = str.trim() + str2.trim();
        SharedPreferences sharedPreferences2 = sharedPreferences;
        OTLogger.a("OTUtils", 4, "OTT data parameters" + str5 + "," + str6);
        boolean zEquals = str5.equals(str6) ^ true;
        if (q(string) && q(string2) && q(string3)) {
            if (z10) {
                sharedPreferences2 = hVar;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
            editorEdit.putString("OTT_BLOBLOCATION", str);
            editorEdit.putString("OTT_DOMAIN", str2);
            editorEdit.putString("OTT_LANG_CODE", str3);
            editorEdit.apply();
            OTLogger.a("OTUtils", 4, "saving init parameters to preferences");
            return;
        }
        if (zEquals) {
            y(context);
            oTPublishersHeadlessSDK.reInitiateLocalVariable();
            if (z10) {
                sharedPreferences2 = hVar;
            }
            SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
            editorEdit2.putString("OTT_BLOBLOCATION", str);
            editorEdit2.putString("OTT_DOMAIN", str2);
            editorEdit2.putString("OTT_LANG_CODE", str3);
            editorEdit2.apply();
            OTLogger.a("OTUtils", 4, "saving init parameters to preferences");
            str4 = "OTT data parameters changed";
        } else {
            str4 = "OTT data parameters not changed";
        }
        OTLogger.a("OTUtils", 4, str4);
    }

    public static void g(@NonNull Context context, @NonNull JSONObject jSONObject) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).edit();
        editorEdit.putString("OTT_UX_PARAMS_JSON", jSONObject.toString());
        editorEdit.apply();
    }

    public static void h(@NonNull e eVar, @NonNull String str) {
        eVar.c().edit().putString("OT_MOBILE_DATA_OVERRIDE_THEME", str).apply();
    }

    public static void i(@NonNull JSONArray jSONArray, @NonNull Context context, boolean z10) {
        boolean zT = new g(context).t();
        if (z10) {
            OTLogger.a("OTUtils", 3, "Clearing IAB data from storage as saved TC string got expired");
            new t(context).j(jSONArray, new JSONObject(), false);
            q.a(zT).getClass();
            q.g(context);
            com.onetrust.otpublishers.headless.gpp.c cVar = new com.onetrust.otpublishers.headless.gpp.c(context);
            if (cVar.f23791b.isEmpty()) {
                cVar.d();
            }
            if (cVar.f23791b.keySet().isEmpty()) {
                return;
            }
            for (String str : cVar.f23791b.keySet()) {
                if (!q(str) && (str.startsWith("IABGPP_TCFEU2_") || str.equalsIgnoreCase(OTGppKeys.IAB_GPP_TCFEU2_STRING))) {
                    cVar.f23792c.a(str);
                }
            }
        }
    }

    public static boolean j(Fragment fragment, @NonNull String str) {
        if (str.equals("LAYER_1")) {
            return (fragment instanceof r) || (fragment instanceof l0) || (fragment instanceof k);
        }
        if (str.equals("LAYER_2")) {
            return (fragment instanceof i0) || (fragment instanceof m2);
        }
        if (str.equals("LAYER_3")) {
            return (fragment instanceof a3) || (fragment instanceof c1) || (fragment instanceof o0) || (fragment instanceof h1);
        }
        return false;
    }

    public static boolean k(@NonNull FragmentActivity fragmentActivity, @NonNull String str) {
        Fragment fragmentFindFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
        return j(fragmentFindFragmentByTag, "LAYER_1") || j(fragmentFindFragmentByTag, "LAYER_2") || j(fragmentFindFragmentByTag, "LAYER_3");
    }

    public static boolean l(@Nullable String str, boolean z10) {
        return q(str) ? z10 : Boolean.parseBoolean(str);
    }

    public static boolean m(JSONArray jSONArray, @Nullable JSONObject jSONObject, long j10, Context context) {
        if (-1 != j10 && !com.onetrust.otpublishers.headless.Internal.Helper.k.d(context)) {
            int days = (int) TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - j10);
            if (jSONObject != null && jSONObject.has("IABReconsentFrequencyDays")) {
                try {
                    boolean z10 = days > jSONObject.getInt("IABReconsentFrequencyDays");
                    i(jSONArray, context, z10);
                    return z10;
                } catch (JSONException e10) {
                    p.a(e10, new StringBuilder("Error on getting IAB reconsent frequency days,  message = "), "OTUtils", 6);
                }
            }
        }
        return false;
    }

    public static boolean n(@Nullable JSONObject jSONObject, @Nullable String str) {
        if (str == null || q(str) || "0".equals(str)) {
            return false;
        }
        return jSONObject != null && jSONObject.has("ReconsentFrequencyDays") && ((int) TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - Long.parseLong(str))) >= jSONObject.optInt("ReconsentFrequencyDays", 0);
    }

    @NonNull
    public static String o(@NonNull Context context) {
        h hVar;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_SCRIPT_TYPE", "");
        return q(string) ? "" : string;
    }

    public static void p(@NonNull Context context, @NonNull String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).edit();
        editorEdit.putString("OT_UX_SDK_THEME", str);
        editorEdit.apply();
    }

    public static boolean q(@Nullable String str) {
        return str == null || str.length() == 0;
    }

    @NonNull
    public static String r(@NonNull Context context) {
        h hVar;
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, c0.a(context, "OTT_DEFAULT_USER"), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string = sharedPreferences.getString("OT_SYNC_GROUP_ID", "");
        return q(string) ? "" : string;
    }

    public static boolean s(@NonNull Context context, @Nullable String str) {
        int i10;
        if (str == null) {
            OTLogger.a("OTUtils", 4, "setDataSubjectIdentifier: Pass a valid identifier.");
            return false;
        }
        j0 j0Var = new j0(context);
        if (str.isEmpty()) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0);
            str = sharedPreferences.getString("OT_GENERIC_PROFILE_IDENTIFIER", null);
            if (q(str)) {
                str = UUID.randomUUID().toString();
                v.a(sharedPreferences, "OT_GENERIC_PROFILE_IDENTIFIER", str);
            }
            d.a("Generated identifier = ", str, "OTUtils", 4);
            i10 = 1;
        } else {
            i10 = 2;
        }
        j0Var.f21770b.c(i10);
        j0Var.f21770b.s(str);
        j0Var.a();
        return true;
    }

    public static boolean t(@Nullable String str) {
        if (q(str)) {
            return false;
        }
        return "IAB2V2".equalsIgnoreCase(str);
    }

    public static boolean u(@NonNull Context context) {
        boolean z10;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo != null) {
                String[] strArr = packageInfo.requestedPermissions;
                if (strArr == null) {
                    OTLogger.a("OTUtils", 3, "App requestedPermissionsList is empty.");
                } else {
                    for (String str : strArr) {
                        if ("com.google.android.gms.permission.AD_ID".equalsIgnoreCase(str)) {
                            z10 = true;
                            break;
                        }
                    }
                }
                z10 = false;
                OTLogger.a("GoogleAdInfo", 3, "Is appRequestedGoogleAdPermission = " + z10);
                return z10;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            OTLogger.a("GoogleAdInfo", 6, "Issue on reading PackageInfo for google ad permission. Error = " + e10.getMessage());
        }
        return false;
    }

    public static boolean v(@Nullable String str) {
        if (q(str)) {
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(Locale.getISOLanguages()));
        HashSet hashSet2 = new HashSet(Arrays.asList(Locale.getISOCountries()));
        Locale[] availableLocales = Locale.getAvailableLocales();
        String[] strArr = new String[availableLocales.length + 1];
        for (int i10 = 0; i10 < availableLocales.length; i10++) {
            strArr[i10] = availableLocales[i10].toString().replace("_", "-").trim();
        }
        HashSet hashSet3 = new HashSet(Arrays.asList(strArr));
        if (str.contains("-")) {
            try {
                String str2 = str.split("-")[1];
                Locale locale = Locale.ENGLISH;
                String upperCase = str2.toUpperCase(locale);
                if (!hashSet.contains(str.split("-")[0].toLowerCase(locale))) {
                    return false;
                }
                if (!hashSet2.contains(upperCase)) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e10) {
                OTLogger.a("OTUtils", 3, "Exception while validating language code, err: " + e10.getMessage());
                return false;
            }
        } else {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (!hashSet3.contains(lowerCase) && !hashSet.contains(lowerCase)) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public static SimpleDateFormat w(String str) {
        return Build.VERSION.SDK_INT >= 24 ? new SimpleDateFormat(str, Locale.getDefault(Locale.Category.FORMAT)) : new SimpleDateFormat(str);
    }

    public static boolean x(@NonNull Context context) {
        boolean z10;
        h hVar;
        String string = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
        if (q(string)) {
            string = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
        }
        boolean zEqualsIgnoreCase = OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR.equalsIgnoreCase(string);
        if (!zEqualsIgnoreCase) {
            String string2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOT_SDK_APP_CONFIGURATION", 0).getString("OT_UX_SDK_THEME", OTThemeConstants.NO_SDK_THEME_OVERRIDE);
            if (q(string2)) {
                string2 = OTThemeConstants.NO_SDK_THEME_OVERRIDE;
            }
            zEqualsIgnoreCase = OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR_LANDSCAPE_FULL_SCREEN.equalsIgnoreCase(string2);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (com.onetrust.otpublishers.headless.Internal.Helper.h.a(Boolean.FALSE, context.getSharedPreferences("com.onetrust.otpublishers.headless.preference".concat("OTT_DEFAULT_USER"), 0), "OT_ENABLE_MULTI_PROFILE")) {
            hVar = new h(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z10 = true;
        } else {
            z10 = false;
            hVar = null;
        }
        if (z10) {
            sharedPreferences = hVar;
        }
        String string3 = sharedPreferences.getString("OT_MOBILE_DATA_OVERRIDE_THEME", null);
        if (!q(string3)) {
            OTLogger.a("OTUtils", 3, "Mobile data, overrideTheme = " + string3);
            if (OTThemeConstants.NO_SDK_THEME_OVERRIDE.equalsIgnoreCase(string3)) {
                return false;
            }
            if (OTThemeConstants.OT_THEME_APP_COMPACT_LIGHT_NO_ACTION_BAR.equalsIgnoreCase(string3)) {
                return true;
            }
        }
        return zEqualsIgnoreCase;
    }

    public static void y(Context context) {
        try {
            com.onetrust.otpublishers.headless.Internal.profile.d dVar = new com.onetrust.otpublishers.headless.Internal.profile.d(context);
            String string = dVar.f21906a.c().getString("OT_MULTI_PROFILE_ID_MAP", null);
            if (!q(string)) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    dVar.i(jSONArray.getString(i10));
                }
            }
        } catch (JSONException e10) {
            p.a(e10, new StringBuilder("Error on clearing multi-profile files. Error = "), "OneTrust", 6);
        }
        new e(context, "OTT_DEFAULT_USER").a();
        new g0(context).a();
        com.onetrust.otpublishers.headless.gpp.c cVar = new com.onetrust.otpublishers.headless.gpp.c(context);
        if (cVar.f23791b.isEmpty()) {
            cVar.d();
        }
        if (!cVar.f23791b.keySet().isEmpty()) {
            for (String str : cVar.f23791b.keySet()) {
                if (!q(str)) {
                    cVar.f23792c.a(str);
                }
            }
        }
        new com.onetrust.otpublishers.headless.Internal.Preferences.a(context).a(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT);
        boolean zT = new g(context).t();
        q.a(zT).getClass();
        if (!q(q.o(context).toString())) {
            q.a(zT).getClass();
            q.g(context);
        }
        c(context, -1);
    }

    public static void z(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        g gVar = new g(context);
        if (uiModeManager.getCurrentModeType() == 4) {
            OTLogger.a("OneTrust", 4, "SDK rendering on TV device");
            gVar.m(101);
        } else {
            OTLogger.a("OneTrust", 4, "SDK rendering on mobile device");
            gVar.m(102);
        }
    }
}
