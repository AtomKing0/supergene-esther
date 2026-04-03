package com.king.installreferrer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.ironsource.v8;
import d4.a;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class KingInstallReferrerClient {
    private static final int PLAY_STORE_MIN_APP_VER = 80837300;
    private static final String SERVICE_ACTION_NAME = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";
    private static final String SERVICE_NAME = "com.google.android.finsky.externalreferrer.GetInstallReferrerService";
    private static final String SERVICE_PACKAGE_NAME = "com.android.vending";
    private static final String TAG = "KingInstallReferrer";
    private final Context mApplicationContext;
    private int mClientState = 0;
    private d4.a mService;
    private ServiceConnection mServiceConnection;

    private final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b0.a f17110a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c0.a.a(KingInstallReferrerClient.TAG, "Install Referrer service connected.");
            KingInstallReferrerClient.this.mService = a.AbstractBinderC0538a.o(iBinder);
            KingInstallReferrerClient.this.mClientState = 2;
            this.f17110a.a(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c0.a.b(KingInstallReferrerClient.TAG, "Install Referrer service disconnected.");
            KingInstallReferrerClient.this.mService = null;
            KingInstallReferrerClient.this.mClientState = 0;
            this.f17110a.b();
        }

        private b(@NonNull b0.a aVar) {
            if (aVar == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.f17110a = aVar;
        }
    }

    public KingInstallReferrerClient(@NonNull Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    private boolean isPlayStoreCompatible() {
        try {
            return this.mApplicationContext.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= PLAY_STORE_MIN_APP_VER;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void endConnection() {
        this.mClientState = 3;
        if (this.mServiceConnection != null) {
            c0.a.a(TAG, "Unbinding from service.");
            this.mApplicationContext.unbindService(this.mServiceConnection);
            this.mServiceConnection = null;
        }
        this.mService = null;
    }

    public KingInstallReferrerDetails getInstallReferrer() throws RemoteException {
        if (!isReady()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString(v8.h.V, this.mApplicationContext.getPackageName());
        try {
            return new KingInstallReferrerDetails(this.mService.c(bundle));
        } catch (RemoteException e10) {
            c0.a.b(TAG, "RemoteException getting install referrer information");
            this.mClientState = 0;
            throw e10;
        }
    }

    public boolean isReady() {
        return (this.mClientState != 2 || this.mService == null || this.mServiceConnection == null) ? false : true;
    }

    public void startConnection(@NonNull b0.a aVar) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            c0.a.a(TAG, "Service connection is valid. No need to re-initialize.");
            aVar.a(0);
            return;
        }
        int i10 = this.mClientState;
        if (i10 == 1) {
            c0.a.b(TAG, "Client is already in the process of connecting to the service.");
            aVar.a(3);
            return;
        }
        if (i10 == 3) {
            c0.a.b(TAG, "Client was already closed and can't be reused. Please create another instance.");
            aVar.a(3);
            return;
        }
        c0.a.a(TAG, "Starting install referrer service setup.");
        this.mServiceConnection = new b(aVar);
        Intent intent = new Intent(SERVICE_ACTION_NAME);
        intent.setComponent(new ComponentName("com.android.vending", SERVICE_NAME));
        List<ResolveInfo> listQueryIntentServices = this.mApplicationContext.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.mClientState = 0;
            c0.a.a(TAG, "Install Referrer service unavailable on device.");
            aVar.a(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if (!"com.android.vending".equals(str) || str2 == null || !isPlayStoreCompatible()) {
            c0.a.b(TAG, "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.mClientState = 0;
            aVar.a(2);
        } else {
            if (this.mApplicationContext.bindService(new Intent(intent), this.mServiceConnection, 1)) {
                c0.a.a(TAG, "Service was bonded successfully.");
                return;
            }
            c0.a.b(TAG, "Connection to service is blocked.");
            this.mClientState = 0;
            aVar.a(1);
        }
    }
}
