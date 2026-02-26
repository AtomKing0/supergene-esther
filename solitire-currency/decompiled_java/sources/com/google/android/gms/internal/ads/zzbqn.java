package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbqn extends zzaxn implements zzbqo {
    public zzbqn() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zze(string);
        } else if (i10 == 2) {
            String string2 = parcel.readString();
            zzaxo.zzc(parcel);
            zzf(string2);
        } else {
            if (i10 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzaxo.zzc(parcel);
            zzg(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
