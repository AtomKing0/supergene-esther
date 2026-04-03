package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbql extends IInterface {
    com.google.android.gms.ads.internal.client.zzdq zze() throws RemoteException;

    zzbra zzf() throws RemoteException;

    zzbra zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzq zzqVar, zzbqo zzbqoVar) throws RemoteException;

    void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpw zzbpwVar, zzbos zzbosVar) throws RemoteException;

    void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpz zzbpzVar, zzbos zzbosVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException;

    void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpz zzbpzVar, zzbos zzbosVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException;

    void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqc zzbqcVar, zzbos zzbosVar) throws RemoteException;

    void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqf zzbqfVar, zzbos zzbosVar) throws RemoteException;

    void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqf zzbqfVar, zzbos zzbosVar, zzbes zzbesVar) throws RemoteException;

    void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqi zzbqiVar, zzbos zzbosVar) throws RemoteException;

    void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqi zzbqiVar, zzbos zzbosVar) throws RemoteException;

    void zzq(String str) throws RemoteException;

    boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException;
}
