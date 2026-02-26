package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzavn implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzavp zzb;

    zzavn(zzavp zzavpVar, int i10, boolean z10) {
        this.zza = i10;
        this.zzb = zzavpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzasj zzasjVarZza;
        int i10 = this.zza;
        zzavp zzavpVar = this.zzb;
        if (i10 > 0) {
            try {
                Thread.sleep(i10 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = zzavpVar.zza.getPackageManager().getPackageInfo(zzavpVar.zza.getPackageName(), 0);
            Context context = zzavpVar.zza;
            zzasjVarZza = zzfop.zza(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            zzasjVarZza = null;
        }
        this.zzb.zzm = zzasjVarZza;
        if (this.zza < 4) {
            if (zzasjVarZza != null && zzasjVarZza.zzaj() && !zzasjVarZza.zzh().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzasjVarZza.zzak() && zzasjVarZza.zzf().zze() && zzasjVarZza.zzf().zza() != -2) {
                return;
            }
            this.zzb.zzo(this.zza + 1, true);
        }
    }
}
