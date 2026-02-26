package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MimeTypes;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(32)
final class zzxm {
    private final Spatializer zza;
    private final boolean zzb;

    @Nullable
    private Handler zzc;

    @Nullable
    private Spatializer.OnSpatializerStateChangedListener zzd;

    private zzxm(Spatializer spatializer) {
        this.zza = spatializer;
        this.zzb = spatializer.getImmersiveAudioLevel() != 0;
    }

    @Nullable
    public static zzxm zza(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return new zzxm(audioManager.getSpatializer());
    }

    public final void zzb(zzxt zzxtVar, Looper looper) {
        if (this.zzd == null && this.zzc == null) {
            this.zzd = new zzxl(this, zzxtVar);
            final Handler handler = new Handler(looper);
            this.zzc = handler;
            Spatializer spatializer = this.zza;
            Objects.requireNonNull(handler);
            spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzxk
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, this.zzd);
        }
    }

    public final void zzc() {
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.zzd;
        if (onSpatializerStateChangedListener == null || this.zzc == null) {
            return;
        }
        this.zza.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
        Handler handler = this.zzc;
        int i10 = zzet.zza;
        handler.removeCallbacksAndMessages(null);
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean zzd(zzh zzhVar, zzaf zzafVar) {
        int iZzh = zzet.zzh((MimeTypes.AUDIO_E_AC3_JOC.equals(zzafVar.zzm) && zzafVar.zzz == 16) ? 12 : zzafVar.zzz);
        if (iZzh == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(iZzh);
        int i10 = zzafVar.zzA;
        if (i10 != -1) {
            channelMask.setSampleRate(i10);
        }
        return this.zza.canBeSpatialized(zzhVar.zza().zza, channelMask.build());
    }

    public final boolean zze() {
        return this.zza.isAvailable();
    }

    public final boolean zzf() {
        return this.zza.isEnabled();
    }

    public final boolean zzg() {
        return this.zzb;
    }
}
