package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzs extends zzb implements zzt {
    public zzs() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            int i12 = parcel.readInt();
            String[] strArrCreateStringArray = parcel.createStringArray();
            zzc.zzd(parcel);
            zzb(i12, strArrCreateStringArray);
        } else if (i10 == 2) {
            int i13 = parcel.readInt();
            String[] strArrCreateStringArray2 = parcel.createStringArray();
            zzc.zzd(parcel);
            zzc(i13, strArrCreateStringArray2);
        } else {
            if (i10 != 3) {
                return false;
            }
            int i14 = parcel.readInt();
            PendingIntent pendingIntent = (PendingIntent) zzc.zza(parcel, PendingIntent.CREATOR);
            zzc.zzd(parcel);
            zzd(i14, pendingIntent);
        }
        return true;
    }
}
