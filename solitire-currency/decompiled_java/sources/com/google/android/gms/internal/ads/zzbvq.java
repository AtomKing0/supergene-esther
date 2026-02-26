package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbvq extends IInterface {
    Bundle zzb() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzdn zzc() throws RemoteException;

    String zzd() throws RemoteException;

    void zze() throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(zzbvu zzbvuVar) throws RemoteException;

    void zzh() throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzj() throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(com.google.android.gms.ads.internal.client.zzby zzbyVar) throws RemoteException;

    void zzm(String str) throws RemoteException;

    void zzn(boolean z10) throws RemoteException;

    void zzo(zzbvt zzbvtVar) throws RemoteException;

    void zzp(String str) throws RemoteException;

    void zzq() throws RemoteException;

    void zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs() throws RemoteException;

    boolean zzt() throws RemoteException;

    void zzu(zzbvo zzbvoVar) throws RemoteException;
}
