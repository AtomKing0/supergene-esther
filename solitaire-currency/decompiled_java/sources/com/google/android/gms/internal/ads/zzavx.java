package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzavx implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzavy zza;

    zzavx(zzavy zzavyVar) {
        this.zza = zzavyVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i10, String str2, boolean z10) {
        if (z10) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzavy zzavyVar = this.zza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zzavyVar.zzc > 0) {
            zzavy zzavyVar2 = this.zza;
            if (jCurrentTimeMillis >= zzavyVar2.zzc) {
                zzavyVar2.zzd = jCurrentTimeMillis - zzavyVar2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
