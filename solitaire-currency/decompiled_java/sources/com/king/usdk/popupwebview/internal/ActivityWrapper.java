package com.king.usdk.popupwebview.internal;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
@Keep
final class ActivityWrapper {
    private volatile WeakReference<Activity> weakActivity;

    ActivityWrapper(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("invalid null activity");
        }
        this.weakActivity = new WeakReference<>(activity);
    }

    @UiThread
    public WebView createWebView() {
        Activity activity = this.weakActivity.get();
        if (activity == null || activity.isDestroyed()) {
            return null;
        }
        return new WebView(activity);
    }

    @UiThread
    public View getActivityDecorView() {
        Window window;
        Activity activity = this.weakActivity.get();
        if (activity == null || activity.isDestroyed() || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView();
    }

    public void runOnUIThread(Runnable runnable) {
        Activity activity;
        if (runnable == null || (activity = this.weakActivity.get()) == null) {
            return;
        }
        activity.runOnUiThread(runnable);
    }

    public void updateActivity(Activity activity) {
        if (activity != null) {
            this.weakActivity = new WeakReference<>(activity);
        }
    }
}
