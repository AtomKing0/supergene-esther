package com.unity3d.player;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes4.dex */
final class Z implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3230c0 f24047a;

    Z(C3230c0 c3230c0) {
        this.f24047a = c3230c0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f24047a.reportSoftInputArea();
        this.f24047a.f24084h.b();
    }
}
