package com.king.usdk.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class UrlLauncher {
    private static final String TAG = "com.king.usdk.urllauncher.UrlLauncher";

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f17289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f17290b;

        a(Activity activity, Intent intent) {
            this.f17289a = activity;
            this.f17290b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f17289a.startActivity(this.f17290b);
            } catch (ActivityNotFoundException e10) {
                Log.e(UrlLauncher.TAG, "Failed to start activity for intent", e10);
            }
        }
    }

    public static boolean launchUrl(Activity activity, String str) {
        String str2 = TAG;
        Log.i(str2, "launchUrl " + str);
        if (activity != null && str != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            activity.getApplicationContext().getPackageManager();
            activity.runOnUiThread(new a(activity, intent));
            return true;
        }
        Log.i(str2, "Failed to start activity for intent, activity: " + activity + " url:" + str);
        return false;
    }
}
