package com.google.android.gms.internal.location;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzx extends IInterface {
    void zzb(Status status, LocationAvailability locationAvailability) throws RemoteException;
}
