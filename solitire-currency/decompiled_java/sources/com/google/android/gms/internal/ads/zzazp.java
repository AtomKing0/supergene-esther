package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzazp extends IInterface {
    com.google.android.gms.ads.internal.client.zzbu zze() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzdn zzf() throws RemoteException;

    void zzg(boolean z10) throws RemoteException;

    void zzh(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, zzazw zzazwVar) throws RemoteException;
}
