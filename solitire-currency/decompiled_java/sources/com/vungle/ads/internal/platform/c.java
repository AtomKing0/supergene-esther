package com.vungle.ads.internal.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import androidx.core.util.Consumer;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.vungle.ads.internal.executor.i;
import com.vungle.ads.internal.util.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: AndroidPlatform.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements d {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String TAG = "AndroidPlatform";

    @Nullable
    private com.vungle.ads.internal.model.c advertisingInfo;

    @Nullable
    private String appSetId;

    @Nullable
    private Integer appSetIdScope;

    @NotNull
    private final AudioManager audioManager;

    @NotNull
    private final Context context;
    private final boolean isSideLoaded;

    @NotNull
    private final PowerManager powerManager;

    @NotNull
    private final i uaExecutor;

    @Nullable
    private String userAgent;

    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        public final String getCarrierName$vungle_ads_release(@NotNull Context context) {
            t.i(context, "context");
            Object systemService = context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            t.g(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            return ((TelephonyManager) systemService).getNetworkOperatorName();
        }
    }

    public c(@NotNull Context context, @NotNull i uaExecutor) {
        t.i(context, "context");
        t.i(uaExecutor, "uaExecutor");
        this.context = context;
        this.uaExecutor = uaExecutor;
        updateAppSetID();
        Object systemService = context.getSystemService("power");
        t.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        this.powerManager = (PowerManager) systemService;
        Object systemService2 = context.getSystemService("audio");
        t.g(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService2;
    }

    private final com.vungle.ads.internal.model.c getAmazonAdvertisingInfo() {
        com.vungle.ads.internal.model.c cVar = new com.vungle.ads.internal.model.c();
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            boolean z10 = true;
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                z10 = false;
            }
            cVar.setLimitAdTracking(z10);
            cVar.setAdvertisingId(Settings.Secure.getString(contentResolver, "advertising_id"));
        } catch (Settings.SettingNotFoundException e10) {
            p.Companion.w(TAG, "Error getting Amazon advertising info", e10);
        }
        return cVar;
    }

    private final com.vungle.ads.internal.model.c getGoogleAdvertisingInfo() {
        com.vungle.ads.internal.model.c cVar = new com.vungle.ads.internal.model.c();
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
            t.h(advertisingIdInfo, "getAdvertisingIdInfo(context)");
            cVar.setAdvertisingId(advertisingIdInfo.getId());
            cVar.setLimitAdTracking(advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (GooglePlayServicesNotAvailableException e10) {
            p.Companion.e(TAG, "Play services Not available: " + e10.getLocalizedMessage());
        } catch (Exception e11) {
            p.Companion.e(TAG, "Error getting Google advertising info: " + e11.getLocalizedMessage());
        } catch (NoClassDefFoundError e12) {
            p.Companion.e(TAG, "Play services Not available: " + e12.getLocalizedMessage());
            cVar.setAdvertisingId(Settings.Secure.getString(this.context.getContentResolver(), "advertising_id"));
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getUserAgentLazy$lambda-0, reason: not valid java name */
    public static final void m4071getUserAgentLazy$lambda0(c this$0, Consumer consumer) {
        t.i(this$0, "this$0");
        t.i(consumer, "$consumer");
        new e(this$0.context).getUserAgent(consumer);
    }

    private final void updateAppSetID() {
        String str = this.appSetId;
        if (str == null || str.length() == 0) {
            try {
                AppSetIdClient client = AppSet.getClient(this.context);
                t.h(client, "getClient(context)");
                Task<AppSetIdInfo> appSetIdInfo = client.getAppSetIdInfo();
                t.h(appSetIdInfo, "client.appSetIdInfo");
                appSetIdInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.vungle.ads.internal.platform.a
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        c.m4072updateAppSetID$lambda2(this.f24365a, (AppSetIdInfo) obj);
                    }
                });
            } catch (NoClassDefFoundError e10) {
                p.Companion.e(TAG, "Required libs to get AppSetID Not available: " + e10.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateAppSetID$lambda-2, reason: not valid java name */
    public static final void m4072updateAppSetID$lambda2(c this$0, AppSetIdInfo appSetIdInfo) {
        t.i(this$0, "this$0");
        if (appSetIdInfo != null) {
            this$0.appSetId = appSetIdInfo.getId();
            this$0.appSetIdScope = Integer.valueOf(appSetIdInfo.getScope());
        }
    }

    @Override // com.vungle.ads.internal.platform.d
    @NotNull
    public com.vungle.ads.internal.model.c getAdvertisingInfo() {
        com.vungle.ads.internal.model.c cVar = this.advertisingInfo;
        if (cVar != null) {
            String advertisingId = cVar.getAdvertisingId();
            if (!(advertisingId == null || advertisingId.length() == 0)) {
                return cVar;
            }
        }
        com.vungle.ads.internal.model.c amazonAdvertisingInfo = q.x(Build.MANUFACTURER, "Amazon", true) ? getAmazonAdvertisingInfo() : getGoogleAdvertisingInfo();
        this.advertisingInfo = amazonAdvertisingInfo;
        return amazonAdvertisingInfo;
    }

    @Override // com.vungle.ads.internal.platform.d
    @Nullable
    public String getAppSetId() {
        return this.appSetId;
    }

    @Override // com.vungle.ads.internal.platform.d
    @Nullable
    public Integer getAppSetIdScope() {
        return this.appSetIdScope;
    }

    @Override // com.vungle.ads.internal.platform.d
    @NotNull
    public String getCarrierName() {
        String carrierName$vungle_ads_release = Companion.getCarrierName$vungle_ads_release(this.context);
        t.h(carrierName$vungle_ads_release, "getCarrierName(context)");
        return carrierName$vungle_ads_release;
    }

    @Override // com.vungle.ads.internal.platform.d
    @Nullable
    public String getUserAgent() {
        String str = this.userAgent;
        return str == null ? System.getProperty("http.agent") : str;
    }

    @Override // com.vungle.ads.internal.platform.d
    public void getUserAgentLazy(@NotNull final Consumer<String> consumer) {
        t.i(consumer, "consumer");
        this.uaExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.platform.b
            @Override // java.lang.Runnable
            public final void run() {
                c.m4071getUserAgentLazy$lambda0(this.f24366a, consumer);
            }
        });
    }

    @Override // com.vungle.ads.internal.platform.d
    public float getVolumeLevel() {
        try {
            return this.audioManager.getStreamVolume(3) / this.audioManager.getStreamMaxVolume(3);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isAtLeastMinimumSDK() {
        return true;
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isBatterySaverEnabled() {
        return this.powerManager.isPowerSaveMode();
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isSdCardPresent() {
        try {
            return t.d(Environment.getExternalStorageState(), "mounted");
        } catch (Exception e10) {
            p.Companion.e(TAG, "Acquiring external storage state failed", e10);
            return false;
        }
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isSideLoaded() {
        return this.isSideLoaded;
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isSilentModeEnabled() {
        try {
            if (this.audioManager.getRingerMode() != 0) {
                if (this.audioManager.getRingerMode() != 1) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.vungle.ads.internal.platform.d
    public boolean isSoundEnabled() {
        try {
            return this.audioManager.getStreamVolume(3) > 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public void setUserAgent(@Nullable String str) {
        this.userAgent = str;
    }
}
