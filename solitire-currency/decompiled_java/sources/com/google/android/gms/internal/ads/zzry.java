package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Trace;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzry implements zzsa {

    @Nullable
    private final Context zza;

    @Deprecated
    public zzry() {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzsa
    public final zzsc zzd(zzrz zzrzVar) throws Throwable {
        MediaCodec mediaCodecCreateByCodecName;
        Context context;
        int i10 = zzet.zza;
        if (i10 >= 23 && (i10 >= 31 || ((context = this.zza) != null && i10 >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen")))) {
            int iZzb = zzbn.zzb(zzrzVar.zzc.zzm);
            zzea.zze("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzet.zzC(iZzb)));
            zzro zzroVar = new zzro(iZzb);
            zzroVar.zze(true);
            return zzroVar.zzc(zzrzVar);
        }
        MediaCodec mediaCodec = null;
        try {
            String str = zzrzVar.zza.zza;
            Trace.beginSection("createCodec:".concat(str));
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
        } catch (IOException e10) {
            e = e10;
        } catch (RuntimeException e11) {
            e = e11;
        }
        try {
            Trace.beginSection("configureCodec");
            mediaCodecCreateByCodecName.configure(zzrzVar.zzb, zzrzVar.zzd, (MediaCrypto) null, 0);
            Trace.endSection();
            Trace.beginSection("startCodec");
            mediaCodecCreateByCodecName.start();
            Trace.endSection();
            return new zzte(mediaCodecCreateByCodecName, null);
        } catch (IOException | RuntimeException e12) {
            e = e12;
            mediaCodec = mediaCodecCreateByCodecName;
            if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e;
        }
    }

    public zzry(Context context) {
        this.zza = context;
    }
}
