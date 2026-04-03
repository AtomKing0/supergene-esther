package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfwy extends zzfwl {
    final /* synthetic */ zzfxa zza;
    private final Object zzb;
    private int zzc;

    zzfwy(zzfxa zzfxaVar, int i10) {
        this.zza = zzfxaVar;
        this.zzb = zzfxa.zzg(zzfxaVar, i10);
        this.zzc = i10;
    }

    private final void zza() {
        int i10 = this.zzc;
        if (i10 == -1 || i10 >= this.zza.size() || !zzfur.zza(this.zzb, zzfxa.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfwl, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfwl, java.util.Map.Entry
    public final Object getValue() {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.get(this.zzb);
        }
        zza();
        int i10 = this.zzc;
        if (i10 == -1) {
            return null;
        }
        return zzfxa.zzj(this.zza, i10);
    }

    @Override // com.google.android.gms.internal.ads.zzfwl, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.put(this.zzb, obj);
        }
        zza();
        int i10 = this.zzc;
        if (i10 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        zzfxa zzfxaVar = this.zza;
        Object objZzj = zzfxa.zzj(zzfxaVar, i10);
        zzfxa.zzn(zzfxaVar, this.zzc, obj);
        return objZzj;
    }
}
