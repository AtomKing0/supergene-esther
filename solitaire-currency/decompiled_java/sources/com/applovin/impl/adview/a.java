package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.browser.customtabs.CustomTabsSession;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.a8;
import com.applovin.impl.adview.k;
import com.applovin.impl.f2;
import com.applovin.impl.f6;
import com.applovin.impl.g1;
import com.applovin.impl.h4;
import com.applovin.impl.l2;
import com.applovin.impl.l4;
import com.applovin.impl.n2;
import com.applovin.impl.n4;
import com.applovin.impl.q7;
import com.applovin.impl.r5;
import com.applovin.impl.s3;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u3;
import com.applovin.impl.v1;
import com.applovin.impl.x1;
import com.applovin.impl.y1;
import com.applovin.impl.z6;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.unity3d.services.UnityAdsConstants;
import io.sentry.protocol.TransactionInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements AppLovinCommunicatorSubscriber {
    private volatile AppLovinAdLoadListener A;
    private volatile AppLovinAdDisplayListener B;
    private volatile AppLovinAdViewEventListener C;
    private volatile AppLovinAdClickListener D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewGroup f4756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.applovin.impl.sdk.j f4757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAdServiceImpl f4758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.applovin.impl.sdk.n f4759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AppLovinCommunicator f4760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f4761g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AppLovinAdSize f4763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CustomTabsSession f4765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.applovin.impl.adview.c f4766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private e f4767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.applovin.impl.adview.b f4768n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private WebView f4769o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k f4770p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Runnable f4771q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Runnable f4772r;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f4762h = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile com.applovin.impl.sdk.ad.b f4773s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile AppLovinAd f4774t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private f f4775u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private f f4776v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicReference f4777w = new AtomicReference();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicBoolean f4778x = new AtomicBoolean();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile boolean f4779y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile boolean f4780z = false;

    public interface b {
        void a(a aVar);
    }

    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f4768n != null) {
                a.this.f4768n.setVisibility(8);
            }
        }
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: com.applovin.impl.adview.a$d$a, reason: collision with other inner class name */
        class C0158a implements k.a {
            C0158a() {
            }

            @Override // com.applovin.impl.adview.k.a
            public void a() {
                a.this.f4768n.addView(a.this.f4770p, new ViewGroup.LayoutParams(-1, -1));
            }

            @Override // com.applovin.impl.adview.k.a
            public void onFailure() {
                com.applovin.impl.sdk.n unused = a.this.f4759e;
                if (com.applovin.impl.sdk.n.a()) {
                    a.this.f4759e.b("AppLovinAdView", "Watermark failed to render.");
                }
            }
        }

        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f4773s != null) {
                if (a.this.f4768n == null) {
                    com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to render advertisement for ad #" + a.this.f4773s.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
                    l2.a(a.this.C, a.this.f4773s, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
                    return;
                }
                a.this.t();
                com.applovin.impl.sdk.n unused = a.this.f4759e;
                if (com.applovin.impl.sdk.n.a()) {
                    a.this.f4759e.a("AppLovinAdView", "Rendering advertisement ad for #" + a.this.f4773s.getAdIdNumber() + "...");
                }
                a.b(a.this.f4768n, a.this.f4773s.getSize(), a.this.f4773s.v0());
                if (a.this.f4770p != null) {
                    q7.c(a.this.f4770p);
                    a.this.f4770p = null;
                }
                x1 x1Var = new x1(a.this.f4762h, a.this.f4757c);
                if (x1Var.c()) {
                    a.this.f4770p = new k(x1Var, a.this.f4755a);
                    a.this.f4770p.a(new C0158a());
                }
                a.this.f4768n.setAdHtmlLoaded(false);
                a.this.f4768n.a(a.this.f4773s);
                if (a.this.f4773s.getSize() == AppLovinAdSize.INTERSTITIAL || a.this.f4780z) {
                    return;
                }
                a.this.f4773s.setHasShown(true);
            }
        }
    }

    static class e implements AppLovinAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f4784a;

        e(a aVar, com.applovin.impl.sdk.j jVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("No view specified");
            }
            if (jVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f4784a = aVar;
        }

        private a a() {
            return this.f4784a;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            a aVarA = a();
            if (aVarA != null) {
                aVarA.b(appLovinAd);
            } else {
                com.applovin.impl.sdk.n.h("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i10) {
            a aVarA = a();
            if (aVarA != null) {
                aVarA.b(i10);
            }
        }
    }

    private void B() {
        if (this.f4759e != null && com.applovin.impl.sdk.n.a() && com.applovin.impl.sdk.n.a()) {
            this.f4759e.a("AppLovinAdView", "Destroying...");
        }
        a8.b(this.f4768n);
        this.f4768n = null;
        a8.b(this.f4769o);
        this.f4769o = null;
        this.f4765k = null;
        this.A = null;
        this.B = null;
        this.D = null;
        this.C = null;
        this.f4780z = true;
    }

    private void v() {
        if (this.f4773s.T0()) {
            int iA = this.f4757c.p().a();
            if (com.applovin.impl.sdk.h.a(iA)) {
                this.f4768n.a("javascript:al_muteSwitchOn();");
            } else if (iA == 2) {
                this.f4768n.a("javascript:al_muteSwitchOff();");
            }
        }
    }

    public void A() {
        if (!this.f4779y || this.f4780z) {
            return;
        }
        this.f4780z = true;
    }

    public void C() {
        if (this.f4779y) {
            AppLovinAd appLovinAd = (AppLovinAd) this.f4777w.getAndSet(null);
            if (appLovinAd != null) {
                c(appLovinAd);
            }
            this.f4780z = false;
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return a.class.getSimpleName();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            a(new Runnable() { // from class: com.applovin.impl.adview.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4872a.r();
                }
            });
        }
    }

    public void u() {
        if ((this.f4755a instanceof g1) && this.f4773s != null && this.f4773s.P() == b.EnumC0172b.DISMISS) {
            ((g1) this.f4755a).dismiss();
        }
    }

    public void w() {
        if (this.f4775u != null || this.f4776v != null) {
            a();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f4759e.a("AppLovinAdView", "Ad: " + this.f4773s + " closed.");
        }
        a(this.f4772r);
        l2.b(this.B, this.f4773s);
        this.f4773s = null;
    }

    public void x() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f4759e.a("AppLovinAdView", "AdView fully watched...");
        }
        b bVar = this.f4761g;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void y() {
        if (this.f4773s != null && this.f4773s.u0()) {
            com.applovin.impl.g.a(this.f4768n, this.f4757c);
        } else if (com.applovin.impl.q.a(this.f4768n)) {
            this.f4757c.E().c(v1.f7568r);
        }
    }

    public void z() {
        if (this.f4779y) {
            l2.b(this.B, this.f4773s);
            if (this.f4773s != null && this.f4773s.isOpenMeasurementEnabled() && z6.a(this.f4773s.getSize())) {
                this.f4773s.getAdEventTracker().f();
            }
            if (this.f4768n == null || this.f4775u == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4759e.a("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
                }
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4759e.a("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
                }
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, AppLovinAdSize appLovinAdSize, boolean z10) {
        if (view == null) {
            return;
        }
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        String label = appLovinAdSize.getLabel();
        AppLovinAdSize appLovinAdSize2 = AppLovinAdSize.INTERSTITIAL;
        int iApplyDimension = -1;
        int iApplyDimension2 = (label.equals(appLovinAdSize2.getLabel()) || z10) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getWidth(), displayMetrics);
        if (!appLovinAdSize.getLabel().equals(appLovinAdSize2.getLabel()) && !z10) {
            iApplyDimension = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getHeight(), displayMetrics);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = iApplyDimension2;
        layoutParams.height = iApplyDimension;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
        }
        view.setLayoutParams(layoutParams);
    }

    private void c() {
        a(new Runnable() { // from class: com.applovin.impl.adview.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f4857a.p();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.f4768n.loadDataWithBaseURL(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, "<html></html>", "text/html", null, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        com.applovin.impl.adview.b bVar;
        d();
        if (this.f4756b == null || (bVar = this.f4768n) == null || bVar.getParent() != null) {
            return;
        }
        this.f4756b.addView(this.f4768n);
        b(this.f4768n, this.f4773s.getSize(), this.f4773s.v0());
        if (this.f4773s.isOpenMeasurementEnabled()) {
            this.f4773s.getAdEventTracker().a((View) this.f4768n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (this.f4768n != null && this.f4775u != null) {
            a();
        }
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        if (this.f4775u != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f4759e.a("AppLovinAdView", "Detaching expanded ad: " + this.f4775u.b());
            }
            this.f4776v = this.f4775u;
            this.f4775u = null;
            a(this.f4763i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        com.applovin.impl.sdk.ad.a aVarB;
        f fVar = this.f4776v;
        if (fVar == null && this.f4775u == null) {
            return;
        }
        if (fVar != null) {
            aVarB = fVar.b();
            this.f4776v.dismiss();
            this.f4776v = null;
        } else {
            aVarB = this.f4775u.b();
            this.f4775u.dismiss();
            this.f4775u = null;
        }
        l2.a(this.C, aVarB, (AppLovinAdView) this.f4756b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        f().loadUrl("chrome://crash");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.applovin.impl.sdk.ad.b bVar = this.f4773s;
        n2 n2Var = new n2();
        n2Var.a().a(bVar).a(i());
        if (!z6.a(bVar.getSize())) {
            n2Var.a().a("Fullscreen Ad Properties").b(bVar);
        }
        n2Var.a(this.f4757c);
        n2Var.a();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4759e.a("AppLovinAdView", n2Var.toString());
        }
    }

    public com.applovin.impl.sdk.ad.b g() {
        return this.f4773s;
    }

    public CustomTabsSession h() {
        return this.f4765k;
    }

    public AppLovinAdView i() {
        return (AppLovinAdView) this.f4756b;
    }

    public com.applovin.impl.sdk.j j() {
        return this.f4757c;
    }

    public AppLovinAdSize k() {
        return this.f4763i;
    }

    public String l() {
        return this.f4764j;
    }

    public void s() {
        if (this.f4757c == null || this.f4767m == null || this.f4755a == null || !this.f4779y) {
            com.applovin.impl.sdk.n.i("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f4758d.loadNextAd(this.f4764j, this.f4763i, this.f4767m);
        }
    }

    private void d() {
        a(new Runnable() { // from class: com.applovin.impl.adview.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f4785a.q();
            }
        });
    }

    public void c(AppLovinAd appLovinAd) {
        a(appLovinAd, (String) null);
    }

    public AppLovinAdViewEventListener e() {
        return this.C;
    }

    public com.applovin.impl.adview.b f() {
        return this.f4768n;
    }

    public void c(WebView webView) {
        a(webView, (String) null);
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.A = appLovinAdLoadListener;
    }

    public void a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.B = appLovinAdDisplayListener;
    }

    public void a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.C = appLovinAdViewEventListener;
    }

    public void a(AppLovinAdClickListener appLovinAdClickListener) {
        this.D = appLovinAdClickListener;
    }

    private void a(AppLovinAdView appLovinAdView, com.applovin.impl.sdk.j jVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (appLovinAdSize != null) {
            this.f4757c = jVar;
            this.f4758d = jVar.k();
            this.f4759e = jVar.I();
            this.f4760f = AppLovinCommunicator.getInstance(context);
            this.f4763i = appLovinAdSize;
            this.f4764j = str;
            if (!(context instanceof AppLovinFullscreenActivity)) {
                context = context.getApplicationContext();
            }
            this.f4755a = context;
            this.f4756b = appLovinAdView;
            this.f4766l = new com.applovin.impl.adview.c(this, jVar);
            this.f4772r = new c();
            this.f4771q = new d();
            this.f4767m = new e(this, jVar);
            a(appLovinAdSize);
            return;
        }
        throw new IllegalArgumentException("No ad size specified");
    }

    public void b() {
        a(new Runnable() { // from class: com.applovin.impl.adview.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f4871a.o();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WebView webView) {
        this.f4773s.getAdEventTracker().c(webView);
        k kVar = this.f4770p;
        if (kVar != null && kVar.a()) {
            s3 adEventTracker = this.f4773s.getAdEventTracker();
            k kVar2 = this.f4770p;
            adEventTracker.b(webView, Collections.singletonList(new u3(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier())));
        } else {
            this.f4773s.getAdEventTracker().a((View) webView);
        }
        this.f4773s.getAdEventTracker().h();
        this.f4773s.getAdEventTracker().g();
    }

    protected void a(AppLovinAdSize appLovinAdSize) {
        try {
            com.applovin.impl.adview.b bVar = new com.applovin.impl.adview.b(this.f4766l, this.f4757c, this.f4755a);
            this.f4768n = bVar;
            bVar.setBackgroundColor(0);
            this.f4768n.setWillNotCacheDrawing(false);
            this.f4756b.setBackgroundColor(0);
            this.f4756b.addView(this.f4768n);
            a(this.f4768n, appLovinAdSize);
            if (!this.f4779y) {
                a(this.f4772r);
            }
            a(new Runnable() { // from class: com.applovin.impl.adview.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4860a.m();
                }
            });
            this.f4779y = true;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("AppLovinAdView", "Failed to initialize AdWebView", th);
            this.f4757c.A().a("AppLovinAdView", "initAdWebView", th);
            this.f4778x.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MotionEvent motionEvent) {
        if (this.f4775u == null && (this.f4773s instanceof com.applovin.impl.sdk.ad.a) && this.f4768n != null) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f4773s;
            Context context = this.f4755a;
            Activity activityB = context instanceof Activity ? (Activity) context : q7.b(this.f4768n, this.f4757c);
            if (activityB != null && !activityB.isFinishing()) {
                ViewGroup viewGroup = this.f4756b;
                if (viewGroup != null) {
                    viewGroup.removeView(this.f4768n);
                }
                f fVar = new f(aVar, this.f4768n, activityB, this.f4757c);
                this.f4775u = fVar;
                fVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.adview.u
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f4867a.a(dialogInterface);
                    }
                });
                this.f4775u.show();
                l2.c(this.C, this.f4773s, (AppLovinAdView) this.f4756b);
                if (this.f4773s.isOpenMeasurementEnabled()) {
                    this.f4773s.getAdEventTracker().a((View) this.f4775u.c());
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to expand ad. No Activity found.");
            Uri uriJ = aVar.j();
            if (uriJ != null) {
                this.f4758d.trackAndLaunchClick(aVar, i(), this, uriJ, motionEvent, null);
            }
            this.f4768n.a("javascript:al_onFailedExpand();");
        }
    }

    private static void a(View view, AppLovinAdSize appLovinAdSize) {
        b(view, appLovinAdSize, false);
    }

    public void a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (context == null) {
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
            return;
        }
        if (appLovinAdSize == null && (appLovinAdSize = com.applovin.impl.q.a(attributeSet)) == null) {
            appLovinAdSize = AppLovinAdSize.BANNER;
        }
        AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        if (appLovinSdk != null) {
            a(appLovinAdView, appLovinSdk.a(), appLovinAdSize2, str, context);
            if (com.applovin.impl.q.b(attributeSet)) {
                s();
            }
        }
    }

    void b(final AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.f4780z) {
                c(appLovinAd);
            } else {
                this.f4777w.set(appLovinAd);
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4759e.a("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
                }
            }
            a(new Runnable() { // from class: com.applovin.impl.adview.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4865a.a(appLovinAd);
                }
            });
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f4759e.b("AppLovinAdView", "No provided when to the view controller");
        }
        b(-1);
    }

    public void a(String str, Object obj) {
        this.f4762h.put(str, obj);
    }

    public void a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            z6.b(appLovinAd, this.f4757c);
            if (this.f4779y) {
                com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) z6.a(appLovinAd, this.f4757c);
                if (bVar == null) {
                    com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to retrieve the loaded ad: " + appLovinAd);
                    l2.a(this.B, "Unable to retrieve the loaded ad");
                    return;
                }
                if (bVar == this.f4773s) {
                    com.applovin.impl.sdk.n.h("AppLovinAdView", "Attempting to show ad again: " + bVar);
                    if (((Boolean) this.f4757c.a(l4.f5787z1)).booleanValue()) {
                        if (this.B instanceof f2) {
                            l2.a(this.B, "Attempting to show ad again");
                            return;
                        } else {
                            if (!z6.c(this.f4757c)) {
                                this.f4757c.g().a(y1.f7798o0, bVar, CollectionUtils.hashMap(TransactionInfo.JsonKeys.SOURCE, "attemptingAdReRender"));
                                return;
                            }
                            throw new IllegalStateException("Attempting to show ad again");
                        }
                    }
                    return;
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4759e.a("AppLovinAdView", "Rendering ad #" + bVar.getAdIdNumber() + " (" + bVar.getSize() + ")");
                }
                l2.b(this.B, this.f4773s);
                if (this.f4773s != null && this.f4773s.isOpenMeasurementEnabled()) {
                    this.f4773s.getAdEventTracker().f();
                }
                this.f4777w.set(null);
                this.f4774t = null;
                this.f4773s = bVar;
                if (this.f4773s.z0()) {
                    this.f4765k = this.f4757c.x().a(this);
                    this.f4757c.x().b(this.f4773s.A(), this.f4765k);
                }
                if (!this.f4780z && z6.a(this.f4763i)) {
                    this.f4757c.k().trackImpression(bVar);
                }
                if (this.f4775u != null) {
                    c();
                }
                a(this.f4771q);
                return;
            }
            com.applovin.impl.sdk.n.i("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            return;
        }
        throw new IllegalArgumentException("No ad specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i10) {
        if (!this.f4780z) {
            a(this.f4772r);
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f4873a.a(i10);
            }
        });
    }

    public void b(Uri uri) {
        if (this.f4773s != null && this.f4773s.B0() && this.f4769o == null) {
            String queryParameter = uri.getQueryParameter("tracking_id");
            if (TextUtils.isEmpty(queryParameter)) {
                this.f4757c.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f4757c.I().b("AppLovinAdView", "Invalid tracking id. Cannot initialize GA");
                    return;
                }
                return;
            }
            WebView webView = new WebView(this.f4755a);
            this.f4769o = webView;
            webView.setWebViewClient(new h4());
            this.f4769o.getSettings().setJavaScriptEnabled(true);
            this.f4769o.loadDataWithBaseURL((String) this.f4757c.a(l4.f5725q6), "<html><head><link rel=\"icon\" href=\"data:,\"><G-SCRIPT_TAG></head><body></body></html>".replace("<G-SCRIPT_TAG>", "<script src='https://www.googletagmanager.com/gtag/js?id=<G-TRACKING_ID>'></script><script>window.dataLayer = window.dataLayer || [];function gtag(){dataLayer.push(arguments);}gtag('js', new Date());gtag('config', '<G-TRACKING_ID>')</script>".replace("<G-TRACKING_ID>", queryParameter)), "text/html", "UTF-8", null);
        }
    }

    public void a(final WebView webView, String str) {
        if (this.f4773s == null) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.v
            @Override // java.lang.Runnable
            public final void run() {
                webView.setVisibility(0);
            }
        });
        if (!((Boolean) this.f4757c.a(l4.M5)).booleanValue() || (str != null && str.startsWith(this.f4773s.h()))) {
            try {
                if (this.f4773s != this.f4774t) {
                    this.f4774t = this.f4773s;
                    v();
                    this.f4768n.setAdHtmlLoaded(true);
                    if (this.B != null) {
                        this.f4757c.w().d(this.f4773s);
                        this.f4757c.g().a(y1.f7795n, this.f4773s);
                        l2.a(this.B, this.f4773s);
                        if (this.f4773s.U0()) {
                            String str2 = (String) this.f4757c.i0().a(n4.L, "");
                            JSONObject jSONObject = new JSONObject();
                            JsonUtils.putString(jSONObject, "template_browser_package_name", str2);
                            this.f4768n.a("javascript:al_onAdViewRendered(" + jSONObject + ");");
                        } else {
                            this.f4768n.a("javascript:al_onAdViewRendered();");
                        }
                    }
                    if ((this.f4773s instanceof com.applovin.impl.sdk.ad.a) && this.f4773s.isOpenMeasurementEnabled()) {
                        this.f4757c.j0().a(new f6(this.f4757c, "StartOMSDK", new Runnable() { // from class: com.applovin.impl.adview.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f4869a.b(webView);
                            }
                        }), r5.b.OTHER, 500L);
                    }
                }
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("AppLovinAdView", "Exception while notifying ad display listener", th);
                com.applovin.impl.sdk.j jVar = this.f4757c;
                if (jVar != null) {
                    jVar.A().a("AppLovinAdView", "onAdHtmlLoaded", th);
                }
            }
        }
    }

    public void a(final MotionEvent motionEvent) {
        a(new Runnable() { // from class: com.applovin.impl.adview.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f4858a.b(motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        a();
    }

    public void a() {
        a(new Runnable() { // from class: com.applovin.impl.adview.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f4864a.n();
            }
        });
    }

    public void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, Uri uri, MotionEvent motionEvent, Bundle bundle) {
        if (appLovinAdView != null) {
            this.f4758d.trackAndLaunchClick(bVar, appLovinAdView, this, uri, motionEvent, bundle);
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f4759e.b("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
        l2.a(this.D, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAd appLovinAd) {
        if (this.f4778x.compareAndSet(true, false)) {
            a(this.f4763i);
        }
        try {
            if (this.A != null) {
                this.A.adReceived(appLovinAd);
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
            com.applovin.impl.sdk.j jVar = this.f4757c;
            if (jVar != null) {
                jVar.A().a("AppLovinAdView", "notifyAdLoadedCallback", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i10) {
        try {
            if (this.A != null) {
                this.A.failedToReceiveAd(i10);
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("AppLovinAdView", "Exception while running app load callback", th);
            com.applovin.impl.sdk.j jVar = this.f4757c;
            if (jVar != null) {
                jVar.A().a("AppLovinAdView", "notifyAdLoadFailedCallback", th);
            }
        }
    }

    private void a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    public void a(b bVar) {
        this.f4761g = bVar;
    }

    public void a(Uri uri) {
        if (this.f4773s == null || !this.f4773s.B0()) {
            return;
        }
        if (this.f4769o == null) {
            this.f4757c.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f4757c.I().a("AppLovinAdView", "GA is not initialized. Cannot fire GA event");
                return;
            }
            return;
        }
        final String queryParameter = uri.getQueryParameter("event_name");
        final String queryParameter2 = uri.getQueryParameter("event_params_json");
        if (TextUtils.isEmpty(queryParameter)) {
            this.f4757c.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f4757c.I().a("AppLovinAdView", "Invalid GA event name. Cannot fire GA event");
                return;
            }
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f4861a.a(queryParameter2, queryParameter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        String str3;
        if (StringUtils.isValidString(str)) {
            str3 = "gtag('event', '" + str2 + "', " + str + ");";
        } else {
            str3 = "gtag('event', '" + str2 + "')";
        }
        a8.a(this.f4769o, str3);
    }
}
