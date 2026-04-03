package com.king.usdk.adinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Keep;
import com.king.installreferrer.KingInstallReferrerClient;
import com.king.installreferrer.KingInstallReferrerDetails;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class ReferrerProvider {
    private static final long NO_CALLER_USER_DATA = 0;
    private static final long RETRY_DELAY = 3000;
    private static final String TAG = "ReferrerProvider";

    @GuardedBy("ReferrerProvider.class")
    private static long callerUserData;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f17171a;

        a(Activity activity) {
            this.f17171a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            new b(this.f17171a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void SetData(long j10, int i10, String str, long j11, long j12, long j13, long j14);

    public static void clearUserData() {
        synchronized (ReferrerProvider.class) {
            callerUserData = NO_CALLER_USER_DATA;
        }
    }

    public static void startFetch(Activity activity, long j10) {
        if (activity == null) {
            return;
        }
        synchronized (ReferrerProvider.class) {
            callerUserData = j10;
        }
        activity.runOnUiThread(new a(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements b0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private KingInstallReferrerClient f17172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Looper f17173b;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.f17172a.startConnection(b.this);
                } catch (Exception unused) {
                }
            }
        }

        b(Activity activity) {
            this.f17173b = activity.getMainLooper();
            Context applicationContext = activity.getApplicationContext();
            if (applicationContext != null) {
                try {
                    KingInstallReferrerClient kingInstallReferrerClient = new KingInstallReferrerClient(applicationContext);
                    this.f17172a = kingInstallReferrerClient;
                    kingInstallReferrerClient.startConnection(this);
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i10) {
            try {
                synchronized (ReferrerProvider.class) {
                    if (ReferrerProvider.callerUserData == ReferrerProvider.NO_CALLER_USER_DATA) {
                        return;
                    }
                    Log.i(ReferrerProvider.TAG, "InstallReferrer connected");
                    KingInstallReferrerDetails installReferrer = this.f17172a.getInstallReferrer();
                    this.f17172a.endConnection();
                    ReferrerProvider.SetData(ReferrerProvider.callerUserData, i10, installReferrer.getInstallReferrer(), installReferrer.getInstallBeginTimestampSeconds(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginServerTimestampSeconds(), installReferrer.getReferrerClickServerTimestampSeconds());
                }
            } catch (RemoteException e10) {
                Log.w(ReferrerProvider.TAG, "RemoteException when getting install referrer.", e10);
            }
        }

        @Override // b0.a
        public void a(final int i10) {
            synchronized (ReferrerProvider.class) {
                if (i10 == -1) {
                    Log.w(ReferrerProvider.TAG, "Service disconnected, retrying");
                    new Handler(this.f17173b).postDelayed(new a(), 3000L);
                } else if (i10 == 0) {
                    new Thread(new Runnable() { // from class: com.king.usdk.adinfo.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f17175a.e(i10);
                        }
                    }).start();
                } else if (i10 == 1) {
                    Log.w(ReferrerProvider.TAG, "Unable to connect to the service");
                    ReferrerProvider.SetData(ReferrerProvider.callerUserData, i10, "", -1L, -1L, -1L, -1L);
                } else if (i10 == 2) {
                    Log.w(ReferrerProvider.TAG, "InstallReferrer not supported");
                    ReferrerProvider.SetData(ReferrerProvider.callerUserData, i10, "", -1L, -1L, -1L, -1L);
                } else if (i10 != 3) {
                    Log.w(ReferrerProvider.TAG, "responseCode not found.");
                    ReferrerProvider.SetData(ReferrerProvider.callerUserData, i10, "", -1L, -1L, -1L, -1L);
                } else {
                    Log.w(ReferrerProvider.TAG, "Developer error");
                    ReferrerProvider.SetData(ReferrerProvider.callerUserData, i10, "", -1L, -1L, -1L, -1L);
                }
            }
        }

        @Override // b0.a
        public void b() {
        }
    }
}
