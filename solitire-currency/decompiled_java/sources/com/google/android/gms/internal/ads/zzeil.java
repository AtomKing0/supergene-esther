package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeil implements zzgcf {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfeo zzb;
    final /* synthetic */ zzfel zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzflh zze;
    final /* synthetic */ zzfex zzf;
    final /* synthetic */ zzein zzg;

    zzeil(zzein zzeinVar, long j10, zzfeo zzfeoVar, zzfel zzfelVar, String str, zzflh zzflhVar, zzfex zzfexVar) {
        this.zza = j10;
        this.zzb = zzfeoVar;
        this.zzc = zzfelVar;
        this.zzd = str;
        this.zze = zzflhVar;
        this.zzf = zzfexVar;
        this.zzg = zzeinVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[PHI: r7
      0x0061: PHI (r7v1 int) = (r7v0 int), (r7v3 int), (r7v3 int), (r7v3 int) binds: [B:16:0x002f, B:21:0x004a, B:23:0x004e, B:25:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgcf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.Throwable r17) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeil.zza(java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        long jElapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        synchronized (this.zzg) {
            zzein zzeinVar = this.zzg;
            if (zzeinVar.zze) {
                zzeinVar.zzb.zza(this.zzb, this.zzc, 0, null, jElapsedRealtime);
            }
            zzein zzeinVar2 = this.zzg;
            if (zzeinVar2.zzg) {
                return;
            }
            if (zzeinVar2.zzq(this.zzc)) {
                ((zzeim) this.zzg.zzd.get(this.zzc)).zzd = jElapsedRealtime;
            } else {
                LinkedHashMap linkedHashMap = this.zzg.zzd;
                zzfel zzfelVar = this.zzc;
                linkedHashMap.put(zzfelVar, new zzeim(this.zzd, zzfelVar.zzaf, 0, jElapsedRealtime, null));
            }
            this.zzg.zzf.zzg(this.zzc, jElapsedRealtime, null);
        }
    }
}
