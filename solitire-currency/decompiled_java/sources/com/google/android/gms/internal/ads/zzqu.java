package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzqu implements zzpi {
    final /* synthetic */ zzqv zza;

    /* synthetic */ zzqu(zzqv zzqvVar, zzqt zzqtVar) {
        this.zza = zzqvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zza(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }
}
