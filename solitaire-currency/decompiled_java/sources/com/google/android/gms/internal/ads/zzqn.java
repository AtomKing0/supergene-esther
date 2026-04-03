package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(29)
final class zzqn {
    final /* synthetic */ zzqp zza;
    private final Handler zzb = new Handler(Looper.myLooper());
    private final AudioTrack.StreamEventCallback zzc;

    public zzqn(zzqp zzqpVar) {
        this.zza = zzqpVar;
        this.zzc = new zzqm(this, zzqpVar);
    }

    @DoNotInline
    public void zza(AudioTrack audioTrack) {
        final Handler handler = this.zzb;
        Objects.requireNonNull(handler);
        audioTrack.registerStreamEventCallback(new Executor() { // from class: com.google.android.gms.internal.ads.zzql
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, this.zzc);
    }

    @DoNotInline
    public void zzb(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.zzc);
        this.zzb.removeCallbacksAndMessages(null);
    }
}
