package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(31)
final class zzps {
    @DoNotInline
    public static zzoq zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z10) {
        int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (playbackOffloadSupport == 0) {
            return zzoq.zza;
        }
        zzoo zzooVar = new zzoo();
        boolean z11 = false;
        if (zzet.zza > 32 && playbackOffloadSupport == 2) {
            z11 = true;
        }
        zzooVar.zza(true);
        zzooVar.zzb(z11);
        zzooVar.zzc(z10);
        return zzooVar.zzd();
    }
}
