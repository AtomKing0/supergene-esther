package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzsk extends Exception {

    @Nullable
    public final String zza;
    public final boolean zzb;

    @Nullable
    public final zzsf zzc;

    @Nullable
    public final String zzd;

    public zzsk(zzaf zzafVar, @Nullable Throwable th, boolean z10, int i10) {
        this("Decoder init failed: [" + i10 + "], " + zzafVar.toString(), th, zzafVar.zzm, false, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i10), null);
    }

    static /* bridge */ /* synthetic */ zzsk zza(zzsk zzskVar, zzsk zzskVar2) {
        return new zzsk(zzskVar.getMessage(), zzskVar.getCause(), zzskVar.zza, false, zzskVar.zzc, zzskVar.zzd, zzskVar2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzsk(zzaf zzafVar, @Nullable Throwable th, boolean z10, zzsf zzsfVar) {
        String str = "Decoder init failed: " + zzsfVar.zza + ", " + zzafVar.toString();
        String str2 = zzafVar.zzm;
        int i10 = zzet.zza;
        this(str, th, str2, false, zzsfVar, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
    }

    private zzsk(@Nullable String str, @Nullable Throwable th, @Nullable String str2, boolean z10, @Nullable zzsf zzsfVar, @Nullable String str3, @Nullable zzsk zzskVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzsfVar;
        this.zzd = str3;
    }
}
