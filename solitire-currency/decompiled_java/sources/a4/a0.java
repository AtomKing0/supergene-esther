package a4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.autofill.HintConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: NetworkTypeObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private static a0 f132e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f133a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<WeakReference<c>> f134b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f135c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("networkTypeLock")
    private int f136d = 0;

    /* JADX INFO: compiled from: NetworkTypeObserver.java */
    @RequiresApi(31)
    private static final class b {

        /* JADX INFO: compiled from: NetworkTypeObserver.java */
        private static final class a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final a0 f137a;

            public a(a0 a0Var) {
                this.f137a = a0Var;
            }

            @Override // android.telephony.TelephonyCallback.DisplayInfoListener
            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f137a.k(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }

        public static void a(Context context, a0 a0Var) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) a4.a.e((TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE));
                a aVar = new a(a0Var);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), aVar);
                telephonyManager.unregisterTelephonyCallback(aVar);
            } catch (RuntimeException unused) {
                a0Var.k(5);
            }
        }
    }

    /* JADX INFO: compiled from: NetworkTypeObserver.java */
    public interface c {
        void onNetworkTypeChanged(int i10);
    }

    /* JADX INFO: compiled from: NetworkTypeObserver.java */
    private final class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iG = a0.g(context);
            if (o0.f214a < 31 || iG != 5) {
                a0.this.k(iG);
            } else {
                b.a(context, a0.this);
            }
        }
    }

    private a0(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        o0.E0(context, new d(), intentFilter);
    }

    public static synchronized a0 d(Context context) {
        if (f132e == null) {
            f132e = new a0(context);
        }
        return f132e;
    }

    private static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return o0.f214a >= 29 ? 9 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i10 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i10 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (type != 4 && type != 5) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(c cVar) {
        cVar.onNetworkTypeChanged(f());
    }

    private void j() {
        for (WeakReference<c> weakReference : this.f134b) {
            if (weakReference.get() == null) {
                this.f134b.remove(weakReference);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i10) {
        synchronized (this.f135c) {
            if (this.f136d == i10) {
                return;
            }
            this.f136d = i10;
            for (WeakReference<c> weakReference : this.f134b) {
                c cVar = weakReference.get();
                if (cVar != null) {
                    cVar.onNetworkTypeChanged(i10);
                } else {
                    this.f134b.remove(weakReference);
                }
            }
        }
    }

    public int f() {
        int i10;
        synchronized (this.f135c) {
            i10 = this.f136d;
        }
        return i10;
    }

    public void i(final c cVar) {
        j();
        this.f134b.add(new WeakReference<>(cVar));
        this.f133a.post(new Runnable() { // from class: a4.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f289a.h(cVar);
            }
        });
    }
}
