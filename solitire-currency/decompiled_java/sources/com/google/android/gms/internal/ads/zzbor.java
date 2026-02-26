package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbor extends zzaxn implements zzbos {
    public zzbor() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbos zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface : new zzboq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int i12 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzg(i12);
                break;
            case 4:
                zzn();
                break;
            case 5:
                zzp();
                break;
            case 6:
                zzo();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (iInterfaceQueryLocalInterface instanceof zzbow) {
                    }
                }
                zzaxo.zzc(parcel);
                break;
            case 8:
                zzm();
                break;
            case 9:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                zzq(string, string2);
                break;
            case 10:
                zzbfw.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzaxo.zzc(parcel);
                break;
            case 11:
                zzv();
                break;
            case 12:
                parcel.readString();
                zzaxo.zzc(parcel);
                break;
            case 13:
                zzy();
                break;
            case 14:
                zzbvz zzbvzVar = (zzbvz) zzaxo.zza(parcel, zzbvz.CREATOR);
                zzaxo.zzc(parcel);
                zzs(zzbvzVar);
                break;
            case 15:
                zzw();
                break;
            case 16:
                zzbwd zzbwdVarZzb = zzbwc.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzt(zzbwdVarZzb);
                break;
            case 17:
                int i13 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzj(i13);
                break;
            case 18:
                zzu();
                break;
            case 19:
                zzaxo.zzc(parcel);
                break;
            case 20:
                zzx();
                break;
            case 21:
                String string3 = parcel.readString();
                zzaxo.zzc(parcel);
                zzl(string3);
                break;
            case 22:
                int i14 = parcel.readInt();
                String string4 = parcel.readString();
                zzaxo.zzc(parcel);
                zzi(i14, string4);
                break;
            case 23:
                com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzaxo.zzc(parcel);
                zzh(zzeVar);
                break;
            case 24:
                com.google.android.gms.ads.internal.client.zze zzeVar2 = (com.google.android.gms.ads.internal.client.zze) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzaxo.zzc(parcel);
                zzk(zzeVar2);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
