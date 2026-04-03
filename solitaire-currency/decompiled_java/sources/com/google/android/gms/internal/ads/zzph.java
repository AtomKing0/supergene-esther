package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzph extends Exception {
    public final int zza;
    public final boolean zzb;

    public zzph(int i10, int i11, int i12, int i13, zzaf zzafVar, boolean z10, @Nullable Exception exc) {
        String strValueOf = String.valueOf(zzafVar);
        StringBuilder sb = new StringBuilder();
        sb.append("AudioTrack init failed ");
        sb.append(i10);
        sb.append(" Config(");
        sb.append(i11);
        sb.append(", ");
        sb.append(i12);
        sb.append(", ");
        sb.append(i13);
        sb.append(") ");
        sb.append(strValueOf);
        sb.append(true != z10 ? "" : " (recoverable)");
        super(sb.toString(), exc);
        this.zza = i10;
        this.zzb = z10;
    }
}
