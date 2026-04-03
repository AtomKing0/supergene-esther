package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgeb {
    public static final zzgen zza(zzgen zzgenVar) throws GeneralSecurityException {
        return zzgenVar != null ? zzgenVar : zzget.zza(zzb(null).zzaV());
    }

    static final zzgsz zzb(zzgen zzgenVar) {
        try {
            return ((zzgnm) zzgmk.zzc().zze(null, zzgnm.class)).zzc();
        } catch (GeneralSecurityException e10) {
            throw new zzgnz("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e10);
        }
    }
}
