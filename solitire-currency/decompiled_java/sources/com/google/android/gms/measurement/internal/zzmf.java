package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzmj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzmf<T extends Context & zzmj> {
    private final T zza;

    public zzmf(T t10) {
        Preconditions.checkNotNull(t10);
        this.zza = t10;
    }

    private final zzgb zzc() {
        return zzho.zza(this.zza, null, null).zzj();
    }

    @MainThread
    public final int zza(final Intent intent, int i10, final int i11) {
        final zzgb zzgbVarZzj = zzho.zza(this.zza, null, null).zzj();
        if (intent == null) {
            zzgbVarZzj.zzu().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzgbVarZzj.zzp().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmh
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(i11, zzgbVarZzj, intent);
                }
            });
        }
        return 2;
    }

    @MainThread
    public final void zzb() {
        zzho.zza(this.zza, null, null).zzj().zzp().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final boolean zzc(Intent intent) {
        if (intent == null) {
            zzc().zzg().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzp().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @MainThread
    public final void zzb(Intent intent) {
        if (intent == null) {
            zzc().zzg().zza("onRebind called with null intent");
        } else {
            zzc().zzp().zza("onRebind called. action", intent.getAction());
        }
    }

    @MainThread
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzg().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzhs(zznd.zza(this.zza));
        }
        zzc().zzu().zza("onBind received unknown action", action);
        return null;
    }

    final /* synthetic */ void zza(int i10, zzgb zzgbVar, Intent intent) {
        if (this.zza.zza(i10)) {
            zzgbVar.zzp().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            zzc().zzp().zza("Completed wakeful intent.");
            this.zza.zza(intent);
        }
    }

    final /* synthetic */ void zza(zzgb zzgbVar, JobParameters jobParameters) {
        zzgbVar.zzp().zza("AppMeasurementJobService processed last upload request.");
        this.zza.zza(jobParameters, false);
    }

    @MainThread
    public final void zza() {
        zzho.zza(this.zza, null, null).zzj().zzp().zza("Local AppMeasurementService is starting up");
    }

    private final void zza(Runnable runnable) {
        zznd zzndVarZza = zznd.zza(this.zza);
        zzndVarZza.zzl().zzb(new zzmg(this, zzndVarZza, runnable));
    }

    @TargetApi(24)
    @MainThread
    public final boolean zza(final JobParameters jobParameters) {
        final zzgb zzgbVarZzj = zzho.zza(this.zza, null, null).zzj();
        String string = jobParameters.getExtras().getString("action");
        zzgbVarZzj.zzp().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzme
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(zzgbVarZzj, jobParameters);
            }
        });
        return true;
    }
}
