package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
final class zzpy {
    @DoNotInline
    public static void zza(AudioTrack audioTrack, @Nullable zzon zzonVar) {
        audioTrack.setPreferredDevice(zzonVar == null ? null : zzonVar.zza);
    }
}
