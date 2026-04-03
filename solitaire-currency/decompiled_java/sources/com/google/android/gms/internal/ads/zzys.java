package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"HandlerLeak"})
final class zzys extends Handler implements Runnable {
    final /* synthetic */ zzyx zza;
    private final zzyt zzb;
    private final long zzc;

    @Nullable
    private zzyp zzd;

    @Nullable
    private IOException zze;
    private int zzf;

    @Nullable
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzys(zzyx zzyxVar, Looper looper, zzyt zzytVar, zzyp zzypVar, int i10, long j10) {
        super(looper);
        this.zza = zzyxVar;
        this.zzb = zzytVar;
        this.zzd = zzypVar;
        this.zzc = j10;
    }

    private final void zzd() {
        this.zze = null;
        zzyx zzyxVar = this.zza;
        ExecutorService executorService = zzyxVar.zzc;
        zzys zzysVar = zzyxVar.zzd;
        zzysVar.getClass();
        executorService.execute(zzysVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        int i10 = message.what;
        if (i10 == 0) {
            zzd();
            return;
        }
        if (i10 == 3) {
            throw ((Error) message.obj);
        }
        this.zza.zzd = null;
        long j10 = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = jElapsedRealtime - j10;
        zzyp zzypVar = this.zzd;
        zzypVar.getClass();
        if (this.zzh) {
            zzypVar.zzJ(this.zzb, jElapsedRealtime, j11, false);
            return;
        }
        int i11 = message.what;
        if (i11 == 1) {
            try {
                zzypVar.zzK(this.zzb, jElapsedRealtime, j11);
                return;
            } catch (RuntimeException e10) {
                zzea.zzd("LoadTask", "Unexpected exception handling load completed", e10);
                this.zza.zze = new zzyw(e10);
                return;
            }
        }
        if (i11 != 2) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i12 = this.zzf + 1;
        this.zzf = i12;
        zzyr zzyrVarZzu = zzypVar.zzu(this.zzb, jElapsedRealtime, j11, iOException, i12);
        if (zzyrVarZzu.zza == 3) {
            this.zza.zze = this.zze;
        } else if (zzyrVarZzu.zza != 2) {
            if (zzyrVarZzu.zza == 1) {
                this.zzf = 1;
            }
            zzc(zzyrVarZzu.zzb != C.TIME_UNSET ? zzyrVarZzu.zzb : Math.min((this.zzf - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        try {
            synchronized (this) {
                z10 = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z10) {
                Trace.beginSection("load:" + this.zzb.getClass().getSimpleName());
                try {
                    this.zzb.zzh();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(1);
        } catch (IOException e10) {
            if (this.zzi) {
                return;
            }
            obtainMessage(2, e10).sendToTarget();
        } catch (OutOfMemoryError e11) {
            if (this.zzi) {
                return;
            }
            zzea.zzd("LoadTask", "OutOfMemory error loading stream", e11);
            obtainMessage(2, new zzyw(e11)).sendToTarget();
        } catch (Error e12) {
            if (!this.zzi) {
                zzea.zzd("LoadTask", "Unexpected error loading stream", e12);
                obtainMessage(3, e12).sendToTarget();
            }
            throw e12;
        } catch (Exception e13) {
            if (this.zzi) {
                return;
            }
            zzea.zzd("LoadTask", "Unexpected exception loading stream", e13);
            obtainMessage(2, new zzyw(e13)).sendToTarget();
        }
    }

    public final void zza(boolean z10) {
        this.zzi = z10;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z10) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z10) {
            this.zza.zzd = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzyp zzypVar = this.zzd;
            zzypVar.getClass();
            zzypVar.zzJ(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i10) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i10) {
            throw iOException;
        }
    }

    public final void zzc(long j10) {
        zzdi.zzf(this.zza.zzd == null);
        this.zza.zzd = this;
        if (j10 > 0) {
            sendEmptyMessageDelayed(0, j10);
        } else {
            zzd();
        }
    }
}
