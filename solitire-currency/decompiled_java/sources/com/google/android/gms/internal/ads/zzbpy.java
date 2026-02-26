package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbpy extends zzaxn implements zzbpz {
    public zzbpy() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzg(iObjectWrapperAsInterface);
        } else if (i10 == 2) {
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zze(string);
        } else if (i10 == 3) {
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzaxo.zzc(parcel);
            zzf(zzeVar);
        } else {
            if (i10 != 4) {
                return false;
            }
            zzbov zzbovVarZzb = zzbou.zzb(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zzh(zzbovVarZzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
