package com.google.android.gms.internal.ads;

import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaed implements zzadx {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzaed(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.zza = i10;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = i14;
        this.zze = i15;
    }

    public static zzaed zzb(zzek zzekVar) {
        int iZzi = zzekVar.zzi();
        zzekVar.zzL(12);
        int iZzi2 = zzekVar.zzi();
        int iZzi3 = zzekVar.zzi();
        int iZzi4 = zzekVar.zzi();
        zzekVar.zzL(4);
        int iZzi5 = zzekVar.zzi();
        int iZzi6 = zzekVar.zzi();
        zzekVar.zzL(8);
        return new zzaed(iZzi, iZzi2, iZzi3, iZzi4, iZzi5, iZzi6);
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final int zza() {
        return AviExtractor.FOURCC_strh;
    }
}
