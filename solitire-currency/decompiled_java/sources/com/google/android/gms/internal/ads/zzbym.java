package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbym extends IInterface {
    IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, zzbyq zzbyqVar, zzbyj zzbyjVar) throws RemoteException;

    void zzg(zzbtl zzbtlVar) throws RemoteException;

    void zzh(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) throws RemoteException;

    void zzi(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) throws RemoteException;

    void zzm(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) throws RemoteException;
}
