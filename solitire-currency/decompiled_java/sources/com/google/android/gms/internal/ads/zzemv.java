package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzemv {
    private final zzena zza;
    private final String zzb;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzdn zzc;

    public zzemv(zzena zzenaVar, String str) {
        this.zza = zzenaVar;
        this.zzb = str;
    }

    @Nullable
    public final synchronized String zza() {
        com.google.android.gms.ads.internal.client.zzdn zzdnVar;
        try {
            zzdnVar = this.zzc;
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
            return null;
        }
        return zzdnVar != null ? zzdnVar.zzg() : null;
    }

    @Nullable
    public final synchronized String zzb() {
        com.google.android.gms.ads.internal.client.zzdn zzdnVar;
        try {
            zzdnVar = this.zzc;
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#007 Could not call remote method.", e10);
            return null;
        }
        return zzdnVar != null ? zzdnVar.zzg() : null;
    }

    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zzl zzlVar, int i10) throws RemoteException {
        this.zzc = null;
        zzenb zzenbVar = new zzenb(i10);
        zzemu zzemuVar = new zzemu(this);
        this.zza.zzb(zzlVar, this.zzb, zzenbVar, zzemuVar);
    }

    public final synchronized boolean zze() throws RemoteException {
        return this.zza.zza();
    }
}
