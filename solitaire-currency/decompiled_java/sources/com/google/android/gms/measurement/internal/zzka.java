package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzka implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdi zza;
    private final /* synthetic */ zziy zzb;

    zzka(zziy zziyVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.zza = zzdiVar;
        this.zzb = zziyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zziy r0 = r7.zzb
            com.google.android.gms.measurement.internal.zzmi r0 = r0.zzp()
            boolean r1 = com.google.android.gms.internal.measurement.zzqj.zza()
            r2 = 0
            if (r1 == 0) goto L67
            com.google.android.gms.measurement.internal.zzae r1 = r0.zze()
            com.google.android.gms.measurement.internal.zzfo<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbh.zzby
            boolean r1 = r1.zza(r3)
            if (r1 == 0) goto L67
            com.google.android.gms.measurement.internal.zzgm r1 = r0.zzk()
            com.google.android.gms.measurement.internal.zziq r1 = r1.zzn()
            boolean r1 = r1.zzj()
            if (r1 != 0) goto L35
            com.google.android.gms.measurement.internal.zzgb r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzv()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
            r0.zza(r1)
            goto L74
        L35:
            com.google.android.gms.measurement.internal.zzgm r1 = r0.zzk()
            com.google.android.gms.common.util.Clock r3 = r0.zzb()
            long r3 = r3.currentTimeMillis()
            boolean r1 = r1.zza(r3)
            if (r1 != 0) goto L74
            com.google.android.gms.measurement.internal.zzgm r1 = r0.zzk()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzl
            long r3 = r1.zza()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L58
            goto L74
        L58:
            com.google.android.gms.measurement.internal.zzgm r0 = r0.zzk()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzl
            long r0 = r0.zza()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L75
        L67:
            com.google.android.gms.measurement.internal.zzgb r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzv()
            java.lang.String r1 = "getSessionId has been disabled."
            r0.zza(r1)
        L74:
            r0 = r2
        L75:
            if (r0 == 0) goto L89
            com.google.android.gms.measurement.internal.zziy r1 = r7.zzb
            com.google.android.gms.measurement.internal.zzho r1 = r1.zzu
            com.google.android.gms.measurement.internal.zznt r1 = r1.zzt()
            com.google.android.gms.internal.measurement.zzdi r2 = r7.zza
            long r3 = r0.longValue()
            r1.zza(r2, r3)
            return
        L89:
            com.google.android.gms.internal.measurement.zzdi r0 = r7.zza     // Catch: android.os.RemoteException -> L8f
            r0.zza(r2)     // Catch: android.os.RemoteException -> L8f
            return
        L8f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zziy r1 = r7.zzb
            com.google.android.gms.measurement.internal.zzho r1 = r1.zzu
            com.google.android.gms.measurement.internal.zzgb r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzg()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzka.run():void");
    }
}
