package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
class C {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Runnable f23919b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected y6.c f23918a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f23920c = true;

    protected C(Runnable runnable) {
        this.f23919b = runnable;
    }

    protected void registerOnBackPressedCallback() {
        if (this.f23918a != null) {
            return;
        }
        this.f23918a = new B(this.f23919b);
    }

    protected void unregisterOnBackPressedCallback() {
        this.f23918a = null;
    }
}
