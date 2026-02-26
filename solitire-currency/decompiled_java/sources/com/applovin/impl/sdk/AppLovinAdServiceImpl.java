package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.g2;
import com.applovin.impl.i;
import com.applovin.impl.l2;
import com.applovin.impl.l4;
import com.applovin.impl.m1;
import com.applovin.impl.m5;
import com.applovin.impl.n4;
import com.applovin.impl.o5;
import com.applovin.impl.p1;
import com.applovin.impl.q7;
import com.applovin.impl.r5;
import com.applovin.impl.s5;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.d;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.w4;
import com.applovin.impl.w6;
import com.applovin.impl.y1;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinAdServiceImpl implements AppLovinAdService, a.InterfaceC0171a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f6844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f6845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f6846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f6847d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f6848e = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference f6849f = new AtomicReference();

    class a implements ArrayService.DirectDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p1 f6850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.ad.b f6851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Uri f6852c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f6853d;

        a(p1 p1Var, com.applovin.impl.sdk.ad.b bVar, Uri uri, Context context) {
            this.f6850a = p1Var;
            this.f6851b = bVar;
            this.f6852c = uri;
            this.f6853d = context;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onEvent(String str, Bundle bundle) {
            if (ArrayService.DIRECT_DOWNLOAD_EVENT_APP_DETAILS_SHOWN.equals(str)) {
                AppLovinAdServiceImpl.this.f6844a.f0().pauseForClick();
            } else if (ArrayService.DIRECT_DOWNLOAD_EVENT_APP_DETAILS_DISMISSED.equals(str)) {
                AppLovinAdServiceImpl.this.f6844a.f0().resumeForClick();
            }
            if (this.f6850a != null) {
                this.f6850a.c(AppLovinAdServiceImpl.this.f6844a.o().getJavaScript(str, bundle));
            }
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            n unused = AppLovinAdServiceImpl.this.f6845b;
            if (n.a()) {
                AppLovinAdServiceImpl.this.f6845b.a("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
            }
            AppLovinAdServiceImpl.this.a(this.f6851b, this.f6852c, this.f6850a, this.f6853d);
        }
    }

    class b implements ArrayService.DirectDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.adview.a f6855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.ad.b f6856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppLovinAdView f6857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Uri f6858d;

        b(com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, Uri uri) {
            this.f6855a = aVar;
            this.f6856b = bVar;
            this.f6857c = appLovinAdView;
            this.f6858d = uri;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onEvent(String str, Bundle bundle) {
            com.applovin.impl.adview.b bVarF;
            if (ArrayService.DIRECT_DOWNLOAD_EVENT_APP_DETAILS_SHOWN.equals(str)) {
                AppLovinAdServiceImpl.this.f6844a.f0().pauseForClick();
                com.applovin.impl.adview.a aVar = this.f6855a;
                if (aVar != null) {
                    aVar.u();
                    l2.c(this.f6855a.e(), this.f6856b, this.f6857c);
                }
            } else if (ArrayService.DIRECT_DOWNLOAD_EVENT_APP_DETAILS_DISMISSED.equals(str) && this.f6855a != null) {
                AppLovinAdServiceImpl.this.f6844a.f0().resumeForClick();
                l2.a(this.f6855a.e(), this.f6856b, this.f6857c);
            }
            com.applovin.impl.adview.a aVar2 = this.f6855a;
            if (aVar2 == null || (bVarF = aVar2.f()) == null) {
                return;
            }
            bVarF.a(AppLovinAdServiceImpl.this.f6844a.o().getJavaScript(str, bundle));
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            n unused = AppLovinAdServiceImpl.this.f6845b;
            if (n.a()) {
                AppLovinAdServiceImpl.this.f6845b.a("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
            }
            AppLovinAdServiceImpl.this.a(this.f6856b, this.f6857c, this.f6855a, this.f6858d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c implements g2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f6860a;

        /* synthetic */ c(AppLovinAdServiceImpl appLovinAdServiceImpl, d dVar, a aVar) {
            this(dVar);
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.f6844a.i().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.f6844a.f().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new com.applovin.impl.sdk.ad.c(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.f6844a);
            }
            Collection collectionEmptySet = Collections.emptySet();
            synchronized (this.f6860a.f6862a) {
                if (!this.f6860a.f6864c) {
                    collectionEmptySet = new HashSet(this.f6860a.f6865d);
                    this.f6860a.f6865d.clear();
                }
                d dVar = this.f6860a;
                dVar.f6863b = false;
                dVar.f6864c = false;
            }
            Iterator it = collectionEmptySet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.a(appLovinAd, (AppLovinAdLoadListener) it.next());
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i10) {
            failedToReceiveAdV2(new AppLovinError(i10, ""));
        }

        @Override // com.applovin.impl.g2
        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            Collection collectionEmptySet = Collections.emptySet();
            synchronized (this.f6860a.f6862a) {
                if (!this.f6860a.f6864c) {
                    collectionEmptySet = new HashSet(this.f6860a.f6865d);
                    this.f6860a.f6865d.clear();
                }
                d dVar = this.f6860a;
                dVar.f6863b = false;
                dVar.f6864c = false;
            }
            Iterator it = collectionEmptySet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.b(appLovinError, (AppLovinAdLoadListener) it.next());
            }
        }

        private c(d dVar) {
            this.f6860a = dVar;
        }
    }

    AppLovinAdServiceImpl(j jVar) {
        this.f6844a = jVar;
        this.f6845b = jVar.I();
        HashMap map = new HashMap(6);
        this.f6846c = map;
        a aVar = null;
        map.put(com.applovin.impl.s.c(), new d(aVar));
        map.put(com.applovin.impl.s.k(), new d(aVar));
        map.put(com.applovin.impl.s.j(), new d(aVar));
        map.put(com.applovin.impl.s.m(), new d(aVar));
        map.put(com.applovin.impl.s.b(), new d(aVar));
        map.put(com.applovin.impl.s.h(), new d(aVar));
    }

    public void addCustomQueryParams(Map<String, String> map) {
        this.f6848e.putAll(map);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void collectBidToken(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "collectBidToken(listener=" + appLovinBidTokenCollectionListener + ")");
        }
        this.f6844a.y().a(appLovinBidTokenCollectionListener);
    }

    public AppLovinAd dequeueAd(com.applovin.impl.s sVar) {
        AppLovinAdImpl appLovinAdImplA = this.f6844a.i().a(sVar);
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Dequeued ad: " + appLovinAdImplA + " for zone: " + sVar + "...");
        }
        return appLovinAdImplA;
    }

    public JSONObject getAndResetCustomPostBody() {
        return (JSONObject) this.f6849f.getAndSet(null);
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        Map<String, String> map;
        synchronized (this.f6848e) {
            map = CollectionUtils.map(this.f6848e);
            this.f6848e.clear();
        }
        return map;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public String getBidToken() {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "getBidToken()");
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String strE = this.f6844a.y().E();
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        if (StringUtils.isValidString(strE) && n.a()) {
            this.f6845b.a("AppLovinAdService", "Successfully retrieved bid token");
        }
        return strE;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        a(com.applovin.impl.s.a(appLovinAdSize, AppLovinAdType.REGULAR), appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForAdToken(String str, final AppLovinAdLoadListener appLovinAdLoadListener) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            n.h("AppLovinAdService", "Empty ad token");
            c(new AppLovinError(-8, "Empty ad token"), appLovinAdLoadListener);
            return;
        }
        com.applovin.impl.i iVar = new com.applovin.impl.i(strTrim, this.f6844a);
        if (iVar.c() == i.a.REGULAR) {
            if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Loading next ad for token: " + iVar);
            }
            a(new o5(iVar, appLovinAdLoadListener, this.f6844a));
            return;
        }
        if (iVar.c() != i.a.AD_RESPONSE_JSON) {
            AppLovinError appLovinError = new AppLovinError(-8, "Invalid token type");
            n.h("AppLovinAdService", "Invalid token type");
            c(appLovinError, appLovinAdLoadListener);
            return;
        }
        final JSONObject jSONObjectA = iVar.a();
        if (jSONObjectA == null) {
            String str2 = "Unable to retrieve ad response JSON from token: " + iVar.b();
            AppLovinError appLovinError2 = new AppLovinError(-8, str2);
            n.h("AppLovinAdService", str2);
            c(appLovinError2, appLovinAdLoadListener);
            return;
        }
        com.applovin.impl.n0.c(jSONObjectA, this.f6844a);
        com.applovin.impl.n0.b(jSONObjectA, this.f6844a);
        com.applovin.impl.n0.a(jSONObjectA, this.f6844a);
        com.applovin.impl.x.b(this.f6844a);
        if (JsonUtils.getJSONArray(jSONObjectA, "ads", new JSONArray()).length() <= 0) {
            if (n.a()) {
                this.f6845b.b("AppLovinAdService", "No ad returned from the server for token: " + iVar);
            }
            c(AppLovinError.NO_FILL, appLovinAdLoadListener);
            return;
        }
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Rendering ad for token: " + iVar);
        }
        final com.applovin.impl.s sVarA = z6.a(jSONObjectA, this.f6844a);
        MaxAdFormat maxAdFormatD = sVarA.d();
        if (((Boolean) this.f6844a.a(l4.Q0)).booleanValue() && maxAdFormatD != null && maxAdFormatD.isFullscreenAd()) {
            this.f6844a.h().a(sVarA, new d.a() { // from class: com.applovin.impl.sdk.x
                @Override // com.applovin.impl.sdk.d.a
                public final void a(com.applovin.impl.sdk.ad.b bVar) {
                    this.f7374a.a(appLovinAdLoadListener, jSONObjectA, sVarA, bVar);
                }
            });
        } else {
            a(new s5(jSONObjectA, sVarA, appLovinAdLoadListener, this.f6844a));
        }
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No zone id specified");
        }
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Loading next ad of zone {" + str + "}");
        }
        a(com.applovin.impl.s.a(str), appLovinAdLoadListener);
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        }
        a(com.applovin.impl.s.b(str), appLovinAdLoadListener);
    }

    public void maybeFireAppKilledWhilePlayingAdPostback() {
        Long l10;
        if (((Boolean) this.f6844a.a(l4.Q1)).booleanValue() && (l10 = (Long) this.f6844a.b(n4.H)) != null && System.currentTimeMillis() - l10.longValue() <= ((Long) this.f6844a.a(l4.U1)).longValue()) {
            if (((Boolean) this.f6844a.a(l4.T1)).booleanValue() || b()) {
                a();
            }
        }
    }

    public void maybeSubmitPersistentPostbacks(List<com.applovin.impl.e> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.applovin.impl.e> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0171a
    public void onAdExpired(m1 m1Var) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) m1Var;
        com.applovin.impl.s adZone = appLovinAdImpl.getAdZone();
        if (n.a()) {
            this.f6845b.k("AppLovinAdService", "Ad expired for zone: " + adZone);
        }
        this.f6844a.i().b(appLovinAdImpl);
        if (this.f6844a.z0() || !((Boolean) this.f6844a.a(l4.W0)).booleanValue()) {
            return;
        }
        d dVarA = a(adZone);
        synchronized (dVarA.f6862a) {
            if (!dVarA.f6863b) {
                this.f6844a.I();
                if (n.a()) {
                    this.f6844a.I().a("AppLovinAdService", "Reloading ad after expiration for zone {" + adZone + "}...");
                }
                dVarA.f6863b = true;
                dVarA.f6864c = true;
                a(adZone, new c(this, dVarA, null));
            } else if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Cancelled expired ad reload. Already waiting on an ad load...");
            }
        }
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.f6849f.set(jSONObject);
    }

    @NonNull
    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.f6846c + '}';
    }

    public void trackAndLaunchClick(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Uri uri, @Nullable MotionEvent motionEvent, @Nullable Bundle bundle) {
        if (bVar == null) {
            if (n.a()) {
                this.f6845b.b("AppLovinAdService", "Unable to track ad view click. No ad specified");
                return;
            }
            return;
        }
        if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Tracking click on an ad...");
            }
            boolean z10 = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(bVar.a(motionEvent, z10));
            if (this.f6844a.Z() != null) {
                this.f6844a.Z().b(bVar.d(motionEvent, false, z10), motionEvent);
            }
        } else if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Skipping tracking for click on an ad...");
        }
        if (appLovinAdView == null || uri == null) {
            if (n.a()) {
                this.f6845b.b("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
            }
        } else if (bVar.isDirectDownloadEnabled()) {
            this.f6844a.o().startDirectInstallOrDownloadProcess(bVar, bundle, new b(aVar, bVar, appLovinAdView, uri));
        } else {
            a(bVar, appLovinAdView, aVar, uri);
        }
    }

    public void trackAndLaunchVideoClick(com.applovin.impl.sdk.ad.b bVar, Uri uri, MotionEvent motionEvent, @Nullable Bundle bundle, p1 p1Var, Context context) {
        if (bVar == null) {
            if (n.a()) {
                this.f6845b.b("AppLovinAdService", "Unable to track video click. No ad specified");
                return;
            }
            return;
        }
        if (bundle == null || !Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Tracking VIDEO click on an ad...");
            }
            boolean z10 = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(bVar.b(motionEvent, z10));
            if (this.f6844a.Z() != null) {
                this.f6844a.Z().b(bVar.d(motionEvent, true, z10), motionEvent);
            }
        } else if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Skipping tracking for VIDEO click on an ad...");
        }
        if (bVar.isDirectDownloadEnabled()) {
            this.f6844a.o().startDirectInstallOrDownloadProcess(bVar, bundle, new a(p1Var, bVar, uri, context));
        } else {
            a(bVar, uri, p1Var, context);
        }
    }

    public void trackCustomTabsNavigationAborted(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking Custom Tabs navigation aborted on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.t());
    }

    public void trackCustomTabsNavigationFailed(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking Custom Tabs navigation failed on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.u());
    }

    public void trackCustomTabsNavigationFinished(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking Custom Tabs navigation finished on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.v());
    }

    public void trackCustomTabsNavigationStarted(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking Custom Tabs navigation started on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.w());
    }

    public void trackCustomTabsTabHidden(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking Custom Tabs tab hidden on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.y());
    }

    public void trackCustomTabsTabShown(com.applovin.impl.sdk.ad.b bVar) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking Custom Tabs tab shown on ad...");
        }
        maybeSubmitPersistentPostbacks(bVar.z());
    }

    public void trackFullScreenAdClosed(com.applovin.impl.sdk.ad.b bVar, long j10, List<Long> list, long j11, boolean z10, int i10) {
        if (bVar == null) {
            if (n.a()) {
                this.f6845b.b("AppLovinAdService", "Unable to track ad closed. No ad specified.");
                return;
            }
            return;
        }
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking ad closed...");
        }
        List<com.applovin.impl.e> listD = bVar.d();
        if (listD == null || listD.isEmpty()) {
            if (n.a()) {
                this.f6845b.k("AppLovinAdService", "Unable to track ad closed for AD #" + bVar.getAdIdNumber() + ". Missing ad close tracking URL." + bVar.getAdIdNumber());
                return;
            }
            return;
        }
        for (com.applovin.impl.e eVar : listD) {
            String strA = a(eVar.c(), j10, j11, list, z10, i10);
            String strA2 = a(eVar.a(), j10, j11, list, z10, i10);
            if (StringUtils.isValidString(strA)) {
                a(new com.applovin.impl.e(strA, strA2));
            } else if (n.a()) {
                this.f6845b.b("AppLovinAdService", "Failed to parse url: " + eVar.c());
            }
        }
    }

    public void trackImpression(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            if (n.a()) {
                this.f6845b.b("AppLovinAdService", "Unable to track impression click. No ad specified");
            }
        } else {
            if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Tracking impression on ad...");
            }
            maybeSubmitPersistentPostbacks(bVar.F());
            if (this.f6844a.Z() != null) {
                this.f6844a.Z().b(bVar.getPrivacySandboxImpressionAttributionUrls());
            }
        }
    }

    public void trackVideoEnd(com.applovin.impl.sdk.ad.b bVar, long j10, int i10, boolean z10) {
        if (bVar == null) {
            if (n.a()) {
                this.f6845b.b("AppLovinAdService", "Unable to track video end. No ad specified");
                return;
            }
            return;
        }
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking video end on ad...");
        }
        List<com.applovin.impl.e> listK0 = bVar.k0();
        if (listK0 == null || listK0.isEmpty()) {
            if (n.a()) {
                this.f6845b.k("AppLovinAdService", "Unable to submit persistent postback for AD #" + bVar.getAdIdNumber() + ". Missing video end tracking URL.");
                return;
            }
            return;
        }
        String string = Long.toString(System.currentTimeMillis());
        for (com.applovin.impl.e eVar : listK0) {
            if (StringUtils.isValidString(eVar.c())) {
                String strA = a(eVar.c(), j10, i10, string, z10);
                String strA2 = a(eVar.a(), j10, i10, string, z10);
                if (strA != null) {
                    a(new com.applovin.impl.e(strA, strA2));
                } else if (n.a()) {
                    this.f6845b.b("AppLovinAdService", "Failed to parse url: " + eVar.c());
                }
            } else if (n.a()) {
                this.f6845b.k("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
            }
        }
    }

    private void c(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener instanceof g2) {
            ((g2) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        }
        a(com.applovin.impl.s.a(appLovinAdSize, AppLovinAdType.REGULAR, str), appLovinAdLoadListener);
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f6862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f6863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f6864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Collection f6865d;

        private d() {
            this.f6862a = new Object();
            this.f6865d = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.f6863b + ", isReloadingExpiredAd=" + this.f6864c + ", pendingAdListeners=" + this.f6865d + '}';
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinError appLovinError, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f7349a.a(appLovinError, appLovinAdLoadListener);
            }
        });
    }

    private Uri b(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable th) {
            this.f6844a.I();
            if (n.a()) {
                this.f6844a.I().k("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            }
            this.f6844a.A().a("AppLovinAdService", "buildDeepLinkPlusUrl", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final AppLovinAdLoadListener appLovinAdLoadListener, JSONObject jSONObject, com.applovin.impl.s sVar, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.t
                @Override // java.lang.Runnable
                public final void run() {
                    appLovinAdLoadListener.adReceived(bVar);
                }
            });
        } else {
            a(new s5(jSONObject, sVar, appLovinAdLoadListener, this.f6844a));
        }
    }

    private boolean b() {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        Context contextN = j.n();
        ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) ((ActivityManager) contextN.getSystemService("activity")).getHistoricalProcessExitReasons(contextN.getPackageName(), 0, 1).get(0);
        return applicationExitInfo.getReason() == 10 || applicationExitInfo.getReason() == 11;
    }

    private void a(com.applovin.impl.s sVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (sVar == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        if (appLovinAdLoadListener != null) {
            this.f6844a.I();
            if (n.a()) {
                this.f6844a.I().a("AppLovinAdService", "Loading next ad of zone {" + sVar + "}...");
            }
            d dVarA = a(sVar);
            synchronized (dVarA.f6862a) {
                dVarA.f6865d.add(appLovinAdLoadListener);
                if (!dVarA.f6863b) {
                    dVarA.f6863b = true;
                    a(sVar, new c(this, dVarA, null));
                } else if (n.a()) {
                    this.f6845b.a("AppLovinAdService", "Already waiting on an ad load...");
                }
            }
            return;
        }
        throw new IllegalArgumentException("No callback specified");
    }

    private void a(w4 w4Var) {
        if (!this.f6844a.u0()) {
            n.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f6844a.c();
        this.f6844a.j0().a(w4Var, r5.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f7371a.a(appLovinAdLoadListener, appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAdLoadListener appLovinAdLoadListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdLoadListener.adReceived(appLovinAd);
        } catch (Throwable th) {
            n.c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            this.f6844a.A().a("AppLovinAdService", "notifyAdLoadedCallback", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        try {
            c(appLovinError, appLovinAdLoadListener);
        } catch (Throwable th) {
            n.c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            StringBuilder sb = new StringBuilder();
            sb.append("notifyAdLoadFailedCallback");
            sb.append(appLovinAdLoadListener instanceof g2 ? "V2" : "");
            this.f6844a.A().a("AppLovinAdService", sb.toString(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, Uri uri, p1 p1Var, Context context) {
        if (a(uri.getScheme())) {
            a(uri, bVar, (com.applovin.impl.adview.a) null, p1Var);
        } else if (w6.b(uri)) {
            a(uri, bVar, (AppLovinAdView) null, (com.applovin.impl.adview.a) null, context, this.f6844a);
        } else {
            w6.a(uri, bVar, context, this.f6844a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Uri uri) {
        Context context;
        if (!((Boolean) this.f6844a.a(l4.f5771x)).booleanValue() || (context = q7.b(appLovinAdView, this.f6844a)) == null) {
            context = appLovinAdView.getContext();
        }
        Context context2 = context;
        if (a(uri.getScheme())) {
            a(uri, bVar, aVar, (p1) null);
        } else if (w6.b(uri)) {
            a(uri, bVar, appLovinAdView, aVar, context2, this.f6844a);
        } else {
            a(uri, bVar, appLovinAdView, aVar, context2);
        }
    }

    private String a(String str, long j10, int i10, String str2, boolean z10) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i10 < 0 || i10 > 100) {
                i10 = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j10)).appendQueryParameter("pv", Integer.toString(i10)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z10)).build().toString();
        } catch (Throwable th) {
            if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            }
            this.f6844a.A().a("AppLovinAdService", "buildVideoEndUrl", th);
            return null;
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context) {
        if (w6.a(uri, bVar, context, this.f6844a)) {
            l2.b(aVar.e(), bVar, appLovinAdView);
        }
        aVar.u();
    }

    private boolean a(String str) {
        String str2 = this.f6844a.g0().getExtraParameters().get("forwarding_click_scheme");
        return StringUtils.isValidString(str2) && StringUtils.isValidString(str) && str.equalsIgnoreCase(str2);
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.adview.a aVar, final p1 p1Var) {
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Forwarding click " + uri);
        }
        bVar.setMaxAdValue("forwarding_clicked_url", uri.toString());
        String str = this.f6844a.g0().getExtraParameters().get("close_ad_on_forwarding_click_scheme");
        if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
            if (p1Var != null) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7342a.a(p1Var);
                    }
                });
            } else {
                if (aVar == null || z6.a(bVar.getSize())) {
                    return;
                }
                if (n.a()) {
                    this.f6845b.a("AppLovinAdService", "Closing ad after forwarding click");
                }
                aVar.w();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(p1 p1Var) {
        if (p1Var != null) {
            if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Dismissing ad after forwarding click");
            }
            p1Var.c();
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context, j jVar) {
        if (uri != null && StringUtils.isValidString(uri.getQuery())) {
            Uri uriB = b(uri, "primaryUrl");
            List listA = a(uri, "primaryTrackingUrl");
            Uri uriB2 = b(uri, "fallbackUrl");
            List listA2 = a(uri, "fallbackTrackingUrl");
            if (uriB == null && uriB2 == null) {
                jVar.I();
                if (n.a()) {
                    jVar.I().b("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
                    return;
                }
                return;
            }
            if (!a(uriB, "primary", listA, bVar, appLovinAdView, aVar, context, jVar)) {
                a(uriB2, "backup", listA2, bVar, appLovinAdView, aVar, context, jVar);
            }
            if (aVar != null) {
                aVar.u();
                return;
            }
            return;
        }
        jVar.I();
        if (n.a()) {
            jVar.I().b("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
        }
    }

    private boolean a(Uri uri, String str, List list, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.a aVar, Context context, j jVar) {
        jVar.I();
        if (n.a()) {
            jVar.I().a("AppLovinAdService", "Opening " + str + " URL: " + uri);
        }
        boolean zA = w6.a(uri, bVar, context, jVar);
        if (zA) {
            jVar.I();
            if (n.a()) {
                jVar.I().a("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jVar.Y().dispatchPostbackAsync(((Uri) it.next()).toString(), null);
            }
            if (aVar != null) {
                l2.b(aVar.e(), bVar, appLovinAdView);
            }
        } else {
            jVar.I();
            if (n.a()) {
                jVar.I().b("AppLovinAdService", "URL failed to open");
            }
        }
        return zA;
    }

    private List a(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        Iterator<String> it = queryParameters.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Uri.parse(it.next()));
            } catch (Throwable th) {
                this.f6844a.I();
                if (n.a()) {
                    this.f6844a.I().k("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
                }
                this.f6844a.A().a("AppLovinAdService", "buildDeepLinkPlusUrlList", th);
            }
        }
        return arrayList;
    }

    private String a(String str, long j10, long j11, List list, boolean z10, int i10) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j10)).appendQueryParameter("vs_ms", Long.toString(j11));
        if (list != null && list.size() > 0) {
            builderAppendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (i10 != h.f7069h) {
            builderAppendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z10));
            builderAppendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(h.a(i10)));
        }
        return builderAppendQueryParameter.build().toString();
    }

    private void a() {
        Map<String, String> mapTryToStringMap;
        if (n.a()) {
            this.f6845b.a("AppLovinAdService", "Tracking app killed during ad from previous run.");
        }
        String str = (String) this.f6844a.b(n4.K);
        if (TextUtils.isEmpty(str)) {
            if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Couldn't get last ad data. Tracking event with empty data.");
            }
            mapTryToStringMap = null;
        } else {
            mapTryToStringMap = JsonUtils.tryToStringMap(JsonUtils.jsonObjectFromJsonString(str, new JSONObject()));
        }
        this.f6844a.A().d(y1.f7782g0, mapTryToStringMap);
        String str2 = (String) this.f6844a.b(n4.J);
        if (str2 != null) {
            JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(str2, null);
            String string = JsonUtils.getString(jSONObjectJsonObjectFromJsonString, "app_killed_postback_url", null);
            String string2 = JsonUtils.getString(jSONObjectJsonObjectFromJsonString, "app_killed_postback_backup_url", null);
            Long l10 = (Long) this.f6844a.b(n4.I);
            if (l10 != null) {
                string = StringUtils.appendQueryParameter(string, "imp_duration_ms", String.valueOf(l10));
                string2 = StringUtils.appendQueryParameter(string2, "imp_duration_ms", String.valueOf(l10));
            }
            a(new com.applovin.impl.e(string, string2));
            return;
        }
        if (n.a()) {
            this.f6845b.k("AppLovinAdService", "Unable to track app killed during ad from previous run. Missing app killed tracking URLs.");
        }
    }

    private void a(com.applovin.impl.e eVar) {
        if (StringUtils.isValidString(eVar.c())) {
            this.f6844a.X().e(com.applovin.impl.sdk.network.d.b().d(eVar.c()).a(StringUtils.isValidString(eVar.a()) ? eVar.a() : null).a(eVar.b()).a(false).b(eVar.d()).a());
        } else if (n.a()) {
            this.f6845b.k("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
        }
    }

    private void a(final com.applovin.impl.s sVar, final c cVar) {
        AppLovinAdImpl appLovinAdImplE = this.f6844a.i().e(sVar);
        if (appLovinAdImplE != null && !appLovinAdImplE.isExpired()) {
            if (n.a()) {
                this.f6845b.a("AppLovinAdService", "Using pre-loaded ad: " + appLovinAdImplE + " for " + sVar);
            }
            cVar.adReceived(appLovinAdImplE);
            return;
        }
        MaxAdFormat maxAdFormatD = sVar.d();
        if (((Boolean) this.f6844a.a(l4.Q0)).booleanValue() && maxAdFormatD != null && maxAdFormatD.isFullscreenAd()) {
            this.f6844a.h().a(sVar, new d.a() { // from class: com.applovin.impl.sdk.v
                @Override // com.applovin.impl.sdk.d.a
                public final void a(com.applovin.impl.sdk.ad.b bVar) {
                    this.f7368a.a(cVar, sVar, bVar);
                }
            });
        } else {
            a(new m5(sVar, cVar, this.f6844a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final c cVar, com.applovin.impl.s sVar, final com.applovin.impl.sdk.ad.b bVar) {
        if (bVar != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.s
                @Override // java.lang.Runnable
                public final void run() {
                    cVar.adReceived(bVar);
                }
            });
        } else {
            a(new m5(sVar, cVar, this.f6844a));
        }
    }

    private d a(com.applovin.impl.s sVar) {
        d dVar;
        synchronized (this.f6847d) {
            dVar = (d) this.f6846c.get(sVar);
            if (dVar == null) {
                dVar = new d(null);
                this.f6846c.put(sVar, dVar);
            }
        }
        return dVar;
    }
}
