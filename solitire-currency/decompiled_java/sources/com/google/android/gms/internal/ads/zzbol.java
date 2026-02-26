package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbol extends zzaxn implements zzbom {
    public zzbol() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbom zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return iInterfaceQueryLocalInterface instanceof zzbom ? (zzbom) iInterfaceQueryLocalInterface : new zzbok(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zzbop zzbopVarZzb = zzb(string);
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, zzbopVarZzb);
        } else if (i10 == 2) {
            String string2 = parcel.readString();
            zzaxo.zzc(parcel);
            boolean zZze = zze(string2);
            parcel2.writeNoException();
            parcel2.writeInt(zZze ? 1 : 0);
        } else if (i10 == 3) {
            String string3 = parcel.readString();
            zzaxo.zzc(parcel);
            zzbql zzbqlVarZzc = zzc(string3);
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, zzbqlVarZzc);
        } else {
            if (i10 != 4) {
                return false;
            }
            String string4 = parcel.readString();
            zzaxo.zzc(parcel);
            boolean zZzd = zzd(string4);
            parcel2.writeNoException();
            parcel2.writeInt(zZzd ? 1 : 0);
        }
        return true;
    }
}
