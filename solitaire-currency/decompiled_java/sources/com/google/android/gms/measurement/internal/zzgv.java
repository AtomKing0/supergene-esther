package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgv {
    final zzho zza;

    zzgv(zznd zzndVar) {
        this.zza = zzndVar.zzk();
    }

    @VisibleForTesting
    @WorkerThread
    final Bundle zza(String str, com.google.android.gms.internal.measurement.zzby zzbyVar) {
        this.zza.zzl().zzt();
        if (zzbyVar == null) {
            this.zza.zzj().zzu().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(v8.h.V, str);
        try {
            Bundle bundleZza = zzbyVar.zza(bundle);
            if (bundleZza != null) {
                return bundleZza;
            }
            this.zza.zzj().zzg().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e10) {
            this.zza.zzj().zzg().zza("Exception occurred while retrieving the Install Referrer", e10.getMessage());
            return null;
        }
    }

    @VisibleForTesting
    final boolean zza() {
        try {
            PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(this.zza.zza());
            if (packageManagerWrapperPackageManager != null) {
                return packageManagerWrapperPackageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.zza.zzj().zzp().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e10) {
            this.zza.zzj().zzp().zza("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
