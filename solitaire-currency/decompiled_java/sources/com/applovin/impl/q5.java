package com.applovin.impl;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.applovin.impl.r5;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.v8;
import io.sentry.protocol.Device;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class q5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6690g;

    public q5(com.applovin.impl.sdk.j jVar) {
        super("TaskInitializeSdk", jVar, true);
        this.f6690g = jVar;
    }

    private void f() {
        if (this.f6690g.L().c()) {
            return;
        }
        Activity activityN0 = this.f6690g.n0();
        if (activityN0 != null) {
            this.f6690g.L().a(activityN0);
            return;
        }
        this.f6690g.A().a(y1.f7774c0, this.f7678b + ":maybeInitializeAdapters()");
        this.f6690g.j0().a(new f6(this.f6690g, true, "initializeAdapters", new Runnable() { // from class: com.applovin.impl.yc
            @Override // java.lang.Runnable
            public final void run() {
                this.f7854a.e();
            }
        }), r5.b.CORE, TimeUnit.SECONDS.toMillis(1L));
    }

    private void g() {
        String str;
        boolean zC = this.f6690g.h0().c();
        Map mapN = this.f6690g.y().n();
        Map mapJ = this.f6690g.y().J();
        String strA = zC ? this.f6690g.y().f().a() : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        if (zC) {
            str = mapN.get("idfv") + " (use this for test devices)";
        } else {
            str = "<Enable verbose logging to see the App Set ID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        }
        n2 n2Var = new n2();
        n2Var.a().a("=====AppLovin SDK=====");
        n2Var.a("===SDK Versions===").a("Version", AppLovinSdk.VERSION).a("Plugin Version", this.f6690g.a(l4.f5761v3)).a("Ad Review Version", h.b()).a("OM SDK Version", this.f6690g.W().c());
        n2Var.a("===Device Info===").a("OS", z6.d()).a(IronSourceConstants.TYPE_GAID, strA).a("App Set ID", str).a(ExifInterface.TAG_MODEL, mapN.get("model")).a("Locale", mapN.get(Device.JsonKeys.LOCALE)).a("Emulator", mapN.get("sim")).a("Tablet", mapN.get("is_tablet"));
        n2Var.a("===App Info===").a("Application ID", mapJ.get(v8.h.V)).a("Target SDK", mapJ.get("target_sdk"));
        n2Var.a("===SDK Settings===").a("SDK Key", this.f6690g.b0()).a("Mediation Provider", this.f6690g.O()).a("TG", y6.a(this.f6690g)).a("MD", this.f6690g.a(l4.f5742t)).a("Test Mode On", Boolean.valueOf(this.f6690g.l0().c())).a("Verbose Logging On", Boolean.valueOf(zC));
        n2Var.a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").a(l0.a(a()));
        n2Var.a("===MAX Terms and Privcay Policy Flow===");
        p0 p0VarV = this.f6690g.v();
        boolean zJ = p0VarV.j();
        n2Var.a("Enabled", Boolean.valueOf(zJ));
        if (zJ) {
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.f6690g.t().getConsentFlowUserGeography();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyD = p0VarV.d();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography2 = AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
            String str2 = "Other";
            n2Var.a("Consent Flow Geography", consentFlowUserGeography == consentFlowUserGeography2 ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : "Unknown");
            if (z6.c(this.f6690g)) {
                if (consentFlowUserGeographyD == consentFlowUserGeography2) {
                    str2 = "GDPR";
                } else if (consentFlowUserGeography != AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER) {
                    str2 = "None";
                }
                n2Var.a("Debug User Geography", str2);
            }
        }
        n2Var.a("Privacy Policy URI", p0VarV.f()).a("Terms of Service URI", p0VarV.h());
        n2Var.a("===CMP (CONSENT MANAGEMENT PLATFORM)===").a(this.f6690g.k0().j());
        n2Var.a();
        com.applovin.impl.sdk.n.g("AppLovinSdk", n2Var.toString());
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        String str;
        com.applovin.impl.sdk.n nVar;
        String str2;
        StringBuilder sb;
        str = "succeeded";
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Initializing AppLovin SDK v" + AppLovinSdk.VERSION + "...");
        }
        try {
            this.f6690g.E().e();
            this.f6690g.E().a(v1.f7558h);
            this.f6690g.E().a(v1.f7559i);
            this.f6690g.C().b(a());
            this.f6690g.C().e(a());
            this.f6690g.j0().a((w4) new x4(this.f6690g), r5.b.OTHER);
            this.f6690g.y().T();
            this.f6690g.e0().c();
            this.f6690g.w().l();
            if (z6.c(this.f6690g)) {
                this.f6690g.a();
            }
            this.f6690g.R0();
            this.f6690g.o().collectAppHubData();
            g();
            f();
            this.f6690g.a(true);
            this.f6690g.X().b();
            this.f6690g.k().maybeFireAppKilledWhilePlayingAdPostback();
            this.f6690g.B().maybeTrackAppOpenEvent();
            this.f6690g.x().a();
            if (((Boolean) this.f6690g.a(l4.D2)).booleanValue()) {
                this.f6690g.q0().c();
            }
            if (((Boolean) this.f6690g.a(l4.Q0)).booleanValue()) {
                this.f6690g.h().b();
            } else {
                this.f6690g.h().g();
            }
            if (this.f6690g.N().g() || (((Boolean) this.f6690g.a(g3.C6)).booleanValue() && z6.c(this.f6690g) && this.f6690g.z0())) {
                this.f6690g.N().e();
            }
            if (this.f6690g.Z() != null) {
                this.f6690g.Z().b((String) this.f6690g.a(l4.f5750u));
            }
            this.f6690g.W().i();
        } catch (Throwable th) {
            try {
                com.applovin.impl.sdk.n.c("AppLovinSdk", "Failed to initialize SDK!", th);
                this.f6690g.a(false);
                a(th);
                if (((Boolean) this.f6690g.a(l4.f5654i)).booleanValue()) {
                    this.f6690g.X().a();
                }
                if (((Boolean) this.f6690g.a(l4.f5646h)).booleanValue()) {
                    this.f6690g.N0();
                }
                if (this.f6690g.Z() != null) {
                    this.f6690g.Z().b((String) this.f6690g.a(l4.f5750u));
                }
                this.f6690g.W().i();
                if (!com.applovin.impl.sdk.n.a()) {
                    return;
                }
                nVar = this.f7679c;
                str2 = this.f7678b;
                sb = new StringBuilder();
                sb.append("AppLovin SDK ");
                sb.append(AppLovinSdk.VERSION);
                sb.append(" initialization ");
                if (!this.f6690g.u0()) {
                }
            } catch (Throwable th2) {
                if (this.f6690g.Z() != null) {
                    this.f6690g.Z().b((String) this.f6690g.a(l4.f5750u));
                }
                this.f6690g.W().i();
                if (com.applovin.impl.sdk.n.a()) {
                    com.applovin.impl.sdk.n nVar2 = this.f7679c;
                    String str3 = this.f7678b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("AppLovin SDK ");
                    sb2.append(AppLovinSdk.VERSION);
                    sb2.append(" initialization ");
                    sb2.append(this.f6690g.u0() ? "succeeded" : v8.h.f15817t);
                    sb2.append(" in ");
                    sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    sb2.append("ms");
                    nVar2.a(str3, sb2.toString());
                }
                throw th2;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            nVar = this.f7679c;
            str2 = this.f7678b;
            sb = new StringBuilder();
            sb.append("AppLovin SDK ");
            sb.append(AppLovinSdk.VERSION);
            sb.append(" initialization ");
            if (!this.f6690g.u0()) {
                str = v8.h.f15817t;
            }
            sb.append(str);
            sb.append(" in ");
            sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb.append("ms");
            nVar.a(str2, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f6690g.L().a(this.f6690g.e().b());
    }
}
