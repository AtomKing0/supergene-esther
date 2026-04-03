package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbyi extends zzaxn implements zzbyj {
    public zzbyi() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            parcel.readString();
            parcel.readString();
            zzaxo.zzc(parcel);
        } else if (i10 == 2) {
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zzb(string);
        } else {
            if (i10 != 3) {
                return false;
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Bundle bundle = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
            zzaxo.zzc(parcel);
            zzc(string2, string3, bundle);
        }
        parcel2.writeNoException();
        return true;
    }
}
