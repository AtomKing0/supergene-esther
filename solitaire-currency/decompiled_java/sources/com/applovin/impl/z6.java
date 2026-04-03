package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.v8;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f7907a = {60, 60, 24, 7, 4, 12};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f7908b = {" second", " minute", " hour", " day", " week", " month"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f7909c = {CmcdData.Factory.STREAMING_FORMAT_SS, "m", CmcdData.Factory.STREAMING_FORMAT_HLS, "d", "w", "mth"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DecimalFormat f7910d = new DecimalFormat();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Random f7911e = new Random();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Boolean f7912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Boolean f7913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f7914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Boolean f7915i;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    public static double a(long j10) {
        return j10 / 1024.0d;
    }

    public static float b(float f10) {
        return f10 * 1000.0f;
    }

    public static double d(long j10) {
        return j10 / 1000.0d;
    }

    public static long e(String str) {
        if (!StringUtils.isValidString(str)) {
            return Long.MAX_VALUE;
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public static String f(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    public static boolean g() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Exception thrown while getting memory state.", th);
        }
        int i10 = runningAppProcessInfo.importance;
        return i10 == 100 || i10 == 200;
    }

    public static boolean h() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean i() {
        return !a("com.applovin.sdk.AppLovinSdk");
    }

    public static boolean j() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                String displayName = networkInterfaces.nextElement().getDisplayName();
                if (displayName.contains("tun") || displayName.contains("ppp") || displayName.contains("ipsec")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to check Network Interfaces", th);
            return false;
        }
    }

    public static boolean k() {
        Context contextN = com.applovin.impl.sdk.j.n();
        if (contextN != null) {
            return w.a(contextN).a("applovin.sdk.verbose_logging");
        }
        return false;
    }

    public static int a(int i10, int i11) {
        return (i10 < 0 || i10 > 100) ? i11 : i10;
    }

    public static int b(int i10) {
        return i10 * 1024;
    }

    public static void c() {
    }

    public static String d() {
        try {
            return Build.VERSION.RELEASE + " (" + e() + " - API " + Build.VERSION.SDK_INT + ")";
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to get Android OS info", th);
            return "";
        }
    }

    public static boolean h(Context context) {
        if (f7913g == null) {
            f7913g = Boolean.valueOf("com.applovin.apps.playables".equals(context.getPackageName()));
        }
        return f7913g.booleanValue();
    }

    public static boolean i(Context context) {
        String packageName = context.getPackageName();
        return "com.revolverolver.fliptrickster".equals(packageName) || "com.mindstormstudios.idlemakeover".equals(packageName);
    }

    public static void a() {
    }

    public static long b(long j10) {
        return j10 * 8;
    }

    public static long c(float f10) {
        return a(b(f10));
    }

    public static String e() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt(null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to get Android SDK codename", th);
            return "";
        }
    }

    public static boolean f(Context context) {
        if (f7912f == null) {
            f7912f = Boolean.valueOf("com.applovin.apps.dspdemo".equals(context.getPackageName()));
        }
        return f7912f.booleanValue();
    }

    public static boolean k(Context context) {
        if (context == null) {
            context = com.applovin.impl.sdk.j.n();
        }
        if (context != null) {
            return w.a(context).a("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    public static boolean a(long j10, long j11) {
        return (j10 & j11) != 0;
    }

    public static void b() {
    }

    public static double c(long j10) {
        return a(b(j10));
    }

    public static byte[] d(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0 || !b(bArr)) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i10 = gZIPInputStream.read(bArr2);
            if (i10 > 0) {
                byteArrayOutputStream.write(bArr2, 0, i10);
            } else {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String a(Map map, boolean z10) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z10) {
            TreeMap treeMap = new TreeMap(new a());
            treeMap.putAll(map);
            map = treeMap;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(v8.i.f15835c);
            }
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (str.contains(v8.i.f15835c)) {
                    value = str.replace(v8.i.f15835c, "%26");
                }
            }
            sb.append(entry.getKey());
            sb.append(com.ironsource.nb.T);
            sb.append(value);
        }
        return sb.toString();
    }

    public static void b(String str, String str2) {
        if (str == null || str.length() <= b(8)) {
            return;
        }
        com.applovin.impl.sdk.n.j(str2, "Provided custom data parameter longer than supported (" + str.length() + " bytes, " + b(8) + " maximum)");
    }

    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    public static int g(String str) {
        int i10 = 0;
        for (String str2 : str.replaceAll("-beta", ".").split("\\.")) {
            if (str2.length() > 2) {
                com.applovin.impl.sdk.n.h("Utils", "Version number components cannot be longer than two digits -> " + str);
                return i10;
            }
            i10 = (i10 * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i10 * 100) + 99 : i10;
    }

    public static int f() {
        if (k0.b()) {
            return WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout();
        }
        return 0;
    }

    public static String b(Class cls, String str) {
        try {
            Field fieldA = a(cls, str);
            fieldA.setAccessible(true);
            return (String) fieldA.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c(com.applovin.impl.sdk.j jVar) {
        String str = jVar.g0().getExtraParameters().get("run_in_release_mode");
        return ((StringUtils.isValidString(str) && Boolean.parseBoolean(str)) || (com.applovin.impl.sdk.j.n().getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static boolean e(Context context) {
        return w.a(context).a("applovin.sdk.is_test_environment");
    }

    public static boolean e(com.applovin.impl.sdk.j jVar) {
        if (((Boolean) jVar.a(l4.Z1)).booleanValue()) {
            return jVar.g0().isMuted();
        }
        return ((Boolean) jVar.a(l4.X1)).booleanValue();
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getResources();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(AppLovinAd appLovinAd, com.applovin.impl.sdk.j jVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
            String strB0 = jVar.b0();
            String strB02 = appLovinAdBase.getSdk().b0();
            if (strB0.equals(strB02)) {
                return;
            }
            String str = "Ad was loaded from sdk with key: " + strB02 + ", but is being rendered from sdk with key: " + strB0;
            com.applovin.impl.sdk.n.h("AppLovinAd", str);
            jVar.E().c(v1.f7567q);
            a(str, appLovinAdBase, "AppLovinAd", jVar);
        }
    }

    public static long c(byte[] bArr) {
        return a(bArr, 0);
    }

    public static String c(String str) {
        return str.replace("ALPlayableAnalytics.trackEvent = ", "ALPlayableAnalytics.trackEvent = function (eventName) {const SDK_URL = 'applovin://com.applovin.sdk/playable_event';if (!Object.values(ALPlayableEvent).includes(eventName)) {var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=0&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();return;}var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=1&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();}; ALPlayableAnalytics.trackEvent_ignore = ");
    }

    public static String d(String str) {
        return a(str, str.split("\\.").length);
    }

    public static Boolean g(Context context) {
        if (context == null) {
            return null;
        }
        Boolean bool = f7915i;
        if (bool != null) {
            return bool;
        }
        try {
            String strA = w.a(context).a();
            String strB = b(context);
            if (strB == null) {
                return null;
            }
            if (strB.equals(strA)) {
                Boolean bool2 = Boolean.TRUE;
                f7915i = bool2;
                return bool2;
            }
            if (TextUtils.isEmpty(strA) && strB.equals(context.getPackageName())) {
                Boolean bool3 = Boolean.TRUE;
                f7915i = bool3;
                return bool3;
            }
            Boolean bool4 = Boolean.FALSE;
            f7915i = bool4;
            return bool4;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to determine if the current process is the main process", th);
            return null;
        }
    }

    public static boolean d(com.applovin.impl.sdk.j jVar) {
        String str = jVar.g0().getExtraParameters().get("user_agent_collection_enabled");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public static Context d(Context context) {
        return j(context) ? context : com.applovin.impl.sdk.j.n();
    }

    public static Map a(Map map) {
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                map2.put((String) entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return map2;
    }

    private static long b(String str) {
        if (str == null) {
            return 0L;
        }
        return new File(str).length();
    }

    public static boolean b(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 31 && bArr[1] == -117;
    }

    public static boolean b(com.applovin.impl.sdk.j jVar) {
        try {
            JSONObject.wrap(JSONObject.NULL);
            return true;
        } catch (Throwable th) {
            jVar.I();
            if (!com.applovin.impl.sdk.n.a()) {
                return false;
            }
            jVar.I().d("Utils", "Failed to wrap JSONObject with exception", th);
            return false;
        }
    }

    public static boolean a(String str, List list) {
        return StringUtils.startsWithAtLeastOnePrefix(str, list);
    }

    public static boolean b(List list) {
        Context contextN = com.applovin.impl.sdk.j.n();
        if (contextN == null) {
            com.applovin.impl.sdk.n.h("Utils", "Failed to check whether or not app is member of package names");
            return false;
        }
        return list.contains(contextN.getPackageName());
    }

    public static int a(int i10) {
        return a(i10, 95);
    }

    public static long a(com.applovin.impl.sdk.j jVar) {
        long jLongValue = ((Long) jVar.a(l4.f5597a5)).longValue();
        long jLongValue2 = ((Long) jVar.a(l4.f5604b5)).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (jLongValue <= 0 || jLongValue2 <= 0) ? jCurrentTimeMillis : jCurrentTimeMillis + (jLongValue - jLongValue2);
    }

    public static WebView b(Context context, String str) {
        return a(context, str, false);
    }

    public static String b(Context context) {
        int iMyPid;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        if (StringUtils.isValidString(f7914h)) {
            return f7914h;
        }
        try {
            iMyPid = Process.myPid();
            runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to determine process name", th);
        }
        if (runningAppProcesses == null) {
            com.applovin.impl.sdk.n.c("Utils", "No running app processes. Unable to determine process name");
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (iMyPid == runningAppProcessInfo.pid) {
                String str = runningAppProcessInfo.processName;
                f7914h = str;
                return str;
            }
        }
        return null;
    }

    public static void a(String str, String str2, Map map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    private static long a(float f10) {
        return Math.round(f10);
    }

    public static String a(long j10, boolean z10) {
        String[] strArr = z10 ? f7908b : f7909c;
        long jCurrentTimeMillis = (System.currentTimeMillis() - j10) / 1000;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            long j11 = f7907a[i10];
            if (jCurrentTimeMillis < j11) {
                if (jCurrentTimeMillis <= 0) {
                    return z10 ? "just now" : "now";
                }
                return String.format("%d%s%s%s", Long.valueOf(jCurrentTimeMillis), strArr[i10], (!z10 || jCurrentTimeMillis <= 1) ? "" : CmcdData.Factory.STREAMING_FORMAT_SS, z10 ? " ago" : "");
            }
            jCurrentTimeMillis /= j11;
        }
        return z10 ? "just now" : "now";
    }

    public static double a(String str, double d10) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to parse double from String: " + str, th);
            return d10;
        }
    }

    public static String a(Uri uri, String str, com.applovin.impl.sdk.j jVar) {
        List listC = jVar.c(l4.E0);
        String lastPathSegment = uri.getLastPathSegment();
        if (listC.contains(lastPathSegment)) {
            return lastPathSegment;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = uri.getQueryParameterNames().iterator();
        while (it.hasNext()) {
            String queryParameter = uri.getQueryParameter(it.next());
            if (StringUtils.isValidString(queryParameter)) {
                arrayList.add(queryParameter);
            }
        }
        arrayList.addAll(uri.getPathSegments());
        String strEncodeUriString = StringUtils.encodeUriString(TextUtils.join("_", arrayList));
        Integer num = (Integer) jVar.a(l4.F0);
        int length = StringUtils.emptyIfNull(strEncodeUriString).length() + StringUtils.emptyIfNull(str).length();
        if (length > num.intValue() && StringUtils.isValidString(strEncodeUriString)) {
            strEncodeUriString = strEncodeUriString.substring(length - num.intValue());
        }
        if (!StringUtils.isValidString(strEncodeUriString) || !StringUtils.isValidString(str)) {
            return strEncodeUriString;
        }
        return str + strEncodeUriString;
    }

    public static void a(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject.has("no_fill_reason")) {
            Object object = JsonUtils.getObject(jSONObject, "no_fill_reason", new Object());
            StringBuilder sb = new StringBuilder();
            sb.append("\n**************************************************\nNO FILL received:\n..ID: \"");
            sb.append(str);
            sb.append("\"\n..FORMAT: \"");
            sb.append(maxAdFormat != null ? maxAdFormat.getLabel() : "None");
            sb.append("\"\n..SDK KEY: \"");
            sb.append(jVar.b0());
            sb.append("\"\n..PACKAGE NAME: \"");
            sb.append(com.applovin.impl.sdk.j.n().getPackageName());
            sb.append("\"\n..Reason: ");
            sb.append(object);
            sb.append("\n**************************************************\n");
            String string = sb.toString();
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("AppLovinSdk", string);
            }
        }
    }

    public static AppLovinAd a(AppLovinAd appLovinAd, com.applovin.impl.sdk.j jVar) {
        if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
            return appLovinAd;
        }
        com.applovin.impl.sdk.ad.c cVar = (com.applovin.impl.sdk.ad.c) appLovinAd;
        AppLovinAd appLovinAdDequeueAd = jVar.k().dequeueAd(cVar.getAdZone());
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().a("Utils", "Dequeued ad for dummy ad: " + appLovinAdDequeueAd);
        }
        if (appLovinAdDequeueAd != null) {
            cVar.a(appLovinAdDequeueAd);
            ((AppLovinAdImpl) appLovinAdDequeueAd).setDummyAd(cVar);
            return appLovinAdDequeueAd;
        }
        return cVar.f();
    }

    public static s a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        return s.a(AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", null)), AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", null)), JsonUtils.getString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, null), true, JsonUtils.getBoolean(jSONObject, "is_direct_sold", Boolean.FALSE).booleanValue());
    }

    public static Field a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return a(superclass, str);
        }
    }

    public static List a(JSONObject jSONObject, String str, String str2, com.applovin.impl.sdk.j jVar) {
        return a(jSONObject, str, null, str2, null, false, jVar);
    }

    public static List a(JSONObject jSONObject, String str, Map map, String str2, Map map2, boolean z10, com.applovin.impl.sdk.j jVar) {
        if (map == null) {
            map = new HashMap(1);
        }
        Map map3 = map;
        map3.put("{CLCODE}", str);
        return a(jSONObject, map3, str2, map2, z10, jVar);
    }

    public static List a(JSONObject jSONObject, Map map, String str, Map map2, boolean z10, com.applovin.impl.sdk.j jVar) {
        ArrayList arrayList = new ArrayList(jSONObject.length() + 1);
        if (StringUtils.isValidString(str)) {
            arrayList.add(new e(str, null, map2, z10));
        }
        if (jSONObject.length() <= 0) {
            return arrayList;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    String strOptString = jSONObject.optString(next);
                    String strReplace = StringUtils.replace(next, map);
                    if (AppLovinSdkUtils.isValidString(strOptString)) {
                        strOptString = StringUtils.replace(strOptString, map);
                    }
                    arrayList.add(new e(strReplace, strOptString, map2, z10));
                }
            } catch (Throwable th) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Utils", "Failed to create and add postback url.", th);
                }
            }
        }
        return arrayList;
    }

    public static void a(com.applovin.impl.sdk.j jVar, String str) {
        String strB0 = jVar.b0();
        if (((Boolean) jVar.a(l4.f5778y)).booleanValue()) {
            if (strB0 == null || strB0.length() != 86) {
                a(TextUtils.isEmpty(strB0) ? "Empty SDK key" : "Invalid SDK key length", str, jVar);
            }
        }
    }

    private static void a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        a(str, (AppLovinAdBase) null, str2, jVar);
    }

    private static void a(String str, AppLovinAdBase appLovinAdBase, String str2, com.applovin.impl.sdk.j jVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("sdkKey=");
        sb.append(jVar.b0());
        if (appLovinAdBase != null) {
            sb.append(",adSdkKey=");
            sb.append(appLovinAdBase.getSdk().b0());
        }
        HashMap map = new HashMap();
        CollectionUtils.putStringIfValid("details", sb.toString(), map);
        CollectionUtils.putStringIfValid("error_message", str, map);
        jVar.A().a(y1.f7798o0, str2, map);
    }

    public static Map a(Map map, com.applovin.impl.sdk.j jVar) {
        Map map2 = CollectionUtils.map(map);
        for (String str : map2.keySet()) {
            String str2 = (String) map2.get(str);
            if (str2 != null) {
                map2.put(str, StringUtils.encodeUriString(str2));
            }
        }
        return map2;
    }

    public static String a(Context context, String str, com.applovin.impl.sdk.j jVar) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities.isEmpty()) {
                return null;
            }
            return listQueryIntentActivities.get(0).activityInfo.name;
        } catch (Throwable th) {
            jVar.A().a(str, th);
            return null;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (a((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        thread.start();
    }

    public static void a(Closeable closeable, com.applovin.impl.sdk.j jVar) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            if (jVar != null) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Utils", "Unable to close stream: " + closeable, th);
                }
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection, com.applovin.impl.sdk.j jVar) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (jVar != null) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Utils", "Unable to disconnect connection: " + httpURLConnection, th);
                }
            }
        }
    }

    public static void a(final String str, final Context context) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sf
            @Override // java.lang.Runnable
            public final void run() {
                z6.a(context, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str) {
        Toast toastMakeText = Toast.makeText(context, str, 0);
        toastMakeText.setMargin(0.0f, 0.1f);
        toastMakeText.show();
    }

    public static void a(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getLabel() + ": " + str, 1).show();
    }

    public static boolean a(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER;
    }

    public static String a(Object obj) {
        if (obj instanceof q2) {
            return ((q2) obj).N();
        }
        if (l3.a(obj)) {
            return ((com.applovin.impl.sdk.ad.b) obj).I();
        }
        return null;
    }

    public static List a(boolean z10, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar, Context context) {
        boolean z11;
        if (bVar instanceof a7) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = new ArrayList(bVar.i()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Uri uri = (Uri) it.next();
            boolean zC = jVar.C().c(uri.getLastPathSegment(), context);
            z11 = ((Boolean) jVar.a(l4.f5692m5)).booleanValue() && b(uri.getPath()) == 0;
            if (!zC || z11) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().b("Utils", "Cached HTML asset missing: " + uri);
                }
                arrayList.add(uri);
            }
        }
        Uri uriP0 = bVar.p0();
        if (z10 && uriP0 != null) {
            boolean zC2 = jVar.C().c(uriP0.getLastPathSegment(), context);
            z11 = ((Boolean) jVar.a(l4.f5692m5)).booleanValue() && b(uriP0.getPath()) == 0;
            if (!zC2 || z11) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().b("Utils", "Cached video missing: " + uriP0);
                }
                arrayList.add(uriP0);
            }
        }
        return arrayList;
    }

    public static void a(MaxError maxError, String str, Context context) {
        StringBuilder sb = new StringBuilder();
        if (maxError.getCode() == -5001) {
            for (MaxNetworkResponseInfo maxNetworkResponseInfo : maxError.getWaterfall().getNetworkResponses()) {
                MaxError error = maxNetworkResponseInfo.getError();
                String name = maxNetworkResponseInfo.getMediatedNetwork().getName();
                sb.append("\nFailed to load " + str + " from " + name + ":\n");
                sb.append("\nMAX Error " + error.getCode() + ": " + error.getMessage() + "\n");
                sb.append("\n" + name + " Error " + error.getMediatedNetworkErrorCode() + ": " + error.getMediatedNetworkErrorMessage() + "\n\n");
            }
        } else {
            sb.append("Failed to load " + str + " with error " + maxError.getCode() + ": " + maxError.getMessage());
        }
        a("", sb.toString(), context);
    }

    public static void a(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(R.string.ok, (DialogInterface.OnClickListener) null).create().show();
    }

    public static boolean a(double d10) {
        if (d10 >= 100.0d) {
            return true;
        }
        return d10 > 0.0d && ((double) f7911e.nextFloat()) < d10 / 100.0d;
    }

    public static byte[] a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static long a(byte[] bArr, int i10) {
        int i11 = i10 + 8;
        if (bArr.length < i11) {
            throw new IllegalArgumentException("byte array must be at least 8 bytes long");
        }
        long j10 = 0;
        while (i10 < i11) {
            j10 |= (((long) bArr[i10]) & 255) << (i10 * 8);
            i10++;
        }
        return j10;
    }

    public static int a(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    public static String a(String str, int i10) {
        String[] strArrSplit = StringUtils.toDigitsOnlyVersionString(str).split("\\.");
        if (strArrSplit.length == i10) {
            return rf.a(".", strArrSplit);
        }
        if (strArrSplit.length > i10) {
            return g9.a(".", new ArrayList(Arrays.asList(strArrSplit)).subList(0, i10));
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArrSplit));
        arrayList.addAll(Collections.nCopies(i10 - arrayList.size(), "0"));
        return g9.a(".", arrayList);
    }

    public static int a(String str, String str2) {
        String digitsOnlyVersionString = StringUtils.toDigitsOnlyVersionString(str);
        String digitsOnlyVersionString2 = StringUtils.toDigitsOnlyVersionString(str2);
        try {
            String[] strArrSplit = digitsOnlyVersionString.split("\\.");
            String[] strArrSplit2 = digitsOnlyVersionString2.split("\\.");
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            int i10 = 0;
            while (i10 < iMax) {
                String str3 = i10 < strArrSplit.length ? strArrSplit[i10] : "0";
                String str4 = i10 < strArrSplit2.length ? strArrSplit2[i10] : "0";
                int i11 = Integer.parseInt(str3);
                int i12 = Integer.parseInt(str4);
                if (i11 < i12) {
                    return -1;
                }
                if (i11 > i12) {
                    return 1;
                }
                i10++;
            }
            return 0;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to process version string.", th);
            return 0;
        }
    }

    public static WebView a(Context context, String str, boolean z10) {
        try {
            WebView webView = new WebView(context);
            if (z10) {
                webView.setWebViewClient(new h4());
            }
            return webView;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to initialize WebView for " + str + ".", th);
            return null;
        }
    }

    public static void a(Uri uri, Activity activity, com.applovin.impl.sdk.j jVar) {
        if (activity == null) {
            activity = jVar.n0();
        }
        Intent intent = new Intent(activity, (Class<?>) AppLovinWebViewActivity.class);
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, jVar.b0());
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, uri.toString());
        activity.startActivity(intent);
    }

    public static String a(int i10, Context context, com.applovin.impl.sdk.j jVar) {
        if (i10 == 0) {
            return "";
        }
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i10);
            try {
                byte[] bArr = new byte[inputStreamOpenRawResource.available()];
                inputStreamOpenRawResource.read(bArr);
                return new String(bArr);
            } catch (IOException e10) {
                if (jVar != null) {
                    jVar.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.I().a("Utils", "Opening raw resource file threw exception", e10);
                    }
                }
                return "";
            } finally {
                a(inputStreamOpenRawResource, jVar);
            }
        } catch (Throwable th) {
            if (jVar != null) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Utils", "Failed to retrieve resource " + i10, th);
                }
            }
            return "";
        }
    }

    public static boolean a(MaxAdFormat maxAdFormat, MaxAdFormat maxAdFormat2) {
        return (maxAdFormat == null || maxAdFormat2 == null || (maxAdFormat != maxAdFormat2 && ((!maxAdFormat.isAdViewAd() || !maxAdFormat2.isAdViewAd()) && (!maxAdFormat.isFullscreenAd() || !maxAdFormat2.isFullscreenAd())))) ? false : true;
    }

    public static boolean a(String str, com.applovin.impl.sdk.j jVar) {
        if (str == null) {
            return false;
        }
        return StringUtils.containsAtLeastOneSubstring(str, jVar.c(l4.f5758v0));
    }

    public static ActivityManager.MemoryInfo a(ActivityManager activityManager) {
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to collect memory info.", th);
            return null;
        }
    }

    public static String a(AppLovinSdkSettings appLovinSdkSettings) {
        String strEmptyIfNull = StringUtils.emptyIfNull(appLovinSdkSettings.getExtraParameters().get("applovin_unity_metadata"));
        if (TextUtils.isEmpty(strEmptyIfNull)) {
            return null;
        }
        Map<String, String> mapTryToStringMap = JsonUtils.tryToStringMap(JsonUtils.jsonObjectFromJsonString(strEmptyIfNull, new JSONObject()));
        if (CollectionUtils.isEmpty(mapTryToStringMap)) {
            return null;
        }
        return mapTryToStringMap.get("UnityVersion");
    }

    public static void a(String str, int i10, int i11, k1 k1Var) {
        if (i10 > i11) {
            k1Var.a(y1.f7802q0, str, CollectionUtils.hashMap("details", i10 + " Leaking Instances"));
        }
    }
}
