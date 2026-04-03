package com.google.android.gms.internal.ads;

import androidx.media3.extractor.ts.PsExtractor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaid implements zzaia {
    private final zzek zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzaid(zzahw zzahwVar) {
        zzek zzekVar = zzahwVar.zza;
        this.zza = zzekVar;
        zzekVar.zzK(12);
        this.zzc = zzekVar.zzp() & 255;
        this.zzb = zzekVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zza() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final int zzc() {
        int i10 = this.zzc;
        if (i10 == 8) {
            return this.zza.zzm();
        }
        if (i10 == 16) {
            return this.zza.zzq();
        }
        int i11 = this.zzd;
        this.zzd = i11 + 1;
        if (i11 % 2 != 0) {
            return this.zze & 15;
        }
        int iZzm = this.zza.zzm();
        this.zze = iZzm;
        return (iZzm & PsExtractor.VIDEO_STREAM_MASK) >> 4;
    }
}
