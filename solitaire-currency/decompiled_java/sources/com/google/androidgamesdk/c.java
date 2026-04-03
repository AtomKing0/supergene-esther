package com.google.androidgamesdk;

import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwappyDisplayManager f9969b;

    c(SwappyDisplayManager swappyDisplayManager, int i10) {
        this.f9969b = swappyDisplayManager;
        this.f9968a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Window window = this.f9969b.mActivity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.preferredDisplayModeId = this.f9968a;
        window.setAttributes(attributes);
    }
}
