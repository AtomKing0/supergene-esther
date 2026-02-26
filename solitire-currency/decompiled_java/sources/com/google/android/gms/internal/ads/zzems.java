package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzems extends com.google.android.gms.ads.internal.client.zzbt {
    private final com.google.android.gms.ads.internal.client.zzq zza;
    private final Context zzb;
    private final zzfco zzc;
    private final String zzd;
    private final VersionInfoParcel zze;
    private final zzemk zzf;
    private final zzfdo zzg;
    private final zzauo zzh;
    private final zzdsk zzi;

    @Nullable
    private zzdfo zzj;
    private boolean zzk = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzav)).booleanValue();

    public zzems(Context context, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzfco zzfcoVar, zzemk zzemkVar, zzfdo zzfdoVar, VersionInfoParcel versionInfoParcel, zzauo zzauoVar, zzdsk zzdskVar) {
        this.zza = zzqVar;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzfcoVar;
        this.zzf = zzemkVar;
        this.zzg = zzfdoVar;
        this.zze = versionInfoParcel;
        this.zzh = zzauoVar;
        this.zzi = zzdskVar;
    }

    private final synchronized boolean zze() {
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar != null) {
            if (!zzdfoVar.zza()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar != null) {
            zzdfoVar.zzn().zzc(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzD(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzf.zzj(zzbhVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzE(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzG(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzf.zzm(zzcbVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(com.google.android.gms.ads.internal.client.zzci zzciVar) {
        this.zzf.zzn(zzciVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzL(boolean z10) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzk = z10;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzO(zzbcr zzbcrVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzi(zzbcrVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdgVar.zzf()) {
                this.zzi.zze();
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzf("Error in making CSI ping for reporting paid event callback", e10);
        }
        this.zzf.zzl(zzdgVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(zzbvt zzbvtVar) {
        this.zzg.zzm(zzbvtVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzW(IObjectWrapper iObjectWrapper) {
        if (this.zzj == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfgi.zzd(9, null, null));
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzct)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzX() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzj == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfgi.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzct)).booleanValue()) {
                this.zzh.zzc().zzn(new Throwable().getStackTrace());
            }
            this.zzj.zzc(this.zzk, null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzY() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzZ() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzaa() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zze();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.google.android.gms.ads.internal.client.zzbu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean zzab(com.google.android.gms.ads.internal.client.zzl r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zzi     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L8b
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L8b
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L8b
            r1 = 0
            if (r0 == 0) goto L24
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzkl     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r0 = r2.zza(r0)     // Catch: java.lang.Throwable -> L8b
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L8b
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = r1
        L25:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.zze     // Catch: java.lang.Throwable -> L8b
            int r2 = r2.clientJarVersion     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzkm     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r3 = r4.zza(r3)     // Catch: java.lang.Throwable -> L8b
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L8b
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L8b
            if (r2 < r3) goto L3d
            if (r0 != 0) goto L42
        L3d:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L8b
        L42:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch: java.lang.Throwable -> L8b
            android.content.Context r0 = r5.zzb     // Catch: java.lang.Throwable -> L8b
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzH(r0)     // Catch: java.lang.Throwable -> L8b
            r2 = 0
            if (r0 == 0) goto L64
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch: java.lang.Throwable -> L8b
            if (r0 != 0) goto L64
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r6)     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.zzemk r6 = r5.zzf     // Catch: java.lang.Throwable -> L8b
            if (r6 == 0) goto L89
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgi.zzd(r0, r2, r2)     // Catch: java.lang.Throwable -> L8b
            r6.zzdB(r0)     // Catch: java.lang.Throwable -> L8b
            goto L89
        L64:
            boolean r0 = r5.zze()     // Catch: java.lang.Throwable -> L8b
            if (r0 != 0) goto L89
            android.content.Context r0 = r5.zzb     // Catch: java.lang.Throwable -> L8b
            boolean r1 = r6.zzf     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.zzfgd.zza(r0, r1)     // Catch: java.lang.Throwable -> L8b
            r5.zzj = r2     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.zzfco r0 = r5.zzc     // Catch: java.lang.Throwable -> L8b
            java.lang.String r1 = r5.zzd     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.ads.internal.client.zzq r2 = r5.zza     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.zzfch r3 = new com.google.android.gms.internal.ads.zzfch     // Catch: java.lang.Throwable -> L8b
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.zzemr r2 = new com.google.android.gms.internal.ads.zzemr     // Catch: java.lang.Throwable -> L8b
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L8b
            boolean r6 = r0.zzb(r6, r1, r3, r2)     // Catch: java.lang.Throwable -> L8b
            monitor-exit(r5)
            return r6
        L89:
            monitor-exit(r5)
            return r1
        L8b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zzab(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzq zzg() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzbh zzi() {
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzcb zzj() {
        return this.zzf.zzi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    @Nullable
    public final synchronized com.google.android.gms.ads.internal.client.zzdn zzk() {
        zzdfo zzdfoVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgc)).booleanValue() && (zzdfoVar = this.zzj) != null) {
            return zzdfoVar.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzdq zzl() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzn() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzr() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    @Nullable
    public final synchronized String zzs() {
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar == null || zzdfoVar.zzm() == null) {
            return null;
        }
        return zzdfoVar.zzm().zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    @Nullable
    public final synchronized String zzt() {
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar == null || zzdfoVar.zzm() == null) {
            return null;
        }
        return zzdfoVar.zzm().zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar != null) {
            zzdfoVar.zzn().zza(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(com.google.android.gms.ads.internal.client.zzl zzlVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        this.zzf.zzk(zzbkVar);
        zzab(zzlVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar != null) {
            zzdfoVar.zzn().zzb(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzA() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzC(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzF(com.google.android.gms.ads.internal.client.zzq zzqVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzH(zzazs zzazsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzI(com.google.android.gms.ads.internal.client.zzw zzwVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzK(com.google.android.gms.ads.internal.client.zzdu zzduVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzM(zzbsw zzbswVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzN(boolean z10) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzR(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzT(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzU(com.google.android.gms.ads.internal.client.zzfk zzfkVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzac(com.google.android.gms.ads.internal.client.zzcf zzcfVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(zzbsz zzbszVar, String str) {
    }
}
