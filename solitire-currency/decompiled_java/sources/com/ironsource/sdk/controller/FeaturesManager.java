package com.ironsource.sdk.controller;

import com.ironsource.i8;
import com.ironsource.i9;
import com.ironsource.j8;
import com.ironsource.jr;
import com.ironsource.kd;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.v8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class FeaturesManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile FeaturesManager f14844c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14845d = "debugMode";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, ?> f14846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f14847b = new a();

    class a extends ArrayList<String> {
        a() {
            add(v8.d.f15729f);
            add(v8.d.f15728e);
            add(v8.d.f15730g);
            add(v8.d.f15731h);
            add(v8.d.f15732i);
            add(v8.d.f15733j);
            add(v8.d.f15734k);
            add(v8.d.f15735l);
            add(v8.d.f15736m);
        }
    }

    private FeaturesManager() {
        if (f14844c != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        this.f14846a = new HashMap();
    }

    public static FeaturesManager getInstance() {
        if (f14844c == null) {
            synchronized (FeaturesManager.class) {
                if (f14844c == null) {
                    f14844c = new FeaturesManager();
                }
            }
        }
        return f14844c;
    }

    ArrayList<String> a() {
        return new ArrayList<>(this.f14847b);
    }

    public JSONObject getDataManagerConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return networkConfiguration.has(v8.a.f15676c) ? networkConfiguration.optJSONObject(v8.a.f15676c) : new JSONObject();
    }

    public int getDebugMode() {
        Integer num = 0;
        try {
            if (this.f14846a.containsKey("debugMode")) {
                num = (Integer) this.f14846a.get("debugMode");
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public i8 getFeatureFlagCatchUrlError() {
        return new i8(SDKUtils.getNetworkConfiguration().optJSONObject(i8.a.f12566c));
    }

    public j8 getFeatureFlagClickCheck() {
        return new j8(SDKUtils.getNetworkConfiguration());
    }

    public kd getFeatureFlagHealthCheck() {
        return new kd(SDKUtils.getNetworkConfiguration().optJSONObject(v8.a.f15690q));
    }

    public int getInitRecoverTrials() {
        JSONObject jSONObjectOptJSONObject = SDKUtils.getNetworkConfiguration().optJSONObject(v8.a.f15678e);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optInt(v8.a.f15677d, 0);
        }
        return 0;
    }

    public jr getSessionHistoryConfig() {
        JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
        return new jr(networkConfiguration.has(v8.a.f15691r) ? networkConfiguration.optJSONObject(v8.a.f15691r) : new JSONObject());
    }

    public void updateDebugConfigurations(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.f14846a = map;
    }
}
