package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbym;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzce extends IInterface {
    zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbom zzbomVar, int i10) throws RemoteException;

    zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbom zzbomVar, int i10) throws RemoteException;

    zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbom zzbomVar, int i10) throws RemoteException;

    zzbu zze(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbom zzbomVar, int i10) throws RemoteException;

    zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, int i10) throws RemoteException;

    zzco zzg(IObjectWrapper iObjectWrapper, int i10) throws RemoteException;

    zzdj zzh(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) throws RemoteException;

    zzbfh zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    zzbfn zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzbjz zzk(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10, zzbjw zzbjwVar) throws RemoteException;

    zzbsg zzl(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) throws RemoteException;

    zzbsn zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzbvq zzn(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) throws RemoteException;

    zzbwg zzo(IObjectWrapper iObjectWrapper, String str, zzbom zzbomVar, int i10) throws RemoteException;

    zzbym zzp(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) throws RemoteException;
}
