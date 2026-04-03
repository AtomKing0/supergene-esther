package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzglc {
    private final zzgvr zza;
    private final Class zzb;

    /* synthetic */ zzglc(zzgvr zzgvrVar, Class cls, zzglb zzglbVar) {
        this.zza = zzgvrVar;
        this.zzb = cls;
    }

    public static zzglc zzb(zzgla zzglaVar, zzgvr zzgvrVar, Class cls) {
        return new zzgkz(zzgvrVar, cls, zzglaVar);
    }

    public abstract zzgdy zza(zzgnq zzgnqVar, zzger zzgerVar) throws GeneralSecurityException;

    public final zzgvr zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
