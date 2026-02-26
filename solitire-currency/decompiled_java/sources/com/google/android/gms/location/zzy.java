package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzy extends com.google.android.gms.internal.location.zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static zzz zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterfaceQueryLocalInterface instanceof zzz ? (zzz) iInterfaceQueryLocalInterface : new zzx(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            Location location = (Location) com.google.android.gms.internal.location.zzc.zza(parcel, Location.CREATOR);
            com.google.android.gms.internal.location.zzc.zzd(parcel);
            zzd(location);
        } else {
            if (i10 != 2) {
                return false;
            }
            zze();
        }
        return true;
    }
}
