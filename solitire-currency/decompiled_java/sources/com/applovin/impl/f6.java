package com.applovin.impl;

/* JADX INFO: loaded from: classes2.dex */
public class f6 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f5190g;

    public f6(com.applovin.impl.sdk.j jVar, String str, Runnable runnable) {
        this(jVar, false, str, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5190g.run();
    }

    public f6(com.applovin.impl.sdk.j jVar, boolean z10, String str, Runnable runnable) {
        super("TaskRunnable:" + str, jVar, z10);
        this.f5190g = runnable;
    }
}
