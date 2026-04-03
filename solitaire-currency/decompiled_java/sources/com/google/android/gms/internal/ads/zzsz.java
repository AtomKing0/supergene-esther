package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzsz implements zzsx {
    private zzsz() {
        throw null;
    }

    /* synthetic */ zzsz(zzsy zzsyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final MediaCodecInfo zzb(int i10) {
        return MediaCodecList.getCodecInfoAt(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    @Override // com.google.android.gms.internal.ads.zzsx
    public final boolean zze() {
        return false;
    }
}
