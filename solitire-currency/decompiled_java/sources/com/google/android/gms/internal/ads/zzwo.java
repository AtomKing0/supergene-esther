package com.google.android.gms.internal.ads;

import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzwo {
    private final zzdj zza = zzdj.zza;

    protected final zzwp zza(zzcd zzcdVar, int[] iArr, int i10, zzyj zzyjVar, zzfxr zzfxrVar) {
        return new zzwp(zzcdVar, iArr, 0, zzyjVar, 10000L, 25000L, 25000L, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0.7f, 0.75f, zzfxrVar, this.zza);
    }
}
