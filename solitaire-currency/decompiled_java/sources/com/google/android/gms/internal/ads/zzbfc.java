package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbfc extends zzaxn implements zzbfd {
    public zzbfc() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbfd zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return iInterfaceQueryLocalInterface instanceof zzbfd ? (zzbfd) iInterfaceQueryLocalInterface : new zzbfb(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            IObjectWrapper iObjectWrapperZzf = zzf();
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, iObjectWrapperZzf);
        } else if (i10 == 2) {
            Uri uriZze = zze();
            parcel2.writeNoException();
            zzaxo.zze(parcel2, uriZze);
        } else if (i10 == 3) {
            double dZzb = zzb();
            parcel2.writeNoException();
            parcel2.writeDouble(dZzb);
        } else if (i10 == 4) {
            int iZzd = zzd();
            parcel2.writeNoException();
            parcel2.writeInt(iZzd);
        } else {
            if (i10 != 5) {
                return false;
            }
            int iZzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(iZzc);
        }
        return true;
    }
}
