package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
final class zzta implements zzsx {
    private final int zza;

    @Nullable
    private MediaCodecInfo[] zzb;

    public zzta(boolean z10, boolean z11) {
        int i10 = 1;
        if (!z10 && !z11) {
            i10 = 0;
        }
        this.zza = i10;
    }

    private final void zzf() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final int zza() {
        zzf();
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final MediaCodecInfo zzb(int i10) {
        zzf();
        return this.zzb[i10];
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zze() {
        return true;
    }
}
