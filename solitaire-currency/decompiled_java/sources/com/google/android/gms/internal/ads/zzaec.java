package com.google.android.gms.internal.ads;

import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaec implements zzadx {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaec(int i10, int i11, int i12, int i13) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
    }

    public static zzaec zzb(zzek zzekVar) {
        int iZzi = zzekVar.zzi();
        zzekVar.zzL(8);
        int iZzi2 = zzekVar.zzi();
        int iZzi3 = zzekVar.zzi();
        zzekVar.zzL(4);
        int iZzi4 = zzekVar.zzi();
        zzekVar.zzL(12);
        return new zzaec(iZzi, iZzi2, iZzi3, iZzi4);
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final int zza() {
        return AviExtractor.FOURCC_avih;
    }
}
