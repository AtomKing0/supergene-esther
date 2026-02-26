package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbpa extends zzaxn implements zzbpb {
    public zzbpa() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzbpb zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        return iInterfaceQueryLocalInterface instanceof zzbpb ? (zzbpb) iInterfaceQueryLocalInterface : new zzboz(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 2:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 3:
                List listZzv = zzv();
                parcel2.writeNoException();
                parcel2.writeList(listZzv);
                return true;
            case 4:
                String strZzq = zzq();
                parcel2.writeNoException();
                parcel2.writeString(strZzq);
                return true;
            case 5:
                zzbfd zzbfdVarZzl = zzl();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfdVarZzl);
                return true;
            case 6:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 7:
                String strZzp = zzp();
                parcel2.writeNoException();
                parcel2.writeString(strZzp);
                return true;
            case 8:
                double dZze = zze();
                parcel2.writeNoException();
                parcel2.writeDouble(dZze);
                return true;
            case 9:
                String strZzu = zzu();
                parcel2.writeNoException();
                parcel2.writeString(strZzu);
                return true;
            case 10:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzdq zzdqVarZzj = zzj();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzdqVarZzj);
                return true;
            case 12:
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperZzm = zzm();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, iObjectWrapperZzm);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperZzn = zzn();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, iObjectWrapperZzn);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperZzo = zzo();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, iObjectWrapperZzo);
                return true;
            case 16:
                Bundle bundleZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzi);
                return true;
            case 17:
                boolean zZzB = zzB();
                parcel2.writeNoException();
                int i12 = zzaxo.zza;
                parcel2.writeInt(zZzB ? 1 : 0);
                return true;
            case 18:
                boolean zZzA = zzA();
                parcel2.writeNoException();
                int i13 = zzaxo.zza;
                parcel2.writeInt(zZzA ? 1 : 0);
                return true;
            case 19:
                zzx();
                parcel2.writeNoException();
                return true;
            case 20:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzw(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 21:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzy(iObjectWrapperAsInterface2, iObjectWrapperAsInterface3, iObjectWrapperAsInterface4);
                parcel2.writeNoException();
                return true;
            case 22:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzz(iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                return true;
            case 23:
                float fZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzf);
                return true;
            case 24:
                float fZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzh);
                return true;
            case 25:
                float fZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzg);
                return true;
            default:
                return false;
        }
    }
}
