package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbuq extends zzaxn implements zzbur {
    public zzbuq() {
        super("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzaxo.zzc(parcel);
            zzf(parcelFileDescriptor);
        } else {
            if (i10 != 2) {
                return false;
            }
            com.google.android.gms.ads.internal.util.zzbb zzbbVar = (com.google.android.gms.ads.internal.util.zzbb) zzaxo.zza(parcel, com.google.android.gms.ads.internal.util.zzbb.CREATOR);
            zzaxo.zzc(parcel);
            zze(zzbbVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
