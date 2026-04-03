package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayq {
    private final Object zza = new Object();
    private zzayo zzb = null;
    private boolean zzc = false;

    @Nullable
    public final Activity zza() {
        synchronized (this.zza) {
            zzayo zzayoVar = this.zzb;
            if (zzayoVar == null) {
                return null;
            }
            return zzayoVar.zza();
        }
    }

    @Nullable
    public final Context zzb() {
        synchronized (this.zza) {
            zzayo zzayoVar = this.zzb;
            if (zzayoVar == null) {
                return null;
            }
            return zzayoVar.zzb();
        }
    }

    public final void zzc(zzayp zzaypVar) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzayo();
            }
            this.zzb.zzf(zzaypVar);
        }
    }

    public final void zzd(Context context) {
        synchronized (this.zza) {
            if (!this.zzc) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Can not cast Context to Application");
                    return;
                }
                if (this.zzb == null) {
                    this.zzb = new zzayo();
                }
                this.zzb.zzg(application, context);
                this.zzc = true;
            }
        }
    }

    public final void zze(zzayp zzaypVar) {
        synchronized (this.zza) {
            zzayo zzayoVar = this.zzb;
            if (zzayoVar == null) {
                return;
            }
            zzayoVar.zzh(zzaypVar);
        }
    }
}
