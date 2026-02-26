package com.applovin.adview;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.window.OnBackInvokedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.impl.a2;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.c0;
import com.applovin.impl.d;
import com.applovin.impl.e;
import com.applovin.impl.g;
import com.applovin.impl.g1;
import com.applovin.impl.h2;
import com.applovin.impl.k0;
import com.applovin.impl.l4;
import com.applovin.impl.n4;
import com.applovin.impl.p1;
import com.applovin.impl.q7;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.y1;
import com.applovin.impl.z6;
import com.applovin.sdk.AppLovinSdk;
import com.ironsource.v8;
import io.sentry.protocol.TransactionInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinFullscreenActivity extends Activity implements g1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Set f4640i = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f4641j = new Object();

    @SuppressLint({"StaticFieldLeak"})
    public static h2 parentInterstitialWrapper;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f4642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p1 f4643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f4644c = new AtomicBoolean(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.applovin.impl.adview.activity.a f4645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f4646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c0 f4648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f4649h;

    private static class b implements OnBackInvokedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f4651a;

        protected b(Runnable runnable) {
            this.f4651a = runnable;
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            this.f4651a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        p1 p1Var = this.f4643b;
        if (p1Var != null) {
            p1Var.p();
        }
        if (z6.e(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    @Override // com.applovin.impl.g1
    public void dismiss() {
        if (k0.j() && this.f4646e != null) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f4646e);
            this.f4646e = null;
        }
        p1 p1Var = this.f4643b;
        if (p1Var != null) {
            p1Var.c();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p1 p1Var = this.f4643b;
        if (p1Var != null) {
            p1Var.a(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            n.j("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
            dismiss();
            return;
        }
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            n.c("AppLovinFullscreenActivity", "Failed to request window feature", th);
        }
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(128);
        View viewFindViewById = findViewById(R.id.content);
        viewFindViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        if (TextUtils.isEmpty(getIntent().getStringExtra("com.applovin.interstitial.sdk_key"))) {
            h2 h2Var = parentInterstitialWrapper;
            if (h2Var != null && h2Var.f() != null) {
                h2.a(parentInterstitialWrapper.f(), parentInterstitialWrapper.c(), "Empty SDK key", null, this);
            }
            finish();
            return;
        }
        j jVarA = AppLovinSdk.getInstance(this).a();
        this.f4642a = jVarA;
        this.f4647f = ((Boolean) jVarA.a(l4.f5665j2)).booleanValue();
        viewFindViewById.setFitsSystemWindows(true);
        h2 h2Var2 = parentInterstitialWrapper;
        if (h2Var2 != null && h2Var2.f() != null) {
            com.applovin.impl.sdk.ad.b bVarF = parentInterstitialWrapper.f();
            if (bVarF.L0() && k0.b()) {
                q7.a(viewFindViewById, this.f4642a);
            }
            if (bVarF.u0()) {
                g.a(bVarF, this, this.f4642a);
            }
        }
        d.a(this.f4647f, this);
        if (k0.j() && ((Boolean) this.f4642a.a(l4.f5770w5)).booleanValue()) {
            this.f4646e = new b(new Runnable() { // from class: com.applovin.adview.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4659a.c();
                }
            });
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f4646e);
        }
        a();
        b();
        Integer num = (Integer) this.f4642a.a(l4.V5);
        if (num.intValue() > 0) {
            synchronized (f4641j) {
                Set set = f4640i;
                set.add(this);
                z6.a("AppLovinFullscreenActivity", set.size(), num.intValue(), this.f4642a.A());
            }
        }
        h2 h2Var3 = parentInterstitialWrapper;
        if (h2Var3 != null) {
            p1.a(h2Var3.f(), parentInterstitialWrapper.b(), parentInterstitialWrapper.c(), parentInterstitialWrapper.d(), parentInterstitialWrapper.h(), this.f4642a, this, new a());
            return;
        }
        Intent intent = new Intent(this, (Class<?>) FullscreenAdService.class);
        com.applovin.impl.adview.activity.a aVar = new com.applovin.impl.adview.activity.a(this, this.f4642a);
        this.f4645d = aVar;
        bindService(intent, aVar, 1);
        if (k0.h()) {
            String str = this.f4642a.g0().getExtraParameters().get("disable_set_data_dir_suffix");
            if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
                return;
            }
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        j jVar = this.f4642a;
        if (jVar != null && ((Boolean) jVar.a(l4.Q1)).booleanValue()) {
            this.f4642a.i0().b(n4.H);
            this.f4642a.i0().b(n4.J);
            this.f4642a.i0().b(n4.K);
        }
        if (this.f4648g != null) {
            this.f4642a.i0().b(n4.I);
            this.f4648g.a();
            this.f4648g = null;
        }
        com.applovin.impl.adview.activity.a aVar = this.f4645d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        p1 p1Var = this.f4643b;
        if (p1Var != null) {
            if (!p1Var.g()) {
                this.f4643b.c();
                if (this.f4642a != null) {
                    HashMap<String, String> mapHashMap = CollectionUtils.hashMap(TransactionInfo.JsonKeys.SOURCE, "onDestroyAppLovinFullScreenActivity");
                    h2 h2Var = parentInterstitialWrapper;
                    mapHashMap.putAll(a2.b(h2Var != null ? h2Var.f() : null));
                    this.f4642a.A().d(y1.f7772b0, mapHashMap);
                }
            }
            this.f4643b.q();
        }
        parentInterstitialWrapper = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        p1 p1Var = this.f4643b;
        if (p1Var != null) {
            p1Var.a(i10, keyEvent);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        p1 p1Var = this.f4643b;
        if (p1Var != null) {
            p1Var.r();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        p1 p1Var;
        try {
            super.onResume();
            if (this.f4644c.get() || (p1Var = this.f4643b) == null) {
                return;
            }
            p1Var.s();
        } catch (IllegalArgumentException e10) {
            this.f4642a.I();
            if (n.a()) {
                this.f4642a.I().a("AppLovinFullscreenActivity", "Error was encountered in onResume().", e10);
            }
            this.f4642a.A().a("AppLovinFullscreenActivity", v8.h.f15820u0, e10);
            dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        p1 p1Var = this.f4643b;
        if (p1Var != null) {
            p1Var.t();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        if (this.f4643b != null) {
            if (!this.f4644c.getAndSet(false)) {
                this.f4643b.b(z10);
            }
            if (z10) {
                d.a(this.f4647f, this);
            }
        }
        super.onWindowFocusChanged(z10);
    }

    public void setPresenter(@Nullable p1 p1Var) {
        this.f4643b = p1Var;
    }

    class a implements p1.d {
        a() {
        }

        @Override // com.applovin.impl.p1.d
        public void a(p1 p1Var) {
            AppLovinFullscreenActivity.this.f4643b = p1Var;
            p1Var.v();
        }

        @Override // com.applovin.impl.p1.d
        public void a(String str, Throwable th) {
            h2.a(AppLovinFullscreenActivity.parentInterstitialWrapper.f(), AppLovinFullscreenActivity.parentInterstitialWrapper.c(), str, th, AppLovinFullscreenActivity.this);
        }
    }

    private void b() {
        j jVar = this.f4642a;
        if (jVar == null || !((Boolean) jVar.a(l4.R1)).booleanValue()) {
            return;
        }
        final Long l10 = (Long) this.f4642a.a(l4.S1);
        this.f4648g = c0.a(l10.longValue(), true, this.f4642a, new Runnable() { // from class: com.applovin.adview.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f4657a.a(l10);
            }
        });
    }

    private void a() {
        h2 h2Var;
        j jVar = this.f4642a;
        if (jVar == null || !((Boolean) jVar.a(l4.Q1)).booleanValue() || (h2Var = parentInterstitialWrapper) == null || h2Var.f() == null) {
            return;
        }
        com.applovin.impl.sdk.ad.b bVarF = parentInterstitialWrapper.f();
        List listG = bVarF.g();
        if (CollectionUtils.isEmpty(listG)) {
            return;
        }
        e eVar = (e) listG.get(0);
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_url", eVar.c());
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_backup_url", eVar.a());
        this.f4642a.i0().b(n4.J, jSONObject.toString());
        this.f4642a.i0().b(n4.H, Long.valueOf(System.currentTimeMillis()));
        this.f4642a.i0().b(n4.K, CollectionUtils.toJsonString(a2.b(bVarF), JsonUtils.EMPTY_JSON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l10) {
        this.f4649h += l10.longValue();
        this.f4642a.i0().b(n4.I, Long.valueOf(this.f4649h));
    }
}
