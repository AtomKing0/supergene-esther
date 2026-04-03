package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@MainThread
@VisibleForTesting
final class zzkl implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zziy zza;

    zzkl(zziy zziyVar) {
        this.zza = zziyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void zza(com.google.android.gms.measurement.internal.zzkl r17, boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(com.google.android.gms.measurement.internal.zzkl, boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityCreated(android.app.Activity r9, android.os.Bundle r10) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zziy r0 = r8.zza     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            com.google.android.gms.measurement.internal.zzgb r0 = r0.zzj()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzp()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            java.lang.String r1 = "onActivityCreated"
            r0.zza(r1)     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            android.content.Intent r0 = r9.getIntent()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            if (r0 != 0) goto L1f
            com.google.android.gms.measurement.internal.zziy r0 = r8.zza
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r9, r10)
            return
        L1f:
            android.net.Uri r1 = r0.getData()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            if (r1 == 0) goto L2c
            boolean r2 = r1.isHierarchical()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            if (r2 == 0) goto L2c
            goto L44
        L2c:
            android.os.Bundle r1 = r0.getExtras()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            if (r1 == 0) goto L43
            java.lang.String r2 = "com.android.vending.referral_url"
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            if (r2 != 0) goto L43
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            goto L44
        L43:
            r1 = 0
        L44:
            r5 = r1
            if (r5 == 0) goto L85
            boolean r1 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            if (r1 != 0) goto L4e
            goto L85
        L4e:
            com.google.android.gms.measurement.internal.zziy r1 = r8.zza     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            r1.zzq()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            boolean r0 = com.google.android.gms.measurement.internal.zznt.zza(r0)     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            if (r0 == 0) goto L5c
            java.lang.String r0 = "gs"
            goto L5e
        L5c:
            java.lang.String r0 = "auto"
        L5e:
            r6 = r0
            java.lang.String r0 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            if (r10 != 0) goto L69
            r0 = 1
            goto L6a
        L69:
            r0 = 0
        L6a:
            r4 = r0
            com.google.android.gms.measurement.internal.zziy r0 = r8.zza     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            com.google.android.gms.measurement.internal.zzhh r0 = r0.zzl()     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            com.google.android.gms.measurement.internal.zzkk r1 = new com.google.android.gms.measurement.internal.zzkk     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            r2 = r1
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            r0.zzb(r1)     // Catch: java.lang.Throwable -> L8f java.lang.RuntimeException -> L91
            com.google.android.gms.measurement.internal.zziy r0 = r8.zza
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r9, r10)
            return
        L85:
            com.google.android.gms.measurement.internal.zziy r0 = r8.zza
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r9, r10)
            return
        L8f:
            r0 = move-exception
            goto Lab
        L91:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zziy r1 = r8.zza     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.measurement.internal.zzgb r1 = r1.zzj()     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzg()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r1.zza(r2, r0)     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.measurement.internal.zziy r0 = r8.zza
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzn()
            r0.zza(r9, r10)
            return
        Lab:
            com.google.android.gms.measurement.internal.zziy r1 = r8.zza
            com.google.android.gms.measurement.internal.zzkv r1 = r1.zzn()
            r1.zza(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzn().zza(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.zza.zzn().zzb(activity);
        zzmi zzmiVarZzp = this.zza.zzp();
        zzmiVarZzp.zzl().zzb(new zzmk(zzmiVarZzp, zzmiVarZzp.zzb().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityResumed(Activity activity) {
        zzmi zzmiVarZzp = this.zza.zzp();
        zzmiVarZzp.zzl().zzb(new zzml(zzmiVarZzp, zzmiVarZzp.zzb().elapsedRealtime()));
        this.zza.zzn().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzn().zzb(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
