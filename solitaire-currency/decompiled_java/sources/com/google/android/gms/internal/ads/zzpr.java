package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
final class zzpr {
    @DoNotInline
    public static zzoq zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z10) {
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return zzoq.zza;
        }
        zzoo zzooVar = new zzoo();
        zzooVar.zza(true);
        zzooVar.zzc(z10);
        return zzooVar.zzd();
    }
}
