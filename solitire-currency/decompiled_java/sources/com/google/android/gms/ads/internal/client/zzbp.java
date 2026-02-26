package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbga;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgh;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgn;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzblp;
import com.google.android.gms.internal.ads.zzblq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbp extends zzaxn implements zzbq {
    public zzbp() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzbh zzbfVar = null;
        zzcf zzcfVar = null;
        switch (i10) {
            case 1:
                zzbn zzbnVarZze = zze();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbnVarZze);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbfVar = iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbf(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzl(zzbfVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zzbgb zzbgbVarZzb = zzbga.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzf(zzbgbVarZzb);
                parcel2.writeNoException();
                return true;
            case 4:
                zzbge zzbgeVarZzb = zzbgd.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzg(zzbgeVarZzb);
                parcel2.writeNoException();
                return true;
            case 5:
                String string = parcel.readString();
                zzbgk zzbgkVarZzb = zzbgj.zzb(parcel.readStrongBinder());
                zzbgh zzbghVarZzb = zzbgg.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzh(string, zzbgkVarZzb, zzbghVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbes zzbesVar = (zzbes) zzaxo.zza(parcel, zzbes.CREATOR);
                zzaxo.zzc(parcel);
                zzo(zzbesVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcfVar = iInterfaceQueryLocalInterface2 instanceof zzcf ? (zzcf) iInterfaceQueryLocalInterface2 : new zzcf(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzq(zzcfVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbgo zzbgoVarZzb = zzbgn.zzb(parcel.readStrongBinder());
                zzq zzqVar = (zzq) zzaxo.zza(parcel, zzq.CREATOR);
                zzaxo.zzc(parcel);
                zzj(zzbgoVarZzb, zzqVar);
                parcel2.writeNoException();
                return true;
            case 9:
                PublisherAdViewOptions publisherAdViewOptions = (PublisherAdViewOptions) zzaxo.zza(parcel, PublisherAdViewOptions.CREATOR);
                zzaxo.zzc(parcel);
                zzp(publisherAdViewOptions);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbgr zzbgrVarZzb = zzbgq.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzk(zzbgrVarZzb);
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzblh zzblhVar = (zzblh) zzaxo.zza(parcel, zzblh.CREATOR);
                zzaxo.zzc(parcel);
                zzn(zzblhVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzblq zzblqVarZzb = zzblp.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzi(zzblqVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                AdManagerAdViewOptions adManagerAdViewOptions = (AdManagerAdViewOptions) zzaxo.zza(parcel, AdManagerAdViewOptions.CREATOR);
                zzaxo.zzc(parcel);
                zzm(adManagerAdViewOptions);
                parcel2.writeNoException();
                return true;
        }
    }
}
