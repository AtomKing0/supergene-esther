package com.ironsource;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class l implements hu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f12940a;

    public l(Activity activity) {
        this.f12940a = new WeakReference<>(activity);
    }

    @Override // com.ironsource.hu
    public void a() {
        Activity activity = this.f12940a.get();
        if (activity == null) {
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        Window window = activity.getWindow();
        if (i10 < 30) {
            window.setFlags(1024, 1024);
            return;
        }
        WindowInsetsController windowInsetsController = window.getDecorView().getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsets.Type.statusBars());
        }
    }
}
