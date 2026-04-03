package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzn implements ServiceConnection {
    zzp zzc;
    final /* synthetic */ zzu zzf;
    int zza = 0;
    final Messenger zzb = new Messenger(new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.zzk
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i10 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Received response to request: " + i10);
            }
            zzn zznVar = this.zza;
            synchronized (zznVar) {
                zzr zzrVar = (zzr) zznVar.zze.get(i10);
                if (zzrVar == null) {
                    Log.w("MessengerIpcClient", "Received response for unknown request: " + i10);
                    return true;
                }
                zznVar.zze.remove(i10);
                zznVar.zzf();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzrVar.zzc(new zzs(4, "Not supported by GmsCore", null));
                    return true;
                }
                zzrVar.zza(data);
                return true;
            }
        }
    }));
    final Queue zzd = new ArrayDeque();
    final SparseArray zze = new SparseArray();

    /* synthetic */ zzn(zzu zzuVar, zzm zzmVar) {
        this.zzf = zzuVar;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.zzf.zzc.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzg
            @Override // java.lang.Runnable
            public final void run() {
                zzn zznVar = this.zza;
                IBinder iBinder2 = iBinder;
                synchronized (zznVar) {
                    try {
                        if (iBinder2 == null) {
                            zznVar.zza(0, "Null service connection");
                            return;
                        }
                        try {
                            zznVar.zzc = new zzp(iBinder2);
                            zznVar.zza = 2;
                            zznVar.zzc();
                        } catch (RemoteException e10) {
                            zznVar.zza(0, e10.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.zzf.zzc.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(2, "Service disconnected");
            }
        });
    }

    final synchronized void zza(int i10, @Nullable String str) {
        zzb(i10, str, null);
    }

    final synchronized void zzb(int i10, @Nullable String str, @Nullable Throwable th) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
        }
        int i11 = this.zza;
        if (i11 == 0) {
            throw new IllegalStateException();
        }
        if (i11 != 1 && i11 != 2) {
            if (i11 != 3) {
                return;
            }
            this.zza = 4;
            return;
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.zza = 4;
        ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
        zzs zzsVar = new zzs(i10, str, th);
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzr) it.next()).zzc(zzsVar);
        }
        this.zzd.clear();
        for (int i12 = 0; i12 < this.zze.size(); i12++) {
            ((zzr) this.zze.valueAt(i12)).zzc(zzsVar);
        }
        this.zze.clear();
    }

    final void zzc() {
        this.zzf.zzc.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzh
            @Override // java.lang.Runnable
            public final void run() {
                final zzr zzrVar;
                while (true) {
                    final zzn zznVar = this.zza;
                    synchronized (zznVar) {
                        if (zznVar.zza != 2) {
                            return;
                        }
                        if (zznVar.zzd.isEmpty()) {
                            zznVar.zzf();
                            return;
                        } else {
                            zzrVar = (zzr) zznVar.zzd.poll();
                            zznVar.zze.put(zzrVar.zza, zzrVar);
                            zznVar.zzf.zzc.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzl
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zznVar.zze(zzrVar.zza);
                                }
                            }, 30L, TimeUnit.SECONDS);
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(zzrVar)));
                    }
                    zzu zzuVar = zznVar.zzf;
                    Messenger messenger = zznVar.zzb;
                    int i10 = zzrVar.zzc;
                    Context context = zzuVar.zzb;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i10;
                    messageObtain.arg1 = zzrVar.zza;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", zzrVar.zzb());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", zzrVar.zzd);
                    messageObtain.setData(bundle);
                    try {
                        zznVar.zzc.zza(messageObtain);
                    } catch (RemoteException e10) {
                        zznVar.zza(2, e10.getMessage());
                    }
                }
            }
        });
    }

    final synchronized void zzd() {
        if (this.zza == 1) {
            zza(1, "Timed out while binding");
        }
    }

    final synchronized void zze(int i10) {
        zzr zzrVar = (zzr) this.zze.get(i10);
        if (zzrVar != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i10);
            this.zze.remove(i10);
            zzrVar.zzc(new zzs(3, "Timed out waiting for response", null));
            zzf();
        }
    }

    final synchronized void zzf() {
        if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.zza = 3;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
        }
    }

    final synchronized boolean zzg(zzr zzrVar) {
        int i10 = this.zza;
        if (i10 != 0) {
            if (i10 == 1) {
                this.zzd.add(zzrVar);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            this.zzd.add(zzrVar);
            zzc();
            return true;
        }
        this.zzd.add(zzrVar);
        Preconditions.checkState(this.zza == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.zza = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (ConnectionTracker.getInstance().bindService(this.zzf.zzb, intent, this, 1)) {
                this.zzf.zzc.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzi
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzd();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                zza(0, "Unable to bind to service");
            }
        } catch (SecurityException e10) {
            zzb(0, "Unable to bind to service", e10);
        }
        return true;
    }
}
