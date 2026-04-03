package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgnd {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzgnd(zzgmz zzgmzVar, zzgnc zzgncVar) {
        this.zza = new HashMap(zzgmzVar.zza);
        this.zzb = new HashMap(zzgmzVar.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzgnk) this.zzb.get(cls)).zza();
        }
        throw new GeneralSecurityException("No input primitive class for " + cls.toString() + " available");
    }

    public final Object zzb(zzgdy zzgdyVar, Class cls) throws GeneralSecurityException {
        zzgnb zzgnbVar = new zzgnb(zzgdyVar.getClass(), cls, null);
        if (this.zza.containsKey(zzgnbVar)) {
            return ((zzgmx) this.zza.get(zzgnbVar)).zza(zzgdyVar);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + zzgnbVar.toString() + " available");
    }

    public final Object zzc(zzgnj zzgnjVar, Class cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        zzgnk zzgnkVar = (zzgnk) this.zzb.get(cls);
        if (zzgnjVar.zzd().equals(zzgnkVar.zza()) && zzgnkVar.zza().equals(zzgnjVar.zzd())) {
            return zzgnkVar.zzc(zzgnjVar);
        }
        throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
    }
}
