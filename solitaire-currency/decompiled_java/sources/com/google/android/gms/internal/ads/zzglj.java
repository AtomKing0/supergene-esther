package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzglj extends zzgdy {
    private final zzgnl zza;

    public zzglj(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        zzc(zzgnlVar, zzgerVar);
        this.zza = zzgnlVar;
    }

    private static void zzc(zzgnl zzgnlVar, zzger zzgerVar) throws GeneralSecurityException {
        int i10 = zzgli.zzb[zzgnlVar.zzb().ordinal()];
    }

    public final zzgnl zza(zzger zzgerVar) throws GeneralSecurityException {
        zzc(this.zza, zzgerVar);
        return this.zza;
    }

    public final Integer zzb() {
        return this.zza.zzf();
    }
}
