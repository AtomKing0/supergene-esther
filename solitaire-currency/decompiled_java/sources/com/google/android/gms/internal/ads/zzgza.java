package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgza implements zzgzh {
    private final zzgzh[] zza;

    zzgza(zzgzh... zzgzhVarArr) {
        this.zza = zzgzhVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final zzgzg zzb(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            zzgzh zzgzhVar = this.zza[i10];
            if (zzgzhVar.zzc(cls)) {
                return zzgzhVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final boolean zzc(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (this.zza[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
