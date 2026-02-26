package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.extractor.OpusUtil;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
final class zzob {
    @DoNotInline
    public static int zza(int i10, int i11, zzh zzhVar) {
        for (int i12 = 10; i12 > 0; i12--) {
            int iZzh = zzet.zzh(i12);
            if (iZzh != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i10).setSampleRate(i11).setChannelMask(iZzh).build(), zzhVar.zza().zza)) {
                return i12;
            }
        }
        return 0;
    }

    @DoNotInline
    public static zzfxr<Integer> zzb(zzh zzhVar) {
        zzfxo zzfxoVar = new zzfxo();
        zzfzx it = zzof.zzb.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (zzet.zza >= zzet.zzg(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(OpusUtil.SAMPLE_RATE).build(), zzhVar.zza().zza)) {
                zzfxoVar.zzf(Integer.valueOf(iIntValue));
            }
        }
        zzfxoVar.zzf((Object) 2);
        return zzfxoVar.zzi();
    }
}
