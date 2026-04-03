package com.king.usdk.popupguard.internal;

import android.app.Activity;
import androidx.annotation.Keep;
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

    public Activity getActivity() {
        return this.weakActivity.get();
    }

    public void runOnUIThread(Runnable runnable) {
        Activity activity;
        if (runnable == null || (activity = this.weakActivity.get()) == null) {
            return;
        }
        activity.runOnUiThread(runnable);
    }
}
