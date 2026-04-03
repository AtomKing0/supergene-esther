package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import io.sentry.protocol.Browser;
import io.sentry.protocol.Device;
import io.sentry.protocol.OperatingSystem;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzevx implements zzevn {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final boolean zze;
    public final boolean zzf;
    public final String zzg;
    public final ArrayList zzh;
    public final String zzi;
    public final String zzj;
    public final String zzk;
    public final boolean zzl;
    public final String zzm;
    public final long zzn;
    public final boolean zzo;
    public final String zzp;
    public final int zzq;

    public zzevx(boolean z10, boolean z11, String str, boolean z12, boolean z13, boolean z14, String str2, ArrayList arrayList, String str3, String str4, String str5, boolean z15, String str6, long j10, boolean z16, String str7, int i10) {
        this.zza = z10;
        this.zzb = z11;
        this.zzc = str;
        this.zzd = z12;
        this.zze = z13;
        this.zzf = z14;
        this.zzg = str2;
        this.zzh = arrayList;
        this.zzi = str3;
        this.zzj = str4;
        this.zzk = str5;
        this.zzl = z15;
        this.zzm = str6;
        this.zzn = j10;
        this.zzo = z16;
        this.zzp = str7;
        this.zzq = i10;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("cog", this.zza);
        bundle.putBoolean("coh", this.zzb);
        bundle.putString("gl", this.zzc);
        bundle.putBoolean(Device.JsonKeys.SIMULATOR, this.zzd);
        bundle.putBoolean("is_latchsky", this.zze);
        bundle.putInt("build_api_level", this.zzq);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkd)).booleanValue()) {
            bundle.putBoolean("is_sidewinder", this.zzf);
        }
        bundle.putString("hl", this.zzg);
        if (!this.zzh.isEmpty()) {
            bundle.putStringArrayList("hl_list", this.zzh);
        }
        bundle.putString("mv", this.zzi);
        bundle.putString("submodel", this.zzm);
        Bundle bundleZza = zzffu.zza(bundle, "device");
        bundle.putBundle("device", bundleZza);
        bundleZza.putString(OperatingSystem.JsonKeys.BUILD, this.zzk);
        bundleZza.putLong("remaining_data_partition_space", this.zzn);
        Bundle bundleZza2 = zzffu.zza(bundleZza, Browser.TYPE);
        bundleZza.putBundle(Browser.TYPE, bundleZza2);
        bundleZza2.putBoolean("is_browser_custom_tabs_capable", this.zzl);
        if (!TextUtils.isEmpty(this.zzj)) {
            Bundle bundleZza3 = zzffu.zza(bundleZza, "play_store");
            bundleZza.putBundle("play_store", bundleZza3);
            bundleZza3.putString("package_version", this.zzj);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkv)).booleanValue()) {
            bundle.putBoolean("is_bstar", this.zzo);
        }
        if (!TextUtils.isEmpty(this.zzp)) {
            bundle.putString("v_unity", this.zzp);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzko)).booleanValue()) {
            zzffu.zzg(bundle, "gotmt_l", true, ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkl)).booleanValue());
            zzffu.zzg(bundle, "gotmt_i", true, ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkk)).booleanValue());
        }
    }
}
