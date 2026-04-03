package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeug implements zzevo {
    private final String zza;
    private final String zzb;

    zzeug(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 31;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return zzgcj.zzh(new zzeuh(this.zza, this.zzb));
    }
}
