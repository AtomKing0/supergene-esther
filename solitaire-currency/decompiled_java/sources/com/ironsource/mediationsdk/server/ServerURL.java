package com.ironsource.mediationsdk.server;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.ad;
import com.ironsource.ce;
import com.ironsource.el;
import com.ironsource.g1;
import com.ironsource.i9;
import com.ironsource.lj;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.a;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.r8;
import com.ironsource.v3;
import com.ironsource.xa;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class ServerURL {
    private static final String AMPERSAND = "&";
    private static final String ANDROID = "android";
    private static final String APPLICATION_KEY = "applicationKey";
    private static final String APPLICATION_USER_ID = "applicationUserId";
    private static final String APPLICATION_VERSION = "appVer";
    private static final String AUID = "auid";
    private static String BASE_URL_PREFIX = "https://i-sdk.mediation.unity3d.com/sdk/v";
    private static final String BASE_URL_SUFFIX = "?request=";
    private static final String BROWSER_USER_AGENT = "browserUserAgent";
    private static final String BUNDLE_ID = "bundleId";
    private static final String CONNECTION_TYPE = "connType";
    private static final String COPPA = "coppa";
    private static final String DEVICE_LANG = "deviceLang";
    private static final String DEVICE_MAKE = "devMake";
    private static final String DEVICE_MODEL = "devModel";
    private static final String EQUAL = "=";
    private static final String FIRST_SESSION = "fs";
    private static final String GAID = "advId";
    private static final String GOOGLE_FAMILY_SUPPORT = "dff";
    private static final String IMPRESSION = "impression";
    private static final String ISO_COUNTRY_CODE = "icc";
    private static final String IS_DEMAND_ONLY = "isDemandOnly";
    private static final String MEDIATION_TYPE = "mt";
    private static final String MOBILE_CARRIER = "mCar";
    private static final String MOBILE_COUNTRY_CODE = "mcc";
    private static final String MOBILE_NETWORK_CODE = "mnc";
    private static final String OS_VERSION = "osVer";
    private static final String PLACEMENT = "placementId";
    private static final String PLATFORM_KEY = "platform";
    private static final String PLUGIN_FW_VERSION = "plugin_fw_v";
    private static final String PLUGIN_TYPE = "pluginType";
    private static final String PLUGIN_VERSION = "pluginVersion";
    private static final String REWARDED_VIDEO_MANUAL_MODE = "rvManual";
    private static final String SDK_VERSION = "sdkVersion";
    private static final String SERR = "serr";
    private static final String TEST_SUITE = "ts";
    private static final String TIME_ZONE_ID = "tz";
    private static final String TIME_ZONE_OFFSET = "tzOff";

    public static String buildInitURL(Context context, String str, String str2, String str3, String str4, boolean z10, List<Pair<String, String>> list, boolean z11) throws UnsupportedEncodingException {
        String str5;
        List<String> list2;
        ce ceVarF = el.N().f();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("platform", "android"));
        arrayList.add(new Pair("applicationKey", str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new Pair("applicationUserId", str2));
        }
        arrayList.add(new Pair("sdkVersion", IronSourceUtils.getSDKVersion()));
        if (z10) {
            arrayList.add(new Pair(REWARDED_VIDEO_MANUAL_MODE, "1"));
        }
        if (!IronSourceUtils.isEncryptedResponse()) {
            arrayList.add(new Pair(SERR, "0"));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginType())) {
            arrayList.add(new Pair(PLUGIN_TYPE, ConfigFile.getConfigFile().getPluginType()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginVersion())) {
            arrayList.add(new Pair(PLUGIN_VERSION, ConfigFile.getConfigFile().getPluginVersion()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginFrameworkVersion())) {
            arrayList.add(new Pair(PLUGIN_FW_VERSION, ConfigFile.getConfigFile().getPluginFrameworkVersion()));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new Pair(GAID, str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            arrayList.add(new Pair("mt", str4));
        }
        String strB = v3.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(strB)) {
            arrayList.add(new Pair(APPLICATION_VERSION, strB));
        }
        arrayList.add(new Pair(OS_VERSION, Build.VERSION.SDK_INT + ""));
        arrayList.add(new Pair(DEVICE_MAKE, Build.MANUFACTURER));
        arrayList.add(new Pair(DEVICE_MODEL, Build.MODEL));
        arrayList.add(new Pair("fs", (IronSourceUtils.getFirstSession(context) ? 1 : 0) + ""));
        ConcurrentHashMap<String, List<String>> concurrentHashMapC = lj.b().c();
        if (concurrentHashMapC.containsKey(a.f13683b)) {
            arrayList.add(new Pair(COPPA, concurrentHashMapC.get(a.f13683b).get(0)));
        }
        if (concurrentHashMapC.containsKey(a.f13687f)) {
            String str6 = concurrentHashMapC.get(a.f13687f).get(0);
            if (!TextUtils.isEmpty(str6) && str6.equalsIgnoreCase(a.f13691j)) {
                arrayList.add(new Pair("ts", "1"));
            }
        }
        if (concurrentHashMapC.containsKey(a.f13685d)) {
            String str7 = concurrentHashMapC.get(a.f13685d).get(0);
            if (!TextUtils.isEmpty(str7) && str7.equalsIgnoreCase(a.f13688g)) {
                arrayList.add(new Pair(GOOGLE_FAMILY_SUPPORT, "1"));
            }
        }
        if (concurrentHashMapC.containsKey(a.f13686e) && (list2 = concurrentHashMapC.get(a.f13686e)) != null) {
            arrayList.add(new Pair(a.f13686e, list2.get(0)));
        }
        String connectionType = IronSourceUtils.getConnectionType(context);
        if (!TextUtils.isEmpty(connectionType)) {
            arrayList.add(new Pair(CONNECTION_TYPE, connectionType));
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        String strS = ceVarF.s();
        if (strS.length() != 0) {
            arrayList.add(new Pair(BROWSER_USER_AGENT, strS));
        }
        try {
            str5 = ceVarF.b(context) + "-" + ceVarF.F(context);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            str5 = null;
        }
        if (str5 != null && str5.length() != 0) {
            arrayList.add(new Pair(DEVICE_LANG, str5));
        }
        arrayList.add(new Pair("bundleId", context.getPackageName()));
        arrayList.add(new Pair("mcc", "" + r8.b(context)));
        arrayList.add(new Pair("mnc", "" + r8.c(context)));
        String strN = ceVarF.n(context);
        if (!TextUtils.isEmpty(strN)) {
            arrayList.add(new Pair("icc", strN));
        }
        String strJ = ceVarF.j(context);
        if (!TextUtils.isEmpty(strJ)) {
            arrayList.add(new Pair(MOBILE_CARRIER, strJ));
        }
        String strB2 = ceVarF.b();
        if (!TextUtils.isEmpty(strB2)) {
            arrayList.add(new Pair("tz", strB2));
        }
        arrayList.add(new Pair(TIME_ZONE_OFFSET, "" + ceVarF.p()));
        String strS2 = ceVarF.s(context);
        if (!TextUtils.isEmpty(strS2)) {
            arrayList.add(new Pair("auid", strS2));
        }
        if (z11) {
            arrayList.add(new Pair("isDemandOnly", "1"));
        }
        arrayList.add(new Pair(ad.Y, String.valueOf(g1.a())));
        return getBaseUrl(IronSourceUtils.getSDKVersion()) + URLEncoder.encode(IronSourceAES.encode(xa.b().c(), createURLParams(arrayList)), "UTF-8");
    }

    private static String createURLParams(List<Pair<String, String>> list) throws UnsupportedEncodingException {
        String str = "";
        for (Pair<String, String> pair : list) {
            if (str.length() > 0) {
                str = str + "&";
            }
            str = str + ((String) pair.first) + "=" + URLEncoder.encode((String) pair.second, "UTF-8");
        }
        return str;
    }

    private static String getBaseUrl(String str) {
        return BASE_URL_PREFIX + str + BASE_URL_SUFFIX;
    }

    public static String getRequestURL(String str, boolean z10, int i10) throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("impression", Boolean.toString(z10)));
        arrayList.add(new Pair("placementId", Integer.toString(i10)));
        return str + "&" + createURLParams(arrayList);
    }

    private static void setBaseUrlPrefix(String str) {
        BASE_URL_PREFIX = str;
    }
}
