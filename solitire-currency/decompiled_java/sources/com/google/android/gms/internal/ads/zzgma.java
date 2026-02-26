package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgma {
    public static final /* synthetic */ int zza = 0;
    private static final zzglz zzb = new zzglz() { // from class: com.google.android.gms.internal.ads.zzgly
        @Override // com.google.android.gms.internal.ads.zzglz
        public final zzgdy zza(zzgen zzgenVar, Integer num) throws GeneralSecurityException {
            int i10 = zzgma.zza;
            zzgsz zzgszVarZzc = ((zzglk) zzgenVar).zzb().zzc();
            zzgdz zzgdzVarZzb = zzgky.zzc().zzb(zzgszVarZzc.zzi());
            if (!zzgky.zzc().zze(zzgszVarZzc.zzi())) {
                throw new GeneralSecurityException("Creating new keys is not allowed.");
            }
            zzgsv zzgsvVarZza = zzgdzVarZzb.zza(zzgszVarZzc.zzh());
            return new zzglj(zzgnl.zza(zzgsvVarZza.zzg(), zzgsvVarZza.zzf(), zzgsvVarZza.zzc(), zzgszVarZzc.zzg(), num), zzgdx.zza());
        }
    };
    private static final zzgma zzc = zze();
    private final Map zzd = new HashMap();

    public static zzgma zzb() {
        return zzc;
    }

    private final synchronized zzgdy zzd(zzgen zzgenVar, Integer num) throws GeneralSecurityException {
        zzglz zzglzVar;
        zzglzVar = (zzglz) this.zzd.get(zzgenVar.getClass());
        if (zzglzVar == null) {
            throw new GeneralSecurityException("Cannot create a new key for parameters " + zzgenVar.toString() + ": no key creator for this class was registered.");
        }
        return zzglzVar.zza(zzgenVar, num);
    }

    private static zzgma zze() {
        zzgma zzgmaVar = new zzgma();
        try {
            zzgmaVar.zzc(zzb, zzglk.class);
            return zzgmaVar;
        } catch (GeneralSecurityException e10) {
            throw new IllegalStateException("unexpected error.", e10);
        }
    }

    public final zzgdy zza(zzgen zzgenVar, Integer num) throws GeneralSecurityException {
        return zzd(zzgenVar, num);
    }

    public final synchronized void zzc(zzglz zzglzVar, Class cls) throws GeneralSecurityException {
        zzglz zzglzVar2 = (zzglz) this.zzd.get(cls);
        if (zzglzVar2 != null && !zzglzVar2.equals(zzglzVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class " + cls.toString() + " already inserted");
        }
        this.zzd.put(cls, zzglzVar);
    }
}
