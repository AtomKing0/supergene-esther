package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.h2;
import com.applovin.impl.p1;
import com.applovin.impl.s;
import com.applovin.impl.s5;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f4794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f4795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f4796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f4797d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Messenger f4798e;

    /* JADX INFO: renamed from: com.applovin.impl.adview.activity.a$a, reason: collision with other inner class name */
    class C0159a implements AppLovinAdLoadListener {
        C0159a() {
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) a.this.f4796c.get();
            if (appLovinFullscreenActivity != null) {
                n unused = a.this.f4795b;
                if (n.a()) {
                    a.this.f4795b.a("AppLovinFullscreenActivity", "Presenting ad...");
                }
                b bVar = new b(a.this, null);
                p1.a((com.applovin.impl.sdk.ad.b) appLovinAd, bVar, bVar, bVar, null, a.this.f4794a, appLovinFullscreenActivity, new C0160a(appLovinFullscreenActivity, appLovinAd, bVar));
                return;
            }
            n unused2 = a.this.f4795b;
            if (n.a()) {
                a.this.f4795b.b("AppLovinFullscreenActivity", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i10) {
            a.this.a();
        }

        /* JADX INFO: renamed from: com.applovin.impl.adview.activity.a$a$a, reason: collision with other inner class name */
        class C0160a implements p1.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppLovinFullscreenActivity f4800a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppLovinAd f4801b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f4802c;

            C0160a(AppLovinFullscreenActivity appLovinFullscreenActivity, AppLovinAd appLovinAd, b bVar) {
                this.f4800a = appLovinFullscreenActivity;
                this.f4801b = appLovinAd;
                this.f4802c = bVar;
            }

            @Override // com.applovin.impl.p1.d
            public void a(p1 p1Var) {
                this.f4800a.setPresenter(p1Var);
                p1Var.v();
            }

            @Override // com.applovin.impl.p1.d
            public void a(String str, Throwable th) {
                h2.a((com.applovin.impl.sdk.ad.b) this.f4801b, this.f4802c, str, th, this.f4800a);
            }
        }
    }

    private class b implements AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        private b() {
        }

        private void a(FullscreenAdService.c cVar) {
            a(null, cVar);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_CLICKED);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_DISPLAYED);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_HIDDEN);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            a(FullscreenAdService.c.AD_VIDEO_STARTED);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d10, boolean z10) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d10);
            bundle.putBoolean("fully_watched", z10);
            a(bundle, FullscreenAdService.c.AD_VIDEO_ENDED);
        }

        /* synthetic */ b(a aVar, C0159a c0159a) {
            this();
        }

        private void a(Bundle bundle, FullscreenAdService.c cVar) {
            Message messageObtain = Message.obtain((Handler) null, cVar.b());
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            try {
                a.this.f4798e.send(messageObtain);
            } catch (RemoteException e10) {
                n unused = a.this.f4795b;
                if (n.a()) {
                    a.this.f4795b.a("AppLovinFullscreenActivity", "Failed to forward callback (" + cVar.b() + ")", e10);
                }
            }
        }
    }

    private static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f4805a;

        /* synthetic */ c(a aVar, C0159a c0159a) {
            this(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            if (message.what != FullscreenAdService.c.AD.b() || (aVar = (a) this.f4805a.get()) == null) {
                super.handleMessage(message);
            } else {
                aVar.a(message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
            }
        }

        private c(a aVar) {
            this.f4805a = new WeakReference(aVar);
        }
    }

    public a(AppLovinFullscreenActivity appLovinFullscreenActivity, j jVar) {
        this.f4794a = jVar;
        this.f4795b = jVar.I();
        this.f4796c = new WeakReference(appLovinFullscreenActivity);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f4797d.compareAndSet(false, true)) {
            if (n.a()) {
                this.f4795b.a("AppLovinFullscreenActivity", "Fullscreen ad service connected to " + componentName);
            }
            this.f4798e = new Messenger(iBinder);
            Message messageObtain = Message.obtain((Handler) null, FullscreenAdService.c.AD.b());
            messageObtain.replyTo = new Messenger(new c(this, null));
            try {
                if (n.a()) {
                    this.f4795b.a("AppLovinFullscreenActivity", "Requesting ad from FullscreenAdService...");
                }
                this.f4798e.send(messageObtain);
            } catch (RemoteException e10) {
                if (n.a()) {
                    this.f4795b.a("AppLovinFullscreenActivity", "Failed to send ad request message to FullscreenAdService", e10);
                }
                a();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f4797d.compareAndSet(true, false) && n.a()) {
            this.f4795b.a("AppLovinFullscreenActivity", "FullscreenAdService disconnected from " + componentName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) this.f4796c.get();
        if (appLovinFullscreenActivity != null) {
            if (n.a()) {
                this.f4795b.a("AppLovinFullscreenActivity", "Dismissing...");
            }
            appLovinFullscreenActivity.dismiss();
        } else if (n.a()) {
            this.f4795b.b("AppLovinFullscreenActivity", "Unable to dismiss parent Activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = JsonUtils.getString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, "");
            if (!TextUtils.isEmpty(string)) {
                this.f4794a.j0().a(new s5(jSONObject, s.a(string), true, new C0159a(), this.f4794a));
                return;
            }
            throw new IllegalStateException("No zone identifier found in ad response: " + jSONObject);
        } catch (JSONException e10) {
            if (n.a()) {
                this.f4795b.a("AppLovinFullscreenActivity", "Unable to process ad: " + str, e10);
            }
            a();
        }
    }
}
