package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzecp implements zzfjm {
    private final zzecd zza;
    private final zzech zzb;

    zzecp(zzecd zzecdVar, zzech zzechVar) {
        this.zza = zzecdVar;
        this.zzb = zzechVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzd(zzfjf zzfjfVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfB)).booleanValue() && zzfjf.RENDERER == zzfjfVar && this.zza.zzc() != 0) {
            this.zza.zzf(com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdD(zzfjf zzfjfVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfB)).booleanValue() && zzfjf.RENDERER == zzfjfVar && this.zza.zzc() != 0) {
            this.zza.zzf(com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdE(zzfjf zzfjfVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfB)).booleanValue()) {
            if (zzfjf.RENDERER == zzfjfVar) {
                this.zza.zzg(com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime());
                return;
            }
            if (zzfjf.PRELOADED_LOADER == zzfjfVar || zzfjf.SERVER_TRANSACTION == zzfjfVar) {
                this.zza.zzh(com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime());
                final zzech zzechVar = this.zzb;
                final long jZzd = this.zza.zzd();
                zzechVar.zza.zza(new zzfio() { // from class: com.google.android.gms.internal.ads.zzecg
                    @Override // com.google.android.gms.internal.ads.zzfio
                    public final Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzechVar.zzf()) {
                            return null;
                        }
                        long j10 = jZzd;
                        zzbbc.zzaf.zza.C0193zza c0193zzaZzn = zzbbc.zzaf.zza.zzn();
                        c0193zzaZzn.zzP(j10);
                        byte[] bArrZzaV = c0193zzaZzn.zzbr().zzaV();
                        zzeco.zzf(sQLiteDatabase, false, false);
                        zzeco.zzc(sQLiteDatabase, j10, bArrZzaV);
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdC(zzfjf zzfjfVar, String str) {
    }
}
