package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbwf extends zzaxn implements zzbwg {
    public zzbwf() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzbwg zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return iInterfaceQueryLocalInterface instanceof zzbwg ? (zzbwg) iInterfaceQueryLocalInterface : new zzbwe(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzbwn zzbwlVar = null;
        zzbwn zzbwlVar2 = null;
        zzbwo zzbwoVar = null;
        zzbwj zzbwhVar = null;
        switch (i10) {
            case 1:
                com.google.android.gms.ads.internal.client.zzl zzlVar = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbwlVar = iInterfaceQueryLocalInterface instanceof zzbwn ? (zzbwn) iInterfaceQueryLocalInterface : new zzbwl(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzf(zzlVar, zzbwlVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzbwhVar = iInterfaceQueryLocalInterface2 instanceof zzbwj ? (zzbwj) iInterfaceQueryLocalInterface2 : new zzbwh(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzk(zzbwhVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzo = zzo();
                parcel2.writeNoException();
                int i12 = zzaxo.zza;
                parcel2.writeInt(zZzo ? 1 : 0);
                return true;
            case 4:
                String strZze = zze();
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzm(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    zzbwoVar = iInterfaceQueryLocalInterface3 instanceof zzbwo ? (zzbwo) iInterfaceQueryLocalInterface3 : new zzbwo(strongBinder3);
                }
                zzaxo.zzc(parcel);
                zzp(zzbwoVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbwu zzbwuVar = (zzbwu) zzaxo.zza(parcel, zzbwu.CREATOR);
                zzaxo.zzc(parcel);
                zzl(zzbwuVar);
                parcel2.writeNoException();
                return true;
            case 8:
                com.google.android.gms.ads.internal.client.zzdd zzddVarZzb = com.google.android.gms.ads.internal.client.zzdc.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzi(zzddVarZzb);
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle bundleZzb = zzb();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzb);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzn(iObjectWrapperAsInterface2, zZzg);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbwd zzbwdVarZzd = zzd();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbwdVarZzd);
                return true;
            case 12:
                com.google.android.gms.ads.internal.client.zzdn zzdnVarZzc = zzc();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzdnVarZzc);
                return true;
            case 13:
                com.google.android.gms.ads.internal.client.zzdg zzdgVarZzb = com.google.android.gms.ads.internal.client.zzdf.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzj(zzdgVarZzb);
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.ads.internal.client.zzl zzlVar2 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbwlVar2 = iInterfaceQueryLocalInterface4 instanceof zzbwn ? (zzbwn) iInterfaceQueryLocalInterface4 : new zzbwl(strongBinder4);
                }
                zzaxo.zzc(parcel);
                zzg(zzlVar2, zzbwlVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zZzg2 = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzh(zZzg2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
