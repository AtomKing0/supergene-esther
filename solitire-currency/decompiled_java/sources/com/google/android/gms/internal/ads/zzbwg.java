package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbwg extends IInterface {
    Bundle zzb() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzdn zzc() throws RemoteException;

    zzbwd zzd() throws RemoteException;

    String zze() throws RemoteException;

    void zzf(com.google.android.gms.ads.internal.client.zzl zzlVar, zzbwn zzbwnVar) throws RemoteException;

    void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar, zzbwn zzbwnVar) throws RemoteException;

    void zzh(boolean z10) throws RemoteException;

    void zzi(com.google.android.gms.ads.internal.client.zzdd zzddVar) throws RemoteException;

    void zzj(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException;

    void zzk(zzbwj zzbwjVar) throws RemoteException;

    void zzl(zzbwu zzbwuVar) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper, boolean z10) throws RemoteException;

    boolean zzo() throws RemoteException;

    void zzp(zzbwo zzbwoVar) throws RemoteException;
}
