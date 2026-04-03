package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzyx {
    public static final zzyr zza = new zzyr(2, C.TIME_UNSET, null);
    public static final zzyr zzb = new zzyr(3, C.TIME_UNSET, null);
    private final ExecutorService zzc = zzet.zzE("ExoPlayer:Loader:ProgressiveMediaPeriod");

    @Nullable
    private zzys zzd;

    @Nullable
    private IOException zze;

    public zzyx(String str) {
    }

    public static zzyr zzb(boolean z10, long j10) {
        return new zzyr(z10 ? 1 : 0, j10, null);
    }

    public final long zza(zzyt zzytVar, zzyp zzypVar, int i10) {
        Looper looperMyLooper = Looper.myLooper();
        zzdi.zzb(looperMyLooper);
        this.zze = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzys(this, looperMyLooper, zzytVar, zzypVar, i10, jElapsedRealtime).zzc(0L);
        return jElapsedRealtime;
    }

    public final void zzg() {
        zzys zzysVar = this.zzd;
        zzdi.zzb(zzysVar);
        zzysVar.zza(false);
    }

    public final void zzh() {
        this.zze = null;
    }

    public final void zzi(int i10) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null) {
            throw iOException;
        }
        zzys zzysVar = this.zzd;
        if (zzysVar != null) {
            zzysVar.zzb(i10);
        }
    }

    public final void zzj(@Nullable zzyu zzyuVar) {
        zzys zzysVar = this.zzd;
        if (zzysVar != null) {
            zzysVar.zza(true);
        }
        this.zzc.execute(new zzyv(zzyuVar));
        this.zzc.shutdown();
    }

    public final boolean zzk() {
        return this.zze != null;
    }

    public final boolean zzl() {
        return this.zzd != null;
    }
}
