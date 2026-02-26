package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeni implements zzevo {
    private final Context zza;

    zzeni(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcD)).booleanValue()) {
            return zzgcj.zzh(new zzenj(ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0));
        }
        return zzgcj.zzh(null);
    }
}
