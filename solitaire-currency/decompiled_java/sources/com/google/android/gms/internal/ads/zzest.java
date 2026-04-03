package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzest implements zzevo {
    private final Context zza;
    private final Intent zzb;

    zzest(Context context, Intent intent) {
        this.zza = context;
        this.zzb = intent;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 60;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlQ)).booleanValue()) {
            return zzgcj.zzh(new zzesu(null));
        }
        boolean z10 = false;
        try {
            if (this.zzb.resolveActivity(this.zza.getPackageManager()) != null) {
                z10 = true;
            }
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "HsdpMigrationSignal.isHsdpMigrationSupported");
        }
        return zzgcj.zzh(new zzesu(Boolean.valueOf(z10)));
    }
}
