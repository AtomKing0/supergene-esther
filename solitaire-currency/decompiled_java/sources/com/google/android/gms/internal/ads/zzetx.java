package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetx implements zzevo, zzevn {
    private final ApplicationInfo zza;

    @Nullable
    private final PackageInfo zzb;
    private final Context zzc;
    private final zzdsf zzd;

    zzetx(ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, Context context, zzdsf zzdsfVar) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
        this.zzc = context;
        this.zzd = zzdsfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 29;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return zzgcj.zzh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zza.packageName;
        PackageInfo packageInfo = this.zzb;
        Integer numValueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle.putString("pn", str);
        if (numValueOf != null) {
            bundle.putInt("vc", numValueOf.intValue());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbV)).booleanValue()) {
                this.zzd.zzc("vc", numValueOf.toString());
            }
        }
        PackageInfo packageInfo2 = this.zzb;
        String str2 = packageInfo2 != null ? packageInfo2.versionName : null;
        if (str2 != null) {
            bundle.putString("vnm", str2);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbV)).booleanValue()) {
                this.zzd.zzc("vn", str2);
            }
        }
        try {
            Context context = this.zzc;
            String str3 = this.zza.packageName;
            zzfru zzfruVar = com.google.android.gms.ads.internal.util.zzt.zza;
            bundle.putString(CmcdConfiguration.KEY_DEADLINE, String.valueOf(Wrappers.packageManager(context).getApplicationLabel(str3)));
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlN)).booleanValue()) {
                try {
                    InstallSourceInfo installSourceInfo = this.zzc.getPackageManager().getInstallSourceInfo(str);
                    if (installSourceInfo == null) {
                        return;
                    }
                    String installingPackageName = installSourceInfo.getInstallingPackageName();
                    if (TextUtils.isEmpty(installingPackageName)) {
                        com.google.android.gms.ads.internal.util.zze.zza("No installing package name found");
                    } else {
                        bundle.putString("ins_pn", installingPackageName);
                    }
                    String initiatingPackageName = installSourceInfo.getInitiatingPackageName();
                    if (TextUtils.isEmpty(initiatingPackageName)) {
                        com.google.android.gms.ads.internal.util.zze.zza("No initiating package name found");
                    } else {
                        bundle.putString("ini_pn", initiatingPackageName);
                    }
                } catch (PackageManager.NameNotFoundException e10) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "PackageInfoSignalsource.compose");
                }
            }
        }
    }
}
