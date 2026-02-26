package com.google.android.gms.internal.ads;

import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaeh implements zzadx {
    public final String zza;

    private zzaeh(String str) {
        this.zza = str;
    }

    public static zzaeh zzb(zzek zzekVar) {
        return new zzaeh(zzekVar.zzA(zzekVar.zzb(), zzfuj.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final int zza() {
        return AviExtractor.FOURCC_strn;
    }
}
