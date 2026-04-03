package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbqk extends zzaxn implements zzbql {
    public zzbqk() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbql zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzbql ? (zzbql) iInterfaceQueryLocalInterface : new zzbqj(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.ads.zzbqo] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.google.android.gms.internal.ads.zzbqi] */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.google.android.gms.internal.ads.zzbqf] */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.google.android.gms.internal.ads.zzbqi] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.google.android.gms.internal.ads.zzbqf] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.google.android.gms.internal.ads.zzbqk, com.google.android.gms.internal.ads.zzbql] */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.google.android.gms.internal.ads.zzbpz] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzbpz] */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.google.android.gms.internal.ads.zzbpw] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.ads.zzbqc] */
    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        IInterface zzbpuVar = null;
        if (i10 == 1) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String string = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) zzaxo.zza(parcel, creator);
            Bundle bundle2 = (Bundle) zzaxo.zza(parcel, creator);
            com.google.android.gms.ads.internal.client.zzq zzqVar = (com.google.android.gms.ads.internal.client.zzq) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbpuVar = iInterfaceQueryLocalInterface instanceof zzbqo ? (zzbqo) iInterfaceQueryLocalInterface : new zzbqm(strongBinder);
            }
            ?? r11 = zzbpuVar;
            zzaxo.zzc(parcel);
            zzh(iObjectWrapperAsInterface, string, bundle, bundle2, zzqVar, r11);
            parcel2.writeNoException();
        } else if (i10 == 2) {
            zzbra zzbraVarZzf = zzf();
            parcel2.writeNoException();
            zzaxo.zze(parcel2, zzbraVarZzf);
        } else if (i10 == 3) {
            zzbra zzbraVarZzg = zzg();
            parcel2.writeNoException();
            zzaxo.zze(parcel2, zzbraVarZzg);
        } else if (i10 == 5) {
            com.google.android.gms.ads.internal.client.zzdq zzdqVarZze = zze();
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, zzdqVarZze);
        } else if (i10 == 10) {
            IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
        } else if (i10 != 11) {
            switch (i10) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface2 instanceof zzbpz ? (zzbpz) iInterfaceQueryLocalInterface2 : new zzbpx(strongBinder2);
                    }
                    ?? r52 = zzbpuVar;
                    zzbos zzbosVarZzb = zzbor.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzq zzqVar2 = (com.google.android.gms.ads.internal.client.zzq) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                    zzaxo.zzc(parcel);
                    zzj(string2, string3, zzlVar, iObjectWrapperAsInterface2, r52, zzbosVarZzb, zzqVar2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar2 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface3 instanceof zzbqc ? (zzbqc) iInterfaceQueryLocalInterface3 : new zzbqa(strongBinder3);
                    }
                    ?? r72 = zzbpuVar;
                    zzbos zzbosVarZzb2 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzl(string4, string5, zzlVar2, iObjectWrapperAsInterface3, r72, zzbosVarZzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    boolean zZzs = zzs(iObjectWrapperAsInterface4);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzs ? 1 : 0);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar3 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface4 instanceof zzbqi ? (zzbqi) iInterfaceQueryLocalInterface4 : new zzbqg(strongBinder4);
                    }
                    ?? r112 = zzbpuVar;
                    zzbos zzbosVarZzb3 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzp(string6, string7, zzlVar3, iObjectWrapperAsInterface5, r112, zzbosVarZzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    boolean zZzt = zzt(iObjectWrapperAsInterface6);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzt ? 1 : 0);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar4 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface5 instanceof zzbqf ? (zzbqf) iInterfaceQueryLocalInterface5 : new zzbqd(strongBinder5);
                    }
                    ?? r113 = zzbpuVar;
                    zzbos zzbosVarZzb4 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzm(string8, string9, zzlVar4, iObjectWrapperAsInterface7, r113, zzbosVarZzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String string10 = parcel.readString();
                    zzaxo.zzc(parcel);
                    zzq(string10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String string11 = parcel.readString();
                    String string12 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar5 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder6 = parcel.readStrongBinder();
                    if (strongBinder6 != null) {
                        IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface6 instanceof zzbqi ? (zzbqi) iInterfaceQueryLocalInterface6 : new zzbqg(strongBinder6);
                    }
                    ?? r114 = zzbpuVar;
                    zzbos zzbosVarZzb5 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzo(string11, string12, zzlVar5, iObjectWrapperAsInterface8, r114, zzbosVarZzb5);
                    parcel2.writeNoException();
                    break;
                case 21:
                    String string13 = parcel.readString();
                    String string14 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar6 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder7 = parcel.readStrongBinder();
                    if (strongBinder7 != null) {
                        IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface7 instanceof zzbpz ? (zzbpz) iInterfaceQueryLocalInterface7 : new zzbpx(strongBinder7);
                    }
                    ?? r53 = zzbpuVar;
                    zzbos zzbosVarZzb6 = zzbor.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzq zzqVar3 = (com.google.android.gms.ads.internal.client.zzq) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                    zzaxo.zzc(parcel);
                    zzk(string13, string14, zzlVar6, iObjectWrapperAsInterface9, r53, zzbosVarZzb6, zzqVar3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String string15 = parcel.readString();
                    String string16 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar7 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder8 = parcel.readStrongBinder();
                    if (strongBinder8 != null) {
                        IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface8 instanceof zzbqf ? (zzbqf) iInterfaceQueryLocalInterface8 : new zzbqd(strongBinder8);
                    }
                    ?? r115 = zzbpuVar;
                    zzbos zzbosVarZzb7 = zzbor.zzb(parcel.readStrongBinder());
                    zzbes zzbesVar = (zzbes) zzaxo.zza(parcel, zzbes.CREATOR);
                    zzaxo.zzc(parcel);
                    zzn(string15, string16, zzlVar7, iObjectWrapperAsInterface10, r115, zzbosVarZzb7, zzbesVar);
                    parcel2.writeNoException();
                    break;
                case 23:
                    String string17 = parcel.readString();
                    String string18 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar8 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder9 = parcel.readStrongBinder();
                    if (strongBinder9 != null) {
                        IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbpuVar = iInterfaceQueryLocalInterface9 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface9 : new zzbpu(strongBinder9);
                    }
                    ?? r73 = zzbpuVar;
                    zzbos zzbosVarZzb8 = zzbor.zzb(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    zzi(string17, string18, zzlVar8, iObjectWrapperAsInterface11, r73, zzbosVarZzb8);
                    parcel2.writeNoException();
                    break;
                case 24:
                    IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzaxo.zzc(parcel);
                    boolean zZzr = zzr(iObjectWrapperAsInterface12);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzr ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
