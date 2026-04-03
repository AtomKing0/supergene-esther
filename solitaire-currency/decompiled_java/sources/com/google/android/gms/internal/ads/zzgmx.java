package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgmx {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgmx(Class cls, Class cls2, zzgmw zzgmwVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgmx zzb(zzgmv zzgmvVar, Class cls, Class cls2) {
        return new zzgmu(cls, cls2, zzgmvVar);
    }

    public abstract Object zza(zzgdy zzgdyVar) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
