package com.applovin.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.r5;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class y4 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f7836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Activity f7837h;

    public y4(List list, Activity activity, com.applovin.impl.sdk.j jVar) {
        super("TaskAutoInitAdapters", jVar, true);
        this.f7836g = list;
        this.f7837h = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a3 a3Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Auto-initing adapter: " + a3Var);
        }
        this.f7677a.L().a(a3Var, this.f7837h);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7836g.size() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f7679c;
                String str = this.f7678b;
                StringBuilder sb = new StringBuilder();
                sb.append("Auto-initing ");
                sb.append(this.f7836g.size());
                sb.append(" adapters");
                sb.append(this.f7677a.l0().c() ? " in test mode" : "");
                sb.append("...");
                nVar.a(str, sb.toString());
            }
            if (TextUtils.isEmpty(this.f7677a.O())) {
                this.f7677a.I0();
            } else if (!this.f7677a.z0()) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.f7677a.O());
            }
            if (this.f7837h == null) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
            }
            for (final a3 a3Var : this.f7836g) {
                if (a3Var.s()) {
                    this.f7677a.j0().a(new Runnable() { // from class: com.applovin.impl.gf
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5290a.a(a3Var);
                        }
                    }, r5.b.MEDIATION);
                } else {
                    this.f7677a.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f7677a.I().a(this.f7678b, "Skipping eager auto-init for adapter " + a3Var);
                    }
                }
            }
        }
    }
}
