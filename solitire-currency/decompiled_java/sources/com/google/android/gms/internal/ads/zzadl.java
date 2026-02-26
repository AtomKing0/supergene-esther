package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadl implements zzadi {
    public zzadl(long j10) {
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j10) {
        zzadj zzadjVar = new zzadj(j10, 0L);
        return new zzadg(zzadjVar, zzadjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
