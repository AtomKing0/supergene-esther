package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdnd extends zzbfr {

    @Nullable
    private final String zza;
    private final zzdiw zzb;
    private final zzdjb zzc;

    public zzdnd(@Nullable String str, zzdiw zzdiwVar, zzdjb zzdjbVar) {
        this.zza = str;
        this.zzb = zzdiwVar;
        this.zzc = zzdjbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final double zzb() throws RemoteException {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final Bundle zzc() throws RemoteException {
        return this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final com.google.android.gms.ads.internal.client.zzdq zzd() throws RemoteException {
        return this.zzc.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final zzbew zze() throws RemoteException {
        return this.zzc.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final zzbfd zzf() throws RemoteException {
        return this.zzc.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final IObjectWrapper zzg() throws RemoteException {
        return this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final IObjectWrapper zzh() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzi() throws RemoteException {
        return this.zzc.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzj() throws RemoteException {
        return this.zzc.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzk() throws RemoteException {
        return this.zzc.zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzl() throws RemoteException {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzm() throws RemoteException {
        return this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final String zzn() throws RemoteException {
        return this.zzc.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final List zzo() throws RemoteException {
        return this.zzc.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final void zzp() throws RemoteException {
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final void zzq(Bundle bundle) throws RemoteException {
        this.zzb.zzG(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzL(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zzY(bundle);
    }
}
