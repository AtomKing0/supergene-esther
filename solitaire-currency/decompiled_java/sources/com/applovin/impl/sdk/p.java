package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue f7325a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7326b = new Object();

    p() {
    }

    void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f7326b) {
            if (b() <= 25) {
                this.f7325a.offer(appLovinAdImpl);
            } else {
                n.h("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    int b() {
        int size;
        synchronized (this.f7326b) {
            size = this.f7325a.size();
        }
        return size;
    }

    boolean c() {
        boolean z10;
        synchronized (this.f7326b) {
            z10 = b() == 0;
        }
        return z10;
    }

    AppLovinAdImpl d() {
        AppLovinAdImpl appLovinAdImpl;
        synchronized (this.f7326b) {
            appLovinAdImpl = (AppLovinAdImpl) this.f7325a.peek();
        }
        return appLovinAdImpl;
    }

    void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.f7326b) {
            this.f7325a.remove(appLovinAdImpl);
        }
    }

    AppLovinAdImpl a() {
        AppLovinAdImpl appLovinAdImpl;
        synchronized (this.f7326b) {
            appLovinAdImpl = !c() ? (AppLovinAdImpl) this.f7325a.poll() : null;
        }
        return appLovinAdImpl;
    }
}
