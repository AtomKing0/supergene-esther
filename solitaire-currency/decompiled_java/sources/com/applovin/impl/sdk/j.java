package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.applovin.impl.a3;
import com.applovin.impl.b3;
import com.applovin.impl.e2;
import com.applovin.impl.e4;
import com.applovin.impl.f3;
import com.applovin.impl.f6;
import com.applovin.impl.g3;
import com.applovin.impl.h5;
import com.applovin.impl.j3;
import com.applovin.impl.k1;
import com.applovin.impl.k3;
import com.applovin.impl.k4;
import com.applovin.impl.l2;
import com.applovin.impl.l3;
import com.applovin.impl.l4;
import com.applovin.impl.m4;
import com.applovin.impl.m6;
import com.applovin.impl.mediation.MaxSegmentCollectionImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.n3;
import com.applovin.impl.n4;
import com.applovin.impl.o4;
import com.applovin.impl.p0;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.q5;
import com.applovin.impl.r2;
import com.applovin.impl.r5;
import com.applovin.impl.s6;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t7;
import com.applovin.impl.v1;
import com.applovin.impl.w1;
import com.applovin.impl.w3;
import com.applovin.impl.w4;
import com.applovin.impl.x6;
import com.applovin.impl.x7;
import com.applovin.impl.y1;
import com.applovin.impl.y6;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxSegmentCollection;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static volatile com.applovin.impl.c A0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static j f7084v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    protected static Context f7085w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private static boolean f7086x0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private static final boolean f7088z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference f7091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7095d;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private List f7098e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppLovinSdkSettings f7099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxSegmentCollection f7101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f7103h;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f7106i0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile AppLovinSdk f7113m;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private String f7116n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private AppLovinSdkInitializationConfiguration f7118o0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private AppLovinSdk.SdkInitializationListener f7124r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private AppLovinSdk.SdkInitializationListener f7126s0;
    private static final Object B0 = new Object();

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private static final long f7087y0 = System.currentTimeMillis();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f7097e = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicReference f7105i = new AtomicReference();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicReference f7107j = new AtomicReference();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicReference f7109k = new AtomicReference();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicReference f7111l = new AtomicReference();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n f7115n = new n(this);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final com.applovin.impl.f f7117o = new com.applovin.impl.f(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final r2 f7119p = new r2(this);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final k1 f7121q = new k1(this);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final x6 f7123r = new x6(this);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final AtomicReference f7125s = new AtomicReference();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicReference f7127t = new AtomicReference();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicReference f7129u = new AtomicReference();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicReference f7131v = new AtomicReference();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicReference f7132w = new AtomicReference();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicReference f7133x = new AtomicReference();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicReference f7134y = new AtomicReference();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final AtomicReference f7135z = new AtomicReference();
    private final AtomicReference A = new AtomicReference();
    private final AtomicReference B = new AtomicReference();
    private final AtomicReference C = new AtomicReference();
    private final AtomicReference D = new AtomicReference();
    private final AtomicReference E = new AtomicReference();
    private final AtomicReference F = new AtomicReference();
    private final AtomicReference G = new AtomicReference();
    private final AtomicReference H = new AtomicReference();
    private final AtomicReference I = new AtomicReference();
    private final AtomicReference J = new AtomicReference();
    private final AtomicReference K = new AtomicReference();
    private final AtomicReference L = new AtomicReference();
    private final AtomicReference M = new AtomicReference();
    private final AtomicReference N = new AtomicReference();
    private final AtomicReference O = new AtomicReference();
    private final AtomicReference P = new AtomicReference();
    private final AtomicReference Q = new AtomicReference();
    private final AtomicReference R = new AtomicReference();
    private final AtomicReference S = new AtomicReference();
    private final AtomicReference T = new AtomicReference();
    private final AtomicReference U = new AtomicReference();
    private final AtomicReference V = new AtomicReference();
    private final AtomicReference W = new AtomicReference();
    private final AtomicReference X = new AtomicReference();
    private final AtomicReference Y = new AtomicReference();
    private final AtomicReference Z = new AtomicReference();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final AtomicReference f7090a0 = new AtomicReference();

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final AtomicReference f7092b0 = new AtomicReference();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final AtomicReference f7094c0 = new AtomicReference();

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final AtomicReference f7096d0 = new AtomicReference();

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final Object f7100f0 = new Object();

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final AtomicBoolean f7102g0 = new AtomicBoolean(true);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final AtomicBoolean f7104h0 = new AtomicBoolean();

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f7108j0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private boolean f7110k0 = false;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f7112l0 = false;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private int f7114m0 = 0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final Object f7120p0 = new Object();

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private AppLovinSdkConfiguration f7122q0 = new SdkConfigurationImpl(null, this);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final w4 f7128t0 = new f6(this, true, "scheduleAdLoadIntegrationError", new Runnable() { // from class: com.applovin.impl.sdk.m0
        @Override // java.lang.Runnable
        public final void run() {
            this.f7182a.D0();
        }
    });

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private final w4 f7130u0 = new f6(this, true, "sdkInit", new Runnable() { // from class: com.applovin.impl.sdk.n0
        @Override // java.lang.Runnable
        public final void run() {
            this.f7185a.E0();
        }
    });

    class a implements h5.b {
        a() {
        }

        @Override // com.applovin.impl.h5.b
        public void a(JSONObject jSONObject) {
            boolean z10 = jSONObject != null && jSONObject.length() > 0;
            j.this.c(jSONObject);
            com.applovin.impl.x.b(j.this);
            com.applovin.impl.n0.a(jSONObject, z10, j.this);
            j.this.N().a(JsonUtils.getBoolean(jSONObject, "smd", Boolean.FALSE).booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
            j.this.A().b();
            j jVar = j.this;
            jVar.f7098e0 = jVar.a(jSONObject);
            if (z10) {
                List<String> listExplode = CollectionUtils.explode(JsonUtils.getString(jSONObject, "eaaui", ""));
                j jVar2 = j.this;
                jVar2.f7122q0 = new SdkConfigurationImpl(listExplode, jVar2);
            }
            j.this.l0().a(jSONObject);
            j.this.b(jSONObject);
            l2.b(((Boolean) j.this.a(l4.K5)).booleanValue());
            l2.a(((Boolean) j.this.a(l4.L5)).booleanValue());
            j.this.J0();
            if (!((Boolean) j.this.a(l4.Q2)).booleanValue() || z10 || !com.applovin.impl.n0.a(j.n())) {
                j.this.H0();
                return;
            }
            j.this.I();
            if (n.a()) {
                j.this.I().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
            }
            j.this.M0();
        }
    }

    class b implements p0.c {
        b() {
        }

        @Override // com.applovin.impl.p0.c
        public void a(p0.b bVar) {
            j.this.I();
            if (n.a()) {
                j.this.I().a("AppLovinSdk", "Terms and Privacy Policy flow completed with status: " + bVar);
            }
            if (!bVar.c()) {
                j.this.c("Initializing SDK in MAX environment...");
                return;
            }
            j.this.I();
            if (n.a()) {
                j.this.I().a("AppLovinSdk", "Re-initializing SDK with the updated privacy settings...");
            }
            j.this.L0();
            j.this.K0();
        }
    }

    class c implements h5.b {
        c() {
        }

        @Override // com.applovin.impl.h5.b
        public void a(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.length() > 0) {
                j.this.c(jSONObject);
            }
            j.this.f7097e.set(false);
            j.this.H0();
        }
    }

    static {
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.j0
                @Override // java.lang.Runnable
                public final void run() {
                    z6.c();
                }
            });
            f7088z0 = true;
        } catch (Throwable unused) {
            f7088z0 = false;
        }
    }

    public j(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.f7106i0 = false;
        f7084v0 = this;
        this.f7099f = appLovinSdkSettings;
        this.f7093c = System.currentTimeMillis();
        this.f7106i0 = true;
        if (!y0()) {
            throw new RuntimeException("As of version 12.0.0, the AppLovin MAX SDK requires Java 8. For more information visit our docs: https://developers.applovin.com/en/android/overview/integration");
        }
        f7085w0 = context.getApplicationContext();
        if (context instanceof Activity) {
            this.f7091b = new WeakReference((Activity) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0() {
        if (j0().d()) {
            return;
        }
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "Timing out adapters init...");
        }
        j0().e();
        F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0() {
        r5 r5VarJ0 = j0();
        int i10 = this.f7114m0 + 1;
        this.f7114m0 = i10;
        r5VarJ0.a((w4) new h5(i10, this, new c()), r5.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0() {
        if (z0()) {
            e2.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        synchronized (this.f7100f0) {
            boolean zA = com.applovin.impl.n0.a(n());
            if (!z0()) {
                I();
                if (n.a()) {
                    I().a("AppLovinSdk", "non-MAX mediation detected, mediation provider is: " + O());
                }
            }
            if (!((Boolean) a(l4.R2)).booleanValue() || zA) {
                L0();
            }
            if (((Boolean) a(l4.Q2)).booleanValue() && !zA) {
                I();
                if (n.a()) {
                    I().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                }
                M0();
            }
        }
    }

    private q G0() {
        if (!e4.f(f7085w0)) {
            return null;
        }
        try {
            return new q(this);
        } catch (Throwable th) {
            n.b("AppLovinSdk", "Failed to initialize Privacy Sandbox Service", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        Long l10 = (Long) a(l4.Z2);
        if (l10.longValue() >= 0 && this.f7097e.compareAndSet(false, true)) {
            t7.a(l10.longValue(), false, this, new Runnable() { // from class: com.applovin.impl.sdk.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7341a.C0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (!z0()) {
            c("Initializing SDK in non-MAX environment...");
            return;
        }
        if (!this.f7104h0.compareAndSet(false, true)) {
            c("Consent flow is already shown. Initializing SDK in MAX environment...");
        } else if (!v().j()) {
            c("Consent flow is not enabled. Initializing SDK in MAX environment...");
        } else {
            v().a(n0(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        n3 n3VarV = V();
        n3VarV.a(new d(n3VarV));
    }

    private Map P() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) a(l4.S3)));
        } catch (JSONException unused) {
            return Collections.emptyMap();
        }
    }

    public static Context n() {
        return f7085w0;
    }

    private void t0() {
        Context context = f7085w0;
        n nVarI = I();
        o4 o4VarI0 = i0();
        com.applovin.impl.p0 p0VarV = v();
        a(context);
        f0();
        j();
        o();
        V();
        L().a(MaxAdapter.InitializationStatus.INITIALIZING);
        NativeCrashReporter.a(this);
        String str = this.f7089a;
        if (str == null || str.length() != 86) {
            n.h("AppLovinSdk", "SDK key provided is invalid (" + this.f7089a + "). Expected length: 86 characters.\n\nStack trace:\n" + Log.getStackTraceString(new Throwable()));
        }
        if (p0VarV.l()) {
            String str2 = "Terms Flow has been replaced. " + p0VarV.g();
            if (z6.c(this)) {
                throw new IllegalStateException(str2);
            }
            n.h("AppLovinSdk", str2);
        }
        if (z6.i()) {
            n.h("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!z6.b(this)) {
            n.h("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (z6.k(context)) {
            this.f7099f.setVerboseLogging(true);
        }
        h0().a(l4.f5670k, Boolean.valueOf(this.f7099f.isVerboseLoggingEnabled()));
        l3.d(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        n4 n4Var = n4.f6381c;
        if (TextUtils.isEmpty((String) o4VarI0.a(n4Var, (Object) null, defaultSharedPreferences))) {
            this.f7110k0 = true;
            o4VarI0.b(n4Var, Boolean.toString(true), defaultSharedPreferences);
        } else {
            o4VarI0.b(n4Var, Boolean.toString(false), defaultSharedPreferences);
        }
        n4 n4Var2 = n4.f6382d;
        if (((Boolean) o4VarI0.a(n4Var2, Boolean.FALSE)).booleanValue()) {
            if (n.a()) {
                nVarI.a("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.f7112l0 = true;
        } else {
            if (n.a()) {
                nVarI.a("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            o4VarI0.b(n4Var2, Boolean.TRUE);
            o4VarI0.b(n4.f6393o, Boolean.valueOf(p0VarV.j()));
        }
        n4 n4Var3 = n4.f6383e;
        String str3 = (String) o4VarI0.a(n4Var3, null);
        if (StringUtils.isValidString(str3)) {
            if (AppLovinSdk.VERSION_CODE > z6.g(str3)) {
                o4VarI0.b(n4Var3, AppLovinSdk.VERSION);
            }
        } else {
            o4VarI0.b(n4Var3, AppLovinSdk.VERSION);
        }
        o0().d(y1.f7777e, CollectionUtils.map("details", "isInitProviderContextSet=" + f7086x0));
    }

    public static boolean y0() {
        return f7088z0;
    }

    public k1 A() {
        return this.f7121q;
    }

    public boolean A0() {
        return z6.a("com.unity3d.player.UnityPlayerActivity");
    }

    public EventServiceImpl B() {
        Object eventServiceImpl = this.f7109k.get();
        if (eventServiceImpl == null) {
            synchronized (this.f7109k) {
                eventServiceImpl = this.f7109k.get();
                if (eventServiceImpl == null) {
                    eventServiceImpl = new EventServiceImpl(this);
                    this.f7109k.set(eventServiceImpl);
                }
            }
        }
        if (eventServiceImpl == this.f7109k) {
            eventServiceImpl = null;
        }
        return (EventServiceImpl) eventServiceImpl;
    }

    public l C() {
        Object lVar = this.D.get();
        if (lVar == null) {
            synchronized (this.D) {
                lVar = this.D.get();
                if (lVar == null) {
                    lVar = new l(this);
                    this.D.set(lVar);
                }
            }
        }
        if (lVar == this.D) {
            lVar = null;
        }
        return (l) lVar;
    }

    public m D() {
        Object mVar = this.F.get();
        if (mVar == null) {
            synchronized (this.F) {
                mVar = this.F.get();
                if (mVar == null) {
                    mVar = new m(this);
                    this.F.set(mVar);
                }
            }
        }
        if (mVar == this.F) {
            mVar = null;
        }
        return (m) mVar;
    }

    public w1 E() {
        Object w1Var = this.f7131v.get();
        if (w1Var == null) {
            synchronized (this.f7131v) {
                w1Var = this.f7131v.get();
                if (w1Var == null) {
                    w1Var = new w1(this);
                    this.f7131v.set(w1Var);
                }
            }
        }
        if (w1Var == this.f7131v) {
            w1Var = null;
        }
        return (w1) w1Var;
    }

    public Activity F() {
        WeakReference weakReference;
        if (!((Boolean) a(l4.f5635f4)).booleanValue() || (weakReference = this.f7091b) == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public void F0() {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener;
        if (v().i() || (sdkInitializationListener = this.f7124r0) == null) {
            return;
        }
        if (u0()) {
            this.f7124r0 = null;
            this.f7126s0 = null;
            L().a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
        } else {
            if (this.f7126s0 == sdkInitializationListener) {
                return;
            }
            L().a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
            if (((Boolean) a(l4.f5710p)).booleanValue()) {
                this.f7124r0 = null;
            } else {
                this.f7126s0 = sdkInitializationListener;
            }
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.l0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7168a.b(sdkInitializationListener);
            }
        }, Math.max(0L, ((Long) a(l4.f5718q)).longValue()));
    }

    public AppLovinSdkInitializationConfiguration G() {
        return this.f7118o0;
    }

    public long H() {
        return this.f7093c;
    }

    public n I() {
        return this.f7115n;
    }

    public void I0() {
        if (StringUtils.isValidString(this.f7103h)) {
            return;
        }
        this.f7103h = AppLovinMediationProvider.MAX;
    }

    public r2 J() {
        return this.f7119p;
    }

    public com.applovin.impl.mediation.d K() {
        Object dVar = this.f7094c0.get();
        if (dVar == null) {
            synchronized (this.f7094c0) {
                dVar = this.f7094c0.get();
                if (dVar == null) {
                    dVar = new com.applovin.impl.mediation.d(this);
                    this.f7094c0.set(dVar);
                }
            }
        }
        if (dVar == this.f7094c0) {
            dVar = null;
        }
        return (com.applovin.impl.mediation.d) dVar;
    }

    public void K0() {
        r().a();
    }

    public com.applovin.impl.mediation.e L() {
        Object eVar = this.X.get();
        if (eVar == null) {
            synchronized (this.X) {
                eVar = this.X.get();
                if (eVar == null) {
                    eVar = new com.applovin.impl.mediation.e(this);
                    this.X.set(eVar);
                }
            }
        }
        if (eVar == this.X) {
            eVar = null;
        }
        return (com.applovin.impl.mediation.e) eVar;
    }

    public void L0() {
        synchronized (this.f7100f0) {
            this.f7106i0 = true;
            j0().f();
            d();
        }
    }

    public com.applovin.impl.mediation.f M() {
        Object fVar = this.W.get();
        if (fVar == null) {
            synchronized (this.W) {
                fVar = this.W.get();
                if (fVar == null) {
                    fVar = new com.applovin.impl.mediation.f(this);
                    this.W.set(fVar);
                }
            }
        }
        if (fVar == this.W) {
            fVar = null;
        }
        return (com.applovin.impl.mediation.f) fVar;
    }

    public f3 N() {
        Object f3Var = this.f7090a0.get();
        if (f3Var == null) {
            synchronized (this.f7090a0) {
                f3Var = this.f7090a0.get();
                if (f3Var == null) {
                    f3Var = new f3(this);
                    this.f7090a0.set(f3Var);
                }
            }
        }
        if (f3Var == this.f7090a0) {
            f3Var = null;
        }
        return (f3) f3Var;
    }

    public void N0() {
        n.h("AppLovinSdk", "Resetting SDK state...");
        w1 w1VarE = E();
        v1 v1Var = v1.f7562l;
        long jB = w1VarE.b(v1Var);
        h0().a();
        h0().e();
        E().a();
        E().b(v1Var, jB + 1);
        if (this.f7102g0.compareAndSet(true, false)) {
            L0();
        } else {
            this.f7102g0.set(true);
        }
    }

    public String O() {
        return this.f7103h;
    }

    public void O0() {
        if (StringUtils.isValidString(this.f7116n0)) {
            return;
        }
        this.f7116n0 = AppLovinMediationProvider.MAX;
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "Detected mediation provider: MAX");
        }
    }

    public void P0() {
        w().n();
    }

    public MediationServiceImpl Q() {
        Object mediationServiceImpl = this.Y.get();
        if (mediationServiceImpl == null) {
            synchronized (this.Y) {
                mediationServiceImpl = this.Y.get();
                if (mediationServiceImpl == null) {
                    mediationServiceImpl = new MediationServiceImpl(this);
                    this.Y.set(mediationServiceImpl);
                }
            }
        }
        if (mediationServiceImpl == this.Y) {
            mediationServiceImpl = null;
        }
        return (MediationServiceImpl) mediationServiceImpl;
    }

    public void Q0() {
        a((Map) null);
    }

    public j3 R() {
        Object j3Var = this.f7132w.get();
        if (j3Var == null) {
            synchronized (this.f7132w) {
                j3Var = this.f7132w.get();
                if (j3Var == null) {
                    j3Var = new j3(this);
                    this.f7132w.set(j3Var);
                }
            }
        }
        if (j3Var == this.f7132w) {
            j3Var = null;
        }
        return (j3) j3Var;
    }

    public void R0() {
        if (AppLovinMediationProvider.ADMOB.equalsIgnoreCase(this.f7103h) && ((Boolean) a(l4.f5768w3)).booleanValue()) {
            String str = (String) a(l4.f5761v3);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str2 = AppLovinSdk.VERSION;
            sb.append(str2);
            sb.append(".");
            if (str.startsWith(sb.toString())) {
                return;
            }
            final String str3 = "Mismatched AdMob adapter (" + str + ") and AppLovin SDK (" + str2 + ") versions detected, which may cause compatibility issues.";
            n.h("AppLovinSdk", str3);
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7160a.b(str3);
                }
            });
        }
    }

    public k3 S() {
        Object k3Var = this.Z.get();
        if (k3Var == null) {
            synchronized (this.Z) {
                k3Var = this.Z.get();
                if (k3Var == null) {
                    k3Var = new k3();
                    this.Z.set(k3Var);
                }
            }
        }
        if (k3Var == this.Z) {
            k3Var = null;
        }
        return (k3) k3Var;
    }

    public o T() {
        Object oVar = this.f7092b0.get();
        if (oVar == null) {
            synchronized (this.f7092b0) {
                oVar = this.f7092b0.get();
                if (oVar == null) {
                    oVar = new o(this);
                    this.f7092b0.set(oVar);
                }
            }
        }
        if (oVar == this.f7092b0) {
            oVar = null;
        }
        return (o) oVar;
    }

    public AppLovinNativeAdService U() {
        Object appLovinNativeAdService = this.f7107j.get();
        if (appLovinNativeAdService == null) {
            synchronized (this.f7107j) {
                appLovinNativeAdService = this.f7107j.get();
                if (appLovinNativeAdService == null) {
                    appLovinNativeAdService = new AppLovinNativeAdService(this);
                    this.f7107j.set(appLovinNativeAdService);
                }
            }
        }
        if (appLovinNativeAdService == this.f7107j) {
            appLovinNativeAdService = null;
        }
        return (AppLovinNativeAdService) appLovinNativeAdService;
    }

    public n3 V() {
        Object n3Var = this.I.get();
        if (n3Var == null) {
            synchronized (this.I) {
                n3Var = this.I.get();
                if (n3Var == null) {
                    n3Var = new n3(n());
                    this.I.set(n3Var);
                }
            }
        }
        if (n3Var == this.I) {
            n3Var = null;
        }
        return (n3) n3Var;
    }

    public w3 W() {
        Object w3Var = this.P.get();
        if (w3Var == null) {
            synchronized (this.P) {
                w3Var = this.P.get();
                if (w3Var == null) {
                    w3Var = new w3(this);
                    this.P.set(w3Var);
                }
            }
        }
        if (w3Var == this.P) {
            w3Var = null;
        }
        return (w3) w3Var;
    }

    public com.applovin.impl.sdk.network.b X() {
        Object bVar = this.U.get();
        if (bVar == null) {
            synchronized (this.U) {
                bVar = this.U.get();
                if (bVar == null) {
                    bVar = new com.applovin.impl.sdk.network.b(this);
                    this.U.set(bVar);
                }
            }
        }
        if (bVar == this.U) {
            bVar = null;
        }
        return (com.applovin.impl.sdk.network.b) bVar;
    }

    public PostbackServiceImpl Y() {
        Object postbackServiceImpl = this.T.get();
        if (postbackServiceImpl == null) {
            synchronized (this.T) {
                postbackServiceImpl = this.T.get();
                if (postbackServiceImpl == null) {
                    postbackServiceImpl = new PostbackServiceImpl(this);
                    this.T.set(postbackServiceImpl);
                }
            }
        }
        if (postbackServiceImpl == this.T) {
            postbackServiceImpl = null;
        }
        return (PostbackServiceImpl) postbackServiceImpl;
    }

    public q Z() {
        Object objG0 = this.f7134y.get();
        if (objG0 == null) {
            synchronized (this.f7134y) {
                objG0 = this.f7134y.get();
                if (objG0 == null) {
                    objG0 = G0();
                    if (objG0 == null) {
                        objG0 = this.f7134y;
                    }
                    this.f7134y.set(objG0);
                }
            }
        }
        if (objG0 == this.f7134y) {
            objG0 = null;
        }
        return (q) objG0;
    }

    public String a0() {
        return p0().a();
    }

    public String b0() {
        return this.f7089a;
    }

    public MaxSegmentCollectionImpl c0() {
        return (MaxSegmentCollectionImpl) this.f7101g;
    }

    public Map d0() {
        MaxSegmentCollectionImpl maxSegmentCollectionImplC0 = c0();
        if (maxSegmentCollectionImplC0 == null) {
            return null;
        }
        return maxSegmentCollectionImplC0.getJsonData();
    }

    public k4 e0() {
        Object k4Var = this.K.get();
        if (k4Var == null) {
            synchronized (this.K) {
                k4Var = this.K.get();
                if (k4Var == null) {
                    k4Var = new k4(this);
                    this.K.set(k4Var);
                }
            }
        }
        if (k4Var == this.K) {
            k4Var = null;
        }
        return (k4) k4Var;
    }

    public SessionTracker f0() {
        Object sessionTracker = this.E.get();
        if (sessionTracker == null) {
            synchronized (this.E) {
                sessionTracker = this.E.get();
                if (sessionTracker == null) {
                    sessionTracker = new SessionTracker(this);
                    this.E.set(sessionTracker);
                }
            }
        }
        if (sessionTracker == this.E) {
            sessionTracker = null;
        }
        return (SessionTracker) sessionTracker;
    }

    public AppLovinSdkSettings g0() {
        return this.f7099f;
    }

    public m4 h0() {
        Object m4Var = this.f7127t.get();
        if (m4Var == null) {
            synchronized (this.f7127t) {
                m4Var = this.f7127t.get();
                if (m4Var == null) {
                    m4Var = new m4(this);
                    this.f7127t.set(m4Var);
                }
            }
        }
        if (m4Var == this.f7127t) {
            m4Var = null;
        }
        return (m4) m4Var;
    }

    public o4 i0() {
        Object o4Var = this.f7135z.get();
        if (o4Var == null) {
            synchronized (this.f7135z) {
                o4Var = this.f7135z.get();
                if (o4Var == null) {
                    o4Var = new o4(this);
                    this.f7135z.set(o4Var);
                }
            }
        }
        if (o4Var == this.f7135z) {
            o4Var = null;
        }
        return (o4) o4Var;
    }

    public r5 j0() {
        Object r5Var = this.f7125s.get();
        if (r5Var == null) {
            synchronized (this.f7125s) {
                r5Var = this.f7125s.get();
                if (r5Var == null) {
                    r5Var = new r5(this);
                    this.f7125s.set(r5Var);
                }
            }
        }
        if (r5Var == this.f7125s) {
            r5Var = null;
        }
        return (r5) r5Var;
    }

    public m6 k0() {
        Object m6Var = this.N.get();
        if (m6Var == null) {
            synchronized (this.N) {
                m6Var = this.N.get();
                if (m6Var == null) {
                    m6Var = new m6(this);
                    this.N.set(m6Var);
                }
            }
        }
        if (m6Var == this.N) {
            m6Var = null;
        }
        return (m6) m6Var;
    }

    public s6 l0() {
        Object s6Var = this.f7096d0.get();
        if (s6Var == null) {
            synchronized (this.f7096d0) {
                s6Var = this.f7096d0.get();
                if (s6Var == null) {
                    s6Var = new s6(this);
                    this.f7096d0.set(s6Var);
                }
            }
        }
        if (s6Var == this.f7096d0) {
            s6Var = null;
        }
        return (s6) s6Var;
    }

    public long m0() {
        if (this.f7095d == 0) {
            return -1L;
        }
        return System.currentTimeMillis() - this.f7095d;
    }

    public Activity n0() {
        Activity activityB = a(n()).b();
        return activityB != null ? activityB : F();
    }

    public ArrayService o() {
        Object arrayService = this.Q.get();
        if (arrayService == null) {
            synchronized (this.Q) {
                arrayService = this.Q.get();
                if (arrayService == null) {
                    arrayService = new ArrayService(this);
                    this.Q.set(arrayService);
                }
            }
        }
        if (arrayService == this.Q) {
            arrayService = null;
        }
        return (ArrayService) arrayService;
    }

    public x6 o0() {
        return this.f7123r;
    }

    public h p() {
        Object hVar = this.L.get();
        if (hVar == null) {
            synchronized (this.L) {
                hVar = this.L.get();
                if (hVar == null) {
                    hVar = new h(this);
                    this.L.set(hVar);
                }
            }
        }
        if (hVar == this.L) {
            hVar = null;
        }
        return (h) hVar;
    }

    public y6 p0() {
        Object y6Var = this.A.get();
        if (y6Var == null) {
            synchronized (this.A) {
                y6Var = this.A.get();
                if (y6Var == null) {
                    y6Var = new y6(this);
                    this.A.set(y6Var);
                }
            }
        }
        if (y6Var == this.A) {
            y6Var = null;
        }
        return (y6) y6Var;
    }

    public CmpServiceImpl q() {
        Object cmpServiceImpl = this.f7111l.get();
        if (cmpServiceImpl == null) {
            synchronized (this.f7111l) {
                cmpServiceImpl = this.f7111l.get();
                if (cmpServiceImpl == null) {
                    cmpServiceImpl = new CmpServiceImpl(this);
                    this.f7111l.set(cmpServiceImpl);
                }
            }
        }
        if (cmpServiceImpl == this.f7111l) {
            cmpServiceImpl = null;
        }
        return (CmpServiceImpl) cmpServiceImpl;
    }

    public x7 q0() {
        Object x7Var = this.H.get();
        if (x7Var == null) {
            synchronized (this.H) {
                x7Var = this.H.get();
                if (x7Var == null) {
                    x7Var = new x7(this);
                    this.H.set(x7Var);
                }
            }
        }
        if (x7Var == this.H) {
            x7Var = null;
        }
        return (x7) x7Var;
    }

    public i r() {
        Object iVar = this.J.get();
        if (iVar == null) {
            synchronized (this.J) {
                iVar = this.J.get();
                if (iVar == null) {
                    iVar = new i(this);
                    this.J.set(iVar);
                }
            }
        }
        if (iVar == this.J) {
            iVar = null;
        }
        return (i) iVar;
    }

    public AppLovinSdk r0() {
        return this.f7113m;
    }

    public String s() {
        return p0().b();
    }

    public boolean s0() {
        return this.f7112l0;
    }

    public AppLovinSdkConfiguration t() {
        return this.f7122q0;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f7089a + "', enabled=" + this.f7108j0 + ", isFirstSession=" + this.f7110k0 + '}';
    }

    public com.applovin.impl.m0 u() {
        Object m0Var = this.f7129u.get();
        if (m0Var == null) {
            synchronized (this.f7129u) {
                m0Var = this.f7129u.get();
                if (m0Var == null) {
                    m0Var = new com.applovin.impl.m0(this);
                    this.f7129u.set(m0Var);
                }
            }
        }
        if (m0Var == this.f7129u) {
            m0Var = null;
        }
        return (com.applovin.impl.m0) m0Var;
    }

    public boolean u0() {
        boolean z10;
        synchronized (this.f7100f0) {
            z10 = this.f7108j0;
        }
        return z10;
    }

    public com.applovin.impl.p0 v() {
        Object p0Var = this.M.get();
        if (p0Var == null) {
            synchronized (this.M) {
                p0Var = this.M.get();
                if (p0Var == null) {
                    p0Var = new com.applovin.impl.p0(this);
                    this.M.set(p0Var);
                }
            }
        }
        if (p0Var == this.M) {
            p0Var = null;
        }
        return (com.applovin.impl.p0) p0Var;
    }

    public boolean v0() {
        return this.f7110k0;
    }

    public com.applovin.impl.z0 w() {
        Object z0Var = this.O.get();
        if (z0Var == null) {
            synchronized (this.O) {
                z0Var = this.O.get();
                if (z0Var == null) {
                    z0Var = new com.applovin.impl.z0(this);
                    this.O.set(z0Var);
                }
            }
        }
        if (z0Var == this.O) {
            z0Var = null;
        }
        return (com.applovin.impl.z0) z0Var;
    }

    public boolean w0() {
        boolean z10;
        synchronized (this.f7120p0) {
            z10 = this.f7118o0 != null;
        }
        return z10;
    }

    public com.applovin.impl.a1 x() {
        Object a1Var = this.R.get();
        if (a1Var == null) {
            synchronized (this.R) {
                a1Var = this.R.get();
                if (a1Var == null) {
                    a1Var = new com.applovin.impl.a1(this);
                    this.R.set(a1Var);
                }
            }
        }
        if (a1Var == this.R) {
            a1Var = null;
        }
        return (com.applovin.impl.a1) a1Var;
    }

    public boolean x0() {
        boolean z10;
        synchronized (this.f7100f0) {
            z10 = this.f7106i0;
        }
        return z10;
    }

    public k y() {
        Object kVar = this.f7133x.get();
        if (kVar == null) {
            synchronized (this.f7133x) {
                kVar = this.f7133x.get();
                if (kVar == null) {
                    kVar = new k(this);
                    this.f7133x.set(kVar);
                }
            }
        }
        if (kVar == this.f7133x) {
            kVar = null;
        }
        return (k) kVar;
    }

    public String z() {
        return this.f7116n0;
    }

    public boolean z0() {
        return StringUtils.containsIgnoreCase(O(), AppLovinMediationProvider.MAX);
    }

    private void d() {
        r5 r5VarJ0 = j0();
        int i10 = this.f7114m0 + 1;
        this.f7114m0 = i10;
        r5VarJ0.a((w4) new h5(i10, this, new a()), r5.b.CORE);
    }

    public static long m() {
        return f7087y0;
    }

    public com.applovin.impl.c e() {
        return a(f7085w0);
    }

    public com.applovin.impl.sdk.a f() {
        Object aVar = this.C.get();
        if (aVar == null) {
            synchronized (this.C) {
                aVar = this.C.get();
                if (aVar == null) {
                    aVar = new com.applovin.impl.sdk.a(this);
                    this.C.set(aVar);
                }
            }
        }
        if (aVar == this.C) {
            aVar = null;
        }
        return (com.applovin.impl.sdk.a) aVar;
    }

    public com.applovin.impl.f g() {
        return this.f7117o;
    }

    public com.applovin.impl.sdk.d h() {
        Object dVar = this.S.get();
        if (dVar == null) {
            synchronized (this.S) {
                dVar = this.S.get();
                if (dVar == null) {
                    dVar = new com.applovin.impl.sdk.d(this);
                    this.S.set(dVar);
                }
            }
        }
        if (dVar == this.S) {
            dVar = null;
        }
        return (com.applovin.impl.sdk.d) dVar;
    }

    public e i() {
        Object eVar = this.B.get();
        if (eVar == null) {
            synchronized (this.B) {
                eVar = this.B.get();
                if (eVar == null) {
                    eVar = new e(this);
                    this.B.set(eVar);
                }
            }
        }
        if (eVar == this.B) {
            eVar = null;
        }
        return (e) eVar;
    }

    public com.applovin.impl.h j() {
        Object hVar = this.V.get();
        if (hVar == null) {
            synchronized (this.V) {
                hVar = this.V.get();
                if (hVar == null) {
                    hVar = new com.applovin.impl.h(this);
                    this.V.set(hVar);
                }
            }
        }
        if (hVar == this.V) {
            hVar = null;
        }
        return (com.applovin.impl.h) hVar;
    }

    public AppLovinAdServiceImpl k() {
        Object appLovinAdServiceImpl = this.f7105i.get();
        if (appLovinAdServiceImpl == null) {
            synchronized (this.f7105i) {
                appLovinAdServiceImpl = this.f7105i.get();
                if (appLovinAdServiceImpl == null) {
                    appLovinAdServiceImpl = new AppLovinAdServiceImpl(this);
                    this.f7105i.set(appLovinAdServiceImpl);
                }
            }
        }
        if (appLovinAdServiceImpl == this.f7105i) {
            appLovinAdServiceImpl = null;
        }
        return (AppLovinAdServiceImpl) appLovinAdServiceImpl;
    }

    public g l() {
        Object gVar = this.G.get();
        if (gVar == null) {
            synchronized (this.G) {
                gVar = this.G.get();
                if (gVar == null) {
                    gVar = new g(this);
                    this.G.set(gVar);
                }
            }
        }
        if (gVar == this.G) {
            gVar = null;
        }
        return (g) gVar;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        f7085w0 = context.getApplicationContext();
        f7086x0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        this.f7095d = System.currentTimeMillis();
        com.applovin.impl.n0.c(jSONObject, this);
        com.applovin.impl.n0.b(jSONObject, this);
        com.applovin.impl.n0.a(jSONObject, this);
        b3.f(jSONObject, this);
        b3.d(jSONObject, this);
        b3.e(jSONObject, this);
        b3.g(jSONObject, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration) {
        t0();
        this.f7099f.attachAppLovinSdk(this);
        String pluginVersion = appLovinSdkInitializationConfiguration.getPluginVersion();
        if (pluginVersion != null) {
            n.g("AppLovinSdk", "Setting plugin version: " + pluginVersion);
            h0().a(l4.f5761v3, pluginVersion);
        }
        if (appLovinSdkInitializationConfiguration.isExceptionHandlerEnabled() && ((Boolean) a(l4.f5734s)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        r5 r5VarJ0 = j0();
        w4 w4Var = this.f7128t0;
        r5.b bVar = r5.b.CORE;
        r5VarJ0.a(w4Var, bVar);
        j0().a(this.f7130u0, bVar);
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.f7113m = appLovinSdk;
    }

    public static String a(String str) {
        return a(str, (List) null);
    }

    public static String a(int i10) {
        return a(i10, (List) null);
    }

    public static String a(String str, List list) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context contextN = n();
        return a(contextN.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, contextN.getPackageName()), list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        I();
        if (n.a()) {
            I().a("AppLovinSdk", str);
        }
        j0().a(new q5(this));
    }

    public void c() {
        synchronized (this.f7100f0) {
            if (!this.f7106i0 && !this.f7108j0) {
                L0();
            }
        }
    }

    public static String a(int i10, List list) {
        String string = n().getResources().getString(i10);
        return list != null ? String.format(string, list.toArray()) : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        Iterator it = JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList()).iterator();
        while (it.hasNext()) {
            n.h("AppLovinSdk", (String) it.next());
        }
    }

    public static com.applovin.impl.c a(Context context) {
        if (A0 == null) {
            synchronized (B0) {
                if (A0 == null) {
                    A0 = new com.applovin.impl.c(context);
                }
            }
        }
        return A0;
    }

    class d implements n3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n3 f7139a;

        d(n3 n3Var) {
            this.f7139a = n3Var;
        }

        @Override // com.applovin.impl.n3.a
        public void a() {
            j.this.I();
            if (n.a()) {
                j.this.I().d("AppLovinSdk", "Connected to internet - re-initializing SDK");
            }
            synchronized (j.this.f7100f0) {
                if (!j.this.f7106i0) {
                    j.this.L0();
                }
            }
            this.f7139a.b(this);
        }

        @Override // com.applovin.impl.n3.a
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        if (!z6.c(this)) {
            HashMap map = new HashMap();
            map.put("details", AppLovinMediationProvider.ADMOB);
            map.put("error_message", str);
            A().a(y1.f7798o0, "adapterVersionMismatch", map);
            return;
        }
        throw new IllegalStateException(str);
    }

    public List c(l4 l4Var) {
        return h0().c(l4Var);
    }

    public void c(n4 n4Var) {
        i0().b(n4Var);
    }

    public void a(final AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration, final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        synchronized (this.f7120p0) {
            if (this.f7118o0 != null) {
                n.h("AppLovinSdk", "AppLovin SDK already initialized with configuration: " + this.f7118o0 + ". Ignoring the provided initialization configuration.");
                if (!u0() || sdkInitializationListener == null) {
                    return;
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.o0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7323a.a(sdkInitializationListener);
                    }
                });
                return;
            }
            this.f7118o0 = appLovinSdkInitializationConfiguration;
            this.f7124r0 = sdkInitializationListener;
            this.f7089a = appLovinSdkInitializationConfiguration.getSdkKey();
            this.f7103h = appLovinSdkInitializationConfiguration.getMediationProvider();
            this.f7101g = appLovinSdkInitializationConfiguration.getSegmentCollection();
            z6.a(new Runnable() { // from class: com.applovin.impl.sdk.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7327a.a(appLovinSdkInitializationConfiguration);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "Calling back publisher's initialization completion handler...");
        }
        sdkInitializationListener.onSdkInitialized(this.f7122q0);
    }

    public List b(l4 l4Var) {
        return h0().b(l4Var);
    }

    public void b(n4 n4Var, Object obj) {
        i0().b(n4Var, obj);
    }

    public Object b(n4 n4Var) {
        return i0().a(n4Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        r12 = r4.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        if (r12.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        r13 = (java.util.Map.Entry) r12.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
    
        if (r11.startsWith((java.lang.String) r13.getKey()) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
    
        r15.f7116n0 = (java.lang.String) r13.getValue();
        I();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
    
        if (com.applovin.impl.sdk.n.a() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
    
        I().a("AppLovinSdk", "Detected mediation provider: " + r15.f7116n0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
    
        if (r6.booleanValue() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
    
        r2.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
    
        r8 = java.lang.Integer.valueOf(r8.intValue() - 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b() {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.j.b():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.f7122q0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(JSONObject jSONObject) {
        List listAsList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(listAsList.size());
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            MaxAdFormat fromString = MaxAdFormat.formatFromString((String) it.next());
            if (fromString != null) {
                arrayList.add(fromString);
            }
        }
        return arrayList;
    }

    public void a(boolean z10) {
        synchronized (this.f7100f0) {
            this.f7106i0 = false;
            this.f7108j0 = z10;
        }
        if (z10) {
            List listA = l3.a(this);
            if (listA.isEmpty()) {
                j0().e();
                F0();
                return;
            }
            Long l10 = (Long) a(g3.f5249w6);
            f6 f6Var = new f6(this, true, "timeoutInitAdapters", new Runnable() { // from class: com.applovin.impl.sdk.r0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7344a.B0();
                }
            });
            I();
            if (n.a()) {
                I().a("AppLovinSdk", "Waiting for required adapters to init: " + listA + " - timing out in " + l10 + "ms...");
            }
            j0().a(f6Var, r5.b.TIMEOUT, l10.longValue(), true);
        }
    }

    public void a(a3 a3Var) {
        if (j0().d()) {
            return;
        }
        List listA = l3.a(this);
        if (listA.size() <= 0 || !L().a().containsAll(listA)) {
            return;
        }
        I();
        if (n.a()) {
            I().a("AppLovinSdk", "All required adapters initialized");
        }
        j0().e();
        F0();
    }

    public boolean a(MaxAdFormat maxAdFormat) {
        List list = this.f7098e0;
        return (list == null || list.size() <= 0 || this.f7098e0.contains(maxAdFormat)) ? false : true;
    }

    public void a() {
        String str = (String) i0().a(n4.f6383e, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE < z6.g(str)) {
                n.h("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
            }
        }
    }

    public Object a(l4 l4Var) {
        return h0().a(l4Var);
    }

    public boolean a(l4 l4Var, MaxAdFormat maxAdFormat) {
        return b(l4Var).contains(maxAdFormat);
    }

    public void a(Map map) {
        N().a(map);
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        i0().a(str, obj, editor);
    }

    public Object a(n4 n4Var) {
        return a(n4Var, (Object) null);
    }

    public Object a(n4 n4Var, Object obj) {
        return i0().a(n4Var, obj);
    }

    public Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return o4.a(str, obj, cls, sharedPreferences);
    }

    public void a(SharedPreferences sharedPreferences) {
        i0().a(sharedPreferences);
    }
}
