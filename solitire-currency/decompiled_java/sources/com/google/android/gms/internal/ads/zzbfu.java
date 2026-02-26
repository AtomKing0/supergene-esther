package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbfu extends IInterface {
    Bundle zzb() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzdq zzc() throws RemoteException;

    zzbew zzd() throws RemoteException;

    zzbfd zze() throws RemoteException;

    IObjectWrapper zzf() throws RemoteException;

    IObjectWrapper zzg() throws RemoteException;

    String zzh() throws RemoteException;

    String zzi() throws RemoteException;

    String zzj() throws RemoteException;

    String zzk() throws RemoteException;

    String zzl() throws RemoteException;

    List zzm() throws RemoteException;

    void zzn() throws RemoteException;

    void zzo(Bundle bundle) throws RemoteException;

    void zzp(Bundle bundle) throws RemoteException;

    boolean zzq(Bundle bundle) throws RemoteException;
}
