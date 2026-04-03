package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgzb implements zzhaf {
    private static final zzgzh zza = new zzgyz();
    private final zzgzh zzb;

    public zzgzb() {
        zzgzh zzgzhVar = zza;
        int i10 = zzgzt.zza;
        zzgza zzgzaVar = new zzgza(zzgxr.zza(), zzgzhVar);
        byte[] bArr = zzgyl.zzb;
        this.zzb = zzgzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhaf
    public final zzhae zza(Class cls) {
        int i10 = zzhag.zza;
        if (!zzgxy.class.isAssignableFrom(cls)) {
            int i11 = zzgzt.zza;
        }
        zzgzg zzgzgVarZzb = this.zzb.zzb(cls);
        if (zzgzgVarZzb.zzb()) {
            int i12 = zzgzt.zza;
            return zzgzn.zzc(zzhag.zzm(), zzgxl.zza(), zzgzgVarZzb.zza());
        }
        int i13 = zzgzt.zza;
        return zzgzm.zzm(cls, zzgzgVarZzb, zzgzq.zza(), zzgyx.zza(), zzhag.zzm(), zzgzgVarZzb.zzc() + (-1) != 1 ? zzgxl.zza() : null, zzgzf.zza());
    }
}
