package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbm extends zzaxn implements zzbn {
    public zzbm() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            zzl zzlVar = (zzl) zzaxo.zza(parcel, zzl.CREATOR);
            zzaxo.zzc(parcel);
            zzg(zzlVar);
            parcel2.writeNoException();
        } else if (i10 == 2) {
            String strZze = zze();
            parcel2.writeNoException();
            parcel2.writeString(strZze);
        } else if (i10 == 3) {
            boolean zZzi = zzi();
            parcel2.writeNoException();
            int i12 = zzaxo.zza;
            parcel2.writeInt(zZzi ? 1 : 0);
        } else if (i10 == 4) {
            String strZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(strZzf);
        } else {
            if (i10 != 5) {
                return false;
            }
            zzl zzlVar2 = (zzl) zzaxo.zza(parcel, zzl.CREATOR);
            int i13 = parcel.readInt();
            zzaxo.zzc(parcel);
            zzh(zzlVar2, i13);
            parcel2.writeNoException();
        }
        return true;
    }
}
