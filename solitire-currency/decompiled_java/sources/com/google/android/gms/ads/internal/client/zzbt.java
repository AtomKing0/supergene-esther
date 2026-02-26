package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzazr;
import com.google.android.gms.internal.ads.zzazs;
import com.google.android.gms.internal.ads.zzbcq;
import com.google.android.gms.internal.ads.zzbcr;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbvt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbt extends zzaxn implements zzbu {
    public zzbt() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzbu zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzbh zzbfVar = null;
        zzci zzcgVar = null;
        zzbk zzbiVar = null;
        zzdg zzdeVar = null;
        zzby zzbwVar = null;
        zzcf zzcfVar = null;
        zzbe zzbcVar = null;
        zzcb zzbzVar = null;
        switch (i10) {
            case 1:
                IObjectWrapper iObjectWrapperZzn = zzn();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, iObjectWrapperZzn);
                return true;
            case 2:
                zzx();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzaa = zzaa();
                parcel2.writeNoException();
                int i12 = zzaxo.zza;
                parcel2.writeInt(zZzaa ? 1 : 0);
                return true;
            case 4:
                zzl zzlVar = (zzl) zzaxo.zza(parcel, zzl.CREATOR);
                zzaxo.zzc(parcel);
                boolean zZzab = zzab(zzlVar);
                parcel2.writeNoException();
                parcel2.writeInt(zZzab ? 1 : 0);
                return true;
            case 5:
                zzz();
                parcel2.writeNoException();
                return true;
            case 6:
                zzB();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbfVar = iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbf(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzD(zzbfVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzbzVar = iInterfaceQueryLocalInterface2 instanceof zzcb ? (zzcb) iInterfaceQueryLocalInterface2 : new zzbz(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzG(zzbzVar);
                parcel2.writeNoException();
                return true;
            case 9:
                zzX();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel2.writeNoException();
                return true;
            case 11:
                zzA();
                parcel2.writeNoException();
                return true;
            case 12:
                zzq zzqVarZzg = zzg();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, zzqVarZzg);
                return true;
            case 13:
                zzq zzqVar = (zzq) zzaxo.zza(parcel, zzq.CREATOR);
                zzaxo.zzc(parcel);
                zzF(zzqVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbsw zzbswVarZzb = zzbsv.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzM(zzbswVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                zzbsz zzbszVarZzb = zzbsy.zzb(parcel.readStrongBinder());
                String string = parcel.readString();
                zzaxo.zzc(parcel);
                zzQ(zzbszVarZzb, string);
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 19:
                zzbcr zzbcrVarZzb = zzbcq.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzO(zzbcrVarZzb);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzbcVar = iInterfaceQueryLocalInterface3 instanceof zzbe ? (zzbe) iInterfaceQueryLocalInterface3 : new zzbc(strongBinder3);
                }
                zzaxo.zzc(parcel);
                zzC(zzbcVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcfVar = iInterfaceQueryLocalInterface4 instanceof zzcf ? (zzcf) iInterfaceQueryLocalInterface4 : new zzcf(strongBinder4);
                }
                zzaxo.zzc(parcel);
                zzac(zzcfVar);
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzN(zZzg);
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zZzZ = zzZ();
                parcel2.writeNoException();
                int i13 = zzaxo.zza;
                parcel2.writeInt(zZzZ ? 1 : 0);
                return true;
            case 24:
                zzbvt zzbvtVarZzb = zzbvs.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzS(zzbvtVarZzb);
                parcel2.writeNoException();
                return true;
            case 25:
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                zzT(string2);
                parcel2.writeNoException();
                return true;
            case 26:
                zzdq zzdqVarZzl = zzl();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzdqVarZzl);
                return true;
            case 29:
                zzfk zzfkVar = (zzfk) zzaxo.zza(parcel, zzfk.CREATOR);
                zzaxo.zzc(parcel);
                zzU(zzfkVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzdu zzduVar = (zzdu) zzaxo.zza(parcel, zzdu.CREATOR);
                zzaxo.zzc(parcel);
                zzK(zzduVar);
                parcel2.writeNoException();
                return true;
            case 31:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 32:
                zzcb zzcbVarZzj = zzj();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzcbVarZzj);
                return true;
            case 33:
                zzbh zzbhVarZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbhVarZzi);
                return true;
            case 34:
                boolean zZzg2 = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzL(zZzg2);
                parcel2.writeNoException();
                return true;
            case 35:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 36:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzbwVar = iInterfaceQueryLocalInterface5 instanceof zzby ? (zzby) iInterfaceQueryLocalInterface5 : new zzbw(strongBinder5);
                }
                zzaxo.zzc(parcel);
                zzE(zzbwVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle bundleZzd = zzd();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzd);
                return true;
            case 38:
                String string3 = parcel.readString();
                zzaxo.zzc(parcel);
                zzR(string3);
                parcel2.writeNoException();
                return true;
            case 39:
                zzw zzwVar = (zzw) zzaxo.zza(parcel, zzw.CREATOR);
                zzaxo.zzc(parcel);
                zzI(zzwVar);
                parcel2.writeNoException();
                return true;
            case 40:
                zzazs zzazsVarZze = zzazr.zze(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzH(zzazsVarZze);
                parcel2.writeNoException();
                return true;
            case 41:
                zzdn zzdnVarZzk = zzk();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzdnVarZzk);
                return true;
            case 42:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    zzdeVar = iInterfaceQueryLocalInterface6 instanceof zzdg ? (zzdg) iInterfaceQueryLocalInterface6 : new zzde(strongBinder6);
                }
                zzaxo.zzc(parcel);
                zzP(zzdeVar);
                parcel2.writeNoException();
                return true;
            case 43:
                zzl zzlVar2 = (zzl) zzaxo.zza(parcel, zzl.CREATOR);
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    zzbiVar = iInterfaceQueryLocalInterface7 instanceof zzbk ? (zzbk) iInterfaceQueryLocalInterface7 : new zzbi(strongBinder7);
                }
                zzaxo.zzc(parcel);
                zzy(zzlVar2, zzbiVar);
                parcel2.writeNoException();
                return true;
            case 44:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzW(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 45:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    zzcgVar = iInterfaceQueryLocalInterface8 instanceof zzci ? (zzci) iInterfaceQueryLocalInterface8 : new zzcg(strongBinder8);
                }
                zzaxo.zzc(parcel);
                zzJ(zzcgVar);
                parcel2.writeNoException();
                return true;
            case 46:
                boolean zZzY = zzY();
                parcel2.writeNoException();
                int i14 = zzaxo.zza;
                parcel2.writeInt(zZzY ? 1 : 0);
                return true;
        }
    }
}
