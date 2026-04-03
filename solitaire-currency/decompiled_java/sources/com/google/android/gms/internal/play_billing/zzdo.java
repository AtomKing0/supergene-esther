package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdo extends zzdq {
    private zzdo() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    final void zza(Object obj, long j10) {
        ((zzcz) zzfp.zzf(obj, j10)).zzb();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdq
    final void zzb(Object obj, Object obj2, long j10) {
        zzcz zzczVarZzd = (zzcz) zzfp.zzf(obj, j10);
        zzcz zzczVar = (zzcz) zzfp.zzf(obj2, j10);
        int size = zzczVarZzd.size();
        int size2 = zzczVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzczVarZzd.zzc()) {
                zzczVarZzd = zzczVarZzd.zzd(size2 + size);
            }
            zzczVarZzd.addAll(zzczVar);
        }
        if (size > 0) {
            zzczVar = zzczVarZzd;
        }
        zzfp.zzs(obj, j10, zzczVar);
    }

    /* synthetic */ zzdo(zzdn zzdnVar) {
        super(null);
    }
}
