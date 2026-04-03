package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzazr extends zzaxn implements zzazs {
    public zzazr() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzazs zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        return iInterfaceQueryLocalInterface instanceof zzazs ? (zzazs) iInterfaceQueryLocalInterface : new zzazq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzazp zzaznVar;
        if (i10 == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzaznVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
                zzaznVar = iInterfaceQueryLocalInterface instanceof zzazp ? (zzazp) iInterfaceQueryLocalInterface : new zzazn(strongBinder);
            }
            zzaxo.zzc(parcel);
            zzd(zzaznVar);
        } else if (i10 == 2) {
            parcel.readInt();
            zzaxo.zzc(parcel);
        } else {
            if (i10 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzaxo.zzc(parcel);
            zzc(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
