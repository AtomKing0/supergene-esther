package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.y1;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.v8;
import io.sentry.protocol.App;
import io.sentry.protocol.Device;
import io.sentry.protocol.Geo;
import io.sentry.protocol.TransactionInfo;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile ExecutorService f7882g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f7884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f7885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y1.b f7886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f7887d = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f7888e = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f7881f = (int) TimeUnit.SECONDS.toMillis(30);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f7883h = new Object();

    class a implements ThreadFactory {

        /* JADX INFO: renamed from: com.applovin.impl.z1$a$a, reason: collision with other inner class name */
        class C0180a implements Thread.UncaughtExceptionHandler {
            C0180a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                z1.this.f7884a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    z1.this.f7884a.I().a("HealthEventsReporter", "Caught unhandled exception", th);
                }
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:health_events_reporter");
            thread.setDaemon(true);
            thread.setPriority(((Integer) z1.this.f7884a.a(l4.Q)).intValue());
            thread.setUncaughtExceptionHandler(new C0180a());
            return thread;
        }
    }

    public z1(com.applovin.impl.sdk.j jVar, y1.b bVar) {
        this.f7884a = jVar;
        this.f7885b = jVar.I();
        this.f7886c = bVar;
        a();
    }

    private void c(y1 y1Var, List list) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        if (y1Var.a() == y1.b.AD || y1Var.a() == y1.b.MEDIATED_AD || y1Var.a() == y1.b.USER_SESSION || !z6.a(((Integer) this.f7884a.a(l4.f5785z)).intValue())) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            try {
                httpURLConnection = (HttpURLConnection) a(y1Var, map).openConnection();
                try {
                    int i10 = f7881f;
                    httpURLConnection.setConnectTimeout(i10);
                    httpURLConnection.setReadTimeout(i10);
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("AppLovin-Event-Type", y1Var.b());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f7885b.a("HealthEventsReporter", y1Var.b() + " reported with code " + responseCode + " and extra parameters " + map);
                    }
                    this.f7887d.put(y1Var, Long.valueOf(System.currentTimeMillis()));
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f7885b.d("HealthEventsReporter", "Failed to report " + y1Var.b() + " with extra parameters " + map, th);
                        }
                        z6.a(httpURLConnection, this.f7884a);
                    } finally {
                        z6.a(httpURLConnection, this.f7884a);
                    }
                }
            } catch (Throwable th3) {
                httpURLConnection = null;
                th = th3;
            }
        }
    }

    public void d(y1 y1Var, Map map) {
        a(y1Var, map, 0L);
    }

    private void a() {
        if (f7882g != null) {
            return;
        }
        synchronized (f7883h) {
            if (f7882g != null) {
                return;
            }
            f7882g = Executors.newFixedThreadPool(1, new a());
        }
    }

    private void d(final y1 y1Var, List list) {
        final String str = (String) this.f7884a.a(l4.A);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        double dA = y1Var.a(this.f7884a);
        if (z6.a(dA)) {
            if (((Boolean) this.f7884a.a(l4.G)).booleanValue()) {
                a(str, y1Var, a(y1Var, dA, list));
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final JSONObject jSONObjectA = a(y1Var, dA, Collections.singletonList((Map) it.next()));
                f7882g.execute(new Runnable() { // from class: com.applovin.impl.of
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6491a.a(str, y1Var, jSONObjectA);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(String str, y1 y1Var, JSONObject jSONObject) {
        byte[] bytes;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            URL url = new URL(str);
            bytes = jSONObject.toString().getBytes("UTF-8");
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            int i10 = f7881f;
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setReadTimeout(i10);
            httpURLConnection.setRequestProperty(com.ironsource.nb.K, "application/json; charset=utf-8");
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("AppLovin-Event-Type", y1Var.b());
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (com.applovin.impl.sdk.n.a()) {
                this.f7885b.a("HealthEventsReporter", y1Var.b() + " reported with code " + responseCode);
            }
            this.f7887d.put(y1Var, Long.valueOf(System.currentTimeMillis()));
            z6.a(httpURLConnection, this.f7884a);
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            try {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7885b.d("HealthEventsReporter", "Failed to report " + y1Var.b(), th);
                }
            } finally {
                z6.a(httpURLConnection2, this.f7884a);
            }
        }
    }

    public void a(y1 y1Var, String str) {
        a(y1Var, str, new HashMap());
    }

    public void a(y1 y1Var, String str, Map map) {
        map.put(TransactionInfo.JsonKeys.SOURCE, str);
        d(y1Var, map);
    }

    public void a(y1 y1Var, String str, Map map, String str2) {
        if (!StringUtils.isValidString(str2) || this.f7888e.add(str2)) {
            map.put(TransactionInfo.JsonKeys.SOURCE, str);
            a(y1Var, str, map);
        }
    }

    public void a(y1 y1Var, Map map, long j10) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        a(y1Var, arrayList, j10);
    }

    public void a(final y1 y1Var, final List list, long j10) {
        if (a(y1Var, j10)) {
            return;
        }
        try {
            if (z6.h()) {
                f7882g.execute(new Runnable() { // from class: com.applovin.impl.pf
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6584a.b(y1Var, list);
                    }
                });
            } else {
                b(y1Var, list);
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7885b.d("HealthEventsReporter", "Failed to report " + y1Var.b() + " with extra parameters collection " + list, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(y1 y1Var, List list) {
        if (AppLovinSdkUtils.isEmulator()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7885b.a("HealthEventsReporter", "Reporting " + y1Var.b() + " with extra parameters collection " + list);
        }
        if (this.f7886c != y1Var.a()) {
            e1.a("Health event " + y1Var.b() + " category: " + y1Var.a() + " does not match the reporter category: " + this.f7886c, new Object[0]);
        }
        c(y1Var, list);
        d(y1Var, list);
    }

    private Map c(y1 y1Var, Map map) {
        HashMap map2 = new HashMap(map);
        if (y1Var == y1.f7794m0) {
            map2.remove("details");
        }
        return map2;
    }

    private Map b(y1 y1Var, Map map) {
        HashMap map2 = new HashMap();
        map2.put("type", y1Var.b());
        if (y1Var == y1.f7786i0 || y1Var == y1.f7816x0 || y1Var == y1.f7812v0) {
            if (((Boolean) this.f7884a.a(l4.X3)).booleanValue()) {
                CollectionUtils.putStringIfValid("wvvc", String.valueOf(z7.d()), map2);
                CollectionUtils.putStringIfValid("wvv", z7.c(), map2);
                CollectionUtils.putStringIfValid("wvpn", z7.b(), map2);
            }
            CollectionUtils.putStringIfValid("oglv", this.f7884a.y().H(), map2);
        }
        Map mapK = this.f7884a.y().K();
        map2.put("platform", String.valueOf(mapK.get("platform")));
        map2.put(Geo.JsonKeys.COUNTRY_CODE, String.valueOf(mapK.get(Geo.JsonKeys.COUNTRY_CODE)));
        map2.put("cc", this.f7884a.t().getCountryCode());
        map2.put("applovin_random_token", this.f7884a.a0());
        map2.put("compass_random_token", this.f7884a.s());
        map2.put("model", Build.MODEL);
        map2.put(Device.JsonKeys.BRAND, Build.MANUFACTURER);
        map2.put("brand_name", Build.BRAND);
        map2.put("hardware", Build.HARDWARE);
        map2.put("revision", Build.DEVICE);
        map2.put("os", Build.VERSION.RELEASE);
        map2.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        map2.put("sdk_version", String.valueOf(AppLovinSdk.VERSION));
        CollectionUtils.putStringIfValid("ad_review_sdk_version", h.b(), map2);
        map2.put(com.ironsource.ad.f11264s, (String) this.f7884a.a(l4.f5742t));
        b(map2);
        a(map2);
        if (map != null) {
            map2.putAll(c(y1Var, map));
        }
        return map2;
    }

    private URL a(y1 y1Var, Map map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("https://ms.applovin.com/1.0/sdk/error");
        sb.append("?");
        Iterator it = b(y1Var, map).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strEncode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
            String strEncode2 = URLEncoder.encode((String) entry.getValue(), "UTF-8");
            sb.append(strEncode);
            sb.append(v8.i.f15833b);
            sb.append(strEncode2);
            if (it.hasNext()) {
                sb.append(v8.i.f15835c);
            }
        }
        return new URL(sb.toString());
    }

    private JSONObject a(y1 y1Var, double d10, List list) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "ts_ms", System.currentTimeMillis());
        if (y1Var == y1.f7786i0 || y1Var == y1.f7816x0 || y1Var == y1.f7812v0) {
            if (((Boolean) this.f7884a.a(l4.X3)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "wvvc", String.valueOf(z7.d()));
                JsonUtils.putStringIfValid(jSONObject, "wvv", z7.c());
                JsonUtils.putStringIfValid(jSONObject, "wvpn", z7.b());
            }
            JsonUtils.putStringIfValid(jSONObject, "oglv", this.f7884a.y().H());
        }
        JSONObject jSONObject2 = new JSONObject();
        Map mapK = this.f7884a.y().K();
        JsonUtils.putObject(jSONObject2, "platform", mapK.get("platform"));
        JsonUtils.putObject(jSONObject2, "os", mapK.get("os"));
        JsonUtils.putObject(jSONObject2, Device.JsonKeys.BRAND, mapK.get(Device.JsonKeys.BRAND));
        JsonUtils.putObject(jSONObject2, "model", mapK.get("model"));
        JsonUtils.putObject(jSONObject2, "revision", mapK.get("revision"));
        JsonUtils.putObject(jSONObject2, Geo.JsonKeys.COUNTRY_CODE, mapK.get(Geo.JsonKeys.COUNTRY_CODE));
        JsonUtils.putObject(jSONObject2, "cc", this.f7884a.t().getCountryCode());
        JsonUtils.putObject(jSONObject2, "applovin_random_token", this.f7884a.a0());
        JsonUtils.putObject(jSONObject2, "ad_review_sdk_version", StringUtils.emptyIfNull(h.b()));
        Map mapC = this.f7884a.y().C();
        JsonUtils.putObject(jSONObject2, "sdk_version", mapC.get("sdk_version"));
        JsonUtils.putObject(jSONObject2, "plugin_version", this.f7884a.a(l4.f5761v3));
        JsonUtils.putObject(jSONObject2, App.JsonKeys.APP_VERSION, mapC.get(App.JsonKeys.APP_VERSION));
        JsonUtils.putObject(jSONObject2, v8.h.V, mapC.get(v8.h.V));
        JsonUtils.putObject(jSONObject2, "first_install", Boolean.toString(Boolean.TRUE.equals((Boolean) mapC.get("first_install_v2"))));
        JsonUtils.putObject(jSONObject2, com.ironsource.ad.f11264s, this.f7884a.a(l4.f5742t));
        JsonUtils.putObject(jSONObject2, "mediation_provider", this.f7884a.O());
        SessionTracker sessionTrackerF0 = this.f7884a.f0();
        JsonUtils.putObject(jSONObject2, "app_state", sessionTrackerF0.getCurrentApplicationState().b());
        JsonUtils.putObject(jSONObject2, "app_state_duration_ms", Long.valueOf(sessionTrackerF0.getCurrentApplicationStateDurationMillis()));
        JsonUtils.putObject(jSONObject2, "session_duration_ms", Long.valueOf(System.currentTimeMillis() - com.applovin.impl.sdk.j.m()));
        JsonUtils.putObject(jSONObject, "shared_fields", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putDouble(jSONObject3, "ts_ms", System.currentTimeMillis());
            JsonUtils.putString(jSONObject3, "type", y1Var.b());
            JsonUtils.putDouble(jSONObject3, "weight", d10);
            JsonUtils.putString(jSONObject3, AppLovinEventTypes.USER_COMPLETED_LEVEL, "DEBUG");
            a(map);
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) map);
            jSONArray.put(jSONObject3);
        }
        JsonUtils.putObject(jSONObject, "events", jSONArray);
        return jSONObject;
    }

    private void b(Map map) {
        String packageName;
        PackageInfo packageInfo;
        PackageManager packageManager;
        try {
            packageManager = com.applovin.impl.sdk.j.n().getPackageManager();
            packageName = com.applovin.impl.sdk.j.n().getPackageName();
        } catch (Throwable unused) {
            packageName = "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(packageName, 0);
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        map.put(v8.h.V, packageName);
        map.put(App.JsonKeys.APP_VERSION, packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", String.valueOf(packageInfo != null ? packageInfo.versionCode : 0));
    }

    private void a(Map map) {
        if (map == null) {
            return;
        }
        Object objA = this.f7884a.D().a();
        if (objA instanceof com.applovin.impl.sdk.ad.b) {
            map.put("fs_ad_network", "AppLovin");
            map.put("fs_ad_creative_id", Long.toString(((com.applovin.impl.sdk.ad.b) objA).getAdIdNumber()));
        } else if (objA instanceof q2) {
            q2 q2Var = (q2) objA;
            map.put("fs_ad_network", q2Var.getNetworkName());
            map.put("fs_ad_creative_id", q2Var.getCreativeId());
        } else {
            map.put("fs_ad_network", "None");
            map.put("fs_ad_creative_id", "None");
        }
    }

    private boolean a(y1 y1Var, long j10) {
        Long l10 = (Long) this.f7887d.get(y1Var);
        return System.currentTimeMillis() - (l10 != null ? l10.longValue() : -1L) < j10;
    }
}
