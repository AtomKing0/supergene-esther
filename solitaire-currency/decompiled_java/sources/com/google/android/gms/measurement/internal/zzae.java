package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpl;
import com.google.android.gms.internal.measurement.zzpm;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzae extends zzim {
    private Boolean zza;
    private String zzb;
    private zzag zzc;
    private Boolean zzd;

    zzae(zzho zzhoVar) {
        super(zzhoVar);
        this.zzc = new zzag() { // from class: com.google.android.gms.measurement.internal.zzah
            @Override // com.google.android.gms.measurement.internal.zzag
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    public static long zzh() {
        return zzbh.zzd.zza(null).longValue();
    }

    public static long zzm() {
        return zzbh.zzad.zza(null).longValue();
    }

    @VisibleForTesting
    private final Bundle zzz() {
        try {
            if (zza().getPackageManager() == null) {
                zzj().zzg().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(zza().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzj().zzg().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            zzj().zzg().zza("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    @WorkerThread
    public final double zza(String str, zzfo<Double> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).doubleValue();
        }
        String strZza = this.zzc.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).doubleValue();
        }
        try {
            return zzfoVar.zza(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).doubleValue();
        }
    }

    final int zzb(String str, boolean z10) {
        return Math.max(zza(str, z10), 256);
    }

    final int zzc() {
        return (zzpm.zza() && zze().zzf(null, zzbh.zzcd) && zzq().zza(231100000, true)) ? 35 : 0;
    }

    @WorkerThread
    final long zzd(String str) {
        return zzc(str, zzbh.zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    public final int zzg() {
        return zzq().zza(201500000, true) ? 100 : 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    public final String zzn() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzo() {
        return zza("debug.deferred.deeplink", "");
    }

    public final String zzp() {
        return this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final boolean zzu() {
        Boolean boolZzf = zzf("google_analytics_adid_collection_enabled");
        return boolZzf == null || boolZzf.booleanValue();
    }

    public final boolean zzv() {
        Boolean boolZzf = zzf("google_analytics_automatic_screen_reporting_enabled");
        return boolZzf == null || boolZzf.booleanValue();
    }

    public final boolean zzw() {
        Boolean boolZzf = zzf("firebase_analytics_collection_deactivated");
        return boolZzf != null && boolZzf.booleanValue();
    }

    @WorkerThread
    final boolean zzx() {
        if (this.zza == null) {
            Boolean boolZzf = zzf("app_measurement_lite");
            this.zza = boolZzf;
            if (boolZzf == null) {
                this.zza = Boolean.FALSE;
            }
        }
        return this.zza.booleanValue() || !this.zzu.zzag();
    }

    public final boolean zzy() {
        if (this.zzd == null) {
            synchronized (this) {
                if (this.zzd == null) {
                    ApplicationInfo applicationInfo = zza().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzd = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzd == null) {
                        this.zzd = Boolean.TRUE;
                        zzj().zzg().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzd.booleanValue();
    }

    public final int zzb(@Size(min = 1) String str) {
        return zza(str, zzbh.zzai, 25, 100);
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    public final zzip zze(String str) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzz = zzz();
        if (bundleZzz == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleZzz.get(str);
        }
        if (obj == null) {
            return zzip.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzip.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzip.DENIED;
        }
        if ("default".equals(obj)) {
            return zzip.DEFAULT;
        }
        zzj().zzu().zza("Invalid manifest metadata for", str);
        return zzip.UNINITIALIZED;
    }

    @VisibleForTesting
    final Boolean zzf(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzz = zzz();
        if (bundleZzz == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleZzz.containsKey(str)) {
            return Boolean.valueOf(bundleZzz.getBoolean(str));
        }
        return null;
    }

    @WorkerThread
    final String zzg(String str) {
        return zzd(str, zzbh.zzal);
    }

    public final void zzi(String str) {
        this.zzb = str;
    }

    @WorkerThread
    final boolean zzj(String str) {
        return zzf(str, zzbh.zzak);
    }

    public final boolean zzk(String str) {
        return "1".equals(this.zzc.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzl(String str) {
        return "1".equals(this.zzc.zza(str, "measurement.event_sampling_enabled"));
    }

    @WorkerThread
    public final int zzb(String str, zzfo<Integer> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).intValue();
        }
        String strZza = this.zzc.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).intValue();
        }
        try {
            return zzfoVar.zza(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).intValue();
        }
    }

    @WorkerThread
    public final String zzd(String str, zzfo<String> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null);
        }
        return zzfoVar.zza(this.zzc.zza(str, zzfoVar.zza()));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.List<java.lang.String> zzh(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzz()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.zzgb r4 = r3.zzj()
            com.google.android.gms.measurement.internal.zzgd r4 = r4.zzg()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.zza()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzgb r0 = r3.zzj()
            com.google.android.gms.measurement.internal.zzgd r0 = r0.zzg()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzae.zzh(java.lang.String):java.util.List");
    }

    @WorkerThread
    public final int zzc(@Size(min = 1) String str) {
        return zzb(str, zzbh.zzo);
    }

    @WorkerThread
    public final long zzc(String str, zzfo<Long> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).longValue();
        }
        String strZza = this.zzc.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).longValue();
        }
        try {
            return zzfoVar.zza(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).longValue();
        }
    }

    @WorkerThread
    public final boolean zzf(String str, zzfo<Boolean> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).booleanValue();
        }
        String strZza = this.zzc.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).booleanValue();
        }
        return zzfoVar.zza(Boolean.valueOf("1".equals(strZza))).booleanValue();
    }

    final int zza(@Size(min = 1) String str) {
        return zza(str, zzbh.zzah, 500, 2000);
    }

    final int zza(String str, boolean z10) {
        if (!zzpl.zza() || !zze().zzf(null, zzbh.zzcw)) {
            return 100;
        }
        if (z10) {
            return zza(str, zzbh.zzar, 100, 500);
        }
        return 500;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @WorkerThread
    public final int zza(String str, zzfo<Integer> zzfoVar, int i10, int i11) {
        return Math.max(Math.min(zzb(str, zzfoVar), i11), i10);
    }

    public final boolean zze(String str, zzfo<Boolean> zzfoVar) {
        return zzf(str, zzfoVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    private final String zza(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e10) {
            zzj().zzg().zza("Could not find SystemProperties class", e10);
            return str2;
        } catch (IllegalAccessException e11) {
            zzj().zzg().zza("Could not access SystemProperties.get()", e11);
            return str2;
        } catch (NoSuchMethodException e12) {
            zzj().zzg().zza("Could not find SystemProperties.get() method", e12);
            return str2;
        } catch (InvocationTargetException e13) {
            zzj().zzg().zza("SystemProperties.get() threw an exception", e13);
            return str2;
        }
    }

    final void zza(zzag zzagVar) {
        this.zzc = zzagVar;
    }

    public final boolean zza(zzfo<Boolean> zzfoVar) {
        return zzf(null, zzfoVar);
    }
}
