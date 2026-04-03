package com.applovin.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class h implements AppLovinCommunicatorSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f5293b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashMap f5294c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f5295d = Collections.synchronizedSet(new HashSet());

    class a extends LinkedHashMap {
        a() {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > 16;
        }
    }

    public interface b {
        void onCreativeIdGenerated(String str, String str2);
    }

    public h(com.applovin.impl.sdk.j jVar) {
        this.f5292a = jVar;
        if (c()) {
            AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.n()).subscribe(this, "safedk_ad_info");
        }
    }

    public void b(b bVar) {
        this.f5295d.remove(bVar);
    }

    public void c(String str) {
        this.f5292a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5292a.I().a("AdReviewManager", "Removing ad info for serve id: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f5293b) {
            this.f5294c.remove(str);
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return h.class.getSimpleName();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle("public");
            if (bundle == null) {
                this.f5292a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5292a.I().k("AdReviewManager", "Received SafeDK ad info without public data");
                    return;
                }
                return;
            }
            Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle("private");
            if (bundle2 == null) {
                this.f5292a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5292a.I().k("AdReviewManager", "Received SafeDK ad info without private data");
                    return;
                }
                return;
            }
            if (MaxAdFormat.formatFromString(bundle2.getString("ad_format")) == null) {
                this.f5292a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5292a.I().k("AdReviewManager", "Received SafeDK ad info without ad format");
                    return;
                }
                return;
            }
            final String string = bundle2.getString("id");
            if (TextUtils.isEmpty(string)) {
                this.f5292a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5292a.I().k("AdReviewManager", "Received SafeDK ad info without serve id");
                    return;
                }
                return;
            }
            synchronized (this.f5293b) {
                this.f5292a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5292a.I().a("AdReviewManager", "Storing current SafeDK ad info for serve id: " + string + ", public data: " + bundle);
                }
                this.f5294c.put(string, bundle);
            }
            final String string2 = bundle.getString("ad_review_creative_id");
            this.f5292a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5292a.I().a("AdReviewManager", "Received SafeDK ad info with Ad Review creative id: " + string2);
            }
            if (!StringUtils.isValidString(string2) || this.f5295d.isEmpty()) {
                return;
            }
            HashSet<b> hashSet = new HashSet(this.f5295d);
            this.f5292a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5292a.I().a("AdReviewManager", "Notifying listeners: " + this.f5295d);
            }
            for (final b bVar : hashSet) {
                this.f5292a.j0().a((w4) new f6(this.f5292a, "creativeIdGenerated", new Runnable() { // from class: com.applovin.impl.q9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6710a.a(bVar, string, string2);
                    }
                }), r5.b.OTHER);
            }
        }
    }

    public static String b() {
        return b(MobileAdsBridge.versionMethodName);
    }

    public Bundle a(String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f5293b) {
            bundle = (Bundle) this.f5294c.get(str);
        }
        this.f5292a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5292a.I().a("AdReviewManager", "Retrieved ad info (" + bundle + ") for serve id: " + str);
        }
        return bundle;
    }

    private static String b(String str) {
        Class<?> cls;
        try {
            try {
                cls = Class.forName("com.applovin.quality.AppLovinQualityService");
            } catch (Throwable unused) {
                cls = Class.forName("com.safedk.android.SafeDK");
            }
            return (String) cls.getMethod(str, null).invoke(null, null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static boolean c() {
        return StringUtils.isValidString(b());
    }

    public void a(b bVar) {
        this.f5295d.add(bVar);
    }

    public static String a() {
        return b("getSdkKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar, String str, String str2) {
        this.f5292a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5292a.I().a("AdReviewManager", "Notifying Ad Review creative id generated for listener: " + bVar);
        }
        bVar.onCreativeIdGenerated(str, str2);
    }
}
