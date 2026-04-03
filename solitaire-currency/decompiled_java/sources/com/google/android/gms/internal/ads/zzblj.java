package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzblj extends zzaxn implements zzblk {
    public zzblj() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzbln zzbllVar;
        if (i10 == 3) {
            com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = zzb();
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, zzdqVarZzb);
            return true;
        }
        if (i10 == 4) {
            zzd();
            parcel2.writeNoException();
            return true;
        }
        if (i10 == 5) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbllVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzbllVar = iInterfaceQueryLocalInterface instanceof zzbln ? (zzbln) iInterfaceQueryLocalInterface : new zzbll(strongBinder);
            }
            zzaxo.zzc(parcel);
            zzf(iObjectWrapperAsInterface, zzbllVar);
            parcel2.writeNoException();
            return true;
        }
        if (i10 == 6) {
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            zze(iObjectWrapperAsInterface2);
            parcel2.writeNoException();
            return true;
        }
        if (i10 != 7) {
            return false;
        }
        zzbfa zzbfaVarZzc = zzc();
        parcel2.writeNoException();
        zzaxo.zzf(parcel2, zzbfaVarZzc);
        return true;
    }
}
