package com.king.usdk.otconsent;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.preference.PreferenceManager;
import com.king.usdk.logger.Logger;
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
import com.unity3d.services.UnityAdsConstants;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class OneTrustHelper {
    private static long mCppInstance;
    private static AtomicBoolean mInitialized = new AtomicBoolean(false);
    private final Activity mActivity;
    private final Context mContext;
    private final Logger mLogger;
    private BroadcastReceiver mOnCategoryConsentChanged = null;
    private OTPublishersHeadlessSDK mOtPublishersHeadlessSDK;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f17212d;

        /* JADX INFO: renamed from: com.king.usdk.otconsent.OneTrustHelper$a$a, reason: collision with other inner class name */
        class C0284a implements OTCallback {
            C0284a() {
            }

            @Override // com.onetrust.otpublishers.headless.Public.OTCallback
            public void onFailure(@NonNull OTResponse oTResponse) {
                String string = oTResponse.toString();
                int responseCode = oTResponse.getResponseCode();
                String responseMessage = oTResponse.getResponseMessage();
                Logger logger = OneTrustHelper.this.mLogger;
                if (("OneTrustHelper::initialize: failure=" + string) == null) {
                    string = "";
                }
                logger.e(string);
                OneTrustHelper oneTrustHelper = OneTrustHelper.this;
                if (responseMessage == null) {
                    responseMessage = "";
                }
                oneTrustHelper.onInitComplete(false, responseCode, responseMessage);
            }

            @Override // com.onetrust.otpublishers.headless.Public.OTCallback
            public void onSuccess(@NonNull OTResponse oTResponse) {
                String string = oTResponse.toString();
                int responseCode = oTResponse.getResponseCode();
                String responseMessage = oTResponse.getResponseMessage();
                Logger logger = OneTrustHelper.this.mLogger;
                if (("OneTrustHelper::initialize: success=" + string) == null) {
                    string = "";
                }
                logger.i(string);
                OneTrustHelper oneTrustHelper = OneTrustHelper.this;
                if (responseMessage == null) {
                    responseMessage = "";
                }
                oneTrustHelper.onInitComplete(true, responseCode, responseMessage);
            }
        }

        a(String str, String str2, String str3, String str4) {
            this.f17209a = str;
            this.f17210b = str2;
            this.f17211c = str3;
            this.f17212d = str4;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                OneTrustHelper.this.mLogger.i("OneTrustHelper:initialize: : " + this.f17209a + ", appId: " + this.f17210b + ", userId: " + this.f17211c + ", jwt: " + this.f17212d);
                StringBuilder sb = new StringBuilder();
                sb.append("OneTrustHelper:initialize: : ");
                sb.append(this.f17209a);
                sb.append(", appId: ");
                sb.append(this.f17210b);
                sb.append(", userId: ");
                sb.append(this.f17211c);
                OneTrustHelper.logBreadcrumb(sb.toString(), null);
                OTPublishersHeadlessSDK unused = OneTrustHelper.this.mOtPublishersHeadlessSDK;
                OTPublishersHeadlessSDK.enableOTSDKLog(OneTrustHelper.this.mLogger.logLevel().d());
                OTSdkParams.SdkParamsBuilder sdkParamsBuilderNewInstance = OTSdkParams.SdkParamsBuilder.newInstance();
                if (!com.king.usdk.otconsent.a.a(this.f17211c) && !com.king.usdk.otconsent.a.a(this.f17212d)) {
                    sdkParamsBuilderNewInstance.setProfileSyncParams(OTProfileSyncParams.OTProfileSyncParamsBuilder.newInstance().setSyncProfile(com.ironsource.mediationsdk.metadata.a.f13688g).setSyncProfileAuth(this.f17212d).setIdentifier(this.f17211c).build());
                    sdkParamsBuilderNewInstance.shouldCreateProfile(com.ironsource.mediationsdk.metadata.a.f13688g);
                }
                OTUXParams customUIParams = OneTrustHelper.this.getCustomUIParams();
                if (customUIParams != null) {
                    sdkParamsBuilderNewInstance.setOTUXParams(customUIParams);
                }
                OneTrustHelper.this.mOtPublishersHeadlessSDK.startSDK(this.f17209a, this.f17210b, Locale.getDefault().getLanguage(), sdkParamsBuilderNewInstance.build(), new C0284a());
            } catch (Exception e10) {
                String message = e10.getMessage() != null ? e10.getMessage() : "";
                OneTrustHelper.this.mLogger.e("OneTrustHelper::initialize: exception=" + message);
                OneTrustHelper.this.onInitComplete(false, -1, message);
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
                if (OneTrustHelper.mCppInstance != 0) {
                    OneTrustHelper.logBreadcrumb("OneTrustHelper::setConsentChangeListener: received consent update event for group '" + action + "' with status " + intExtra, OneTrustHelper.this.mLogger);
                    OneTrustHelper.onConsentUpdated(OneTrustHelper.mCppInstance, action, intExtra);
                }
            }
        }
    }

    public enum c {
        Consent,
        PreferenceCenter
    }

    public OneTrustHelper(@NonNull Activity activity, long j10, long j11, boolean z10) {
        this.mOtPublishersHeadlessSDK = null;
        this.mActivity = activity;
        Context applicationContext = activity.getApplicationContext();
        this.mContext = applicationContext;
        mCppInstance = j10;
        Logger logger = new Logger(j11, z10);
        this.mLogger = logger;
        if (mCppInstance == 0) {
            logger.e("OneTrustHelper: native instance is a nullptr");
        } else if (applicationContext != null) {
            this.mOtPublishersHeadlessSDK = new OTPublishersHeadlessSDK(applicationContext);
        } else {
            logger.e("OneTrustHelper: Context is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OTUXParams getCustomUIParams() throws Throwable {
        String resourceFile;
        logBreadcrumb("OneTrustHelper: getting custom UI params ...", this.mLogger);
        try {
            resourceFile = readResourceFile(this.mContext, com.king.usdk.otconsent.c.f17233a);
        } catch (Exception e10) {
            this.mLogger.e("OneTrustHelper: error while reading UI json file: " + e10.toString());
            resourceFile = null;
        }
        if (TextUtils.isEmpty(resourceFile)) {
            return null;
        }
        try {
            return OTUXParams.OTUXParamsBuilder.newInstance().setUXParams(new JSONObject(resourceFile)).build();
        } catch (JSONException e11) {
            this.mLogger.i("OneTrustHelper: error in ot UI json object: " + e11.toString());
            return null;
        }
    }

    private void launchActivityDialog(c cVar) {
        this.mLogger.i("OneTrustHelper::showConsentDialog: showing consent dialog");
        try {
            Intent intent = new Intent(this.mActivity, (Class<?>) OneTrustLaunchActivity.class);
            intent.setFlags(276889600);
            intent.putExtra("log-state", this.mLogger.getState());
            intent.putExtra("log-enabled", this.mLogger.isEnabled());
            intent.putExtra("dialog-type", cVar.toString());
            this.mActivity.startActivity(intent);
        } catch (Exception e10) {
            Logger logger = this.mLogger;
            StringBuilder sb = new StringBuilder();
            sb.append("OneTrustHelper::showConsentDialog: exception=");
            sb.append(e10.getMessage());
            logger.e(sb.toString() != null ? e10.getMessage() : "");
        }
    }

    public static synchronized void logBreadcrumb(String str, Logger logger) {
        if (logger != null) {
            logger.i(str);
            writeBreadcrumb(mCppInstance, str);
        } else {
            writeBreadcrumb(mCppInstance, str);
        }
    }

    public static native void onConsentDialogClosed(long j10, boolean z10, String str);

    public static native void onConsentUpdated(long j10, String str, int i10);

    public static synchronized void onDialogClosed(c cVar, boolean z10, @NonNull String str) {
        if (cVar == c.Consent) {
            onConsentDialogClosed(mCppInstance, z10, str);
        } else {
            onPreferenceCenterClosed(mCppInstance, z10, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitComplete(boolean z10, int i10, String str) {
        synchronized (this) {
            mInitialized.set(z10);
            if (z10) {
                onInitSucceeded(mCppInstance);
            } else {
                onInitFailed(mCppInstance, i10, str);
            }
        }
    }

    public static native void onInitFailed(long j10, int i10, String str);

    public static native void onInitSucceeded(long j10);

    public static native void onPreferenceCenterClosed(long j10, boolean z10, String str);

    /* JADX WARN: Removed duplicated region for block: B:51:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String readResourceFile(@androidx.annotation.NonNull android.content.Context r10, int r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.king.usdk.otconsent.OneTrustHelper.readResourceFile(android.content.Context, int):java.lang.String");
    }

    private void setConsentChangeListener(String[] strArr) {
        if (this.mOnCategoryConsentChanged == null) {
            this.mOnCategoryConsentChanged = new b();
            for (String str : strArr) {
                this.mLogger.i("OneTrustHelper::setConsentChangeListener: registering for group '" + str + "'");
                try {
                    IntentFilter intentFilter = new IntentFilter(str);
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.mActivity.registerReceiver(this.mOnCategoryConsentChanged, intentFilter, 2);
                    } else {
                        this.mActivity.registerReceiver(this.mOnCategoryConsentChanged, intentFilter);
                    }
                } catch (Exception e10) {
                    Logger logger = this.mLogger;
                    StringBuilder sb = new StringBuilder();
                    sb.append("OneTrustHelper::setConsentChangeListener: exception registering receiver for group '");
                    sb.append(str);
                    sb.append("': ");
                    sb.append(e10.getMessage());
                    logger.e(sb.toString() != null ? e10.getMessage() : "");
                }
            }
        }
    }

    public static native void writeBreadcrumb(long j10, String str);

    public void clearData() {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.clearOTSDKData();
        }
    }

    public String getCCPAConsentString() {
        return PreferenceManager.getDefaultSharedPreferences(this.mContext).getString(OTIABCCPAKeys.OT_IAB_US_PRIVACY_STRING, "-1");
    }

    public int getConsentStatus(@NonNull String str) {
        if (this.mOtPublishersHeadlessSDK != null && mInitialized.get()) {
            return this.mOtPublishersHeadlessSDK.getConsentStatusForGroupId(str);
        }
        this.mLogger.e("OneTrustHelper::getConsentStatus: SDK not initialized");
        return -1;
    }

    public String getCountryCode() {
        if (this.mOtPublishersHeadlessSDK == null || !mInitialized.get()) {
            this.mLogger.e("OneTrustHelper::getCountryCode: SDK not initialized");
            return "";
        }
        OTGeolocationModel lastDataDownloadedLocation = this.mOtPublishersHeadlessSDK.getLastDataDownloadedLocation();
        if (lastDataDownloadedLocation != null) {
            this.mLogger.i("OneTrustHelper::getCountryCode: geolocation=" + lastDataDownloadedLocation.country + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + lastDataDownloadedLocation.state);
            String str = lastDataDownloadedLocation.country;
            if (str != null && !str.isEmpty()) {
                return lastDataDownloadedLocation.country;
            }
        }
        this.mLogger.e("OneTrustHelper::getCountryCode: geolocation not fetched");
        return "";
    }

    public String getGDPRConsentString() {
        return PreferenceManager.getDefaultSharedPreferences(this.mContext).getString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, "-1");
    }

    public String getTCConsentString() {
        return PreferenceManager.getDefaultSharedPreferences(this.mContext).getString("IABTCF_TCString", "");
    }

    public synchronized void initialize(@NonNull String[] strArr, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        if (mInitialized.get()) {
            this.mLogger.i("OneTrustHelper: already initialized");
            onInitComplete(true, 1000, "already initialized");
        } else {
            setConsentChangeListener(strArr);
            new Thread(new a(str, str2, str3, str4)).start();
        }
    }

    public boolean isInitialized() {
        this.mLogger.d("OneTrustHelper::isInitialized: " + mInitialized.toString());
        return mInitialized.get();
    }

    public boolean shouldShowDialog() {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        return oTPublishersHeadlessSDK != null && oTPublishersHeadlessSDK.shouldShowBanner();
    }

    public void showDialog() {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null && oTPublishersHeadlessSDK.getBannerData() != null) {
            logBreadcrumb("OneTrustHelper::showDialog: showing banner", this.mLogger);
            launchActivityDialog(c.Consent);
        } else {
            logBreadcrumb("OneTrustHelper::showDialog: Failed to show banner, not downloaded", this.mLogger);
            synchronized (this) {
                onConsentDialogClosed(mCppInstance, false, "Tried to show banner when consent is not downloaded");
            }
        }
    }

    public void showPreferenceCenter() {
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.mOtPublishersHeadlessSDK;
        if (oTPublishersHeadlessSDK != null && oTPublishersHeadlessSDK.getBannerData() != null) {
            logBreadcrumb("OneTrustHelper::showPreferenceCenter: showing banner", this.mLogger);
            launchActivityDialog(c.PreferenceCenter);
        } else {
            logBreadcrumb("OneTrustHelper::showDialog: Failed to show banner, not downloaded", this.mLogger);
            synchronized (this) {
                onConsentDialogClosed(mCppInstance, false, "Tried to show preference center when consent is not downloaded");
            }
        }
    }
}
