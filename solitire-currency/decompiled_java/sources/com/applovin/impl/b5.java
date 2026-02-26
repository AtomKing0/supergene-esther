package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.a7;
import com.applovin.impl.i7;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class b5 extends z4 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a7 f4904l;

    public b5(a7 a7Var, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", a7Var, jVar, appLovinAdLoadListener);
        this.f4904l = a7Var;
    }

    private String d(String str) {
        for (String str2 : StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f7677a.a(l4.C4)), 1)) {
            if (!TextUtils.isEmpty(str2)) {
                Uri uriA = a(str2, Collections.emptyList(), false);
                if (uriA != null) {
                    str = str.replace(str2, uriA.toString());
                    this.f7894g.a(uriA);
                } else if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "Failed to cache JavaScript resource: " + str2);
                }
            }
        }
        return str;
    }

    private void l() {
        if (k()) {
            return;
        }
        if (!this.f4904l.t1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Companion ad caching disabled. Skipping...");
                return;
            }
            return;
        }
        d7 d7VarF1 = this.f4904l.f1();
        if (d7VarF1 == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "No companion ad provided. Skipping...");
                return;
            }
            return;
        }
        i7 i7VarE = d7VarF1.e();
        if (i7VarE == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Failed to retrieve non-video resources from companion ad. Skipping...");
                return;
            }
            return;
        }
        Uri uriC = i7VarE.c();
        String string = uriC != null ? uriC.toString() : "";
        String strB = i7VarE.b();
        if (!URLUtil.isValidUrl(string) && !StringUtils.isValidString(strB)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.k(this.f7678b, "Companion ad does not have any resources attached. Skipping...");
                return;
            }
            return;
        }
        if (i7VarE.d() == i7.a.STATIC) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Caching static companion ad at " + string + "...");
            }
            Uri uriA = a(string, Collections.emptyList(), false);
            if (uriA != null) {
                i7VarE.a(uriA);
                this.f4904l.b(true);
                return;
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f7679c.b(this.f7678b, "Failed to cache static companion ad");
                    return;
                }
                return;
            }
        }
        if (i7VarE.d() != i7.a.HTML) {
            if (i7VarE.d() == i7.a.IFRAME && com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Skip caching of iFrame resource...");
                return;
            }
            return;
        }
        if (!StringUtils.isValidString(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strB);
            }
            if (((Boolean) this.f7677a.a(l4.B4)).booleanValue()) {
                strB = d(strB);
            }
            i7VarE.a(a(strB, Collections.emptyList(), this.f4904l));
            this.f4904l.b(true);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Begin caching HTML companion ad. Fetching from " + string + "...");
        }
        String strC = c(string, null, false);
        if (StringUtils.isValidString(strC)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "HTML fetched. Caching HTML now...");
            }
            i7VarE.a(a(strC, Collections.emptyList(), this.f4904l));
            this.f4904l.b(true);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Unable to load companion ad resources from " + string);
        }
    }

    private void m() {
        if (k() || !m7.a(this.f4904l)) {
            return;
        }
        String strH1 = this.f4904l.h1();
        if (!StringUtils.isValidString(strH1)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Unable to load HTML template");
                return;
            }
            return;
        }
        String strA = a(strH1, this.f4904l.W(), this.f7894g);
        if (this.f4904l.isOpenMeasurementEnabled()) {
            strA = this.f7677a.W().a(strA);
        }
        this.f4904l.b(strA);
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Finish caching HTML template " + this.f4904l.h1() + " for ad #" + this.f4904l.getAdIdNumber());
        }
    }

    private void n() {
        o7 o7VarP1;
        Uri uriE;
        if (k()) {
            return;
        }
        if (!this.f4904l.u1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Video caching disabled. Skipping...");
                return;
            }
            return;
        }
        if (this.f4904l.o1() == null || (o7VarP1 = this.f4904l.p1()) == null || (uriE = o7VarP1.e()) == null) {
            return;
        }
        Uri uriB = b(uriE.toString(), Collections.emptyList(), false);
        if (uriB != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Video file successfully cached into: " + uriB);
            }
            o7VarP1.a(uriB);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Failed to cache video file: " + o7VarP1);
        }
    }

    @Override // com.applovin.impl.z4
    void a(int i10) {
        this.f4904l.getAdEventTracker().f();
        super.a(i10);
    }

    @Override // com.applovin.impl.z4
    void e() {
        this.f4904l.getAdEventTracker().h();
        super.e();
    }

    @Override // com.applovin.impl.z4, java.lang.Runnable
    public void run() {
        super.run();
        boolean zH0 = this.f4904l.H0();
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVar = this.f7679c;
            String str = this.f7678b;
            StringBuilder sb = new StringBuilder();
            sb.append("Begin caching for VAST ");
            sb.append(zH0 ? "streaming " : "");
            sb.append("ad #");
            sb.append(this.f7894g.getAdIdNumber());
            sb.append("...");
            nVar.a(str, sb.toString());
        }
        if (zH0) {
            i();
            if (this.f4904l.r1()) {
                e();
            }
            a7.c cVarI1 = this.f4904l.i1();
            a7.c cVar = a7.c.COMPANION_AD;
            if (cVarI1 == cVar) {
                l();
                m();
                a(this.f4904l);
            } else {
                n();
            }
            if (!this.f4904l.r1()) {
                e();
            }
            if (this.f4904l.i1() == cVar) {
                n();
            } else {
                l();
                m();
                a(this.f4904l);
            }
        } else {
            i();
            l();
            n();
            m();
            a(this.f4904l);
            e();
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Finished caching VAST ad #" + this.f4904l.getAdIdNumber());
        }
        this.f4904l.s1();
        j();
    }
}
