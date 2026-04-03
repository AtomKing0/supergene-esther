package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import io.sentry.protocol.Browser;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.TransactionInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w6 {

    class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.adview.a f7686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f7687c;

        a(String str, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
            this.f7685a = str;
            this.f7686b = aVar;
            this.f7687c = jVar;
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof AppLovinWebViewActivity) {
                ((AppLovinWebViewActivity) activity).loadUrl(this.f7685a, null);
                l2.c(this.f7686b.e(), this.f7686b.g(), this.f7686b.i());
            }
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof AppLovinWebViewActivity) {
                l2.a(this.f7686b.e(), this.f7686b.g(), this.f7686b.i());
                this.f7687c.e().b(this);
            }
        }
    }

    public static boolean a(Uri uri, Context context, com.applovin.impl.sdk.j jVar) {
        return a(uri, (com.applovin.impl.sdk.ad.b) null, context, jVar);
    }

    public static boolean b(Uri uri) {
        return uri != null && "applovin".equalsIgnoreCase(uri.getScheme()) && AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN.equalsIgnoreCase(uri.getHost()) && "/adservice/deeplink".equals(uri.getPath());
    }

    public static boolean a(Uri uri, com.applovin.impl.sdk.ad.b bVar, Context context, com.applovin.impl.sdk.j jVar) {
        return a(uri, null, bVar, context, jVar);
    }

    public static void b(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        String strEmptyIfNull = StringUtils.emptyIfNull(uri.getQueryParameter("error"));
        String strEmptyIfNull2 = StringUtils.emptyIfNull(uri.getQueryParameter("exception"));
        String strEmptyIfNull3 = StringUtils.emptyIfNull(uri.getQueryParameter("details"));
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap(TransactionInfo.JsonKeys.SOURCE, strEmptyIfNull);
        CollectionUtils.putStringIfValid("top_main_method", strEmptyIfNull2, mapHashMap);
        CollectionUtils.putStringIfValid("details", strEmptyIfNull3, mapHashMap);
        if (bVar != null) {
            mapHashMap.putAll(a2.b(bVar));
            mapHashMap.putAll(a2.a(bVar));
        }
        jVar.A().d(y1.f7812v0, mapHashMap);
    }

    public static boolean a(Uri uri, String str, com.applovin.impl.sdk.ad.b bVar, Context context, com.applovin.impl.sdk.j jVar) {
        String strDefaultIfEmpty = null;
        boolean z10 = false;
        if (uri == null) {
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.external_redirect_failure"), null);
            return false;
        }
        try {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().d("UriUtils", "Opening URI: " + uri);
            }
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            strDefaultIfEmpty = StringUtils.defaultIfEmpty(str, a(intent, uri, bVar, context));
            intent.setPackage(strDefaultIfEmpty);
            jVar.f0().pauseForClick();
            context.startActivity(intent);
            z10 = true;
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("UriUtils", "Unable to open \"" + uri + "\".", th);
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("url", uri.toString());
            mapHashMap.put("name", strDefaultIfEmpty);
            if (bVar != null) {
                mapHashMap.putAll(a2.b(bVar));
                mapHashMap.putAll(a2.a(bVar));
            }
            if ("play.google.com".equals(uri.getHost())) {
                CollectionUtils.putStringIfValid("details", (String) jVar.y().K().get("ps_version"), mapHashMap);
            }
            jVar.A().a("UriUtils", "openUri", th, mapHashMap);
        }
        if (!z10) {
            jVar.f0().resumeForClick();
        }
        AppLovinBroadcastManager.sendBroadcast(new Intent(z10 ? "com.applovin.external_redirect_success" : "com.applovin.external_redirect_failure"), CollectionUtils.map("url", uri));
        return z10;
    }

    private static String a(Intent intent, Uri uri, com.applovin.impl.sdk.ad.b bVar, Context context) {
        if (!"market".equals(intent.getScheme()) && !"play.google.com".equals(uri.getHost())) {
            if ("https".equals(intent.getScheme()) && bVar != null) {
                if (bVar.c1()) {
                    String strF = com.applovin.impl.sdk.k.F();
                    if (a(strF, context)) {
                        return strF;
                    }
                }
                for (String str : bVar.S()) {
                    if (a(str, context)) {
                        return str;
                    }
                }
            }
            return null;
        }
        if (Boolean.FALSE.equals(a(context))) {
            return "com.android.vending";
        }
        return null;
    }

    private static boolean a(String str, Context context) {
        return (TextUtils.isEmpty(str) || context.getPackageManager().getLaunchIntentForPackage(str) == null) ? false : true;
    }

    public static void a(Uri uri, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        com.applovin.impl.adview.b bVarF = aVar.f();
        String queryParameter = uri.getQueryParameter(com.ironsource.nb.f14119q);
        if (TextUtils.isEmpty(queryParameter)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("UriUtils", "Could not find url to load from query in original uri");
            }
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.external_redirect_failure"), null);
            return;
        }
        o4 o4VarI0 = jVar.i0();
        n4 n4Var = n4.L;
        String str = (String) o4VarI0.a(n4Var, null);
        if (uri.getQueryParameterNames().contains(Browser.TYPE)) {
            String queryParameter2 = uri.getQueryParameter(Browser.TYPE);
            String str2 = TextUtils.isEmpty(queryParameter2) ? null : queryParameter2;
            if (Boolean.parseBoolean(uri.getQueryParameter("retain_browser"))) {
                jVar.i0().b(n4Var, str2);
            }
            str = str2;
        }
        String queryParameter3 = uri.getQueryParameter("load_type");
        if (com.ironsource.u3.f15552e.equalsIgnoreCase(queryParameter3)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("UriUtils", "Loading new page externally: " + queryParameter);
            }
            a(queryParameter, str, aVar, jVar);
            return;
        }
        if ("internal".equalsIgnoreCase(queryParameter3)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("UriUtils", "Loading new page in WebView: " + queryParameter);
            }
            bVarF.loadUrl(queryParameter);
            String queryParameter4 = uri.getQueryParameter("bg_color");
            if (StringUtils.isValidString(queryParameter4)) {
                bVarF.setBackgroundColor(Color.parseColor(queryParameter4));
                return;
            }
            return;
        }
        if (SentryStackFrame.JsonKeys.IN_APP.equalsIgnoreCase(queryParameter3)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("UriUtils", "Loading new page in slide-up webview: " + queryParameter);
            }
            jVar.e().a(new a(queryParameter, aVar, jVar));
            Intent intent = new Intent(com.applovin.impl.sdk.j.n(), (Class<?>) AppLovinWebViewActivity.class);
            intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, jVar.b0());
            intent.setFlags(268435456);
            com.applovin.impl.sdk.j.n().startActivity(intent);
            return;
        }
        if ("in_app_v2".equalsIgnoreCase(queryParameter3)) {
            aVar.a(aVar.g(), aVar.i(), (Uri) null, bVarF.getAndClearLastClickEvent(), (Bundle) null);
            if (aVar.h() != null) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("UriUtils", "Loading new page in Custom Tabs: " + queryParameter);
                }
                jVar.x().a(queryParameter, aVar, jVar.n0());
                return;
            }
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("UriUtils", "Custom Tabs not supported, loading new page externally: " + queryParameter);
            }
            a(queryParameter, str, aVar, jVar);
            return;
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().b("UriUtils", "Could not find load type in original uri");
        }
    }

    public static void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        String queryParameter = uri.getQueryParameter(com.ironsource.nb.f14119q);
        if (URLUtil.isValidUrl(queryParameter)) {
            jVar.X().e(com.applovin.impl.sdk.network.d.b().d(StringUtils.appendQueryParameter(queryParameter, "clcode", bVar.getClCode())).a(false).b(Boolean.parseBoolean(uri.getQueryParameter("fire_from_webview"))).a());
            return;
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().b("UriUtils", "Could not find postback url to fire from query in original uri: " + uri);
        }
    }

    public static Bundle a(Uri uri) {
        Bundle bundle = new Bundle();
        for (String str : uri.getQueryParameterNames()) {
            bundle.putString(str, uri.getQueryParameter(str));
        }
        return bundle;
    }

    private static void a(String str, String str2, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        a(Uri.parse(str), str2, aVar.g(), aVar.f().getContext(), jVar);
        l2.b(aVar.e(), aVar.g(), aVar.i());
    }

    public static Boolean a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            boolean z10 = true;
            packageManager.getPackageInfo("com.android.vending", 1);
            int applicationEnabledSetting = packageManager.getApplicationEnabledSetting("com.android.vending");
            if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        } catch (PackageManager.NameNotFoundException unused) {
            return Boolean.TRUE;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
