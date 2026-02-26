package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbjv;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbol;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbym;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcd extends zzaxn implements zzce {
    public zzcd() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar = (zzq) zzaxo.zza(parcel, zzq.CREATOR);
                String string = parcel.readString();
                zzbom zzbomVarZzf = zzbol.zzf(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbu zzbuVarZzd = zzd(iObjectWrapperAsInterface, zzqVar, string, zzbomVarZzf, i12);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbuVarZzd);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar2 = (zzq) zzaxo.zza(parcel, zzq.CREATOR);
                String string2 = parcel.readString();
                zzbom zzbomVarZzf2 = zzbol.zzf(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbu zzbuVarZze = zze(iObjectWrapperAsInterface2, zzqVar2, string2, zzbomVarZzf2, i13);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbuVarZze);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzbom zzbomVarZzf3 = zzbol.zzf(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbq zzbqVarZzb = zzb(iObjectWrapperAsInterface3, string3, zzbomVarZzf3, i14);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbqVarZzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzbfh zzbfhVarZzi = zzi(iObjectWrapperAsInterface4, iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfhVarZzi);
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbom zzbomVarZzf4 = zzbol.zzf(parcel.readStrongBinder());
                int i15 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbvq zzbvqVarZzn = zzn(iObjectWrapperAsInterface6, zzbomVarZzf4, i15);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbvqVarZzn);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzbsn zzbsnVarZzm = zzm(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbsnVarZzm);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i16 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzco zzcoVarZzg = zzg(iObjectWrapperAsInterface8, i16);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzcoVarZzg);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar3 = (zzq) zzaxo.zza(parcel, zzq.CREATOR);
                String string4 = parcel.readString();
                int i17 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbu zzbuVarZzf = zzf(iObjectWrapperAsInterface9, zzqVar3, string4, i17);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbuVarZzf);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzbfn zzbfnVarZzj = zzj(iObjectWrapperAsInterface10, iObjectWrapperAsInterface11, iObjectWrapperAsInterface12);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfnVarZzj);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzbom zzbomVarZzf5 = zzbol.zzf(parcel.readStrongBinder());
                int i18 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbwg zzbwgVarZzo = zzo(iObjectWrapperAsInterface13, string5, zzbomVarZzf5, i18);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbwgVarZzo);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperAsInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar4 = (zzq) zzaxo.zza(parcel, zzq.CREATOR);
                String string6 = parcel.readString();
                zzbom zzbomVarZzf6 = zzbol.zzf(parcel.readStrongBinder());
                int i19 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbu zzbuVarZzc = zzc(iObjectWrapperAsInterface14, zzqVar4, string6, zzbomVarZzf6, i19);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbuVarZzc);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbom zzbomVarZzf7 = zzbol.zzf(parcel.readStrongBinder());
                int i20 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbym zzbymVarZzp = zzp(iObjectWrapperAsInterface15, zzbomVarZzf7, i20);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbymVarZzp);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperAsInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbom zzbomVarZzf8 = zzbol.zzf(parcel.readStrongBinder());
                int i21 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzbsg zzbsgVarZzl = zzl(iObjectWrapperAsInterface16, zzbomVarZzf8, i21);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbsgVarZzl);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperAsInterface17 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbom zzbomVarZzf9 = zzbol.zzf(parcel.readStrongBinder());
                int i22 = parcel.readInt();
                zzbjw zzbjwVarZzc = zzbjv.zzc(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzbjz zzbjzVarZzk = zzk(iObjectWrapperAsInterface17, zzbomVarZzf9, i22, zzbjwVarZzc);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbjzVarZzk);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperAsInterface18 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbom zzbomVarZzf10 = zzbol.zzf(parcel.readStrongBinder());
                int i23 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzdj zzdjVarZzh = zzh(iObjectWrapperAsInterface18, zzbomVarZzf10, i23);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzdjVarZzh);
                return true;
            default:
                return false;
        }
    }
}
