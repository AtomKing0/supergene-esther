package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzt extends IInterface {
    void zzb(int i10, String[] strArr) throws RemoteException;

    void zzc(int i10, String[] strArr) throws RemoteException;

    void zzd(int i10, PendingIntent pendingIntent) throws RemoteException;
}
