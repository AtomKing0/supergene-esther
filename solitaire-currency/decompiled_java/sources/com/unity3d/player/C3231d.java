package com.unity3d.player;

import android.window.OnBackInvokedCallback;

/* JADX INFO: renamed from: com.unity3d.player.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3231d implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ y6.c f24086a;

    C3231d(y6.c cVar) {
        this.f24086a = cVar;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        Runnable runnable = ((B) this.f24086a).f23916a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
