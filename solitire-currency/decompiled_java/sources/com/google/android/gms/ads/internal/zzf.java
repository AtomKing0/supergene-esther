package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbne;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzdsk;
import com.google.android.gms.internal.ads.zzfjt;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.common.util.concurrent.m;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzf {
    private Context zza;
    private long zzb = 0;

    static final /* synthetic */ m zzd(Long l10, zzdsk zzdskVar, zzfki zzfkiVar, zzfju zzfjuVar, JSONObject jSONObject) throws Exception {
        boolean zOptBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (zOptBoolean) {
            zzu.zzo().zzi().zzv(jSONObject.getString("appSettingsJson"));
            if (l10 != null) {
                zzf(zzdskVar, "cld_s", zzu.zzB().elapsedRealtime() - l10.longValue());
            }
        }
        zzfjuVar.zzg(zOptBoolean);
        zzfkiVar.zzb(zzfjuVar.zzm());
        return zzgcj.zzh(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzf(zzdsk zzdskVar, String str, long j10) {
        if (zzdskVar != null) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzlI)).booleanValue()) {
                zzdsj zzdsjVarZza = zzdskVar.zza();
                zzdsjVarZza.zzb("action", "lat_init");
                zzdsjVarZza.zzb(str, Long.toString(j10));
                zzdsjVarZza.zzf();
            }
        }
    }

    public final void zza(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable Runnable runnable, zzfki zzfkiVar, @Nullable zzdsk zzdskVar, @Nullable Long l10) {
        zzb(context, versionInfoParcel, true, null, str, null, runnable, zzfkiVar, zzdskVar, l10);
    }

    @VisibleForTesting
    final void zzb(Context context, VersionInfoParcel versionInfoParcel, boolean z10, @Nullable zzbyy zzbyyVar, String str, @Nullable String str2, @Nullable Runnable runnable, final zzfki zzfkiVar, @Nullable final zzdsk zzdskVar, @Nullable final Long l10) {
        PackageInfo packageInfo;
        if (zzu.zzB().elapsedRealtime() - this.zzb < 5000) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzu.zzB().elapsedRealtime();
        if (zzbyyVar != null && !TextUtils.isEmpty(zzbyyVar.zzc())) {
            if (zzu.zzB().currentTimeMillis() - zzbyyVar.zza() <= ((Long) zzba.zzc().zza(zzbbw.zzdJ)).longValue() && zzbyyVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.zza = applicationContext;
        final zzfju zzfjuVarZza = zzfjt.zza(context, 4);
        zzfjuVarZza.zzi();
        zzbno zzbnoVarZza = zzu.zzf().zza(this.zza, versionInfoParcel, zzfkiVar);
        zzbni zzbniVar = zzbnl.zza;
        zzbne zzbneVarZza = zzbnoVarZza.zza("google.afma.config.fetchAppSettings", zzbniVar, zzbniVar);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ad_unit_id", str2);
            }
            jSONObject.put("is_init", z10);
            jSONObject.put("pn", context.getPackageName());
            zzbbn zzbbnVar = zzbbw.zza;
            jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zza().zza()));
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            try {
                ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                    jSONObject.put("version", packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
            }
            m mVarZzb = zzbneVarZza.zzb(jSONObject);
            zzgbq zzgbqVar = new zzgbq(this) { // from class: com.google.android.gms.ads.internal.zzd
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final m zza(Object obj) {
                    return zzf.zzd(l10, zzdskVar, zzfkiVar, zzfjuVarZza, (JSONObject) obj);
                }
            };
            zzgcu zzgcuVar = zzbzo.zzf;
            m mVarZzn = zzgcj.zzn(mVarZzb, zzgbqVar, zzgcuVar);
            if (runnable != null) {
                mVarZzb.addListener(runnable, zzgcuVar);
            }
            if (l10 != null) {
                mVarZzb.addListener(new Runnable(this) { // from class: com.google.android.gms.ads.internal.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzf.zzf(zzdskVar, "cld_r", zzu.zzB().elapsedRealtime() - l10.longValue());
                    }
                }, zzgcuVar);
            }
            if (((Boolean) zzba.zzc().zza(zzbbw.zzgT)).booleanValue()) {
                zzbzr.zzb(mVarZzn, "ConfigLoader.maybeFetchNewAppSettings");
            } else {
                zzbzr.zza(mVarZzn, "ConfigLoader.maybeFetchNewAppSettings");
            }
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error requesting application settings", e10);
            zzfjuVarZza.zzh(e10);
            zzfjuVarZza.zzg(false);
            zzfkiVar.zzb(zzfjuVarZza.zzm());
        }
    }

    public final void zzc(Context context, VersionInfoParcel versionInfoParcel, String str, zzbyy zzbyyVar, zzfki zzfkiVar) {
        zzb(context, versionInfoParcel, false, zzbyyVar, zzbyyVar != null ? zzbyyVar.zzb() : null, str, null, zzfkiVar, null, null);
    }
}
