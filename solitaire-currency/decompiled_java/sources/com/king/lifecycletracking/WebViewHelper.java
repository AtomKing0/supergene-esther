package com.king.lifecycletracking;

import android.app.Activity;
import android.webkit.WebView;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class WebViewHelper {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f17117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f17118b;

        a(Activity activity, long j10) {
            this.f17117a = activity;
            this.f17118b = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String userAgentString;
            try {
                userAgentString = new WebView(this.f17117a).getSettings().getUserAgentString();
            } catch (Exception unused) {
                userAgentString = "";
            }
            WebViewHelper.nativeUserAgentRetrievedCb(this.f17118b, userAgentString);
        }
    }

    public static void getUserAgent(Activity activity, long j10) {
        activity.runOnUiThread(new a(activity, j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeUserAgentRetrievedCb(long j10, String str);
}
