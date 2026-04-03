package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfar extends com.google.android.gms.ads.internal.client.zzbt implements com.google.android.gms.ads.internal.overlay.zzp, zzazj {

    @Nullable
    protected zzcpe zza;
    private final zzcgj zzb;
    private final Context zzc;
    private final String zze;
    private final zzfal zzf;
    private final zzfaj zzg;
    private final VersionInfoParcel zzh;
    private final zzdsk zzi;

    @Nullable
    private zzcor zzk;
    private AtomicBoolean zzd = new AtomicBoolean();
    private long zzj = -1;

    public zzfar(zzcgj zzcgjVar, Context context, String str, zzfal zzfalVar, zzfaj zzfajVar, VersionInfoParcel versionInfoParcel, zzdsk zzdskVar) {
        this.zzb = zzcgjVar;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzfalVar;
        this.zzg = zzfajVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzdskVar;
        zzfajVar.zzm(this);
    }

    private final synchronized void zzq(int i10) {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzg.zzj();
            zzcor zzcorVar = this.zzk;
            if (zzcorVar != null) {
                com.google.android.gms.ads.internal.zzu.zzb().zze(zzcorVar);
            }
            if (this.zza != null) {
                long jElapsedRealtime = -1;
                if (this.zzj != -1) {
                    jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - this.zzj;
                }
                this.zza.zze(jElapsedRealtime, i10);
            }
            zzx();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzA() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzF(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzH(zzazs zzazsVar) {
        this.zzg.zzo(zzazsVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzI(com.google.android.gms.ads.internal.client.zzw zzwVar) {
        this.zzf.zzl(zzwVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzN(boolean z10) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzO(zzbcr zzbcrVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzU(com.google.android.gms.ads.internal.client.zzfk zzfkVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzX() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzY() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzZ() {
        return this.zzf.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzazj
    public final void zza() {
        zzq(3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzaa() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.google.android.gms.ads.internal.client.zzbu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean zzab(com.google.android.gms.ads.internal.client.zzl r6) throws android.os.RemoteException {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zzd     // Catch: java.lang.Throwable -> L87
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L87
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L87
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L87
            r1 = 0
            if (r0 == 0) goto L24
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzkl     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L87
            java.lang.Object r0 = r2.zza(r0)     // Catch: java.lang.Throwable -> L87
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L87
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = r1
        L25:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.zzh     // Catch: java.lang.Throwable -> L87
            int r2 = r2.clientJarVersion     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzkm     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L87
            java.lang.Object r3 = r4.zza(r3)     // Catch: java.lang.Throwable -> L87
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L87
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L87
            if (r2 < r3) goto L3d
            if (r0 != 0) goto L42
        L3d:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L87
        L42:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch: java.lang.Throwable -> L87
            android.content.Context r0 = r5.zzc     // Catch: java.lang.Throwable -> L87
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzH(r0)     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L64
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L52
            goto L64
        L52:
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r6)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzfaj r6 = r5.zzg     // Catch: java.lang.Throwable -> L87
            r0 = 4
            r2 = 0
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgi.zzd(r0, r2, r2)     // Catch: java.lang.Throwable -> L87
            r6.zzdB(r0)     // Catch: java.lang.Throwable -> L87
            monitor-exit(r5)
            return r1
        L64:
            boolean r0 = r5.zzZ()     // Catch: java.lang.Throwable -> L87
            if (r0 == 0) goto L6c
            monitor-exit(r5)
            return r1
        L6c:
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean     // Catch: java.lang.Throwable -> L87
            r0.<init>()     // Catch: java.lang.Throwable -> L87
            r5.zzd = r0     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzfap r0 = new com.google.android.gms.internal.ads.zzfap     // Catch: java.lang.Throwable -> L87
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzfal r1 = r5.zzf     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = r5.zze     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzfaq r3 = new com.google.android.gms.internal.ads.zzfaq     // Catch: java.lang.Throwable -> L87
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L87
            boolean r6 = r1.zzb(r6, r2, r0, r3)     // Catch: java.lang.Throwable -> L87
            monitor-exit(r5)
            return r6
        L87:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfar.zzab(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzac(com.google.android.gms.ads.internal.client.zzcf zzcfVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final Bundle zzd() {
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzdr() {
        if (this.zza != null) {
            this.zzj = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
            int iZza = this.zza.zza();
            if (iZza > 0) {
                zzcor zzcorVar = new zzcor(this.zzb.zzC(), com.google.android.gms.ads.internal.zzu.zzB());
                this.zzk = zzcorVar;
                zzcorVar.zzd(iZza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzfao
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzp();
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzdt() {
        zzcpe zzcpeVar = this.zza;
        if (zzcpeVar != null) {
            zzcpeVar.zze(com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - this.zzj, 1);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdu(int i10) {
        if (i10 == 0) {
            throw null;
        }
        int i11 = i10 - 1;
        if (i11 == 0) {
            zzq(2);
            return;
        }
        if (i11 == 1) {
            zzq(4);
        } else if (i11 != 2) {
            zzq(6);
        } else {
            zzq(3);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzq zzg() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzbh zzi() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzcb zzj() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzdn zzk() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzdq zzl() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzn() {
        return null;
    }

    final /* synthetic */ void zzo() {
        zzq(5);
    }

    @VisibleForTesting
    public final void zzp() {
        this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfan
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzr() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzs() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzt() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcpe zzcpeVar = this.zza;
        if (zzcpeVar != null) {
            zzcpeVar.zzb();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdH() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdk() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzdq() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzC(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzD(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzE(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzG(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(com.google.android.gms.ads.internal.client.zzci zzciVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzK(com.google.android.gms.ads.internal.client.zzdu zzduVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzL(boolean z10) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzM(zzbsw zzbswVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzR(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(zzbvt zzbvtVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzT(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(zzbsz zzbszVar, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(com.google.android.gms.ads.internal.client.zzl zzlVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
    }
}
