package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzy extends zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.location.internal.ILocationStatusCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        Location location = (Location) zzc.zza(parcel, Location.CREATOR);
        zzc.zzd(parcel);
        zzb(status, location);
        return true;
    }
}
