package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdyg extends zzdya {
    private String zzg;
    private int zzh = 1;

    zzdyg(Context context) {
        this.zzf = new zzbty(context, com.google.android.gms.ads.internal.zzu.zzt().zzb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    try {
                        int i10 = this.zzh;
                        if (i10 == 2) {
                            this.zzf.zzp().zze(this.zze, new zzdxz(this));
                        } else if (i10 == 3) {
                            this.zzf.zzp().zzh(this.zzg, new zzdxz(this));
                        } else {
                            this.zza.zzd(new zzdyp(1));
                        }
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.zza.zzd(new zzdyp(1));
                    }
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
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
            int i10 = this.zzh;
            if (i10 != 1 && i10 != 2) {
                return zzgcj.zzg(new zzdyp(2));
            }
            if (this.zzc) {
                return this.zza;
            }
            this.zzh = 2;
            this.zzc = true;
            this.zze = zzbvbVar;
            this.zzf.checkAvailabilityAndConnect();
            this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdye
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            }, zzbzo.zzf);
            return this.zza;
        }
    }

    public final m zzd(String str) {
        synchronized (this.zzb) {
            int i10 = this.zzh;
            if (i10 != 1 && i10 != 3) {
                return zzgcj.zzg(new zzdyp(2));
            }
            if (this.zzc) {
                return this.zza;
            }
            this.zzh = 3;
            this.zzc = true;
            this.zzg = str;
            this.zzf.checkAvailabilityAndConnect();
            this.zza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyf
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            }, zzbzo.zzf);
            return this.zza;
        }
    }
}
