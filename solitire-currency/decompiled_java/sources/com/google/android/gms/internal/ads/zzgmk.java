package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgmk {
    private static final zzgmk zza = (zzgmk) zzgnz.zza(new zzgny() { // from class: com.google.android.gms.internal.ads.zzgmi
        @Override // com.google.android.gms.internal.ads.zzgny
        public final Object zza() throws GeneralSecurityException {
            zzgmk zzgmkVar = new zzgmk();
            zzgmkVar.zzg(new zzgld(zzglj.class, zzgnl.class, new zzgle() { // from class: com.google.android.gms.internal.ads.zzgmj
                @Override // com.google.android.gms.internal.ads.zzgle
                public final zzgnq zza(zzgdy zzgdyVar, zzger zzgerVar) {
                    return ((zzglj) zzgdyVar).zza(zzgerVar);
                }
            }));
            return zzgmkVar;
        }
    });
    private final AtomicReference zzb = new AtomicReference(new zzgnx(new zzgnr(), null));

    public static zzgmk zzc() {
        return zza;
    }

    public final zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) throws GeneralSecurityException {
        return ((zzgnx) this.zzb.get()).zza(zzgnqVar, zzgerVar);
    }

    public final zzgen zzb(zzgnq zzgnqVar) throws GeneralSecurityException {
        return ((zzgnx) this.zzb.get()).zzb(zzgnqVar);
    }

    public final zzgnq zzd(zzgdy zzgdyVar, Class cls, zzger zzgerVar) throws GeneralSecurityException {
        return ((zzgnx) this.zzb.get()).zzc(zzgdyVar, cls, zzgerVar);
    }

    public final zzgnq zze(zzgen zzgenVar, Class cls) throws GeneralSecurityException {
        return ((zzgnx) this.zzb.get()).zzd(zzgenVar, cls);
    }

    public final synchronized void zzf(zzglc zzglcVar) throws GeneralSecurityException {
        zzgnr zzgnrVar = new zzgnr((zzgnx) this.zzb.get());
        zzgnrVar.zza(zzglcVar);
        this.zzb.set(new zzgnx(zzgnrVar, null));
    }

    public final synchronized void zzg(zzglg zzglgVar) throws GeneralSecurityException {
        zzgnr zzgnrVar = new zzgnr((zzgnx) this.zzb.get());
        zzgnrVar.zzb(zzglgVar);
        this.zzb.set(new zzgnx(zzgnrVar, null));
    }

    public final synchronized void zzh(zzgmp zzgmpVar) throws GeneralSecurityException {
        zzgnr zzgnrVar = new zzgnr((zzgnx) this.zzb.get());
        zzgnrVar.zzc(zzgmpVar);
        this.zzb.set(new zzgnx(zzgnrVar, null));
    }

    public final synchronized void zzi(zzgmt zzgmtVar) throws GeneralSecurityException {
        zzgnr zzgnrVar = new zzgnr((zzgnx) this.zzb.get());
        zzgnrVar.zzd(zzgmtVar);
        this.zzb.set(new zzgnx(zzgnrVar, null));
    }

    public final boolean zzj(zzgnq zzgnqVar) {
        return ((zzgnx) this.zzb.get()).zzi(zzgnqVar);
    }

    public final boolean zzk(zzgnq zzgnqVar) {
        return ((zzgnx) this.zzb.get()).zzj(zzgnqVar);
    }
}
