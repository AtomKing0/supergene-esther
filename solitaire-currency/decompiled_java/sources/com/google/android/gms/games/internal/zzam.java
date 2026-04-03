package com.google.android.gms.games.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzam extends IInterface {
    void zzb(int i10, String str) throws RemoteException;

    void zzc(DataHolder dataHolder) throws RemoteException;

    void zzd(DataHolder dataHolder) throws RemoteException;

    void zze(DataHolder dataHolder) throws RemoteException;

    void zzf(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException;

    void zzg(DataHolder dataHolder) throws RemoteException;

    void zzh(DataHolder dataHolder) throws RemoteException;

    void zzi(DataHolder dataHolder) throws RemoteException;

    void zzj(DataHolder dataHolder) throws RemoteException;

    void zzk(DataHolder dataHolder) throws RemoteException;

    void zzl(Status status, @Nullable String str) throws RemoteException;

    void zzm() throws RemoteException;

    void zzn(DataHolder dataHolder) throws RemoteException;

    void zzo(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException;

    void zzp(int i10, String str) throws RemoteException;

    void zzq(DataHolder dataHolder, Contents contents) throws RemoteException;

    void zzr(DataHolder dataHolder) throws RemoteException;
}
