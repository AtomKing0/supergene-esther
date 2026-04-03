package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
final class zzc {
    @DoNotInline
    public static void zza(AudioAttributes.Builder builder, int i10) {
        builder.setAllowedCapturePolicy(i10);
    }
}
