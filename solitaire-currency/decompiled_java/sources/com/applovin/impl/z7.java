package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7916a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f7919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f7920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f7921f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f7917b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f7918c = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicBoolean f7922g = new AtomicBoolean();

    static {
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f7084v0;
        if (jVar != null && ((Boolean) jVar.a(l4.N3)).booleanValue() && e()) {
            f7916a = (String) o4.a(n4.G, "", com.applovin.impl.sdk.j.n());
        } else {
            f7916a = "";
            o4.b(n4.G, (Object) null, com.applovin.impl.sdk.j.n());
        }
    }

    public static void a(final com.applovin.impl.sdk.j jVar) {
        if (f7918c.getAndSet(true)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.tf
            @Override // java.lang.Runnable
            public final void run() {
                z7.d(jVar);
            }
        });
    }

    public static String b() {
        return f7921f;
    }

    public static String c() {
        return f7920e;
    }

    public static int d() {
        return f7919d;
    }

    public static void b(com.applovin.impl.sdk.j jVar) {
        if (f7922g.getAndSet(true)) {
            return;
        }
        PackageInfo packageInfoC = c(jVar);
        if (packageInfoC != null) {
            f7919d = packageInfoC.versionCode;
            f7920e = packageInfoC.versionName;
            f7921f = packageInfoC.packageName;
        } else {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("WebViewDataCollector", "Failed to get WebView package info");
            }
        }
    }

    private static PackageInfo c(com.applovin.impl.sdk.j jVar) {
        PackageManager packageManager = com.applovin.impl.sdk.j.n().getPackageManager();
        if (k0.g()) {
            return WebView.getCurrentWebViewPackage();
        }
        Iterator it = jVar.c(l4.Y3).iterator();
        while (it.hasNext()) {
            try {
                return packageManager.getPackageInfo((String) it.next(), 0);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(com.applovin.impl.sdk.j jVar) {
        try {
            synchronized (f7917b) {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(com.applovin.impl.sdk.j.n());
                if (!TextUtils.isEmpty(defaultUserAgent)) {
                    f7916a = defaultUserAgent;
                    o4.b(n4.G, f7916a, com.applovin.impl.sdk.j.n());
                } else {
                    jVar.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.I().b("WebViewDataCollector", "Collected invalid user agent");
                    }
                    jVar.A().a(y1.f7816x0, "collectedInvalidUserAgent");
                }
            }
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("WebViewDataCollector", "Failed to collect user agent", th);
            }
            jVar.A().a("WebViewDataCollector", "collectUserAgent", th);
        }
    }

    private static boolean e() {
        boolean zIsValidString;
        synchronized (f7917b) {
            zIsValidString = StringUtils.isValidString((String) o4.a(n4.G, "", com.applovin.impl.sdk.j.n()));
        }
        return zIsValidString;
    }

    public static String a() {
        String str;
        synchronized (f7917b) {
            str = f7916a;
        }
        return str;
    }
}
