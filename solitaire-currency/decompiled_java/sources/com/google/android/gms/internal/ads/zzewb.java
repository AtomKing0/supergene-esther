package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.ironsource.ad;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewb implements zzevn {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzewb(String str, int i10, int i11, int i12, boolean z10, int i13) {
        this.zza = str;
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = z10;
        this.zzf = i13;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzffu.zzf(bundle, ad.f11277y0, this.zza, !TextUtils.isEmpty(this.zza));
        int i10 = this.zzb;
        zzffu.zze(bundle, "cnt", i10, i10 != -2);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle bundleZza = zzffu.zza(bundle, "device");
        bundle.putBundle("device", bundleZza);
        Bundle bundleZza2 = zzffu.zza(bundleZza, "network");
        bundleZza.putBundle("network", bundleZza2);
        bundleZza2.putInt("active_network_state", this.zzf);
        bundleZza2.putBoolean("active_network_metered", this.zze);
    }
}
