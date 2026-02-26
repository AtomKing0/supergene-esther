package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f7023b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f7025d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f7026e = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f7024c = new Object();

    e(j jVar) {
        this.f7022a = jVar;
        this.f7023b = jVar.I();
        for (com.applovin.impl.s sVar : com.applovin.impl.s.a()) {
            this.f7025d.put(sVar, new p());
            this.f7026e.put(sVar, new p());
        }
    }

    private p c(com.applovin.impl.s sVar) {
        synchronized (this.f7024c) {
            p pVarB = b(sVar);
            if (pVarB.b() > 0) {
                return pVarB;
            }
            return d(sVar);
        }
    }

    private p d(com.applovin.impl.s sVar) {
        p pVar;
        synchronized (this.f7024c) {
            pVar = (p) this.f7025d.get(sVar);
            if (pVar == null) {
                pVar = new p();
                this.f7025d.put(sVar, pVar);
            }
        }
        return pVar;
    }

    void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f7024c) {
            d(appLovinAdImpl.getAdZone()).a(appLovinAdImpl);
            if (n.a()) {
                this.f7023b.a("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
            }
        }
    }

    public void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f7024c) {
            c(appLovinAdImpl.getAdZone()).b(appLovinAdImpl);
        }
    }

    public AppLovinAdImpl e(com.applovin.impl.s sVar) {
        com.applovin.impl.sdk.ad.c cVar;
        synchronized (this.f7024c) {
            p pVarD = d(sVar);
            if (pVarD.b() > 0) {
                b(sVar).a(pVarD.a());
                cVar = new com.applovin.impl.sdk.ad.c(sVar, this.f7022a);
            } else {
                cVar = null;
            }
        }
        if (cVar != null) {
            if (n.a()) {
                this.f7023b.a("AdPreloadManager", "Retrieved ad of zone " + sVar + "...");
            }
        } else if (n.a()) {
            this.f7023b.a("AdPreloadManager", "Unable to retrieve ad of zone " + sVar + "...");
        }
        return cVar;
    }

    public AppLovinAdBase f(com.applovin.impl.s sVar) {
        AppLovinAdImpl appLovinAdImplD;
        synchronized (this.f7024c) {
            appLovinAdImplD = c(sVar).d();
        }
        return appLovinAdImplD;
    }

    private p b(com.applovin.impl.s sVar) {
        p pVar;
        synchronized (this.f7024c) {
            pVar = (p) this.f7026e.get(sVar);
            if (pVar == null) {
                pVar = new p();
                this.f7026e.put(sVar, pVar);
            }
        }
        return pVar;
    }

    public AppLovinAdImpl a(com.applovin.impl.s sVar) {
        AppLovinAdImpl appLovinAdImplA;
        synchronized (this.f7024c) {
            appLovinAdImplA = c(sVar).a();
        }
        return appLovinAdImplA;
    }
}
