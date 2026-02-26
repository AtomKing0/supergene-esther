package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaze {
    final long zza;
    final String zzb;
    final int zzc;

    zzaze(long j10, String str, int i10) {
        this.zza = j10;
        this.zzb = str;
        this.zzc = i10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzaze)) {
            zzaze zzazeVar = (zzaze) obj;
            if (zzazeVar.zza == this.zza && zzazeVar.zzc == this.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
