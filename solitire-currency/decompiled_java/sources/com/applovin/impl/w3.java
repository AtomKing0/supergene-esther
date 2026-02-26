package com.applovin.impl;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.adsession.Partner;
import com.ironsource.v8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class w3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f7675b = com.applovin.impl.sdk.j.n();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7676c;

    public w3(com.applovin.impl.sdk.j jVar) {
        this.f7674a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.f7676c != null) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f7675b.getResources().openRawResource(R.raw.omsdk_v1_5_3)));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            this.f7676c = sb.toString();
                            bufferedReader.close();
                            return;
                        }
                        sb.append(line);
                    }
                } catch (Throwable th) {
                    try {
                        Log.e("OpenMeasurementService", "Failed to load JavaScript Open Measurement SDK", th);
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e10);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e11) {
                Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e11);
            }
        } catch (Throwable th3) {
            this.f7674a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f7674a.I().a("OpenMeasurementService", "Failed to retrieve resource omsdk_v1_5_3.js", th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Omid.activate(this.f7675b);
        this.f7674a.I();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVarI = this.f7674a.I();
            StringBuilder sb = new StringBuilder();
            sb.append("Init ");
            sb.append(d() ? "succeeded" : v8.h.f15817t);
            sb.append(" and took ");
            sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb.append("ms");
            nVarI.a("OpenMeasurementService", sb.toString());
        }
        h();
    }

    private void h() {
        this.f7674a.j0().a((w4) new f6(this.f7674a, "OpenMeasurementService", new Runnable() { // from class: com.applovin.impl.je
            @Override // java.lang.Runnable
            public final void run() {
                this.f5506a.f();
            }
        }), r5.b.OTHER);
    }

    public String c() {
        return Omid.getVersion();
    }

    public boolean d() {
        return Omid.isActive();
    }

    public boolean e() {
        String str = this.f7674a.g0().getExtraParameters().get("enable_omsdk_testing");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    public void i() {
        if (((Boolean) this.f7674a.a(l4.f5623e0)).booleanValue()) {
            this.f7674a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f7674a.I().a("OpenMeasurementService", "Initializing Open Measurement SDK v" + c() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ie
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5409a.g();
                }
            });
        }
    }

    public String a() {
        return this.f7676c;
    }

    public Partner b() {
        return Partner.createPartner((String) this.f7674a.a(l4.f5631f0), AppLovinSdk.VERSION);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = r4.e()     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L17
            com.applovin.impl.sdk.j r0 = r4.f7674a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r0 = com.applovin.impl.x3.a(r0)     // Catch: java.lang.Throwable -> L1f
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L17
            java.lang.String r0 = com.iab.omid.library.applovin.ScriptInjector.injectScriptContentIntoHtml(r0, r5)     // Catch: java.lang.Throwable -> L1f
            goto L18
        L17:
            r0 = r5
        L18:
            java.lang.String r1 = r4.f7676c     // Catch: java.lang.Throwable -> L1f
            java.lang.String r5 = com.iab.omid.library.applovin.ScriptInjector.injectScriptContentIntoHtml(r1, r0)     // Catch: java.lang.Throwable -> L1f
            return r5
        L1f:
            r0 = move-exception
            com.applovin.impl.sdk.j r1 = r4.f7674a
            r1.I()
            boolean r1 = com.applovin.impl.sdk.n.a()
            if (r1 == 0) goto L38
            com.applovin.impl.sdk.j r1 = r4.f7674a
            com.applovin.impl.sdk.n r1 = r1.I()
            java.lang.String r2 = "OpenMeasurementService"
            java.lang.String r3 = "Failed to inject JavaScript SDK into HTML"
            r1.a(r2, r3, r0)
        L38:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.w3.a(java.lang.String):java.lang.String");
    }
}
