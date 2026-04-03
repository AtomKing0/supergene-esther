package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzbom;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzco extends IInterface {
    float zze() throws RemoteException;

    String zzf() throws RemoteException;

    List zzg() throws RemoteException;

    void zzh(@Nullable String str) throws RemoteException;

    void zzi() throws RemoteException;

    void zzj(boolean z10) throws RemoteException;

    void zzk() throws RemoteException;

    void zzl(@Nullable String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzm(zzda zzdaVar) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzo(zzbom zzbomVar) throws RemoteException;

    void zzp(boolean z10) throws RemoteException;

    void zzq(float f10) throws RemoteException;

    void zzr(String str) throws RemoteException;

    void zzs(zzblc zzblcVar) throws RemoteException;

    void zzt(String str) throws RemoteException;

    void zzu(zzff zzffVar) throws RemoteException;

    boolean zzv() throws RemoteException;
}
