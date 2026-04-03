package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfty implements ServiceConnection {
    final /* synthetic */ zzftz zza;

    /* synthetic */ zzfty(zzftz zzftzVar, zzftx zzftxVar) {
        this.zza = zzftzVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        this.zza.zzc.zzc("LmdServiceConnectionManager.onServiceConnected(%s)", componentName);
        this.zza.zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzftv
            @Override // java.lang.Runnable
            public final void run() {
                zzfty zzftyVar = this.zza;
                zzftyVar.zza.zzj = zzfsi.zzb(iBinder);
                zzftyVar.zza.zzc.zzc("linkToDeath", new Object[0]);
                try {
                    IInterface iInterface = zzftyVar.zza.zzj;
                    iInterface.getClass();
                    iInterface.asBinder().linkToDeath(zzftyVar.zza.zzh, 0);
                } catch (RemoteException e10) {
                    zzftyVar.zza.zzc.zzb(e10, "linkToDeath failed", new Object[0]);
                }
                zzftyVar.zza.zzf = false;
                synchronized (zzftyVar.zza.zze) {
                    Iterator it = zzftyVar.zza.zze.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    zzftyVar.zza.zze.clear();
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zzc.zzc("LmdServiceConnectionManager.onServiceDisconnected(%s)", componentName);
        this.zza.zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzftw
            @Override // java.lang.Runnable
            public final void run() {
                zzfty zzftyVar = this.zza;
                zzftyVar.zza.zzc.zzc("unlinkToDeath", new Object[0]);
                zzftz zzftzVar = zzftyVar.zza;
                IInterface iInterface = zzftzVar.zzj;
                iInterface.getClass();
                iInterface.asBinder().unlinkToDeath(zzftzVar.zzh, 0);
                zzftyVar.zza.zzj = null;
                zzftyVar.zza.zzf = false;
            }
        });
    }
}
