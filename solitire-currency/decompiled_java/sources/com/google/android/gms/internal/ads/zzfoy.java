package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
final class zzfoy implements zzfoz {
    private static final zzasj zza;

    static {
        zzaro zzaroVarZza = zzasj.zza();
        zzaroVarZza.zzx(ExifInterface.LONGITUDE_EAST);
        zza = (zzasj) zzaroVarZza.zzbr();
    }

    zzfoy() {
    }

    @Override // com.google.android.gms.internal.ads.zzfoz
    public final zzasj zza() {
        return zza;
    }
}
