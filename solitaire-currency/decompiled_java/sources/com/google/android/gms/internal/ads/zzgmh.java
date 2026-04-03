package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgmh {
    private static final zzgmh zza = new zzgmh();
    private final AtomicReference zzb = new AtomicReference(new zzgnd(new zzgmz(null), null));

    zzgmh() {
    }

    public static zzgmh zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzgnd) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzgdy zzgdyVar, Class cls) throws GeneralSecurityException {
        return ((zzgnd) this.zzb.get()).zzb(zzgdyVar, cls);
    }

    public final Object zzd(zzgnj zzgnjVar, Class cls) throws GeneralSecurityException {
        return ((zzgnd) this.zzb.get()).zzc(zzgnjVar, cls);
    }

    public final synchronized void zze(zzgmx zzgmxVar) throws GeneralSecurityException {
        zzgmz zzgmzVar = new zzgmz((zzgnd) this.zzb.get(), null);
        zzgmzVar.zza(zzgmxVar);
        this.zzb.set(new zzgnd(zzgmzVar, null));
    }

    public final synchronized void zzf(zzgnk zzgnkVar) throws GeneralSecurityException {
        zzgmz zzgmzVar = new zzgmz((zzgnd) this.zzb.get(), null);
        zzgmzVar.zzb(zzgnkVar);
        this.zzb.set(new zzgnd(zzgmzVar, null));
    }
}
