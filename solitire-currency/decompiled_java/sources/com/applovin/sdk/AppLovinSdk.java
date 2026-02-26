package com.applovin.sdk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.applovin.impl.l3;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxSegmentCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    private static AppLovinSdk instance;
    private final j coreSdk;
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Object instanceLock = new Object();

    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    private AppLovinSdk(j jVar) {
        this.coreSdk = jVar;
    }

    public static AppLovinSdk getInstance(Context context) {
        AppLovinSdk appLovinSdk;
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        synchronized (instanceLock) {
            if (instance == null) {
                j jVar = new j(new AppLovinSdkSettings(context), context);
                AppLovinSdk appLovinSdk2 = new AppLovinSdk(jVar);
                jVar.a(appLovinSdk2);
                instance = appLovinSdk2;
            }
            appLovinSdk = instance;
        }
        return appLovinSdk;
    }

    private static String getVersion() {
        return "13.2.0";
    }

    private static int getVersionCode() {
        return 13020099;
    }

    public j a() {
        return this.coreSdk;
    }

    public AppLovinAdService getAdService() {
        return this.coreSdk.k();
    }

    public List<MaxMediatedNetworkInfo> getAvailableMediatedNetworks() {
        JSONArray jSONArrayB = l3.b(this.coreSdk);
        ArrayList arrayList = new ArrayList(jSONArrayB.length());
        for (int i10 = 0; i10 < jSONArrayB.length(); i10++) {
            arrayList.add(new MaxMediatedNetworkInfoImpl(JsonUtils.getJSONObject(jSONArrayB, i10, (JSONObject) null)));
        }
        return arrayList;
    }

    public AppLovinCmpService getCmpService() {
        return this.coreSdk.q();
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.coreSdk.t();
    }

    public AppLovinEventService getEventService() {
        return this.coreSdk.B();
    }

    public String getSdkKey() {
        return this.coreSdk.b0();
    }

    public MaxSegmentCollection getSegmentCollection() {
        return this.coreSdk.c0();
    }

    public AppLovinSdkSettings getSettings() {
        return this.coreSdk.g0();
    }

    public void initialize(AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration, @Nullable SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.a(appLovinSdkInitializationConfiguration, sdkInitializationListener);
    }

    public boolean isInitialized() {
        return this.coreSdk.u0();
    }

    public void reinitialize(Boolean bool, Boolean bool2) {
        if (this.coreSdk.w0()) {
            this.coreSdk.L0();
        }
        this.coreSdk.K0();
        if (bool != null) {
            this.coreSdk.I();
            if (n.a()) {
                this.coreSdk.I().d(TAG, "Toggled 'huc' to " + bool);
            }
            getEventService().trackEvent("huc", CollectionUtils.map("value", bool.toString()));
        }
        if (bool2 != null) {
            this.coreSdk.I();
            if (n.a()) {
                this.coreSdk.I().d(TAG, "Toggled 'dns' to " + bool2);
            }
            getEventService().trackEvent("dns", CollectionUtils.map("value", bool2.toString()));
        }
    }

    public void showCreativeDebugger() {
        this.coreSdk.P0();
    }

    public void showMediationDebugger() {
        this.coreSdk.Q0();
    }

    public String toString() {
        return "AppLovinSdk{sdkKey='" + getSdkKey() + "', isInitialized=" + isInitialized() + ", isFirstSession=" + this.coreSdk.v0() + '}';
    }

    public void showMediationDebugger(@Nullable Map<String, List<?>> map) {
        this.coreSdk.a(map);
    }
}
