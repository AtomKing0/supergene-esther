package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpn implements zzgnk {
    private static final zzgpn zza = new zzgpn();
    private static final zzgmx zzb = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgpk
        @Override // com.google.android.gms.internal.ads.zzgmv
        public final Object zza(zzgdy zzgdyVar) {
            return zzgqh.zza((zzglj) zzgdyVar);
        }
    }, zzglj.class, zzgem.class);

    zzgpn() {
    }

    static void zzd() throws GeneralSecurityException {
        zzgmh.zza().zzf(zza);
        zzgmh.zza().zze(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zza() {
        return zzgem.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zzb() {
        return zzgem.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final /* synthetic */ Object zzc(zzgnj zzgnjVar) throws GeneralSecurityException {
        return new zzgpm(zzgnjVar, null);
    }
}
