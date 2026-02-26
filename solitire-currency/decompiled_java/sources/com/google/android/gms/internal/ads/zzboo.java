package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzboo extends zzaxn implements zzbop {
    public zzboo() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    protected final boolean zzdF(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzbos zzboqVar = null;
        switch (i10) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzq zzqVar = (com.google.android.gms.ads.internal.client.zzq) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                com.google.android.gms.ads.internal.client.zzl zzlVar = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface : new zzboq(strongBinder);
                }
                zzbos zzbosVar = zzboqVar;
                zzaxo.zzc(parcel);
                zzu(iObjectWrapperAsInterface, zzqVar, zzlVar, string, zzbosVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperZzn = zzn();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, iObjectWrapperZzn);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar2 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface2 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface2 : new zzboq(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzx(iObjectWrapperAsInterface2, zzlVar2, string2, zzboqVar);
                parcel2.writeNoException();
                return true;
            case 4:
                zzI();
                parcel2.writeNoException();
                return true;
            case 5:
                zzo();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzq zzqVar2 = (com.google.android.gms.ads.internal.client.zzq) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                com.google.android.gms.ads.internal.client.zzl zzlVar3 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface3 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface3 : new zzboq(strongBinder3);
                }
                zzbos zzbosVar2 = zzboqVar;
                zzaxo.zzc(parcel);
                zzv(iObjectWrapperAsInterface3, zzqVar2, zzlVar3, string3, string4, zzbosVar2);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar4 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface4 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface4 : new zzboq(strongBinder4);
                }
                zzbos zzbosVar3 = zzboqVar;
                zzaxo.zzc(parcel);
                zzy(iObjectWrapperAsInterface4, zzlVar4, string5, string6, zzbosVar3);
                parcel2.writeNoException();
                return true;
            case 8:
                zzE();
                parcel2.writeNoException();
                return true;
            case 9:
                zzF();
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar5 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string7 = parcel.readString();
                zzbvy zzbvyVarZzb = zzbvx.zzb(parcel.readStrongBinder());
                String string8 = parcel.readString();
                zzaxo.zzc(parcel);
                zzp(iObjectWrapperAsInterface5, zzlVar5, string7, zzbvyVarZzb, string8);
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzl zzlVar6 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string9 = parcel.readString();
                zzaxo.zzc(parcel);
                zzs(zzlVar6, string9);
                parcel2.writeNoException();
                return true;
            case 12:
                zzL();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zZzN = zzN();
                parcel2.writeNoException();
                int i12 = zzaxo.zza;
                parcel2.writeInt(zZzN ? 1 : 0);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar7 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface5 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface5 : new zzboq(strongBinder5);
                }
                zzbos zzbosVar4 = zzboqVar;
                zzbes zzbesVar = (zzbes) zzaxo.zza(parcel, zzbes.CREATOR);
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                zzaxo.zzc(parcel);
                zzz(iObjectWrapperAsInterface6, zzlVar7, string10, string11, zzbosVar4, zzbesVar, arrayListCreateStringArrayList);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 16:
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 17:
                Bundle bundleZze = zze();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZze);
                return true;
            case 18:
                Bundle bundleZzf = zzf();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzf);
                return true;
            case 19:
                Bundle bundleZzg = zzg();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzg);
                return true;
            case 20:
                com.google.android.gms.ads.internal.client.zzl zzlVar8 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzaxo.zzc(parcel);
                zzB(zzlVar8, string12, string13);
                parcel2.writeNoException();
                return true;
            case 21:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzD(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                return true;
            case 22:
                parcel2.writeNoException();
                int i13 = zzaxo.zza;
                parcel2.writeInt(0);
                return true;
            case 23:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvy zzbvyVarZzb2 = zzbvx.zzb(parcel.readStrongBinder());
                ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                zzaxo.zzc(parcel);
                zzr(iObjectWrapperAsInterface8, zzbvyVarZzb2, arrayListCreateStringArrayList2);
                parcel2.writeNoException();
                return true;
            case 24:
                zzbfx zzbfxVarZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfxVarZzi);
                return true;
            case 25:
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzG(zZzg);
                parcel2.writeNoException();
                return true;
            case 26:
                com.google.android.gms.ads.internal.client.zzdq zzdqVarZzh = zzh();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzdqVarZzh);
                return true;
            case 27:
                zzbpb zzbpbVarZzk = zzk();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbpbVarZzk);
                return true;
            case 28:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar9 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string14 = parcel.readString();
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface6 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface6 : new zzboq(strongBinder6);
                }
                zzaxo.zzc(parcel);
                zzA(iObjectWrapperAsInterface9, zzlVar9, string14, zzboqVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzK(iObjectWrapperAsInterface10);
                parcel2.writeNoException();
                return true;
            case 31:
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbkz zzbkzVarZzb = zzbky.zzb(parcel.readStrongBinder());
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzblf.CREATOR);
                zzaxo.zzc(parcel);
                zzq(iObjectWrapperAsInterface11, zzbkzVarZzb, arrayListCreateTypedArrayList);
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar10 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string15 = parcel.readString();
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface7 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface7 : new zzboq(strongBinder7);
                }
                zzaxo.zzc(parcel);
                zzC(iObjectWrapperAsInterface12, zzlVar10, string15, zzboqVar);
                parcel2.writeNoException();
                return true;
            case 33:
                zzbra zzbraVarZzl = zzl();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, zzbraVarZzl);
                return true;
            case 34:
                zzbra zzbraVarZzm = zzm();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, zzbraVarZzm);
                return true;
            case 35:
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzq zzqVar3 = (com.google.android.gms.ads.internal.client.zzq) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                com.google.android.gms.ads.internal.client.zzl zzlVar11 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string16 = parcel.readString();
                String string17 = parcel.readString();
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface8 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface8 : new zzboq(strongBinder8);
                }
                zzbos zzbosVar5 = zzboqVar;
                zzaxo.zzc(parcel);
                zzw(iObjectWrapperAsInterface13, zzqVar3, zzlVar11, string16, string17, zzbosVar5);
                parcel2.writeNoException();
                return true;
            case 36:
                zzbov zzbovVarZzj = zzj();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbovVarZzj);
                return true;
            case 37:
                IObjectWrapper iObjectWrapperAsInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzJ(iObjectWrapperAsInterface14);
                parcel2.writeNoException();
                return true;
            case 38:
                IObjectWrapper iObjectWrapperAsInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar12 = (com.google.android.gms.ads.internal.client.zzl) zzaxo.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string18 = parcel.readString();
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzboqVar = iInterfaceQueryLocalInterface9 instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface9 : new zzboq(strongBinder9);
                }
                zzaxo.zzc(parcel);
                zzt(iObjectWrapperAsInterface15, zzlVar12, string18, zzboqVar);
                parcel2.writeNoException();
                return true;
            case 39:
                IObjectWrapper iObjectWrapperAsInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzH(iObjectWrapperAsInterface16);
                parcel2.writeNoException();
                return true;
        }
    }
}
