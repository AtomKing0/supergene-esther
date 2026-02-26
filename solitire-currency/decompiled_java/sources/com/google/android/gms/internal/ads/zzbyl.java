package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbyl extends zzaxn implements zzbym {
    public zzbyl() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzbym zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        return iInterfaceQueryLocalInterface instanceof zzbym ? (zzbym) iInterfaceQueryLocalInterface : new zzbyk(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzbyj zzbyhVar = null;
        switch (i10) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbyq zzbyqVar = (zzbyq) zzaxo.zza(parcel, zzbyq.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzbyhVar = iInterfaceQueryLocalInterface instanceof zzbyj ? (zzbyj) iInterfaceQueryLocalInterface : new zzbyh(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzf(iObjectWrapperAsInterface, zzbyqVar, zzbyhVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzk(iObjectWrapperAsInterface2);
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbtc zzbtcVarZzb = zzbtb.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzm(arrayListCreateTypedArrayList, iObjectWrapperAsInterface3, zzbtcVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbtc zzbtcVarZzb2 = zzbtb.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzl(arrayListCreateTypedArrayList2, iObjectWrapperAsInterface4, zzbtcVarZzb2);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbtl zzbtlVar = (zzbtl) zzaxo.zza(parcel, zzbtl.CREATOR);
                zzaxo.zzc(parcel);
                zzg(zzbtlVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzj(iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                return true;
            case 9:
                ArrayList arrayListCreateTypedArrayList3 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbtc zzbtcVarZzb3 = zzbtb.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzi(arrayListCreateTypedArrayList3, iObjectWrapperAsInterface6, zzbtcVarZzb3);
                parcel2.writeNoException();
                return true;
            case 10:
                ArrayList arrayListCreateTypedArrayList4 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbtc zzbtcVarZzb4 = zzbtb.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzh(arrayListCreateTypedArrayList4, iObjectWrapperAsInterface7, zzbtcVarZzb4);
                parcel2.writeNoException();
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                IObjectWrapper iObjectWrapperZze = zze(iObjectWrapperAsInterface8, iObjectWrapperAsInterface9, string, iObjectWrapperAsInterface10);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, iObjectWrapperZze);
                return true;
            default:
                return false;
        }
    }
}
