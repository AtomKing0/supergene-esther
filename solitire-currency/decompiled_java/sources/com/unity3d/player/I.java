package com.unity3d.player;

import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
final class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IPermissionRequestCallbacks f23944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23947d;

    I(IPermissionRequestCallbacks iPermissionRequestCallbacks, String str, int i10, boolean z10) {
        this.f23944a = iPermissionRequestCallbacks;
        this.f23945b = str;
        this.f23946c = i10;
        this.f23947d = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f23946c;
        if (i10 != -1) {
            if (i10 == 0) {
                this.f23944a.onPermissionGranted(this.f23945b);
            }
        } else if (Build.VERSION.SDK_INT >= 30 || this.f23947d) {
            this.f23944a.onPermissionDenied(this.f23945b);
        } else {
            this.f23944a.onPermissionDeniedAndDontAskAgain(this.f23945b);
        }
    }
}
