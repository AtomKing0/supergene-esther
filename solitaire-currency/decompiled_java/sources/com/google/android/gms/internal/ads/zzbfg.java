package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbfg extends zzaxn implements zzbfh {
    public zzbfg() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzbfh zzdA(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return iInterfaceQueryLocalInterface instanceof zzbfh ? (zzbfh) iInterfaceQueryLocalInterface : new zzbff(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzbfa zzbeyVar;
        switch (i10) {
            case 1:
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdv(string, iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 2:
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                IObjectWrapper iObjectWrapperZzb = zzb(string2);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, iObjectWrapperZzb);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdz(iObjectWrapperAsInterface2);
                parcel2.writeNoException();
                return true;
            case 4:
                zzc();
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readInt();
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdw(iObjectWrapperAsInterface3);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzd(iObjectWrapperAsInterface4);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbeyVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
                    zzbeyVar = iInterfaceQueryLocalInterface instanceof zzbfa ? (zzbfa) iInterfaceQueryLocalInterface : new zzbey(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzdx(zzbeyVar);
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzdy(iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
