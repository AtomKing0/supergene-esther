package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzse extends zzhb {

    @Nullable
    public final String zza;
    public final int zzb;

    public zzse(Throwable th, @Nullable zzsf zzsfVar) {
        super("Decoder failed: ".concat(String.valueOf(zzsfVar == null ? null : zzsfVar.zza)), th);
        int i10 = zzet.zza;
        boolean z10 = th instanceof MediaCodec.CodecException;
        String diagnosticInfo = z10 ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null;
        this.zza = diagnosticInfo;
        this.zzb = zzet.zza >= 23 ? z10 ? ((MediaCodec.CodecException) th).getErrorCode() : 0 : zzet.zzk(diagnosticInfo);
    }
}
