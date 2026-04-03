package com.unity3d.scar.adapter.common;

/* JADX INFO: compiled from: DispatchGroup.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24231a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f24232b;

    private void d() {
        Runnable runnable;
        if (this.f24231a > 0 || (runnable = this.f24232b) == null) {
            return;
        }
        runnable.run();
    }

    public synchronized void a() {
        this.f24231a++;
    }

    public synchronized void b() {
        this.f24231a--;
        d();
    }

    public void c(Runnable runnable) {
        this.f24232b = runnable;
        d();
    }
}
