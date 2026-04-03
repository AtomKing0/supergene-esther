package com.king.adscmp.sa;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;
import androidx.webkit.Profile;
import com.king.amp.sa.Logging;
import com.onetrust.otpublishers.headless.Public.DataModel.OTGeolocationModel;
import com.onetrust.otpublishers.headless.Public.DataModel.OTProfileSyncParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTSdkParams;
import com.onetrust.otpublishers.headless.Public.DataModel.OTUXParams;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABCCPAKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import j6.h;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public final class AdsOnetrustNative {
    private static String LOG_TAG = "AdsOnetrustNative";
    private static String PREFERENCE_FILE = "com.king.amp.consent";
    private static String TAG_INTERNAL = "Internal";
    private static long mCppInstance = 0;
    private static boolean mInitialized = false;
    private Activity mActivity;
    private Context mContext;
    private OTPublishersHeadlessSDK mOtPublishersHeadlessSDK;
    private BroadcastReceiver onCategoryConsentChanged;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f16510c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f16511d;

        /* JADX INFO: renamed from: com.king.adscmp.sa.AdsOnetrustNative$a$a, reason: collision with other inner class name */
        class C0274a implements OTCallback {
            C0274a() {
            }

            @Override // com.onetrust.otpublishers.headless.Public.OTCallback
            public void onFailure(@NonNull OTResponse oTResponse) {
                int responseCode = oTResponse.getResponseCode();
                String responseMessage = oTResponse.getResponseMessage();
                Log.e(AdsOnetrustNative.LOG_TAG, "Init OT Failed: " + oTResponse.toString());
                AdsOnetrustNative.this.onInitComplete(false, responseCode, responseMessage);
            }

            @Override // com.onetrust.otpublishers.headless.Public.OTCallback
            public void onSuccess(@NonNull OTResponse oTResponse) {
                Log.i(AdsOnetrustNative.LOG_TAG, "Init OT Success : " + oTResponse.toString());
                AdsOnetrustNative.this.onInitComplete(true, oTResponse.getResponseCode(), oTResponse.getResponseMessage());
            }
        }

        a(String str, String str2, String str3, String str4) {
            this.f16508a = str;
            this.f16509b = str2;
            this.f16510c = str3;
            this.f16511d = str4;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AdsOnetrustNative.this.mContext);
                String string = defaultSharedPreferences.getString("config_key_cmp_locale", "");
                String string2 = defaultSharedPreferences.getString("config_key_cmp_language", "");
                if (string2.equals(Profile.DEFAULT_PROFILE_NAME) || string2.isEmpty()) {
                    string2 = Locale.getDefault().getLanguage();
                }
                String str = string2;
                Log.i(AdsOnetrustNative.LOG_TAG, "InitOnetrustSDK url : " + this.f16508a + " and app id : " + this.f16509b + " and load user id: " + this.f16510c);
                Logging.logBreadcrumb("External", "OneTrust - InitOnetrustSDK url : " + this.f16508a + " and app id : " + this.f16509b + " and userId: " + this.f16510c);
                OTSdkParams.SdkParamsBuilder sdkParamsBuilderNewInstance = OTSdkParams.SdkParamsBuilder.newInstance();
                if (!this.f16510c.isEmpty() && !this.f16510c.equals("0") && !this.f16511d.isEmpty()) {
                    sdkParamsBuilderNewInstance.setProfileSyncParams(OTProfileSyncParams.OTProfileSyncParamsBuilder.newInstance().setSyncProfile(com.ironsource.mediationsdk.metadata.a.f13688g).setSyncProfileAuth(this.f16511d).setIdentifier(this.f16510c).build());
                    sdkParamsBuilderNewInstance.shouldCreateProfile(com.ironsource.mediationsdk.metadata.a.f13688g);
                }
                OTUXParams customUIParams = AdsOnetrustNative.this.getCustomUIParams();
                if (customUIParams != null) {
                    sdkParamsBuilderNewInstance.setOTUXParams(customUIParams);
                }
                if (!string.isEmpty() && !string.equals(Profile.DEFAULT_PROFILE_NAME)) {
                    if (string.length() == 2) {
                        sdkParamsBuilderNewInstance.setOTCountryCode(string);
                        sdkParamsBuilderNewInstance.setOTRegionCode("");
                    } else if (string.length() > 3 && string.charAt(2) == '-') {
                        sdkParamsBuilderNewInstance.setOTCountryCode(string.substring(0, 2));
                        sdkParamsBuilderNewInstance.setOTRegionCode(string.substring(3));
                    }
                }
                AdsOnetrustNative.this.mOtPublishersHeadlessSDK.startSDK(this.f16508a, this.f16509b, str, sdkParamsBuilderNewInstance.build(), new C0274a());
            } catch (Exception e10) {
                Log.e(AdsOnetrustNative.LOG_TAG, "Init OT Failed: " + e10.getMessage());
                AdsOnetrustNative.this.onInitComplete(false, -1, e10.getMessage());
            }
        }
    }

    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            int intExtra = intent.getIntExtra(OTBroadcastServiceKeys.EVENT_STATUS, -1);
            synchronized (this) {
                if (AdsOnetrustNative.mCppInstance != 0) {
                    Logging.logBreadcrumb(AdsOnetrustNative.TAG_INTERNAL, "AdsOnetrustNative - received consent update events for : " + action + " status : " + intExtra);
                    AdsOnetrustNative.onConsentUpdated(AdsOnetrustNative.mCppInstance, action, intExtra);
                }
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16516b;

        c(String str, String str2) {
            this.f16515a = str;
            this.f16516b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logging.logBreadcrumb(AdsOnetrustNative.TAG_INTERNAL, "Write cache consent to disk. key : " + this.f16515a + " consent : " + this.f16516b);
            SharedPreferences.Editor editorEdit = AdsOnetrustNative.this.mActivity.getSharedPreferences(AdsOnetrustNative.PREFERENCE_FILE, 0).edit();
            editorEdit.putString(this.f16515a, this.f16516b);
            editorEdit.commit();
        }
    }

    public AdsOnetrustNative(String str, Activity activity) {
        LOG_TAG = str;
        mCppInstance = 0L;
        this.mActivity = activity;
        Context applicationContext = activity.getApplicationContext();
        this.mContext = applicationContext;
        if (applicationContext != null) {
            this.mOtPublishersHeadlessSDK = new OTPublishersHeadlessSDK(applicationContext);
        }
    }

    private String GetConsentString(String str) {
        return PreferenceManager.getDefaultSharedPreferences(this.mContext).getString(str, "-1");
    }

    private void ShowConsentDialog(boolean z10, boolean z11) {
        Log.i(LOG_TAG, "Start to show consent dialog: " + z10);
        Logging.logBreadcrumb(TAG_INTERNAL, "AdsOnetrustNative - start wrapper activity to ShowConsentDialog");
        Intent intent = new Intent(this.mActivity, (Class<?>) OneTrustNativeLaunchActivity.class);
        intent.setFlags(276889600);
        intent.putExtra("logTag", LOG_TAG);
        intent.putExtra("showPC", z10);
        intent.putExtra("disableOtLayoutPatch", z11);
        this.mActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OTUXParams getCustomUIParams() throws Throwable {
        String rawResourceFileIntoString;
        Log.i(LOG_TAG, "Start custom OneTrust UI.");
        Logging.logBreadcrumb(TAG_INTERNAL, "AdsOnetrustNative - read custom UI assets");
        try {
            rawResourceFileIntoString = readRawResourceFileIntoString(this.mContext, h.f28754c);
        } catch (Exception e10) {
            Log.e(LOG_TAG, "Error reading OneTrust ot_ui_params.json: " + e10.getMessage());
            rawResourceFileIntoString = null;
        }
        if (TextUtils.isEmpty(rawResourceFileIntoString)) {
            return null;
        }
        try {
            return OTUXParams.OTUXParamsBuilder.newInstance().setUXParams(new JSONObject(rawResourceFileIntoString)).build();
        } catch (JSONException e11) {
            Log.e(LOG_TAG, "Error parsing ot_ui_params.json: " + e11.getMessage());
            return null;
        }
    }

    public static native void onConsentDialogClosed(long j10, int i10, int i11, String str);

    public static native void onConsentInitDone(long j10, int i10, String str);

    public static native void onConsentUpdated(long j10, String str, int i10);

    public static synchronized void onDialogClosed(int i10, boolean z10, String str) {
        String str2 = i10 == 1 ? "Show preference center failed" : "Show Banner failed";
        if (str == null) {
            str = z10 ? str2 : "";
        }
        Logging.logBreadcrumb(TAG_INTERNAL, "OneTrust - onConsentDialogClosed");
        onConsentDialogClosed(mCppInstance, i10, z10 ? 0 : 1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitComplete(boolean z10, int i10, String str) {
        synchronized (this) {
            Logging.logBreadcrumb(TAG_INTERNAL, "AdsOnetrustNative - onInitComplete");
            onConsentInitDone(mCppInstance, z10 ? 1 : 0, str);
            mInitialized = z10;
        }
    }

    private void setConsentChangeListener(String[] strArr) {
        this.onCategoryConsentChanged = new b();
        for (String str : strArr) {
            IntentFilter intentFilter = new IntentFilter(str);
            Log.i(LOG_TAG, "registerReceiver for " + intentFilter);
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    this.mActivity.registerReceiver(this.onCategoryConsentChanged, intentFilter, 4);
                } else {
                    this.mActivity.registerReceiver(this.onCategoryConsentChanged, intentFilter);
                }
            } catch (Exception unused) {
                Log.e(LOG_TAG, "Error in registerReceiver for category: " + str);
            }
        }
    }

    public void ClearOTSDKData() {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.clearOTSDKData();
        }
    }

    public String FetchCacheFromDisk(String str) {
        return this.mActivity.getSharedPreferences(PREFERENCE_FILE, 0).getString(str, "-1");
    }

    public String GetAdditionalConsentString() {
        return GetConsentString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT);
    }

    public String GetCCPAConsentString() {
        return GetConsentString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING);
    }

    public int GetConsentStatus(String str) {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null) {
            return oTPublishersHeadlessSDK.getConsentStatusForSDKId(str);
        }
        return -1;
    }

    public int GetConsentStatusForGroup(String str) {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null) {
            return oTPublishersHeadlessSDK.getConsentStatusForGroupId(str);
        }
        return -1;
    }

    public String GetGDPRConsentString() {
        return GetConsentString("IABTCF_TCString");
    }

    public String GetGDPRPurposeConsentString() {
        return GetConsentString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS);
    }

    public String GetUserConsentLocation_country() {
        OTGeolocationModel lastDataDownloadedLocation;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK == null || (lastDataDownloadedLocation = oTPublishersHeadlessSDK.getLastDataDownloadedLocation()) == null) {
            Log.e(LOG_TAG, "Geolocation: not fetched");
            return "";
        }
        Log.i(LOG_TAG, "Geolocation: " + lastDataDownloadedLocation.country + " " + lastDataDownloadedLocation.state);
        return lastDataDownloadedLocation.country;
    }

    public String GetUserConsentLocation_state() {
        OTGeolocationModel lastDataDownloadedLocation;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK == null || (lastDataDownloadedLocation = oTPublishersHeadlessSDK.getLastDataDownloadedLocation()) == null) {
            Log.e(LOG_TAG, "Geolocation: not fetched");
            return "";
        }
        Log.i(LOG_TAG, "Geolocation: " + lastDataDownloadedLocation.country + " " + lastDataDownloadedLocation.state);
        return lastDataDownloadedLocation.state;
    }

    public synchronized void InitOnetrustSDK(long j10, String[] strArr, String str, String str2, String str3, String str4) {
        mCppInstance = j10;
        setConsentChangeListener(strArr);
        new Thread(new a(str, str2, str3, str4)).start();
    }

    public void ResetCppInstance() {
        Log.i(LOG_TAG, "Resetting cpp counter part instance address.");
        synchronized (this) {
            mCppInstance = 0L;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public void SaveCacheToDisk(String str, String str2) {
        if (str.isEmpty()) {
            return;
        }
        new Thread(new c(str, str2)).start();
    }

    public boolean ShouldShowBanner() {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null) {
            return oTPublishersHeadlessSDK.shouldShowBanner();
        }
        return false;
    }

    public void ShowConsentBanner(boolean z10) {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null && oTPublishersHeadlessSDK.getBannerData() != null) {
            Logging.logBreadcrumb(TAG_INTERNAL, "AdsOnetrustNative - ShowConsentBanner");
            ShowConsentDialog(false, z10);
        } else {
            synchronized (this) {
                Logging.logBreadcrumb(TAG_INTERNAL, "AdsOnetrustNative - onConsentDialogClosed: Failed to show banner, not downloaded");
                onConsentDialogClosed(mCppInstance, 2, -1, "Tried to show banner when consent is not downloaded");
            }
        }
    }

    public void ShowConsentPreferenceCenter(boolean z10) {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null && oTPublishersHeadlessSDK.getPreferenceCenterData() != null) {
            Logging.logBreadcrumb(TAG_INTERNAL, "AdsOnetrustNative - ShowConsentPreferenceCenter");
            ShowConsentDialog(true, z10);
        } else {
            synchronized (this) {
                Logging.logBreadcrumb(TAG_INTERNAL, "AdsOnetrustNative - onConsentDialogClosed: Failed to show preference center, not downloaded");
                onConsentDialogClosed(mCppInstance, 1, -1, "Tried to show preference center when consent is not downloaded");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v5 */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String readRawResourceFileIntoString(@androidx.annotation.NonNull android.content.Context r7, int r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "Error on closing FileInputStream message: "
            r1 = 0
            android.content.res.Resources r7 = r7.getResources()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            java.io.InputStream r7 = r7.openRawResource(r8)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            int r8 = r7.available()     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            byte[] r8 = new byte[r8]     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            int r2 = r7.read(r8)     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            java.lang.String r3 = com.king.adscmp.sa.AdsOnetrustNative.LOG_TAG     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            r4.<init>()     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            java.lang.String r5 = "Num bytes read for Asset file : "
            r4.append(r5)     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            r4.append(r2)     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            java.lang.String r2 = r4.toString()     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            android.util.Log.v(r3, r2)     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            r7.close()     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            java.lang.String r2 = new java.lang.String     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            r2.<init>(r8)     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L92
            r7.close()     // Catch: java.io.IOException -> L37
            goto L50
        L37:
            r7 = move-exception
            java.lang.String r8 = com.king.adscmp.sa.AdsOnetrustNative.LOG_TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r7 = r7.getMessage()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            android.util.Log.e(r8, r7)
        L50:
            r1 = r2
            goto L91
        L52:
            r8 = move-exception
            goto L58
        L54:
            r8 = move-exception
            goto L94
        L56:
            r8 = move-exception
            r7 = r1
        L58:
            java.lang.String r2 = com.king.adscmp.sa.AdsOnetrustNative.LOG_TAG     // Catch: java.lang.Throwable -> L92
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
            r3.<init>()     // Catch: java.lang.Throwable -> L92
            java.lang.String r4 = "File read error: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L92
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L92
            r3.append(r8)     // Catch: java.lang.Throwable -> L92
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L92
            android.util.Log.e(r2, r8)     // Catch: java.lang.Throwable -> L92
            if (r7 == 0) goto L91
            r7.close()     // Catch: java.io.IOException -> L78
            goto L91
        L78:
            r7 = move-exception
            java.lang.String r8 = com.king.adscmp.sa.AdsOnetrustNative.LOG_TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r8, r7)
        L91:
            return r1
        L92:
            r8 = move-exception
            r1 = r7
        L94:
            if (r1 == 0) goto Lb3
            r1.close()     // Catch: java.io.IOException -> L9a
            goto Lb3
        L9a:
            r7 = move-exception
            java.lang.String r1 = com.king.adscmp.sa.AdsOnetrustNative.LOG_TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r1, r7)
        Lb3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.adscmp.sa.AdsOnetrustNative.readRawResourceFileIntoString(android.content.Context, int):java.lang.String");
    }
}
