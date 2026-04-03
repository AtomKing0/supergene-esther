package com.ironsource;

import android.content.Context;
import com.ironsource.cr;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.r0;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class pi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final pi f14343a = new pi();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final dh f14344b = new dh();

    public static final class b implements hq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f14345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ta f14346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ InitListener f14347c;

        b(Context context, ta taVar, InitListener initListener) {
            this.f14345a = context;
            this.f14346b = taVar;
            this.f14347c = initListener;
        }

        @Override // com.ironsource.hq
        public void a(@NotNull bq sdkConfig) {
            kotlin.jvm.internal.t.i(sdkConfig, "sdkConfig");
            pi.f14343a.a(this.f14345a, sdkConfig.d(), this.f14346b, this.f14347c);
        }

        @Override // com.ironsource.hq
        public void a(@NotNull dq error) {
            kotlin.jvm.internal.t.i(error, "error");
            pi.f14343a.a(this.f14347c, this.f14346b, error);
        }
    }

    private pi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, cr crVar, ta taVar, InitListener initListener) {
        String strU = com.ironsource.mediationsdk.p.m().u();
        vg vgVarF = crVar.f();
        kotlin.jvm.internal.t.h(vgVarF, "serverResponse.initialConfiguration");
        NetworkSettings networkSettingsB = crVar.k().b("IronSource");
        kotlin.jvm.internal.t.h(networkSettingsB, "serverResponse.providerS…s.IRONSOURCE_CONFIG_NAME)");
        JSONObject interstitialSettings = networkSettingsB.getInterstitialSettings();
        kotlin.jvm.internal.t.h(interstitialSettings, "networkSettings.interstitialSettings");
        vgVarF.a(new r0.a(interstitialSettings));
        vgVarF.a(ConfigFile.getConfigFile().getPluginType());
        vgVarF.b(strU);
        new t0(new jm()).a(context, vgVarF, new a());
        a(crVar, taVar, initListener);
    }

    public final void a(@NotNull final Context context, @NotNull final InitRequest initRequest, @NotNull final InitListener initializationListener) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(initRequest, "initRequest");
        kotlin.jvm.internal.t.i(initializationListener, "initializationListener");
        f14344b.a(new Runnable() { // from class: com.ironsource.qz
            @Override // java.lang.Runnable
            public final void run() {
                pi.a(initRequest, context, initializationListener);
            }
        });
    }

    private final void a(cr crVar, ta taVar, final InitListener initListener) {
        c4 c4VarD;
        t3 t3VarB = crVar.c().b();
        new fl().a((t3VarB == null || (c4VarD = t3VarB.d()) == null) ? null : c4VarD.b(), true);
        String sessionId = com.ironsource.mediationsdk.p.m().u();
        cm cmVarA = cm.f11590e.a();
        cmVarA.a(crVar.k());
        cmVarA.a(crVar.c());
        kotlin.jvm.internal.t.h(sessionId, "sessionId");
        cmVarA.a(sessionId);
        cmVarA.g();
        long jA = ta.a(taVar);
        dh dhVar = f14344b;
        cr.a aVarH = crVar.h();
        kotlin.jvm.internal.t.h(aVarH, "serverResponse.origin");
        dhVar.a(jA, aVarH);
        dhVar.b(new Runnable() { // from class: com.ironsource.sz
            @Override // java.lang.Runnable
            public final void run() {
                pi.a(initListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitListener initListener) {
        if (initListener != null) {
            initListener.onInitSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitListener initListener, dq error) {
        kotlin.jvm.internal.t.i(error, "$error");
        if (initListener != null) {
            initListener.onInitFailed(f14344b.a(error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final InitListener initListener, ta taVar, final dq dqVar) {
        long jA = ta.a(taVar);
        dh dhVar = f14344b;
        dhVar.a(dqVar, jA);
        dhVar.b(new Runnable() { // from class: com.ironsource.rz
            @Override // java.lang.Runnable
            public final void run() {
                pi.a(initListener, dqVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitRequest initRequest, Context context, InitListener initializationListener) {
        kotlin.jvm.internal.t.i(initRequest, "$initRequest");
        kotlin.jvm.internal.t.i(context, "$context");
        kotlin.jvm.internal.t.i(initializationListener, "$initializationListener");
        ta taVar = new ta();
        pq.f14391a.c(context, new iq(initRequest.getAppKey(), null, kotlin.collections.p.q0(f14344b.a(initRequest.getLegacyAdFormats())), 2, null), new b(context, taVar, initializationListener));
    }

    public static final class a implements InitListener {
        a() {
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitFailed(@NotNull IronSourceError error) {
            kotlin.jvm.internal.t.i(error, "error");
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitSuccess() {
        }
    }
}
