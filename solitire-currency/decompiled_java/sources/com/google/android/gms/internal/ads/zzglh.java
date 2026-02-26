package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzglh implements zzgdz {
    final String zza;
    final Class zzb;
    final zzgsu zzc;

    zzglh(String str, Class cls, zzgsu zzgsuVar, zzgzr zzgzrVar) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzgsuVar;
    }

    public static zzgdz zzd(String str, Class cls, zzgsu zzgsuVar, zzgzr zzgzrVar) {
        return new zzglh(str, cls, zzgsuVar, zzgzrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdz
    public final zzgsv zza(zzgwm zzgwmVar) throws GeneralSecurityException {
        zzgsy zzgsyVarZza = zzgsz.zza();
        zzgsyVarZza.zzb(this.zza);
        zzgsyVarZza.zzc(zzgwmVar);
        zzgsyVarZza.zza(zzgtz.RAW);
        zzgnq zzgnqVarZzd = zzgmk.zzc().zzd(zzgma.zzb().zza(zzgmk.zzc().zzb(zzgnm.zza((zzgsz) zzgsyVarZza.zzbr())), null), zzgnl.class, zzgdx.zza());
        zzgst zzgstVarZza = zzgsv.zza();
        zzgnl zzgnlVar = (zzgnl) zzgnqVarZzd;
        zzgstVarZza.zzb(zzgnlVar.zzg());
        zzgstVarZza.zzc(zzgnlVar.zze());
        zzgstVarZza.zza(zzgnlVar.zzb());
        return (zzgsv) zzgstVarZza.zzbr();
    }

    @Override // com.google.android.gms.internal.ads.zzgdz
    public final Class zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgdz
    public final Object zzc(zzgwm zzgwmVar) throws GeneralSecurityException {
        return zzgmh.zza().zzc(zzgmk.zzc().zza(zzgnl.zza(this.zza, zzgwmVar, this.zzc, zzgtz.RAW, null), zzgdx.zza()), this.zzb);
    }
}
