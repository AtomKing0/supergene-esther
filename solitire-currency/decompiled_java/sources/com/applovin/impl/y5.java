package com.applovin.impl;

import com.applovin.impl.a7;
import com.applovin.impl.r5;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
class y5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e7 f7838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppLovinAdLoadListener f7839h;

    y5(e7 e7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskRenderVastAd", jVar);
        this.f7839h = appLovinAdLoadListener;
        this.f7838g = e7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Rendering VAST ad...");
        }
        int size = this.f7838g.a().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String strA = "";
        j7 j7VarA = null;
        n7 n7VarA = null;
        d7 d7VarA = null;
        c7 c7VarA = null;
        String strA2 = "";
        for (b8 b8Var : this.f7838g.a()) {
            b8 b8VarB = b8Var.b(m7.b(b8Var) ? "Wrapper" : "InLine");
            if (b8VarB != null) {
                b8 b8VarB2 = b8VarB.b("AdSystem");
                if (b8VarB2 != null) {
                    j7VarA = j7.a(b8VarB2, j7VarA, this.f7677a);
                }
                strA = m7.a(b8VarB, "AdTitle", strA);
                strA2 = m7.a(b8VarB, "Description", strA2);
                m7.a(b8VarB.a("Impression"), hashSet, this.f7838g, this.f7677a);
                b8 b8VarC = b8VarB.c("ViewableImpression");
                if (b8VarC != null) {
                    m7.a(b8VarC.a("Viewable"), hashSet, this.f7838g, this.f7677a);
                }
                b8 b8VarB3 = b8VarB.b("AdVerifications");
                if (b8VarB3 != null) {
                    c7VarA = c7.a(b8VarB3, c7VarA, this.f7838g, this.f7677a);
                }
                m7.a(b8VarB.a("Error"), hashSet2, this.f7838g, this.f7677a);
                b8 b8VarC2 = b8VarB.c("Creatives");
                if (b8VarC2 != null) {
                    for (b8 b8Var2 : b8VarC2.b()) {
                        b8 b8VarC3 = b8Var2.c("Linear");
                        if (b8VarC3 != null) {
                            n7VarA = n7.a(b8VarC3, n7VarA, this.f7838g, this.f7677a);
                        } else {
                            b8 b8VarB4 = b8Var2.b("CompanionAds");
                            if (b8VarB4 != null) {
                                b8 b8VarB5 = b8VarB4.b("Companion");
                                if (b8VarB5 != null) {
                                    d7VarA = d7.a(b8VarB5, d7VarA, this.f7838g, this.f7677a);
                                }
                            } else if (com.applovin.impl.sdk.n.a()) {
                                this.f7679c.b(this.f7678b, "Received and will skip rendering for an unidentified creative: " + b8Var2);
                            }
                        }
                    }
                }
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Did not find wrapper or inline response for node: " + b8Var);
            }
        }
        a7 a7VarA = new a7.b().a(this.f7677a).a(this.f7838g.b()).b(this.f7838g.e()).a(this.f7838g.c()).b(strA).a(strA2).a(j7VarA).a(n7VarA).a(d7VarA).a(c7VarA).b(hashSet).a(c7VarA).a(hashSet2).a();
        f7 f7VarC = m7.c(a7VarA);
        if (f7VarC != null) {
            m7.a(this.f7838g, this.f7839h, f7VarC, -6, this.f7677a);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Finished rendering VAST ad: " + a7VarA);
        }
        a7VarA.getAdEventTracker().e();
        this.f7677a.j0().a((w4) new b5(a7VarA, this.f7677a, this.f7839h), r5.b.CACHING);
    }
}
