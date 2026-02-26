package com.ironsource.adapters.supersonicads;

import android.text.TextUtils;
import androidx.media3.datasource.cache.ContentMetadata;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.so;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SupersonicConfig {
    private static SupersonicConfig mInstance;
    private final String CUSTOM_PARAM_PREFIX = ContentMetadata.KEY_CUSTOM_PREFIX;
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    NetworkSettings mProviderSettings = new NetworkSettings(so.c().b("Mediation"));

    private SupersonicConfig() {
    }

    private Map<String, String> convertCustomParams(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            try {
                Set<String> setKeySet = map.keySet();
                if (setKeySet != null) {
                    for (String str : setKeySet) {
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = map.get(str);
                            if (!TextUtils.isEmpty(str2)) {
                                map2.put(ContentMetadata.KEY_CUSTOM_PREFIX + str, str2);
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, ":convertCustomParams()", e10);
            }
        }
        return map2;
    }

    public static SupersonicConfig getConfigObj() {
        if (mInstance == null) {
            mInstance = new SupersonicConfig();
        }
        return mInstance;
    }

    public boolean getClientSideCallbacks() {
        NetworkSettings networkSettings = this.mProviderSettings;
        if (networkSettings == null || networkSettings.getRewardedVideoSettings() == null || !this.mProviderSettings.getRewardedVideoSettings().has("useClientSideCallbacks")) {
            return false;
        }
        return this.mProviderSettings.getRewardedVideoSettings().optBoolean("useClientSideCallbacks", false);
    }

    public void setClientSideCallbacks(boolean z10) {
        this.mProviderSettings.setRewardedVideoSettings("useClientSideCallbacks", String.valueOf(z10));
    }

    public void setCustomControllerUrl(String str) {
        this.mProviderSettings.setRewardedVideoSettings("controllerUrl", str);
        this.mProviderSettings.setInterstitialSettings("controllerUrl", str);
        this.mProviderSettings.setBannerSettings("controllerUrl", str);
        this.mProviderSettings.setNativeAdSettings("controllerUrl", str);
    }

    public void setDebugMode(int i10) {
        this.mProviderSettings.setRewardedVideoSettings("debugMode", Integer.valueOf(i10));
        this.mProviderSettings.setInterstitialSettings("debugMode", Integer.valueOf(i10));
        this.mProviderSettings.setBannerSettings("debugMode", Integer.valueOf(i10));
        this.mProviderSettings.setNativeAdSettings("debugMode", Integer.valueOf(i10));
    }
}
