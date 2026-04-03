package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzs extends zzmy {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzu> zzc;
    private Long zzd;
    private Long zze;

    zzs(zznd zzndVar) {
        super(zzndVar);
    }

    private final zzu zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:201:0x0625, code lost:
    
        r7 = zzj().zzu();
        r9 = com.google.android.gms.measurement.internal.zzgb.zza(r52.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0637, code lost:
    
        if (r8.zzi() == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0639, code lost:
    
        r8 = java.lang.Integer.valueOf(r8.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0642, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0643, code lost:
    
        r7.zza("Invalid property filter ID. appId, id", r9, java.lang.String.valueOf(r8));
        r8 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x02fd A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.List<com.google.android.gms.internal.measurement.zzft.zzc> zza(java.lang.String r53, java.util.List<com.google.android.gms.internal.measurement.zzft.zze> r54, java.util.List<com.google.android.gms.internal.measurement.zzft.zzn> r55, java.lang.Long r56, java.lang.Long r57) {
        /*
            Method dump skipped, instruction units count: 1794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzs.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    private final boolean zza(int i10, int i11) {
        zzu zzuVar = this.zzc.get(Integer.valueOf(i10));
        if (zzuVar == null) {
            return false;
        }
        return zzuVar.zzd.get(i11);
    }
}
