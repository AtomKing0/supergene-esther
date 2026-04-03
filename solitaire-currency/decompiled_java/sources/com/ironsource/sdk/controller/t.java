package com.ironsource.sdk.controller;

import android.app.Activity;
import android.media.AudioManager;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.ve;

/* JADX INFO: loaded from: classes4.dex */
class t {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioManager f15128a;

        a(AudioManager audioManager) {
            this.f15128a = audioManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.a(this.f15128a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioManager f15129a;

        b(AudioManager audioManager) {
            this.f15129a = audioManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.d(this.f15129a);
        }
    }

    t() {
    }

    public static void a(Activity activity) {
        ve.f15889a.b(new a((AudioManager) activity.getSystemService("audio")));
    }

    public static void b(Activity activity) {
        ve.f15889a.b(new b((AudioManager) activity.getSystemService("audio")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(AudioManager audioManager) {
        try {
            audioManager.requestAudioFocus(null, 3, 2);
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AudioManager audioManager) {
        try {
            audioManager.abandonAudioFocus(null);
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }
}
