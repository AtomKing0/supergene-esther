package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaip {
    public final zzaiw zza;
    public final zzaiz zzb;
    public final zzadp zzc;

    @Nullable
    public final zzadq zzd;
    public int zze;

    public zzaip(zzaiw zzaiwVar, zzaiz zzaizVar, zzadp zzadpVar) {
        this.zza = zzaiwVar;
        this.zzb = zzaizVar;
        this.zzc = zzadpVar;
        this.zzd = MimeTypes.AUDIO_TRUEHD.equals(zzaiwVar.zzf.zzm) ? new zzadq() : null;
    }
}
