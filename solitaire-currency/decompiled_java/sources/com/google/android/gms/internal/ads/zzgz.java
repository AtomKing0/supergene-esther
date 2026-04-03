package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(24)
final class zzgz {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    static /* bridge */ /* synthetic */ void zza(zzgz zzgzVar, int i10, int i11) {
        zzgzVar.zzb.set(i10, i11);
        zzgzVar.zza.setPattern(zzgzVar.zzb);
    }
}
