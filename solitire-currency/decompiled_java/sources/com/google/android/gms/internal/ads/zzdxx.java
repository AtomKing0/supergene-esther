package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdxx extends zzdya {
    private final Context zzg;
    private final Executor zzh;

    public zzdxx(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbty(context, com.google.android.gms.ads.internal.zzu.zzt().zzb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzg(this.zze, new zzdxz(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzdyp(1));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "RemoteAdRequestClientTask.onConnected");
                    this.zza.zzd(new zzdyp(1));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdya, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        com.google.android.gms.ads.internal.util.client.zzm.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzdyp(1));
    }

    public final m zza(zzbvb zzbvbVar) {
        synchronized (this.zzb) {
            if (this.zzc) {
                return this.zza;
            }
            this.zzc = true;
            this.zze = zzbvbVar;
            this.zzf.checkAvailabilityAndConnect();
            this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxw
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            }, zzbzo.zzf);
            zzdya.zzc(this.zzg, this.zza, this.zzh);
            return this.zza;
        }
    }
}
