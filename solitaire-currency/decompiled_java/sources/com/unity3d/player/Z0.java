package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
public final class Z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a1 f24048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f24049b = false;

    public Z0(a1 a1Var) {
        this.f24048a = a1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (this.f24049b) {
            return;
        }
        int i10 = a1.A;
        this.f24048a.cancelOnPrepare();
    }
}
