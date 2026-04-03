package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.fn;
import com.ironsource.i9;
import com.ironsource.mi;
import com.ironsource.pb;
import com.ironsource.qi;
import com.ironsource.rf;
import com.ironsource.sdk.controller.e;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.wi;
import com.ironsource.xf;
import com.ironsource.yf;
import com.ironsource.zi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class IronSourceNetwork {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f14819a = "IronSourceNetwork";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static wi f14820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<fn> f14821c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static zi f14822d;

    private static synchronized void a() throws Exception {
        if (f14820b == null) {
            throw new NullPointerException("Call initSDK first");
        }
    }

    public static synchronized void addInitListener(fn fnVar) {
        zi ziVar = f14822d;
        if (ziVar == null) {
            f14821c.add(fnVar);
        } else if (ziVar.b()) {
            fnVar.onSuccess();
        } else {
            fnVar.onFail(f14822d.a());
        }
    }

    public static synchronized void destroyAd(mi miVar) throws Exception {
        a();
        f14820b.b(miVar);
    }

    public static synchronized e getControllerManager() {
        return f14820b.a();
    }

    public static String getVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static synchronized void initSDK(Context context, String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            Logger.e(f14819a, "applicationKey is NULL");
            return;
        }
        if (f14820b == null) {
            SDKUtils.setInitSDKParams(map);
            try {
                a(context, SDKUtils.getNetworkConfiguration().optJSONObject("events"), str2, str, map);
            } catch (Exception e10) {
                i9.d().a(e10);
                Logger.e(f14819a, "Failed to init event tracker: " + e10.getMessage());
            }
            f14820b = qi.a(context, str, str2);
        }
    }

    public static synchronized boolean isAdAvailableForInstance(mi miVar) {
        wi wiVar = f14820b;
        if (wiVar == null) {
            return false;
        }
        return wiVar.a(miVar);
    }

    public static synchronized void loadAd(mi miVar, Map<String, String> map) throws Exception {
        a();
        f14820b.a(miVar, map);
    }

    public static synchronized void loadAdView(Activity activity, mi miVar, Map<String, String> map) throws Exception {
        a();
        f14820b.b(activity, miVar, map);
    }

    public static void onPause(Activity activity) {
        wi wiVar = f14820b;
        if (wiVar == null) {
            return;
        }
        wiVar.onPause(activity);
    }

    public static void onResume(Activity activity) {
        wi wiVar = f14820b;
        if (wiVar == null) {
            return;
        }
        wiVar.onResume(activity);
    }

    public static synchronized void release(Activity activity) {
        wi wiVar = f14820b;
        if (wiVar == null) {
            return;
        }
        wiVar.a(activity);
    }

    public static synchronized void showAd(Activity activity, mi miVar, Map<String, String> map) throws Exception {
        a();
        f14820b.a(activity, miVar, map);
    }

    public static synchronized void updateInitFailed(rf rfVar) {
        f14822d = new zi(rfVar);
        Iterator<fn> it = f14821c.iterator();
        while (it.hasNext()) {
            it.next().onFail(rfVar);
        }
        f14821c.clear();
    }

    public static synchronized void updateInitSucceeded() {
        f14822d = new zi();
        Iterator<fn> it = f14821c.iterator();
        while (it.hasNext()) {
            it.next().onSuccess();
        }
        f14821c.clear();
    }

    private static void a(Context context, JSONObject jSONObject, String str, String str2, Map<String, String> map) throws Exception {
        if (jSONObject != null) {
            pb pbVarA = yf.a(jSONObject);
            if (pbVarA.a()) {
                xf.a(pbVarA, yf.a(context, str, str2, map));
            }
        }
    }
}
