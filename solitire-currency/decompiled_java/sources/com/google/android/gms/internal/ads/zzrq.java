package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
final class zzrq implements zzsc {
    private final MediaCodec zza;
    private final zzrw zzb;
    private final zzsd zzc;
    private boolean zzd;
    private int zze = 0;

    /* synthetic */ zzrq(MediaCodec mediaCodec, HandlerThread handlerThread, zzsd zzsdVar, zzrp zzrpVar) {
        this.zza = mediaCodec;
        this.zzb = new zzrw(handlerThread);
        this.zzc = zzsdVar;
    }

    static /* bridge */ /* synthetic */ void zzh(zzrq zzrqVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i10) {
        zzrqVar.zzb.zzf(zzrqVar.zza);
        Trace.beginSection("configureCodec");
        zzrqVar.zza.configure(mediaFormat, surface, (MediaCrypto) null, i10);
        Trace.endSection();
        zzrqVar.zzc.zzh();
        Trace.beginSection("startCodec");
        zzrqVar.zza.start();
        Trace.endSection();
        zzrqVar.zze = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzs(int i10, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i10 == 1) {
            sb.append("Audio");
        } else if (i10 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i10);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    @Nullable
    public final ByteBuffer zzf(int i10) {
        return this.zza.getInputBuffer(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    @Nullable
    public final ByteBuffer zzg(int i10) {
        return this.zza.getOutputBuffer(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzi() {
        this.zzc.zzb();
        this.zza.flush();
        this.zzb.zze();
        this.zza.start();
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzj(int i10, int i11, int i12, long j10, int i13) {
        this.zzc.zzd(i10, 0, i12, j10, i13);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzk(int i10, int i11, zzha zzhaVar, long j10, int i12) {
        this.zzc.zze(i10, 0, zzhaVar, j10, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzl() {
        try {
            if (this.zze == 1) {
                this.zzc.zzg();
                this.zzb.zzh();
            }
            this.zze = 2;
            if (this.zzd) {
                return;
            }
            this.zza.release();
            this.zzd = true;
        } catch (Throwable th) {
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzm(int i10, long j10) {
        this.zza.releaseOutputBuffer(i10, j10);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzn(int i10, boolean z10) {
        this.zza.releaseOutputBuffer(i10, false);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzp(Bundle bundle) {
        this.zzc.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzq(int i10) {
        this.zza.setVideoScalingMode(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final boolean zzr(zzsb zzsbVar) {
        this.zzb.zzg(zzsbVar);
        return true;
    }
}
