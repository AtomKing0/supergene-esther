package com.applovin.impl;

import com.applovin.impl.t;

/* JADX INFO: loaded from: classes2.dex */
public class c5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f4958g;

    public interface a {
        void a(t.a aVar);
    }

    public c5(com.applovin.impl.sdk.j jVar, a aVar) {
        super("TaskCollectAdvertisingId", jVar, true);
        this.f4958g = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4958g.a(this.f7677a.y().f());
    }
}
