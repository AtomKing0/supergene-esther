package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaxn;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzdc extends zzaxn implements zzdd {
    public zzdc() {
        super("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    public static zzdd zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
        return iInterfaceQueryLocalInterface instanceof zzdd ? (zzdd) iInterfaceQueryLocalInterface : new zzdb(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        zze();
        parcel2.writeNoException();
        return true;
    }
}
