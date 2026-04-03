package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzeai implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzbzt zza = new zzbzt();

    @GuardedBy("this")
    protected boolean zzb = false;

    @GuardedBy("this")
    protected boolean zzc = false;

    @GuardedBy("this")
    protected zzbub zzd;
    protected Context zze;
    protected Looper zzf;
    protected ScheduledExecutorService zzg;

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        String str = String.format(Locale.US, "Remote ad service connection failed, cause: %d.", Integer.valueOf(connectionResult.getErrorCode()));
        com.google.android.gms.ads.internal.util.client.zzm.zze(str);
        this.zza.zzd(new zzdyp(1, str));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i10) {
        String str = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", Integer.valueOf(i10));
        com.google.android.gms.ads.internal.util.client.zzm.zze(str);
        this.zza.zzd(new zzdyp(1, str));
    }

    protected final synchronized void zzb() {
        if (this.zzd == null) {
            this.zzd = new zzbub(this.zze, this.zzf, this, this);
        }
        this.zzd.checkAvailabilityAndConnect();
    }

    protected final synchronized void zzc() {
        this.zzc = true;
        zzbub zzbubVar = this.zzd;
        if (zzbubVar == null) {
            return;
        }
        if (zzbubVar.isConnected() || this.zzd.isConnecting()) {
            this.zzd.disconnect();
        }
        Binder.flushPendingCommands();
    }
}
