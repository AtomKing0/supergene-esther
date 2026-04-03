package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.PlaybackException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
final class zzfoq implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    @VisibleForTesting
    protected final zzfpo zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzfoh zzf;
    private final long zzg;
    private final int zzh;

    public zzfoq(Context context, int i10, int i11, String str, String str2, String str3, zzfoh zzfohVar) {
        this.zzb = str;
        this.zzh = i11;
        this.zzc = str2;
        this.zzf = zzfohVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        this.zzg = System.currentTimeMillis();
        zzfpo zzfpoVar = new zzfpo(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfpoVar;
        this.zzd = new LinkedBlockingQueue();
        zzfpoVar.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    static zzfqa zza() {
        return new zzfqa(null, 1);
    }

    private final void zze(int i10, long j10, Exception exc) {
        this.zzf.zzc(i10, System.currentTimeMillis() - j10, exc);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfpt zzfptVarZzd = zzd();
        if (zzfptVarZzd != null) {
            try {
                zzfqa zzfqaVarZzf = zzfptVarZzd.zzf(new zzfpy(1, this.zzh, this.zzb, this.zzc));
                zze(IronSourceConstants.errorCode_internal, this.zzg, null);
                this.zzd.put(zzfqaVarZzf);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i10) {
        try {
            zze(4011, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfqa zzb(int i10) {
        zzfqa zzfqaVar;
        try {
            zzfqaVar = (zzfqa) this.zzd.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            zze(2009, this.zzg, e10);
            zzfqaVar = null;
        }
        zze(PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED, this.zzg, null);
        if (zzfqaVar != null) {
            if (zzfqaVar.zzc == 7) {
                zzfoh.zzg(3);
            } else {
                zzfoh.zzg(2);
            }
        }
        return zzfqaVar == null ? zza() : zzfqaVar;
    }

    public final void zzc() {
        zzfpo zzfpoVar = this.zza;
        if (zzfpoVar != null) {
            if (zzfpoVar.isConnected() || this.zza.isConnecting()) {
                this.zza.disconnect();
            }
        }
    }

    protected final zzfpt zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
